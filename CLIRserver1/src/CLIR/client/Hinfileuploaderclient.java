package CLIR.client;

import irenglish.upload.EnFileUploader;
import irhindi.upload.HinFileUploader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Hinfileuploaderclient {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		URL url = Hinfileuploaderclient.class.getResource("Hintest.txt");
		File f1 = new File(url.getPath());
		genFile gf = new genFile();
		HinFileUploader hfu = new HinFileUploader();
		hfu.fileUpload(gf.convert(f1),"k577tttt7","yes",0);
	}
}
