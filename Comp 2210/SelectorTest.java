public class SelectorTest {
 
   public static void main(String[] args) {
      int[] test = new int[]{2,10,0,8,6,4};
      Selector.min(test);
      Selector.max(test);
      Selector.kmin(test, 3);
      Selector.kmax(test, 2);
   }
}