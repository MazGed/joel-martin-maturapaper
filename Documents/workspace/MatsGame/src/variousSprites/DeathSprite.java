package variousSprites;

import java.awt.Image;
import java.util.Random;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class DeathSprite extends Sprite{
	
	//class for the little sprites created whenever an enemy or the Player dies
	//Blood and gore

	
	public DeathSprite(int x, int y, Board parent){
		super(x, y, parent, true);
		height = width = 10;
		life = maxLife =  60;
		
		
		Random rand = new Random();
		xImp(rand.nextInt(20)-10, 1);
		yImp(-rand.nextInt(15)+5, 1);
		
		source.add("/Pictures/etc/deathanimation.png");
		StringToImage();
		image = new Image[1];
		image[0]= imageCollection[0];
	}
	
	public void Init(){
		super.Init();
		life -= 1;

	}
	
	public void death(){
		
	}
	
public void Collision(String s1, Sprite s){
		
		if (s1 == "Block"){
			xNullify();
		}
	}

}
