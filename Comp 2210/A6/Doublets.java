import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Doublets.java
 * Provides an implementation of the WordLadderGame interface. The lexicon
 * is stored as a TreeSet of Strings.
 *
 * @author Dylan McCardle (dcm0033@auburn.edu)
 * @version 2016-11-15
 */
public class Doublets implements WordLadderGame {

   ////////////////////////////////////////////
   // DON'T CHANGE THE FOLLOWING TWO FIELDS. //
   ////////////////////////////////////////////

   // A word ladder with no words. Used as the return value for the ladder methods
   // below when no ladder exists.
   List<String> EMPTY_LADDER = new ArrayList<>();

   // The word list used to validate words.
   // Must be instantiated and populated in the constructor.
   TreeSet<String> lexicon;


   /**
    * Instantiates a new instance of Doublets with the lexicon populated with
    * the strings in the provided InputStream. The InputStream can be formatted
    * in different ways as long as the first string on each line is a word to be
    * stored in the lexicon.
    */
   public Doublets(InputStream in) {
      try {
         lexicon = new TreeSet<String>();
         Scanner s =
            new Scanner(new BufferedReader(new InputStreamReader(in)));
         while (s.hasNext()) {
            String str = s.next();
            ////////////////////////////////////////////////
            // Add code here to store str in the lexicon. //
            ////////////////////////////////////////////////
            lexicon.add(str.toLowerCase());
            s.nextLine();
         }
         in.close();
      }
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }
   
   
   public int getHammingDistance(String str1, String str2) {
      if (str1.length() != str2.length()){
         return -1;
      }
      int count = 0;
      for (int i = 0; i < str1.length(); i++){
         if (str1.toLowerCase().charAt(i) != str2.toLowerCase().charAt(i)) {
            count++;
         }
      }
      return count;
   }
   
   public List<String> getLadder(String start, String end){
      if (start.length() == end.length()) {
         return findLadder(start, end);
      }
      return new ArrayList<String>();
   }
  
   public  List<String> getMinLadder(String start, String end){
      if (start.length() == end.length()) {
         return findMinLadder(start, end);
      }
      return new ArrayList<String>();
   }
   
   public List<String> getNeighbors(String word){
      if (word == null) {
         return null;
      }
      ArrayList<String> out = new ArrayList<String>();
      for (int i = 0; i < word.length(); i++) {
         for (char c = 'a'; c <= 'z'; c++){
            if (word.charAt(i) != c){
               String h = replaceLetter2(word, c, i);
               if (lexicon.contains(h)){
                  out.add(h);
               }
            }
         }
            
      }
      if (out.isEmpty()){
         return new ArrayList<String>();
      }
      return out;
   }
  
   public  int getWordCount(){
      return lexicon.size();
   }
   
   public boolean isWord(String str){
      return lexicon.contains(str);
   }
   
   public boolean isWordLadder(List<String> sequence){
      if (sequence.isEmpty()){
         return false;
      }
      if (sequence.size() == 1 && lexicon.contains(sequence.get(0))) {
         return true;
      }
      if (sequence.size() == 1 && !lexicon.contains(sequence.get(0))) {
         return false;
      }
      for (int i = 0; i < sequence.size(); i++){
         if (!lexicon.contains(sequence.get(i))){
            return false;
         }
         if (i == 0) {
            if (getHammingDistance(sequence.get(i), sequence.get(i + 1)) != 1){
               return false;
            }
         }
         else {
            if (getHammingDistance(sequence.get(i), sequence.get(i - 1)) != 1){
               return false;
            }
         }
      }
   
      return true;
   }
  
   private List<String> findLadder(String str1, String str2) {
      ArrayDeque<String> stack = new ArrayDeque<String>();
      TreeSet<String> nope = new TreeSet<String>();
      List<String> hold = null;
      if (str1.equals(str2)) {
         ArrayList<String> out1 = new ArrayList<String>();
         out1.add(str1);
         return out1;
      }
      stack.addFirst(str1);
      while (!stack.isEmpty()) {
         int j = 100;
         int f = 0;
         int count = 0;
         hold = getNeighbors(stack.peekFirst());
         for (int i = 0; i < hold.size(); i++) {
            if (!nope.contains(hold.get(i))){
               if (getHammingDistance(str2, hold.get(i)) < j){
                  j = getHammingDistance(str2, hold.get(i));
                  f = i;
                  count++;
               }
            }
         }
         if (hold.size() != 0) {
            nope.add(hold.get(f));
         }
         if (count == 0){
            stack.removeFirst();
         }
         else {
            stack.addFirst(hold.get(f));
         }
         
         if (stack.size() != 0){
            if (stack.peekFirst().toLowerCase()
            .compareTo(str2.toLowerCase()) == 0) {
               ArrayList<String> out = new ArrayList<String>();
               while (!stack.isEmpty()){
                  out.add(stack.removeLast());
               }
               return out;
            }
         }
      }
      return new ArrayList<String>();
   }
  
   private List<String> findMinLadder(String str1, String str2) {
      ArrayDeque<Node> queue = new ArrayDeque<Node>();
      TreeSet<String> nope = new TreeSet<String>();
      List<String> hold = new ArrayList<String>();
      queue.addLast(new Node(str1, 1, null));
      int min = 0;
      int prevSteps = 0;
      
      while(!queue.isEmpty()){
         Node N = queue.removeFirst();
         String s = N.word;
      
         if (s.equals(str2)){
            if (min==0){
               min = N.steps;
            }
            
            if(N.steps == min && min !=0){
               ArrayList<String> out = new ArrayList<String>();
               out.add(N.word);
               while(N.back !=null){
                  out.add(0, N.back.word);
                  N = N.back;
               }
               return out;
            }
         }
         hold = getNeighbors(s);
         for (int i = 0; i < hold.size(); i++) {
            if (!nope.contains(hold.get(i))){
               queue.addLast(new Node(hold.get(i), N.steps + 1, N));
               nope.add(hold.get(i));
            }
         }
      }
      return new ArrayList<String>();
   }
   
   private class Node{
      String word;
      int steps;
      Node back;
   
      public Node(String in, int numIn, Node b){
         word = in;
         steps = numIn;
         back = b;
      }
   
   }
  
  
   private String replaceLetter(String j, String k, int place){
      StringBuilder h = new StringBuilder(j);
      h.setCharAt(place, k.charAt(place));
      return h.toString();
   }
   
   private String replaceLetter2(String j, char i, int place){
      StringBuilder h = new StringBuilder(j);
      h.setCharAt(place, i);
      return h.toString();
   }
}