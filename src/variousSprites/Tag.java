package variousSprites;

import java.awt.Image;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class Tag extends Sprite{
	
	//A shield displaying any String. Helpful for a tutorial level or to display the level's name next to a startPortal.
	
	
	public String s;
	public Tag(int x, int y,String s,Board parent) {
		super(x, y, parent, false);
		spriteString = "tag";
		this.s = s;
		width = 200;
		height = 125;
		this.y -= 25;
		image = new Image[1];
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/etc/sign.png"));
		image[0]=ii.getImage();
	}
	
	

}
