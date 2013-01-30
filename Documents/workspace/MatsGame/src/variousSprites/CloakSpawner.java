package variousSprites;

import java.awt.Image;
import java.util.Random;

import Cloaks.Cloak;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;


public class CloakSpawner extends Sprite{
	/*When the hero walks over this sprite it disappears but adds the contained cloak
	 *to his inventory. To create scarce items the CloakSpawner only has a certain 
	 *probality to actually spawn.
	 * 
	 */
	public Cloak c;
	public CloakSpawner(int x, int y, Board parent, Cloak c, int prob){
		super(x, y, parent, true);
		this.c = c;
		Random rand = new Random();
		image = new Image[1];
		width = height = 40;
		int diceroll = rand.nextInt(101);
		if (prob < diceroll)
			life = 0;
	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player"){
			life = 0;
			if (collected() == false){
				GamePanel.cInventory.add(c);
			}
			
			if (GamePanel.carriedCloaks[0].getClass() != c.getClass() 
					&& GamePanel.carriedCloaks[1].getClass() != c.getClass() 
					&& GamePanel.carriedCloaks[2].getClass() != c.getClass()){
				
				if (GamePanel.carriedCloaks[0].getClass()==GamePanel.carriedCloaks[1].getClass() 
						){
					GamePanel.carriedCloaks[1]=c;
				}else if (GamePanel.carriedCloaks[1].getClass()==GamePanel.carriedCloaks[2].getClass()
						&& GamePanel.carriedCloaks[0].getClass()==GamePanel.carriedCloaks[2].getClass()){
					GamePanel.carriedCloaks[2]=c;
				}
				
			}
			
			
		}
	}
	
	public boolean collected(){
		boolean collected = false;
		for (int i= 0; i<GamePanel.cInventory.size(); i++){
			if (c.getClass() == GamePanel.cInventory.get(i).getClass()){
				collected = true;
				
			}
		}

		return collected;
		
	}
	
	public void findImage(){
		image[0] = c.imageCollection[12];
		
	}

}
