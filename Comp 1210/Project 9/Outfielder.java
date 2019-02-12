/**
  A class whcih represents an outfielder softball player.
 
*/


public class Outfielder extends SoftballPlayer {
  /**
  the fielding avg of the outfielder.
*/
   private double outfielderFieldingAvg;
   /**
The constructor for an outfielder.
@param numberIn the players number.
@param nameIn the player's name.
@param positionIn the player's position.
@param specFactorIn the players spec factor.
@param batAvgIn the player's bat avg.
@param outfielderFieldingAvgIn the player's fielding avg.
*/
   public Outfielder(String numberIn, String nameIn, String positionIn,
       double specFactorIn, double batAvgIn, double outfielderFieldingAvgIn) {
      super(numberIn, nameIn, positionIn, specFactorIn, batAvgIn);
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
   /**
  a getter for the fielding avg.
  @return the player's fieldign avg.
*/
   public double getOutfielderFieldingAvg() {
      return outfielderFieldingAvg;
   }
   /**
  a setter for the fielding avg.
  @param outfielderFieldingAvgIn the player's new fielding avg.
*/
   public void setOutfielderFieldingAvg(double outfielderFieldingAvgIn) {
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
   /**
  an algorithm which returns a double respresenting the overall rating
  of the player.
  @return the player's overall rating.
*/
   public double rating() {
      return BASE_RATING * specFactor * batAvg * outfielderFieldingAvg;
   }
}