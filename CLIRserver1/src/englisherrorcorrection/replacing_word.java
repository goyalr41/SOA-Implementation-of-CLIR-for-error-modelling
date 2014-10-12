package englisherrorcorrection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class replacing_word {
    Map<String,Integer> freqlist_map = new HashMap<String,Integer>();
    Map<String,Integer> sorted_freqlist_map = new HashMap<String,Integer>();
    Map<String,String> dis = new HashMap<String,String>();
    public String bestword() throws FileNotFoundException, IOException
    {
        int maxno = 2;
        Iterator it = edist.dist_sorted.keySet().iterator();
        int i = 0;
        int maxval = 0;
        String freq_word = null;
        for (Map.Entry<String, Integer> entry : edist.dist_sorted.entrySet()) {
              if(i == 0){
                  maxno = entry.getValue();
                  i = 1;
              }
              
              String key = entry.getKey();
              int dis = entry.getValue();
              
              //System.out.println("word == " + key + " dis == " + dis);
              if(dis > maxno){
                  break;
              }

             int freq = findfromfile(key);
             freqlist_map.put(key,freq);
             
             if(freq > maxval){
                 maxval = freq;
                 freq_word = key;
             }
        }
        error_check ob = new error_check();
        sorted_freqlist_map = (HashMap<String, Integer>) ob.desc_sortByValues(freqlist_map);
        return freq_word;
    }
    public Map<String,String> distances()
    {
        dis.clear();
        for (Map.Entry<String, Integer> entry : sorted_freqlist_map.entrySet()) {
              String key = entry.getKey();
              int dist = edist.words_dist.get(key);
              String d = dist + "";
             // System.out.println("word = " + key + " dist = " + dist);  
             dis.put(key,d);
         }
   //     System.out.println(dis);
        return dis;
    }
    public int findfromfile(String word) throws FileNotFoundException, IOException
    {
        File inp_file = new File("C:/Users/hp/workspace/CLIRserver1/src/englisherrorcorrection/en.txt");
        BufferedReader br = new BufferedReader(new FileReader(inp_file));
        String line;
        while ((line = br.readLine()) != null) {
               String[] values = line.split(" ");
               if(values[0].compareTo(word) == 0){
                   int freq = Integer.parseInt(values[1]);
                //  System.out.println("word = " + values[0] + " freq = " + freq);
                   return freq;
               }
        }
        return 2;
    }
}
