package CLIR.client;

import irenglish.upload.EnFileUploader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Enfileuploaderclient {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		URL url = Enfileuploaderclient.class.getResource("Engtest.txt");
		File f1 = new File(url.getPath());
		genFile gf = new genFile();
		EnFileUploader efu = new EnFileUploader();
		efu.fileUpload(gf.convert(f1),"nnnkiii","yes",0);
	}
}
