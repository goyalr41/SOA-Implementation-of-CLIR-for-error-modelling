package irenglish.stemming;


import irenglish.tfidf.term_freqmatrixcall;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Stemen {
	public String poi = "";
	public void stemmer(File Doc, String filename,int query) throws IOException {
		      char[] w = new char[501];
		      Stemmeren s = new Stemmeren();
		      File out_file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+Doc.getName()+"_stem");
		      //File out_file = new File("C:/Users/hp/"+Doc.getName()+"_stem");
		      out_file.createNewFile();
		      FileWriter fstream = new FileWriter(out_file);
		      BufferedWriter out = new BufferedWriter(fstream);   

		     // for (int i = 0; i < args.length; i++)
		      try
		      {
		         FileInputStream in = new FileInputStream(Doc);

		         try
		         { 
		        	 while(true)
		             {  
		        		 int ch = in.read();
		        		 if (Character.isLetter((char) ch))
		        		 {
		        			 int j = 0;
		        			 while(true)
		        			 {
		        				 ch = Character.toLowerCase((char) ch);
		        				 w[j] = (char) ch;
		        				 if (j < 500) j++;
		                    
		        				 ch = in.read();
		        				 if (!Character.isLetter((char) ch))
		        				 {
		        					 /* to test add(char ch) */
		        					 for (int c = 0; c < j; c++) s.add(w[c]);

		        					 /* or, to test add(char[] w, int j) */
		        					 /* s.add(w, j); */

		        					 s.stem();
		        					 {  String u;

		        					 /* and now, to test toString() : */
		        					 u = s.toString();

		        					 /* to test getResultBuffer(), getResultLength() : */
		        					 /* u = new String(s.getResultBuffer(), 0, s.getResultLength()); */
		                                                   out.write(u);
		                                                   out.write(" ");
		                                                   poi = poi + u + " ";
		        					 //System.out.print("String = " + u);
		        					 }
		        					 break;
		        				 }
		        			 }
		        		 }
		        		 if (ch < 0) break;
		                                //out.write((char)ch);
		        		 	//System.out.print((char)ch);
		                                
		             }
		                 out.close();
		                 System.out.println("Stemming Done");
		         }
		         catch (IOException e)
		         {  System.out.println("error reading " + "file");
		           // break;
		         }
		      }
		      catch (FileNotFoundException e)
		      {  System.out.println("file " + " not found");
		         //break;
		      }
		      System.out.println("Stemming Done");
		      
		      	
			    
		      	 term_freqmatrixcall tfid = new term_freqmatrixcall();
		      	System.out.println("TF-IDF Called");
			     if(query == 0) {
			    	 tfid.call(out_file, filename,query);
			     }else {
			    	 tfid.call(out_file, poi,query);
			     }
			      
		     
		   }
	
}
