package Weapons;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;
import variousSprites.DeathSprite;

public class GrenadeStaffMissile extends Missile{
	//The Grenade launched by the GrenadeStaff
	
	int counter = 15;
	int debrisCount = 25;
	Random rand = new Random();
	public GrenadeStaffMissile(int x, int y, Board parent) {
		super(x, y, parent);
		damage = 1;
		width = 20;
		height = 20;
		life = maxLife = 50;
		this.y -= 5;
		speed = 10;
		elasticity = 1;
		GravityAffected = true;
		
		
		source.add("/Pictures/Hero/grenade/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Block" && xCollided){
			speed *= -1;
		}
		
		if (s1 == "Enemy" && life > 0){
			life =0;
		}
	}
	
	public void death(){
		explode();
	}
	
	public void Init(){
		super.Init();
		life -= 1;
		
			
		
	}
	
	
	public void explode(){
		//creates all the ExplosionDebris
			for (int i = 0; i<debrisCount ; i++){
				new ExplosionDebris(x+width/2, y-height*2, parent);
			}
	}

	

	
}
