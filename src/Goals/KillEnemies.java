package Goals;

import Enemies.Enemy;
import phaseThreeGames.GamePanel;
import variousSprites.Flag;

public class KillEnemies extends Goal{

	private int a;

	public KillEnemies(GamePanel gp, int a) {
		super(gp);
		Enemy.enemiesKilled = 0;
		this.a = a;
		instruction = "Kill" + (a-Enemy.enemiesKilled) + "enemies";
	}
	
	public void winCheck(){
		if (Enemy.enemiesKilled == a){
			win();
		}
	}

}
