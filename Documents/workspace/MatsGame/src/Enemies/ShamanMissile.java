package Enemies;

import Weapons.Missile;
import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class ShamanMissile extends Missile{
	
	public ShamanMissile(int x, int y, Board parent) {
		//The missile launched by the ShamanMignon.
		//A basic elastic missile.
		super(x, y, parent);
		speed = 10;
		elasticity = 1;
		width = 15;
		height =15;
		damage = 25;
		GravityAffected = true;
		if (parent.p.x > x){
			left = false;
		}else{
			left = true;
		}
		
		source.add("/Pictures/Hero/scatter/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		if (s1 == "Block" && xCollided){
			life = 0;
		}
		if (s1 == "Player" && life > 0){
			s.damage(damage,false);
			s.invincible = 100;
			life = 0;
		}
	}
		

}
