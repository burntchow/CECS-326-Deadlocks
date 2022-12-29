/**
 * East_village.java 
 * 
 * This class represents each East_village thread.
 * 
 */

public class East_village extends Thread
{
   /* Variables */
   RoadController east;
   String village;

   /* Constructor 
    * IN: RoadController e
    * Also records this is the east village to identify 
    * which village holds the road in RoadController later
   */
   public East_village(RoadController e){
      this.east = e; 
      this.village = "East village";
   }
 
   @Override
   public void run(){ 
      // Calls the activity from the RoadController
      east.activity(east, village);
   }
}
