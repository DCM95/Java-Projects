import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Your Name (you@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2016-11-17
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;
   private String origin = "";
   private int kSize = 0;
   // add other fields as you need them ...


   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
      //iterate through the list in multiples of kgrams adding to model all values
      //after the current kgram then incrementing by one.
      kSize = K;
      origin = sourceText;
      for (int i = 0; i < sourceText.length() - K; i++) {
         String hold = sourceText.substring(i, i + K);
         if (model.get(hold) == null) {
            model.put(hold, "");
         }
         String hold2 = model.get(hold) + sourceText.charAt(i + K);
         model.put(hold, hold2);
      }
   }


   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
      return origin.substring(0, kSize);
   }


   /** Returns a kgram chosen at random from the source text. */
   public String getRandomKgram() {
      Random rnd = new Random();
      int start = 0;
      start = rnd.nextInt(origin.length() - kSize + 1);
      String out = origin.substring(start, start + kSize);
      return out;
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
      if (model.get(kgram) == null) {
         return '\u0000';
      }
      String hold = model.get(kgram);
      Random rnd = new Random();
      char out = hold.charAt(rnd.nextInt(hold.length()));
      return out;
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   @Override
    public String toString() {
      return model.toString();
   }

}
