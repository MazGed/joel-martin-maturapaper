package phaseOneGameMartin;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Goal {
	// This is a simple class that contains the image and the collision rectangle for the goal.
	// The x and y coordinate are defined when a goal is created on the board.
	private Image image;
	private int x, y, HGT, WDT;
	private String source = "goal.jpg";
	
	public Goal(int x, int y){
		ImageIcon ii = new ImageIcon(this.getClass().getResource(source));
		image = ii.getImage();
		this.x = x;
		this.y = y;
		HGT = image.getHeight(null);
		WDT = image.getWidth(null);
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle (x,y,WDT,HGT);
	}
	


	
	public Image getImage(){
		return image;
	}
	

}
