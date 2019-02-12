import java.io.IOException;
 /**
a driver fot the softballteam program.
*/
public class SoftballPlayersPart3 {
 /**
a driver which takes a file and outputs several
reports absed on the input file.
@param args the name of the files to be run.
*/
   public static void main(String[] args) {
      try {
         if (args.length == 0) {
            System.out.println("File name expected as command line argument.");
            System.out.println("Program ending.");
         }
         else {
            SoftballTeam team = new SoftballTeam();
            team.readPlayerFile(args[0]);
            System.out.print(team.generateReport());
            System.out.print(team.generateReportByNumber());
            System.out.print(team.generateReportByName());
            System.out.print(team.generateReportByRating());
            System.out.print(team.generateExcludedRecordsReport());
         }
      }
      catch (IOException e) {
         System.out.println("Attempted to read file: " + args[0] 
            + " (No such file or directory)");
         System.out.println("Program ending.");
      }
   }
}