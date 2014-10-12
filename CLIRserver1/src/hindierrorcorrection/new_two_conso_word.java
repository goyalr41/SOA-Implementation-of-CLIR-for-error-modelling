/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hindierrorcorrection;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author vissh_000
 */
class new_two_conso_word extends bigram_table {
    public new_two_conso_word(String s2, int line_no) {
        try {
            String finl = "";
            finl += String.valueOf(line_no) + " ";
            char ch1 = s2.charAt(0);
            try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\first_conso\\" + ch1, true))) {
                out.write(finl);
                out.close();
            }
        } catch (Exception e) {
           System.out.println("1 error");
        }
        
        try {
            int i = 1;
            while ((i != s2.length()) && !is_consonant(s2.charAt(i)))
                i++;
            
            if (i != s2.length()) {
                String finl = "";
                finl += String.valueOf(line_no) + " ";
                char ch2 = s2.charAt(i);
                try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\second_conso\\" + ch2, true))) {
                    out.write(finl);
                    out.close();
                }
            }
        }catch (Exception e) {
            System.out.println("2 error");
        }
    }
}
