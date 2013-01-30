package variousSprites;

import java.awt.Image;
import java.util.Random;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;
import Enemies.Enemy;
import Weapons.Weapon;

public class Spike extends Sprite{
	
	//causes heavy damage to the player when he touches it.
	
	public int d;
	
	public Spike(int x, int y, Board parent,int d){
		super(x, y, parent, true);
		image = new Image[1];
		source.add("/Pictures/etc/spike/up.png");
		source.add("/Pictures/etc/spike/down.png");
		source.add("/Pictures/etc/spike/left.png");
		source.add("/Pictures/etc/spike/right.png");
		StringToImage();
		height = 59;
		this.d = d;
		
		GravityAffected = false;

	}
	
	public void Collision(String s1, Sprite s){
		
		if (s1 == "Player"){
			
			int damage = parent.p.maxLife;
			if (damage >= 50){
				damage = 50;
			}
			
			s.damage(damage, false);
			
			if (s.invincible==0)s.invincible = 100;
			
			
		}
		
		if (s1 == "Enemy"){
			s.life = 0;
			Enemy.enemiesKilled -= 1;
			
			
		}
	}
	
	public void findImage(){
		
		image[0]= imageCollection[d];
		
		
	}
	
	


}