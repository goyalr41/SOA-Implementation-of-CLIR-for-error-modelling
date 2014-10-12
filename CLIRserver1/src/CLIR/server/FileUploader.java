package CLIR.server;

import java.io.File;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.xml.bind.annotation.XmlType;

import irenglish.*;
import irenglish.punctuation.punccallen;
import irenglish.stopwords.stopwordcallen;
import irhindi.*;
import irhindi.punctuation.punccallhin;
import irhindi.stopwords.stopwordcallhin;


public class FileUploader {
	public static Set<String> Endoc = new HashSet<String>();
	public static Set<String> Hindoc = new HashSet<String>();
	
	public void fileUpload(byte[] myFile,String filename,String author, String type,int query) throws IOException {
	File file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+filename+"_toprocdata");
	//File file = new File("C:/Users/hp/"+filename+"_toprocdata");
	FileOutputStream fos = new FileOutputStream(file);
	fos.write(myFile);
	fos.close();

	
	if(type.compareTo("english")==0) {
		//imagetotext it = new imagetotext();
		//it.maint();
		
		File Docname = new File("C:/Users/hp/workspace/CLIRserver1/src/irenglish/data/Docname.txt");
		//System.out.println("File to mil rhi h");
		if(Endoc.isEmpty()) {
			
			Scanner sc1 = new Scanner(Docname);
			while(sc1.hasNextLine()) {
					String s = sc1.nextLine();
					Endoc.add(s);
					
			}
			sc1.close();
			
			FileWriter fw = new FileWriter(Docname.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			if(!Endoc.contains(filename)) {
				Endoc.add(filename);
				fw.append(filename+"\n");
				fw.close();
			}else {
				return;
			}
		}else {
			FileWriter fw = new FileWriter(Docname.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			if(!Endoc.contains(filename)) {
				Endoc.add(filename);
				fw.append(filename+"\n");
				fw.close();
			}else {
				return;
			}
		}
		punccallen ptc = new punccallen();
		ptc.call(file,filename,author,query);
		//stopwordcallen stc = new stopwordcallen();
		//stc.call(file,filename,author,type);
	}
	
	if(type.compareTo("hindi")==0) { 
		
		File Docname = new File("C:/Users/hp/workspace/CLIRserver1/src/irhindi/data/Docname.txt");
		//System.out.println("File to mil rhi h");
		if(Hindoc.isEmpty()) {
			
			Scanner sc1 = new Scanner(Docname);
			while(sc1.hasNextLine()) {
					String s = sc1.nextLine();
					Hindoc.add(s);
					
			}
			sc1.close();
			
			FileWriter fw = new FileWriter(Docname.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			if(!Hindoc.contains(filename)) {
				Hindoc.add(filename);
				fw.append(filename+"\n");
				fw.close();
			}else {
				return;
			}
		}else {
			FileWriter fw = new FileWriter(Docname.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			if(!Hindoc.contains(filename)) {
				Hindoc.add(filename);
				fw.append(filename+"\n");
				fw.close();
			}else {
				return;
			}
		}
		punccallhin ptc = new punccallhin();
		//ptc.call(file,filename,author,type);
		//stopwordcallhin stc = new stopwordcallhin();
		//stc.call(file,filename,author,type);
	}
	
	
	}
}
