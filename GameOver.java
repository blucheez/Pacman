import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GameOver extends JPanel{
   public static JFrame endFrame;
   private static int ghosts;
   public static void endGame(int g) {
      endFrame = new JFrame("OH NO!");
      endFrame.setSize(400, 400);
      endFrame.setLocation(200, 200);
      endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      endFrame.setContentPane(new GameOver());
      endFrame.setVisible(true);
      ghosts = g;
   }
   
   public GameOver() {
      setLayout(new GridLayout(2, 1));
      try{
         System.setOut(new PrintStream(new FileOutputStream("scores.txt", true)));
      } 
      catch(Exception e) {
         System.out.println("File not found");
      }
      JLabel label = new JLabel("You lost!", SwingConstants.CENTER);
      label.setFont(new Font("Arial", Font.BOLD, 50));
      add(label);
     	 
      JLabel scored = new JLabel("You scored: " + BumperPanel.getScore(), SwingConstants.CENTER);
      scored.setFont(new Font("Arial", Font.BOLD, 20));
      add(scored);
      
      
      
      add(makeField("Name: ")); 
       
      JButton button = new JButton("Start Again");
      button.setBackground(Color.BLUE);
      button.addActionListener(new Listener());
      button.setFont(new Font("Arial", Font.BOLD, 20));
      button.setForeground(Color.white);
      add(button);
   }
   
   private class Listener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
         if (BumperPanel.getLives()>0)
         {
            BumperPanel.setLives(BumperPanel.getLives()-1);
            GameOver.endFrame.setVisible(false);
            Driver.frame.setVisible(false);
            Driver.gameFrame(ghosts);
         }
         else
         {
            BumperPanel.setLives(3);
            GameOver.endFrame.setVisible(false);
            Driver.frame.setVisible(false);
            Start.menuFrame.setVisible(true);
            BumperPanel.setScore(0);
         }
      }
   }
   
   private JPanel makeField(String s) {
      JPanel p = new JPanel();
      JLabel temp = new JLabel(s);
      temp.setFont(new Font("Arial", Font.ITALIC, 20));
      p.add(temp);
      
      JTextField field = new JTextField(10);
      p.add(field);
      
      JButton enter = new JButton("Enter");
      enter.addActionListener(new EnterField(field));
      p.add(enter);
      return p;
   }
   
   private class EnterField implements ActionListener {
      private JTextField x;
      public EnterField(JTextField f) {
         x = f;
      }
      
      public void actionPerformed(ActionEvent e) {
         System.out.println(x.getText());
         System.out.println(BumperPanel.getScore());
      }
   }
}


