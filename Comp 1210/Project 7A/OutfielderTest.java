import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class OutfielderTest {



   /** A test that always fails. **/
   @Test public void countTest() {
      Outfielder.resetCount();
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Outfielder p2 = new Outfielder("36", "Pat Jones", "RF", 1.0, .375, .950);
      Outfielder p3 = new Outfielder("39", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals(SoftballPlayer.getCount(), 3, .2);
      Assert.assertEquals(Outfielder.getCount(), 3, .2);
   }
}
