package CLIR.client;

import irenglish.upload.EnFileUploader;
import irenglish.upload.EnFileUploaderServiceLocator;
import irhindi.upload.HinFileUploader;
import irhindi.upload.HinFileUploaderServiceLocator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;


import javax.xml.bind.annotation.XmlType;
import javax.xml.rpc.ServiceException;

import CLIR.server.FileUploader;
import CLIR.server.FileUploaderServiceLocator;

public class GUIinteractor {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 * 
	 */
	
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
	 
	public void upload(File f,String lang, String Type) throws FileNotFoundException, IOException, ServiceException {
		if(Type.compareToIgnoreCase("text") != 0){
			Tesserect tes = new Tesserect();
			String h = tes.convert(f);
			f = filewrite(h);
			
		}
		
		if(lang.compareToIgnoreCase("english") == 0){
			genFile gf = new genFile();
			
			EnFileUploaderServiceLocator locator1 = new EnFileUploaderServiceLocator();
			EnFileUploader requestor1 = locator1.getEnFileUploader();
		
			requestor1.fileUpload(gf.convert(f),f.getName(),"no",0);
			
		}
		
		if(lang.compareToIgnoreCase("hindi") == 0){
			genFile gf = new genFile();

			HinFileUploaderServiceLocator locator1 = new HinFileUploaderServiceLocator();
			HinFileUploader requestor1 = locator1.getHinFileUploader();
			
			requestor1.fileUpload(gf.convert(f),f.getName(),"no",0);
			
		}
	}


}
