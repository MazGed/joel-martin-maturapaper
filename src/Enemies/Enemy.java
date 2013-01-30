package Enemies;

import java.awt.Image;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class Enemy extends Sprite{
	//the abstract class for all the enemy classes. Features some basic behavior which are usable for all the enemies
	int direction=1;
	public String[] SlowFreezSource = {"/Pictures/etc/frozenslowed.png", "/Pictures/etc/frozenstunned.png"};
	public Image[] SlowFreezImg =new Image[SlowFreezSource.length];
	int xColl;
	public static int enemiesKilled;//used for the kill enemies goal
	public Enemy(int x, int y, Board parent){
		super(x,y,parent, true);
		deathAnim = true;
		spriteString = "Enemy";
		maxSpeed = 1;
		acc =1;
		image = new Image[2];
		
		
		
		
		try{
			for (int i = 0; i < SlowFreezSource.length; i++){
				ImageIcon ii = new ImageIcon(this.getClass().getResource(SlowFreezSource[i]));
				SlowFreezImg[i]=ii.getImage();}
		}catch(NullPointerException e){
			
		}
		

		
	}
	
	public void Init(){
		//Basic enemy behavior : accelerating towards his maximal speed
		
		xColl = 0;
		xImp(acc*direction,direction*maxSpeed,friction);
		super.Init();
		
		
	}
	

	
	public void Collision(String s1, Sprite s){
		
		
		if (s1 == "Block"){
			//Basic enemy behaviors: Changing direction when it collides with wall
			if (OnTheWall){
				xColl += 1;
					if (s.y < y+height-1 && xColl == 1){
						direction = -direction;
					}
				}
		}
		
		if (s1 == "Player"){
			//Basic enemy behaviors: causing damage to player when they touch him
		
			if (s.invincible == 0){
				s.damage(damage, false);
				s.invincible = 25;
				
			}
		}
		

		
		
	}
	public void turnIfOnEdge(){
		/*If this method is incorporated in the init method of an enemy class 
		 *this enemy will change his direction when he gets to the edge of a platform
		 *Ps: check out the first if statement. I'm pretty proud of it.
		 */
		boolean onEdge=false;
		for (int i = 0; i < parent.staticSprites.size(); i++){
			Sprite s1 = parent.staticSprites.get(i);
			if (s1.y == y+height &&
					s1.x + (direction+1)/2*s1.width > x +(-direction+1)/2*width/2  &&
					s1.x + (direction+1)/2*s1.width < x+width/((direction+3)/2)   ){
					onEdge = true;
					for (int j = 0; j < parent.staticSprites.size(); j++){
						Sprite s2 = parent.staticSprites.get(j);
						if (s2.x == s1.x+direction*60 && s2.y == s1.y){
							onEdge =false;
							
						}	
					}	
				
			}
			
		}
		if (dy != 0){
			onEdge = false;
		}
		if (onEdge){
			direction *= -1;
		}
	}
	
	public void findImage(){
		// this function checks in which of the six positions the figure is. 
		if (direction<0){
			if ((counter >30 && counter < 45) || counter <15 )
				image[0] = imageCollection[0];
			if ((counter> 15 && counter < 30) || counter > 45)
				image[0] = imageCollection[4];
			if (dy != 0)
				image[0] = imageCollection[1];
		}
		else{
			if ((counter >30 && counter < 45) || counter <15 )
				image[0] = imageCollection[2];
			if ((counter> 15 && counter < 30) || counter > 45)
				image[0] = imageCollection[5];
			if (dy != 0)
				image[0] = imageCollection[3];
		}
		FreezedSlowedImage();
		
		
	}
	
	public void FreezedSlowedImage(){
		//Enemies can be frozen or slowed by the player. This method checks whether they are and applies the right image.
		if (Unstoppable == false &&(Freezed!=0 || Slowed!=0)){
			
			if (Slowed!=0 ){
				image[1]= SlowFreezImg[0];
			}
			if (Freezed!=0 ){
				image[1]= SlowFreezImg[1];
			}
		}else{
			image[1]= null;
		}
		
		
	}
	
	public void death(){
		super.death();
		enemiesKilled +=1;
	}
	


}
