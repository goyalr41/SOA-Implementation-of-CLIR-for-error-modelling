package englisherrorcorrection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//import org.apache.commons.io.FileUtils;

public class replacement {

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File inp_file = new File("D:\\xyz.txt");
        BufferedReader br = new BufferedReader(new FileReader(inp_file));
        Scanner sc1 = new Scanner(inp_file); 
         while(sc1.hasNextLine()) { 
                Scanner sc2 = new Scanner(sc1.nextLine()); 
                while(sc2.hasNext()) { 
                     String word = sc2.next();
                     if(word.compareTo("there") == 0){
                        System.out.println("yess");
                         String output = word.replaceAll("there", "here");
                         
                        //FileUtils.writeStringToFile(inp_file, output);
                     }
                }
                sc2.close();
         }
         sc1.close();
    }
}
