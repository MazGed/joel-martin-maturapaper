package Enemies;

import java.util.Random;

import phaseThreeGames.Board;

public class Mignon extends Enemy{
	//Basic enemy.
	int icounter;
	Random rand;//used to change the imageCounter so that the mignons aren't all in the same position at the same time
	public Mignon(int x, int y, Board parent, int direction) {
		super(x, y, parent);
		this.direction = direction;
		maxSpeed = 2;
		maxLife = 40;
		life = maxLife;
		damage = 10;
		width = 50;
		height = 75;
		this.y -= 15;
		rand = new Random();
		icounter = rand.nextInt(6*12);
		
		source.add("/Pictures/midget/1R.png");
		source.add("/Pictures/midget/2R.png");
		source.add("/Pictures/midget/3R.png");
		source.add("/Pictures/midget/4R.png");
		source.add("/Pictures/midget/FR.png");
		source.add("/Pictures/midget/1L.png");
		source.add("/Pictures/midget/2L.png");
		source.add("/Pictures/midget/3L.png");
		source.add("/Pictures/midget/4L.png");
		source.add("/Pictures/midget/FL.png");

		StringToImage();
		
		
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
		}
		else{
			switch((icounter/a%6))
            {
               case 0:
            	   image[0] = imageCollection[5];break;
               case 1:case 5:
            	   image[0] = imageCollection[6]; break;
               case 2:case 4:
            	   image[0] = imageCollection[7];break;
               case 3:
            	   image[0] = imageCollection[8];break;
            }
			if (dy != 0){
				image[0] = imageCollection[9];
			}
		}
		FreezedSlowedImage();
		
		
	}

}
