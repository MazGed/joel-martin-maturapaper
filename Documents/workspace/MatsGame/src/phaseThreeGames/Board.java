
package phaseThreeGames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.*;

import staticSprites.*;
import variousSprites.CloakChanger;
import variousSprites.CloakSpawner;
import variousSprites.Flag;
import variousSprites.LifeWell;
import variousSprites.ManaBall;
import variousSprites.ManaWell;
import variousSprites.Portal;
import variousSprites.Spike;
import variousSprites.StartPortal;
import variousSprites.Tag;
import variousSprites.WeaponChanger;
import variousSprites.WeaponSpawner;

import Cloaks.DarkCloak;
import Enemies.*;
import Goals.Goal;
import Weapons.PurpleStaff;

/*The board is basically the class that coordinates the Sprites. It gives them their starting position and launches their methods in the right order every cycle
 *It also is responsible for the painting of all the classes and registers Key and MouseEvents. It also contains a skinset which gives the Blocks and Platforms their image.
 *It also contains and draws the UserInterface
 */
public class Board extends JPanel implements ActionListener{
	
	
	public GamePanel gp;// The game panel which coordinates the Board
	
	// The integers used during the creation of the Sprites
	public int SPACE = 60;
	public int h = 0;
	public int w = 0;
	public int worldX;
	public int worldY;
	public int deathCounter = 100;
	public String world = "";//The map editor String. Every char of this String symbolizes a different Sprite
	
	public Timer timer;//responsible for the cycles
	public Player p;//The player which is technically a Sprite but has to be defined as p because it contains a lot of methods like the KeyEvents
	public Camera c;//The camera which defines which part of the map is to be drawn
	
	public Skinset skin;//The skinset which gives blocks and platforms their images
	public String BackSource="/Pictures/Background.jpg";//data name for the background
	public Image Background;// the background image

	public ArrayList<Sprite> movingSprites;//ArrayList for movingSprites (player, enemies, etc)
	public ArrayList<Sprite> staticSprites;//ArrayList for staticSprites (blocks, platforms, etc)
	public int Gravity[] = {1,1};//The strength of the gravity on this board
	
	public UserInterface ui = new UserInterface(this);// the ui
	
	
	public Board(GamePanel gp){
		this.gp = gp;
		
		
		setFocusable(true);//necessary for the board to be able to be focused by mouse and keyboard
		setDoubleBuffered(true);// reduces flickering a bit
		//add all the listener (defined as local classes down below)
		addKeyListener(new Adapter());
		addMouseMotionListener(new MMAdapter());
		addMouseListener(new MAdapter());
		movingSprites = new ArrayList<Sprite>();
		staticSprites = new ArrayList<Sprite>();
		c = new Camera(this);	
		timer = new Timer(20, this);//sets the time between the cycles to 20 milliseconds
		p = new Player(0,0,this);//creates the player
		
		
		
		
		
	}
		

		
	
	public void InitSprites(){
		//launched in the constructor of subclasses. Creates the map from the world String.
		worldX = 0;
		worldY = 0;
		//WorldToSprites is the actual map creation. It is defined as its own method so that the char standing for a Sprite can be changed from subclass to subclass.
		for (int j = 0; j < world.length(); j++) {
			
			char item = world.charAt(j);
			if (item == '\n') {
				worldY += SPACE;
                if (this.w < worldX) {
                    this.w = worldX;
                }
				worldX = 0;
	            
			}
			
			WorldToSprites(item);
				

	        h = worldY;
	           
	            
	           
	            
			}
		//Creates the Background
		ImageIcon ii = new ImageIcon(this.getClass().getResource(BackSource));
		Background=ii.getImage();
		//triggers the InitImage() method for all the staticSprites
		for (int i = 0; i < staticSprites.size(); i++){
			Sprite s = (Sprite)staticSprites.get(i);
			s.InitImage();
		}
	}
	
	public void WorldToSprites(char item){
		//WorldToSprites() takes the world String and creates the map from it
		if (item == '@') {
            new Block(worldX, worldY, this);
            worldX += SPACE;
            
        } 
		else if (item == '>') {
            new ShamanMignon(worldX, worldY,this,1);
            worldX += SPACE;
        } 
		else if (item == '<') {
			new ManaWell(worldX, worldY,this);
            worldX += SPACE;
        } 
		else if (item == '#') {
			new Platform(worldX, worldY,this);
            worldX += SPACE;
        }
		else if (item == '!') {
            p.x = worldX;
            p.y = worldY;
            worldX += SPACE;
        }
		else if (item == 'p'){
			new Portal(worldX, worldY, this);
			worldX += SPACE;
		}
		else if (item == ' '){
            worldX += SPACE;
        }
		
	}


	public void actionPerformed(ActionEvent e) {
		/*This is the so called cycle. First the Init() method is triggered for all the movingSprites 
		 *then the board checks whether the collision polygon of a any movingSprite collides with the bounds of any staticSprites and triggers the collision(s1, s) method if that's the case
		 *then the movingSprites are moved
		 *then the board checks whether the bounds of any movingSprite collide with the bounds of any other movingSprite
		 *then the board checks whether the mission goal has been accomplished
		 *then the board removes all the dead Sprites (life = 0);
		 *and finally it repaints everything
		 */
		
		long beforeTime, timeDiff;
		beforeTime= System.currentTimeMillis();
		Init();
		StaticMovingCollisionCheck();
		move();
		MovingMovingCollisionCheck();
		try{
			gp.g.test();}
		catch(NullPointerException ex){}
		DeathCheck();
		repaint();
		
		if (p.life < 1){
			deathCounter--;
		}
		
		timeDiff= System.currentTimeMillis() - beforeTime;
		
		
	}
	
	public void paint(Graphics g){
		
		// the paint method
		Graphics2D g2d = (Graphics2D)g;
		super.paint(g);
		g.setColor(Color.red);
		
		//draws background image
		int bgcx = c.x*Background.getWidth(null)/w;
		
		int bgcy = c.y*Background.getHeight(null)/h;
		g2d.drawImage(Background, 0, 0, 1000, 750,bgcx, bgcy, bgcx+1000*Background.getWidth(null)/w, bgcy+750*Background.getHeight(null)/h, null);
		
		//Draws all the movingSprites
		for (int i = 0; i < movingSprites.size(); i++) {
				Sprite s = (Sprite)movingSprites.get(i);
				s.findImage();
				try{
					for (int j = 0; j < s.image.length; j++){
						if (s.image[j]!=null){
							g2d.drawImage(s.image[j], s.x-c.x-s.xNcorrect, s.y-c.y-s.ycorrect, s.x-c.x+s.width+s.xPcorrect, s.y-c.y+s.height, 
									0,0,s.image[j].getWidth(null),s.image[j].getHeight(null), null);
							
						}
						
					}
					if (s.spriteString == "Enemy" && s.life != s.maxLife){
						g2d.setColor(Color.RED);
						g2d.fillRect(s.x-c.x-s.xNcorrect,s.y-c.y-s.ycorrect-10, (int) (20*((double)s.life/s.maxLife)), 5);
						g2d.setColor(Color.BLACK);
						g2d.drawRect(s.x-c.x-s.xNcorrect,s.y-c.y-s.ycorrect-10, 20, 5);
					}
				}catch(NullPointerException e){
					g2d.fillRect(s.x-c.x, s.y-c.y, s.width, s.height);
				}
				
				
				
			
		}
		//Draws all the staticSprites
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] allFonts = ge.getAvailableFontFamilyNames();
		Font font = new Font(allFonts[1],Font.PLAIN,14);
	    g2d.setFont(font);
		g2d.setColor(Color.black);
		
		for (int i = 0; i < staticSprites.size(); i++) {
			Sprite s = (Sprite)staticSprites.get(i);
			try{
				for (int j = 0; j < s.image.length; j++){
					g2d.drawImage(s.image[j], s.x-c.x-s.xNcorrect, s.y-c.y-s.ycorrect, s.x-c.x+s.width+s.xPcorrect, s.y-c.y+s.height, 
							0,0,s.image[j].getWidth(null),s.image[j].getHeight(null), null);
					if (s.getClass() == variousSprites.Tag.class){
						Tag t = (Tag) s;
						PausePanel.drawString(g2d, t.s, t.x-c.x+25, t.y-c.y+37, t.width-50);
						
					}
				}
			}catch(NullPointerException e){
				g2d.drawRect(s.x-c.x, s.y-c.y, s.width, s.height);
			}
		
		}
		//Draws the player once again (since he is inside the movingSprites) so that he is drawn over anything else
		if (p.life > 0){
			for (int j = 0; j < p.image.length; j++){
				if (p.image[j]!=null){
					g2d.drawImage(p.image[j], p.x-c.x-p.xNcorrect, p.y-c.y-p.ycorrect, p.x-c.x+p.width+p.xPcorrect, p.y-c.y+p.height, 
							0,0,p.image[j].getWidth(null),p.image[j].getHeight(null), null);
					
				}
			}
		}
		
		
		
		//Draws the user interface
		ui.paintGui(g2d);
		g2d.setColor(Color.BLACK);
		
		for (int i = 0; i < 4; i++){
			g2d.drawRect(i, i, 1000-1-i*2, 750-1-i*2);
		}
		
		
	}
	
	public void move(){
		//triggers move() for all the movingSprites
		for (int i = 0; i < movingSprites.size(); i++){
			Sprite s = (Sprite)movingSprites.get(i);
			s.move();
			c.move();
		}
	}
	
	public void Init(){
		//triggers Init() for all the movingSprites
	for (int i = 0; i < movingSprites.size(); i++){
		Sprite s = (Sprite)movingSprites.get(i);
		s.Init();
		}
	}
	

	
	
	

	public void StaticMovingCollisionCheck(){
		//collides the collision polygon of every movingSprite with the bounds of all the staticSprites
		for (int i= 0; i<movingSprites.size(); i++){
			Sprite s = (Sprite)movingSprites.get(i);
			for (int j=0; j<staticSprites.size(); j++){
				Sprite s2 = (Sprite)staticSprites.get(j);
				if (s.x>s2.x-200 && s.x<s2.x+200 && s.y>s2.y-200 && s.y<s2.y+200){
					if (s.collisionp.intersects(s2.bounds)){
						s2.Collision(s.spriteString,s);
						s.Collision(s2.spriteString,s2);
						
					}
				}
			}
		}
	}
	
	public void MovingMovingCollisionCheck(){
		//collides the bounds of every movingSprite with the bounds of all the other movingSprites
		for (int i= 0; i <movingSprites.size(); i++){
			Sprite s = (Sprite)movingSprites.get(i);
			for (int j = i+1; j<movingSprites.size(); j++){
				Sprite s2 = (Sprite)movingSprites.get(j);
				if (s.bounds.intersects(s2.bounds)){
					s.Collision(s2.spriteString ,s2);
					s2.Collision(s.spriteString ,s);				
				}
			}
		}
	}
	
	public void DeathCheck(){
		//if a movingSprites life is reduced to zero, it is removed from the game
		for (int i = 0; i <movingSprites.size(); i++){
			Sprite s = (Sprite)movingSprites.get(i);
			if (s.life <=0){
				movingSprites.get(i).death();
				movingSprites.remove(i);
				i -= 1;
			}
		}
	}
	
	public class Adapter extends KeyAdapter{
		//The KeyListener, all the methods are defined in the player
		public void keyPressed(KeyEvent e){
			p.keyPressed(e);
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_P){
				gp.pause(1);
				}

		}
		
		public void keyReleased (KeyEvent e){
			p.keyReleased(e);
		}
	}
	
	public class MMAdapter extends MouseMotionAdapter{
		//The MouseMotionListener, all the methods are defined in the UserInterface
		public void mouseMoved(final MouseEvent e) {
            ui.mouseMoved(e);
        }
	}
	
	public class MAdapter extends MouseAdapter{
		//The MouseListener, all the methods are defined in the UserInterface
		public void mousePressed(final MouseEvent e) {
            ui.mousePressed(e);
        }
	}



}
