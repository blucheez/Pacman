import java.awt.Color;


public class WallCollision {
    private static int rangeFinder = 11;
    public static void checkNorth(Creature c, Color[][] array) {
        //get the y value of the creature, subtract 11, see if that place is a blue pixel
        if(array[c.getY() - rangeFinder + c.getSize()][c.getX() + c.getSize()].getBlue() > array[c.getY() - 11 + c.getSize()][c.getX() + c.getSize()].getRed()) {
            c.setTopIsClear(false);
        } else {
            c.setTopIsClear(true);
        }
    }
    
    public static void checkEast(Creature c, Color[][] array) {
        //check if x + 11 is clear
        if(array[c.getY() + c.getSize()][c.getX() + rangeFinder + c.getSize()].getBlue() > array[c.getY() + c.getSize()][c.getX() + 11 + c.getSize()].getRed()) {
            c.setRightIsClear(false);
        } else {
            c.setRightIsClear(true);
        }
    }
    
    public static void checkSouth(Creature c, Color[][] array) {
        //check if y + 11 is clear
        if(array[c.getY() + rangeFinder + c.getSize()][c.getX() + c.getSize()].getBlue() > array[c.getY() + 11 + c.getSize()][c.getX() + c.getSize()].getRed()) {
            c.setBottomIsClear(false);
        } else {
            c.setBottomIsClear(true);
        }
    }
    
    public static void checkWest(Creature c, Color[][] array) {
        //check if x - 11 is clear
        if(array[c.getY() + c.getSize()][c.getX() - rangeFinder + c.getSize()].getBlue() > array[c.getY() + c.getSize()][c.getX() - 11 + c.getSize()].getRed()) {
            c.setLeftIsClear(false);
        } else {
            c.setLeftIsClear(true);
        }
    }
}
