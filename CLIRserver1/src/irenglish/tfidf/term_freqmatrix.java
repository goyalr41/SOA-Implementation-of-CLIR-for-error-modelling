package irenglish.tfidf;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



public class term_freqmatrix {
    
	//List<HashMap< String, Integer> >
	public static HashMap<String, HashMap<String,Integer>> fmatrix = new HashMap<String, HashMap<String,Integer>>();;
	HashMap<String, HashMap<String,Double>> tfidf;
	public static  HashMap<String,Double> final_resen = new HashMap<String,Double>(); 
	public static  Set<String> filenameset = new HashSet<String>();
	HashMap<String,Double> query_tfidf;
	HashMap<String,Integer> doc_maxfreqword;
	HashMap<String, Double> idf ;
	Set<String> q_wrds = new HashSet<String>();
	Map <String,Double> quer_freq = new HashMap<String,Double>();
	
	/*public term_freqmatrix()
	{    
		//HashMap<String,Integer> temp= new HashMap<String,Integer>();
		fmatrix = 
				
	}*/
	//to make matrix from file
	public void makefmatrix_file(String wrd, String docname, String freq)
	{    
		//System.out.printf("%s : %s => %s \n", wrd, docname, freq);
		if (fmatrix.isEmpty()) {
			HashMap<String, Integer> temp= new HashMap<String, Integer>();
			int num = Integer.parseInt(freq);
		    temp.put(docname, num);
		    fmatrix.put(wrd, temp);
		} else
		{
			HashMap<String, Integer> temp = new HashMap<String, Integer>();
			int num = Integer.parseInt(freq);
			if (fmatrix.containsKey(wrd)) {
					temp = fmatrix.get(wrd);
					temp.put(docname, num);
					//System.out.println(docname);
					fmatrix.put(wrd, temp);
			} else {
				temp.put(docname, num);
				
				fmatrix.put(wrd, temp);
			}
					
		}
	}
	///////////////to update matrix for uploaded document////////////////////////////////////////////////////////////
	public void makefmatrix(String wrd, String docname)
	{
		//try {
		//System.out.println(fmatrix.isEmpty());
		//}
		if (fmatrix.isEmpty()) {
			HashMap<String, Integer> temp= new HashMap<String, Integer>();
		    temp.put(docname, 1);
		    fmatrix.put(wrd, temp);
		} else
		if (fmatrix.containsKey(wrd)) {
			HashMap<String, Integer> temp= new HashMap<String, Integer>();
			temp = fmatrix.get(wrd);
			if(temp.containsKey(docname)) {
				Integer n = (Integer) temp.get(docname);
				n = n +1;
				temp.put(docname, n);
				fmatrix.put(wrd, temp);
			} else {
				temp.put(docname, 1);
				fmatrix.put(wrd, temp);
			}
		} else {
			HashMap temp = new HashMap<String, Integer>();
			temp.put(docname, 1);
			fmatrix.put(wrd, temp);
					
		}
	
	}

	void print()
	{
			
		/*for(Map.Entry<String, HashMap<String, Integer>> entry : fmatrix.entrySet()){
		    HashMap<String, Integer> temp = entry.getValue();
		    String word = entry.getKey();
		    for (Map.Entry<String, Integer> abc:temp.entrySet()) {
		    //String doc = temp.get(arg0);
 			System.out.printf("%s: %s => %s %n", word, abc.getKey(), abc.getValue());
		}*/
		//}

		
	}
	///////////////////////////////writing  matrix into file /////////////////////////////////////////////////////////
	void filematrix_write() throws IOException
	{  
		
		File file = new File("C:/Users/hp/workspace/CLIRserver1/src/irenglish/data/tfidf.txt");
        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);   
        
		for(Map.Entry<String, HashMap<String, Integer>> entry : fmatrix.entrySet()){
		    HashMap<String, Integer> temp = entry.getValue();
		    String word = entry.getKey();
		    out.write(word);
		    for (Map.Entry<String, Integer> abc:temp.entrySet()) {
		    //String doc = temp.get(arg0);
		    	out.write(",");
                out.write(abc.getKey() );
                out.write(",");
                out.write(abc.getValue().toString());
               // out.write(",");
 			//System.out.printf("%s: %s => %s %n", word, abc.getKey(), abc.getValue());
		}
		    out.write("\n");
		}
		out.close();
			
		

	}
	/////////////////reading matrix form file///////////////////////////////////////////////////////////////////
	public void filematrix_read(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("C:/Users/hp/workspace/CLIRserver1/src/irenglish/data/tfidf.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String line = null;
		
		try {
			while ((line = reader.readLine()) != null) {
				String [] tokens = line.split(",");
				for (int i = 0; i < tokens.length / 2; i++) {
					//System.out.println("token =  " + tokens[i]);
					if (!tokens[i].equalsIgnoreCase(null))
						makefmatrix_file(tokens[0], tokens[ 2 * i + 1], tokens[ 2 * i + 2] );
				}		
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	////////////////////////////traversing word by word of uploaded doc <filename>///////////////////////////////////
	public void fileread(File doc,String filename) {
	BufferedReader reader = null;
	try {
		reader = new BufferedReader(new FileReader(doc));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String line = null;
	
	try {
		while ((line = reader.readLine()) != null) {
			String [] tokens = line.split(" ");
			for (int i = 0; i < tokens.length; i++) {
				//System.out.println("token =  " + tokens[i]);
				if (!tokens[i].equalsIgnoreCase(null))
					makefmatrix(tokens[i], filename);
			}		
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	void print_tfidf()
	{
		 /* System.out.println("printing tfidffff\n");	
		for(Map.Entry<String, HashMap<String, Double>> entry : tfidf.entrySet()){
		    HashMap<String, Double> temp = entry.getValue();
		    String word = entry.getKey();
		  
		    for (Map.Entry<String, Double> abc:temp.entrySet()) {
		    //String doc = temp.get(arg0);
		      	System.out.printf("%s: %s => %s %n", word, abc.getKey(), abc.getValue());
		}
		}*/
	//	System.out.println(idf);

		
	}
	// for normalised tf
	void  doc_maxfreq_word()
	{   
		doc_maxfreqword = new HashMap<String,Integer>();
		int total = filenameset.size();
		
		Iterator<String> iter = filenameset.iterator();
		while (iter.hasNext()) {
		  String docname = iter.next();
		  //System.out.println(docname);
		  int max = 0;
		  int val = 0;
		  for(Map.Entry<String, HashMap<String, Integer>> entry : fmatrix.entrySet()){
		    HashMap<String, Integer> temp = entry.getValue();
		    String word = entry.getKey();
		    if (temp.containsKey(docname)) {
		    		val = temp.get(docname);
		            if (max < val)
		    	       max = val;
		    }
		  }
		  doc_maxfreqword.put(docname, max);
		}
		
	}
	void tfidf()
    {
    	
		//for(Map.Entry<String, HashMap<String, Integer>> entry : fmatrix.entrySet()){
    	//String [] wrd = query.split("\\s+");
    	tfidf=new HashMap<String, HashMap<String,Double>>();
    	idf = new HashMap<String, Double>();
    	//for (int i = 0; i < wrd.length; i++) {
    	for(Map.Entry<String, HashMap<String, Integer>> entry : fmatrix.entrySet()){
		    HashMap<String, Integer> temp = entry.getValue();
		    String word = entry.getKey();
		    double totaldocs = filenameset.size();
		    
		    //System.out.println("totdocs ==> " + totaldocs);
		    //System.out.println("totaldocs " + totaldocs);
		   // for (Map.Entry<String, Integer> abc:temp.entrySet()) {
    		   
		    	//if (fmatrix.containsKey(wrd[i])) {
		    			//HashMap<String, Integer> temp = fmatrix.get(word);
		    			double docperword = temp.size();
		    			
		    			//System.out.println(word + " is present in totaldocs " + wordperdoc);
		    			double va = Math.log(totaldocs/(docperword))/Math.log(2);
		    			double idfval = va;
		    			
		    			 //System.out.println("\n idfval of wrd[i]" + idfval + "  " + word + "\n");
		    			idf.put(word, idfval);
		    	
		 }
    	
    	
    	//storing map doument vs words
    	for(Map.Entry<String, HashMap<String, Integer>> entry : fmatrix.entrySet()){
		    HashMap<String, Integer> temp = entry.getValue();
		    String word = entry.getKey();
		    //for (Map.Entry<String, Integer> abc:temp.entrySet()) {
    	  //  System.out.println("tfidfcalculation" + word + "\n");
			  //if (fmatrix.containsKey(wrd[i])) {
			       //HashMap<String, Integer> temp = fmatrix.get(wrd[i]);
		           HashMap<String, Double> temp1= new HashMap<String, Double>();
		           for (Map.Entry<String, Integer> abc:temp.entrySet()) {
		                String docn = abc.getKey();
		        	    //System.out.printf("inti%s: %s => %s %n", word, abc.getKey(), abc.getValue());
		        	    Double normtf = (double)abc.getValue()/(doc_maxfreqword.get(docn));//make fn docsize();
		    		    Double wtd = (double) abc.getValue() * idf.get(word);
		    		    //System.out.println("wtd of wrd[i]" + wtd + "  " + word + "\n");
		                String docname = abc.getKey();
		                
		                
		                if (tfidf.isEmpty()) {
		        			temp1= new HashMap<String, Double>();
		        		    temp1.put(word, wtd );
		        		    tfidf.put(docname, temp1);
		                } else if (tfidf.containsKey(docname)) {
		                	temp1= new HashMap<String, Double>();
		                	temp1 = tfidf.get(docname);
		    	        	//System.out.println("docname and temp1 isssssssss " + docname + "   "  + temp1 + "\n" );
		    	        	temp1.put(word, wtd);
		    	            tfidf.put(docname, temp1 );
		                } else {
		                	temp1= new HashMap<String, Double>();
		    	        	temp1.put(word, wtd);
		    	        	tfidf.put(docname, temp1);
		    	        }
		    
		   }
		    
		  }
    	}
	    
	void query_tfidf(String q)
	{  
		//System.out.println("totaldocs == " + filenameset.size());
		 query_tfidf = new HashMap<String,Double>();
	
		String [] wrd = q.split(" ");
		double ma = 1;
		double total = wrd.length;
		//Map <String,Double> quer_freq = new HashMap<>();
	//	Set<String> q_wrds = new HashSet<>();
		
		for(int i = 0;i < total; i++){
			String q_word = wrd[i];
			q_wrds.add(q_word);
			if(quer_freq.containsKey(q_word)){
				double va = quer_freq.get(wrd[i]);
				quer_freq.put(q_word,va+1);
				if(ma < va + 1){
					ma = va + 1;
				}
			}else{
				quer_freq.put(q_word,1.0);
			}
		}
		Iterator it = q_wrds.iterator();
		while(it.hasNext()){
			Object p = (Object)(it.next());
			String wr = p.toString();
			double que = quer_freq.get(wr);
			
			if (idf.containsKey(wr)) {
			    Double val = idf.get(wr);
			    double qti = ((double)que/(double)ma) * val;
			//    System.out.println("word == " + wr + " qti == " + qti);
			    query_tfidf.put(wr, qti );
			}
		}    	
	}
	 public <K extends Comparable,V extends Comparable> Map<K,V> desc_sortByValues(Map<K,V> map){
	        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
	      
	        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

	            @Override
	            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
	                return o2.getValue().compareTo(o1.getValue());
	            }
	        });
	      
	        //LinkedHashMap will keep the keys in the order they are inserted
	        //which is currently sorted on natural ordering
	        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
	      
	        for(Map.Entry<K,V> entry: entries){
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }
	      
	        return sortedMap;
	    }
	    
	HashMap<String,Double> cosine_sim(String q)
	{
		final_resen = null;
		String [] wrd = q.split(" ");
		int total = wrd.length;
		HashMap<String, Double> doclen = new HashMap<String,Double>();
		
		double qlen = 0;
		
		Iterator it = q_wrds.iterator();
		
		while(it.hasNext()){
			Object p = (Object)(it.next());
			String wr = p.toString();
			if(query_tfidf.containsKey(wr)) {
			double que = query_tfidf.get(wr);		
			qlen = qlen + (que*que);
			}
		}
		double sq_qlen = Math.sqrt(qlen);
		
		for(Map.Entry<String, HashMap<String, Double>> entry : tfidf.entrySet()){
		    HashMap<String, Double> temp = entry.getValue();
		    String docname = entry.getKey();
		    double dlen = 0;
		    double dqlen = 0;
		    
		    for(Map.Entry<String, Double> weights : temp.entrySet()){
			    double wt = weights.getValue();
			    dlen = dlen + wt*wt;
		    }
			 
		    double sq_doclen = Math.sqrt(dlen);
		    doclen.put(docname, sq_doclen);   
		}
		//calculating wt of eac doc and query
		HashMap<String, Double> final_result = new HashMap<String,Double>();
		
		for(Map.Entry<String, HashMap<String, Double>> entry : tfidf.entrySet()){
		    HashMap<String, Double> temp = entry.getValue();
		    String docname = entry.getKey();
		    double dlen = 0;
		    double wght = 0;
		    it = q_wrds.iterator();
		    
			while(it.hasNext()){
				Object p = (Object)(it.next());
				String wr = p.toString();
				
				if(temp.containsKey(wr)){
					double val = temp.get(wr);
					if(query_tfidf.containsKey(wr)) {
					double que = query_tfidf.get(wr);
					dlen = dlen + (que * val);
					}
				}
			}
		     double cos_doc_q = dlen/( sq_qlen * doclen.get(docname) );
		     //System.out.println("ddddddddddd " + dlen + " " + sq_qlen+ " "+ (doclen.get(docname) ));
		     final_result.put(docname, cos_doc_q);  
		}
		final_resen = (HashMap<String,Double>) desc_sortByValues(final_result);
		//System.out.println("printing final doc weight values");
		 for (Map.Entry<String, Double> abc: final_resen.entrySet()) {
			    //String doc = temp.get(arg0);
	 			//System.out.printf("%s => %s \n", abc.getKey(), abc.getValue());
		}
		return final_resen;
	}
}
