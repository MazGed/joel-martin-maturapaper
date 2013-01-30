package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ConfirmationPanel extends JPanel{
	
	//The Panel which shows up when you want to start a new game and which asks you if you are sure.
	
	
	
	private SuperPanel sp;
	private int x;
	private int y;


	public ConfirmationPanel(SuperPanel sp){
		this.sp = sp;
		setFocusable(true);
		addMouseMotionListener(new MMAdapter());
		addMouseListener(new MAdapter());
	}
	
	public void paint(Graphics g){
		Image img;


		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/GUI/areyousure.png"));
		img=ii.getImage();

		
		
		g.drawImage(img, 150, 125, 850, 625, 0, 0, img.getWidth(null), img.getHeight(null), null);
		
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
		
		//Yes and no button
		public void mousePressed(final MouseEvent e) {
			if(477 < y && y < 507){
				if (278 < x && x < 457){//Yes
					sp.load(sp.source, true);
				}
				if (516 < x && x < 691){//No
					sp.menu();
				}
			}
				

		}
	}

}
