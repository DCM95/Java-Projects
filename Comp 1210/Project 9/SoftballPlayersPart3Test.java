import org.junit.Assert;
import org.junit.Test;
 /**
a test which tests the driver of the Softball player.

*/
public class SoftballPlayersPart3Test {
 /**
a test which tests the empty args case of main.
*/
   @Test public void emptyTests() {
      SoftballTeam.resetTeamCount();
      String[] args1 = {}; // an empty String[]
      SoftballPlayersPart3.main(args1);
      Assert.assertEquals("Team count should be 0. ",
         0, SoftballTeam.getTeamCount());
   }
 /**
a test which tests the normal case of main.
*/
   @Test public void mainTests() {
      SoftballTeam.resetTeamCount();
      SoftballPlayersPart3 app = new SoftballPlayersPart3();
      String[] args2 = {"softball_player_data3a.csv"};
   // element args2[0] is the file name
      SoftballPlayersPart3.main(args2);
      Assert.assertEquals("Team count should be 1. ",
         1, SoftballTeam.getTeamCount());
   }
   /**
a test which tests the normal case of main.
*/
   @Test public void iOExceptionTests() {
      SoftballTeam.resetTeamCount();
      String[] args2 = {"softball_player_data3a not really.csv"};
   // element args2[0] is the file name
      SoftballPlayersPart3.main(args2);
      Assert.assertEquals("Team count should be 1. ",
         1, SoftballTeam.getTeamCount());
   }
}