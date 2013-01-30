package variousSprites;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;
import Weapons.Weapon;

public class ManaWell extends Sprite{
	//restores the hero's mana very fast as long as he touches the well.
	
	public ManaWell(int x, int y, Board parent){
		super(x, y, parent, true);
		width = height = 100;
		image = new Image[1];
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/etc/manawell.png"));
		image[0]=ii.getImage();
		this.y -= 40;
	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player"){
			
			if (parent.p.mana < parent.p.maxMana){
				parent.p.mana += 7;
			}
			
		}
	}
	
	


}