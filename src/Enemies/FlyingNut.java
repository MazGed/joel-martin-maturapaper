package Enemies;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class FlyingNut extends Enemy{
	int xColl, yColl;
	int horizontalDirection;
	/*This enemy behaves just like every other enemy except that he is flying.
	 *This means that all the vertical moving processes written down in the enemy class
	 *had to be rewritten for the horizontal movement.
	 *Collision method was completely rewritten to fix a lag which caused the
	 *Flying ball to stick on walls when he collided with too many blocks.
	 */
	public FlyingNut(int x, int y, Board parent, int direction, int horizontalDirection) {
		super(x, y, parent);
		this.direction = direction;
		this.horizontalDirection = horizontalDirection;
		maxSpeed = 2;
		maxLife = 40;
		life = maxLife;
		damage = 25;
		width = 60;
		xPcorrect = xNcorrect = 15;
		height = 90;
		elasticity = 1;
		GravityAffected = false;
		
		source.add("/Pictures/flyingball/1.png");
		source.add("/Pictures/flyingball/2.png");
		source.add("/Pictures/flyingball/3.png");
		source.add("/Pictures/flyingball/2.png");

		StringToImage();
		
		
	}
	
	public void Init(){
		xColl = yColl = 0;
		yImp(acc*horizontalDirection,horizontalDirection*maxSpeed,friction);
		super.Init();
	}
	
	public void findImage(){
		
		image[0] = imageCollection[counter/15%4];
		FreezedSlowedImage();
		
		
	}
	
	public void Collision(String s1, Sprite s){
		
		
		
			if (s1 == "Block"){
				if (OnTheWall){
				xColl += 1;
					if (s.y < y+height-1 && xColl == 1){
						direction = -direction;
					}
				}
				if (FeetsOnTheGround || OnTheCeiling){
					yColl += 1;
					if (yColl == 1){
						horizontalDirection = -horizontalDirection;
					}
						
						
				}

			}
			
			if (s1 == "Platform"){

				if (OnTheCeiling){
					yColl += 1;
					if (yColl == 1){
						horizontalDirection = -horizontalDirection;
					}
						
						
				}

			}
			
			if (s1 == "Player"){
				if (s.invincible == 0){
					s.damage(damage, false);
					s.invincible = 50;
					
				}
			}
		}
	}

