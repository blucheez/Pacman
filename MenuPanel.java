import
javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel
{
private int numOfGhosts = 0;

public MenuPanel()
{
setLayout(new GridLayout(2, 1)); //sets two sections, one for title, one for buttons
setOpaque(true);
setBackground(Color.BLUE);
setForeground(Color.YELLOW);

JLabel title = new JLabel("Pac-Man", SwingConstants.CENTER);
title.setFont(new Font("Arial", Font.BOLD, 50));
title.setForeground(Color.YELLOW);
add(title); //THIS IS THE TITLE

JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new GridLayout(4, 1));

JButton play = new JButton("Play");
play.setBackground(Color.blue);
play.setForeground(Color.YELLOW);
play.addActionListener(new PlayListener());
play.setFocusPainted(false);
buttonPanel.add(play);

JButton option = new JButton("Options");
option.setBackground(Color.blue);
option.setEnabled(true);
option.setForeground(Color.YELLOW);
option.addActionListener(new OptionListener());
option.setFocusPainted(false);
buttonPanel.add(option);

JButton scores = new JButton("High Scores");
scores.setBackground(Color.blue);
scores.setForeground(Color.YELLOW);
scores.addActionListener(new ScoreListener());
scores.setFocusPainted(false);
buttonPanel.add(scores);

JButton quit = new JButton("Quit");
quit.setBackground(Color.blue);
quit.setForeground(Color.YELLOW);
quit.addActionListener(new QuitListener());
quit.setFocusPainted(false);
buttonPanel.add(quit);


add(buttonPanel);
}


private class PlayListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
Start.menuFrame.setVisible(false);
Driver.gameFrame(numOfGhosts);
}
}
 
private class OptionListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
    numOfGhosts = Integer.parseInt(JOptionPane.showInputDialog("How many ghosts?"));
}
}

private class ScoreListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
    ScorePanel sp = new ScorePanel();
    sp.open();
}
}

private class QuitListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
System.exit(0);
}
}

}