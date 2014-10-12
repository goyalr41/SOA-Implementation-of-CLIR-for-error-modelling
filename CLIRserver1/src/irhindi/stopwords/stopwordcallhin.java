package irhindi.stopwords;

import irhindi.stemming.Stemhin;

import java.io.File;
import java.io.IOException;
import java.net.URL;





public class stopwordcallhin {
	File f1;
	public void call(File f, String filename, int query) throws IOException{

			//File f = new File("C:/Users/hp/"+filename+"_toprocdata");
			//System.out.println(f.length());
			stopwordhin stw = new stopwordhin();
			f1 = stw.stopit(f);
			Stemhin stem = new Stemhin();
			//url = stopworden.class.getClassLoader().getResource("/Temp/"+filename+"_toprocdata_stop");
			//f = new File(url.getPath());
			//f = new File("C:/Users/hp/"+filename+"_toprocdata_stop");
			System.out.println("Stop Word Removed");
			stem.stemmer(f1,filename,query);
			
		}
		
	
}
