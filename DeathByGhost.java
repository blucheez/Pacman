//Abdalla Osman     7/30/15    
public class DeathByGhost
{
         
   public static boolean collide(Pacman pacman, Ghost ghost)
   {
      
      if ((pacman.getX()  >= ghost.getX() && pacman.getX() <= ghost.getX() + 2 * ghost.getSize() + 2 * pacman.getSize()
              || pacman.getX()  <= ghost.getX() && pacman.getX() >= ghost.getX() - 2 * pacman.getSize()) //Pacman to the right or the left, ghost to the le 
              &&
              (pacman.getY() >= ghost.getY() - 5 && pacman.getY() <= ghost.getY() + 5) //Pacman is within the height range
              
              )
         
         return true;
      
      else
         return false;
      
   }
      
}
