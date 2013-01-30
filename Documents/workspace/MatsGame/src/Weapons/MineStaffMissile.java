package Weapons;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;
import variousSprites.DeathSprite;

public class MineStaffMissile extends Missile{
	int counter = 20;
	int debrisCount = 20;
	public MineStaffMissile(int x, int y, Board parent) {
		//The mine launched by the MineStaff.
		//note that it has a small period before it is armed
		//so that it doesn't explode in the hero's face
		super(x, y, parent);
		damage = 1;
		width = 30;
		height = 15;
		life = 50;
		speed = 0;
		elasticity = 0;
		dcounter = 500;
		GravityAffected = true;
		AirAffected = true;
		if (parent.p.lookingLeft){
			xImp(-10,1);
			this.x -= 10;

		}else{
			xImp(10,1);
		}
		yImp(-5,1);
		
		source.add("/Pictures/Hero/mine/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
		
	}
	
	public void Collision(String s1, Sprite s){
		
		
		if (s1 == "Enemy" || s1 == "Player"){
			if (counter == 0){
				life =0;
			}
			
		}
	}
	
	public void death(){
		explode();
	}
	
	public void Init(){
		super.Init();
		if (counter > 0){
			counter--;
		}

	}
	
	
	public void explode(){
			for (int i = 0; i<debrisCount ; i++){
				new ExplosionDebris(x+width/2, y-height*2, parent);
			}
	}

	

	
}