//Abdalla Osman     7/30/15    
public class PolkadotCollision
{
         
   public static boolean collide(Pacman pacman, Polkadot pd)
   {
      
      if (pacman.getX()  >= pd.getX()-3 && pacman.getX() <= pd.getX()+3 && pacman.getY() >= pd.getY() - 3 && pacman.getY() <= pd.getY() + 3)               
                    
         return true;
      
      else
         return false;
      
   }
      
}
