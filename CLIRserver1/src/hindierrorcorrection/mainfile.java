package hindierrorcorrection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class mainfile {

    /**
     * @param args the command line arguments
     */
    public String process (String s) throws FileNotFoundException, IOException {
          String filename = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\words1.txt";
          FileInputStream fs= new FileInputStream(filename);
          DataInputStream in = new DataInputStream(fs);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));


       //String s , ss;
          bigram_table table = new bigram_table ();
          table.create_bigrame();
          
          /*input inp = new input();
          inp.setVisible(true);*/
          hindi_error hob = new hindi_error();
             String replacing_word =  hob.fun(s);
             if(replacing_word == null) {
            	 System.out.println("Yes null");
             }
             return replacing_word;
    }
    
}