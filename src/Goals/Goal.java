package Goals;

import phaseThreeGames.GamePanel;
import variousSprites.Flag;

public class Goal{
	
	
	public String instruction = "Reach the blue flag!";
	
	
	GamePanel gp;
	public Goal(GamePanel gp){
		this.gp = gp;
		Flag.FlagReached = false;
	}
	
	
	public void winCheck(){
		if (Flag.FlagReached == true){
			win();
		}
	}
	
	public void looseCheck(){
		if (gp.board.deathCounter<=0){
			gp.pause(3);
			gp.sl.save();
		}
	}
	
	public void test(){
		winCheck();
		looseCheck();
	}
	
	public void win(){
		if (GamePanel.progress < gp.level){
			GamePanel.progress = gp.level;
		}
		gp.pause(2);
		gp.sl.save();
	}

}
