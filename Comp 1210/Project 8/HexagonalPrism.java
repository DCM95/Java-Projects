import java.text.DecimalFormat;
/**
 * This program contaisn methods which find useful values for hexagonal 
 * prisms such as volume, surface area, base area, and base perimeter. 
 *
 *@author Dylan McCardle
 *@version 2-18-2016
 */

public class HexagonalPrism {
/**
* This is the name of the Hexagonal prism.
*/
   private String label;
 /**
* This is the length of the sides of the abse of the Hexagonal Prism.
*/
   private double side;
 /**
* This is the Height of the Hexagonal prism.
*/
   private double height;
   /**
* This is the amount of hexagonal prisms which have been created.
*/
   private static int count = 0;
/**
 * This is the constructor which takes in the name side length and height
 * then increments count.
 *
 * @param labelIn Name of the hexagonal prism.
 * @param sideIn Length of the side at the abse of the prism.
 * @param heightIn Height of the prism.
 */
   public HexagonalPrism(String labelIn, double sideIn, double heightIn) {
      side = sideIn;
      height = heightIn;
      label = labelIn.trim();
      count++;
   }
/**
 * Returns the label of the hexagonal prism.
 * @return Returns the name of the prism.
 */
   public String getLabel() {
      return label;
   }
   
/**
 * Sets the label of the hexagonal prism. Returns false if no string is input.
 * @param labelIn Input label of the hexagonal prism.
 * @return returns true if the label is changed.
 */
   public boolean setLabel(String labelIn) {
      if (labelIn == null) {
         return false;
      }
      else {
         label = labelIn.trim();
         return true;
      }
   }
/**
 * Returns the side length of the hexagonal prism.
 * @return returns the side length.
 */
   public double getSide() {
      return side;
   }
   
/**
 * Sets the side length of the hexagonal prism.
 * @param sideIn Input length of the side of the base.
 */
   public void setSide(double sideIn) {
      side = sideIn;
   }
/**
 * Returns the height of the hexagonal prism.
 * @return returns height.
 */
   public double getHeight() {
      return height;
   }
/**
 * Sets the height of the hexagonal prism.
 * @param heightIn input height of the prism.
 */
   public void setHeight(double heightIn) {
      height = heightIn;
   }
/**
 * Calculates and returns the perimeter of the base of the hexagonal prism.
 * @return Returns area of base of Prism.
 */
   public double basePerimeter() {
      double perimeter;
      perimeter = side * 6;
      return perimeter;
   }
/**
 * Calculates and returns the area of the base of the hexagonal prism.
 * @return Returns area of Hexagonal Prism.
 */
   public double baseArea() {
      double area;
      area = ((3.0 * Math.sqrt(3)) / 2.0) * Math.pow(side, 2);
      return area;
   }
/**
 * Calculates and returns the surface area of the hexagonal prism.
 * @return Returns surface area of Hexagonal prism.
 */
   public double surfaceArea() {
      double sArea;
      sArea = (6 * side * height) + (3 * Math.sqrt(3) * Math.pow(side, 2));
      return sArea;
   }
/**
 * Calculates and returns the volume of the hexagonal prism. 
 * Uses base area method.
 * @return Returns volume of hexagonal prism.
 */
   public double volume() {
      double vol;
      vol = baseArea() * height;
      return vol;
   }
/**
 * Returns a string describing the hexagonal prism with formatted things 
 * such as the height, the side length, the base area and perimeter, 
 * the surface area, and the volume.
 * @return Returns calculations made of the hexagonal prism.
 */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      return "\"" + label + "\" is a hexagonal prism with side = " 
         + df.format(side) + " units and height = " + df.format(height) 
         + " units,\nwhich has base perimeter = " + df.format(basePerimeter()) 
         + " units, base area = " + df.format(baseArea()) + " square units,"
         + "\nsurface area = " + df.format(surfaceArea()) + " square units, "
         + "and volume = " + df.format(volume()) + " cubic units.";
   }
/**
* a static method returns the count variable.
* @return the count variable
*/
   public static int getCount() {
      return count;
   }
/**
* a static method resets the count variable.
*/
   public static void resetCount() {
      count = 0;
   }
   /**
* This method checks to see if the input hexagonal prism has the same
* fields as the input object.
* @param obj input object which is checked to see if it equals the prism.
* @return false if the object is not a hexagonal prism or if 
*     it does not equal the input hexagonal prism.
*/
   public boolean equals(Object obj) {
      if (!(obj instanceof HexagonalPrism)) {
         return false;
      }
      else {
         HexagonalPrism c = (HexagonalPrism) obj;
         return (label.equals(c.getLabel())
            && Math.abs(side - c.getSide()) < .00001
            && Math.abs(height - c.getHeight()) < .00001);
      }
   } 
   /**
   * required to make equals work.
   * @return shrug
   */
   public int hashCode() {
      return 0;
   }
}