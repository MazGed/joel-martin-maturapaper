package variousSprites;

import java.awt.Image;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class CollectibleFlag extends Sprite{
	//When the player walks over this sprite he collects one flag.
	//(needed to succeed in a mission with a collect flags goal)
	public static int flagsCollected;
	public CollectibleFlag(int x, int y, Board parent){
		super(x,y,parent, true);
		spriteString = "Flag";
		image = new Image[1];
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/etc/Flagred.png"));
		image[0]=ii.getImage();
		width = height = 80;
	}
	

	
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player"){
				
				life = 0;
				flagsCollected += 1;
			
		}
	}

}
