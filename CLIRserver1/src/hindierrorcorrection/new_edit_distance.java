/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hindierrorcorrection;

public class new_edit_distance extends bigram_table {
    String s1;
	String s2;
	int c_d;
        String os;
	int c_i;
        float[] a = new float[100];
        String[] similar;
        float[] b = new float[100];
	int[][] path = new int[100][100];
	int[][] ways = new int[100][100];
	
	new_edit_distance (String ss1, String ss2, String[] similar1) {
       //     edit_check ec = edit_check.getinstance();
         //   similar = ec.similar;
            similar = similar1;
   //         System.out.println("comparint b/w --> " + ss1 + "   " + ss2);
		c_d = 1;
		c_i = 1;
                s1 = ss1;
                s2 = ss2;
                int i , j;
                String ss , sss;
                
/*		ss = "र�?";
                if(s1.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s1.length(); i++) {
                        if(s1.charAt(i) == 'र' && s1.charAt(i + 1) == '�?') {
                            sss += (char)2412;
                            i++;
                        } else {
                            sss += s1.charAt(i);
                        }
                    }
                    s1 = sss;
                }
                if(s2.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s2.length() - 1 ; i++) {
                        if(s2.charAt(i) == 'र' && s2.charAt(i + 1) == '�?') {
                            sss += (char)2412;
                            i++;
                        } else {
                            sss += s2.charAt(i);
                        }
                    }
                    s2 = sss;
                }
                
  */              ss = "क्ष";
                if(s1.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s1.length() - 2 ; i++) {
                        if(s1.charAt(i) == 'क' && s1.charAt(i + 1) == '्' && s1.charAt(i + 2) == 'ष') {
                            sss += (char)2415;
                            i += 2;
                        } else {
                            sss += s1.charAt(i);
                        }
                    }
                    while(i < s1.length()) {
                        sss += s1.charAt(i);
                        i++;
                    }
                    s1 = sss;
                }
                if(s2.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s2.length() - 2 ; i++) {
                        if(s2.charAt(i) == 'क' && s2.charAt(i + 1) == '्' && s2.charAt(i + 2) == 'ष') {
                            sss += (char)2415;
                            i += 2;
                        } else {
                            sss += s2.charAt(i);
                        }
                    }
                    while(i < s2.length()) {
                        sss += s2.charAt(i);
                        i++;
                    }
                    s2 = sss;
                }
                
                ss = "ज्ञ";
                if(s1.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s1.length() - 2 ; i++) {
                        if(s1.charAt(i) == 'ज' && s1.charAt(i + 1) == '्' && s1.charAt(i + 2) == 'ञ') {
                            sss += (char)2413;
                            i += 2;
                        } else {
                            sss += s1.charAt(i);
                        }
                    }
                    while(i < s1.length()) {
                        sss += s1.charAt(i);
                        i++;
                    }
                    s1 = sss;
                }
                if(s2.contains(ss)) {
    //                System.out.println("hereeeeeeeeeeeeeee");
                    sss = "";
                    for(i = 0 ; i < s2.length() - 2 ; i++) {
                        if(s2.charAt(i) == 'ज' && s2.charAt(i + 1) == '्' && s2.charAt(i + 2) == 'ञ') {
                            sss += (char)2413;
                            i += 2;
                        } else {
                            sss += s2.charAt(i);
                        }
                    }
                    while(i < s2.length()) {
                        sss += s2.charAt(i);
                        i++;
                    }
                    
                    s2 = sss;
     //               System.out.println("ddddddddd====> " + s2);
                }
                
                ss = "त्र";
                if(s1.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s1.length() - 2 ; i++) {
                        if(s1.charAt(i) == 'त' && s1.charAt(i + 1) == '्' && s1.charAt(i + 2) == 'र') {
                            sss += (char)2414;
                            i += 2;
                        } else {
                            sss += s1.charAt(i);
                        }
                    }
                    while(i < s1.length()) {
                        sss += s1.charAt(i);
                        i++;
                    }
                    s1 = sss;
                }
                if(s2.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s2.length() - 2 ; i++) {
                        if(s2.charAt(i) == 'त' && s2.charAt(i + 1) == '्' && s2.charAt(i + 2) == 'र') {
                            sss += (char)2414;
                            i += 2;
                        } else {
                            sss += s2.charAt(i);
                        }
                    }
                    while(i < s2.length()) {
                        sss += s2.charAt(i);
                        i++;
                    }
                    s2 = sss;
                }
                
                ss = "श्र";
                if(s1.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s1.length() - 2 ; i++) {
                        if(s1.charAt(i) == 'श' && s1.charAt(i + 1) == '्' && s1.charAt(i + 2) == 'र') {
                            sss += (char)2416;
                            i += 2;
                        } else {
                            sss += s1.charAt(i);
                        }
                    }
                    while(i < s1.length()) {
                        sss += s1.charAt(i);
                        i++;
                    }
                    s1 = sss;
                }
                if(s2.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s2.length() - 2 ; i++) {
                        if(s2.charAt(i) == 'श' && s2.charAt(i + 1) == '्' && s2.charAt(i + 2) == 'र') {
                            sss += (char)2416;
                            i += 2;
                        } else {
                            sss += s2.charAt(i);
                        }
                    }
                    while(i < s2.length()) {
                        sss += s2.charAt(i);
                        i++;
                    }
                    s2 = sss;
                }
                
                ss = "्र";
                if(s1.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s1.length() - 1 ; i++) {
                        if(s1.charAt(i) == '्' && s1.charAt(i + 1) == 'र') {
                            sss += (char)2411;
                            i++;
                        } else {
                            sss += s1.charAt(i);
                        }
                    }
                    if(i == s1.length() - 1) {
                        sss += s1.charAt(i);
                    }
                    s1 = sss;
                }
                if(s2.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s2.length() - 1 ; i++) {
                        if(s2.charAt(i) == '्' && s2.charAt(i + 1) == 'र') {
                            sss += (char)2411;
                            i++;
                        } else {
                            sss += s2.charAt(i);
                        }
                    }
                    if(i == s2.length() - 1) {
                        sss += s2.charAt(i);
                    }
                    s2 = sss;
                }
                
                ss = "्";
                if(s1.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s1.length() - 1 ; i++) {
                        if(is_consonant1(s1.charAt(i)) && s1.charAt(i + 1) == '्') {
                            sss += (char)((int)s1.charAt(i) + 200);
                            i++;
                        } else {
                            sss += s1.charAt(i);
                        }
                    }
                    if(i == s1.length() - 1) {
                        sss += s1.charAt(i);
                    }
                    s1 = sss;
                }
                if(s2.contains(ss)) {
                    sss = "";
                    for(i = 0 ; i < s2.length() - 1 ; i++) {
                        if(is_consonant(s2.charAt(i)) && s2.charAt(i + 1) == '्') {
                            sss += (char)((int)s2.charAt(i) + 200);
                            i++;
                        } else {
                            sss += s2.charAt(i);
                        }
                    }
                    if(i == s2.length() - 1) {
                        sss += s2.charAt(i);
                    }
                    s2 = sss;
                }
           //     System.out.println("after ---> and goin to init " + s1 + "   " + s2);
		init();
	}
        
        void init () {
            int temp = 0;
		for (int i = 1; i < s1.length() + 1; i++) {
                    if (is_consonant(s1.charAt(i - 1)))
                        temp += c_d + 1;
                    else temp += c_d;
			
                    ways[0][i] = temp;
                    path[0][i] = path[0][i - 1] + 1;
		}
		
                temp = 0;
		for (int i = 1; i < s2.length() + 1; i++) {
                    if (is_consonant(s2.charAt(i - 1)))
                        temp += c_i + 1;
                    else temp += c_i;
                    ways [i][0] = temp;
                    path [i][0] = path[i - 1][0];
                    for (int j = 1; j < s1.length() + 1; j++) {
			ways[i][j] = 0;
                    }
		}
         //       System.out.println("going in function");
                function ();
	}
        
    void function() {
        //        System.out.println("from function ---> s1 == " + s1 + "  s2 == " + s2);
          //     for (int o = 0; o < s1.length(); o++) {
            //                                    System.out.print("o = " + o + "-"+ s1.charAt(o) + " ");
              //                              } 
                int t1 , t2, tt1, tt2;
		for (int i = 1; i < s2.length() + 1; i++) {
			for (int j = 1; j < s1.length() + 1; j++) {
       //                         System.out.println("inside ---> " + s2.charAt(i - 1));
                                t1 = 0;
                                tt1 = 0;
                                tt2 = 0;
                                t2 = 0;
           //                     System.out.println("hereererer1");
                                if((int)s1.charAt(j - 1) > 2410)
                                        t1 = 1;
                                if((int)s2.charAt(i - 1) > 2410)
                                        t2 = 1;
                                
                                if((int)s1.charAt(j - 1) > 2508)
                                        tt1 = 1;
                                if((int)s2.charAt(i - 1) > 2508)
                                        tt2 = 1;
             //                   System.out.println("hereererer2");
                        //        if (tt1 == 1 || tt2 == 0) {
                          //          System.out.println("for word = " + s1 + " and " + s2 + " tt1 = " + tt1 + " tt2 = " + tt2 + " t1 = " + t1 + " t2 = " + t2);
                          //      }
                                int right = 0;
         //                       System.out.println("heloo1");
                                if(is_consonant(s1.charAt(j - 1)) || t1 == 1) { 
           //                         System.out.println("heloo2");
                                    
                                    right = ways[i][j - 1] + c_d + 1;
               //                     System.out.println("hereerere13");
                        }
                                else {///*
                                    int temp_i = i - 1;
                                    int temp_j = j - 2;
                 //                   System.out.println("hereererer4");
                                    while (temp_j >= 0 && (int)s1.charAt(temp_j) < 2410 && !is_consonant(s1.charAt(temp_j))) {
                                        temp_j--;
                                    }
                                    
                                    while (temp_i >= 0 && (int)s2.charAt(temp_i) < 2410 && !is_consonant(s2.charAt(temp_i))) {
                                        temp_i--;
                                    }
                                    
                                    if (temp_i == -1)
                                        temp_i = 0;
                                    
                                    if (temp_j == -1)
                                        temp_j = 0;
                                    
                                   if (s1.charAt(temp_j) != s2.charAt(temp_i)) {
                                        right = ways[i][j - 1] + c_d + 1;
                                    } else {
                                        right = ways[i][j - 1] + c_d + 0;
                   //                 System.out.println("hereererer5");
                                    }
                                }
           //                     System.out.println("heloo4");
				int down = 0;
                                if (is_consonant(s2.charAt(i - 1)) || t2 == 1) {
             //                       System.out.println("heloo5");
                             //       if (s2 == "किर्या")
                               // System.out.println();
					down = ways[i - 1][j] + c_i + 1;
                     //           System.out.println("hereererer6");
                                }
                                else { ///*
             //                       System.out.println("heloo7");
                       //             System.out.println("hereererer7");
                                    int temp_i = i - 2;
                                    int temp_j = j - 1;
                                    
                                    while (temp_j >= 0 && (int)s1.charAt(temp_j) < 2410 && !is_consonant(s1.charAt(temp_j))) {
                                        temp_j--;
                                    }
                                    
                                    while (temp_i >= 0 && (int)s2.charAt(temp_i) < 2410 && !is_consonant(s2.charAt(temp_i))) {
                                        temp_i--;
                                    }
                                    
                                    if (temp_i == -1)
                                        temp_i = 0;
                                    
                                    if (temp_j == -1)
                                        temp_j = 0;
       //                             System.out.println("heloo9");
                                    if (s1.charAt(temp_j) != s2.charAt(temp_i)) {
        //                                System.out.println("heloo10");
                                        down = ways[i - 1][j] + c_i + 1;
                                    } else down = ways[i - 1][j] + c_i + 0;
        //                            System.out.println("heloo11");
                         //           System.out.println("hereererer8");
                                }
					
				int diagonal;
				if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
					diagonal = ways[i - 1][j - 1];
                           //     System.out.println("hereererer9");
                                }
				else {
                             //        System.out.println("hereererer111111111   " + j + "   " + i);
                                    if (is_consonant(s1.charAt(j - 1)) && is_consonant(s2.charAt(i - 1))) {
                                        int increament = 0;
                    //                     System.out.println("hereererer2222222");
                                        int g = (int)(s1.charAt(j - 1)) - 2305;
                                        String sim = "";
                                        if(g>=0 && g < similar.length) {
                                        sim = similar[g];
                                        }
                          //              if (s2.equals("कंसेट"))
                            //                System.out.println("sim = " + sim + " " + s1.charAt(j - 1));
                                        if (sim == "-")
                                            increament = 2;
                                        else {
                      //                       System.out.println("hereererer333333333333");
                                            int flag = 0;
                                            for (int ii = 1; ii < sim.length(); ii++) {
                                                if (sim.charAt(ii) == s2.charAt(i - 1)) {
                                                    increament = 1;
                                                
                                                    flag = 1;
                                                    break;
                                                }
                                            }
                                        
                                            if (flag == 0)
                                                increament = 2;
                        //                    System.out.println("hereererer10");
                                        }
                                        
                                        diagonal = ways[i - 1][j - 1] + increament;
                                    } else if (!(is_consonant(s1.charAt(j - 1))) && !(is_consonant(s2.charAt(i - 1))) && (t1 != 1) && (t2 != 1)) {
                                        int increament = 0;
                          //              System.out.println("hereererer111111111111111111111111111111111111111111111111");
                                        int g = (int)(s1.charAt(j - 1)) - 2305;
                                        String sim = "";
                                        if(g>=0 && g < similar.length) {
                                           sim = similar[g];
                                         }
                                        if (sim == "-")
                                            increament = 2;
                                        else {
                                            int flag = 0;
                                            for (int ii = 0; ii < sim.length(); ii++) {
                                                if (sim.charAt(ii) == s2.charAt(i - 1)) {
                                                    increament = 1;
                                                
                                                    flag = 1;
                                                    break;
                                                }
                            //                    System.out.println("hereererer11");
                                            }
                                        
                                            if (flag == 0)
                                                increament = 2;
                                        }
                                        
                                        diagonal = ways[i - 1][j - 1] + increament;
                                        
                                    } else if (t1 == 1 && t2 == 1) {
                              //          System.out.println("hereererer222222222222222222222222222222222222222");
                                        int increament = 0;
                                        
                                        if (tt1 == 1 && tt2 == 1) {
                                            int a1, a2;
                                        
                                            a1 = (int)s1.charAt(j - 1) - 200 - 2305;
                                        
                                            a2 = (int)s2.charAt(i - 1) - 200 - 2305;
                                       
                                        String sim = "";
                                        if(a1 >= 0 && a1 < similar.length) {
                                            sim = similar[a1];
                                        }
        //                                    System.out.println("inside " + a1 + " " + a2 + " s = " + sim);
                                        
                                            if (sim == "-")
                                                increament = 2;
                                            else {
                                                int flag = 0;
                                                for (int ii = 0; ii < sim.length(); ii++) {
                                                    if (sim.charAt(ii) == (char)(a2 + 2305)) {
                                                        increament = 1;
                                                
                                                        flag = 1;
                                                        break;
                                                    }
                                //                    System.out.println("hereererer12");
                                                }
                                        
                                                if (flag == 0)
                                                    increament = 2;
                                            }
                                        } else increament = 2;
                                        
                                        diagonal = ways[i - 1][j - 1] + increament;
                                    } else if (is_consonant(s1.charAt(j - 1)) && t2 == 1) {
                                        int increament = 0;
                                    //    System.out.println("hereererer3333333333333333333333333333333333333333333333");
                          //      //        System.out.println("hereererer13");
                                        if (tt2 == 1) {
                                            int a1, a2;
                                        
                                            a1 = (int)s1.charAt(j - 1) - 2305;
                                        
                                            a2 = (int)s2.charAt(i - 1) - 200 - 2305;
                                       
                                        
                                            String sim = "";
                                            if(a1 >= 0 && a1 < similar.length) {
                                            		sim = similar[a1];
                                            }
                                        
                                            if (sim == "-")
                                                increament = 2;
                                            else {
                                                int flag = 0;
                                                for (int ii = 0; ii < sim.length(); ii++) {
                                                    if (sim.charAt(ii) == (char)(a2 + 2305)) {
                                                        increament = 1;
                                                
                                                        flag = 1;
                                                        break;
                                                    }
                                                }
                                        
                                                if (flag == 0)
                                                    increament = 2;
                     //                           System.out.println("hereererer14");
                                            }
                                        } else {
                                            increament = 2;
                                        }
                                        
                                        diagonal = ways[i - 1][j - 1] + increament;
                                    } else if (is_consonant(s2.charAt(i - 1)) && t1 == 1) {
                                        int increament = 0;
                       //                 System.out.println("hereerer444444444444444444444444444444444444444444444444444");
                                        if (tt1 == 1) {
                                            int a1, a2;
                          //                  for (int o = 0; o < s1.length(); o++) {
                        //                        System.out.print("o = " + o + "-"+ s1.charAt(o) + " ");
                      //                      }
                    //                        System.out.println();
                         //                   System.out.println("hereererer indide if    j = " + j + "    " + (int)s1.charAt(j - 1) + "     " + s1.charAt(j - 1));    
                                            a1 = (int)s1.charAt(j - 1) - 200 - 2305;
                                        
                                            a2 = (int)s2.charAt(i - 1) - 2305;
                            //                System.out.println("newwwwwwwwwwwwwwwwwwwwwwwwwwwww    " + a1);
                                            String sim = "";
                                            if(a1 >= 0 && a1 < similar.length) {
                                            sim = similar[a1];
                                            }
                              //          System.out.println("hphewwwwwwwwwwwwwwwwwww");
                                            if (sim == "-")
                                                increament = 2;
                                            else {
                           //                     System.out.println("hereererer         inside else");
                                                int flag = 0;
                                                for (int ii = 0; ii < sim.length(); ii++) {
                                                    if (sim.charAt(ii) == (char)(a2 + 2305)) {
                                                        increament = 1;
                                                
                                                        flag = 1;
                                                        break;
                                                    }
                             //                       System.out.println("hereererer15");
                                                }
                                        
                                                if (flag == 0)
                                                    increament = 2;
                                            }
                                        } else {
                                            increament = 2;
                                        }
                                        
                                        diagonal = ways[i - 1][j - 1] + increament;
                                    } else if (t1 != 1 && t2 != 1){
                                        int increament = 0;
                   //                     System.out.println("hereerere55555555555555555555555555555555555555555555555555");
                          //              System.out.println("hererererererererererererer   " + ((int)(s1.charAt(j - 1))) + "  " + s1.charAt(j - 1));
                                       int g = (int)(s1.charAt(j - 1)) - 2305;
                                        String sim = "";
                                        if(g >= 0 && g < similar.length) {
                                        sim = similar[g];
                                        }
                          //              System.out.println("nowwwwwwww herererererererererer");
                                        if (sim == "-")
                                            increament = 2;
                                        else {
                                            int flag = 0;
                                            for (int ii = 0; ii < sim.length(); ii++) {
                                                if (sim.charAt(ii) == s2.charAt(i - 1)) {
                                                    increament = 1;
                                                
                                                    flag = 1;
                                                    break;
                                                }
                                            }
                                        
                                            if (flag == 0)
                                                increament = 2;
                                        }
                                        
                                        diagonal = ways[i - 1][j - 1] + increament;
                                    } else {
                                        diagonal = ways[i - 1][j - 1] + 2;
                                    }
                                }
					
				if (down <= right) {
					if (diagonal >= down) {
						ways[i][j] = down;
                                                path[i][j] = path[i - 1][j] + 1;
					}
				}
				if (right <= down) {
					if (right <= diagonal) {
						ways[i][j] = right;
                                                path[i][j] = path[i][j - 1] + 1;
					}
				}
                                if (diagonal <= right) {
					if (diagonal <= down) {
						ways[i][j] = diagonal;
                                                if (ways[i][j] == ways[i - 1][j - 1])
                                                    path[i][j] = path[i - 1][j - 1];
                                                else path[i][j] = path[i - 1][j - 1] + 1;
					}
				}
                                
			}
		}
  //              if(s1 == "निचित" && s2 == "नि৾चित")
  //                  display();
	}
                
    void display() {
		for (int i = 0; i < s2.length() + 1; i++) {
			for (int j = 0; j < s1.length() + 1; j++) {
				System.out.print(ways[i][j] + " ");
			}
			System.out.println();
		}
	}
    
    int get_distance () {
        int dis;
        
        if (path[s2.length()][s1.length()] == 2)
            dis = ways[s2.length()][s1.length()];
        else if (path[s2.length()][s1.length()] < 2)
            dis = ways[s2.length()][s1.length()];
        else dis = ways[s2.length()][s1.length()] + path[s2.length()][s1.length()] - 2;
//        System.out.println("returning --> " + dis);
        return dis;
    }
    
    boolean is_consonant1(char c) {
        if ((int)c >= 2325 && (int)c <= 2361)
            return true;
        else return false;
    }
};
