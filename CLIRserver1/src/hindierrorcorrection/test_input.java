package hindierrorcorrection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test_input {
    String sss , ss1;
    int[][] cc = new int[3][10];
    int r1 , r2 , r3 , i1 , i2 , i3 , d1 , d2 , d3 , t , r4, r5 , d4 , d5 , i4 , i5;

    public void get_input(char c) throws FileNotFoundException, IOException {
        String filename = "F:\\miniproject\\src\\miniproject\\words1.txt";
          FileInputStream fs= new FileInputStream(filename);
          DataInputStream in = new DataInputStream(fs);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          
          int no_of_words_scanned = 0;
                String filenam1 = "F:\\miniproject\\src\\miniproject\\no_of_words_scanned_for_bigram";
                FileInputStream fs1= new FileInputStream(filenam1);
                DataInputStream in1 = new DataInputStream(fs1);
                BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
                
                String ss1;
                while ((ss1 = br1.readLine()) != null) {
                    no_of_words_scanned = Integer.parseInt(ss1);
                }
                
          String [] tokens;
        String[] words1 = new String[no_of_words_scanned + 1];
          String[] words2 = new String[no_of_words_scanned + 1];
          int k = 1 , i , j , l , no_conso = 0;
          
          for(i = 0 ; i < 3 ; i++) {
              for(j = 0 ; j < 10 ; j++) {
                  cc[i][j] = 0;
              }
          }
                  
          r1 = r2 = r3 = i1 = i2 = i3 = d1 = d2 = d3 = 0;
          String s , ss , filename1 , filename2 , filename3;
 //         System.out.println("new words are ---> ");
          while((s = br.readLine()) != null) {
         //     System.out.println("mine ----- ");
           //       for (int o = 0; o < s.length(); o++) {
             //                                   System.out.print("o = " + o + "-"+ s.charAt(o) + " ");
               //                             } 
              //    System.out.println();
              no_conso = 0;
              words1[k] = s;
              
              l = s.length();
              for (i = 0; i < l; i++) {
                    if (new bigram_table().is_consonant(s.charAt(i))) {
                        no_conso++;
                    }
               }
              ss = "";
         //     if(s.length() > 2) {
                  for(j = 0 ; j < s.length() ; j++) {
                      if(j == 1) {
     //                     System.out.println("rrrrrrrrrrrrrrr   " + s.charAt(j));
                          if(c == 'r') {
                            ss += (char)2349;
                          }
                          if(c == 'i') {
                              ss += (char)2349;
                              ss += s.charAt(j);
                          }
                      } else {
                          ss += s.charAt(j);
                      }
                      
                  }
                  
   //               System.out.println();
                  if(no_conso == 2)
                    words2[k] = s;
                  else words2[k] = ss;
 //             System.out.println(ss);
              k++;
          //} else {
             //     words2[k] = s;
               //   k++;
              //}
          }
  //        System.out.println(words1[0] + "   " + words2[0]);
  //        System.out.println(words1[3959] + "   " + words2[3959]);
  //        testing_output to = testing_output.getinstance();
          filename1 = "F:\\miniproject\\src\\miniproject\\testing_phase\\";
          filename2 = filename1;
          filename3 = filename2;
          if(c == 'r') {
              filename1 += "replace.txt";
              filename2 += "rn.txt";
              filename3 += "miss_replace.txt";
          }
          if(c == 'd') {
              filename1 += "delete.txt";
              filename2 += "dn.txt";
              filename3 += "miss_delete.txt";
          }
          if(c == 'i') {
              filename1 += "insert.txt";
              filename2 += "in.txt";
              filename3 += "miss_insert.txt";
          }
          System.out.println("===============================================================================");
          try (BufferedWriter out = new BufferedWriter(new FileWriter(filename1)) ; BufferedWriter out1 = new BufferedWriter(new FileWriter(filename2)) ; BufferedWriter out2 = new BufferedWriter(new FileWriter(filename3))) {
              for(i = 1 ; i < k ; i++) {
                  t = 0;
 //                 System.out.println(i + " ---> " + words1[i] + "   " + words2[i]);
                sss = words1[i] + " --> " + words2[i] + " --->  ";
                extract_all extract_ob = new extract_all();
     //             System.out.println("sending to extrcact");
                ss1 = extract_ob.extract(words2[i] , words1);
       //           System.out.println("beck from extract");
                sss += ss1;
                tokens = ss1.split("  ");
  //                System.out.println("comapring -->  " + tokens[0] + " ---> " + words1[i]);
                if(tokens.length >= 1 && tokens[0].equals(words1[i])) {
                    t = 1;
   //                 System.out.println("inside1");
                    if(c == 'r') {
                        r1 += 1;
                        r2 += 1;
                        r3 += 1;
                        r4 += 1;
                        r5 += 1;
                    } else if (c == 'd') {
                        d1 += 1;
                        d2 += 1;
                        d3 += 1;
                        d4 += 1;
                        d5 += 1;
                    } else {
                        i1 += 1;
                        i2 += 1;
                        i3 += 1;
                        i4 += 1;
                        i5 += 1;
                    }
                } else if (tokens.length >= 2 && tokens[1].equals(words1[i])) {
    //                System.out.println("inside2");
                    t = 1;
                    if(c == 'r') {
                        r2 += 1;
                        r3 += 1;
                        r4 += 1;
                        r5 += 1;
                    } else if (c == 'd') {
                        d2 += 1;
                        d3 += 1;
                        d4 += 1;
                        d5 += 1;
                    } else {
                        i2 += 1;
                        i3 += 1;
                        i4 += 1;
                        i5 += 1;
                    }
                } else if (tokens.length >= 3 && tokens[2].equals(words1[i])) {
   //                 System.out.println("inside3");
                    t = 1;
                    if(c == 'r') {
                        r3 += 1;
                        r4 += 1;
                        r5 += 1;
                    } else if (c == 'd') {
                        d3 += 1;
                        d4 += 1;
                        d5 += 1;
                    } else {
                        i3 += 1;
                        i4 += 1;
                        i5 += 1;
                    }
                } else if (tokens.length >= 4 && tokens[3].equals(words1[i])) {
   //                 System.out.println("inside3");
                    t = 1;
                    if(c == 'r') {
                        r4 += 1;
                        r5 += 1;
                    } else if (c == 'd') {
                        d4 += 1;
                        d5 += 1;
                    } else {
                        i4 += 1;
                        i5 += 1;
                    }
                } else if (tokens.length >= 5 && tokens[4].equals(words1[i])) {
   //                 System.out.println("inside3");
                    t = 1;
                    if(c == 'r') {
                        r5 += 1;
                    } else if (c == 'd') {
                        d5 += 1;
                    } else {
                        i5 += 1;
                    }
                }
   //               System.out.println("back ----- ");
 //                 System.out.println("cheching for word ---> " + words1[i]);
 //                 System.out.println("from to ---> " + to.sss);
  //              System.out.println("going back");
                if(t == 0) {
                    out2.write(i + " ---> " + words1[i] + "    " + words2[i] + '\n');
                }
                out.write(sss);
                out.write('\n');
    //              System.out.println();
              }
              String sn;
              sn = "";
 //             System.out.println("c == " + c);
              if(c =='r') {
 //                 System.out.println("in replace");
                  sn = "n == 1 --> " + String.valueOf(r1) + '\n' + "n == 2 --> " + String.valueOf(r2) + '\n' + "n == 3 --> " + String.valueOf(r3) + '\n' + "n == 4 --> " + String.valueOf(r4) + '\n' + "n == 5 --> " + String.valueOf(r5) + '\n';
              } else if (c == 'd') {
  //                System.out.println("in delete");
                  sn = "n == 1 --> " + String.valueOf(d1) + '\n' + "n == 2 --> " + String.valueOf(d2) + '\n' + "n == 3 --> " + String.valueOf(d3) + '\n' + "n == 4 --> " + String.valueOf(d4) + '\n' + "n == 5 --> " + String.valueOf(d5) + '\n';
              } else if (c == 'i') {
   //               System.out.println("in insert");
                  sn = "n == 1 --> " + String.valueOf(i1) + '\n' + "n == 2 --> " + String.valueOf(i2) + '\n' + "n == 3 --> " + String.valueOf(i3) + '\n' + "n == 4 --> " + String.valueOf(i4) + '\n' + "n == 5 --> " + String.valueOf(i5) + '\n';
              }
              out1.write(sn);
              out1.close();
              out.close();
          } catch (Exception e) {
              System.out.println(e.toString());
              System.out.println("i am here 1");
              System.out.println("error");
          }
          
    }
    
}
