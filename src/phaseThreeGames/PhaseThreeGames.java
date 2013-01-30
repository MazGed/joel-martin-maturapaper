package phaseThreeGames;

import javax.swing.*;

import menu.SuperPanel;


import java.awt.*;
import java.awt.event.*;


//The Frame in which the game takes place
public class PhaseThreeGames extends JFrame
{
	public static PhaseThreeGames frame;
	public PhaseThreeGames()
	{
      

		add(new SuperPanel());
		
		setUndecorated(true);
		setSize(1000, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("");
		setResizable(false);
		setVisible(true);


  }

  public static void main( String[] args ){
	  frame = new PhaseThreeGames();
	  

      
  }
}



