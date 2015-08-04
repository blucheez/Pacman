
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class BumperPanel extends JPanel {

   public static int lives = 3;
   private static int xFRAME;
   private static int yFRAME;
   private static final Color BACKGROUND = Color.BLACK;
   private static final Color FOOD_COLOR = Color.YELLOW;
   private static final Color BUMPER_COLOR = Color.BLUE;
   private int slowCount = 0;
   private Polkadot[] pd;

   private BufferedImage myImage;
   private Graphics myBuffer;
   public static int score = 0;
   private Timer refresher;
   private Pacman pacman;
   private Ghost[] ghosts;
   private Color[][] bluePixels;
   private Map map;
   private DotProcess dotprocessor;

   public BumperPanel(int x, int y, int ghgosts) {
      xFRAME = x;
      yFRAME = y;
      myImage = new BufferedImage(xFRAME, yFRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      map = new Map();
      bluePixels = map.getArray();
      pacman = new Pacman(20, 280);
      dotprocessor = new DotProcess(xFRAME, yFRAME);
      
      pd = new Polkadot[20000];
      for (int i = 0; i < pd.length; i++) {
         pd[i] = new Polkadot();
      }
      dotprocessor.placeDots(pd, bluePixels);
   
      ghosts = new Ghost[ghgosts];
      for (int i = 0; i < ghosts.length; i++) {
         ghosts[i] = new Ghost();
      }
   // ghosts[1] = new Ghost(260, 140);
      //   	ghosts[2] = new Ghost(240, 160);
      //   	ghosts[3] = new Ghost(250, 150);
      //   	ghosts[0] = new Ghost(240, 140);
   
      refresher = new Timer(1, new Refresh());
   
      refresher.start();
      setFocusable(true);
      addKeyListener(new Key());
   
   }

   public static void setLives(int x)
   {
      //x = Integer.parseInt(JOptionPane.showInputDialog("Set Lives: "));
      lives = x;
   }

 public static void setScore(int x)
   {
      //x = Integer.parseInt(JOptionPane.showInputDialog("Set Lives: "));
      score = x;
   }

   public static int getLives()
   {
      return lives;
   }
   
   
   public static int getScore()
   {
      return score;
   }

   public void paintComponent(Graphics g) {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }

   public class Key extends KeyAdapter
   {
   
      public void keyPressed(KeyEvent e)
      {
         //System.out.println(e.getKeyCode());
         if ((e.getKeyCode() == KeyEvent.VK_UP) && (pacman.getY() > 15)) {
            pacman.moveVertical(-5);
         }
         if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (pacman.getY() < 285)) {
            pacman.moveVertical(5);
         }
         if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (pacman.getX() < 485)) {
            pacman.moveHorizontal(5);
         }
         if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (pacman.getX() > 15)) {
            pacman.moveHorizontal(-5);
         }
      }
   }

   private class Refresh implements ActionListener 
   {
   
      public void actionPerformed(ActionEvent e)
      {
      
         //draws the background map
         myBuffer.drawImage(map.getImage(), 0, 0, xFRAME, yFRAME, null);
         
         //draws pacman, checks for collisions
         pacman.draw(myBuffer);
         WallCollision.checkNorth(pacman, bluePixels);
         WallCollision.checkEast(pacman, bluePixels);
         WallCollision.checkSouth(pacman, bluePixels);
         WallCollision.checkWest(pacman, bluePixels);
      
         //moves the ghosts every 7th decision
         if (slowCount == 7) {
            for (int i = 0; i < ghosts.length; i++) {
               
               ghosts[i].draw(myBuffer);
               WallCollision.checkNorth(ghosts[i], bluePixels);
               WallCollision.checkEast(ghosts[i], bluePixels);
               WallCollision.checkSouth(ghosts[i], bluePixels);
               WallCollision.checkWest(ghosts[i], bluePixels);
               ghosts[i].move(5);
               
               //checks for when pacman ouches the ghost
               if (DeathByGhost.collide(pacman, ghosts[i])) {
                  lives--;
                  pacman.setX(20);
                  pacman.setY(280);
                  for (int q = 0; q < ghosts.length; q++) {
                     ghosts[q] = new Ghost();
                  }
                  if (lives==0)
                  GameOver.endGame(ghosts.length);
               }
            }
            slowCount = 0;
         }
         slowCount++;
         
         //draw the ghosts
         for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].draw(myBuffer);
         }
         
         //checks for dot collisions
         for (int i=0; i<pd.length; i++)
            if (PolkadotCollision.collide(pacman, pd[i]))
            {
               score++;
               pd[i].setValid(false);
               pd[i].setY(pd[i].getY()+300);
            }
         
                     
         //displays the lives left
         myBuffer.setColor(Color.white);
         myBuffer.setFont(new Font("Monospaced", Font.BOLD, 8));
         myBuffer.drawString("Lives:" + lives, 430, 60);
         
         //displays the score
         myBuffer.setColor(Color.white);
         myBuffer.setFont(new Font("Monospaced", Font.BOLD, 8));
         myBuffer.drawString("Score:" + score, 30, 60);
         
         //draw the dots
         if (lives==3)
         {
            dotprocessor.drawDots(pd, myBuffer);
            for (int k=0; k<pd.length; k++)
               pd[k].setValid(true);
         }
         else
            dotprocessor.drawValidDots(pd, myBuffer);
            
         repaint();
      }
   }

}
