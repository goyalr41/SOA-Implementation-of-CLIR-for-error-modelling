package irhindi.punctuation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class punchin {

	/**
	 * @param args
	 */
	public long timeStamp;
	public File file;

	public boolean isFileUpdated( File file ) {
	  this.file = file;
	  long timeStamp = file.lastModified();

	  if( this.timeStamp != timeStamp ) {
	    this.timeStamp = timeStamp;
	    //Yes, file is updated
	    return true;
	  }
	  //No, file is not updated
	  return false;
	}
	
	public Set<String> punc;
	
	public File puncit(File Doc) throws IOException {
		punc = new HashSet<String>();
		URL url = getClass().getResource("punchin.txt");
		File f = new File(url.getPath());
			punc.clear();
			FileReader fr = new FileReader(f);
			char[] chars = new char[(int) f.length()];
		    fr.read(chars);
		    String enstop = new String(chars);
		    fr.close();
		    String[] temp = enstop.split("V");
		    for(String s : temp) {
		    	punc.add(s);
		    }
			
		
		
		
		File file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+Doc.getName()+"_punc");

		// if file doesnt exists, then create it
		//if (!file.exists()) {
			file.createNewFile();
		//}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		FileInputStream fs = new FileInputStream(Doc);
		Scanner sc1 = new Scanner(fs);
		while(sc1.hasNextLine()) {
			Scanner sc2 = new Scanner(sc1.nextLine());
			while(sc2.hasNext()) {
				Iterator it = punc.iterator();
				String s = sc2.next();
				while(it.hasNext()) {
					Object p = it.next();
					String X =(String) p;
					s = s.replace(X, "");
				}
				
					bw.write(s+" ");
				
			}
			sc2.close();
		}
		sc1.close();
		bw.close();
		return file;
		
		
	}
	/*public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		URL url = stopworden.class.getResource("test.txt");
		File f = new File(url.getPath());
		System.out.println(f.length());
		stopworden stw = new stopworden(f);
		
	}*/
}
