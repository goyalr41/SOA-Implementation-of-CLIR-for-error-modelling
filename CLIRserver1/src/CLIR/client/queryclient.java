package CLIR.client;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import CLIR.server.Query;

public class queryclient {
	public static String Englishquery = "";
	public static String Hindiquery = "";
	public static List<String> Enlist = new ArrayList<String>();
	public static List<String> Hinlist = new ArrayList<String>();
	
	public void query(String querytext, String Lang, String Trans) throws Exception {
		Enlist = new ArrayList<String>();
		Hinlist = new ArrayList<String>();
		Englishquery = "";
		Hindiquery = "";
	Query qu = new Query();
	byte[] file = qu.query(querytext.toLowerCase().trim(), Lang.toLowerCase().trim(), Trans.toLowerCase().trim());
	
	File fil = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+"solution123.txt");
	//File file = new File("C:/Users/hp/"+filename+"_toprocdata");
	fil.delete();
	fil.createNewFile();
	FileOutputStream fos = new FileOutputStream(fil);
	fos.write(file);
	fos.close();
	
	final String EoL = System.getProperty("line.separator");
	List<String> lines = Files.readAllLines(Paths.get("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+"solution123.txt"),
	        Charset.defaultCharset());

	StringBuilder sb = new StringBuilder();
	for (String line : lines) {
	    sb.append(line).append(EoL);
	}
	final String content = sb.toString();
	//"!@#$%^&"
	String[] dat = content.split("<>");
	//System.out.println(dat[0]);
	Englishquery = dat[0];
	Hindiquery = dat[2];
	String[] endo = dat[1].trim().split(",");
	String[] hindo = dat[3].trim().split(",");
	
	for(int i = 0; i < endo.length; i = i+2) {
		if(i+1 < endo.length) {
			if(endo[i+1].compareToIgnoreCase("NaN") != 0 && endo[i+1].compareTo("0.0") != 0) {
				Enlist.add(endo[i] + "   ---------->    " + endo[i+1]);
			}else{
				break;
			}
		}
	}
	
	for(int i = 0; i < hindo.length; i = i+2) {
		if(i+1 < hindo.length) {
			if(hindo[i+1].compareToIgnoreCase("NaN") != 0 && hindo[i+1].compareTo("0.0") != 0) {
				Hinlist.add(hindo[i] + "   ---------->    " + hindo[i+1]);
			}else{
				break;
			}
		}
	}
	
	System.out.println(Englishquery);
	System.out.println(Enlist);
	System.out.println(Hindiquery);
	System.out.println(Hinlist);
	
}
	
	/*public static void main(String[] args) throws Exception {
		Query qu = new Query();
		byte[] file = qu.query("agriculture", "english", "no");
		
		File fil = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+"solution123.txt");
		//File file = new File("C:/Users/hp/"+filename+"_toprocdata");
		fil.delete();
		fil.createNewFile();
		FileOutputStream fos = new FileOutputStream(fil);
		fos.write(file);
		fos.close();
		
		final String EoL = System.getProperty("line.separator");
		List<String> lines = Files.readAllLines(Paths.get("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+"solution123.txt"),
		        Charset.defaultCharset());

		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
		    sb.append(line).append(EoL);
		}
		final String content = sb.toString();
		//"!@#$%^&"
		String[] dat = content.split("<>");
		//System.out.println(dat[0]);
		Englishquery = dat[0];
		Hindiquery = dat[2];
		String[] endo = dat[1].trim().split(",");
		String[] hindo = dat[3].trim().split(",");
		
		for(int i = 0; i < endo.length; i = i+2) {
			if(i+1 < endo.length) {
				if(endo[i+1].compareToIgnoreCase("NaN") != 0 && endo[i+1].compareTo("0.0") != 0) {
					Enlist.add(endo[i]);
				}else{
					break;
				}
			}
		}
		
		for(int i = 0; i < hindo.length; i = i+2) {
			if(i+1 < hindo.length) {
				if(hindo[i+1].compareToIgnoreCase("NaN") != 0 && hindo[i+1].compareTo("0.0") != 0) {
					Hinlist.add(hindo[i]);
				}else{
					break;
				}
			}
		}
		
		System.out.println(Englishquery);
		System.out.println(Enlist);
		System.out.println(Hindiquery);
		System.out.println(Hinlist);
		
	}*/
}
