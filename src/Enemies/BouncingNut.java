package Enemies;

import phaseThreeGames.Board;

public class BouncingNut extends Enemy{
	
	/*Very basic enemy. It behaves as stated in the enemy class.
	 *Elastic enemy
	 * 
	 */
	
	int imageCounter = 100;
	public BouncingNut(int x, int y, Board parent, int direction) {
		super(x, y, parent);
		maxSpeed = 5;
		this.direction = direction;
		maxLife = 40;
		life = maxLife;
		damage = 15;
		width = 60;
		height = 60;
		elasticity = 1;
		
		source.add("/Pictures/ball/1.png");
		source.add("/Pictures/ball/2.png");
		source.add("/Pictures/ball/3.png");
		source.add("/Pictures/ball/4.png");
		source.add("/Pictures/ball/5.png");

		StringToImage();
		
		
	}
	
	public void findImage(){
		imageCounter +=direction;
		imageCounter = imageCounter%75;
		if (imageCounter==-1) imageCounter = 74;  
		
		image[0] = imageCollection[imageCounter/15%5];
		FreezedSlowedImage();
		
		
		
	}
	
	public void Init(){
		super.Init();
		if (yImp>25)yImp = 25;
		
	}



}
