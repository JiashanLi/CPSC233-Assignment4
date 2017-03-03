// Jiashan Li   10171607 Lec 01, T04 //
// Version: 2015.11.6 //

import java.util.Random;

public class ArcticTrack extends Track
{
   private int blizzard;
   private SUV suv;


   public ArcticTrack()
   {
    suv = new SUV();
    setLocation(suv, 0);
   }


// randomly creat a blizzard in the SUV track //
   public void CreatBlizzard()
   {
    int n;
    Random r = new Random();
    n = r.nextInt(100);
    if(n < 10)
       blizzard = 1;
    else if (n >= 10 && n < 100)
       blizzard = 0;
   }


// get the value of blizzard to check whether the blizzard happens //
  public int getCreatBlizzard()
  {
    return blizzard;
  }


// the normal move mode when there is a blizzard//
   public void NormalMoveBlizzard()
   {
         int location;
     	   if(suv.isEmpty() == false)
          {
            suv.NomalMoveBlizzard();
            location = getLocation();
            setLocation(suv, location + suv.getdistance());
          }
   }
  

// the AWD move mode when there is a blizzard//
  public void AWDMoveBlizzard()
   {
     int location;
         if(suv.isEmpty() == false)
          {
             suv.AWDMoveBlizzard();
             location = getLocation();
             setLocation(suv, location + suv.getdistance());
             setnull(location);
          }

  }
   

// the move mode when there is no blizzard ( the AWD and normal mode is the same at this situation)//
  public void Move()
   {
     int location;
        if(suv.isEmpty() == false)
          {
            if(getLocation() == 23)    // if the location is 23, only move 1 distance, not 2//
            {
              suv.setlocationMove();
              location = getLocation();
              setLocation(suv, location + suv.getdistance());
              setnull(location);
            }
            else if(getLocation() != 23)
            {
            suv.Move();
            location = getLocation();
            setLocation(suv, location + suv.getdistance());
            setnull(location);
            }
          }
    }


// set fuel value of the car manually //
   public void setfuel(int newfuel)
  {
    suv.setFuel(newfuel);
    setLocation(suv, getLocation());
  }


// get the fuel value of the car //
  public int getfuel()
  {
    return suv.getFuel();
  }


// change the position of the car manually // 
    public void movemanual(int location)
    {
       int position = 0;
       position = getLocation();
       setLocation(suv, location);
       if(location != position)
          setnull(position);     
    }

}