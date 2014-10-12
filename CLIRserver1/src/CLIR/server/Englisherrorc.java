package CLIR.server;

import java.io.IOException;
import java.util.Map;

import englisherrorcorrection.NER2;

public class Englisherrorc {
	public String[] correct (String corword) throws IOException{
		NER2 ner = new NER2();
		Map<String,String> res = ner.maint(corword);
		String[] s = new String[2*res.size()];
		int i = 0;
		for (Map.Entry<String, String> entry : res.entrySet()) { 
			String key = entry.getKey(); 
			s[i] = key; 
			s[i+1] = entry.getValue();
			i = i + 2;
		}
		return s;
		
	}
}
