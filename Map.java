//Abdalla Osman      7/30/15
import java.util.ArrayList;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

   
public class Map extends JPanel
{
   private Graphics myBuffer;
   private BufferedImage myImage;
   private ArrayList<Bumper> bump;
   private static final Color BUMPER_COLOR = Color.BLUE;
   private Timer timer; 
 
   public Map()
   {
      myImage =  new BufferedImage(500, 300, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
         
      bump = new ArrayList<Bumper>();
      //four boxes
      bump.add( new Bumper (30, 220, 50, 50, BUMPER_COLOR));
      bump.add( new Bumper (100, 220, 50, 50, BUMPER_COLOR));
      bump.add( new Bumper (350, 220, 50, 50, BUMPER_COLOR));
      bump.add( new Bumper (420, 220, 50, 50, BUMPER_COLOR));
      bump.add( new Bumper (30, 30, 50, 50, BUMPER_COLOR));
      bump.add( new Bumper (100, 30, 50, 50, BUMPER_COLOR));
      bump.add( new Bumper (350, 30, 50, 50, BUMPER_COLOR));
      bump.add( new Bumper (420, 30, 50, 50, BUMPER_COLOR));
      //outer walls
      bump.add( new Bumper (0, 0, 10, 300, BUMPER_COLOR));
      bump.add( new Bumper (10, 0, 490, 10, BUMPER_COLOR));
      bump.add( new Bumper (490, 10, 10, 290, BUMPER_COLOR));
      bump.add( new Bumper (10, 290, 490, 10, BUMPER_COLOR));
      //four extrusions   
      bump.add( new Bumper (170, 220, 20, 70, BUMPER_COLOR));
      bump.add( new Bumper (310, 220, 20, 70, BUMPER_COLOR));
      bump.add( new Bumper (170, 10, 20, 70, BUMPER_COLOR));
      bump.add( new Bumper (310, 10, 20, 70, BUMPER_COLOR)); 
      //four little nubs  
      bump.add( new Bumper (310, 180, 10, 20, BUMPER_COLOR));   
      bump.add( new Bumper (180, 180, 10, 20, BUMPER_COLOR));
      bump.add( new Bumper (310, 100, 10, 20, BUMPER_COLOR));
      bump.add( new Bumper (180, 100, 10, 20, BUMPER_COLOR));
      //two I's
      bump.add( new Bumper (210, 250, 80, 20, BUMPER_COLOR));
      bump.add( new Bumper (210, 210, 80, 20, BUMPER_COLOR));
      bump.add( new Bumper (210, 30, 80, 20, BUMPER_COLOR));
      bump.add( new Bumper (210, 70, 80, 20, BUMPER_COLOR)); 
      bump.add( new Bumper (240, 50, 20, 20, BUMPER_COLOR));
      bump.add( new Bumper (240, 230, 20, 20, BUMPER_COLOR)); 
      //ghost spawn
      bump.add( new Bumper (210, 130, 20, 60, BUMPER_COLOR)); 
      bump.add( new Bumper (270, 130, 20, 60, BUMPER_COLOR));
      bump.add( new Bumper (230, 170, 40, 20, BUMPER_COLOR));
      bump.add( new Bumper (210, 110, 30, 20, BUMPER_COLOR)); 
      bump.add( new Bumper (260, 110, 30, 20, BUMPER_COLOR));
      //left y  
      bump.add( new Bumper (10, 140, 20, 20, BUMPER_COLOR));   
      bump.add( new Bumper (30, 100, 20, 100, BUMPER_COLOR));
      bump.add( new Bumper (50, 100, 30, 20, BUMPER_COLOR));
      bump.add( new Bumper (50, 180, 30, 20, BUMPER_COLOR));
      //right y  
      bump.add( new Bumper (470, 140, 20, 20, BUMPER_COLOR));   
      bump.add( new Bumper (450, 100, 20, 100, BUMPER_COLOR));
      bump.add( new Bumper (420, 100, 30, 20, BUMPER_COLOR));
      bump.add( new Bumper (420, 180, 30, 20, BUMPER_COLOR));
      //left crosses 
      bump.add( new Bumper (70, 140, 120, 20, BUMPER_COLOR));   
      bump.add( new Bumper (100, 100, 20, 100, BUMPER_COLOR));
      bump.add( new Bumper (140, 100, 20, 100, BUMPER_COLOR));
      //right crosses 
      bump.add( new Bumper (310, 140, 120, 20, BUMPER_COLOR));   
      bump.add( new Bumper (340, 100, 20, 100, BUMPER_COLOR));
      bump.add( new Bumper (380, 100, 20, 100, BUMPER_COLOR));
      
      for (int k=0; k<bump.size(); k++)
         {
            bump.get(k).draw(myBuffer);
         }
      
      
      
   }
   
   public Color[][] getArray()
   {
      Color[][] arr;
   	//
      int numcols = myImage.getWidth();
      int numrows = myImage.getHeight();
   	//
      arr = new Color[numrows][numcols];
   	//
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            int rgb = myImage.getRGB(k,j);
         	//
            arr[j][k] = new Color(rgb);
         }
      }
   	//
      return arr;
   }
   
   public void setImage(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            //
            int rgb = tmp.getRGB();
            //
            myImage.setRGB(k,j,rgb);
         }
      }
   }

  public BufferedImage getImage() {
      return myImage;
  }
}
