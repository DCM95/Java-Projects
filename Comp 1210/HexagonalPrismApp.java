import java.util.Scanner;
/**
* This program takes input information about a hexagonal prism and
* outputs some facts about that prism.
*
*@author Dylan McCardle
*@version 2-18-2016
*/

public class HexagonalPrismApp {
/**
  * This program takes input information about a hexagonal prism and
  * outputs some facts about that prism.
  *
  * @param args Command line arguments (not used).
  */
   public static void main(String[] args) {
      String l1;
      double s1;
      double h1;
      Scanner in = new Scanner(System.in);
      System.out.println("Enter label, side, and height"
         + " for a hexagonal prism.");
      System.out.print("\tlabel: ");
      l1 = in.nextLine();
      System.out.print("\tside: ");
      s1 = Double.parseDouble(in.nextLine());
      System.out.print("\theight: ");
      h1 = Double.parseDouble(in.nextLine());
      HexagonalPrism prism1 = new HexagonalPrism(l1, s1, h1);
      System.out.print(prism1.toString());
   }
}