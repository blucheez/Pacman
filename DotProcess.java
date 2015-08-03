
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;



/**
 *
 * @author Nathan
 */
public class DotProcess {
    private int YFRAME;
    private int XFRAME;
    private ArrayList<Integer> xDots;
    private ArrayList<Integer> yDots;
    
    public DotProcess(int x, int y) {
        XFRAME = x;
        YFRAME = y;
        xDots = new ArrayList<>();
        yDots = new ArrayList<>();
    }
    //takes in a polka dot array, checks each place by 10 hor and 10 vertical, puts one there if possible
    public void placeDots(Polkadot pd[], Color[][] pixels) {
        for(int y = 0; y < pixels.length; y += 10) {
            for(int x = 0; x < pixels[0].length; x += 10) {
                if(pixels[y][x].getBlue() <= pixels[y][x].getRed() + pixels[y][x].getGreen()) {
                    xDots.add(x);
                    yDots.add(y);
                }
            }
        }
        for(int i = 0; i < xDots.size(); i++) {
            pd[i].setX(xDots.get(i));
            pd[i].setY(yDots.get(i));
        }
    }
    
    public void drawDots(Polkadot pd[], Graphics g) {
        for (int i = 0; i < pd.length; i++) {
            pd[i].draw(g);
        }
    }
}
