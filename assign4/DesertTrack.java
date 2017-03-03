// Jiashan Li   10171607 Lec 01, T04 //
// Version: 2015.11.6 //

import java.util.Random;

public class DesertTrack extends Track
{
  private int heatwave;
  private Sports spo;

   public DesertTrack()
   {
    spo = new Sports();
    setLocation(spo, 0);
   }


// randomly creat a heatwave in the desert track //
   public void CreatHeatwave()
   {
    int n;
    Random r = new Random();
    n = r.nextInt(100);    // there is 10% probability to generate a heatwave //
    if(n < 10)
       heatwave = 1;
    else if (n >= 10 && n < 100)
       heatwave = 0;
   }


// get the value of heatwave to check whether the heatwave happens //
  public int getCreatHeatwave()
  {
    return heatwave;
  }


// the move mode when there is no heatwave//
   public void Nomalmove()
   {
     int location;
         if(spo.isEmpty() == false)   // if the fuel of the car is not empty //
          {
            if (getLocation() == 22)   // if the location is 22, only move 2 distance, not 3//
            {
              spo.setlocationMove22();
              location = getLocation();
              setLocation(spo, location + spo.getdistance());
              setnull(location);
            } 
            else if(getLocation() == 23)  // if the location is 23, only move 1 distance, not 3//
            {
              spo.setlocationMove23();
              location = getLocation();
              setLocation(spo, location + spo.getdistance());
              setnull(location);
            }
            else 
            {
            spo.NomalMove();
            location = getLocation();
            setLocation(spo, location + spo.getdistance());
            setnull(location);
          }
          }
  }


// the move mode when there is a heatwave//
   public void Heatwavemove()
   {
     int location;
         if(spo.isEmpty() == false)
          {
            if (getLocation() == 22)
            {
              spo.setlocationHeatwaveMove22();
              location = getLocation();
              setLocation(spo, location + spo.getdistance());
              setnull(location);
            } 
            else if(getLocation() == 23)
            {
              spo.setlocationHeatwaveMove23();
              location = getLocation();
              setLocation(spo, location + spo.getdistance());
              setnull(location);
            }
            else
            {
            spo.HeatwaveMove();
            location = getLocation();
            setLocation(spo, location + spo.getdistance());
            setnull(location);
           }
          }
   }


// set fuel value of the car manually //
  public void setfuel(int newfuel)
  {
    spo.setFuel(newfuel);
    setLocation(spo, getLocation());
  }


// get the fuel value of the car //
  public int getfuel()
  {
    return spo.getFuel();
  }


// change the position of the car manually // 
    public void movemanual(int location)
    {
       int position;
       position = getLocation();
       setLocation(spo, location);
       if(location != position)
         setnull(position);     
    }

}