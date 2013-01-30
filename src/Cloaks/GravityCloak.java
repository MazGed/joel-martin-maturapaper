package Cloaks;

import phaseThreeGames.GamePanel;

public class GravityCloak extends Cloak{
	//Lowers the players weight and makes him jump higher and longer
	
	public GravityCloak(GamePanel gp){
		super(gp);
		name = "Low Gravity Cloak";
		description = "The cloak's magical tissue reduces the guardian's weight.";
		
		maxLife = 50;
		maxMana = 1500;
		
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/gravity/1R.png";
		CloakSource[1]= "/Pictures/Hero/gravity/2R.png";
		CloakSource[2]= "/Pictures/Hero/gravity/3R.png";
		CloakSource[3]= "/Pictures/Hero/gravity/FR.png";
		CloakSource[4]= "/Pictures/Hero/gravity/ShR.png";
		CloakSource[5]= "/Pictures/Hero/gravity/StR.png";
		CloakSource[6]= "/Pictures/Hero/gravity/1L.png";
		CloakSource[7]= "/Pictures/Hero/gravity/2L.png";
		CloakSource[8]= "/Pictures/Hero/gravity/3L.png";
		CloakSource[9]= "/Pictures/Hero/gravity/FL.png";
		CloakSource[10]= "/Pictures/Hero/gravity/ShL.png";
		CloakSource[11]= "/Pictures/Hero/gravity/StL.png";
		CloakSource[12]= "/Pictures/Hero/gravity/icon.png";
		
		StringToImage();
	}
	
	public void InitCloak(){
		super.InitCloak();
		gp.board.p.yImp(-1,2);
		gp.board.p.featherLight = true;
	}

}
