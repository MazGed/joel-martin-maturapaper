package variousSprites;

import java.awt.Image;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.Level;
import phaseThreeGames.Sprite;

public class SpawnPortal extends Sprite{
	int counter, spawnTime, direction;
	Class c;
	public SpawnPortal(int x, int y, Board parent, boolean enemy, boolean synchronised, int spawnTime, Class c, int direction){
		/*This Sprite spawns any other sprites (Class c). It spawns a sprite every every spawnTime milliseconds.
		 *When the boolean enemy is true the Portal gets an image and can be destroyed by the Player.
		 *If not the Portal is invisible and undestructible. If the Portals are synchronized, which means
		 *that all the Portal with the same spawnTime will spawn sprites at the same time.
		 * 
		 */
		super(x,y,parent, true);
		life = 100;
		height = width = 100;
		this.spawnTime = spawnTime;
		this.direction = direction;
		this.c = c;
		GravityAffected = false;
		image = new Image[1];
		if (enemy){
			ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/portal/open.png"));
			image[0]=ii.getImage();
			spriteString = "Enemy";
		}else{
			spriteString = "Portal";
		}
		
		if (!synchronised){
			Random rand = new Random();
			counter = rand.nextInt(spawnTime);
		}
		
	}
	
	public void Init(){
		super.Init();
		counter++;
		if (counter == spawnTime){
			try {
				c.getConstructors()[0].newInstance(x,y,parent, direction);
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| SecurityException e) {
				try {
					c.getConstructors()[0].newInstance(x,y,parent);
				} catch (InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException
						| SecurityException e1) {
					try {
						c.getConstructors()[0].newInstance(x,y,parent,direction,direction);
					} catch (InstantiationException | IllegalAccessException
							| IllegalArgumentException
							| InvocationTargetException | SecurityException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
			counter = 0;
		}
		
	}

}
