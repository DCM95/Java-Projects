import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

/**
 * This program takes coded information for a lunchbox order and processes it
 * to display information such as name, style of box, price, number bought,
 * and a lucky number.
 *
 *@author Dylan McCardle
 *@version 2-3-2016
 */

public class SuperBowlBoxLunch
{
/**
 * This program takes coded information for a lunchbox order and processes it
 * to display information such as name, style of box, price, number bought,
 * and a lucky number.
 *
 * @param args Command line arguments (not used).
 */
   public static void main(String[] args) 
   {
   //input code
      String code;
      Scanner in = new Scanner(System.in);
   //name of buyer
      String name;
   //# Bought
      int childB;
      int adultB;
   //price per box adult and child
      DecimalFormat form = new DecimalFormat("$#,##0.00");
      double priceC;
      double priceA;
   //total cost
      double priceTot;
   //Theme
      String theme;
   //Lucky number
      Random lucky = new Random();
      DecimalFormat luckForm = new DecimalFormat("0000");
   //start of program
      System.out.print("Enter order code: ");
      code = in.nextLine();
      System.out.println("");
      if (code.length() < 13) {
         System.out.println("*** Invalid Order Code ***"
            + "\nOrder code must have at least 13 characters.");
      } 
      else {
         //parse code for data
         code = code.trim();
         adultB = Integer.parseInt(code.substring(1, 3));
         childB = Integer.parseInt(code.substring(7, 9));
         priceC = Double.parseDouble(code.substring(9, 13)) / 100;
         priceA = Double.parseDouble(code.substring(3, 7)) / 100;
         if (code.charAt(0) == '0') {
            theme = "Broncos";
         }
         else if (code.charAt(0) == '1') {
            theme = "Panthers";
         }
         else {
            theme = "Broncos and Panthers";
         }
         priceTot = (adultB * priceA) + (childB * priceC);
         name = code.substring(13);
         System.out.println("Name: " + name);
         System.out.println("Adult meals: " + adultB
            + " at " + form.format(priceA));
         System.out.println("Child meals: " + childB 
            + " at " + form.format(priceC));
         System.out.println("Total: " + form.format(priceTot));
         System.out.println("Theme: " + theme);
         System.out.println("Lucky Number: "
            + luckForm.format(lucky.nextInt(10000)));
      }
   }
}