gimport org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
 /**
a test which tests the driver of the Softball player.

*/
public class SoftballPlayersPart2Test {
 /**
a test which tests the empty args case of main.
@throws IOException required for it to run.
*/
   @Test public void emptyTests() throws IOException {
      SoftballTeam.resetTeamCount();
      String[] args1 = {}; // an empty String[]
      SoftballPlayersPart2.main(args1);
      Assert.assertEquals("Team count should be 0. ",
         0, SoftballTeam.getTeamCount());
   }
 /**
a test which tests the normal case of main.
@throws IOException required for it to run.
*/
   @Test public void mainTests() throws IOException {
      SoftballPlayersPart2 app = new SoftballPlayersPart2();
      String[] args2 = {"softball_player_data.csv"};
   // element args2[0] is the file name
      SoftballPlayersPart2.main(args2);
      Assert.assertEquals("Team count should be 1. ",
         1, SoftballTeam.getTeamCount());
   }
}