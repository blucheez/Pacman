// Billington.  email: mlbillington@fcps.edu
// version: 7.25.2007
// updated by Phil Ero 16NOV07

import java.awt.*;

public class Polkadot
{
private boolean valid = true;
   private double myX;   // x and y coordinates of center
   private double myY;
   private double myDiameter;
   private Color myColor; 
   private double myRadius;
   private boolean canBeDrawn = false;
  // constructors
   public Polkadot(int x, int y)     //default constructor
   {
      myX = x;
      myY = y;
      myDiameter = 4;
      myColor = Color.YELLOW;
      myRadius = myDiameter/2;
      canBeDrawn = true;
   }
   public Polkadot()
   {
      myDiameter = 4;
      myColor = Color.YELLOW;
      myRadius = myDiameter / 2;
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
   public double getDiameter() 
   { 
     return myDiameter;
   }
   public Color getColor() 
   { 
      return myColor;
   }
   public double getRadius() 
   { 
      return myRadius;
   }
   public boolean getValidity()
   {
   return valid;
   }
// modifier methods
   public void setValid(boolean x)
   {
   valid = x;
   }
   public void setX(double x)
   {
      myX = x;
      canBeDrawn = true;
      myY = 0;
   } 
   public void setY(double y)
   {
     myY = y;
     canBeDrawn = true;
   } 
   public void setColor(Color c)
   {
      myColor = c;
   }
   public void setDiameter(double d)
   {
      myDiameter = d;
      myRadius = d/2;
   }
   public void setRadius(double r)
   {
      myRadius = r;
      myDiameter = 2*r;
   }
 //     instance methods
   public void jump(int rightEdge, int bottomEdge)
   {
      // moves location to random (x, y) within the edges
      myX = (Math.random()* (rightEdge-myDiameter) + myRadius);
      myY = (Math.random()* (bottomEdge-myDiameter) + myRadius);
   }
  
   public void draw(Graphics myBuffer) 
   {
      if(canBeDrawn) {
      myBuffer.setColor(myColor);
      myBuffer.fillOval((int)(getX() - getRadius()), (int)(getY()-getRadius()), (int)getDiameter(), (int)getDiameter());
      }
   }
}

