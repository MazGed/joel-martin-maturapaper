package Cloaks;

import java.awt.event.KeyEvent;

import phaseThreeGames.GamePanel;

public class ParachuteCloak extends Cloak{
	public int parachute;
	public ParachuteCloak(GamePanel gp){
		//Slows the heros fall drastically temporarily when the player presses space
		super(gp);
		maxLife = 125;
		name = "Parachute Cloak";
		description = "Click Space stop the guardian from falling to fast.";
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/parachute/1R.png";
		CloakSource[1]= "/Pictures/Hero/parachute/2R.png";
		CloakSource[2]= "/Pictures/Hero/parachute/3R.png";
		CloakSource[3]= "/Pictures/Hero/parachute/FR.png";
		CloakSource[4]= "/Pictures/Hero/parachute/ShR.png";
		CloakSource[5]= "/Pictures/Hero/parachute/StR.png";
		CloakSource[6]= "/Pictures/Hero/parachute/1L.png";
		CloakSource[7]= "/Pictures/Hero/parachute/2L.png";
		CloakSource[8]= "/Pictures/Hero/parachute/3L.png";
		CloakSource[9]= "/Pictures/Hero/parachute/FL.png";
		CloakSource[10]= "/Pictures/Hero/parachute/ShL.png";
		CloakSource[11]= "/Pictures/Hero/parachute/StL.png";
		CloakSource[12]= "/Pictures/Hero/parachute/icon.png";
		
		
		StringToImage();
	}
	
	
	public void CloakKeyEvent(int key){
		super.CloakKeyEvent(key);
		if (key == KeyEvent.VK_SPACE){
			parachute = 100;
			
		}
	}
	public void InitCloak(){
		super.InitCloak();
		if (parachute > 0 && gp.board.p.yImp>0){
			gp.board.p.yImp=1;
			parachute -=1;
		}
		if (gp.board.p.FeetsOnTheGround == true){
			parachute = 0;
		}
		
		gp.board.p.armor = 3;
	}
	

}
