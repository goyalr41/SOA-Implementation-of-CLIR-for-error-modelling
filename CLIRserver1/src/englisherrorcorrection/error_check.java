package englisherrorcorrection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class error_check {
    File bigram_file = new File("C:/Users/hp/workspace/CLIRserver1/src/englisherrorcorrection/bigramlist.txt");
    
    public HashMap <String,Integer> mapfreq = new HashMap<String,Integer>();
    public static HashMap <String,Integer> sorted = new HashMap<String,Integer>();
   // public static String errorword;
    public boolean checkword(String word) throws FileNotFoundException, IOException
    {
                  //System.out.println(word);
        File word_file = new File("C:/Users/hp/workspace/CLIRserver1/src/englisherrorcorrection/word_list_moby_crossword.flat.txt");
        BufferedReader br = new BufferedReader(new FileReader(word_file));
        String line;
                 // System.out.println("check");
        while ((line = br.readLine()) != null) {
                     // System.out.println("word = " + line);
             if(word.compareTo(line) == 0)
             {
                      //     System.out.println("correct word");
                 return true;
             }
        }
        
        return false;
    }
    public int correct (String word) throws FileNotFoundException, IOException
    {
        List word_list = new ArrayList<String>();
        String x = "";
         for(int i = 0; i < word.length()-1; i++){
             x += word.charAt(i);
             x += word.charAt(i+1);
                      // System.out.println(x);
             Set l = retrievelist(x,word);
            if(l.size() > 0){
            	word_list.add(l);
            }
             // System.out.println("list = " + l);
         //    System.out.println("list  size = " + l.size());
             //word_list.add(l);
             x = "";
         }
            if(word_list.isEmpty()){
            	return 0;
            }else{
            	
            	freq_map(word_list);
            	return 1;
            }
             //System.out.println("list = " + word_list);
                 //System.out.println("listsize = " + word_list.size());
         
    }
    public Set<String> retrievelist(String bigram,String word) throws FileNotFoundException, IOException
    {
    	int l = word.length();
    	Set<String> a = new HashSet<String>();
    	a.clear();
        if(Vocabulary.word_mat.containsKey(bigram))
        {
              Set <String> x = new HashSet<String>();        
            Set<String> words = new HashSet<String>();
            //words = Vocabulary.word_mat.get(bigram);
            x = Vocabulary.word_mat.get(bigram);
            Iterator it = x.iterator();
            while(it.hasNext()){
            	Object ob = it.next();
            	String s = ob.toString();
            	int p = s.length();
            	
            	if( (l-2 <= p) && (p <= l+2)){
            		words.add(s);
            	}
            }
            return words;
        }
        return a;
    }
        
    public void freq_map(List word_list)
    {
        mapfreq.clear();
        sorted.clear();
        Iterator it = word_list.iterator();
        Iterator it1;
        while(it.hasNext()){
                 Object p = it.next();
               //  System.out.println(p);
                 Set l = (Set)p;
                 it1 = l.iterator();
                 
                 while(it1.hasNext()){
                    Object q = it1.next();
                   
                    String word = q.toString();
                    
                    if(mapfreq.containsKey(word)){
                        int freq = mapfreq.get(word);
                        freq++;
                        mapfreq.put(word, freq);
                    }else{
                        mapfreq.put(word,1);
                    }
                 
                }
        }
       /* for (Map.Entry<String, Integer> entry : mapfreq.entrySet()) {
             
              String key = entry.getKey();
              int f = entry.getValue();
              System.out.println("word = " + key + " freq = " + f);  
             
         }*/
        sorted = (HashMap<String, Integer>) desc_sortByValues(mapfreq);
                
       // System.out.println("Sorted Map");
        
       /* for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
             
              String key = entry.getKey();
              int f = entry.getValue();
              System.out.println("word = " + key + " freq = " + f);  
             
         }*/
    }
    public <K extends Comparable,V extends Comparable> Map<K,V> desc_sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
      
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
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
    public boolean isNumeric(String str)
    {
    	int l = str.length();
    	for(int i=0;i<l-1;i++){
    		if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
    			return true;
    		}
    	}
    	return false;
    }
    public void fileread(File inp_file) throws FileNotFoundException, IOException
    {
        File file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+inp_file.getName()+"ercor.txt");
        FileWriter fstream = new FileWriter(file);
        BufferedWriter out_write = new BufferedWriter(fstream);   
        
       edist ob = new edist();
       replacing_word obj = new replacing_word();
       
       Scanner sc1 = new Scanner(inp_file); 
         while(sc1.hasNextLine()) { 
                Scanner sc2 = new Scanner(sc1.nextLine()); 
                while(sc2.hasNext()) { 
                     String word = sc2.next();
                               System.out.println(word);
                     boolean check = checkword(word);
                     if(check == true)
                     {
                         System.out.println("correct word");
                         out_write.write(word);
                     }else{
                         String errorword = word;
                         correct(errorword);
                         ob.bestmatch(errorword);
                         String replaced_word = obj.bestword();
                         out_write.write(replaced_word);
                     }
                    out_write.write(" ");
                 } 
                    sc2.close(); 
         } 
         sc1.close();    
         out_write.close();
    }
      /* public static void main(String[] args) throws FileNotFoundException, IOException
       {
           
           error_check ob = new error_check();
           //File word_file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+inp_file.getName()+"ercor.txt");
           //ob.fileread(word_file);
           
       }*/
}
