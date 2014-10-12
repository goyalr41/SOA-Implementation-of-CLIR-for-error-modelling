package hindierrorcorrection;
import java.util.Arrays;

public class testing_output {
    
    String sss;
/*    private static testing_output instance;
    public static synchronized testing_output getinstance () {
        if (instance == null) {
            instance = new testing_output();
            
            return instance;
        } else {
            return instance;
        }
        
    }
  */  
    public String get_output(String[] edit_words , int[] edit_dist , int k) {
        String[][] words = new String[100][1000];
        int[] arr = new int[100];
        int i , j , x , y;
        Arrays.fill(arr, 0);
        sss = "";
        
        for(i = 0 ; i < k  ; i++) {
  //          System.out.print(edit_words[i] + "  ");
            words[edit_dist[i]][arr[edit_dist[i]]] = edit_words[i];
            arr[edit_dist[i]]++;
        }
        
             y = 0;       
            for(i = 0 ; i < 10 ; i++) {
                x = arr[i];
                if(x > 0) {
                    y++;
                }
                if(y > 0 && y < 4) {
                    for(j = 0 ; j < x ; j++) {
                        sss += words[i][j]; 
                        sss += "  ";
                    }
                }
            }
   //         System.out.print(sss);
            return sss;
    }
    
}
