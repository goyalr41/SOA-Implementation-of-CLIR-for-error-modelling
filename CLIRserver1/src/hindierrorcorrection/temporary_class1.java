/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hindierrorcorrection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class temporary_class1 {
    public String finl = "";
    
    int i;
    int number = 2;
    
    temporary_class1 () throws IOException {
        for (i = 0; i < 53; i++) {
            while (!is_prime(number++)) {
            }
            finl += (number - 1) + " ";
            System.out.println(number - 1 + " ");
        }
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter("F:\\miniproject\\src\\miniproject\\prime_no_for_consonants.txt"))) {
              out.write(finl);
              out.close();
        }
    }

    private boolean is_prime(int number) {
        boolean chek = true;
        
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                chek = false;
                break;
            }           
        }
        
        return chek;
    }
}