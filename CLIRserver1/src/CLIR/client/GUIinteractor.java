package CLIR.client;

import irenglish.upload.EnFileUploader;
import irhindi.upload.HinFileUploader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import translation.EntoHin;
import translation.HintoEn;

public class GUIinteractor {
	
	 File filewrite(String data) throws IOException
	    {
	        File new_file = new File("E://temp_file");
	        new_file.delete();
	        new_file.createNewFile();
	        FileWriter fstream = new FileWriter(new_file);
	        BufferedWriter out_write = new BufferedWriter(fstream); 
	        
	        out_write.write(data);
	        out_write.close();
	        return new_file;
	    }
	 
	public void upload(File f,String lang, String Type) throws FileNotFoundException, IOException {
		if(Type.compareToIgnoreCase("text") != 0){
			Tesserect tes = new Tesserect();
			String h = tes.convert(f);
			f = filewrite(h);
			
		}
		
		if(lang.compareToIgnoreCase("english") == 0){
			genFile gf = new genFile();
			EnFileUploader efu = new EnFileUploader();
			efu.fileUpload(gf.convert(f),f.getName(),"no",0);
		}
		
		if(lang.compareToIgnoreCase("hindi") == 0){
			genFile gf = new genFile();
			HinFileUploader hfu = new HinFileUploader();
			hfu.fileUpload(gf.convert(f),f.getName(),"no",0);
		}
	}
	
	public void query(String data,String lang1, String trans) throws Exception{
		String data_trans = "";
		if(lang1.compareToIgnoreCase("english") == 0) {
			if(trans.compareToIgnoreCase("yes") == 0) {
				EntoHin  eth = new EntoHin();
				data_trans = eth.doit(data);
				File query1 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query1.txt");
				File query2 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query2.txt");
				query1.createNewFile();
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
			}else {
				File query1 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query1.txt");
				query1.createNewFile();
				FileWriter fw1 = new FileWriter(query1.getAbsoluteFile(),true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(data);
				bw1.close();
				genFile gf = new genFile();
				EnFileUploader efu = new EnFileUploader();
				efu.fileUpload(gf.convert(query1),query1.getName(),"no",1);
			}
		}else {
			if(trans.compareToIgnoreCase("yes") == 0) {
				HintoEn  eth = new HintoEn();
				data_trans = eth.doit(data);
				File query1 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query1.txt");
				File query2 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query2.txt");
				query1.createNewFile();
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
			}else {
				File query1 = new File("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/query1.txt");
				query1.createNewFile();
				FileWriter fw1 = new FileWriter(query1.getAbsoluteFile(),true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(data);
				bw1.close();
				genFile gf = new genFile();
				HinFileUploader hfu = new HinFileUploader();
				hfu.fileUpload(gf.convert(query1),query1.getName(),"no",1);
			}
			
		}
	}
}
