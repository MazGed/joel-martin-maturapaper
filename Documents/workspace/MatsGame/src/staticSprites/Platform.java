package staticSprites;

import java.awt.Image;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;


public class Platform extends Block{
	/*Behaves exactly like a block but only blocks sprite coming from above.
	 *Note that platforms have a similar InitImage function as the Block.
	 *It also creates the illusion of adjacent platforms being just one "thing".
	 *
	 */
	boolean left=false, right=false;
	public Platform(int x, int y, Board parent){
		
		super(x,y,parent);
		spriteString = "Platform";
		image = new Image[1];
		
	}
	
	public void InitImage(){
		for (int i=0; i<parent.staticSprites.size(); i++){
			Sprite s = (Sprite)parent.staticSprites.get(i);
			if(s.spriteString == "Platform" && s.x == x-width && s.y == y){
				left = true;
			}
			if(s.spriteString == "Platform" && s.x == x+width && s.y == y){
				right = true;
			}
			
		}
		if (left == false && right == false){
			image[0] = parent.skin.PlatformSkin[0];
		}
		if (left == true && right == false){
			image[0] = parent.skin.PlatformSkin[3];
		}
		if (left == false && right == true){
			image[0] = parent.skin.PlatformSkin[2];
		}
		if (left == true && right == true){
			image[0] = parent.skin.PlatformSkin[1];
		}
		
	}
	
	public void Collision(String s1, Sprite s){
		this.s = s;
			
			if (s.yCollided == false){
				if(y -s.height+2 > s.y){
					s.dy=y-s.height-s.y;
					yBlockBehaviour();
					s.friction = friction;
					s.FeetsOnTheGround=true; 
					s.yCollided = true;
					
				}
			}
			
	}
	

}
