package Goals;


import phaseThreeGames.GamePanel;
import variousSprites.CollectibleFlag;


public class CollectFlags extends Goal{

	private int a;

	public CollectFlags(GamePanel gp, int a) {
		super(gp);
		CollectibleFlag.flagsCollected = 0;
		this.a = a;
		instruction = "Collect" + (a-CollectibleFlag.flagsCollected) + "flags";
	}
	
	public void winCheck(){
		if (CollectibleFlag.flagsCollected == a){
			win();
		}
	}

}
