package Weapons;

import java.awt.Image;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class WoodenStaffMissile extends Missile{

	public WoodenStaffMissile(int x, int y, Board parent) {
		//missile launched by the WoodenStaff.
		
		super(x, y, parent);
		damage = 15;
		width = 15;
		height = 15;
		speed = 20;
		this.y -= 10;
		
		
		source.add("/Pictures/Hero/WoodenStaff/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		super.Collision(s1, s);
		if (s1 == "Enemy" && life > 0){
			s.damage(damage,false);
			life = 0;
		}
	}

}