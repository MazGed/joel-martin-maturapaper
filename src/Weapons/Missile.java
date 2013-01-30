package Weapons;

import java.awt.Image;
import java.util.ArrayList;

import Enemies.Enemy;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class Missile extends Sprite{
	public int speed;
	public boolean left;
	public int dcounter=100;
	
	//Abstract class for all the missiles. Not very sophisticated
	//basically a sprite that isn't affected by air or Gravity and that has a fixed speed.
	
	

	public Missile(int x, int y, Board parent) {
		super(x, y, parent, true);
		spriteString = "Missile";
		maxLife = 1;
		life = maxLife;
		image = new Image[1];
		AirAffected = false;
		GravityAffected =false;
		if (parent.p.lookingLeft){
			left = true;
		}else{
			left = false;
		}
	}
	
	public void Init(){
		dcounter--;
		if (dcounter == 0){
			life = 0;
		}
		if(left){
			xImp(-speed, -speed, 1);
		}else{
			xImp(speed, speed, 1);
		}
		super.Init();
	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Block"){
			life = 0;
		}
	}

}
