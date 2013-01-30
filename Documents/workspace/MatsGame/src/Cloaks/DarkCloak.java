package Cloaks;

import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;

public class DarkCloak extends Cloak{
	public int counter;
	public DarkCloak(GamePanel gp){
		
		/*Average Cloak with a strong ability: Enemies at a certain range get Slowed automatically
		 *Can only be found in the dark woods
		 */
		super(gp);
		name = "Poisonous Cloak";
		description = "Slows all the nearby enemies.";
		
		maxLife = 75;
		maxMana = 1250;
		
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/DarkCloak/DC1R.png";
		CloakSource[1]= "/Pictures/Hero/DarkCloak/DC2R.png";
		CloakSource[2]= "/Pictures/Hero/DarkCloak/DC3R.png";
		CloakSource[3]= "/Pictures/Hero/DarkCloak/DCFR.png";
		CloakSource[4]= "/Pictures/Hero/DarkCloak/DCShR.png";
		CloakSource[5]= "/Pictures/Hero/DarkCloak/DCStR.png";
		CloakSource[6]= "/Pictures/Hero/DarkCloak/DC1L.png";
		CloakSource[7]= "/Pictures/Hero/DarkCloak/DC2L.png";
		CloakSource[8]= "/Pictures/Hero/DarkCloak/DC3L.png";
		CloakSource[9]= "/Pictures/Hero/DarkCloak/DCFL.png";
		CloakSource[10]= "/Pictures/Hero/DarkCloak/DCShL.png";
		CloakSource[11]= "/Pictures/Hero/DarkCloak/DCStL.png";
		CloakSource[12]= "/Pictures/Hero/DarkCloak/DCIcon.png";
		
		StringToImage();
	}
	
	public void InitCloak(){
		super.InitCloak();
		
		gp.board.p.armor = 2;
		
		for (int i = 0; i < gp.board.movingSprites.size(); i++){
			Sprite s = gp.board.movingSprites.get(i);
			if (s.spriteString == "Enemy" && s.x > gp.board.p.x-300 && s.x < gp.board.p.x+300){
				s.Slowed = 50;
			}
			
		}
		
		
		
	}

}
