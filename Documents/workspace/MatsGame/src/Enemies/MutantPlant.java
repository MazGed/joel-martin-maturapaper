package Enemies;

import phaseThreeGames.Board;
import phaseThreeGames.Sprite;

public class MutantPlant extends Enemy{
	int reloading;
	int shooting;
	public MutantPlant(int x, int y, Board parent) {
		/*Immobile enemy which shoots missiles.
		 *Shoots missiles in a straight line and aims at the player.
		 *Note that the aiming doesn't happen inside the MutantPlant class
		 *but in the constructor of the SeedMissile class
		 */
		
		super(x, y, parent);
		maxSpeed = 0;
		maxLife = 60;
		life = maxLife;
		damage = 20;
		width = 60;
		height = 90;
		xPcorrect = xNcorrect = 20;
		
		
		source.add("/Pictures/DemonPlant/ShR.png");
		source.add("/Pictures/DemonPlant/ShL.png");
		source.add("/Pictures/DemonPlant/StR1.png");
		source.add("/Pictures/DemonPlant/StR2.png");
		source.add("/Pictures/DemonPlant/StR3.png");
		source.add("/Pictures/DemonPlant/StL1.png");
		source.add("/Pictures/DemonPlant/StL2.png");
		source.add("/Pictures/DemonPlant/StL3.png");

		StringToImage();
		
		
	}
	
	public void Init(){
		
		if (reloading > 0 && Freezed == 0){
			reloading--;
		}
		if (shooting > 0){
			shooting--;
		}
		
		if (parent.p.x > x){
			direction = 1;
			if (parent.p.x < x +500 && reloading == 0){
				reloading = 100;
				shooting = 15;
				SeedMissile s = new SeedMissile(x+width/2, y+30, parent);
				if (Slowed > 0){
					s.xImp/=2;
					s.yImp/=2;
					
				}
				
			}
		}else{
			direction = -1;
			if (parent.p.x > x -500 && reloading == 0){
				reloading = 100;
				shooting = 15;
				SeedMissile s = new SeedMissile(x+width/2, y+30, parent);
				if (Slowed > 0){
					s.xImp/=2;
					s.yImp/=2;
					
				}
				
			}
		}
	
		
		
		
		
		super.Init();
		
		
	}
	
	
	public void Collision(String s1, Sprite s){
		
		
		super.Collision(s1,s);

		
		
	}
	
	public void findImage(){
		if (direction>0){
			switch((counter/15%4))
            {
               case 0: case 2:
            	   image[0] = imageCollection[2];break;
               case 1:
            	   image[0] = imageCollection[3]; break;
               case 3:
            	   image[0] = imageCollection[4];break;
            }
			if (shooting > 0){
				image[0] = imageCollection[0];
			}
		}
		else{
			switch(counter/15%4)
            {
               case 0: case 2:
            	   image[0] = imageCollection[5]; break;
               case 1:
            	   image[0] = imageCollection[6]; break;
               case 3:
            	   image[0] = imageCollection[7];break;
            }
			if (shooting > 0){
				image[0] = imageCollection[1];
			}
		}
		FreezedSlowedImage();
		
		
	}

}
