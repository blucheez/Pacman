import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathan
 */
public abstract class Movement implements ActionListener{
    public static int speed = 0;
    public void actionPerformed(ActionEvent e) {
        move();
    }
    public abstract void move();
    public static void setSpeed(int s) {
        speed = s;
    }
}
