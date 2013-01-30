package Cloaks;

import phaseThreeGames.GamePanel;

public class GreenCloak extends Cloak{
	//Standard Cloak
	
	public GreenCloak(GamePanel gp){
		super(gp);
		name = "Apprentice Cloak";
		description = "A standard cloak providing the guardian a solid amount of durability.";
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/GreenCloak/GC1R.png";
		CloakSource[1]= "/Pictures/Hero/GreenCloak/GC2R.png";
		CloakSource[2]= "/Pictures/Hero/GreenCloak/GC3R.png";
		CloakSource[3]= "/Pictures/Hero/GreenCloak/GCFR.png";
		CloakSource[4]= "/Pictures/Hero/GreenCloak/GCShR.png";
		CloakSource[5]= "/Pictures/Hero/GreenCloak/GCStR.png";
		CloakSource[6]= "/Pictures/Hero/GreenCloak/GC1L.png";
		CloakSource[7]= "/Pictures/Hero/GreenCloak/GC2L.png";
		CloakSource[8]= "/Pictures/Hero/GreenCloak/GC3L.png";
		CloakSource[9]= "/Pictures/Hero/GreenCloak/GCFL.png";
		CloakSource[10]= "/Pictures/Hero/GreenCloak/GCShL.png";
		CloakSource[11]= "/Pictures/Hero/GreenCloak/GCStL.png";
		CloakSource[12]= "/Pictures/Hero/GreenCloak/GCIcon.png";
		
		StringToImage();
	}
	
	
	public void InitCloak(){
		super.InitCloak();
		gp.board.p.armor = 3;
	}
	
	

}
