package phaseOneGameMartin;

import javax.swing.*;
import phaseOneGameMartin.Board;

public class phaseOneGame extends JFrame{ 
// This class creates and defines the window and adds a Board to it. It also runs the main-class
	
	public phaseOneGame(){
		
		add(new Board());
		
		
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jump and Fun");
		setResizable(false);
		setVisible(true);
		
	}
	
	public static void main(String[] args){
		new phaseOneGame();
	}

}
