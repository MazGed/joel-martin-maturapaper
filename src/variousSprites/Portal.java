package variousSprites;

import java.awt.Image;

import phaseThreeGames.Board;
import phaseThreeGames.Level;
import phaseThreeGames.Sprite;

public class Portal extends Sprite{
	//allows the player to access the next board in the level's board array.
	
	public Portal(int x, int y, Board parent){
		super(x,y,parent, true);
		spriteString = "Portal";
		
		image = new Image[1];
		source.add("/Pictures/portal/open.png");
		source.add("/Pictures/portal/closed.png");
		StringToImage();
		height = width = 100;
		this.y -= 40;
		
	}
	
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player" ){
			if (parent.p.down)
				parent.gp.changeBoard(1);
			
		}
	}
	
	public void findImage(){
		image[0]= imageCollection[0];
	}
	

}


