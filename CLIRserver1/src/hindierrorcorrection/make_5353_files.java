/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hindierrorcorrection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class make_5353_files {
    void make_files () throws IOException {
        for (int i = 2309; i < 2362; i++) {
            String ad1 = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\first_conso\\";
            String ad2 = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\second_conso\\";
            ad1 += (char)(i);
            ad2 += (char)(i);
            try (BufferedWriter out = new BufferedWriter(new FileWriter(ad1))) {
            }
            try (BufferedWriter out = new BufferedWriter(new FileWriter(ad2))) {
            }
            for (int j = 2305; j < 2406; j++) {
                try {
                    String add = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\bigrams\\";
                    add += (char)(i);
                    add += " ";
                    add += (char)(j);
                    String add1 = add;
                    String add2 = add;
                    add1 += ".txt";
                    add2 += "_1";
                    add2 += ".txt";
                    String finl = "";
                    finl += (char)(i) + " " + (char)j + " --> ";
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(add1))) {
                        out.write(finl);
                        out.close();
                    }
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(add2))) {
                        out.write(finl);
                        out.close();
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
            
            for (int j = 2309; j < 2362; j++) {
                String add = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\second_conso\\";
                add += (char)j;
                try (BufferedWriter out = new BufferedWriter(new FileWriter(add))) {
                        out.close();
                    }
                
                add = "C:\\Users\\hp\\workspace\\CLIRserverfi\\src\\hindierrorcorrection\\first_conso\\";
                add += (char)j;
                try (BufferedWriter out = new BufferedWriter(new FileWriter(add))) {
                        out.close();
                    }
            }
        }
    }
}
