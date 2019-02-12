import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
/**
* This program is a menu that operates the methods and functions
* found within the HexagonPrismList class.
*
*@author Dylan McCardle
*@version 3-7-2016
*/
public class HexagonalPrismListMenuApp {
/**
* This program is a menu that operates the methods and functions
* found within the HexagonPrismList class.
*
*@param args required for the file to run
*@throws IOException required for the file to run.
*/
   public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);
      char choice;
      HexagonalPrismList fileList = new HexagonalPrismList("", 
         new ArrayList<HexagonalPrism>());
      System.out.print("Hexagonal Prism List System Menu\n");
      System.out.print("R - Read File and Create Hexagonal Prism List\n");
      System.out.print("P - Print Hexagonal Prism List\n");
      System.out.print("S - Print Summary\n");
      System.out.print("A - Add Hexagonal Prism\n");
      System.out.print("D - Delete Hexagonal Prism\n");
      System.out.print("F - Find Hexagonal Prism\n");
      System.out.print("E - Edit Hexagonal Prism\n");
      System.out.print("Q - Quit\n");
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = in.nextLine().charAt(0);
         choice = Character.toUpperCase(choice);
         switch (choice) {
            case 'R':
               System.out.print("\tFile name: ");
               String fileIn = in.nextLine();
               fileList = fileList.readFile(fileIn);
               System.out.print("\tFile read in and Hexagonal"
                  + " Prism List created\n\n");
               break;
            case 'P':
               System.out.print(fileList + "");
               break;
            case 'S':
               System.out.print("\n" + fileList.summaryInfo() + "\n\n");
               break;
            case 'A':
               System.out.print("\tLabel: ");
               String labelInA = in.nextLine();
               System.out.print("\tSide: ");
               double sideInA = Double.parseDouble(in.nextLine());
               System.out.print("\tHeight: ");
               double heightInA = Double.parseDouble(in.nextLine());
               fileList.addHexagonalPrism(labelInA, sideInA, heightInA);
               System.out.print("\t*** Hexagonal Prism added ***\n\n");
               break;
            case 'D':
               System.out.print("\tLabel: ");
               String labelInD = in.nextLine();
               if (fileList.deleteHexagonalPrism(labelInD) == null) {
                  System.out.print("\t\"" + labelInD + "\" not found\n\n");
               }
               else {
                  System.out.print("\t\"" + labelInD + "\" deleted\n\n");
               }
               break;
            case 'F':
               System.out.print("\tLabel: ");
               String labelInF = in.nextLine();
               if (fileList.findHexagonalPrism(labelInF) == null) {
                  System.out.print("\t\"" + labelInF + "\" not found\n\n");
               }
               else {
                  System.out.print(
                     fileList.findHexagonalPrism(labelInF).toString() + "\n\n");
               }
               break;
            case 'E':
               System.out.print("\tLabel: ");
               String labelInE = in.nextLine();
               System.out.print("\tSide: ");
               double sideInE = Double.parseDouble(in.nextLine());
               System.out.print("\tHeight: ");
               double heightInE = Double.parseDouble(in.nextLine());
               if (fileList.editHexagonalPrism(labelInE, sideInE, heightInE)) {
                  System.out.print("\t\"" + labelInE 
                     + "\" successfully edited\n\n");
               }
               else {
                  System.out.print("\t\"" + labelInE + "\" not found\n\n");
               }
               break;
            case 'Q':
               break;
            default:
               break;
         }
      } while (choice != 'Q');
   }
}