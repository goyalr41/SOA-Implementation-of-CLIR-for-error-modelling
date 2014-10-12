package hindierrorcorrection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hindi_error {
    static String[] words;
    
    public hindi_error() throws FileNotFoundException, IOException {
        words = new String[20000];
        make_array();    
    }
    
    //String word;

    public String fun(String word) throws FileNotFoundException, IOException{
        //word = a1.getText();  
            extract_all extract_ob = new extract_all();
        
            extract_ob.extract(word , words);
        edit_check ec = edit_check.getinstance();
        String ans = "";
        String s = ""; //= "       -- " + word + " -- " + "\n\n";
        
        int flag = 0;
        
        s += ec.edit_words[0];
       /* for (int i = 0; i < ec.j; i++) {
            if (ec.final_edit_dis[i] == ec.edit_cnt_min) {
          
                String ss = "";
                ss += ec.edit_words[i];
                
                if (flag++ == 0)
                    ans = ss;
               
                for (int j = ss.length(); j < 30; j++)
                    ss += " ";
                ss += ec.final_edit_dis[i] + "\n";
                
                s += ss;
            }
        }
        for (int i = 0; i < ec.j; i++) {
            if (ec.final_edit_dis[i] == ec.edit_cnt_min + 1) {
                String ss = "";
                ss += ec.edit_words[i];
                
                for (int j = ss.length(); j < 30; j++)
                    ss += " ";
                ss += ec.final_edit_dis[i] + "\n";
                
                s += ss;
            }
        }
        for (int i = 0; i < ec.j; i++) {
            if (ec.final_edit_dis[i] == ec.edit_cnt_min + 2) {
                String ss = "";
                ss += ec.edit_words[i];
                for (int j = ss.length(); j < 30; j++)
                    ss += " ";
                ss += ec.final_edit_dis[i] + "\n";
                
                s += ss;
            }
        }*/
        
        //String final_word = "";
       /* for(int i = 0;i < s.length(); i++)
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                break;
            }
            final_word += s;
        }*/
        System.out.println("String suggested " + s);
        return s;
    }
    
   /* void fn () throws IOException {
        String finl = "" + "\n";
        finl += word;
    //    BufferedWriter out = null;
        try (BufferedWriter out = new BufferedWriter(new FileWriter("F:\\miniproject\\src\\miniproject\\words1.txt", true))) {
                                    out.write(finl);
                                    out.close();
                                    }
        
        
    }*/
    public void make_array() throws FileNotFoundException, IOException {
        //System.out.println("hellooooooooooooo i am in input constuctor");
         String filename = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\no_of_words_scanned_for_bigram";
        FileInputStream fs= new FileInputStream(filename);
        DataInputStream in = new DataInputStream(fs);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String filename1 = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\words1.txt";
          FileInputStream fs1= new FileInputStream(filename1);
          DataInputStream in1 = new DataInputStream(fs1);
          BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
          
          String s1;
          int no_of_words_scanned = 0;
           while ((s1 = br.readLine()) != null) {
                    no_of_words_scanned = Integer.parseInt(s1);
           }
           
        words = new String[no_of_words_scanned + 1];
                
                int i = 1;
        while((s1 = br1.readLine()) != null) {
            words[i] = s1;
            i++;
        } 
        
    } 

}
