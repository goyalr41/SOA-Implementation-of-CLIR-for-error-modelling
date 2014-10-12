package CLIR.server;

import irenglish.upload.EnFileUploader;
import irhindi.upload.HinFileUploader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import CLIR.server.genFile;
import translation.EntoHin;
import translation.HintoEn;
import irenglish.tfidf.*;
import irhindi.tfidf.*;
public class Query {
	public byte[] query(String data,String lang1, String trans) throws Exception{
		String data_trans = "";
		File solution = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/querysolution.txt");
		solution.delete();
		solution.createNewFile();
		if(lang1.compareToIgnoreCase("english") == 0) {
			if(trans.compareToIgnoreCase("yes") == 0) {
				EntoHin  eth = new EntoHin();
				data_trans = eth.doit(data);
				File query1 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query1.txt");
				File query2 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query2.txt");
				query1.delete();
				query1.createNewFile();
				query2.delete();
				query2.createNewFile();
				FileWriter fw1 = new FileWriter(query1.getAbsoluteFile(),true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(data);
				bw1.close();
				FileWriter fw2 = new FileWriter(query2.getAbsoluteFile(),true);
				BufferedWriter bw2 = new BufferedWriter(fw2);
				bw2.write(data_trans);
				bw2.close();
				genFile gf = new genFile();
				EnFileUploader efu = new EnFileUploader();
				efu.fileUpload(gf.convert(query1),query1.getName(),"no",1);
				
				HinFileUploader hfu = new HinFileUploader();
				hfu.fileUpload(gf.convert(query2),query2.getName(),"no",1);
				
				FileWriter fw3 = new FileWriter(solution.getAbsoluteFile(),true);
				BufferedWriter bw3 = new BufferedWriter(fw3);
				
				bw3.write(" "+data+" "+"<>"+" ");
				
				HashMap<String,Double> final_res = irenglish.tfidf.term_freqmatrix.final_resen;
				
				 for (Map.Entry<String, Double> abc: final_res.entrySet()) {
					    //String doc = temp.get(arg0);
			 			bw3.write(abc.getKey()+","+abc.getValue()+",");
				}
				 bw3.write(" "+"<>");
				 
				bw3.write(" "+data_trans+" "); 
				
				final_res = irhindi.tfidf.term_freqmatrix.final_reshin;
				bw3.write("<>"+" ");
				 for (Map.Entry<String, Double> abc: final_res.entrySet()) {
					    //String doc = temp.get(arg0);
			 			bw3.write(abc.getKey()+","+abc.getValue()+",");
				}
				 bw3.write(" "+"<>");
				 bw3.close();
			}else {
				File query1 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query1.txt");
				query1.delete();
				query1.createNewFile();
				FileWriter fw1 = new FileWriter(query1.getAbsoluteFile(),true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(data);
				bw1.close();
				genFile gf = new genFile();
				EnFileUploader efu = new EnFileUploader();
				efu.fileUpload(gf.convert(query1),query1.getName(),"no",1);
				
				FileWriter fw3 = new FileWriter(solution.getAbsoluteFile(),true);
				BufferedWriter bw3 = new BufferedWriter(fw3);
				
				bw3.write(" "+data+" "+"<>"+" ");
				
				HashMap<String,Double> final_res = irenglish.tfidf.term_freqmatrix.final_resen;
				
				 for (Map.Entry<String, Double> abc: final_res.entrySet()) {
					    //String doc = temp.get(arg0);
			 			bw3.write(abc.getKey()+","+abc.getValue()+",");
				}
				 bw3.write(" "+"<>");
				 
				 bw3.write(" "+data_trans+" "); 
					
					final_res = irhindi.tfidf.term_freqmatrix.final_reshin;
					bw3.write("<>"+" ");
					 for (Map.Entry<String, Double> abc: final_res.entrySet()) {
						    //String doc = temp.get(arg0);
				 			bw3.write(abc.getKey()+","+abc.getValue()+",");
					}
					 bw3.write(" "+"<>");
					 bw3.close();
			}
		}else {
			if(trans.compareToIgnoreCase("yes") == 0) {
				HintoEn  eth = new HintoEn();
				data_trans = eth.doit(data);
				File query1 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query1.txt");
				File query2 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query2.txt");
				query1.delete();
				query1.createNewFile();
				query2.delete();
				query2.createNewFile();
				FileWriter fw1 = new FileWriter(query1.getAbsoluteFile(),true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(data);
				bw1.close();
				FileWriter fw2 = new FileWriter(query2.getAbsoluteFile(),true);
				BufferedWriter bw2 = new BufferedWriter(fw2);
				bw2.write(data_trans);
				bw2.close();
				genFile gf = new genFile();
				HinFileUploader hfu = new HinFileUploader();
				hfu.fileUpload(gf.convert(query1),query1.getName(),"no",1);
				
				EnFileUploader efu = new EnFileUploader();
				efu.fileUpload(gf.convert(query2),query2.getName(),"no",1);
				
				FileWriter fw3 = new FileWriter(solution.getAbsoluteFile(),true);
				BufferedWriter bw3 = new BufferedWriter(fw3);
				
				bw3.write(" "+data_trans+" "+"<>"+" ");
				
				HashMap<String,Double> final_res = irenglish.tfidf.term_freqmatrix.final_resen;
				
				 for (Map.Entry<String, Double> abc: final_res.entrySet()) {
					    //String doc = temp.get(arg0);
			 			bw3.write(abc.getKey()+","+abc.getValue()+",");
				}
				 bw3.write(" "+"<>");
				 
				bw3.write(" "+data+" "); 
				//System.out.println("Aaaayaaaaaa");
				final_res = irhindi.tfidf.term_freqmatrix.final_reshin;
				bw3.write("<>"+" ");
				 for (Map.Entry<String, Double> abc: final_res.entrySet()) {
					    //String doc = temp.get(arg0);
			 			bw3.write(abc.getKey()+","+abc.getValue()+",");
				}
				 bw3.write(" "+"<>");
				 bw3.close();
			}else {
				File query1 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query1.txt");
				query1.delete();
				query1.createNewFile();
				FileWriter fw1 = new FileWriter(query1.getAbsoluteFile(),true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(data);
				bw1.close();
				genFile gf = new genFile();
				HinFileUploader hfu = new HinFileUploader();
				hfu.fileUpload(gf.convert(query1),query1.getName(),"no",1);
				
				FileWriter fw3 = new FileWriter(solution.getAbsoluteFile(),true);
				BufferedWriter bw3 = new BufferedWriter(fw3);
				
				bw3.write(" "+data_trans+" "+"<>"+" ");
				
				HashMap<String,Double> final_res = irenglish.tfidf.term_freqmatrix.final_resen;
				
				 for (Map.Entry<String, Double> abc: final_res.entrySet()) {
					    //String doc = temp.get(arg0);
			 			bw3.write(abc.getKey()+","+abc.getValue()+",");
				}
				 bw3.write(" "+"<>");
				 
				
				
				bw3.write(" "+data+" "); 
				System.out.println("write hua");
				final_res = irhindi.tfidf.term_freqmatrix.final_reshin;
				bw3.write("<>"+" ");
				 for (Map.Entry<String, Double> abc: final_res.entrySet()) {
					    //String doc = temp.get(arg0);
			 			bw3.write(abc.getKey()+","+abc.getValue()+",");
				}
				 bw3.write(" "+"<>");
				 bw3.close();
			}
			
		}
	
		genFile gf = new genFile();
		return gf.convert(solution);
	}
	
}
