package phaseThreeGames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


import phaseThreeGames.GamePanel;

public class LoadingPanel extends JPanel{
	/*The Panel that shows up every time the GamePanel has to load a level.
	 *It contains to thread object: one which draws the loading screen and another that loads the actual game
	 */
	
	public Image img[];
	public int count;
	public GamePanel gp;
	public animator a;
	public loader l;
	public LoadingPanel(GamePanel gp){
		this.gp = gp;
		a = new animator();
		l = new loader();
		
	}
	
	public void paint(Graphics g){
		//Paint method
		
		img = new Image[4];
		for (int i = 0; i < 4; i++){
			int a = i+1;
			if (a==4) a -= 2;
			ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/loading"+a+".png"));
			img[i]=ii.getImage();
		}
		
		
		g.drawImage(img[count], 0, 0, 1000, 750, 0, 0, img[0].getWidth(null), img[0].getHeight(null), null);
		
		g.setColor(Color.BLACK);
		for (int i = 0; i < 4; i++){
			g.drawRect(i, i, 1000-1-i*2, 750-1-i*2);
		}
		count +=1;
		if (count == 4){
			count = 0;
		}
			
			
		
	}
	
	public void initLoading(){
		//Starts the loading process
		
		
		a.start();
		l.start();
		
	}
	
	public void loadBoard(Class source){
		//creates a level-object
		gp.pp.state=0;
		try {
			gp.startLevel((Level) gp.source.getConstructors()[0].newInstance(gp));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public class animator extends Thread{
		//The thread which draws the screen. It always pauses for 400 ms between the images.
		public void run(){
			while (isVisible()){
				repaint();
				try {
					sleep(400);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public class loader extends Thread{
		//the Thread loading the level. It just creates a level and resets both threads after that.
		public void run(){
			loadBoard(gp.source);
			a = new animator();
			l = new loader();
			
		}
	}
	
	
	
}



