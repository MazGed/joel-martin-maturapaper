package Cloaks;

import phaseThreeGames.GamePanel;

public class ManaCloak extends Cloak{
	public int counter;
	public ManaCloak(GamePanel gp){
		//Gives the hero more mana and better mana regeneration.
		super(gp);
		maxMana = 2000;
		name = "Mana Cloak";
		description = "Gives the guardian a lot of mana and a fast mana regeneration.";
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/mana/1R.png";
		CloakSource[1]= "/Pictures/Hero/mana/2R.png";
		CloakSource[2]= "/Pictures/Hero/mana/3R.png";
		CloakSource[3]= "/Pictures/Hero/mana/FR.png";
		CloakSource[4]= "/Pictures/Hero/mana/ShR.png";
		CloakSource[5]= "/Pictures/Hero/mana/StR.png";
		CloakSource[6]= "/Pictures/Hero/mana/1L.png";
		CloakSource[7]= "/Pictures/Hero/mana/2L.png";
		CloakSource[8]= "/Pictures/Hero/mana/3L.png";
		CloakSource[9]= "/Pictures/Hero/mana/FL.png";
		CloakSource[10]= "/Pictures/Hero/mana/ShL.png";
		CloakSource[11]= "/Pictures/Hero/mana/StL.png";
		CloakSource[12]= "/Pictures/Hero/mana/icon.png";
		
		
		StringToImage();
	}
	
	public void InitCloak(){
		super.InitCloak();
		counter++;
		if (counter == 100){
			gp.board.p.mana += 100;
			counter = 0;
		}
		
		
	}

}
