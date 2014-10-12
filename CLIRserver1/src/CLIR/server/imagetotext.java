package CLIR.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.net.URL;

import javax.xml.bind.annotation.XmlType;
import java.io.IOException;

import net.sourceforge.tess4j.*;

public class imagetotext {

    public static void main(String[] args) {
    	File file = new File("D:\\00000001.tif");
    	//File file = new File("C:/Users/hp/"+filename+"_toprocdata");
    	/*FileOutputStream fos = new FileOutputStream(file);
    	fos.write(myFile);
    	fos.close();*/
       // File imageFile = new File("D:\\eurotext.tif");
        //Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping

        try {
            String result = instance.doOCR(file);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}