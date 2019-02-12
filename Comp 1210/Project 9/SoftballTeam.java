import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.text.DecimalFormat;
/**
an array of SoftballPlayers with methods to read a file
and construct a team from it and methods to manipulate and 
print the team.
*/

public class SoftballTeam {
/**
the team name.
*/
   private String teamName;
   /**
the array representing the roster.
*/
   private SoftballPlayer[] roster = new SoftballPlayer[24];
   /**
the number of players on the team.
*/
   private int playerCount;
   /**
an array representing the strings of players unable to be
added to the team.
*/
   private String[] excludedRecords = new String[30];
   /**
the number of excluded strings.
*/
   private int excludedCount;
   /**
a static representation of the number of teams made.
*/
   private static int teamCount = 0;
   /**
a constant representing the max team size.
*/
   public static final int MAX_PLAYERS = 24;
   /**
a constant representign the max size of the string list of
excluded players.
*/
   public static final int MAX_EXCLUDED = 30;
   /**
a generic constructor for the softball team.
*/
   public SoftballTeam() {
      teamCount++;
   }
   /**
A getter for the team's name.
@return the team's name
*/
   public String getTeamName() {
      return teamName;
   }
   /**
A setter for the team name.
@param teamNameIn the name of the team
*/
   public void setTeamName(String teamNameIn) {
      teamName = teamNameIn;
   }
   /**
A getter for the array of players on the team.
@return the array of players
*/
   public SoftballPlayer[] getRoster() {
      return roster;
   }
   /**
A setter for the array of players on a roster.
@param rosterIn the array of players on a roster
*/
   public void setRoster(SoftballPlayer[] rosterIn) {
      roster = rosterIn;
   }
   /**
A getter for the number of players on a team.
@return the number of players
*/
   public int getPlayerCount() {
      return playerCount;
   }
   /**
A setter for the number of players.
@param playerCountIn the number of players
*/
   public void setPlayerCount(int playerCountIn) {
      playerCount = playerCountIn;
   }
   /**
A getter for the array of excluded strings.
@return the array of excluded strings
*/
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   /**
A setter for the array of excluded strings.
@param excludedRecordsIn the array of excluded strings
*/
   public void setExcludedRecords(String[] excludedRecordsIn) {
      excludedRecords = excludedRecordsIn;
   }
   /**
A getter for the number of excluded strings.
@return the nubmer of excluded strings
*/
   public int getExcludedCount() {
      return excludedCount;
   }
   /**
A setter for the number of excluded strings in the array.
@param excludedCountIn the amount of excluded strings
*/
   public void setExcludedCount(int excludedCountIn) {
      excludedCount = excludedCountIn;
   }
   /**
A getter for the number of teams.
@return the number of teams
*/
   public static int getTeamCount() {
      return teamCount;
   }
   /**
A method to reset the coutn of the number of teams.
*/
   public static void resetTeamCount() {
      teamCount = 0;
   }
   /**
a method which reads a file and populates the roster and the 
excluded list arrays.
@throws IOException required to make it work.
@param fileIn the name of the file to be input
*/
   public void readPlayerFile(String fileIn) throws IOException {
      Scanner read = new Scanner(new File(fileIn));
      setTeamName(read.nextLine());
      while (read.hasNext()) {
         String pLine = read.nextLine();
         if (getPlayerCount() < MAX_PLAYERS) {
            try {
               Scanner scan = new Scanner(pLine);
               scan.useDelimiter(",");
               String cls = scan.next();
               String num = scan.next();
               String name = scan.next();
               String pos = scan.next();
               double spec = Double.parseDouble(scan.next());
               double bAvg = Double.parseDouble(scan.next());
               switch (cls.toUpperCase().charAt(0)) {
                  case 'O':
                     Outfielder pAdd1 = new Outfielder(num, name, pos, 
                        spec, bAvg, scan.nextDouble());
                     roster[getPlayerCount()] = pAdd1;
                     playerCount++;
                     break;
                  case 'I':
                     Infielder pAdd2 = new Infielder(num, name, pos, 
                        spec, bAvg, Double.parseDouble(scan.next()));
                     roster[getPlayerCount()] = pAdd2;
                     playerCount++;
                     break;
                  case 'P':
                     Pitcher pAdd3 = new Pitcher(num, name, pos, 
                        spec, bAvg, Integer.parseInt(scan.next()), 
                        Integer.parseInt(scan.next()), 
                        Double.parseDouble(scan.next()));
                     roster[getPlayerCount()] = pAdd3;
                     playerCount++;
                     break;
                  case 'R':
                     ReliefPitcher pAdd4 = new ReliefPitcher(num, name, pos, 
                        spec, bAvg, Integer.parseInt(scan.next()), 
                        Integer.parseInt(scan.next()), 
                        Double.parseDouble(scan.next()), 
                        Integer.parseInt(scan.next()));
                     roster[getPlayerCount()] = pAdd4;
                     playerCount++;
                     break;
                  default:
                     throw new InvalidCategoryException(cls);
                     // pLine = "*** invalid category *** " + pLine;
                     // excludedRecords[getExcludedCount()] = pLine;
                     // excludedCount++;
               }
            }
            catch (InvalidCategoryException e) {
               pLine = e + " in: " + pLine;
               excludedRecords[getExcludedCount()] = pLine;
               excludedCount++;
            }
            catch (NumberFormatException e) {
               pLine = e + " in: " + pLine;
               excludedRecords[getExcludedCount()] = pLine;
               excludedCount++;
            }
         }
         else if (getExcludedCount() < MAX_EXCLUDED) {
            pLine = "Maximum player count of 24 exceeded for: " + pLine;
            excludedRecords[getExcludedCount()] = pLine;
            excludedCount++;
         }
      }
   }
   /**
a generic report listing each player on the roster.
@return a report ordered in generic order.
*/
   public String generateReport() {
      String output = "---------------------------------------\n"
         + "Team Report for " + getTeamName() + "\n"
         + "---------------------------------------\n\n";
      for (int i = 0; i < getPlayerCount(); i++) {
         output += roster[i].toString() + "\n\n";
      }
      return output;
   }
   /**
a generic report listing each player on the roster by number.
@return a report ordered in numeric order.
*/
   public String generateReportByNumber() {
      Arrays.sort(roster, 0, getPlayerCount());
      String output = "---------------------------------------\n"
         + "Team Report for " + getTeamName() + " (by Number)\n"
         + "---------------------------------------\n";
      for (int i = 0; i < getPlayerCount(); i++) {
         output += roster[i].getNumber() + " " + roster[i].getName() 
            + " " + roster[i].getPosition() + " " + roster[i].stats() + "\n";
      }
      return output;
   }
   /**
a generic report listing each player on the roster by rating.
@return a report ordered by rating.
*/
   public String generateReportByRating() {
      Arrays.sort(roster, 0, getPlayerCount(), new RatingComparator());
      DecimalFormat df = new DecimalFormat("0.00");
      String output = "---------------------------------------\n"
         + "Team Report for " + getTeamName() + " (by Rating)\n"
         + "---------------------------------------\n";
      for (int i = 0; i < getPlayerCount(); i++) {
         output += df.format(roster[i].rating()) + " " + roster[i].getNumber() 
            + " " + roster[i].getName() + " " + roster[i].getPosition() + " " 
            + roster[i].stats() + "\n";
      }
      return output;
   }
   /**
a generic report listing each player on the roster by name.
@return a report ordered in nomenclature order.
*/
   public String generateReportByName() {
      Arrays.sort(roster, 0, getPlayerCount(), new NameComparator());
      String output = "---------------------------------------\n"
         + "Team Report for " + getTeamName() + " (by Name)\n"
         + "---------------------------------------\n";
      for (int i = 0; i < getPlayerCount(); i++) {
         output += roster[i].getNumber() + " " + roster[i].getName() + " " 
            + roster[i].getPosition() + " " + roster[i].stats() + "\n";
      }
      return output;
   }
   /**
a report listing the players unable to be added to the roster
and the reason why.
@return a report listing players not added to roster.
*/
   public String generateExcludedRecordsReport() {
      String output = "\n---------------------------------------\n"
         + "Excluded Records Report\n"
         + "---------------------------------------";
      for (int i = 0; i < getExcludedCount(); i++) {
         output += "\n" + excludedRecords[i];
      }
         
      return output;
   }
}
e