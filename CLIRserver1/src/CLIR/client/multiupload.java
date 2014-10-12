package CLIR.client;

import irenglish.upload.EnFileUploader;
import irhindi.upload.HinFileUploader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class multiupload {
	
	  void read_corpus(final File folder) throws FileNotFoundException, IOException
	    {
	        for (final File fileEntry : folder.listFiles()) {
	            if (fileEntry.isDirectory()) {
	                read_corpus(fileEntry);
	        
	            } else {
	               process(fileEntry);
	            }
	        }
	    }
	  
	  void process(File inp_file) throws IOException
	   {

			genFile gf = new genFile();
			EnFileUploader hfu = new EnFileUploader();
			hfu.fileUpload(gf.convert(inp_file),inp_file.getName(),"no",0);
	    }
	  
	public static void main(String[] args) throws FileNotFoundException, IOException {
		    multiupload ob = new multiupload();
	        final File folder = new File("E:\\final_data");
	        ob.read_corpus(folder);
	}
}
