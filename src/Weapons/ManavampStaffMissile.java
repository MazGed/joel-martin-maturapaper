package Weapons;

import java.awt.Image;
import java.util.ArrayList;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class ManavampStaffMissile extends Missile{
	private ArrayList<Sprite> enemiesHit;
	public int counter = 25;
	public ManavampStaffMissile(int x, int y, Board parent) {
		//The missile launched by the ManavampStaff
		//Note that the missile resets his enemiesHit arrayList when he turns around.
		super(x, y, parent);
		damage = 15;
		width = 25;
		height = 25;
		this.y -= 10;
		speed = 20;
		life = maxLife = 2;
		
		enemiesHit = new ArrayList<Sprite>();
		
		source.add("/Pictures/Hero/manavamp/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		if (s1 == "Enemy" && life > 0){
			if (alreadyHit(s) == false){
				s.damage(damage,false);
				enemiesHit.add(s);
				if (parent.p.mana < parent.p.maxMana){
					parent.p.mana +=25;
				}else{
					parent.p.mana = parent.p.maxMana;
				}
			}
			
		}
		if (s1 == "Player" && life < 2){
			life = 0;
		}
	}
	
	public boolean alreadyHit(Sprite s){
		//checks whether the concerned sprite was already hit by the missile
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

}