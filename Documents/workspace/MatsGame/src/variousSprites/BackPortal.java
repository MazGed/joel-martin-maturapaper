package variousSprites;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class BackPortal extends Portal{
	//When the hero enters this portal he gets back to the previous board

	public BackPortal(int x, int y, Board parent) {
		super(x, y, parent);
	}
	
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player" ){
			if (parent.p.down)
				parent.gp.changeBoard(-1);
			
		}
	}

}
