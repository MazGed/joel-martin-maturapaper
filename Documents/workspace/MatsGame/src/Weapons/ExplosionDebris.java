package Weapons;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class ExplosionDebris extends Sprite{
	
	/*Explosion debris are the small sprites that are created
	 *whenever a mine or a bomb explodes.
	 *Note the mechanic with the enemiesHit ArrayList:
	 *When a enemy is hit it gets added to that list. Enemies inside
	 *the list are prevented from getting damaged by the missile.
	 *This means that every enemy can only be hit by the same debris once.
	 *A lot of missiles use the same mechanic.
	 *Debris can damage enemies and the player.
	 *
	 */

	public ArrayList<Sprite> enemiesHit;
	public ExplosionDebris(int x, int y, Board parent){
		super(x, y, parent, true);
		height = width = 10;
		life = maxLife = 25;
		
		
		Random rand = new Random();
		xImp(rand.nextInt(20)-10, 1);	
		yImp(-rand.nextInt(15), 1);
		
		enemiesHit = new ArrayList<Sprite>();
		
		source.add("/Pictures/etc/explosionDebris.png");
		StringToImage();
		image = new Image[1];
		image[0]= imageCollection[0];
	}
	
	public void Init(){
		super.Init();
		life -= 1;

	}
	
	
	public void Collision(String s1, Sprite s){

		if (s1 == "Block" ){
			life = 0;
		}
		if (s1 == "Enemy"){
			if (alreadyHit(s) == false){
				s.damage(5, true);
				enemiesHit.add(s);
			}
			
		}
		if (s1 == "Player"){
			if (alreadyHit(s) == false){
				s.damage(5, true);
				enemiesHit.add(s);
			}
		}
	}
	
	public boolean alreadyHit(Sprite s){
		//Checks whether the debris has already hit the concerned sprite.
		boolean hit = false;
		for (int i = 0; i<enemiesHit.size(); i++){
			if (s == enemiesHit.get(i)){
				hit = true;
			}
		}
		return hit;
	}

}