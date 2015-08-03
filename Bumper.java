// Abdalla Osman     7/14/15
import java.awt.*;
   
public class Bumper
{
    //private fields, all ints, for a Bumper
    //hint: the "location" of the bumper begins at its top left corner.      
   private double myX;   // x and y coordinates of center
   private double myY;
   private double myLength;
   private double myWidth;
   private Color myColor;   
  
   
     //constructors
   public Bumper()         //default constructor
   {
      myX = 300;
      myY = 300;
      myLength = 20;
      myWidth = 40;
      myColor = Color.GRAY;
   }
   public Bumper(int x, int y, int xWidth, int yWidth, Color c)
   {
      myX = x;
      myY = y;
      myWidth = xWidth;
      myLength = yWidth;
      myColor = c;
   }
      
      // accessor methods
   public double getX() 
   { 
      return myX;
   }
   public double getY()      
   { 
      return myY;
   }
   public double myWidth() 
   { 
      return myWidth;
   }
   
   public double myLength() 
   { 
      return myLength;
   }
   public Color getColor() 
   { 
      return myColor;
   }
   
// modifier methods
   public void setX(double x)
   {
      myX = x;
   } 
   public void setY(double y)
   {
      myY = y;
   } 
   public void setWidth(double w)
   {
      myWidth = w;  
   }
   public void setLength(double l)
   {
      myLength = l;
   }   
   public void setColor(Color c)
   {
      myColor = c;
   }
     // instance methods
     // chooses a random (x,y) location.  Bumper stays entirely in the window.

      
       // draws a rectangular bumper on the buffer
   public void draw(Graphics myBuffer) 
   {
      myBuffer.setColor(getColor());
      myBuffer.fillRect((int)getX(), (int)getY(), (int)myWidth(), (int)myLength());
   }   
   	// returns true if any part of the polkadot is inside the bumper

}
