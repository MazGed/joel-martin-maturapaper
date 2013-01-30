package Enemies;

import java.util.Random;

import phaseThreeGames.Board;

public class ShamanMignon extends EdgeWalkerMignon{
		int reloading;
		int shooting;
		int icounter;
		Random rand;
		public ShamanMignon(int x, int y, Board parent, int direction) {
			//Behaves exactly like a mignon but launches a missile in direction of the hero
			//whenever he gets into critical range.
			//Not that the shaman doesn't aim at the player(except that he shoots in the right direction)
			//and that his missiles are elastic and affected by gravity.
			//The shaman has another skin than normal mignons.
			super(x, y, parent, direction);
			
			maxLife = 50;
			life = maxLife;
			
			source.clear();
			
			source.add("/Pictures/midgetmage/1R.png");
			source.add("/Pictures/midgetmage/2R.png");
			source.add("/Pictures/midgetmage/3R.png");
			source.add("/Pictures/midgetmage/4R.png");
			source.add("/Pictures/midgetmage/FR.png");
			source.add("/Pictures/midgetmage/ShR.png");
			source.add("/Pictures/midgetmage/1L.png");
			source.add("/Pictures/midgetmage/2L.png");
			source.add("/Pictures/midgetmage/3L.png");
			source.add("/Pictures/midgetmage/4L.png");
			source.add("/Pictures/midgetmage/FL.png");
			source.add("/Pictures/midgetmage/ShL.png");

			StringToImage();
			
			
		}
		
		public void Init(){
			super.Init();
			
			if (reloading > 0){
				reloading--;
			}
			if (shooting > 0){
				shooting--;
			}
			
			if (parent.p.x > x){
				
				if (parent.p.x < x +480 && reloading == 0 && direction == 1){
					
					if (parent.p.y < y +60 && parent.p.y > y -60 ){
						reloading = 30;
						shooting = 15;
						new ShamanMissile(x+width/2, y+30, parent);
					}
					
				}
			}else{
				
				if (parent.p.x > x -480 && reloading == 0 && direction == -1){
					if (parent.p.y < y +60 && parent.p.y > y -60 ){
						reloading = 30;
						shooting = 15;
						new ShamanMissile(x+width/2, y+30, parent);
					}
					
				}
			}
			
		}
		
		public void findImage(){
			icounter ++;
			int a = 12;
			icounter = icounter%(6*a+1);
			
			
			
			if (direction>0){
				switch((icounter/a%6))
	            {
	               case 0:
	            	   image[0] = imageCollection[0];break;
	               case 1:case 5:
	            	   image[0] = imageCollection[1]; break;
	               case 2:case 4:
	            	   image[0] = imageCollection[2];break;
	               case 3:
	            	   image[0] = imageCollection[3];break;
	            }
				if (dy != 0){
					image[0] = imageCollection[4];
				}
				if (shooting != 0){
					image[0] = imageCollection[5];
				}
			}
			else{
				switch((icounter/a%6))
	            {
	               case 0:
	            	   image[0] = imageCollection[6];break;
	               case 1:case 5:
	            	   image[0] = imageCollection[7]; break;
	               case 2:case 4:
	            	   image[0] = imageCollection[8];break;
	               case 3:
	            	   image[0] = imageCollection[9];break;
	            }
				if (dy != 0){
					image[0] = imageCollection[10];
				}
				if (shooting != 0){
					image[0] = imageCollection[11];
				}
			}
			FreezedSlowedImage();
			
			
		}
}
