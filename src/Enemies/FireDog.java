package Enemies;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;


public class FireDog extends Enemy{
	/*Relatively complicated enemy. It charges towards the hero whenever he gets into critical range.
	 *When he hits a block during his charge he will be stunned for a moment.
	 *Apart from that he behaves normally and turn at edges of platforms when he isn't charging.
	 */
	Random rand = new Random();
	int stunned;
	int charging;
	public FireDog(int x, int y, Board parent, int direction) {
		
		super(x, y, parent);
		maxSpeed = 0;
		maxLife = 80;
		life = maxLife;
		damage = 40;
		width = 90;
		height = 60;
		Unstoppable = true;
		this.direction = direction;
		
		
		source.add("/Pictures/FireDog/R1.png");
		source.add("/Pictures/FireDog/R2.png");
		source.add("/Pictures/FireDog/R3.png");
		source.add("/Pictures/FireDog/R4.png");
		source.add("/Pictures/FireDog/L1.png");
		source.add("/Pictures/FireDog/L2.png");
		source.add("/Pictures/FireDog/L3.png");
		source.add("/Pictures/FireDog/L4.png");
		source.add("/Pictures/FireDog/StR.png");
		source.add("/Pictures/FireDog/StL.png");

		StringToImage();
		
		
	}
	
	public void Init(){
		
		if (charging > 0 || stunned > 0){
			maxSpeed = 0;
		}else{
			maxSpeed = 2;
		}
		if (stunned > 0)
			stunned --;
		
		if (charging == 0){
			turnIfOnEdge();
		}
		
		if (charging > 0 && FeetsOnTheGround){
			xImp (direction*5, direction*20 , 1);
			charging--;
			
		}
		
		if (parent.p.x > x  && parent.p.x < x +300 && charging == 0 && stunned == 0){
			if (parent.p.y < y +60 && parent.p.y > y -60 ){
				yImp(-5,1);
				direction = 1;
				charging = 50;
			}
			
		}
		
		if (parent.p.x < x && parent.p.x > x-300 && charging == 0 && stunned == 0){
			if (parent.p.y < y +60 && parent.p.y > y -60 ){
				yImp(-5,1);
				direction = -1;
				charging = 50;
			}
			
		}
		
		
		
		
		super.Init();
		
		
	}
	
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Block"){
			if (OnTheWall){
				
				
				if (charging > 0){
					direction = -direction;
					charging = 0;
					xImp = direction*10;
					stunned = 50;
				}
				
				
				
				
				
			}
		}
		
		super.Collision(s1,s);

		
		
	}
	
	public void findImage(){
		if (direction>0){
			if (counter < 20 )
				image[0] = imageCollection[0];
			if (counter > 20 && counter < 40)
				image[0] = imageCollection[1];
			if (counter > 40)
				image[0] = imageCollection[2];
			if (dy != 0)
				image[0] = imageCollection[3];
			if (stunned > 0)
				image[0]= imageCollection[8];
		}
		else{
			if (counter < 20 )
				image[0] = imageCollection[4];
			if (counter > 20 && counter < 40)
				image[0] = imageCollection[5];
			if (counter > 40)
				image[0] = imageCollection[6];
			if (dy != 0)
				image[0] = imageCollection[7];
			if (stunned > 0)
				image[0]= imageCollection[9];
		}
		FreezedSlowedImage();
		
		
	}
	


}
