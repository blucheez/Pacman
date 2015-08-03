//Name:              Date:

import java.awt.*;

public class Ghost implements Creature {

    private double dx;       // pixels to move each time step() is called.
    private double dy;
    private double myX;   // x and y coordinates of center
    private double myY;
    private double myDiameter;
    private Color myColor;
    private double myRadius;
    private boolean rightIsClear = true;
    private boolean leftIsClear = true;
    private boolean topIsClear = true;
    private boolean bottomIsClear = true;
    private int r = (int) (Math.random() * 4);

    // constructors
    public Ghost() //default constructor
    {
        myX = 240;
        myY = 140;
        myDiameter = 10;
        myColor = new Color((int)(Math.random()*150+50),(int)(Math.random()*150+50), (int)(Math.random()*150+50));
        myRadius = myDiameter / 2;
        dx = Math.random() * 12 - 6;          // to move vertically
        dy = Math.random() * 12 - 6;          // to move sideways
    }

    public Ghost(double x, double y, double dia, Color c) {
        myX = x;
        myY = y;
        myDiameter = dia;
        myColor = c;
        myRadius = dia / 2;
        dx = Math.random() * 12 - 6;
        dy = Math.random() * 12 - 6;
    }

    public int getSize() {
        return (int) (myDiameter / 2);
    }

    //modifier methods 
    public void setX(double x) {
        myX = x;
    }

    public void setY(double y) {
        myY = y;
    }

    //accessor methods
    public double getdx() {
        return dx;
    }

    public double getdy() {
        return dy;
    }

    public int getX() {
        return (int) myX;
    }

    public int getY() {
        return (int) myY;
    }

    public boolean isRightIsClear() {
        return rightIsClear;
    }

    public boolean isLeftIsClear() {
        return leftIsClear;
    }

    public boolean isTopIsClear() {
        return topIsClear;
    }

    public boolean isBottomIsClear() {
        return bottomIsClear;
    }

    /* //instance methods
     public void jump()
     {
     this.setdx(Math.random()* 12 - 6);
     this.setdy(Math.random() * 12 - 6);
     }
     */
    public void move(int x) {
        //ghost must keep moving until it hits a wall

        if (rightIsClear && r == 0) {
            setX(getX() + x);
            if (topIsClear && bottomIsClear) {
                setY(getY() + (randomDirection() * x));
            } else if (topIsClear) {
                setY(getY() - x);
            } else if (bottomIsClear) {
                setY(getY() + x);
            }
        } else if (!rightIsClear && r == 0) {
            r = (int) (Math.random() * 4);
        }

        if (leftIsClear && r == 1) {
            setX(getX() - x);
            if (topIsClear) {
                setY(getY() - x);
            } else if (bottomIsClear) {
                setY(getY() + x);
            }
        } else if (!leftIsClear && r == 1) {
            r = (int) (Math.random() * 4);
        }

        if (topIsClear && r == 2) {
            setY(getY() - x);
            if (leftIsClear) {
                setX(getX() - x);
            } else if (rightIsClear) {
                setX(getX() + x);
            }
        } else if (!topIsClear && r == 2) {
            r = (int) (Math.random() * 4);
        }

        if (bottomIsClear && r == 3) {
            setY(getY() + x);
            if (leftIsClear && rightIsClear) {
                setX(getX() + (randomDirection() * x));
            } else if (leftIsClear) {
                setX(getX() - x);
            } else if (rightIsClear) {
                setX(getX() + x);
            }
        } else if (!bottomIsClear && r == 3) {
            r = (int) (Math.random() * 4);
        }
    }

    /**
     * @param rightIsClear the rightIsClear to set
     */
    public void setRightIsClear(boolean rightIsClear) {
        this.rightIsClear = rightIsClear;
    }

    /**
     * @param leftIsClear the leftIsClear to set
     */
    public void setLeftIsClear(boolean leftIsClear) {
        this.leftIsClear = leftIsClear;
    }

    /**
     * @param topIsClear the topIsClear to set
     */
    public void setTopIsClear(boolean topIsClear) {
        this.topIsClear = topIsClear;
    }

    /**
     * @param bottomIsClear the bottomIsClear to set
     */
    public void setBottomIsClear(boolean bottomIsClear) {
        this.bottomIsClear = bottomIsClear;
    }

    public void draw(Graphics g) {
        g.setColor(myColor);
        g.fillOval((int) myX, (int) myY, (int) myDiameter, (int) myDiameter);
    }

    private int randomDirection() {
        int r = (int) (Math.random() * 2);
        if (r == 0) {
            return 1;
        }
        return -1;
    }
}
