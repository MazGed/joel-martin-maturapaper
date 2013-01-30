package variousSprites;

import java.awt.Image;
import java.util.Random;

import Weapons.Weapon;
import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;

public class WeaponSpawner extends Sprite{
	/*When the hero walks over this sprite it disappears but adds the contained weapon
	 *to his inventory. To create scarce items the WeaponSpawner only has a certain 
	 *probability to actually spawn.
	 * 
	 */
	public Weapon w;
	public WeaponSpawner(int x, int y, Board parent, Weapon w, int prob){
		super(x, y, parent, true);
		this.w = w;
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
				GamePanel.wInventory.add(w);
			}
			if (GamePanel.carriedWeapons[0].getClass() != w.getClass() 
					&& GamePanel.carriedWeapons[1].getClass() != w.getClass() 
					&& GamePanel.carriedWeapons[2].getClass() != w.getClass()){
				
				if (GamePanel.carriedWeapons[0].getClass()==GamePanel.carriedWeapons[1].getClass() 
						&& GamePanel.carriedWeapons[0].getClass()==GamePanel.carriedWeapons[1].getClass()){
					GamePanel.carriedWeapons[0]=w;
				}
				if (GamePanel.carriedWeapons[1].getClass()==GamePanel.carriedWeapons[2].getClass()){
					GamePanel.carriedWeapons[1]=w;
				}
				
			}
			
			
		}
	}
	
	public boolean collected(){
		boolean collected = false;
		for (int i= 0; i<GamePanel.wInventory.size(); i++){
			if (w.getClass() == GamePanel.wInventory.get(i).getClass()){
				collected = true;
				
			}
		}

		return collected;
		
	}
	
	public void findImage(){
		image[0] = w.imageCollection[12];
		
	}

}
