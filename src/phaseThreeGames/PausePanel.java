package phaseThreeGames;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

import Goals.Goal;

import phaseThreeGames.Board.Adapter;
import phaseThreeGames.Board.MAdapter;
import phaseThreeGames.Board.MMAdapter;

public class PausePanel extends JPanel{
	
	/*The PausePanel is the Panel that appears right when the player starts a level, when the player pauses the game
	 * or when the player ends a level (by succeeding or loosing). From the PP the player can resume or start his game,
	 * go back to the holy sanctuary, go back to the main menu or even quit the game. Additionally the PausePanel also
	 * displays the level's goal, some lore about the level and gives an overview of the keys and their function.
	 * 
	 */
	Image PauseMenu;
	GamePanel gp;
	public int state;
	int x; 
	int y;
	
	//This are the strings which are drawn inside the PP when the player is inside the HolySanctuary.
	public String title="The Holy Sanctuary";
	public String mission="Take a break and rewiew your equipment before diving right back into the adventure by entering a portal. ";
	public String lore = "The elder told us never to underestimate the importance of a save place. A place without demons. A place to focus. " +
			"This specific place was purged by the demigod Zurtor himself during the big demon wars. It is nowadays hardly inhabited but still used " +
			"by the local guardian.";
	
	
	private Image startButtons;
	private Image buttons;
	private Image endButtons;
	private Image win;
	private Image loose;
	private Image tutorial;
	public PausePanel(GamePanel gp){
		this.gp = gp;
		addKeyListener(new pAdapter());
		addMouseMotionListener(new MMAdapter());
		addMouseListener(new MAdapter());
		setFocusable(true);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/PP.png"));
		PauseMenu=ii.getImage();
		ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/startButtons.png"));
		startButtons=ii.getImage();
		ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/buttons.png"));
		buttons=ii.getImage();
		ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/endButtons.png"));
		endButtons=ii.getImage();
		ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/end.png"));
		win=ii.getImage();
		ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/failed.png"));
		loose=ii.getImage();
		ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/keys.png"));
		tutorial=ii.getImage();
	}
	
	public static void drawString(Graphics g, String s, int x, int y, int width)
	//drawString is a method which draws a String at x/y. If the length of the drawn 
	//String exceeds width amount of pixels it is going to be cut into several lines
	//which are never bigger than width.
	{
		// FontMetrics gives us information about the width,
		// height, etc. of the current Graphics object's Font.
		FontMetrics fm = g.getFontMetrics();

		int lineHeight = fm.getHeight();

		int curX = x;
		int curY = y;

		String[] words = s.split(" ");

		for (String word : words)
		{
			
			// Find out the width of the word.
			int wordWidth = fm.stringWidth(word + " ");

			// If text exceeds the width, then move to next line.
			if (curX + wordWidth >= x + width)
			{
				curY += lineHeight;
				curX = x;
			}

			g.drawString(word, curX, curY);

			// Move over to the right for next word.
			curX += wordWidth;
		}
	}
	
	
	public void paint(Graphics g){
		//the String allFonts is necessary to change the font. It contains all the font's names.
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] allFonts = ge.getAvailableFontFamilyNames();
		
		
		
		//draws the background + the keys and their function
		g.drawImage(PauseMenu, 0, 0, 1000, 750, 0, 0, PauseMenu.getWidth(null), PauseMenu.getHeight(null), null);
		g.drawImage(tutorial, 0, 0, 1000, 720, 0, 0, PauseMenu.getWidth(null), PauseMenu.getHeight(null), null);
		
		
		//If a the player is inside a level the PausePanel will draw the lore and the goal of that specific level.
		//If the player is inside the holy sanctuary choosing a level, the PausePanel will draw the description of the HolySantuary (written above).
		try{
			Font font = new Font(allFonts[1],Font.PLAIN,30);
		    g.setFont(font);
		    
			g.drawString(gp.lvl.title, 80,100);
			
			font = new Font(allFonts[2],Font.PLAIN,22);
		    g.setFont(font);
			
			drawString(g, gp.lvl.mission, 80, 130, 400);
			drawString(g, gp.lvl.lore, 80, 300, 400);
		}catch(NullPointerException e){
			Font font = new Font(allFonts[2],Font.PLAIN,30);
		    g.setFont(font);
		    
			g.drawString(title, 80,100);
			
			font = new Font(allFonts[2],Font.PLAIN,22);
		    g.setFont(font);
			
			drawString(g, mission, 80, 140, 400);
			drawString(g, lore, 80, 300, 400);
		}
		
		/*Depending on whether the player is starting, loosing, winning or pausing a level an other set of buttons are displayed.
		 *When the player starts a level: "Start Game", "End Level", "End Game", "Back to main menu".
		 *When the player pauses a level: "Resume Game", "End Level", "End Game", "Back to main menu".
		 *When the player wins a level: "Continue", additionally a big "accomplished"-sign appears.
		 *When the player looses a level: "Continue", additionally a big "failed"-sign appears.
		 */
		
		switch (state){
		case 0:
			g.drawImage(startButtons, 0, 0, 1000, 720, 0, 0, PauseMenu.getWidth(null), PauseMenu.getHeight(null), null);
			break;
		case 2: 
			g.drawImage(endButtons, 0, 0, 1000, 720, 0, 0, PauseMenu.getWidth(null), PauseMenu.getHeight(null), null);
			g.drawImage(win, 0, 0, 1000, 720, 0, 0, PauseMenu.getWidth(null), PauseMenu.getHeight(null), null);
			break;
			
		case 3:
			g.drawImage(endButtons, 0, 0, 1000, 720, 0, 0, PauseMenu.getWidth(null), PauseMenu.getHeight(null), null);
			g.drawImage(loose, 0, 0, 1000, 720, 0, 0, PauseMenu.getWidth(null), PauseMenu.getHeight(null), null);
			break;
			
		case 1:
			g.drawImage(buttons, 0, 0, 1000, 720, 0, 0, PauseMenu.getWidth(null), PauseMenu.getHeight(null), null);
			break;
		}
		
		//Draws the frame around the window
		g.setColor(Color.BLACK);
		for (int i = 0; i < 4; i++){
			g.drawRect(i, i, 1000-1-i*2, 750-1-i*2);
		}

	}
	
	
	public class pAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			//Allows the player to unpause the game by clicking p.
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_P){
				if (state < 2){
					gp.board();
				}else{
					gp.backToBase();
				}
				}
		}
	}
	public class MMAdapter extends MouseMotionAdapter{
		//Tracks mouse movement so that the mouseAdapter can make a difference between different buttons.
		public void mouseMoved(final MouseEvent e) {
			x = e.getX();
	        y = e.getY();
        }
	}
	
	public class MAdapter extends MouseAdapter{
		public void mousePressed(final MouseEvent e) {
			if(556 < y && y < 578){
				
				if (560 < x && x < 740){//"Resume Game" or "Start Game"
					if (state < 2){
						gp.board();
					}
				}
				
				if (770 < x && x < 950){//"Quit Level"
					if (state < 2){
						gp.backToBase();
					}
				}
			}
			
			if(603 < y && y < 629){
				
				if (560 < x && x < 740){
					if (state < 2){//"Main MEnu"
						gp.sp.menu();
					}
				}
				
				if (770 < x && x < 950){
					if (state < 2){//"Quit Game"
						System.exit(0);
					}else{//"Continue"
						gp.backToBase();
					}
				}
			}
        }
	}
}
