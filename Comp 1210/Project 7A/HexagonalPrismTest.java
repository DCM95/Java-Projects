import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;
   /**
   * A test class which tests the HexagonalPrism Class.
   */

public class HexagonalPrismTest {
/**
   * A test which tests the get and set label methods Methods.
   */
   @Test public void labelTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      p.setLabel("My P ");
      String s = null;
      Assert.assertEquals("My P", p.getLabel());
      Assert.assertEquals(false, p.setLabel(s));
      Assert.assertEquals(true, p.setLabel("sex"));
      Assert.assertEquals("sex", p.getLabel());
   }
   /**
   * A test which tests get and set side Methods.
   */
   @Test public void sideTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      p.setSide(7);
      Assert.assertEquals(7, p.getSide(), .0001);
   }
   /**
   * A test which tests get and set height Methods.
   */
   @Test public void heightTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      p.setHeight(12);
      Assert.assertEquals(12, p.getHeight(), .0001);
   }
   /**
   * A test which tests the get perimeter Method.
   */
   @Test public void perimeterTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      Assert.assertEquals(60, p.basePerimeter(), 0.01);
   }
   /**
   * A test which tests the get area Method.
   */
   @Test public void areaTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      Assert.assertEquals(259.81, p.baseArea(), 0.01);
   }
   /**
   * A test which tests the get surface area Method.
   */
   @Test public void surfaceAreaTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      Assert.assertEquals(1119.62, p.surfaceArea(), 0.01);
   }
   /**
   * A test which tests the get volume Method.
   */
   @Test public void volumeTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      Assert.assertEquals(2598.076, p.volume(), 0.1);
   }
   /**
   * A test which tests the toString Method.
   */
   @Test public void toStringTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      Assert.assertEquals(true,
          p.toString().contains("which has base perimeter = 60.0"));
   }
   /**
   * A test which tests the get and reset count Methods.
   */
   @Test public void countTest() {
      HexagonalPrism.resetCount();
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      HexagonalPrism p1 = new HexagonalPrism("My Prism", 10, 10);
      HexagonalPrism p2 = new HexagonalPrism("My Prism", 10, 10);
      HexagonalPrism p3 = new HexagonalPrism("My Prism", 10, 10);
      Assert.assertEquals(4, HexagonalPrism.getCount(), 0.1);
   }
   /**
   * A test which tests the equals Method.
   */
   @Test public void equalsTest() {
      String s = "Jack";
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      HexagonalPrism p1 = new HexagonalPrism("My Prism", 10, 10);
      HexagonalPrism p2 = new HexagonalPrism("My Prism2", 12, 10);
      HexagonalPrism p3 = new HexagonalPrism("My Prism", 12, 10);
      HexagonalPrism p4 = new HexagonalPrism("My Prism", 10, 12);
      Assert.assertEquals(true, p.equals(p1));
      Assert.assertEquals(false, p.equals(p2));
      Assert.assertEquals(false, p.equals(p3));
      Assert.assertEquals(false, p.equals(p4));
      Assert.assertEquals(false, p.equals(s));
   } 
   /**
   * A test which tests the hashcode Method.
   */
   @Test public void hashTest() {
      HexagonalPrism p = new HexagonalPrism("My Prism", 10, 10);
      Assert.assertEquals(0, p.hashCode(), 0.01);
   }
}
