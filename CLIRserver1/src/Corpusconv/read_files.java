package Corpusconv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class read_files {
    String ini_path = "E:\\final_folder\\";
    Tesserect ob = new Tesserect();
    static String data;
    void filewrite(String out_name) throws IOException
    {
        File new_file = new File(out_name);
        FileWriter fstream = new FileWriter(new_file);
        BufferedWriter out_write = new BufferedWriter(fstream); 
        
        out_write.write(data);
        out_write.close();
    }
    void read_corpus(final File folder) throws FileNotFoundException, IOException
    {
    	System.out.println("Readhua");
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                read_corpus(fileEntry);
        
            } else {
                String name = process(fileEntry);
                String out_filename = ini_path + name + ".txt";
               filewrite(out_filename);
               System.out.println(out_filename);
            }
        }
    }
    String process(File inp_file) throws FileNotFoundException
    {
        data = ob.convert(inp_file);
        //System.out.println("hhj");
        System.out.println(data);
        String path = inp_file.getAbsolutePath();
        String[] str = path.split("\\\\");
        String file_name = str[3] + "_" + str[5];
        file_name = file_name.substring(0, file_name.length()-4);
       // System.out.println(file_name);
        return file_name;
       
    }
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        read_files ob = new read_files();
        final File folder = new File("E:\\corpus");
        ob.read_corpus(folder);
        
    }
}
