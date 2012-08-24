package phaseOneGameMartin;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;
import phaseOneGameMartin.PlayerFigure;




public class Board extends JPanel implements ActionListener {
	//This class is the board on which my game takes place. Everything is animated and all the key events are registered in here.
	
	private boolean ingame; //ingame is true as long as the game is running.
	private PlayerFigure player;
	private Goal goal;
	private Timer timer;
	private ArrayList blocks; 
	private ArrayList spikes;
	private boolean result;//If result is true at the end of the game the player wins.
	private int pos[][]={
			{20,500,10}, {260,480,5}, {450, 580, 5}, {600, 500, 3}, {680, 550, 2}, {740, 600, 9}, {860,500,3}, {860,400,3},{860,300,3},{860,200,3}, {600, 250, 7}, {460, 200, 3}, {460,125,3},
			{460,050,3}, {20,360,7}
	};
	//This array determines position an length of all the platforms it works like this {x coordinate of the platform, y coordinate, number of blocks (length) of the platform}.
	
	private int possp[][] = { {500,560}, {640,480}, {680,530},{740,580},{800,580},{820,580},{880,480},{900,480},{860,380},{900,380},{860,280},{880,280},{880,180},{640,230},{660,230},{680,230},
			{280,460},{320,460}, {120,340},{80,340}
	//This array determines the position of the spikes. {x coordinate, y coordinate}
	
	};
	
	public Board(){
		
		setBackground(Color.white);
		setFocusable(true);
		setDoubleBuffered(true);
		ingame = true;
		addKeyListener(new Adapter());
		player = new PlayerFigure();
		goal = new Goal (20, 340);
		initBlocksAndSpikes();
		timer = new Timer(10, this);
		timer.start();

	}
	
	public void initBlocksAndSpikes(){
		blocks = new ArrayList();
		for (int i = 0; i < pos.length; i++){
			for (int j= pos[i][0]; j < pos[i][0]+pos[i][2]*20; j+=20){
				blocks.add(new Block(j,pos[i][1]));
				}
		}
		spikes = new ArrayList();
		for (int i = 0; i < possp.length; i++){
			spikes.add(new Spike(possp[i][0],possp[i][1]));
				}
		}
	//this function creates an array list for the blocks and one for the spikes and creates spikes and blocks as describe above.
	
	
	
	

	
	public void paint(Graphics g){
		//paints all the different objects and if ingame is false a message.
			 
			
		if (ingame){
			super.paint(g);
			 
			 Graphics2D g2d = (Graphics2D) g;
			 
			 g2d.drawImage(goal.getImage(), goal.getX(), goal.getY(), this);
			 
			 for (int i = 0; i < blocks.size(); i++){
				 Block b = (Block) blocks.get(i);
				 g2d.drawImage(b.getImage(),b.getX(),b.getY(),this);
			 }
			 
			 for (int i = 0; i < spikes.size(); i++){
				 Spike b = (Spike) spikes.get(i);
				 g2d.drawImage(b.getImage(),b.getX(),b.getY(),this);
			 }
			 
			 g2d.drawImage(player.getImage(),player.getX(),player.getY(), this);
			 
			 Toolkit.getDefaultToolkit().sync();
			 g.dispose();}
		
		else{
			String msg = "GAME OVER";
			String msgwin = "you won";
			String msgloose = "you lost";
            Font small = new Font("Helvetica", Font.BOLD, 50);

            g.setColor(Color.BLACK);
            g.setFont(small);
            g.drawString(msg, 200 ,250);
            if (result)
            	g.drawString(msgwin, 200, 350);
            else
            	g.drawString(msgloose, 200, 350);
		}
		

		 }
	
	public void actionPerformed(ActionEvent e){
		//These actions get repeated every time every x milliseconds. This specific amount of time is defined by the timer.

		 	player.move();
		 	ColisionCheck();
		 	repaint();
			
	}
	
	
	public void ColisionCheck(){
		//Checks for collisions
		Rectangle r1 = player.getFeets();
		for (int i=0; i < blocks.size(); i++){
			Block b = (Block) blocks.get(i);
			Rectangle r2 = b.getBuffer();
			
			if (r2.intersects(r1))
				player.Buffer(player.getY(),b.getY());
		}
		//if the figures feet enter the platforms buffer, the figures buffer() will be activated and make that the figure lands exactly at the right spot.
		
		for (int i=0; i < blocks.size(); i++){
			Block b = (Block) blocks.get(i);
			Rectangle r2 = b.getRail();
			
			if (r2.intersects(r1))
				player.StopFalling();
		}
		// The figures getFeets() and the platforms getRail() are both just one pixel high.
		// If getFeets() intersects getRail() it does not fall anymore. 
		
		r1 = player.getBounds();
		
		for (int i=0; i < spikes.size(); i++){
			Spike b = (Spike) spikes.get(i);
			Rectangle r2 = b.getBounds();
			
			if (r2.intersects(r1)){
				ingame=false;
				result=false;}
			
		}
		
		
		//Checks if player collides with any spike, player looses if thats the case
		
		
		
		Rectangle r2 = goal.getBounds();
		
		if (r2.intersects(r1)){
			ingame=false;
			result=true;}
		
		if (player.getY() > 800){
			ingame = false;
			result = false;}
		
		
		
		
		
				
	}
	//Checks if player collides with the goal, player wins if thats the case

	
	public class Adapter extends KeyAdapter{
	// local class that listens to key events.
		
		public void keyPressed(KeyEvent e){
			player.keyPressed(e);
		}
		public void keyReleased(KeyEvent e){
			player.keyReleased(e);
		}
	}

}
