package Cloaks;

import java.awt.event.KeyEvent;

import phaseThreeGames.GamePanel;

public class TinyCloak extends Cloak{
	
	public TinyCloak(GamePanel gp){
		//makes the hero smaller
		super(gp);
		maxLife = 50;
		maxMana = 500;
		
		name = "Tiny Cloak";
		description = "Makes the guardian really tiny.";
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/tiny/1R.png";
		CloakSource[1]= "/Pictures/Hero/tiny/2R.png";
		CloakSource[2]= "/Pictures/Hero/tiny/3R.png";
		CloakSource[3]= "/Pictures/Hero/tiny/FR.png";
		CloakSource[4]= "/Pictures/Hero/tiny/ShR.png";
		CloakSource[5]= "/Pictures/Hero/tiny/StR.png";
		CloakSource[6]= "/Pictures/Hero/tiny/1L.png";
		CloakSource[7]= "/Pictures/Hero/tiny/2L.png";
		CloakSource[8]= "/Pictures/Hero/tiny/3L.png";
		CloakSource[9]= "/Pictures/Hero/tiny/FL.png";
		CloakSource[10]= "/Pictures/Hero/tiny/ShL.png";
		CloakSource[11]= "/Pictures/Hero/tiny/StL.png";
		CloakSource[12]= "/Pictures/Hero/tiny/icon.png";
		
		StringToImage();
	}
	
	public void InitCloak(){
		super.InitCloak();
		gp.board.p.width = 20;
		gp.board.p.height = 30;
		gp.board.p.ycorrect = 10;
		
		if (gp.board.p.lookingLeft){
			gp.board.p.xNcorrect = 23;
			gp.board.p.xPcorrect = 8;
		}
		else{
			gp.board.p.xNcorrect = 8;
			gp.board.p.xPcorrect = 23;
		}
	}
	
	public void CloakKeyEvent(int key){
		if (key == KeyEvent.VK_RIGHT){
			gp.board.p.xNcorrect = 8;
			gp.board.p.xPcorrect = 23;
		}
		if (key == KeyEvent.VK_LEFT){
			gp.board.p.xNcorrect = 23;
			gp.board.p.xPcorrect = 8;
		}
	}

}
