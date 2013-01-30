package Weapons;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class ScatterStaffMissile extends Missile{
	int counter = 20;
	Random rand = new Random();
	private ArrayList<Sprite> enemiesHit;
	public ScatterStaffMissile(int x, int y, Board parent) {
		//The tiny missiles launched by the ScatterStaff. Uses the already hit mechanic.
		super(x, y, parent);
		damage = 3;
		width = 10;
		height = 10;
		speed = 0;
		
		enemiesHit = new ArrayList<Sprite>();
		
		if (parent.p.lookingLeft == false){
			xImp(rand.nextInt(8)+16,1);
			yImp(rand.nextInt(5)-3,1);
		}else{
			xImp(-rand.nextInt(8)-16,1);
			yImp(rand.nextInt(5)-3,1);
		}
		
		source.add("/Pictures/Hero/scatter/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Block"){
			life = 0;
		}
		
		if (s1 == "Enemy" && life > 0){
			if (alreadyHit(s) == false){
				s.damage(damage, false);
				enemiesHit.add(s);
				
			}
				
			
			

		
				
		}
	}
	public void Init(){
		super.Init();
		counter -= 1;
		xImp(rand.nextInt(3)-1, 6);
		yImp(rand.nextInt(3)-1, 6);
		if (counter == 0)
			life = 0;
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
	
}