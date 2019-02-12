/**
  A class which represents a relief pitcher softball player.
 
*/

public class ReliefPitcher extends Pitcher {
   /**
  the saves of the player.
*/
   private int saves;
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
@param savesIn the player's saves.
*/
   public ReliefPitcher(String numberIn, String nameIn, String positionIn, 
         double specFactorIn, double batAvgIn, int winsIn, int lossesIn, 
         double eraIn, int savesIn) {
      super(numberIn, nameIn, positionIn, specFactorIn, 
         batAvgIn, winsIn, lossesIn, eraIn);
      saves = savesIn;
   }
   /**
  a getter for the saves.
  @return the player's saves.
*/
   public int getSaves() {
      return saves;
   }
   /**
  a setter for the saves.
  @param savesIn the player's new saves.
*/
   public void setSaves(int savesIn) {
      saves = savesIn;
   }
   /**
  returns the stats of the player to be used in toString.
  @return the player's stats as a string.
*/
   public String stats() {
      return getWins() + " wins, " + getLosses() + " losses, " 
         + getSaves() + " saves, " + getEra() + " ERA";
   }
   /**
  an algorithm which returns a double respresenting the overall rating
  of the player.
  @return the player's overall rating.
*/
   public double rating() {
      return BASE_RATING * specFactor * (1.0 / (1 + getEra())) 
         * ((getWins() - getLosses() + getSaves()) / 30.0);
   }
}