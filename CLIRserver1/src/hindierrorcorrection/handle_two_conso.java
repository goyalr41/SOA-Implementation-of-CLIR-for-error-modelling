/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hindierrorcorrection;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class handle_two_conso {
    int total_words_extracted_here;
    int index;
    public String s;
    int presence[];
    String[] words;
    int[] word_set_1;
    int[] word_set_2;
    String [] tokens1;
    String [] tokens2;
    String[] finl = new String[20000];
    
    handle_two_conso(String word, String[] set_words) {
        words = set_words;
//        words = new String[20000];
        word_set_1 = new int[10000];
        word_set_2 = new int[10000];
        s = word;
//      presence = new int[300];
        total_words_extracted_here = 0;
        presence = new int[20000];
    }
    
    void function (String[] extract_words, String[] set_words) throws IOException {
        words = set_words;
        char ch = s.charAt(0);
 //       System.out.println("first conso = " + ch);
        String filename = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\first_conso\\" + ch;
        FileInputStream fs= new FileInputStream(filename);
        DataInputStream in = new DataInputStream(fs);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
//        System.out.println("len of token1 = " + tokens1.length);
      // c = 0;
        String s1;
        if ((s1 = br.readLine()) != null) {
            tokens1 = s1.split(" ");
        }
//        System.out.println("len of token1 = " + tokens1.length);
        
        int i = 1;
        while ((i != s.length()) && !new bigram_table().is_consonant(s.charAt(i)))
                i++;
        
        ch = s.charAt(i);
   //     System.out.println("second conso = " + ch);
        filename = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\second_conso\\" + ch;
        fs= new FileInputStream(filename);
        in = new DataInputStream(fs);
        br = new BufferedReader(new InputStreamReader(in));
        
        if ((s1 = br.readLine()) != null) {
       //     System.out.println("bigram is -->" + s);
            tokens2 = s1.split(" ");
   //     System.out.println("size of arrary --> " + s.length());
        }
 //       System.out.println("len of token2 = " + tokens2.length);
        extract (extract_words);
    }
    
    boolean if_similar (char ch1, char ch2) {
       if (is_sustected_vowels (ch1) && is_sustected_vowels (ch2)) {
           int similar = similar_of (ch1);
           
           if (ch2 == similar) {
               return true;
           }
           else {
               return false;
           }
       } else {
           return false;
       }
   }
   
   boolean is_sustected_vowels (char ch) {
       if (ch == 2366 || ch == 2381 || ch == 2367 || ch == 2368 || ch == 2369 || ch == 2370 || ch == 2371 || ch == 2372 || ch == 2375 || ch == 2376 || ch == 2379 || ch == 2380 || ch == 2305 || ch == 2306) {
           return true;
       }
       else {
           return false;
       }
   }

    int similar_of(char ch) {
        if (ch == 2366)
            return 2381;
        else if (ch == 2381)
            return 2366;
        else if (ch == 2367)
            return 2368;
        else if (ch == 2368)
            return 2367;
        else if (ch == 2369)
            return 2370;
        else if (ch == 2370)
            return 2369;
        else if (ch == 2371)
            return 2372;
        else if (ch == 2372)
            return 2371;
        else if (ch == 2375)
            return 2376;
        else if (ch == 2376)
            return 2375;
        else if (ch == 2379)
            return 2380;
        else if (ch == 2380)
            return 2379;
        else if (ch == 2305)
            return 23806;
        else
            return 2305;
    }
    
    void extract (String[] extract_words) throws FileNotFoundException, IOException {
        int index1 = 0;
        int index2 = 0;
        if (tokens1 != null) {
            for (int i = 0; i < tokens1.length; i++) {
                presence[Integer.parseInt(tokens1[i])]++;
                word_set_1[index1++] = Integer.parseInt(tokens1[i]);
            }
        }
       // System.out.println("tokens = " + tokens2 + " dsdsds");
        if (tokens2 != null) {
            for (int i = 0; i < tokens2.length; i++) {
                presence[Integer.parseInt(tokens2[i])]++;
                word_set_2[index2++] = Integer.parseInt(tokens2[i]);
            }
        }
        
  //      System.out.println (" words from 1st conso and 2nd conso is being extracted ");
        String word;
        int cnt = 0;
  //      while ((word = br1.readLine()) != null) {
        for (int it = 0; it < index1; it++) {
            cnt = word_set_1[it];
            word  = words[cnt];
            int conso_pos = 0;
            int conso_no = 0;
            int i = 0;
                
 //           System.out.println(word.length());
            for (i = 0; i < word.length(); i++) {
                if (new bigram_table().is_consonant(word.charAt(i))) {
                    conso_pos = i;
                    conso_no++;
                }
            }
            
 //           System.out.println("2 - len of wrd = " + conso_no);
                
            if (presence[cnt] == 2) {
      //          System.out.println(word + " with 2 ");
                if (conso_no == 3) {
                 //   if (conso_pos == word.length() - 1) {
                  //      finl[total_words_extracted_here++] = word;
 //                       System.out.println("word with 2 match and 3 conso = " + word);
                        presence[cnt] = 5;
                        extract_words[total_words_extracted_here++] = word;
                   // }
                } else if (conso_no == 2) {
 //                   System.out.println("word with 2 match and 2 conso = " + word);
               //     finl[total_words_extracted_here++] = word;
                    presence[cnt] = 5;
                    extract_words[total_words_extracted_here++] = word;
                }
            } else if (presence[cnt] == 1) {
                if (conso_no == 2) {
               //     System.out.println(word + " with 1 ");
                    int flag = 1;
                    i = 1;
                    
                    if (s.charAt(0) != word.charAt(0)) {
                        int ii = 1;
                        
                        int count = 0;
                        while (ii != s.length() && ii != word.length()) {
                            if (s.charAt(ii) != word.charAt(ii)) {
                                count++;
                                if (new bigram_table().is_consonant(s.charAt(ii)) || new bigram_table().is_consonant(word.charAt(ii))) {
                                    flag = 0;
                                } else if (!if_similar (s.charAt(ii), word.charAt(ii))) {
                                    flag = 0;                                    
                                }
                            }
                            
                            if (count > 1) {
                                flag = 0;
                                
                                break;
                            }
                            
                            ii++;
                        }
                        
                        if (ii != s.length() || ii != word.length())
                            flag = 0;
                    } else {
                        int ii = 1;
                        
                        int count = 0;
                        while (ii != s.length() && ii != word.length()) {
                            if (s.charAt(ii) != word.charAt(ii)) {
                                count++;
                                if (new bigram_table().is_consonant(s.charAt(ii)) ^ new bigram_table().is_consonant(word.charAt(ii))) {
                                    flag = 0;
                                } else {
                                    if (!(new bigram_table().is_consonant(s.charAt(ii))) && !if_similar (s.charAt(ii), word.charAt(ii))) {
  //                                      System.out.println("word should be deletd is = " + word + "  " + s.charAt(ii) + " " + word.charAt(ii));
                                        flag = 0; 
                                    }
                                }
                            }
                            
                            if (count > 2) {
                                flag = 0;
                                
                                break;
                            }
                            
                            ii++;
                        }
                        
                        if (ii != s.length() || ii != word.length())
                            flag = 0;
                    }
                    
                    if (flag == 1) {
                   //     System.out.println("word is as  = " + word);
                    //    finl[total_words_extracted_here++] = word;
                        presence[cnt] = 5;
                        extract_words[total_words_extracted_here++] = word;
                    }
                   
                }
            }
        }
        
        for (int it = 0; it < index2; it++) {
            cnt = word_set_2[it];
            word  = words[cnt];
            int conso_pos = 0;
            int conso_no = 0;
            int i = 0;
                
            for (i = 0; i < word.length(); i++) {
                if (new bigram_table().is_consonant(word.charAt(i))) {
                    conso_pos = i;
                    conso_no++;
                }
            }
                
            if (presence[cnt] == 1) {
                if (conso_no == 2) {
                    int flag = 1;
                    i = 1;
                    
                    if (s.charAt(0) != word.charAt(0)) {
                        int ii = 1;
                        
                        int count = 0;
                        while (ii != s.length() && ii != word.length()) {
                            if (s.charAt(ii) != word.charAt(ii)) {
                                count++;
                                if (new bigram_table().is_consonant(s.charAt(ii)) || new bigram_table().is_consonant(word.charAt(ii))) {
                                    flag = 0;
                                } else if (!if_similar (s.charAt(ii), word.charAt(ii))) {
                                    flag = 0;                                    
                                }
                            }
                            
                            if (count > 1) {
                                flag = 0;
                                
                                break;
                            }
                            
                            ii++;
                        }
                        
                        if (ii != s.length() || ii != word.length())
                            flag = 0;
                    } else {
                        int ii = 1;
                        
                        int count = 0;
                        while (ii != s.length() && ii != word.length()) {
                            if (s.charAt(ii) != word.charAt(ii)) {
                                count++;
                                if (new bigram_table().is_consonant(s.charAt(ii)) ^ new bigram_table().is_consonant(word.charAt(ii))) {
                                    flag = 0;
                                } else {
                                    if (!(new bigram_table().is_consonant(s.charAt(ii))) && !if_similar (s.charAt(ii), word.charAt(ii))) {
    //                                    System.out.println("word should be deletd is = " + word + "  " + s.charAt(ii) + " " + word.charAt(ii));
                                        flag = 0; 
                                    }
                                }
                            }
                            
                            if (count > 2) {
                                flag = 0;
                                
                                break;
                            }
                            
                            ii++;
                        }
                        
                        if (ii != s.length() || ii != word.length())
                            flag = 0;
                    }
                    
                    if (flag == 1) {
                   //     System.out.println("word is as  = " + word);
                //        finl[total_words_extracted_here++] = word;
                        presence[cnt] = 5;
                        extract_words[total_words_extracted_here++] = word;
                    }  
                }
            }
        }
    }
    
    int get_no_of_words () {
        return total_words_extracted_here;
    }
}