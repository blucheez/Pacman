import
javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel
{


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
buttonPanel.setLayout(new GridLayout(3, 1));

JButton play = new JButton("Play");
play.setBackground(Color.blue);
play.setForeground(Color.YELLOW);
play.addActionListener(new PlayListener());
play.setFocusPainted(false);
buttonPanel.add(play);

JButton option = new JButton("Options");
option.setBackground(Color.blue);
option.setEnabled(false);
option.setForeground(Color.YELLOW);
option.addActionListener(new OptionListener());
option.setFocusPainted(false);
buttonPanel.add(option);

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
Driver.gameFrame();
}
}
 
private class OptionListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
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



