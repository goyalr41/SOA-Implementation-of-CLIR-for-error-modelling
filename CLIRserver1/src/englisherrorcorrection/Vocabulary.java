package englisherrorcorrection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Vocabulary {
    public static HashMap <String,Set<String>> word_mat = new HashMap<String,Set<String>>();
    
     void matrix(String bigram,String word)
    {
        if(word_mat.containsKey(bigram)){
            Set<String> words = new HashSet<String>();
           words = word_mat.get(bigram);
            words.add(word);
        }else{
            Set<String> words = new HashSet<String>();
            words.add(word);
            word_mat.put(bigram,words);
        }
    }
     
     public void arrange(String line) {
         String x = "";
         for(int i = 0; i < line.length()-1; i++){
             x += line.charAt(i);
             x += line.charAt(i+1);
             matrix(x,line);
             x = "";
         }
         for(int i = 0; i < line.length()-2; i++){
             x += line.charAt(i);
             x += line.charAt(i+2);
             matrix(x,line);
             x = "";
         }
     }
     public void write_file() throws IOException
     {
         File file = new File("C:/Users/hp/workspace/CLIRserver1/src/englisherrorcorrection/bigramlist.txt");
        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);   
        
         for (Map.Entry<String, Set<String>> entry : word_mat.entrySet()) {
             //System.out.println("IN MAP ALLERGIES");
              String key = entry.getKey();
              Set<String> l= entry.getValue();
               
             Iterator it = l.iterator();
             out.write(key);
             
             while(it.hasNext()){
                 Object p = it.next();
                 String word = p.toString();
                 out.write(",");
                 out.write(word);
                 
             }
             out.write("\n");
             // System.out.println("bigram = " + key + " sizelist = " + l.size() + " : words  = " + l);
         }
          out.close();
     }
     
   /* public static void main(String[] args) throws FileNotFoundException, IOException {
        File inp_file = new File("C:/Users/hp/workspace/CLIRserver1/src/englisherrorcorrection/word_list_moby_crossword.flat.txt");
       
       //   File inp_file = new File("D:\\words.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(inp_file));
        String line;
        
        Vocabulary ob = new Vocabulary();
        while ((line = br.readLine()) != null) {
            ob.arrange(line);
        }
        ob.write_file();
        
        error_check obj = new error_check();
           File word_file = new File("D:\\xyz.txt");
           obj.fileread(word_file);
        
    }*/

   
}
