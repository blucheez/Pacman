import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel{
   public static JFrame endFrame;
   public static void endGame() {
      endFrame = new JFrame("OH NO!");
      endFrame.setSize(400, 400);
      endFrame.setLocation(200, 200);
      endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      endFrame.setContentPane(new GameOver());
      endFrame.setVisible(true);
   }
   
   public GameOver() {
      setLayout(new GridLayout(2, 1));
    
      JLabel label = new JLabel("You lost!", SwingConstants.CENTER);
      label.setFont(new Font("Arial", Font.BOLD, 50));
      add(label);
     	 
      JButton button = new JButton("Start Again");
      button.setBackground(Color.BLUE);
      button.addActionListener(new Listener());
      button.setFont(new Font("Arial", Font.BOLD, 20));
      button.setForeground(Color.white);
      add(button);
   }
   
   private class Listener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (BumperPanel.getScore()==195)
         {
         BumperPanel.setLives(3);
            Winner.endFrame.setVisible(false);
            Driver.frame.setVisible(false);
            Start.menuFrame.setVisible(true);
            }
         if (BumperPanel.getLives()>0)
         {
            BumperPanel.setLives(BumperPanel.getLives()-1);
            GameOver.endFrame.setVisible(false);
            Driver.frame.setVisible(false);
            Driver.gameFrame();
         }
         else
         {
            BumperPanel.setLives(3);
            GameOver.endFrame.setVisible(false);
            Driver.frame.setVisible(false);
            Start.menuFrame.setVisible(true);
         }
      }
   }
}


