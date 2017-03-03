// Jiashan Li  Lec 01  T04  //
// version: 2015.11.6//

import java.util.Scanner;

public class GameController
{
	private ArcticTrack arc;
  private DesertTrack des;
	private boolean done;
  private Scanner in;
  private char selection;
  private int count;
  private int number;
  private int number1 = 0;
  private int number2 = 0;
  private int num1 = 0;
  private int num2 = 0;


//  initialize //
	public GameController()  
	{                     
    in = new Scanner(System.in);
		arc = new ArcticTrack();
    des = new DesertTrack();
		done = false;
    count = 0;
	}


//  many conditions that will put the run to an end,if one of them is satisfied, then the program end //
  public void end()
  {
   if(arc.isWon() == true && des.isWon() == true) // check if two cars reach the end at the same time //  
   {
     System.out.println("two cars reach the end at the same time.");
     System.out.println("simulation is a draw.");
     count++;            //  use to count how many conditions are satisfied, if count > 0 ,then end //
   }
   else if(arc.isWon() == true && des.isWon() == false)     // SUV reach the end first, then end //
   {
     System.out.println("SUV has reached the end first");  
     count++;
   }
   else if(arc.isWon() == false && des.isWon() == true)     //Sports reach the end first, then end // 
   {
     System.out.println("Sports has reached the end first.");
     count++;
   }
   else if(arc.checkfuel() == true && des.checkfuel() == true)// if two cars are both out of fuel, then end //
   {
     System.out.println("Both cars out of fuel, simulation is a draw");
     count++;
   }

  }


// display the cheat menu //
	public void displaycheat()
	{
        System.out.println();
        System.out.println("CHEAT MENU SELECTION");
		    System.out.println("(0) Toggle debugging messages on/off");
        System.out.println("(1) Change fuel of sports car");
        System.out.println("(2) Change fuel of SUV car");
        System.out.println("(3) Change location of sports car");
        System.out.println("(4) Change location of suv car");
        System.out.println("(5) Make a blizzard in the artic track");
        System.out.println("(6) Make a heat wave in the desert track");
        System.out.print("Enter selection:");
	}


// display the SUV mode menu //
  public void displaySUV()
  {
      System.out.println("SUV driving options");
      System.out.println("(a)ll wheel drive mode");
      System.out.println("(d)rive normally");
      System.out.println("(q)uit simulation");
      System.out.print("Enter selection:");
  }


// display the Sports mode menu //
    public void displaySports()
    {
      System.out.println("Sportscar driving options");
      System.out.println("(d)rive normally");
      System.out.println("(q)uit simulation");
      System.out.print("Enter selection:");
    }


//the process of SUV move after the user input the mode (AWD and normal) //
    public void processSUV (char selection) 
    { 
     arc.CreatBlizzard();   
     switch(selection)
     {
      case 'a':
      case 'A':
          if(arc.getCreatBlizzard() == 1 || number1 == 1) // AWD mode move in random produce a blizzard or set a blizzard manually //
          {
             arc.AWDMoveBlizzard();
             if(number1 == 1)
               num1 = 1;   // use to show the blizzard message in the next turn //
             number1 = 0;
             
          }
          else if(arc.getCreatBlizzard() == 0) // AWD mode move when there is no blizzard //
             arc.Move();
           break;

      case 'd':
      case 'D':
          if(arc.getCreatBlizzard() == 1 || number1 == 1) // normal mode move in random produce a blizzard or set a blizzard manually //
          {
             arc.NormalMoveBlizzard();
            if(number1 == 1)
               num1 = 1;
             number1 = 0;
           
          }
          else if(arc.getCreatBlizzard() == 0) // normal mode move when there is no blizzard //
             arc.Move();
           break;

      case 'q':
      case 'Q':
           done = true;
           System.out.println("Quiting game before end: simulation is a draw");
           break;
     
      case 'c':
      case 'C':
           displaycheat();          // begin cheat mode //
           number = in.nextInt();
           SUVprocesscheat(number);
     }
    }


//the process of Sports car move after the user input the mode (only normal)//
    public void processSports(char selection) 
    {
     des.CreatHeatwave();
     switch(selection)
     {
      case 'd':
      case 'D':
          if(des.getCreatHeatwave() == 1 ||  number2 == 1) // normal mode move in random produce a heatwave or set a heatwave manually //
          {
              des.Heatwavemove();
              if(number2 == 1)
               num2 = 1;
              number2 = 0;
          }
          else if(des.getCreatHeatwave() == 0)   // normal mode move when there is no heatwave //
              des.Nomalmove();
           break;

      case 'q':
      case 'Q':
           done = true;
           System.out.println("Quiting game before end: simulation is a draw");
           break;

      case 'c':
      case 'C':
        displaycheat();
        number = in.nextInt();
        Sportsprocesscheat(number);
     }
    }
    

//after user choose the option in the cheat menu provided by SUV mode menu, the process of the option //
    public void SUVprocesscheat(int number)
    {
     switch(number)
     {
      case 0:
           if(Debug.Debugon() == true)
            System.out.println("the cheat mode has been processed.");
          break;
      case 1:    
           System.out.println();
           System.out.print("Set new fuel value (non-negative value only):");
           number = in.nextInt(); // input the value of fuel the sports car have //    
           des.setfuel(number);    // set the fuel value //
           break;

      case 2:
           System.out.println();
           System.out.println("Set new fuel value (non-negative value only):");
           number = in.nextInt(); // input the value of fuel the SUV car have //  
           arc.setfuel(number);    // set the fuel value //
           break;

      case 3:
           System.out.println("Move car from location 0 to 24");
           System.out.print("Enter location:");
           number = in.nextInt(); // input the location the Sports car be in//
           des.movemanual(number);  // set the location //
           break;

      case 4:
           System.out.println("Move car from location 0 to 24");
           System.out.println("Enter location:");
           number = in.nextInt();   // input the location the SUV car be in//
           arc.movemanual(number);   // set the location //
           break;

      case 5:
           System.out.println("Causing a blizzard is ignored");
           break; 

       case 6:
           System.out.println("Causing a heat wave in the desert track");
           number2 = 1;   //use in the processSports method, if number2 = 1,generate a heatwave //
           break;   
    }
}


//after user choose the option in the cheat menu provided by Sports mode menu, the process of the option //
    public void Sportsprocesscheat(int number)
    {
     switch(number)
     {
      case 0:
           if(Debug.Debugon() == true)
             System.out.println("the cheat mode has been processed.");
           break;
      case 1:
           System.out.println();
           System.out.print("Set new fuel value (non-negative value only):");
           number = in.nextInt();
           des.setfuel(number);
           break;

      case 2:
           System.out.println();
           System.out.println("Set new fuel value (non-negative value only):");
           number = in.nextInt();
           arc.setfuel(number2);
           break;

      case 3:
           System.out.println("Move car from location 0 to 24");
           System.out.print("Enter location:");
           number = in.nextInt();
           des.movemanual(number);
           break;

      case 4:
           System.out.println("Move car from location 0 to 24");
           System.out.println("Enter location:");
           number = in.nextInt();
           arc.movemanual(number);
           break;

      case 5:      // use in the processSUV method //
           System.out.println("Causing a blizzard in the artic track");
           number1 = 1;  
           break;

       case 6:  //could not cause a heatwave in its own track! //
           System.out.println("Causing a heat wave is ignored");
           break;   
    }
}


// method use to control the run of the program //
    public void startDriving ()       
    {
	  String line;
    System.out.println("ARTIC TRACK ");    //display the start position // 
    arc.display();
    System.out.println();
    System.out.println("DESERT TRACK ");
    des.display();
	  
    while (done == false)       // if the user quit, the runtime end //
	  {
      System.out.println();
	    displaySUV();             
      do {
        line = in.nextLine();     // get user input //
      }while(line.length() < 1);   
	    selection = line.charAt(0);
	    processSUV(selection);    // process user input //
      if(selection == 'q')      // if the user quit, the runtime end //
      {
          System.out.println("ARTIC TRACK ");
          arc.display();
          if(arc.getCreatBlizzard() == 1 || num1 == 1)
              System.out.println("Arctic track is current hit with a blizzard");
              num1 = 0;
          System.out.println();
          System.out.println("DESERT TRACK ");
          des.display();
          if(des.getCreatHeatwave() == 1 || num2 == 1)
            System.out.println("Desert track is current hit with a heatwave");
         num2 = 0;
          break;
      }
      
      System.out.println();   
      displaySports();
      do {
        line = in.nextLine();
      }while(line.length() < 1);
      selection = line.charAt(0);
      processSports(selection);
      if(arc.getfuel() == 0)     
           System.out.println("SUV car is out of fuel and cannot move");
      if(des.getfuel() == 0)
           System.out.println("Sports car is out of fuel and cannot move"); 
      end();
      
      System.out.println("ARTIC TRACK ");
      arc.display();
      if(arc.getCreatBlizzard() == 1 || num1 == 1)
      System.out.println("Arctic track is current hit with a blizzard");
      num1 = 0;
      System.out.println();
      System.out.println("DESERT TRACK ");
      des.display();
      if(des.getCreatHeatwave() == 1 || num2 == 1)
        System.out.println("Desert track is current hit with a heatwave");
      num2 = 0;
      if(count > 0)   // if one of the end condition is reached, then quit //
        break;
  	}

    }

   
}