import org.junit.Assert;
import org.junit.Test;
/**
  A test file for the pitcher class.
*/

public class PitcherTest {
/**
  A test for the get and set era methods. 
*/
   @Test public void eraTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B", 
         1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p3.setEra(1.1);
      Assert.assertEquals(1.1, p3.getEra(), 0.02);
   }
   /**
  A test for the get and set wins methods. 
*/
   @Test public void winsTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B", 
         1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p3.setWins(6);
      Assert.assertEquals(6, p3.getWins(), 0.02);
   }
   /**
  A test for the get and set losses methods. 
*/
   @Test public void lossesTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B", 
         1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p3.setLosses(7);
      Assert.assertEquals(7, p3.getLosses(), 0.02);
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
      Assert.assertEquals(3.740, p3.rating(), 0.002);
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
      Assert.assertEquals(true, p3.stats().contains("22 wins, "
         + "4 losses, 2.85 ERA"));
   }
  
}
