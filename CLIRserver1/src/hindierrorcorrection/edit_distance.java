package hindierrorcorrection;
import java.util.*;
public class edit_distance {
    
    public int cal_distance(String s1 , String s2) {
        int a , b , i , j , k , u , l , d , p , q , c , x , y , z;
        c = 0;
        x = 0;
        y = 0;
        a = s1.length();
	b = s2.length();
	int[][] arr = new int[100][100];
        int[][][] path = new int[100][100][100];
	arr[0][0] = 0;
        path[0][0][0] = 0;
   //     path[0][0][1] = -1;
        path[0][1][0] = 0;
        
        path[1][0][0] = 0;
//        System.out.println(path[2][2][2]);
        
        
        for(i = 1 ; i <= a ; i++) {
		arr[0][i] = i;
	}
	
	for(i = 1 ; i <= b ; i++) {
		arr[i][0] = i;
	}
        
        for(i = 1 ; i <= b ; i++) {
    //        System.out.println();
		for(j = 1 ; j <= a ; j++) {
                        if((int)s1.charAt(j - 1) >= 2309 && (int)s1.charAt(j - 1) <= 2361) {
       //                     System.out.println("insert 2");
                            l = arr[i][j - 1] + 2;
                        } else {
        //                    System.out.println("insert 1");
                            l = arr[i][j - 1] + 1;
                        }
                        if((int)s2.charAt(i - 1) >= 2309 && (int)s2.charAt(i - 1) <= 2361) {
                            
                            u = arr[i - 1][j] + 2;
          //                  System.out.println("delete 2");
                        } else {
                            u = arr[i - 1][j] + 1;
                            
            //                System.out.println("delete 1");
                        }
			d = arr[i - 1][j - 1];
			if(s1.charAt(j - 1) != s2.charAt(i - 1)) {
                            if(((int)s2.charAt(i - 1) >= 2309 && (int)s1.charAt(j - 1) <= 2361) || ((int)s2.charAt(i - 1) < 2309 && (int)s1.charAt(j - 1) > 2361)) {
  //                          System.out.println("true for --> " + s2.charAt(i - 1) + "  " + s1.charAt(j - 1));
				d += 1;
              //                  System.out.println("replace 1");
                            } else {
                //                System.out.println("replace 2");
                            	d += 2;
                            }
                        }
			k = 0;
			if(u <= l) {
//                            System.out.println("here1");
				k = 1;
				arr[i][j] = u;
			} else {
				k = 2;
  //                              System.out.println("here2");
				arr[i][j] = l;
			}
			if(arr[i][j] >= d) {
  //                              if(s1.charAt(j - 1) != s2.charAt(i - 1)) {
                         //           k = 4;
   //                                 System.out.println("here3");
                          //      } else {
                                    k = 3;
     //                               System.out.println("here4");
                         //       }
				arr[i][j] = d;
			}
         //               System.out.print(arr[i][j] + " ");
			if(k == 1) {
                                x = i - 1;
                                y = j;
			}
			if(k == 2) {
                                x = i;
                                y = j - 1;
			}
			if(k == 3) {
                                x = i - 1;
                                y = j - 1;
			}
                        z = 0;
        //                System.out.println(x + "  " + y + "  " + i + "  " + j);
                        while(path[x][y][z] != 0) {
   //                         System.out.println("copyying -->  " + path[x][y][z] + "--->" + path[i][j][z]);
                            path[i][j][z] = path[x][y][z];
                            z++;
                        }
                        path[i][j][z] = k;       
		}
    
	}
        
        
        for(i = 0 ; i <= b ; i++) {
            for(j = 0 ; j <= a ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();   
        }
        for(i = 0 ; path[b][a][i] != 0 ; i++) {
            System.out.print(path[b][a][i] + " ");
        }
      System.out.println();
        return arr[b][a];
    }
}
