import org.junit.Assert;
import org.junit.Test;
/**
  A test file for the outfielder class. Also tests 
  the softball player class.
*/

public class OutfielderTest {
/**
  A test for the count method and reset count method. 
*/

   @Test public void countTest() {
      SoftballPlayer.resetCount();
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      Assert.assertEquals(4, SoftballPlayer.getCount(), .2);
   }
   /**
  A test for the get and set name methods. 
*/
   @Test public void nameTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p1.setName("Pattie");
      Assert.assertEquals("Pattie", p1.getName());
   }
   /**
  A test for the get and set position methods. 
*/
   @Test public void positionTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p1.setPosition("Bench");
      Assert.assertEquals("Bench", p1.getPosition());
   }
   /**
  A test for the get and set number methods. 
*/
   @Test public void numberTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p1.setNumber("69");
      Assert.assertEquals("69", p1.getNumber());
   }
   /**
  A test for the get and set spec factor methods. 
*/
   @Test public void specFactorTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p1.setSpecializationFactor(12.34);
      Assert.assertEquals(12.34, p1.getSpecializationFactor(), 0.02);
   }
   /**
  A test for the get and set bat avg and stats methods. 
*/
   @Test public void battingAvgStatsTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p1.setBattingAvg(.333);
      Assert.assertEquals(.333, p1.getBattingAvg(), 0.002);
      Assert.assertEquals(".333", p1.stats());
   }
   /**
  A test for the get and set fielding avg methods. 
*/
   @Test public void outfielderFieldingTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p1.setOutfielderFieldingAvg(.44);
      Assert.assertEquals(.44, p1.getOutfielderFieldingAvg(), 0.002);
   }
   /**
  A test for the rating method. 
*/
   @Test public void ratingTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      Assert.assertEquals(3.562, p1.rating(), 0.002);
   }
   /**
  A test for the to string method. 
*/
   @Test public void toStringTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      Assert.assertEquals(true, p1.toString().contains("Specialization "
         + "Factor: 1.0 (class Outfielder) Rating: 3.562"));
   }
   /**
   A test for the comapre to method.
   */
   @Test public void compareToTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      Assert.assertEquals(1, p1.compareTo(p2), .02);
      Assert.assertEquals(-1, p2.compareTo(p1), .02);
      Assert.assertEquals(0, p1.compareTo(p1), .02);
   }
}
