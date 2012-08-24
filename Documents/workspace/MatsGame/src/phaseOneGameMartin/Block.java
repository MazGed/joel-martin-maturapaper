package phaseOneGameMartin;

import java.awt.*;
import javax.swing.*;

public class Block {
	//This is a simple class that contains the image and the two rectangles for the platform components.
	//The x and y component can be defined when a block is created on the board.
	private Image image;
	private int x, y, HGT, WDT;
	private String source = "block.jpg";
	
	public Block(int x, int y){
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
		
	public Rectangle getBuffer(){
		return new Rectangle (x,y-5,WDT,4);
	}
	
	public Rectangle getRail(){
		return new Rectangle (x,y-1,WDT,1);
	}
	
	public Image getImage(){
		return image;
	}
	

}
