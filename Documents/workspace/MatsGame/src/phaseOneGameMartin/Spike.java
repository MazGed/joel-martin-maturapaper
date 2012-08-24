package phaseOneGameMartin;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Spike {
	//This is a simple class that contains the image and the collision rectangle for the spikes.
	//The x and y coordinate are defined when a spike is created on the board.
	
	private Image image;
	private int x, y, HGT, WDT;
	private String source = "spike.jpg";
	
	public Spike(int x, int y){
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
		return new Rectangle (x+3,y+2,WDT-6,HGT-2);
	}
	


	
	public Image getImage(){
		return image;
	}
	

}
