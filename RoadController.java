import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * RoadController.java
 * 
 * This class represents the road control between the East and West village. 
 * Each village will try to acquire the semaphore / road to do an activity and release it after.
 * Main is used to create several threads of each village's people.
 * 
 */

 
public class RoadController
{  
   /* Represent one road -> one resource */
   Semaphore road = new Semaphore(1);  
 
   synchronized void activity(RoadController thrd, String village){
      try{
         road.acquire();
         System.out.println(village + " has ACQUIRED the road space.");

         // Array of random activities 
         String[] activities = {"fishing", "eating pizza", "walking dogs", "playing music", "juggling", "feeding birds"};
         Random rand = new Random();
         // Choose a random activity to do from the array 
         int actIndex = rand.nextInt(activities.length);
         
         // Choose a random amount of time spent doing chosen activity (Bounds between 1000-3000)
         int timeSpent = rand.nextInt((3000-1000) + 1) + 1000; 

         // Thread will sleep for time spent doing activity/traveling
         Thread.sleep(timeSpent);

         // Print to terminal which village did activity and for how long 
         System.out.println("People from " + village + " spent " + timeSpent + " ms " + activities[actIndex]);

      }catch(InterruptedException e){
         System.out.println("Interrupted Exception");
      }
      /* Activity is done, village now release resource/road space */
      road.release();
      System.out.println(village + " has RELEASED the road space.");
   }

   public static void main(String[] args){
      RoadController roadctrl = new RoadController();

      /* Want to create several threads representing the 2 villages people */
      int villagePopulation = 10; 
      West_village[] wes = new West_village[villagePopulation];
      East_village[] eas = new East_village[villagePopulation];
      
      for(int i = 0; i < villagePopulation; i++){
         wes[i] = new West_village(roadctrl);
         eas[i] = new East_village(roadctrl);
         wes[i].start();
         eas[i].start();
      }
   }
}

