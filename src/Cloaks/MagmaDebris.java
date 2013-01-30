package Cloaks;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;
import Weapons.ExplosionDebris;

public class MagmaDebris extends ExplosionDebris{
	//Class for the debris casted by the MagmaCloak
	//very similar to the ExplosionDebris (package Weapons)

	public MagmaDebris(int x, int y, Board parent) {
		super(x, y, parent);
		
	}
	
	public void Collision(String s1, Sprite s){

		if (s1 == "Block" ){
			life = 0;
		}
		if (s1 == "Enemy"){
			if (alreadyHit(s) == false){
				s.damage(10, true);
				enemiesHit.add(s);
			}
			
		}
		
	}
	

}
