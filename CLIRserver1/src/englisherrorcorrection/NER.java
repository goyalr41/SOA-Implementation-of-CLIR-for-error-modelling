package englisherrorcorrection;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.*;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.List;
import java.io.IOException;
import englisherrorcorrection.Vocabulary;
import englisherrorcorrection.edist;
import englisherrorcorrection.error_check;
import englisherrorcorrection.replacing_word;


public class NER {

    public File processNer(File file) throws IOException {
    	
    	System.out.println("NER called");

      String serializedClassifier = "C:/Users/hp/workspace/CLIRserver1/jars/stanford-ner-2014-01-04/classifiers/english.all.3class.distsim.crf.ser.gz";

// Wordlist bigrams----------------------------------------------------------------------------------
      File inp_file = new File("C:/Users/hp/workspace/CLIRserver1/src/englisherrorcorrection/word_list_moby_crossword.flat.txt");
       
       //   File inp_file = new File("D:\\words.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(inp_file));
        String line;
        
        Vocabulary ob = new Vocabulary();
        while ((line = br.readLine()) != null) {
            ob.arrange(line);
        }
        ob.write_file();
 //-------------------------------------------------------------------------------------------------------
        
      AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
//      String filename = "D:\\6sem\\project\\agriculture_domain_parallel_corpus\\parallel corpus\\english/thread96.English";
      String filename = file.getAbsolutePath();
    		  //"D:\\xyz.txt";
        String fileContents = IOUtils.slurpFile(filename);
        List<List<CoreLabel>> out = classifier.classify(fileContents);
        
        error_check obj = new error_check();
        edist dis_ob = new edist();
        replacing_word rep_obj = new replacing_word();
        
        File new_file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/"+file.getName()+"ercor.txt");
        FileWriter fstream = new FileWriter(new_file);
        BufferedWriter out_write = new BufferedWriter(fstream);   
                
        for (List<CoreLabel> sentence : out) {
          out_write.write("\n");
            for (CoreLabel word : sentence) {
              String text = word.word();
              String form = word.get(CoreAnnotations.AnswerAnnotation.class);
              
              if(obj.isNumeric(text)){
            	  out_write.write(text);
              }else if( (form.compareTo("PERSON") == 0) || form.compareTo("LOCATION")== 0 ){
                  out_write.write(text);
                  System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
              }else{
            	  	String text1 = text.toLowerCase();
                     boolean check = obj.checkword(text1);
                     if(check == true)
                     {
                         System.out.println("correct word");
                         out_write.write(text);
                     }else{
                         String errorword = text;
                         System.out.println("incorrect word" + text1);
                         int x = obj.correct(errorword);
                         if(x == 0){
                        	 System.out.println(x);
                        	 out_write.write(text1);
                         }else{
                         dis_ob.bestmatch(errorword);
                         String replaced_word = rep_obj.bestword();
                         System.out.println("replaced word = " + replaced_word);
                         out_write.write(replaced_word);
                         }
                      }
               } 
              out_write.write(" ");
           }
          out_write.write("\n");
              //System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
        }
        out_write.close();
        return new_file;
         // System.out.println();
    }
}