/*
  Author:  James Tam
  Version: April 1, 2013

  The sole purpose of this class is track if the program is in debugging mode.

 */
public class Debug
{
    
    public static boolean on = false;

    // turn the debug mode on //
    public static boolean Debugon()   
    {
    	on = true;
    	return on;
    }
}