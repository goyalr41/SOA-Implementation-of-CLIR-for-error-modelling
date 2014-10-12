package hindierrorcorrection;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class edit_check {
    private static edit_check instance;
    public int j;
    public String[] edit_words = new String[15000];
    int[] final_edit_dis = new int[15000];
    public int edit_cnt_min;
    String[] similar = new String[15000];
    
/*    private edit_check() {
    }
  */  
    public static synchronized edit_check getinstance () {
        if (instance == null) {
            instance = new edit_check();
            
            return instance;
        } else {
            return instance;
        }
        
    }
    
    public String cal_edit(String[] extract_words , String s , int n) throws FileNotFoundException, IOException {
        fn ();
    //    System.out.println("bscjk from func");
        int[] edit_cnt = new int[n];
        String sss = "";
        Arrays.fill(edit_cnt, -1);
        int i , min;
      //  System.out.println("n = " + n);
 //       edit_distance ed = new edit_distance();
        edit_cnt_min = 100;
  //      System.out.println("inside ca_edit");
        for(i = 0 ; i < n ; i++) {
          //  System.out.println("extr_word is ---> " + extract_words[i]);
          //  edit_cnt[i] = ed.cal_distance(s , extract_words[i]);
            
      //      System.out.println("going in edit --> " + s + "   " + extract_words[i] + " i = " + i);
            edit_cnt[i] = new new_edit_distance(s, extract_words[i], similar).get_distance();
          //  if (extract_words[i] == "जमीन")
        //        System.out.println("edit on word = " + extract_words[i] + "   -->  edit = " + edit_cnt[i]);
            if(edit_cnt_min > edit_cnt[i]) {
                edit_cnt_min = edit_cnt[i];
            }
        }
//        System.out.println("after new_edit_distance");
        if (edit_cnt_min == 0) {
                min = 1;
            }
            else if (edit_cnt_min == 1) {
                min = 2;
            }
            else if (edit_cnt_min == 2) {
                min = 4;
            } else {
                min = edit_cnt_min + 1;
        }
        j = 0;
//        System.out.print("check111111");
    //    System.out.print("going fron extract_words -- > ");
  //      System.out.println("n---> " + n);
        for (i = 0; i < n; i++) {
            if (edit_cnt[i] != -1 && edit_cnt[i] <= min) {
                edit_words[j] = extract_words[i];
         //       System.out.println("eee " + edit_words[j] + "   j  = " + j + " extrct = " + extract_words[i] + " i = " + i);
                final_edit_dis[j++] = edit_cnt[i];
                
 //               System.out.println("word = " + extract_words[i] + "   -->  edit = " + edit_cnt[i]);
            }
        }
  
     // Testing Phase
   //    System.out.print("going to test_oputput");
   //     testing_output to = new testing_output();
     //  sss = to.get_output(edit_words , final_edit_dis , j);
  
    //    System.out.println("returning from test_output");
          return sss;
    }
    public void fn () throws FileNotFoundException, IOException {
 //      index_sim = 0;
     //   System.out.println("into funcion");
        String filename = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\similar_characters";
          FileInputStream fs= new FileInputStream(filename);
          DataInputStream in = new DataInputStream(fs);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          
          Arrays.fill(similar, "-");
          String s1;
          while ((s1 = br.readLine()) != null) {
           //   Sy      
              char ch = s1.charAt(0);
        //            System.out.println("word = " + s1);
          //          if (ch == 'स')
            //            System.out.println("ssss");
                    
                    similar[(int)(ch) - 2305] = s1;
                    
                    for (int ii = 0; ii < s1.length(); ii++) {
                        if (s1.charAt(ii) == ' ')
                            System.out.println("**** incorrect file format of smilar_characters in spacing " + s1);
                    }
           }
    }
}
