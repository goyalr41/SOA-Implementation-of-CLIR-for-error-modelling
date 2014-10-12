/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hindierrorcorrection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author vissh_000
 */
public class bigram_table {
    public void create_bigrame () throws FileNotFoundException, IOException{
    
    int no_of_words_scanned = 0;
    String filename = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\no_of_words_scanned_for_bigram";
                FileInputStream fs= new FileInputStream(filename);
                DataInputStream in = new DataInputStream(fs);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                String s1;
                while ((s1 = br.readLine()) != null) {
                    no_of_words_scanned = Integer.parseInt(s1);
                }
                
    int temp = no_of_words_scanned;
    String filename1 = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\words1.txt";
                FileInputStream fs1= new FileInputStream(filename1);
                DataInputStream in1 = new DataInputStream(fs1);
                BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
                
                String s2;
                int i1 , i2;
                i1 = 0;
                i2 = 0;
                int check = 0;
                int cnt = 0;
                while ((s2 = br1.readLine()) != null) {
                    cnt++;
                    
                    if (temp-- <= 0) {
                        int no_conso = 0;
                        for (int i = 0; i < s2.length(); i++) {
                            if (is_consonant(s2.charAt(i)))
                                no_conso++;
                        }
                        
                        if (no_conso == 3 || no_conso == 2)
                            new new_two_conso_word (s2, cnt);
                        
                 //      /* 
                       int ii = 0; 
                       int jj;
                       check = 0;
                        
                        int i = 0;
                        i1 = 0;
                        i2 = 0;
                        while (i < s2.length() - 1) {
                            ii = i;
                            jj = i + 1;
 
                            while (jj < s2.length() && !is_consonant(s2.charAt(jj))) {
                                try {
                                    String finl = "";
                                    finl += String.valueOf(cnt) + " ";
                                    char ch1 = s2.charAt(ii);
                                    char ch2 = s2.charAt(jj);
                                    try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\bigrams\\" + ch1 + " " + ch2 + ".txt", true))) {
                                    out.write(finl);
                                    out.close();
                                    }
                                } catch (Exception e) {
                                    System.out.println("error");
                                }
                                
                                jj++;
                            }
                            
                            if (jj < s2.length()) {
                                if(check == 1) {
                                    i2 = jj;
                                }
                                check++;
                                
                                try {
                                    String finl = "";
                                    finl += String.valueOf(cnt) + " ";
                                    char ch1 = s2.charAt(ii);
                                    char ch2 = s2.charAt(jj);
                                    try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\bigrams\\" + ch1 + " " + ch2 + ".txt", true))) {
                                    out.write(finl);
                                    out.close();
                                    }
                                } catch (Exception e) {
                                    System.out.println("error");
                                }
                            }
                            
                            i = jj;
                        }
                      //  */
                    }
                    if(check == 2 || ((check == 1 && s2.length() == 3) && ((i2 - i1) == 2))) {
                        try {
                                    String finl = "";
                                    finl += String.valueOf(cnt) + " ";
                                    char ch1 = s2.charAt(i1);
                                    char ch2 = s2.charAt(i2);
                                    try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\bigrams\\" + ch1 + " " + ch2 + "_1.txt", true))) {
                                    out.write(finl);
                                    out.close();
                                    }
                                } catch (Exception e) {
                                    System.out.println("error");
                                }
                    }
                    
                }
                
                String finl1 = "";
                finl1 += String.valueOf(cnt);
                try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\no_of_words_scanned_for_bigram"))) {
                     out.write(finl1);
                     out.close();
                }
    }
    
    public boolean is_consonant (char i) {
        if ((int)i >= 2309 && (int)i <= 2361) {
            return true;
        }
        else {
            return false;
        }
    }
}