import java.io.IOException;
 /**
a driver fot the softballteam program.
*/
public class SoftballPlayersPart2 {
 /**
a driver which takes a file and outputs several
reports absed on the input file.
@throws IOException required for it to run.
@param args the name of the files to be run.
*/
   public static void main(String[] args) throws IOException {
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
}