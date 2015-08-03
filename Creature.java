
public interface Creature {
    public boolean isTopIsClear();
    public boolean isRightIsClear();
    public boolean isBottomIsClear();
    public boolean isLeftIsClear();
    
    public void setTopIsClear(boolean b);
    public void setRightIsClear(boolean b);
    public void setBottomIsClear(boolean b);
    public void setLeftIsClear(boolean b);
    
    public int getX();
    public int getY();
    public int getSize();
}
