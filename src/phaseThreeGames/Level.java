package phaseThreeGames;

import Goals.Goal;
//very basic class which contains only a Board Array and a Goal
//The class is coordinated by the GamePanel
public class Level {
	
	//These strings are displayed inside the pausing screen.
	public String lore = "once in a while you gotta do what you gotta do my friend. never seen the daylight in my cave." +
			"Killing was the only. I'm sooooooorry for your loss. But life goes on within or without you." +
			" Charade you are. You abused that girl. You Pig. You should be in a cage. I hate people with mustaches.";
	public String title="Nothing in my brain";
	public String mission="i want you, i want you so baaaaad babe, iwant youououououou, i want you so bahahad babe";
	
	public Board[] board;
	public Goals.Goal goal;
	public GamePanel gp;
	
	public Level(GamePanel gp){
		this.gp = gp;
		board = new Board[2];
		goal = new Goal(gp);
	}
	
	

}
