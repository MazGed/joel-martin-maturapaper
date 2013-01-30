package Weapons;

import java.awt.Image;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class IceStaffMissile extends Missile{
	
	//The missile launched by the IceStaff

	public IceStaffMissile(int x, int y, Board parent) {
		super(x, y, parent);
		damage = 30;
		width = 20;
		height = 20;
		speed = 20;
		this.y -= 10;
		
		
		source.add("/Pictures/Hero/ice/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		super.Collision(s1, s);
		if (s1 == "Enemy" && life > 0){
			s.Freezed = 100;
			s.damage(damage,false);
			life = 0;
		}
	}

}