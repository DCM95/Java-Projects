import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArraySet.java.
 *
 * Provides an implementation of the Set interface using an
 * array as the underlying data structure. Values in the array
 * are kept in ascending natural order and, where possible,
 * methods take advantage of this. Many of the methods with parameters
 * of type ArraySet are specifically designed to take advantage
 * of the ordered array implementation.
 *
 * @author Dylan McCardle (dcm0033@auburn.edu)
 * @version 2016-10-17
 *
 */
public class ArraySet<T extends Comparable<? super T>> implements Set<T> {

   ////////////////////////////////////////////
   // DO NOT CHANGE THE FOLLOWING TWO FIELDS //
   ////////////////////////////////////////////
   T[] elements;
   int size;

   ////////////////////////////////////
   // DO NOT CHANGE THIS CONSTRUCTOR //
   ////////////////////////////////////
   /**
    * Instantiates an empty set.
    */
   @SuppressWarnings("unchecked")
   public ArraySet() {
      elements = (T[]) new Comparable[1];
      size = 0;
   }
   
   /**
    * Instantiate an array set with the elements of
    * a from index start to index end.
    * @param  a     array containing the elements of the new ArraySet
    * @param  start index of first element in a
    * @param  end   index of last element in a
    */
   @SuppressWarnings("unchecked")
   private ArraySet(T[] a, int start, int end) {
      if (start > end) {
         throw new IllegalArgumentException("start > end");
      }
   
      elements = (T[]) new Comparable[end - start];
      System.arraycopy(a, start, elements, 0, end - start);
      size = elements.length;
   }

   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements,
    *               false otherwise.
    */
   public boolean isEmpty() {
      return size == 0;
   }

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this ArraySet.
    *
    * @return a string representation of this ArraySet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }

    /**
     * Ensures the collection contains the specified element. Elements are
     * maintained in ascending natural order at all times. Neither duplicate nor
     * null values are allowed.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */
   public boolean add(T element) {
      T hold = null;
      for (int i = 0; i <= size; i++) {
         hold = elements[i];
         if (hold != null && hold.equals(element)) {
            return false;
         }
         if (hold == null || hold.compareTo(element) > 0) {
            if (isFull()) {
               resize(size * 2);
            }
            for (int j = elements.length; j > i ; j--) {
               if (j > 1) { 
                  elements[j - 1] = elements[j - 2];    
               }
            }
            elements[i] = element;
            break;
         }
         if (i == size - 1 && isFull()) {
            resize(size * 2);
         }
      }
      size++;
      return true;
   }

    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. Elements are maintained in ascending natural
     * order at all times.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */
   public boolean remove(T element) {
      Iterator<T> itr = iterator();
      T hold = null;
      for (int i = 0; itr.hasNext(); i++) {
         hold = itr.next();
         if (hold.equals(element)) {
            for (int j = i; itr.hasNext(); j++) {
               hold = itr.next();
               elements[j] = hold;
            }
            elements[--size] = null;
            if (isSparse()) {
               resize(elements.length / 2);
            }
            return true;
         }
      }
      return false;
   }

   /**
    * Searches for specified element in this collection.
    *
    * @param   element  The element whose presence in this collection
    *                   is to be tested.
    * @return  true if this collection contains the specified element,
    *               false otherwise.
    */
   public boolean contains(T element) {
      int left = 0;
      int right = size - 1;
      while (left <= right) {
         int middle = (left + right) / 2;  
         if (element.compareTo(elements[middle]) < 0) {
            right = middle - 1;
         }
         else if (element.compareTo(elements[middle]) > 0) {
            left = middle + 1; 
         }
         else {
            return true;
         }
      }
      return false;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements
    *               as the parameter set, false otherwise
    */
   public boolean equals(Set<T> s) {
      if (s.isEmpty() && !this.isEmpty()) {
         return false;
      }
      if (s.size() != this.size()) {
         return false;
      }
      Iterator<T> itr = s.iterator();
      T hold = null;
      for (int i = 0; itr.hasNext(); i++) {
         hold = itr.next();
         if (!this.contains(hold)) {
            return false;
         }
      }
      return true;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements
    *               as the parameter set, false otherwise
    */
   public boolean equals(ArraySet<T> s) {
      if (s.isEmpty() && !this.isEmpty()) {
         return false;
      }
      if (s.size() != this.size()) {
         return false;
      }
      Iterator<T> itr = s.iterator();
      T hold = null;
      for (int i = 0; itr.hasNext(); i++) {
         hold = itr.next();
         if (!hold.equals(elements[i])) {
            return false;
         }
      }
      return true;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and
    *            the parameter set
    */
   public Set<T> union(Set<T> s) {
      Iterator<T> itr = s.iterator();
      T hold = null;
      ArraySet<T> out = new ArraySet<T>();
      for (int i = 0; itr.hasNext(); i++) {
         hold = itr.next();
         out.add(hold);
      }
      Iterator<T> itr2 = this.iterator();
      for (int i = 0; itr2.hasNext(); i++) {
         hold = itr2.next();
         out.add(hold);
      }
   
      return out;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and
    *            the parameter set
    */
   @SuppressWarnings("unchecked")
   public Set<T> union(ArraySet<T> s) {
      int i = 0;
      int j = 0;
      int l = 0;
      T[] hold = (T[]) new Comparable[s.size + size];
      for (int k = 0; k < 200 && j < s.size || i < size; k++) {
         if (j < s.size && i < size) {
            if (s.elements[j].equals(elements[i])){
               hold[l++] = s.elements[j];
               j++;
               i++;
            } 
            else if (s.elements[j].compareTo(elements[i]) > 0){
               hold[l++] = elements[i];
               i++;
            }
            else if (s.elements[j].compareTo(elements[i]) < 0){
               hold[l++] = s.elements[j];
               j++;
            }
         }
         else if (j >= s.size) {
            hold[l++] = elements[i];
            i++;
         }
         else if (i >= size) {
            hold[l++] = s.elements[j];
            j++;
         }
      }
      ArraySet<T> out = new ArraySet<T>(hold, 0, l);
      return out;
   }


   /**
    * Returns a set that is the intersection of this set
    * and the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   public Set<T> intersection(Set<T> s) {
      Iterator<T> itr = s.iterator();
      T hold = null;
      ArraySet<T> out = new ArraySet<T>();
      for (int i = 0; itr.hasNext(); i++) {
         hold = itr.next();
         if (this.contains(hold)) {
            out.add(hold);
         }
      }
      return out;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   @SuppressWarnings("unchecked")
   public Set<T> intersection(ArraySet<T> s) {
      int i = 0;
      int j = 0;
      int l = 0;
      T[] hold = (T[]) new Comparable[s.size + size];
      for (int k = 0; k < 200 && j < s.size || i < size; k++) {
         if (j < s.size && i < size) {
            if (s.elements[j].equals(elements[i])){
               hold[l++] = s.elements[j];
               j++;
               i++;
            } 
            else if (s.elements[j].compareTo(elements[i]) > 0){
               i++;
            }
            else if (s.elements[j].compareTo(elements[i]) < 0){
               j++;
            }
         }
         else if (j >= s.size || i >= size) {
            break;
         }
            
         
      }
      ArraySet<T> out = new ArraySet<T>(hold, 0, l);
      return out;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   public Set<T> complement(Set<T> s) {
      Iterator<T> itr = this.iterator();
      T hold = null;
      ArraySet<T> out = new ArraySet<T>();
      for (int i = 0; itr.hasNext(); i++) {
         hold = itr.next();
         if (!s.contains(hold)) {
            out.add(hold);
         }
      }
      return out;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   @SuppressWarnings("unchecked")
   public Set<T> complement(ArraySet<T> s) {
      int i = 0;
      int j = 0;
      int l = 0;
      T[] hold = (T[]) new Comparable[s.size + size];
      for (int k = 0; k < 200 &&  j < s.size || i < size; k++) {
         if (j < s.size && i < size) {
            if (s.elements[j].equals(elements[i])){
               j++;
               i++;
            } 
            else if (s.elements[j].compareTo(elements[i]) > 0){
               hold[l++] = elements[i];
               i++;
            }
            else if (s.elements[j].compareTo(elements[i]) < 0){
               j++;
            }
         }
         else if (i >= size) {
            break;
         }
         else if (j >= s.size) {
            hold[l++] = elements[i];
            i++;
         }
      }
      
      ArraySet<T> out = new ArraySet<T>(hold, 0, l);
      
      return out;
   }
   
   

   /**
    * Returns an iterator over the elements in this ArraySet.
    * No specific order can be assumed.
    *
    * @return  an iterator over the elements in this ArraySet
    */
   public Iterator<T> iterator() {
   
      // ALMOST ALL THE TESTS DEPEND ON THIS METHOD WORKING CORRECTLY.
      // MAKE SURE YOU GET THIS ONE WORKING FIRST.
      // HINT: JUST USE THE SAME CODE/STRATEGY AS THE ARRAYBAG CLASS
      // FROM LECTURE. THE ONLY DIFFERENCE IS THAT YOU'LL NEED THE
      // ARRAYITERATOR CLASS TO BE NESTED, NOT TOP-LEVEL.
   
      return new ArrayIterator(elements, size);
   }
   
   public class ArrayIterator implements Iterator<T> {
      private T[] items;
      private int count;
      private int current;
      
      public ArrayIterator(T[] elements, int size) {
         items = elements;
         count = size;
         current = 0;
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         } 
         return items[current++];
      }
      
      public boolean hasNext() {
         return (current < count);
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   /**
    * Returns an iterator over the elements in this ArraySet.
    * The elements are returned in descending order.
    *
    * @return  an iterator over the elements in this ArraySet
    */
   public Iterator<T> descendingIterator() {
      return new DescendingIterator(elements, size);
   }
   
   public class DescendingIterator implements Iterator<T> {
      private T[] items;
      private int count;
      private int current;
      
      public DescendingIterator(T[] elements, int size) {
         items = elements;
         count = size;
         current = size;
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         } 
         return items[--current];
      }
      
      public boolean hasNext() {
         return (current > 0);
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

   /**
    * Returns an iterator over the members of the power set
    * of this ArraySet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
   public Iterator<Set<T>> powerSetIterator() {
      return new PowersetIterator(elements, size);
   }
   
   
   public class PowersetIterator implements Iterator<Set<T>> {
      private T[] base;
      private Set<T> items;
      private double count;
      private int current;
      
      public PowersetIterator(T[] elements, int size) {
         
         base = elements;
         count = Math.pow(2.0, size);
         current = 0;
      }
      
      public Set<T> next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         } 
         if (current == 0){
            current++;
            items = new ArraySet<T>();
            return items;
         }
         items = new ArraySet<T>();
         int j = 0;
         for (int i = 1; i <= count; i *= 2){
            if (asSumShift(current).contains(" " + i + " ")){
               items.add(base[j]);
            }
            j++;
         }
         // 
         // if (asSumShift(current).contains(" 2 ")){
            // items.add(base[1]);
         // }
         // if (asSumShift(current).contains(" 4 ")){
            // items.add(base[2]);
         // }
         // if (asSumShift(current).contains(" 8 ")){
            // items.add(base[3]);
         // }
         // if (asSumShift(current).contains(" 16 ")){
            // items.add(base[4]);
         // }
         // if (asSumShift(current).contains(" 32 ")){
            // items.add(base[5]);
         // }
      //    if (asSumShift(current).contains(" 64 ")){
            // items.add(base[5]);
         // }
      //    if (asSumShift(current).contains(" 128 ")){
            // items.add(base[5]);
         // }
      //    if (asSumShift(current).contains(" 256 ")){
            // items.add(base[5]);
         // }
      //    if (asSumShift(current).contains(" 5 ")){
            // items.add(base[5]);
         // }
         current++;
         return items;
      }
      
      public boolean hasNext() {
         return (current < count);
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   /**
     * Returns a string representation of the sum of
     * distinct powers of two that is equal to the given
     * positive int value.
     *
     * This implementation uses bitwise and shift
     * operators to test for powers of two in value.
     */
   public static String asSumShift(int value) {
      assert value > 0;
      StringBuilder sum = new StringBuilder();
      int term = 1;
      while (term <= value) {
         if ((value & term) == term) {
            sum.append(" " + term + " ");
         }
         term = term << 1;
      }
      return sum.toString();
   }
   
   /**
    * Reassign elements to a new array of capacity newSize with the
    * current elements of this bag.
    *
    * @param newSize the new capacity of the array
    */
   private void resize(int newSize) {
      assert newSize > 0;
      @SuppressWarnings("unchecked")
         T[] newArray = (T[]) new Comparable[newSize];
      System.arraycopy(elements, 0, newArray, 0, size);
      elements = newArray;
   }
   
   /**
    * Returns true if number of elements in this bag is the same
    * as the capacity of the array.
    *
    * @return true if this bag is full
    */
   private boolean isFull() {
      return size == elements.length;
   }

/**
    * Returns true if the number of elements in this bag is strictly less than
    * 25% of the capacity of the elements array.
    *
    * @return true if this bag is too sparse
    */
   private boolean isSparse() {
      return (size > 0) && (size < elements.length / 4);
   }
   
}
