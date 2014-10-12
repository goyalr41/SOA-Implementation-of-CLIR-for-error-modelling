package irhindi.punctuation;

import hindierrorcorrection.hindierrorcall;
import irenglish.stopwords.stopwordcallen;
import irhindi.stopwords.stopwordcallhin;

import java.io.File;
import java.io.IOException;
import java.net.URL;





public class punccallhin {
	File f1;
	public void call(File f, String filename, String error, int query) throws IOException{

			//File f = new File("C:/Users/hp/"+filename+"_toprocdata");
			//System.out.println(f.length());
		if(error.compareTo("no") == 0) {
			punchin stw = new punchin();
			f1 = stw.puncit(f);
			stopwordcallhin stc = new stopwordcallhin();
			System.out.println("Punctuation Removed");
			stc.call(f1,filename,query);
			//Stemen stem = new Stemen();
			//url = stopworden.class.getClassLoader().getResource("/Temp/"+filename+"_toprocdata_stop");
			//f = new File(url.getPath());
			//f = new File("C:/Users/hp/"+filename+"_toprocdata_stop");
			
			//stem.stemmer(f1,filename);
			
		}
	else {
		punchin stw = new punchin();
		f1 = stw.puncit(f);
		hindierrorcall hec = new hindierrorcall();
		File f2 = hec.processerr(f1, f1.getName());
		stopwordcallhin stc = new stopwordcallhin();
		System.out.println("Punctuation Removed");
		stc.call(f2,filename,query);
		//Stemen stem = new Stemen();
		//url = stopworden.class.getClassLoader().getResource("/Temp/"+filename+"_toprocdata_stop");
		//f = new File(url.getPath());
		//f = new File("C:/Users/hp/"+filename+"_toprocdata_stop");
		
	}
	}
		
	
}
