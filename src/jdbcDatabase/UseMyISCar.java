package jdbcDatabase;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class UseMyISCar {
	
	//final static Random gasInject = new Random();
		static int gas = 0;
		static int moreGas = 0;
		int i = 1;
		String buf = "";
		String theWinner = "";
		
//		public static void main(String[] args) {
		public void begin( String preferedCar ) {
		
			boolean wasCrash = false;
			
	        //Create a car specified just by its name : 밫oyota�.  
			//ISCar myFirstCar = new ISCar("My Car", -1, 1, 10);
			ISCar myFirstCar = new ISCar( preferedCar, -1, 1, 10);
			
			
	        //Create a car with a specified name: 밠azda� to be driven by a non-experienced person.
			//This Car will start the race with an initial speed given by the player as a parameter to the constructor 
			//Let's take 20.
			ISCar mySecondCar = new ISCar ("Computer Car", 20, -1, 1, 10);

	        //Create a third Car which name 뱓oyCar� is given by default, 
	        //and that doesn't move
			Car myThirdCar = new Car();

	        //Create the first Driver that will drive the first car
			Driver firstDriver = new Driver();
			
			//Create the second Driver that will drive the second car
			Driver secondDriver = new Driver();

			

			System.out.println();
			System.out.println("\t\t\t\t" + "CAR RACING");
			System.out.println("\t\t\t\t" + "----------");
			System.out.println();
			System.out.println();
	RacingResult.add( " " );
	RacingResult.add( "\t\t" + "CAR RACING" );
	RacingResult.add( "\t\t" + "----------" );
	RacingResult.add( " " );
	RacingResult.add( " " );
			
			
			//Cars start  
			myFirstCar.start(1, 0);
			mySecondCar.start(1, 0);
	       
			//Cars start running. From here they all get the current speed
			myFirstCar.StartRunning();
			myFirstCar.setSpeedIncreaseStep(myFirstCar.getCurrentSpeed());
	       
			mySecondCar.StartRunning();
			mySecondCar.setSpeedIncreaseStep(mySecondCar.getCurrentSpeed());

			//Let's race for 30 seconds

			Timer m_timer = new Timer();
			TimerTask m_task = new TimerTask() {
				
				@Override
				public void run() {
			
			
			
			
			
						if( i >= 60) {
							
							RacingResult.gameOver = true;
							m_timer.cancel();
						}
						
					
						//if myFirstCar speedIncreaseStep is positive (Acceleration)
						if (myFirstCar.getSpeedIncreaseStep() > 0){
			        	   System.out.print(myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " >>> : " +myFirstCar.getCurrentSpeed() +"\t\t" );
	  buf += ""+myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " >>> : " +myFirstCar.getCurrentSpeed() +"\t\t" ;	
			       		
						}
						//if myFirstCar current speedIncreaseStep is negative (Deceleration - Slow down)
						else if (myFirstCar.getSpeedIncreaseStep() < 0){
			        	   System.out.print(myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " <<< : " +myFirstCar.getCurrentSpeed() +"\t\t");
	   buf += "" + myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " <<< : " +myFirstCar.getCurrentSpeed() +"\t\t";
			       						
						}
						//if myFirstCar speedIncreaseStep speed is zero (Constant speed)
						else{ 
			    		   //increment the car zeroCounter counter 	
			    		   myFirstCar.setZeroCounter(myFirstCar.getZeroCounter() + 1);
			    		   //prepare gas  	
			    		   gas = myFirstCar.AutomaticCreationRandomNumber(-myFirstCar.getMaxFactor(), 5*myFirstCar.getMaxFactor(),20);
			    		   //Increase the speed related to the amount of gas alloted
			    		   myFirstCar.setSpeedIncreaseStep(gas);
			    		   //Get this speed when the driver punches on the accelerator pedal 
			               firstDriver.punchOnAccelorPedal(myFirstCar, myFirstCar.getSpeedIncreaseStep());
			               System.out.print(myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " +++ : " +myFirstCar.getCurrentSpeed() +"\t\t");
	buf += "" + myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " +++ : " +myFirstCar.getCurrentSpeed() +"\t\t";               

			               
			               
			               //if the number of times zeroCounter has passed to zero is multiple of 3
			               if(myFirstCar.getZeroCounter() % 3 == 0){
			            	   //prepare even more gas
			            	   moreGas=myFirstCar.AutomaticCreationRandomNumber(0, myFirstCar.getZeroCounter()*5*myFirstCar.getMaxFactor(), myFirstCar.getZeroCounter()*10);
			            	   //Automatically increase the speed related to the amount of gas alloted
			            	   myFirstCar.automaticAccelerationIncrease(moreGas);
			            	   System.out.print(myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " *** : " +myFirstCar.getCurrentSpeed() +"\t\t");
	buf += "" + myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " *** : " +myFirstCar.getCurrentSpeed() +"\t\t";
			               }
			    	   }
						//if myseSondCar speedIncreaseStep is positive (Acceleration)
						if (mySecondCar.getSpeedIncreaseStep() > 0){
			        	   System.out.print(mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " >>> : " +mySecondCar.getCurrentSpeed() +"\t\t" );
	buf += "" +mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " >>> : " +mySecondCar.getCurrentSpeed() +"\t\t";
						}
						//if mySecondCar current speedIncreaseStep is negative (Deceleration - Slow down)
						else if (mySecondCar.getSpeedIncreaseStep() < 0){
			        	   System.out.print(mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " <<< : " +mySecondCar.getCurrentSpeed() +"\t\t");
	buf +="" + mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " <<< : " +mySecondCar.getCurrentSpeed() +"\t\t";			
						
						}
						//if mySecondCar speedIncreaseStep speed is zero (Constant speed)
						else{ 
			    		   //increment the car zeroCounter counter 	
			    		   mySecondCar.setZeroCounter(mySecondCar.getZeroCounter() + 1);
			    		   //prepare gas  	
			    		   gas = mySecondCar.AutomaticCreationRandomNumber(-mySecondCar.getMaxFactor(), 5*mySecondCar.getMaxFactor(),20);
			    		   //Increase the speed related to the amount of gas alloted
			    		   mySecondCar.setSpeedIncreaseStep(gas);
			    		   //Get this speed when the driver punches on the accelerator pedal 
			               secondDriver.punchOnAccelorPedal(mySecondCar, mySecondCar.getSpeedIncreaseStep());
			               System.out.print(mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " +++ : " +mySecondCar.getCurrentSpeed() +"\t\t");
	buf += "" +	mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " +++ : " +mySecondCar.getCurrentSpeed() +"\t\t";	               
			               
			               //if the number of times zeroCounter has passed to zero is multiple of 3
			               if(mySecondCar.getZeroCounter() % 3 == 0){
			            	   //prepare even more gas
			            	   moreGas=mySecondCar.AutomaticCreationRandomNumber(0, mySecondCar.getZeroCounter()*5*mySecondCar.getMaxFactor(), mySecondCar.getZeroCounter()*10);
			            	   //Automatically increase the speed related to the amount of gas alloted
			            	   mySecondCar.automaticAccelerationIncrease(moreGas);
			            	   System.out.print(mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " *** : " +mySecondCar.getCurrentSpeed() +"\t\t");
	buf += "" + mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " *** : " +mySecondCar.getCurrentSpeed() +"\t\t";		               
			               }
			    	   }
			       	   //Display the third car
			          //System.out.println("\t\t " + myThirdCar.getCarName() + " === : " + myThirdCar.getCurrentSpeed());
	RacingResult.add( buf ); 
	buf = "";
			          //Keep running both the cars
			          myFirstCar.run(2, -1);
			          mySecondCar.run(2, -1);
			          //Pass the seconds between two sppeeds

			          i++;   
			          
			          
			          
			          if( RacingResult.gameOver ) {
			          

						  		System.out.println();
						  		System.out.println();
						  RacingResult.add( buf );
						  buf = "";
						  	    if (myFirstCar.getCurrentSpeed() == mySecondCar.getCurrentSpeed())
						  	    	{
						  	    	   System.out.println("\t\t" + "There is no winner for this Race ");
						   RacingResult.add("\t\t" + "There is no winner for this Race ");
						  	RacingResult.gameOver = true;
				
						  	    	}
						  	    else if (myFirstCar.getCurrentSpeed() > mySecondCar.getCurrentSpeed())
						  	       {
						  	          theWinner = myFirstCar.getCarName();
						  	          System.out.println("\t\t" + "The winner of this Race is :  " + theWinner);
						  RacingResult.add("\t\t" + "The winner of this Race is :  " + theWinner);
						  RacingResult.gameOver = true;
						  RacingResult.winner = 0;
				
						  	       }
						  	    else
						  	       {
						  	          theWinner = mySecondCar.getCarName();	
						  	          System.out.println("\t\t" + "The winner of this Race is :  " + theWinner);
						  RacingResult.add("\t\t" + "The winner of this Race is :  " + theWinner);
						  RacingResult.gameOver = true;
						  RacingResult.winner = 1;
				
						         }
				
						         System.out.println();
						         System.out.println();
			          }
				}  
				
			};
			m_timer.schedule(m_task, 0, 1000);
				
				
				
	    }

}
