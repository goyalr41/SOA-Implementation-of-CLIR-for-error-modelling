package hindierrorcorrection;


import irhindi.tfidf.term_freqmatrixcall;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class hindierrorcall {
	public File processerr(File Doc, String filename) throws IOException {
		      char[] w = new char[501];
		      mainfile mainfi = new mainfile();

		     
		      File file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+Doc.getName()+"_hiner");
		  	
				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}
		    FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
				
				Scanner sc1 = new Scanner(Doc);
				while(sc1.hasNextLine()) {
					Scanner sc2 = new Scanner(sc1.nextLine());
					while(sc2.hasNext()) {
						String s = sc2.next();
						String h = s;
					    String p = mainfi.process(s);
					    //System.out.println(p);
					    if(!p.equals("null")) {
					    	bw.write(p+" ");
					    }else {
					    	bw.write(h+" ");
					    }
						
					}
					sc2.close();
				}
				sc1.close();
				bw.close();
				return file;
		     // for (int i = 0; i < args.length; i++)
	}
	
}