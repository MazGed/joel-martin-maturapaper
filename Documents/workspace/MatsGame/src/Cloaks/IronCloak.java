package Cloaks;

import phaseThreeGames.GamePanel;

public class IronCloak extends Cloak{
	
	//Gives the Hero high life and armor but makes him slow and heavy
	
	public IronCloak(GamePanel gp){
		super(gp);
		name = "Iron Cloak";
		description = "This cloak gives the guardian a strong armor and a lot of life. Carefull heavy Cloak.";
		maxLife = 250;
		maxMana = 1000;
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/iron/1R.png";
		CloakSource[1]= "/Pictures/Hero/iron/2R.png";
		CloakSource[2]= "/Pictures/Hero/iron/3R.png";
		CloakSource[3]= "/Pictures/Hero/iron/FR.png";
		CloakSource[4]= "/Pictures/Hero/iron/ShR.png";
		CloakSource[5]= "/Pictures/Hero/iron/StR.png";
		CloakSource[6]= "/Pictures/Hero/iron/1L.png";
		CloakSource[7]= "/Pictures/Hero/iron/2L.png";
		CloakSource[8]= "/Pictures/Hero/iron/3L.png";
		CloakSource[9]= "/Pictures/Hero/iron/FL.png";
		CloakSource[10]= "/Pictures/Hero/iron/ShL.png";
		CloakSource[11]= "/Pictures/Hero/iron/StL.png";
		CloakSource[12]= "/Pictures/Hero/iron/icon.png";
		
		StringToImage();
	}
	
	public void InitCloak(){
		super.InitCloak();
		gp.board.p.armor = 10;
		gp.board.p.Slowed = 1;
	}
	
	

}
