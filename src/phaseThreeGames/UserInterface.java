package phaseThreeGames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class UserInterface {
	/*The UserInterface includes everything that is shown when the player is playing a level but that doesn't interact with
	 * the player's figure. For example : lifebar, manabar, carried items. The user however can interact with the user interface
	 * for it has key and mouseListeners.
	 *
	 */
	public Board board;
	public Image[] images;
	public String[] source;
	public int x, y;
	public boolean hidden;
	public UserInterface(Board board){
		this.board = board;
		
		
		source = new String[5];
		source[0] = "/Pictures/GUI/manabar.png"; 
		source[1] = "/Pictures/GUI/healthbar.png"; 
		source[2] = "/Pictures/GUI/GUI.png";
		source[3] = "/Pictures/GUI/InfoWindow.png"; 
		source[4] = "/Pictures/GUI/InfoWindow.png"; 
		images = new Image[5];
		for (int i = 0; i < source.length; i++){
			ImageIcon ii = new ImageIcon(this.getClass().getResource(source[i]));
			images[i]=ii.getImage();}
	}
	
	public void paintGui(Graphics g2d){
		if (hidden == false){
			//Draws the GUI's frame
			g2d.drawImage(images[2], 0, 0, 1000, 750, 0,0,images[2].getWidth(null), images[2].getHeight(null), null );
			//Draws all the carried items Icons into the right slot
			g2d.drawImage(GamePanel.carriedCloaks[0].imageCollection[12], 495, 654, 542, 703, 0,0,
					GamePanel.carriedCloaks[0].imageCollection[12].getWidth(null), GamePanel.carriedCloaks[0].imageCollection[12].getHeight(null), null );
			g2d.drawImage(GamePanel.carriedCloaks[1].imageCollection[12], 566, 654, 611, 703, 0,0,
					GamePanel.carriedCloaks[1].imageCollection[12].getWidth(null), GamePanel.carriedCloaks[1].imageCollection[12].getHeight(null), null );
			g2d.drawImage(GamePanel.carriedCloaks[2].imageCollection[12], 566+70, 654, 611+70, 703, 0,0,
					GamePanel.carriedCloaks[2].imageCollection[12].getWidth(null), GamePanel.carriedCloaks[2].imageCollection[12].getHeight(null), null );
			g2d.drawImage(GamePanel.carriedWeapons[0].imageCollection[12], 777, 654, 822, 703, 0,0,
					GamePanel.carriedWeapons[0].imageCollection[12].getWidth(null), GamePanel.carriedWeapons[0].imageCollection[12].getHeight(null), null );
			g2d.drawImage(GamePanel.carriedWeapons[1].imageCollection[12], 777+70, 654, 822+70, 703, 0,0,
					GamePanel.carriedWeapons[1].imageCollection[12].getWidth(null), GamePanel.carriedWeapons[1].imageCollection[12].getHeight(null), null );
			g2d.drawImage(GamePanel.carriedWeapons[2].imageCollection[12], 777+140, 654, 822+140, 703, 0,0,
					GamePanel.carriedWeapons[2].imageCollection[12].getWidth(null), GamePanel.carriedWeapons[2].imageCollection[12].getHeight(null), null );
			
			//Set the right font
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			String[] allFonts = ge.getAvailableFontFamilyNames();
			Font font = new Font(allFonts[1],Font.PLAIN,14);
		    g2d.setFont(font);
			
		    //draws the life and manabar
			int lifebarsize = (int) (171*board.p.life/board.p.maxLife);
			int manabarsize = (int) (171*board.p.mana/board.p.maxMana);
			g2d.drawImage(images[1], 97, 690, 97+lifebarsize, 720, 0,0,images[1].getWidth(null)*board.p.life/board.p.maxLife, images[1].getHeight(null), null );
			g2d.drawImage(images[0], 97, 713, 97+manabarsize, 743, 0,0,images[0].getWidth(null)*board.p.mana/board.p.maxMana, images[0].getHeight(null), null );
			
			//Draws mana/maxMana, life/maxLife + amount of armor
			g2d.setColor(Color.lightGray);
			g2d.drawString(board.p.life+"/"+board.p.maxLife, 97 +190, 710);
			
			g2d.drawString(board.p.mana+"/"+board.p.maxMana, 97 +190, 735);
			
			g2d.drawString("Armor: "+board.p.armor, 97 +290, 707);
			g2d.drawString("Manacost: "+board.p.w.manaCost, 97 +290, 722);
			g2d.drawString("Reload: "+board.p.w.reloadTime, 97 +290, 737);
			
			//When the player is hovering over one of his items a window pops up with the item's description
			font = new Font(allFonts[1],Font.PLAIN,18);
		    g2d.setFont(font);
		    try{
		    	g2d.drawImage(images[3], 750, 10, 990, 130, 0,0,images[3].getWidth(null), images[3].getHeight(null), null );
			    PausePanel.drawString(g2d,"Goal: "+board.gp.lvl.goal.instruction ,765 , 50, 220);
		    }catch (NullPointerException e){
		    	PausePanel.drawString(g2d,"Chill out and rewiew your equipment before your next adventure." ,765 , 50, 220);
		    }
		    
		    
			if(654 < y && y < 703){
				
				if (495 < x && x < 540){
					g2d.drawImage(images[3], 750, 500, 990, 620, 0,0,images[3].getWidth(null), images[3].getHeight(null), null );
					g2d.drawString(GamePanel.carriedCloaks[0].name, 760 , 525);
					PausePanel.drawString(g2d, GamePanel.carriedCloaks[0].description,760 , 555, 220);
				}
				if (566 < x && x < 611){
					g2d.drawImage(images[3], 750, 500, 990, 620, 0,0,images[3].getWidth(null), images[3].getHeight(null), null );
					g2d.drawString(GamePanel.carriedCloaks[1].name, 760 , 525);
					PausePanel.drawString(g2d, GamePanel.carriedCloaks[1].description,760 , 555, 220);
				}
				if (566+70 < x && x < 611+70){
					g2d.drawImage(images[3], 750, 500, 990, 620, 0,0,images[3].getWidth(null), images[3].getHeight(null), null );
					g2d.drawString(GamePanel.carriedCloaks[2].name, 760 , 525);
					PausePanel.drawString(g2d, GamePanel.carriedCloaks[2].description,760 , 555, 220);
				}
				if (777 < x && x < 822){
					g2d.drawImage(images[3], 750, 500, 990, 620, 0,0,images[3].getWidth(null), images[3].getHeight(null), null );
					g2d.drawString(GamePanel.carriedWeapons[0].name, 760 , 525);
					PausePanel.drawString(g2d, GamePanel.carriedWeapons[0].description,760 , 555, 220);
				}
				if (777+70 < x && x < 822+70){
					g2d.drawImage(images[3], 750, 500, 990, 620, 0,0,images[3].getWidth(null), images[3].getHeight(null), null );
					g2d.drawString(GamePanel.carriedWeapons[1].name, 760 , 525);
					PausePanel.drawString(g2d, GamePanel.carriedWeapons[1].description,760 , 555, 220);
				}
				if (777+140 < x && x < 822+140){
					g2d.drawImage(images[3], 750, 500, 990, 620, 0,0,images[3].getWidth(null), images[3].getHeight(null), null );
					g2d.drawString(GamePanel.carriedWeapons[2].name, 760 , 525);
					PausePanel.drawString(g2d, GamePanel.carriedWeapons[2].description,760 , 555, 220);
				}
				
				
			}
			
			
			
		}
		
		
		
	}
	
	public void mouseMoved(final MouseEvent e) {
		//Keeps track of the mouse's position (used to know whether the mouse is over an item)
        x = e.getX();
        y = e.getY();
    }

	public void mousePressed(MouseEvent e) {
		//The player can click on an carried item to put it on.
		
		System.out.println(x+" "+y);
		
		if(654 < y && y < 703){
			
			if (495 < x && x < 540){//puts on cloak 1
				GamePanel.cIndex[3]=0;

			}
			if (566 < x && x < 611){//puts on cloak 2
				GamePanel.cIndex[3]=1;
			}
			if (566+70 < x && x < 611+70){//puts on cloak 3
				GamePanel.cIndex[3]=2;
			}
			if (777 < x && x < 822){//puts on weapon 1
				GamePanel.wIndex[3]=0;
			}
			if (777+70 < x && x < 822+70){//puts on weapon 2
				GamePanel.wIndex[3]=1;
			}
			if (777+140 < x && x < 822+140){//puts on weapon 3
				GamePanel.wIndex[3]=2;
			}
			
			
		}
		
	}

}
