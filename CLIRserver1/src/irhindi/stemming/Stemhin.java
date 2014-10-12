package irhindi.stemming;


import irhindi.tfidf.term_freqmatrixcall;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Stemhin {
	public String poi ="";
	public void stemmer(File Doc, String filename,int query) throws IOException {
		      char[] w = new char[501];
		      Stemminghin stemmerhin = new Stemminghin();

		     
		      File file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+Doc.getName()+"_stem");
		  	
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
						int len = stemmerhin.stem(s.toCharArray(),s.length()) ;
						bw.write(s.substring(0,len)+" ");
						 poi = poi + s.substring(0,len)+" ";
					}
					sc2.close();
				}
				sc1.close();
				bw.close();
				System.out.println("Stemming done");
			    term_freqmatrixcall tfid = new term_freqmatrixcall();
			    if(query == 0) {
			    	 tfid.call(file, filename,query);
			     }else {
			    	 tfid.call(file, poi,query);
			     }
			    System.out.println("TF-IDF Made");
		     // for (int i = 0; i < args.length; i++)
	}
	
}
