

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathan
 */
public class ScorePanel extends JPanel{
    public static JFrame frame;
    
    public void open() {
        frame = new JFrame("High Scores");
      frame.setSize(600, 400);
      frame.setLocation(200, 200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new ScorePanel());
      frame.setVisible(true);
    }
    
    public void close() {
        frame.setVisible(false);
    }
    
    public ScorePanel() {
      setLayout(new BorderLayout());
      setOpaque(true);
      setBackground(Color.blue);
      setForeground(Color.yellow);
      
      JPanel titlePanel = new JPanel();
      JLabel name = new JLabel("Name");
      name.setForeground(Color.yellow);
      titlePanel.add(name);
      JLabel score = new JLabel("Score");
      score.setForeground(Color.yellow);
      titlePanel.add(score);
      titlePanel.setBackground(Color.blue);
      add(titlePanel, BorderLayout.NORTH);
      
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new GridLayout(0,2));
      
      Scanner infile = null;
      try{
          infile = new Scanner(new File("scores.txt"));
          while(infile.hasNext()) {
          addPerson(mainPanel, infile.next(), infile.nextInt());
      }
      } catch(FileNotFoundException e) {
          System.out.println("File NOt Found");
      }
      
      
      titlePanel.setBackground(Color.blue);
      add(titlePanel, BorderLayout.CENTER);
    }
    
    private void addPerson(JPanel p, String s, int score) {
        JLabel newName = new JLabel(s);
        p.add(newName);
        JLabel newScore = new JLabel("" + score);
        p.add(newScore);
    }
}
