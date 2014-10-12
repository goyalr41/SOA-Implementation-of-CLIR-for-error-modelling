package englisherrorcorrection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class edist {
    public static Map<String,Integer> words_dist = new HashMap<String,Integer>();
    public static Map<String,Integer> dist_sorted = new HashMap<String,Integer>();
    error_check obj = new error_check();
    
    public void bestmatch(String word)
    {
        words_dist.clear();
        dist_sorted.clear();
        for (Map.Entry<String, Integer> entry : error_check.sorted.entrySet()) {
              String key = entry.getKey();
              int dis = eDistance(word,key);
              
             /* if ( dis  > 3){
                  break;
              }*/
              
              words_dist.put(key,dis);
              //int f = entry.getValue();
         }
        
        dist_sorted = asc_sortByValues(words_dist);
        
        for (Map.Entry<String, Integer> entry : dist_sorted.entrySet()) {
             
              String key = entry.getKey();
              int f = entry.getValue();
              System.out.println("word = " + key + " dist = " + f);  
             
         }
    }
    public <K extends Comparable,V extends Comparable> Map<K,V> asc_sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
      
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
      
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
      
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
      
        return sortedMap;
    }
    
    public static int eDistance(String word1, String word2) {
	int len1 = word1.length();
	int len2 = word2.length();
 
	// len1+1, len2+1, because finally return dp[len1][len2]
	int[][] dp = new int[len1 + 1][len2 + 1];
 
	for (int i = 0; i <= len1; i++) {
		dp[i][0] = i;
	}
 
	for (int j = 0; j <= len2; j++) {
		dp[0][j] = j;
	}
 
	//iterate though, and check last char
	for (int i = 0; i < len1; i++) {
		char c1 = word1.charAt(i);
		for (int j = 0; j < len2; j++) {
			char c2 = word2.charAt(j);
 
			//if last two chars equal
			if (c1 == c2) {
				//update dp value for +1 length
				dp[i + 1][j + 1] = dp[i][j];
			} else {
				int replace = dp[i][j] + 1;
				int insert = dp[i][j + 1] + 1;
				int delete = dp[i + 1][j] + 1;
 
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[i + 1][j + 1] = min;
			}
		}
	}
 
	return dp[len1][len2];
    }
}
