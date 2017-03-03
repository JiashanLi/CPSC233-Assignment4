// Jiashan Li   10171607 Lec 01, T04 //
// Version: 2015.11.6 //

public class SUV extends Car
{

   public SUV()
   {
    setAppearance('V');
    setFuel (50);
   }


// the situation of fuel consume and distance move  when there is no blizzard//
   public void Move()
	{
      consumeFuel(3);
      distance = STANDARD_DISTANCE;
      System.out.println("Current fuel: " + getFuel());
	  System.out.println("Fuel use: 3");
	  System.out.println("Distance SUV moved: "+ distance);
	}


// the situation of fuel consume and distance move in a normal mode when there is a blizzard//
	public void NomalMoveBlizzard()
	{
      consumeFuel(3);
      distance = 0;
      System.out.println("Current fuel: " +  getFuel());
	  System.out.println("Fuel use: 3");
	  System.out.println("Distance SUV moved: "+ distance);
	}


// the situation of fuel consume and distance move in a AWD mode when there is a blizzard//
	public void AWDMoveBlizzard()
	{
		consumeFuel(3);
		distance = 1;
	    System.out.println("Current fuel: " +  getFuel());
	    System.out.println("Fuel use: 3");
	    System.out.println("Distance SUV moved: "+ distance);
	}

// the situation of fuel consume and distance move in a normal mode when the location is 23 when there is no blizzard//
	public void setlocationMove()
	{
      consumeFuel(3);
      distance = 1;
      System.out.println("Current fuel: " + getFuel());
	  System.out.println("Fuel use: 3");
	  System.out.println("Distance SUV moved: "+ distance);
	}

}