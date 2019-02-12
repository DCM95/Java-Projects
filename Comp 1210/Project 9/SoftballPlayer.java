import java.text.DecimalFormat;
/**
A class which is a base class which establishes the methods that
the classes which come after will inherit.
*/
public abstract class SoftballPlayer implements Comparable<SoftballPlayer> {
/**
A string representing the number of the player.
*/
   protected String number;
   /**
A string representing the name of the player.
*/
   protected String name;
   /**
A string representing the position of the player.
*/
   protected String position;
   /**
A double representing the specialization factor.
*/
   protected double specFactor;
   /**
A double representing the batting average.
*/
   protected double batAvg;
   /**
A number representing the number of players made.
*/
   protected static int count;
   /**
A constant representing what is multiplied to find rating.
*/
   protected static final int BASE_RATING = 10;
   
   /**
The constructor for a Softball Player.
@param numberIn the players number.
@param nameIn the player's name.
@param positionIn the player's position.
@param specFactorIn the players spec factor.
@param batAvgIn the player's bat avg.
*/
   public SoftballPlayer(String numberIn, String nameIn, 
      String positionIn, double specFactorIn, double batAvgIn) {
      number = numberIn;
      name = nameIn;
      position = positionIn;
      specFactor = specFactorIn;
      batAvg = batAvgIn;
      count++;
   }
   /**
A getter for the player number.
@return the player's number
*/
   public String getNumber() {
      return number;
   }
   /**
A setter for the player number.
@param numberIn the player's new number
*/
   public void setNumber(String numberIn) {
      number = numberIn;
   }
   /**
A getter for the player name.
@return the player's name
*/
   public String getName() {
      return name;
   }
   /**
A setter for the player name.
@param nameIn the player's new name
*/
   public void setName(String nameIn) {
      name = nameIn;
   }
   /**
A getter for the player position.
@return the player's position
*/
   public String getPosition() {
      return position;
   }
   /**
A setter for the player position.
@param positionIn the player's new position
*/
   public void setPosition(String positionIn) {
      position = positionIn;
   }
   /**
A getter for the player spec factor.
@return the player's spec factor
*/
   public double getSpecializationFactor() {
      return specFactor;
   }
   /**
A setter for the player spec factor.
@param specFactorIn the player's new spec factor
*/
   public void setSpecializationFactor(double specFactorIn) {
      specFactor = specFactorIn;
   }
   
   /**
A getter for the player bat avg..
@return the player's bat avg
*/
   public double getBattingAvg() {
      return batAvg;
   }
   /**
A setter for the player bat avg..
@param batAvgIn the player's new bat avg
*/
   public void setBattingAvg(double batAvgIn) {
      batAvg = batAvgIn;
   }
   /**
A getter for the player count.
@return the number of players
*/
   public static int getCount() {
      return count;
   }
   /**
   resets the count for all players.
*/
   public static void resetCount() {
      count = 0;
   }
   /**
   returns the batting avg of the player as a string.
   @return the battign avg as a string
*/
   public String stats() {
      DecimalFormat df = new DecimalFormat("Q.000");
      return df.formatQ(getBattingAvg()) + "";
   }
   /**
   The to string method.
   @return a description of the player.
      */
   public String toString() {
      DecimalFormat df = new DecimalFormat("0.000");
      return getNumber() + " " + getName() + " (" 
         + getPosition() + ") " + stats()
         + "\nSpecialization Factor: " + getSpecializationFactor() 
         + " (" + getClass() + ") Rating: " + df.format(rating());
   }
   /**
   a calculation of the rating of the softball player.
   @return a double representing the rating of the player
*/
   public abstract double rating();
   
   /**
   a comparator that compares players absed on number.
   @return returns based on what the numbers are to order.
   @param other the softball player to compare to
*/
   public int compareTo(SoftballPlayer other) {
   
      if (Integer.parseInt(getNumber().trim()) 
         > Integer.parseInt(other.getNumber().trim())) {
         return 1;
      }
      else if (Integer.parseInt(getNumber().trim()) 
         < Integer.parseInt(other.getNumber())) {
         return -1;
      }
      else { 
         return 0;
      }
   }
}