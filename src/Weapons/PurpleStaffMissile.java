package Weapons;

import java.awt.Image;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class PurpleStaffMissile extends Missile{

	public PurpleStaffMissile(int x, int y, Board parent) {
		
		//The missile launched by the PurpleStaff
		super(x, y, parent);
		damage = 10;
		width = 10;
		height = 10;
		speed = 12;		
		GravityAffected = true;
		elasticity = 1;
		source.add("/Pictures/Hero/PStaff/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Block" && xCollided){
			life = 0;
		}
		
		if (s1 == "Enemy" && life > 0){
			s.Slowed = 150;
			s.damage(damage, false);
			life = 0;
		
				
		}
	}
	
}