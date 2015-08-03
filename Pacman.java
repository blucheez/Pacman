import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Pacman implements Creature
{
    private int myX;
    private int myY;
    private ImageIcon myImage;
    private boolean rightIsClear = true, topIsClear = true, leftIsClear = true, bottomIsClear = true;
    private Timer left, right, up, down;
    private int myRadius = 5;
    
    public Pacman(int x, int y){
        myX = x;
        myY = y;
        left = new Timer(100, (ActionListener) new leftMovement());
        right = new Timer(100, (ActionListener) new rightMovement());
        up = new Timer(100, (ActionListener) new upMovement());
        down = new Timer(100, (ActionListener) new downMovement());
    }

    /**
     * @return the myX
     */
    public int getX() {
        return myX;
    }
    
    public int getSize() {
        return myRadius;
    }
    /**
     * @param myX the myX to set
     */
    public void setX(int myX) {
        this.myX = myX;
    }

    /**
     * @return the myY
     */
    public int getY() {
        return myY;
    }

    /**
     * @param myY the myY to set
     */
    public void setY(int myY) {
        this.myY = myY;
    }
    
    public void moveVertical(int y) {
        if(y < 0 && isTopIsClear()) {
            Movement.setSpeed(y);
            up.start();
            down.stop();
            left.stop();
            right.stop();
            return;
        }
        if(y > 0 && isBottomIsClear()) {
            Movement.setSpeed(-1 * y);
            down.start();
            up.stop();
            left.stop();
            right.stop();
            return;
        } 
    }
    
    public void moveHorizontal(int x) {
        
        if(x > 0 && isRightIsClear()) {
            Movement.setSpeed(x);
            right.start();
            down.stop();
            left.stop();
            up.stop();
            return;
        }
        else if(x < 0 && isLeftIsClear()) {
            Movement.setSpeed(-1 * x);
            left.start();
            down.stop();
            up.stop();
            right.stop();
            return;
        } 
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(myX, myY, 2 * myRadius, 2 * myRadius);
    }

    /**
     * @return the rightIsClear
     */
    public boolean isRightIsClear() {
        return rightIsClear;
    }

    /**
     * @param rightIsClear the rightIsClear to set
     */
    public void setRightIsClear(boolean rightIsClear) {
        this.rightIsClear = rightIsClear;
    }

    /**
     * @return the topIsClear
     */
    public boolean isTopIsClear() {
        return topIsClear;
    }

    /**
     * @param topIsClear the topIsClear to set
     */
    public void setTopIsClear(boolean topIsClear) {
        this.topIsClear = topIsClear;
    }

    /**
     * @return the leftIsClear
     */
    public boolean isLeftIsClear() {
        return leftIsClear;
    }

    /**
     * @param leftIsClear the leftIsClear to set
     */
    public void setLeftIsClear(boolean leftIsClear) {
        this.leftIsClear = leftIsClear;
    }

    /**
     * @return the bottomIsClear
     */
    public boolean isBottomIsClear() {
        return bottomIsClear;
    }

    /**
     * @param bottomIsClear the bottomIsClear to set
     */
    public void setBottomIsClear(boolean bottomIsClear) {
        this.bottomIsClear = bottomIsClear;
    }
    
    
    private class upMovement extends Movement {
        
        public void move() {
            if(topIsClear)
            myY += super.speed;
        }
    }

    private class downMovement extends Movement {

        public void move() {
            if(bottomIsClear)
            myY -= super.speed;
        }
    }
    
    private class rightMovement extends Movement {

        public void move() {
            if(rightIsClear)
            myX += super.speed;
        }
    }
    
    private class leftMovement extends Movement {

        public void move() {
            if(leftIsClear)
            myX -= super.speed;
        }
    }
}


