import org.junit.Assert;
import org.junit.Test;
/**
  A test file for the relief pitcher class.
*/

public class ReliefPitcherTest {
/**
  A test for the get and set saves methods. 
*/
   @Test public void savesTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B", 
         1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p4.setSaves(1);
      Assert.assertEquals(1, p4.getSaves(), 0.02);
   }
   /**
  A test for the rating method. 
*/
   @Test public void ratingTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B", 
         1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      Assert.assertEquals(2.474, p4.rating(), 0.002);
   }
   /**
  A test for the stats method. 
*/
   @Test public void statsTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B", 
         1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      Assert.assertEquals(true, p4.stats().contains("5 wins, 4 losses, "
         + "17 saves, 3.85 ERA"));
   }
}
