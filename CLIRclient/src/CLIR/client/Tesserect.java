package CLIR.client;

import java.io.File;
import net.sourceforge.tess4j.*;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.net.URL;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;

public class Tesserect {
    
    public String convert(File f) {
        //File imageFile = new File("eurotext.tif");
        //Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
        String r = "";
        try {
        	//System.out.println("aaya");
            String result = instance.doOCR(f);
            //System.out.println("hogaya");
          //  System.out.println(result);
            return result;
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return r;
    }
}