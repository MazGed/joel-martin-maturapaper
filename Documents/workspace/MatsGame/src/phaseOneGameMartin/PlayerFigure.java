package phaseOneGameMartin;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class PlayerFigure {
//This Class defines the Figure that the player controls.
	
	private int
	x, 
	y, //x and y-coordinate of the figure. These Integers define the position of the figure on the board.
	HGT, 
	WDT,//height and width of the figure. These integers are needed to check for collisions with other objects.
	dx,
	dy,// delta x and y. These integers allow to change x and y and as a consequence to move on the board.
	JumpHeight,// This integer defines how high the figure can jump.
	JumpIndex,//This integer is needed in move() and explained there.
	JumpTime,//JumpTime defines how long the figure jumps.
	Gravity,// This integer defines how fast the figure falls when it is in the air and not jumping.
	PlayerSpeed;//This integer defines the speed of the figure while it walks.
	
	private boolean
	movingx = false, // movingx is true as long as the figure moves vertically. 
	movingy = true, // movingy is true as long as the figure moves horizontally.
	LookingLeft = false; // This boolean defines on which side the figure is looking.
	
	
	private Image
	StandingLeft,
	MovingLeft,
	JumpingLeft,
	StandingRight,
	MovingRight,
	JumpingRight,
	image;
	
	private Image[] PlayerImage={
			StandingLeft, MovingLeft, JumpingLeft, StandingRight, MovingRight, JumpingRight};
	// These six images are for every of the six position the figure can have. Their names are self-explanatory.
			

	
	private String[] Source ={
			"sl.jpg", "ml.jpg", "jl.jpg", "sr.jpg", "mr.jpg", "jr.jpg"};
	// Six different Sources for the six images.
	

	private int b;
	private int a;
	// needed in Buffer().
	
	
	public PlayerFigure(){
		for (int i = 0; i < PlayerImage.length; i++){
			ImageIcon ii = new ImageIcon(this.getClass().getResource(Source[i]));
			PlayerImage[i]=ii.getImage();}			
		image=StandingRight;
		y=400;
		x=50;
		JumpIndex = 0;
		JumpTime=20;
		JumpHeight= 100;
		WDT=20;
		HGT=20;
		Gravity = 5;
		PlayerSpeed = 3;

	}
	
	public void move(){
		
		if (JumpIndex>JumpTime)
			JumpIndex=0;
		if (movingy==true){
			dy= Gravity;
			if (JumpIndex>0){
				dy= -JumpHeight/JumpTime;
				JumpIndex +=1;}
		}
		//If JumpIndex is 1 or more, it will increase every time move() is used.
		//If JumpIndex gets bigger than JumpTime it will be set back to 0.
		//As long as JumpIndex is bigger than 0 delta y is negative which means the figure is jumping.
		
		
				
		x = x + dx;
		y = y + dy;
		// adds delta x and y to the coordinates.
		
			
			
		movingy = true;
		// Sets movingy to true so that the figure will fall nest time move() is used if it moved away from the a platform.
		}

	
	
	public int getX(){
		return x;}

	public int getY(){
	 	return y;}
	
	
	public Image getImage(){
		findImage();
		return image;}
	//method to get the figures coordinates and image in another class.
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,WDT,HGT);}
	
	public Rectangle getFeets(){
		return new Rectangle(x,y+19,WDT,1);}
	//These rectangles are used to collide with other objects. getBounds() is used for collisions with spikes and the goal. getFeets for collisions with platforms.
	
	public void keyPressed(KeyEvent e){
		//These are the KeyEvents.
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT){
			if (movingx==false){
				dx = -PlayerSpeed;
				movingx=true;
				LookingLeft=true;}}

		
		if (key == KeyEvent.VK_RIGHT){
			if (movingx==false){
				dx = PlayerSpeed;
				movingx=true;
				LookingLeft=false;}}
		
		if (key == KeyEvent.VK_SPACE){
			if (movingy==false)
				Jump();}

		
		
	}
	
	public void keyReleased(KeyEvent e){
		//Released KeyEvents are needed so that the figure stops moving when the key gets released.
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT){
			dx = 0;
			movingx=false;
			}
		if (key == KeyEvent.VK_RIGHT){
			dx = 0;
			movingx=false;
			}
	}
	
	
	public void Jump(){
		//sets movingy to true and JumpIndex so that the figure will jump when move() is used.
		movingy=true;
		JumpIndex=1;		
	}
	
	
	public void StopFalling(){
		//The figure stops falling. Used when figure collides with a platform.
		dy=0;
		movingy=false;
	}
	
	public void Buffer(int a , int b){
		//This function avoids that the figure lands inside the platform.
		//When the figures rectangle getFeets() enters the platforms rectangle getBuffer() the function slows the figure down.
		this.a = a;
		this.b = b;
		int c = b - a - 20;
		movingy=false;
		dy = c;
	}
	
	public void findImage(){
		// this function checks in which of the six positions the figure is. 
		if (LookingLeft == true){
			if (movingx==false)
				image = PlayerImage[0];
			if (movingx)
				image = PlayerImage[1];
			if (movingy)
				image = PlayerImage[2];
		}
		else{
			if (movingx==false)
				image = PlayerImage[3];
			if (movingx)
				image = PlayerImage[4];
			if (movingy)
				image = PlayerImage[5];
		}
	}
	
	

}
