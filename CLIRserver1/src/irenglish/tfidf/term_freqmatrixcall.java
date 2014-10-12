package irenglish.tfidf;

import irenglish.upload.EnFileUploader;

import java.io.File;
import java.io.IOException;

import CLIR.server.FileUploader;

public class term_freqmatrixcall {
	public void call(File doc,String filename,int query) throws IOException {
		if(query == 0) {
	 term_freqmatrix ob  = new term_freqmatrix();
     term_freqmatrix.filenameset = EnFileUploader.Endoc;
     //ob.filematrix_read();
     //System.out.println("printing matrix after constructions from file");
     //ob.print();
	 ob.fileread(doc,filename);
	// ob.print();
	 ob.filematrix_write();
	 //do for wrd not existing in corpus
	 ob.doc_maxfreq_word();
	 ob.tfidf();
	 //ob.print_tfidf();
	 //ob.query_tfidf("hello pramiti");
	 //ob.cosine_sim("hello pramiti");
		}else {
			 term_freqmatrix ob  = new term_freqmatrix();
		     term_freqmatrix.filenameset = EnFileUploader.Endoc;
		     ob.filematrix_read();
		//     System.out.println("printing matrix after constructions from file");
		    // ob.print();
		     
			 //ob.fileread(doc,filename);
			 //ob.print();
			 //ob.filematrix_write();
			 //do for wrd not existing in corpus
			 ob.doc_maxfreq_word();
			 ob.tfidf();
			// ob.print_tfidf();
			 ob.query_tfidf(filename);
			 ob.cosine_sim(filename);
			return;
		}
	}
}
