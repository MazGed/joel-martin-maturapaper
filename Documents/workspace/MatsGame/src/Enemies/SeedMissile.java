package Enemies;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;
import Weapons.Missile;

public class SeedMissile extends Missile{
	int horizontalD, vertikalD;
	public SeedMissile(int x, int y, Board parent) {
		//Class of the Missile shot by the MutantPlant
		super(x, y, parent);
		damage = 20;
		width = 15;
		height =15;
		
		/*Aiming process: Checks whether the player is above or under the launched Missile.
		 *Then it checks whether the player is left or right.
		 *The the program calculates the ratio between the dy between the missile and the player and the dx.
		 *
		 */
		
		if (parent.p.x > x){
			vertikalD = 1;
		}else{
			vertikalD = -1;
		}
		
		if (parent.p.y > y){
			horizontalD = 1;
		}else{
			horizontalD = -1;
		}
		
		if (parent.p.x == x){
			yImp(horizontalD*10,1);
		}else if (parent.p.y == y){
			xImp(vertikalD*10,1);
		}else{
			double xy = (double)Math.abs(parent.p.x - x)/Math.abs(parent.p.y - y);
			double yx = (double)Math.abs(parent.p.y - y)/Math.abs(parent.p.x - x);
			if (yx>xy){
				int a = (int) yx;
				switch (a){
					case 1:
						xImp(vertikalD*5,1);
						yImp(horizontalD*5,1);
						break;
					case 2:case 3:
						xImp(vertikalD*3,1);
						yImp(horizontalD*7,1);
						break;
					case 4: case 5: case 6:
						xImp(vertikalD*2,1);
						yImp(horizontalD*8,1);
						break;
					case 7: case 8: case 9:
						xImp(vertikalD*1,1);
						yImp(horizontalD*9,1);
						break;
					default:
						yImp(horizontalD*10,1);
				}
			}else{
				int a = (int) xy;
				switch (a){
					case 1:
						xImp(vertikalD*5,1);
						yImp(horizontalD*5,1);
						break;
					case 2:case 3:
						xImp(vertikalD*7,1);
						yImp(horizontalD*3,1);
						break;
					case 4: case 5: case 6:
						xImp(vertikalD*8,1);
						yImp(horizontalD*2,1);
						break;
					case 7: case 8: case 9:
						xImp(vertikalD*9,1);
						yImp(horizontalD*1,1);
						break;
					default:
						xImp(vertikalD*10,1);
				}
				
			}
		}
		
		
		
		
		
		source.add("/Pictures/Hero/WoodenStaff/missile.png");
		StringToImage();
		image[0]= imageCollection[0];
	}
	
	public void Collision(String s1, Sprite s){
		super.Collision(s1, s);
		if (s1 == "Player" && life > 0){
			s.damage(damage,false);
			s.invincible = 50;
			life = 0;
		}
	}
	

}
