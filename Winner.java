import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Winner extends JPanel{
   public static JFrame endFrame;
   public static void endGame() {
      endFrame = new JFrame("CONGRATULATIONS!");
      endFrame.setSize(400, 400);
      endFrame.setLocation(200, 200);
      endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      endFrame.setContentPane(new Winner());
      endFrame.setVisible(true);
   }
   
   public Winner() {
      setLayout(new GridLayout(0, 1));
      try{
         System.setOut(new PrintStream(new FileOutputStream("scores.txt", true)));
      } 
      catch(Exception e) {
         System.out.println("File not found");
      }
      JLabel label = new JLabel("You won!", SwingConstants.CENTER);
      label.setFont(new Font("Arial", Font.BOLD, 50));
      add(label);
      
      JLabel scored = new JLabel("You scored: " + BumperPanel.getScore(), SwingConstants.CENTER);
      scored.setFont(new Font("Arial", Font.BOLD, 20));
      add(scored);
      
      add(makeField("Name: ")); 
     	 
      JButton button = new JButton("Start Again");
      button.setBackground(Color.BLUE);
      button.setFont(new Font("Arial", Font.BOLD, 20));
      button.setForeground(Color.white);
      button.addActionListener(new Listener());
      add(button);
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

   private class Listener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         BumperPanel.setLives(3);
            Winner.endFrame.setVisible(false);
            Driver.frame.setVisible(false);
            Start.menuFrame.setVisible(true);
            BumperPanel.setScore(0);
      }
   }
}