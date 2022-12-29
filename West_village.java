/**
 * West_village.java 
 * 
 * This class represents each West_village thread.
 * 
 */

public class West_village extends Thread 
{
   /* Variables */
   RoadController west;
   String village;

   /* Constructor 
    * IN: RoadController w
    * Also records this is the west village to identify 
    * which village holds the road in RoadController later
   */
   public West_village(RoadController w){
      this.west = w; 
      this.village = "West village";
   }

   @Override
   public void run(){ 
      // Calls the activity from the RoadController
      west.activity(west, village);
   }
}
