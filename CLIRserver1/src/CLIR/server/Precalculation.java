package CLIR.server;

import irenglish.tfidf.*;
import irhindi.tfidf.*;
public class Precalculation {
	public void doit(){
		System.out.println("English TF");
		irenglish.tfidf.term_freqmatrix tfm = new irenglish.tfidf.term_freqmatrix();
		tfm.filematrix_read();
		System.out.println("Hindi TF");
		irhindi.tfidf.term_freqmatrix tfh = new irhindi.tfidf.term_freqmatrix();
		tfh.filematrix_read();
	}
}
