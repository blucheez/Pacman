import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Winner extends JPanel{
   public static JFrame endFrame;
   public static void endGame() {
      endFrame = new JFrame("CONGRATULATIONS!");
      endFrame.setSize(400, 400);
      endFrame.setLocation(200, 200);
      endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      endFrame.setContentPane(new GameOver());
      endFrame.setVisible(true);
   }
   
   public Winner() {
      setLayout(new GridLayout(2, 1));
    
      JLabel label = new JLabel("You won!", SwingConstants.CENTER);
      label.setFont(new Font("Arial", Font.BOLD, 50));
      add(label);
     	 
      JButton button = new JButton("Start Again");
      button.setBackground(Color.BLUE);
      button.setFont(new Font("Arial", Font.BOLD, 20));
      button.setForeground(Color.white);
      add(button);
   }
}