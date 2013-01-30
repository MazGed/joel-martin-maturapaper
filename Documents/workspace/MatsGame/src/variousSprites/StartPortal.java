package variousSprites;

import java.lang.reflect.InvocationTargetException;

import level1.Level1;

import Goals.Goal;
import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Level;
import phaseThreeGames.Sprite;

public class StartPortal extends Portal{
	public int level;
	boolean opened = false;
	public Class lvl;
	public StartPortal(int x, int y, Board parent, int level, Class class1){
		//allows the player to enter a new level. When the player hasn't yet reached the
		// given level he won't be able to enter the startPortal.
		super(x,y,parent);
		this.level = level;
		this.lvl = class1;
		if (GamePanel.progress > level - 2)
			opened = true;
	}



	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player" && opened && parent.p.down){
			
			parent.gp.source = lvl;	
			parent.gp.level = level;
			parent.gp.load();
				
			
		}
	}
	
	
	public void findImage(){
		if (opened){
			image[0]= imageCollection[0];
		}else{
			image[0]= imageCollection[1];
		}
		
	}
	

}
