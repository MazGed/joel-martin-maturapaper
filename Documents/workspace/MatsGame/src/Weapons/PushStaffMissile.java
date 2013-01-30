package Weapons;

import java.awt.Image;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class PushStaffMissile extends Missile{

	public PushStaffMissile(int x, int y, Board parent) {
		//Missile launched by PushStaff
		
		super(x, y, parent);
		
		
		damage = 15;
		width = 20;
		height = 20;
		speed = 30;
		this.y -= 10;
		
		
		source.add("/Pictures/Hero/push/missile.png");
		source.add("/Pictures/Hero/push/missileL.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		super.Collision(s1, s);
		if (s1 == "Enemy" && life > 0){
			if (parent.p.x < s.x){
				s.xImp(15,1);
				s.yImp(-5, 1);
			}else{
				s.xImp(-15,1);
				s.yImp(-5, 1);
			}
			s.damage(damage,false);
			life = 0;
		}
	}
	
	public void findImage(){
		if (left){
			image[0]= imageCollection[1];
		}else{
			image[0]= imageCollection[0];
		}
	}

}