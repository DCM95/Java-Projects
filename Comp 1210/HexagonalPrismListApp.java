import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
/**
* This program takes an input file and creates a 
* list of hexagonal prisms using the HexagonalPrismList
* class then outputs that list.
*
*@author Dylan McCardle
*@version 2-29-2016
*/
public class HexagonalPrismListApp {
/**
  * This program takes an input file and creates a 
  * list of hexagonal prisms using the HexagonalPrismList
  * class then outputs that list.
  *
  * @param args Command line arguments (not used).
  * @throws IOException required to make the program run.
  */
   public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = in.nextLine();
      ArrayList<HexagonalPrism> prismList = new ArrayList<HexagonalPrism>();
      Scanner read = new Scanner(new File(fileName));
      String listName = read.nextLine();
      while (read.hasNext()) {
         String label = read.nextLine();
         double side = Double.parseDouble(read.nextLine());
         double height = Double.parseDouble(read.nextLine());
         prismList.add(new HexagonalPrism(label, side, height));
      }
      HexagonalPrismList outputList = 
         new HexagonalPrismList(listName, prismList);
      System.out.print("\n" + outputList);
      System.out.println(outputList.summaryInfo());
   }
}