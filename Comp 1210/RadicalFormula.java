import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * This program will take an input value and calculate the value
 * of an expression using that input value.
 *
 *@author Dylan McCardle
 *@version 2-3-2016
 */

public class RadicalFormula
{
/**
 * This program will take an input value and calculate the value
 * of an expression using that input value.
 *
 * @param args Command line arguments (not used).
 */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      //input value and asnwer
      double x;
      double ans;
      //left and right hand number of digits
      int lDigits;
      int rDigits;
      //declares variables used to determine decimals and format
      int dot;
      int length;
      String decimalStr;
      DecimalFormat form = new DecimalFormat("#,##0.0##");
      //start of program
      System.out.print("Enter a value for x: ");
      x = in.nextDouble();
      //calculates answer
      ans = Math.sqrt(Math.pow((3 * Math.pow(x, 8))
         - (2 * Math.pow(x, 3)), 2)
         + Math.abs((3 * (Math.pow(x, 5))
            - (2 * Math.pow(x, 3)))));
      System.out.println("Result: " + ans);
      //calculates digits to left and right
      decimalStr = Double.toString(ans);
      length = decimalStr.length();
      dot = decimalStr.indexOf('.');
      rDigits = length - dot - 1;
      lDigits = dot;
      //prints formatted answer and digits around decimal
      System.out.println("# digits to left of decimal point: " + lDigits);
      System.out.println("# digits to right of decimal point: " + rDigits);
      System.out.println("Formatted Result: " + form.format(ans));
   }
}