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
import java.util.HashMap;
import java.util.Map;
import englisherrorcorrection.Vocabulary;
import englisherrorcorrection.edist;
import englisherrorcorrection.error_check;
import englisherrorcorrection.replacing_word;


public class NER2 {

    public Map<String,String> maint(String corword) throws IOException {
        String inc_word = corword;
        String serializedClassifier = "C:/Users/hp/workspace/CLIRserver1/jars/stanford-ner-2014-01-04/classifiers/english.all.3class.distsim.crf.ser.gz";
      File new_file = new File("C:/Users/hp/workspace/CLIRserver1/src/Temp/englisherror.txt");  
      new_file.delete();
      new_file.createNewFile();
      
        FileWriter fstream = new FileWriter(new_file);
        BufferedWriter out_write = new BufferedWriter(fstream);   
        
        out_write.write(inc_word);
        out_write.close();
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
        
       // String serializedClassifier = "C:/Users/hp/workspace/CLIRserver1/jars/stanford-ner-2014-01-04/classifiers/english.all.3class.distsim.crf.ser.gz";
 //-------------------------------------------------------------------------------------------------------
        
      AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);

      String filename = "C:/Users/hp/workspace/CLIRserver1/src/Temp/englisherror.txt";
 
        String fileContents = IOUtils.slurpFile(filename);
        List<List<CoreLabel>> out = classifier.classify(fileContents);
        
        error_check obj = new error_check();
        edist dis_ob = new edist();
        replacing_word rep_obj = new replacing_word();
        
        Map<String,String> res = new HashMap<String,String>();
        
        for (List<CoreLabel> sentence : out) {
            for (CoreLabel word : sentence) {
              String text = word.word();
              String form = word.get(CoreAnnotations.AnswerAnnotation.class);
              //System.out.println(text);
              if(obj.isNumeric(text)){
                  //System.out.println("num");
                  res.put(text,"Numeric");
              }else if( (form.compareTo("PERSON") == 0) || form.compareTo("LOCATION")== 0 ){
                  res.put(text,form);
                 // return res;
                  //System.out.println("NER");
              }else{
                    String text1 = text.toLowerCase();
                 //   System.out.println(text1);
                     boolean check = obj.checkword(text1);
                     if(check == true)
                     {
                        res.put(text,"Correct Word");
                       // return res;
                         
                     }else{
                         String errorword = text1;
                        // System.out.println("incorrect word " + text1);
                         int x = obj.correct(errorword);
                         if(x == 0){
                             res.put(text,"Replacement not found");
                         }else{
                         dis_ob.bestmatch(errorword);
                         String replaced_word = rep_obj.bestword();
                         res = rep_obj.distances();
                         }
                    }
               } 
              
           }
         // return res;
              //System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
        }
        
         // System.out.println(res);
		return res;
    }
}