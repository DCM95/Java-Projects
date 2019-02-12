import java.util.Comparator;
   /**
a comparator which compares players based on their names.
*/
public class RatingComparator implements Comparator<SoftballPlayer> {
   /**
a comparator which compares players based on their names.
@param p1 the first player
@param p2 the second player
@return the order in which the two should go
*/
   public int compare(SoftballPlayer p1, SoftballPlayer p2) {
      if (p1.rating() > p2.rating()) {
         return -1;
      }
      else if (p1.rating() < p2.rating()) {
         return 1;
      }
      return 0;
   }
}