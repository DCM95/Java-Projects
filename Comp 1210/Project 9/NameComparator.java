import java.util.Comparator;
    /**
a comparator which compares players based on their names.
*/
public class NameComparator implements Comparator<SoftballPlayer> {
   /**
a comprator which compares players based on their names.
@param p1 the first player
@param p2 the second player
@return the order in which the two should go
*/
   public int compare(SoftballPlayer p1, SoftballPlayer p2) {
      int output;
      String p1LN = 
         p1.getName().substring(p1.getName().indexOf(" ")).toUpperCase();
      String p2LN = 
         p2.getName().substring(p2.getName().indexOf(" ")).toUpperCase();
      output = p1LN.compareTo(p2LN);
      if (output == 0) {
         String p1FN = 
            p1.getName().substring(0, p1.getName().indexOf(" ")).toUpperCase();
         String p2FN = 
            p2.getName().substring(0, p2.getName().indexOf(" ")).toUpperCase();
         output = p1FN.compareTo(p2FN);
      }
      return output;
   }
}