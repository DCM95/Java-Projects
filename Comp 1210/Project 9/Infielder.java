 /**
  A class which represents an infielder softball player.
 
*/
public class Infielder extends SoftballPlayer {
/**
  the fielding avg of the infielder.
*/
   private double infielderFieldingAvg;
   /**
The constructor for an infielder.
@param numberIn the players number.
@param nameIn the player's name.
@param positionIn the player's position.
@param specFactorIn the players spec factor.
@param batAvgIn the player's bat avg.
@param infielderFieldingAvgIn the player's fielding avg.
*/
   public Infielder(String numberIn, String nameIn, String positionIn,
       double specFactorIn, double batAvgIn, double infielderFieldingAvgIn) {
      super(numberIn, nameIn, positionIn, specFactorIn, batAvgIn);
      infielderFieldingAvg = infielderFieldingAvgIn;
   }
   /**
  a getter for the fielding avg.
  @return the player's fielding avg.
*/
   public double getInfielderFieldingAvg() {
      return infielderFieldingAvg;
   }
   /**
  a setter for the fielding avg.
  @param infielderFieldingAvgIn the player's new fielding avg.
*/
   public void setInfielderFieldingAvg(double infielderFieldingAvgIn) {
      infielderFieldingAvg = infielderFieldingAvgIn;
   }
   /**
  an algorithm which returns a double respresenting the overall rating
  of the player.
  @return the player's overall rating.
*/
   public double rating() {
      return BASE_RATING * specFactor * batAvg * infielderFieldingAvg;
   }
}