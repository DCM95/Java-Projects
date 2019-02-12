import java.text.DecimalFormat;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
* This program takes an input list of hexagonal
* prisms and calculates information based on
* this list.
*
*@author Dylan McCardle
*@version 2-29-2016
*/

public class HexagonalPrismList2 {
/**
* Name of the prism list.
*/
   private String title;
/**
* The list of hexagonal prisms.
*/
   private HexagonalPrism[] prismList = new HexagonalPrism[100];
/**
*The number of hexagonal prisms.
*/
   private int prismNumber;
   /**
   * Constructor which takes an array list of
   * hexagonal prisms and constructs the list.
   *
   * @param titleIn Name of the input list
   * @param prismListIn The list you want to construct.
   * @param numberIn number of hexagonal prisms in the list.
   */
   public HexagonalPrismList2(String titleIn, 
      HexagonalPrism[] prismListIn, int numberIn) {
      title = titleIn;
      prismList = prismListIn;
      prismNumber = numberIn;
   }
   /**
   * returns the name of the list.
   * @return name of list
   */
   public String getName() {
      return title;
   }
   /**
   * returns the number of prisms in the list.
   * @return int representing number of prisms
   */
   public int numberOfHexagonalPrisms() {
      return prismNumber;
   }
   /**
   * returns the total surface area of all prisms
   * in the list.
   * @return double representing total Surface Area
   */
   public double totalSurfaceArea() {
      double totalSA = 0.0;
      for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
         totalSA += prismList[i].surfaceArea();
      }
      return totalSA;
   }
   /**
   * returns the total volume of all prisms
   * in the list.
   * @return total volume of all prisms in list
   */
   public double totalVolume() {
      double totalV = 0.0;
      for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
         totalV += prismList[i].volume();
      }
      return totalV;
   }
   /**
   * returns the total base perimeter of all prisms
   * in the list. 
   * @return base perimeter of all prisms in list
   */
   public double totalBasePerimeter() {
      double totalBP = 0.0;
      for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
         totalBP += prismList[i].basePerimeter();
      }
      return totalBP;
   }
   /**
   * returns the total base area of all prisms
   * in the list.
   * @return the total base area of all prisms
   */
   public double totalBaseArea() {
      double totalBA = 0.0;
      for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
         totalBA += prismList[i].baseArea();
      }
      return totalBA;
   }
   /**
   * returns the average surface area of all prisms
   * in the list.
   * @return average of all surface areas
   */
   public double averageSurfaceArea() {
      if (numberOfHexagonalPrisms() == 0) {
         return 0.0;
      }
      else {
         double avgSA = totalSurfaceArea() / (double) numberOfHexagonalPrisms();
         return avgSA;
      }
   }
   /**
   * returns the average volume of all prisms
   * in the list.
   * @return average of all volumes
   */
   public double averageVolume() {
      if (numberOfHexagonalPrisms() == 0) {
         return 0.0;
      }
      else {
         double avgV = totalVolume() / (double) numberOfHexagonalPrisms();
         return avgV;
      }
   }
   /**
   * returns a description of all hexagonal prisms within
   * the list by using the toString() method of the prisms.
   * @return returns a description of all prisms
   */
   public String toString() {
      String output = "" + title + "\n\n";
      for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
         output += prismList[i].toString() + "\n\n";
      }
      return output;
   }
   /**
   * returns a summary of all things that can be 
   * calculated using the mthods of this class.
   * @return a summary of all info in the class
   */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "----- " + title + " Summary -----"
         + "\nNumber of Hexagonal Prisms: " 
         + numberOfHexagonalPrisms() + "\nTotal Surface Area: " 
         + df.format(totalSurfaceArea()) + "\nTotal Volume: " 
         + df.format(totalVolume()) 
         + "\nTotal Base Perimeter: " + df.format(totalBasePerimeter()) 
         + "\nTotal Base Area: " + df.format(totalBaseArea())
         + "\nAverage Surface Area: " + df.format(averageSurfaceArea())
         + "\nAverage Volume: " + df.format(averageVolume());
      return output;
   }
   /**
    * returns the array list that this program
    * refers to.
    * @return the array list in this program. 
    */
   public HexagonalPrism[] getList() {
      return prismList;
   }
   /**
    * reads in a file and outputs a HexagonalPrismList
    * object using the file input.
    * @return the HexagonalPrismList created by the file 
    * @param fileIn the input name of the file
    * @throws IOException required to run
    */
   public HexagonalPrismList2 readFile(String fileIn)throws IOException {
      Scanner read = new Scanner(new File(fileIn));
      HexagonalPrism[] createdList = new HexagonalPrism[100];
      String listName = read.nextLine();
      int numPrisms = 0;
      while (read.hasNext()) {
         String label = read.nextLine();
         double side = Double.parseDouble(read.nextLine());
         double height = Double.parseDouble(read.nextLine());
         createdList[numPrisms] = new HexagonalPrism(label, side, height);
         numPrisms++;
         //createdList.add(new HexagonalPrism(label, side, height));
      }
      return new HexagonalPrismList2(listName, createdList, numPrisms);
   }
   /**
    * adds a hexagonal prism to the prism list.
    * @param labelIn the name of the prism
    * @param sideIn the length of a side of the base
    * @param heightIn the height of the prism
    */
   public void addHexagonalPrism(String labelIn, 
      double sideIn, double heightIn) {
      //getList().add(new HexagonalPrism(labelIn, sideIn, heightIn));
      prismList[numberOfHexagonalPrisms()] = 
         new HexagonalPrism(labelIn, sideIn, heightIn);
      prismNumber++;
   }
   /**
    * returns the hexagonal prism referred to and deletes it.
    * @return the hexagonal prism deleted or null of no prism found
    * @param labelIn the name of the hexagonal prism to be deleted 
    */
   public HexagonalPrism deleteHexagonalPrism(String labelIn) {
      for (int i = 0; i < prismNumber; i++) {
         if (labelIn.equalsIgnoreCase(prismList[i].getLabel())) {
            HexagonalPrism output = prismList[i]; 
            for (int j = i; j < prismNumber - 1; j++) {
               prismList[j] = prismList[j + 1];
            }
            prismList[prismNumber - 1] = null; // overwrite duplicate at end
            prismNumber--;
            return output; 
         }
      }
      return null;
   }
   /**
    * finds the hexagonal prism referred to and returns it.
    * @return the hexagonal prism found or null if none found
    * @param labelIn the name of the hexagonal prism to be found
    */
   public HexagonalPrism findHexagonalPrism(String labelIn) {
      for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
         if (labelIn.equalsIgnoreCase(prismList[i].getLabel())) {
            return prismList[i];
         }
      }
      return null;
   }
   /**
    * edits a hexagonal prism in the list and 
    * returns a boolean value if one was edited.
    * @return true if a prism was editted false if none was found
    * @param labelIn the name of the hexagonal prism to be editted 
    * @param sideIn the new length of a side of the base
    * @param heightIn the new height of the prism
    */
   public boolean editHexagonalPrism(String labelIn, 
      double sideIn, double heightIn) {
      for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
         if (labelIn.equalsIgnoreCase(prismList[i].getLabel())) {
            prismList[i].setSide(sideIn);
            prismList[i].setHeight(heightIn);
            return true;
         }
      }
      return false;
   }
   /**
    * finds the hex prism with the smallest side length.
    * @return returns found prism or null if the list is empty.
    */
   public HexagonalPrism findHexagonalPrismWithSmallestSide() {
      HexagonalPrism output = null;
      if (numberOfHexagonalPrisms() > 0) {
         for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
            if (i == 0) {
               output = prismList[i];
            }
            else {
               if (prismList[i].getSide() < output.getSide()) {
                  output = prismList[i];
               }
            }
         }
         return output;
      }
      else {
         return null;
      }
   }
   /**
    * finds the hex prism with the largest side length.
    * @return returns found prism or null if the list is empty.
    */
   public HexagonalPrism findHexagonalPrismWithLargestSide() {
      HexagonalPrism output = null;
      if (numberOfHexagonalPrisms() > 0) {
         for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
            if (i == 0) {
               output = prismList[i];
            }
            else {
               if (prismList[i].getSide() > output.getSide()) {
                  output = prismList[i];
               }
            }
         }
         return output;
      }
      else {
         return null;
      }
   }
   /**
    * finds the hex prism with the smallest height.
    * @return returns found prism or null if the list is empty.
    */
   public HexagonalPrism findHexagonalPrismWithSmallestHeight() {
      HexagonalPrism output = null;
      if (numberOfHexagonalPrisms() > 0) {
         for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
            if (i == 0) {
               output = prismList[i];
            }
            else {
               if (prismList[i].getHeight() < output.getHeight()) {
                  output = prismList[i];
               }
            }
         }
         return output;
      }
      else {
         return null;
      }
   }
   /**
    * finds the hex prism with the largest Height.
    * @return returns found prism or null if the list is empty.
    */
   public HexagonalPrism findHexagonalPrismWithLargestHeight() {
      HexagonalPrism output = null;
      if (numberOfHexagonalPrisms() > 0) {
         for (int i = 0; i < numberOfHexagonalPrisms(); i++) {
            if (i == 0) {
               output = prismList[i];
            }
            else {
               if (prismList[i].getHeight() > output.getHeight()) {
                  output = prismList[i];
               }
            }
         }
         return output;
      }
      else {
         return null;
      }
   }
}