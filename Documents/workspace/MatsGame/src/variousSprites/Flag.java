package variousSprites;

import java.awt.Image;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class Flag extends Sprite{
	//when the player touches this flag during a reach Flag level he wins the level.
	public static boolean FlagReached;
	public Flag(int x, int y, Board parent){
		super(x,y,parent, true);
		spriteString = "Flag";
		image = new Image[1];
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/etc/Flagblue.png"));
		image[0]=ii.getImage();
		width = height = 100;
		this.y +=40;
	}
	
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player"){
				FlagReached = true;
		}
	}

}
