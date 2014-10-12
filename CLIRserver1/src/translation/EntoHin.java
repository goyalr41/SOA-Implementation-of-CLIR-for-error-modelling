package translation;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class EntoHin {
	public String doit(String s) throws Exception{
		System.out.println("English to Hindi Translation called");
		  Translate.setClientId("CLIRram");
		     Translate.setClientSecret("3jmZAtdVhHYPsI5JhD2QkOOoAt3uBknRyTZDlRpK5tw=");

		     String translatedText = Translate.execute(s, Language.ENGLISH, Language.HINDI);

		     System.out.println(translatedText);
		     return translatedText;
	}
}
