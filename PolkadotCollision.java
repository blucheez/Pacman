//Abdalla Osman     7/30/15    
public class PolkadotCollision
{
         
   public static boolean collide(Pacman pacman, Polkadot pd)
   {
      
      if (pacman.getX()  >= pd.getX()-10 && pacman.getX() <= pd.getX()+10 && pacman.getY() >= pd.getY() - 10 && pacman.getY() <= pd.getY() + 10)               
                    
         return true;
      
      else
         return false;
      
   }
      
}
