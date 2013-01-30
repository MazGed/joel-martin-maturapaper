package Enemies;

import phaseThreeGames.Board;

public class EdgeWalkerMignon extends Mignon{
	//Copy of the mignon class implementing the turn if on edge method.
	//Use EdgeWalkerMignons if they are not spawned by millions and when it matters that they don't fall into spikes
	
	public EdgeWalkerMignon(int x, int y, Board parent, int direction) {
		super(x, y, parent, direction);
	}
	
	public void Init(){
		turnIfOnEdge();
		super.Init();
	}
		

}
