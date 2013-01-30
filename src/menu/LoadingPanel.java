package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import phaseThreeGames.GamePanel;

public class LoadingPanel extends JPanel{
	/*Pausing screen. Uses two threads one to animate the loading screen
	 *and one to actually load the new GamePanel
	 * 
	 */
	public Image img[];
	public int count;
	public SuperPanel sp;
	public animator a;
	public loader l;
	public LoadingPanel(SuperPanel sp){
		this.sp = sp;
		
	}
	
	public void paint(Graphics g){
		
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
		//Resets the Threads and starts them and the loading process
		a = new animator();
		l = new loader();
		a.start();
		l.start();
	}
	
	public void loadGamePanel(String source){
		//creates a new GamePanel and shows it inside the window.
		sp.gp = new GamePanel(source, sp);
		sp.add(sp.gp, "Game");
		sp.cards.show(sp, "Game");
		sp.gp.board.requestFocus();
	}
	
	
	public class animator extends Thread{
		//Animates the loading screen. Draws a new picture every 400 ms
		public void run(){
			while (isVisible()){
				repaint();
				try {
					sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public class loader extends Thread{
		//Loads the GamePanel just by triggering the loadGamePanel method.
		public void run(){
			loadGamePanel(sp.source);
			
		}
	}
	
	
	
}



