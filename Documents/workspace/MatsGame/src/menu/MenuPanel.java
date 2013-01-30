package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import menu.StartPanel.MAdapter;
import menu.StartPanel.MMAdapter;

public class MenuPanel extends JPanel{
	
	/*The MenuPanel is the menu on which the player can choose which slot to load
	 *or whether he wants to create a new game.
	 * 
	 */
	
	private SuperPanel sp;
	private int x;
	private int y;


	public MenuPanel(SuperPanel sp){
		this.sp = sp;
		setFocusable(true);
		addMouseMotionListener(new MMAdapter());
		addMouseListener(new MAdapter());
	}
	
	public void paint(Graphics g){
		Image img;


		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/menu.png"));
		img=ii.getImage();

		
		
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
			//Checks whether the player is clicking on a button.
			if(577 < x && x < 754){
				if (281 < y && y < 308){//load game 1
					sp.load("src/saving/1.ser", false);
				}
				if (398 < y && y < 414){//load game 2
					sp.load("src/saving/2.ser", false);
				}
				if (498 < y && y < 525){//load game 3
					sp.load("src/saving/3.ser", false);
				}
			}
			
			if(252 < x && x < 431){
				if (281 < y && y < 308){//new game 1
					sp.confirm("src/saving/1.ser");
				}
				if (398 < y && y < 414){//new game 2
					sp.confirm("src/saving/2.ser");
				}
				if (498 < y && y < 525){//new game 3
					sp.confirm("src/saving/3.ser");
				}
			}
			
			if(799 < x && x < 971){//quit game
				if (698 < y && y < 725){
					System.exit(0);
				}
			}
				

		}
	}

}
