package Weapons;

import java.awt.Image;
import java.util.ArrayList;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class VampireStaffMissile extends Missile{
	private ArrayList<Sprite> enemiesHit;
	public int counter = 25;
	public VampireStaffMissile(int x, int y, Board parent) {
		//The bat casted by the VampireStaff. uses the enemiesHit mechanic.
		super(x, y, parent);
		damage = 5;
		width = 40;
		height = 5;
		ycorrect = 40;
		speed = 20;
		life = maxLife = 2;
		
		enemiesHit = new ArrayList<Sprite>();
		
		source.add("/Pictures/Hero/vampire/missile.png");
		source.add("/Pictures/Hero/vampire/missileL.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		if (s1 == "Enemy" && life > 0){
			if (alreadyHit(s) == false){
				s.damage(damage,false);
				enemiesHit.add(s);
				parent.p.heal(2);
			}
			
		}
		if (s1 == "Player" && life < 2){
			life = 0;
		}
	}
	
	public boolean alreadyHit(Sprite s){
		//checks whether the concerned sprite was already hit by the missile.
		boolean hit = false;
		for (int i = 0; i<enemiesHit.size(); i++){
			if (s == enemiesHit.get(i)){
				hit = true;
			}
		}
		return hit;
	}
	
	public void Init(){
		super.Init();
		counter -= 1;
		if (counter == 0){
			speed *= -1;
			life -= 1;
			counter = 25;
			enemiesHit.clear();
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