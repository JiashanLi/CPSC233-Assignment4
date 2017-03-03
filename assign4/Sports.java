// Jiashan Li   10171607 Lec 01, T04 //
// Version: 2015.11.6 //

public class Sports extends Car
{

	public Sports()
	{
	  setAppearance('P');
      setFuel (30);
	}


// the situation of fuel consume and distance move when there is no heatwave//
	public void NomalMove()
	{
      consumeFuel(2);
      distance = 3;
      System.out.println("Current fuel: " +  getFuel());
	  System.out.println("Fuel use: 2");
	  System.out.println("Distance Sports car moved: "+ distance);
	}


// the situation of fuel consume and distance move  when there is a heatwave//
	public void HeatwaveMove()
	{
		consumeFuel(4);
		distance = 3;
	    System.out.println("Current fuel: " +  getFuel());
	    System.out.println("Fuel use: 4");
	    System.out.println("Distance Sports car moved: "+ distance);
	}


// the situation of fuel consume and distance move  when the location is 22 when there is a heatwave//
	public void setlocationHeatwaveMove22()
	{
		consumeFuel(4);
		distance = 2;
	    System.out.println("Current fuel: " +  getFuel());
	    System.out.println("Fuel use: 4");
	    System.out.println("Distance Sports car moved: "+ distance);
	}


// the situation of fuel consume and distance move  when the location is 23 when there is a heatwave//
	public void setlocationHeatwaveMove23()
	{
		consumeFuel(4);
		distance = 1;
	    System.out.println("Current fuel: " +  getFuel());
	    System.out.println("Fuel use: 4");
	    System.out.println("Distance Sports car moved: "+ distance);
	}


// the situation of fuel consume and distance move  when the location is 22 when there is no heatwave//
	public void setlocationMove22()
	{
		consumeFuel(2);
		distance = 2;
	    System.out.println("Current fuel: " +  getFuel());
	    System.out.println("Fuel use: 4");
	    System.out.println("Distance Sports car moved: "+ distance);
	}


// the situation of fuel consume and distance move  when the location is 23 when there is no heatwave//
	public void setlocationMove23()
	{
		consumeFuel(2);
		distance = 1;
	    System.out.println("Current fuel: " +  getFuel());
	    System.out.println("Fuel use: 4");
	    System.out.println("Distance Sports car moved: "+ distance);
	}

}