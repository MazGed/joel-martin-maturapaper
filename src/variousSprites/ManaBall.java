package variousSprites;

import java.awt.Image;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;
import Weapons.Weapon;

public class ManaBall extends Sprite{
	//when the hero walks over this sprite it disappears but heals 100 manapoints
	
	public ManaBall(int x, int y, Board parent){
		super(x, y, parent, true);
		width = height = 40;
		image = new Image[1];
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/etc/manaball.png"));
		image[0]=ii.getImage();
		spriteString = "Ball";

	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player"){
			life = 0;
			parent.p.mana += 100;
			
			
		}
		
		if (s1 == "Ball"){
			if (life == 1){
				life +=1;
			}
			
			s.life -= 1;
		}
	}
	
	


}
