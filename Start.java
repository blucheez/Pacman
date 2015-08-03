import
javax.swing.*;

public class Start 
{
   public static JFrame menuFrame;
   public static void main(String[] args)
   {
      menuFrame = new JFrame("PACMAN");
      menuFrame.setSize(300, 400);
      menuFrame.setLocation(200, 200);
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      menuFrame.setContentPane(new MenuPanel());
      menuFrame.setVisible(true);
   }
}