package staticSprites;

import java.awt.Image;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;


public class Block extends Sprite{
	//The Basic landscape building sprite. This sprite is immobile and blocks all the mobile sprites.
	//When you put a lot of them next to each other a map is created
	boolean left=false, right=false, up=false , down=false;
	public int friction = 1;//The higher the number, the smaller the grip is on the block
	public Sprite s;
	public Block(int x, int y, Board parent){
		
		super(x,y,parent, false);
		spriteString = "Block";
		image = new Image[1];
		
	}
	
	public void InitImage(){
		//Chooses a image regarding if the block touches other blocks
		//That way the illusion is created that all the blocks form a landscape
		for (int i=0; i<parent.staticSprites.size(); i++){
			Sprite s = (Sprite)parent.staticSprites.get(i);
			if(s.getClass() == staticSprites.Block.class && s.x == x-width && s.y == y){
				left = true;
			}
			if(s.getClass() == staticSprites.Block.class && s.x == x+width && s.y == y){
				right = true;
			}
			if(s.getClass() == staticSprites.Block.class && s.x == x && s.y == y+height){
				down = true;
			}
			if(s.getClass() == staticSprites.Block.class && s.x == x && s.y == y-height){
				up = true;
			}
			
		}

		if (left == true && right == true && up == true && down == true){
			image[0] = parent.skin.BlockSkin[0];
		}
		if (left == false && right == true && up == true && down == true){
			image[0] = parent.skin.BlockSkin[1];
		}
		if (left == true && right == true && up == false && down == true){
			image[0] = parent.skin.BlockSkin[2];
		}
		if (left == true && right == false && up == true && down == true){
			image[0] = parent.skin.BlockSkin[3];
		}
		if (left == true && right == true && up == true && down == false){
			image[0] = parent.skin.BlockSkin[4];
		}
		if (left == false && right == true && up == false && down == true){
			image[0] = parent.skin.BlockSkin[5];
		}
		if (left == true && right == false && up == false && down == true){
			image[0] = parent.skin.BlockSkin[6];
		}
		if (left == true && right == false && up == true && down == false){
			image[0] = parent.skin.BlockSkin[7];
		}
		if (left == false && right == true && up == true && down == false){
			image[0] = parent.skin.BlockSkin[8];
		}
		if (left == false && right == true && up == false && down == false){
			image[0] = parent.skin.BlockSkin[9];
		}
		if (left == true && right == false && up == false && down == false){
			image[0] = parent.skin.BlockSkin[10];
		}
		if (left == false && right == false && up == true && down == false){
			image[0] = parent.skin.BlockSkin[11];
		}
		if (left == false && right == false && up == false && down == true){
			image[0] = parent.skin.BlockSkin[12];
		}
		if (left == false && right == false && up == false && down == false){
			image[0] = parent.skin.BlockSkin[13];
		}
		if (left == true && right == true && up == false && down == false){
			image[0] = parent.skin.BlockSkin[14];
		}
		if (left == false && right == false && up == true && down == true){
			image[0] = parent.skin.BlockSkin[15];
		}
	
	}
	
	public void Collision(String s1, Sprite s){
		/*When a sprite touches a block was to enter a block
		 *it's trajectory is corrected so that it will stop at the edge of the block
		 *Note that sprites entering the block diagonally aren't blocked which
		 *leads to a minor glitch.
		 */
				
		this.s = s;
		if(x-s.width+1 < s.x && s.x < x+width){
			if (s.yCollided == false){
				if(y < s.y){
					s.dy=y+height-s.y;
					yBlockBehaviour();
					s.OnTheCeiling = true;
					s.yCollided = true;
				}
				if(y > s.y){
					s.dy=y-s.height-s.y;
					yBlockBehaviour();
					if (!s.featherLight){
						s.friction = friction;
					}
					s.FeetsOnTheGround=true; 
					s.yCollided = true;
					
				}
			}

			
		}
		
		if(y-s.height+1 < s.y && s.y < y+height){
			if (s.xCollided == false){
				if(x < s.x){
					s.dx=x+width-s.x;
					s.OnTheWall = true;
					xBlockBehaviour();
					s.xCollided = true;
					
					
				}
				if(x > s.x){
					s.dx=x-s.width-s.x;
					s.OnTheWall = true;
					xBlockBehaviour();
					s.xCollided = true;
				}
			}
			
		}

	}
	
	public void yBlockBehaviour(){
		//Additional stuff happening when a sprite touches the block horizontally
		//normally it just gets slowed down it is possible to make elastic
		//blocks which give multiply the sprites impulse by -1;
		s.yNullify();
	}
	
	public void xBlockBehaviour(){
		//Additional stuff happening when a sprite touches the block vertically
		//normally it just gets slowed down it is possible to make elastic
		//blocks which give multiply the sprites impulse by -1;
		s.xNullify();
	}

}
