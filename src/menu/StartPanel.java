package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import phaseThreeGames.PausePanel.MAdapter;
import phaseThreeGames.PausePanel.MMAdapter;

public class StartPanel extends JPanel{
	
	//The screen displayed at the beginning of the game. Has one button to actually start the game and dive into the adventure.
	
	private SuperPanel sp;
	private int x;
	private int y;

	public StartPanel(SuperPanel sp){
		this.sp = sp;
		setFocusable(true);
		addMouseMotionListener(new MMAdapter());
		addMouseListener(new MAdapter());
		
	}
	
	
	public void paint(Graphics g){
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/startpanel.png"));
		Image img=ii.getImage();
		
		g.drawImage(img, 0, 0, 1000, 750, 0, 0, img.getWidth(null), img.getHeight(null), null);
		
		g.setColor(Color.BLACK);
		for (int i = 0; i < 4; i++){
			g.drawRect(i, i, 1000-1-i*2, 750-1-i*2);
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
			if(457 < y && y < 488){
				if (395 < x && x < 571){//continue ----> your journey begins here
					sp.menu();
			
				}
			}

		}
	}
		
			

}
