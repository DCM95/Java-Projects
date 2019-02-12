import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
/**
* A class which tests the HexagonalPrismList2 class.
*/

public class HexagonalPrismList2Test {

   /**
   * A test which tests the getName Method.
   */
   @Test public void nameTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      
      Assert.assertEquals("My list", pList.getName());
   }
   /**
   * A test which tests the numberOfhexagonalPrisms Method.
   */
   @Test public void numberTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      
      Assert.assertEquals(4, pList.numberOfHexagonalPrisms(), 0.01);
   }
   /**
   * A test which tests the total value calculation methods.
   */
   @Test public void totalTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      
      Assert.assertEquals(1204343.885, pList.totalSurfaceArea(), 0.1);
      Assert.assertEquals(93596405.168, pList.totalVolume(), 0.1);
      Assert.assertEquals(2016.6, pList.totalBasePerimeter(), 0.1);
      Assert.assertEquals(235397.162, pList.totalBaseArea(), 0.1);
   }
   /**
   * A test which tests the average value calculation Methods.
   */
   @Test public void averageTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      HexagonalPrismList2 pList2 = new HexagonalPrismList2("Empty List",
          null, 0);
      
      Assert.assertEquals(301085.971, pList.averageSurfaceArea(), 0.1);
      Assert.assertEquals(23399101.292, pList.averageVolume(), 0.1);
      Assert.assertEquals(0, pList2.averageSurfaceArea(), 0.1);
      Assert.assertEquals(0, pList2.averageVolume(), 0.1);
   }
   /**
   * A test which tests the toString Method.
   */
   @Test public void toStringTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      
      Assert.assertEquals(true, 
            pList.toString().contains("\"Tall Example\" is "
            + "a hexagonal prism with side = 10.0 units "
            + "and height = 200.0 units,"));
   }
   /**
   * A test which tests the summaryInfo Method.
   */
   @Test public void summaryTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      
      Assert.assertEquals(true,
            pList.summaryInfo().contains("Number of Hexagonal Prisms: 4"));
   }
   /**
   * A test which tests the read file and find prism Method.
   * @throws IOException required to run the read file method
   */
   @Test public void readFileFindPrismTest() throws IOException {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      HexagonalPrismList2 pList2 = pList.readFile("hexagonal_prism_1.dat");
      
      Assert.assertEquals(true, pList.findHexagonalPrism("Short"
         + " Example").equals(pList2.findHexagonalPrism("Short Example")));
      Assert.assertEquals(null, pList.findHexagonalPrism("S"));
   }
   /**
   * A test which tests the getList Method.
   */
   @Test public void getListTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      
      Assert.assertEquals(array, pList.getList());
   }
   /**
   * A test which tests the addHexPrism Method.
   */
   @Test public void addTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      pList.addHexagonalPrism("My Prism", 12, 2);
      
      Assert.assertEquals(new HexagonalPrism("My Prism", 12, 2),
          pList.findHexagonalPrism("My Prism"));
      Assert.assertEquals(5, pList.numberOfHexagonalPrisms(), 0.01);
   }
   /**
   * A test which tests the deleteHexPrism Method.
   */
   @Test public void deleteTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      pList.addHexagonalPrism("My Prism", 12, 2);
      pList.addHexagonalPrism("My Prism2", 14, 5);
      
      Assert.assertEquals(new HexagonalPrism("My Prism", 12, 2),
          pList.deleteHexagonalPrism("My Prism"));
      Assert.assertEquals(5, pList.numberOfHexagonalPrisms(), 0.01);
      Assert.assertEquals(null, pList.findHexagonalPrism("My Prism"));
      Assert.assertEquals(null, pList.deleteHexagonalPrism("My Prism"));
   }
   /**
   * A test which tests the editHexPrism Method.
   */
   @Test public void editTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[1] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[2] = new HexagonalPrism("Tall Example", 10, 200);
      array[3] = new HexagonalPrism("Really Large Example", 300, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 4);
      
      Assert.assertEquals(true, pList.editHexagonalPrism("Tall Example", 
         12, 2));
      Assert.assertEquals(new HexagonalPrism("Tall Example", 12, 2),
          pList.findHexagonalPrism("Tall Example"));
      Assert.assertEquals(false, pList.editHexagonalPrism("TallExample", 
         12, 2));
   }
   /**
   * A test which tests the methods which search for largest and smallest
   * heights and side lengths.
   */
   @Test public void findSmallAndLargeTest() {
      HexagonalPrism[] array = new HexagonalPrism[25];
      array[0] = new HexagonalPrism("averageprism", 6, 12);
      array[1] = new HexagonalPrism("Short Example", 4.0, 6.0);
      array[2] = new HexagonalPrism(" Wide Example ", 22.1, 10.6);
      array[3] = new HexagonalPrism("Shorter Example", 10, 1);
      array[4] = new HexagonalPrism("Really Tall Example", 12, 400);
      HexagonalPrismList2 pList = new HexagonalPrismList2("My list", array, 5);
      HexagonalPrismList2 pList2 = new HexagonalPrismList2("Empty List",
          null, 0);
      
      Assert.assertEquals(new HexagonalPrism("Short Example", 4.0, 6.0),
          pList.findHexagonalPrismWithSmallestSide());
      Assert.assertEquals(null, pList2.findHexagonalPrismWithSmallestSide());
      Assert.assertEquals(new HexagonalPrism("Wide Example", 22.1, 10.6),
          pList.findHexagonalPrismWithLargestSide());
      Assert.assertEquals(null, pList2.findHexagonalPrismWithLargestSide());
      Assert.assertEquals(new HexagonalPrism("Shorter Example", 10, 1),
          pList.findHexagonalPrismWithSmallestHeight());
      Assert.assertEquals(null, pList2.findHexagonalPrismWithSmallestHeight());
      Assert.assertEquals(new HexagonalPrism("Really Tall Example", 12, 400),
          pList.findHexagonalPrismWithLargestHeight());
      Assert.assertEquals(null, pList2.findHexagonalPrismWithLargestHeight());
   }
}
