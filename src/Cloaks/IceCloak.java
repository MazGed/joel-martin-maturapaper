package Cloaks;

import java.awt.event.KeyEvent;

import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;

public class IceCloak extends Cloak{
	public int counter;
	private int hardenShield;
	public IceCloak(GamePanel gp){
		/*Freezes enemies when the hero collides with them.
		 *Lowers the heros friction and makes him hard to control.
		 *Allows the player to temporarily rise the heroes armor massively.
		 */
		super(gp);
		
		name = "Ice Cloak";
		description = "Click Space to get high armor. Freezes enemies at contact. Carefull slippery cloak!";
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/icy/1R.png";
		CloakSource[1]= "/Pictures/Hero/icy/2R.png";
		CloakSource[2]= "/Pictures/Hero/icy/3R.png";
		CloakSource[3]= "/Pictures/Hero/icy/FR.png";
		CloakSource[4]= "/Pictures/Hero/icy/ShR.png";
		CloakSource[5]= "/Pictures/Hero/icy/StR.png";
		CloakSource[6]= "/Pictures/Hero/icy/1L.png";
		CloakSource[7]= "/Pictures/Hero/icy/2L.png";
		CloakSource[8]= "/Pictures/Hero/icy/3L.png";
		CloakSource[9]= "/Pictures/Hero/icy/FL.png";
		CloakSource[10]= "/Pictures/Hero/icy/ShL.png";
		CloakSource[11]= "/Pictures/Hero/icy/StL.png";
		CloakSource[12]= "/Pictures/Hero/icy/icon.png";
		
		StringToImage();
	}
	
	public void InitCloak(){
		super.InitCloak();
		gp.board.p.friction = 4;
		
		gp.board.p.armor = 5;
		
		if (hardenShield>0){
			hardenShield--;
			gp.board.p.armor = 40;
		}
		
		
		
	}
	
	public void CloakKeyEvent(int key){
		super.CloakKeyEvent(key);
		if (key == KeyEvent.VK_SPACE && gp.board.p.mana > 49){
			hardenShield = 100;
			gp.board.p.mana-= 50;
		}
	}
	
	public void CloakCollision(String s1, Sprite s){
		if (s1 == "Enemy"){
			s.Freezed = 100;
		}
	}

}
