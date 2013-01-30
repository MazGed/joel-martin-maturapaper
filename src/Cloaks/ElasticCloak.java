package Cloaks;

import phaseThreeGames.GamePanel;

public class ElasticCloak extends Cloak{
	/*Makes the player elastic and there for hard to control.
	 *Elastic Cloak allows the player to jump higher.
	 *Nonsense Cloak (Technically not very strong, but fun to play around with)
	 */
	
	public ElasticCloak(GamePanel gp){
		
		
		
		super(gp);
		maxLife = 150;
		maxMana = 1500;
		
		name = "Elastic Cloak";
		description = "Makes the guardian elastic. Kind of strange isn't it?";
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/elastic/1R.png";
		CloakSource[1]= "/Pictures/Hero/elastic/2R.png";
		CloakSource[2]= "/Pictures/Hero/elastic/3R.png";
		CloakSource[3]= "/Pictures/Hero/elastic/FR.png";
		CloakSource[4]= "/Pictures/Hero/elastic/ShR.png";
		CloakSource[5]= "/Pictures/Hero/elastic/StR.png";
		CloakSource[6]= "/Pictures/Hero/elastic/1L.png";
		CloakSource[7]= "/Pictures/Hero/elastic/2L.png";
		CloakSource[8]= "/Pictures/Hero/elastic/3L.png";
		CloakSource[9]= "/Pictures/Hero/elastic/FL.png";
		CloakSource[10]= "/Pictures/Hero/elastic/ShL.png";
		CloakSource[11]= "/Pictures/Hero/elastic/StL.png";
		CloakSource[12]= "/Pictures/Hero/elastic/icon.png";
		
		StringToImage();
	}
	
	public void InitCloak(){
		super.InitCloak();
		gp.board.p.elasticity = 2;
		gp.board.p.armor = 5;
	}
	
	

}
