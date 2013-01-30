package Weapons;

import java.awt.Image;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class HookStaffMissile extends Missile{
	
	//The missile launched by the HookStaff

	public HookStaffMissile(int x, int y, Board parent) {
		super(x, y, parent);
		damage = 25;
		width = 40;
		height = 20;
		this.y -= 5;
		speed = 30;
		ycorrect = 20;
		
		
		source.add("/Pictures/Hero/hook/missile.png");
		source.add("/Pictures/Hero/hook/missileL.png");
		StringToImage();
	}
	
	public void Collision(String s1, Sprite s){
		super.Collision(s1, s);
		if (s1 == "Enemy" && life > 0){
			if (parent.p.x < s.x){
				s.xImp(-10,1);
			}else{
				s.xImp(10,1);
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