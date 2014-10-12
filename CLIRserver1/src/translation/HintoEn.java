package translation;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class HintoEn {
	public String doit(String s) throws Exception{
		System.out.println("Hindi to English Translation called");
		  Translate.setClientId("CLIRram");
		     Translate.setClientSecret("3jmZAtdVhHYPsI5JhD2QkOOoAt3uBknRyTZDlRpK5tw=");

		     String translatedText = Translate.execute(s, Language.HINDI, Language.ENGLISH);

		     System.out.println(translatedText);
		     return translatedText;
	}
}
