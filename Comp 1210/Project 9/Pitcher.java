/**
  A class which represents a pitcher softball player.
 
*/

public class Pitcher extends SoftballPlayer {
/**
  the Era of the player.
*/
   protected double era;
   /**
  the wins of the player.
*/
   protected int wins;
   /**
  the losses of the player.
*/
   protected int losses;
   /**
The constructor for a pitcher.
@param numberIn the players number.
@param nameIn the player's name.
@param positionIn the player's position.
@param specFactorIn the players spec factor.
@param batAvgIn the player's bat avg.
@param winsIn the player's wins.
@param lossesIn the player's losses.
@param eraIn the player's era.
*/
   public Pitcher(String numberIn, String nameIn, String positionIn, 
      double specFactorIn, double batAvgIn, int winsIn, int lossesIn, 
      double eraIn) {
      super(numberIn, nameIn, positionIn, specFactorIn, batAvgIn);
      era = eraIn;
      wins = winsIn;
      losses = lossesIn;
   }
   /**
  a getter for the wins.
  @return the player's wins.
*/
   public int getWins() {
      return wins;
   }
   /**
  a setter for the wins.
  @param winsIn the player's new wins.
*/
   public void setWins(int winsIn) {
      wins = winsIn;
   }
   /**
  a getter for the losses.
  @return the player's losses.
*/
   public int getLosses() {
      return losses;
   }
   /**
  a setter for the losses.
  @param lossesIn the player's new losses.
*/
   public void setLosses(int lossesIn) {
      losses = lossesIn;
   }
   /**
  a getter for the Era.
  @return the player's Era.
*/
   public double getEra() {
      return era;
   }
   /**
  a setter for the Era.
  @param eraIn the player's new Era.
*/
   public void setEra(double eraIn) {
      era = eraIn;
   }
   /**
  returns the stats of the player to be used in toString.
  @return the player's stats as a string.
*/
   public String stats() {
      return getWins() + " wins, " + getLosses() 
         + " losses, " + getEra() + " ERA";
   }
   /**
  an algorithm which returns a double respresenting the overall rating
  of the player.
  @return the player's overall rating.
*/
   public double rating() {
      return BASE_RATING * specFactor 
         * (1.0 / (1 + getEra())) * ((getWins() - getLosses()) / 25.0);
   }
}