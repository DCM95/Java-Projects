import org.junit.Assert;
import org.junit.Test;
/**
  A test file for the infielder class.
*/

public class InfielderTest {
/**
  A test for the get and set fielding avg methods. 
*/
   @Test public void outfielderFieldingTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Infielder p2 = new Infielder("23", "Jackie Smith", "3B", 
         1.25, .275, .850);
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP",
            2.0, .125, 5, 4, 3.85, 17);
      p2.setInfielderFieldingAvg(.44);
      Assert.assertEquals(.44, p2.getInfielderFieldingAvg(), 0.002);
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
      Assert.assertEquals(2.922, p2.rating(), 0.002);
   }
}
