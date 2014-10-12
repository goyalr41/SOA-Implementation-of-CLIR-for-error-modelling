package irenglish.punctuation;

import irenglish.stemming.Stemen;
import irenglish.stopwords.stopwordcallen;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import englisherrorcorrection.NER;


public class punccallen {
	File f1;
	public void call(File f, String filename, String error, int query) throws IOException{

			//File f = new File("C:/Users/hp/"+filename+"_toprocdata");
			//System.out.println(f.length());
		if(error.compareTo("no") == 0) {
		   puncen stw = new puncen();
			f1 = stw.puncit(f);
			stopwordcallen stc = new stopwordcallen();
			System.out.println("Punctuation Removed");
			stc.call(f1,filename,query);
			//Stemen stem = new Stemen();
			//url = stopworden.class.getClassLoader().getResource("/Temp/"+filename+"_toprocdata_stop");
			//f = new File(url.getPath());
			//f = new File("C:/Users/hp/"+filename+"_toprocdata_stop");
			
			//stem.stemmer(f1,filename);*/
		} else {

			puncen stw = new puncen();
			f1 = stw.puncit(f);
			NER ner = new NER();
			File g = ner.processNer(f1);
			stopwordcallen stc = new stopwordcallen();
			System.out.println("Punctuation Removed");
			stc.call(g,filename,query);
			//Stemen stem = new Stemen();
			//url = stopworden.class.getClassLoader().getResource("/Temp/"+filename+"_toprocdata_stop");
			//f = new File(url.getPath());
			//f = new File("C:/Users/hp/"+filename+"_toprocdata_stop");
	
			//stem.stemmer(f1,filename);
			
		}
		
		}
		
	
}
