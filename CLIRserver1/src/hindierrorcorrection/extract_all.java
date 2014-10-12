package hindierrorcorrection;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class extract_all {
    public int c = 0;
    int index = 0;
    public int no_of_words_scanned;
    String[] extract_words = new String[100000];
    String[] edit_words = new String[100000];
    public String s , ss;
    edit_distance e = new edit_distance();
  
    public int get_word(int[] arr , String[] words , int c, int ind) throws FileNotFoundException, IOException {
        int i = 1 , j;
        int sub;
        sub = 0;
        j = ind;
 //       System.out.println("ind -->  " + ind);
                if (c > 2)
                    sub = c - 2;
                else sub = 1;
        while(i < words.length) {
   //         System.out.println("i --> "+ i);
                if(arr[i] >= sub) {
                    
            //        System.out.println(i + "   " + words[i]);
                    extract_words[j] = words[i];
            //        System.out.println(i + "   " + extract_words[j]);
                      j++;
                }
                i++;
        }
        return j;
    }
    
    public void get_line(int a , int b , int[] arr, int t) throws FileNotFoundException, IOException {
        int y , i , j , k;
        String s;
        
        String filename;
        FileInputStream fs;
        DataInputStream in;
        BufferedReader br = null;
        if(t == 0) {
            filename = "C:\\Users\\hp\\workspace\\CLIRserver1\\src\\hindierrorcorrection\\bigrams\\" + (char)(a) + " " + (char)(b) + ".txt";
            File f = new File(filename);
            
            if(!f.exists()){
            	return;
            }
            
            fs= new FileInputStream(filename);
            in = new DataInputStream(fs);
            br = new BufferedReader(new InputStreamReader(in));
        }
        if(t == 1) {
            filename = "C:\\Users\\hp\\workspace\\CLIRserver1\\src\\hindierrorcorrection\\bigrams\\" + (char)(a) + " " + (char)(b) + "_1.txt";
            fs= new FileInputStream(filename);
            in = new DataInputStream(fs);
            br = new BufferedReader(new InputStreamReader(in));
        }
        
        if ((s = br.readLine()) != null) {
            String [] tokens = s.split(" ");
            for(i = 3 ; i < tokens.length; i++) {
                j = Integer.parseInt(tokens[i]);
                if (t == 1) {
                    if (arr[j] == 0)
                        arr[j]++;
                } else arr[j]++;
        /*        if(j == 1) {
                    System.out.println("heloooooooooooooooooooo");
                }
          */     
                if (arr[j] > c) 
                    c = arr[j];
            
            }
        }
    }
    
    public String extract(String word , String[] words) throws FileNotFoundException, IOException {
        int l , i , j;
        l = word.length();
        String sss = "";
        
        i = 0;
        s = word;
                no_of_words_scanned = 0;
                String filename = "C:\\Users\\hp\\workspace\\CLIRserver1\\src\\hindierrorcorrection\\no_of_words_scanned_for_bigram";
                FileInputStream fs= new FileInputStream(filename);
                DataInputStream in = new DataInputStream(fs);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
                String s1;
                while ((s1 = br.readLine()) != null) {
                    no_of_words_scanned = Integer.parseInt(s1);
                }
                
        int[] arr = new int[no_of_words_scanned + 1];
        int a = 0;
        int b = 0;
        int k = -1;
        
        int no_conso = 0;
        
        char a1 = 0, a2 = 0;
        int ii = 0;
        for (i = 0; i < l; i++) {
            if (new bigram_table().is_consonant(word.charAt(i))) {
                if (ii == 0) {
                    a1 = word.charAt(i);
                    ii++;
                } else if (ii == 1) {
                    a2 = word.charAt(i);
                    ii++;
                }
                no_conso++;
            }
        }
        
        i = 0;
        
  //      int words_from_two_conso_check[] = new int[10000];
        if (no_conso == 2) {
            handle_two_conso ob = new handle_two_conso(word, words);
            ob.function(extract_words, words);
            
            index = ob.get_no_of_words();
    //        System.out.println("a1 = " + a1 + " a2  = " + a2);
            get_line((int)a1 , (int)a2 , arr , 1);
            index = get_word(arr , words , c, index);
            
        } else { 
            while(i < l) {
                if((int)word.charAt(i) >= 2309 && (int)word.charAt(i) <= 2361) {
                    j = i + 1;
                    while(j < l && ((int)word.charAt(j) < 2309 || (int)word.charAt(j) > 2361)) {
                        get_line((int)word.charAt(i) , (int)word.charAt(j) , arr, 0);
                        j++;
                    }
                    if(j < l) {
                        get_line((int)word.charAt(i) , (int)word.charAt(j) , arr, 0);
                        k++;
                        if(k == 0) {
                            a = i;
                        }
                        if(k == 1) {
                            b = j;
                        }
                    }
                    i = j;
                } else {
                    i++;
                }
  //          }
            
            if(k == 1) {
                get_line((int)word.charAt(a) , (int)word.charAt(b) , arr , 0);
   //             System.out.println("a --> " + a + " b --> " + b);
                get_line((int)word.charAt(a) , (int)word.charAt(b) , arr , 1);
            }
        //    System.out.println("goin into getwords");
            
        //    System.out.println("index  = " + index);
      //      System.out.println("goin into getw");
        }    
            index = get_word(arr , words , c, index);
    }
        
        edit_check ec = edit_check.getinstance();
        
        // Testing Phase 
 //         edit_check ec = new edit_check();
        
   //        System.out.println("going in edit check");
   //        System.out.println("");
  //    System.out.println("going to edit");
           sss = ec.cal_edit(extract_words, word , index);
    //       System.out.println("back from edit");
    return sss;
    
    }
}