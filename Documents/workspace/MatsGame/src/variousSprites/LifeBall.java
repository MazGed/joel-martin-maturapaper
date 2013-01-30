package variousSprites;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;
import Weapons.Weapon;

public class LifeBall extends Sprite{
	//when the hero walks over this sprite it disappears but heals 25 healthpoints
	
	public LifeBall(int x, int y, Board parent){
		super(x, y, parent, true);
		width = height = 40;
		image = new Image[1];
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/etc/healthball.png"));
		image[0]=ii.getImage();
		spriteString = "Ball";

	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player"){
			life = 0;
			parent.p.life += 25;
			
			
		}
		
		if (s1 == "Ball"){
			if (life == 1){
				life +=1;
			}
			
			s.life -= 1;
		}
	}
	
	


}

	


