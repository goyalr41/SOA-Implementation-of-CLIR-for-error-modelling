package translation;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class Translation1 {
	 public static void main(String[] args) throws Exception {
		
		     // Set your Windows Azure Marketplace client info - See http://msdn.microsoft.com/en-us/library/hh454950.aspx
		     Translate.setClientId("CLIRram");
		     Translate.setClientSecret("3jmZAtdVhHYPsI5JhD2QkOOoAt3uBknRyTZDlRpK5tw=");

		     String translatedText = Translate.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);

		     System.out.println(translatedText);
		   
		 
	 }
	 
}
