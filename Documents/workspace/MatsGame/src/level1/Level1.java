package level1;

import Goals.Goal;
import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Level;

public class Level1 extends Level{

	public Level1(GamePanel gp) {
		super(gp);
		
		lore = "Welcome in the world of Guardian. Here you are a mighty guardian whose only task  " +
				"is to protect his woods from demonic creatures. Our story starts during a routine investigation " +
				"in the depths of the forest. Indeed one might notice a supicious amount of demons on this specific " +
				"day which is always a reason to be worried especially since our guardian didn't had to fight a real " +
				"threat for decades and his equipment might very well be described as poor. That's where you come into " +
				"play! Bring our guardian back in form by collecting equipment and fighting filthy demonses. Maybe there's " +
				"still time to prevent the next big demon war.";
		title="Tutorial";
		mission="Complete the tutorial by reaching the blue flag.";
		
		board = new Board[4];
		board[0] = new Board1(gp);
		board[1] = new Board2(gp);
		board[2] = new Board3(gp);
		board[3] = new Board4(gp);
		goal = new Goal(gp);
	}

}
