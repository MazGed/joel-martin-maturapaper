package Cloaks;

import java.awt.event.KeyEvent;

import phaseThreeGames.GamePanel;

public class ExchangeCloak extends Cloak{
	//Allows the player to change mana to life by pressing "W"
	//Allows the player to change life to mana by pressing "Q"
	
	public ExchangeCloak(GamePanel gp){
		super(gp);
		name = "Energy Changing Cloak";
		description = "Click Q to change life to mana. Click W to change mana to life.";
		
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/exchange/1R.png";
		CloakSource[1]= "/Pictures/Hero/exchange/2R.png";
		CloakSource[2]= "/Pictures/Hero/exchange/3R.png";
		CloakSource[3]= "/Pictures/Hero/exchange/FR.png";
		CloakSource[4]= "/Pictures/Hero/exchange/ShR.png";
		CloakSource[5]= "/Pictures/Hero/exchange/StR.png";
		CloakSource[6]= "/Pictures/Hero/exchange/1L.png";
		CloakSource[7]= "/Pictures/Hero/exchange/2L.png";
		CloakSource[8]= "/Pictures/Hero/exchange/3L.png";
		CloakSource[9]= "/Pictures/Hero/exchange/FL.png";
		CloakSource[10]= "/Pictures/Hero/exchange/ShL.png";
		CloakSource[11]= "/Pictures/Hero/exchange/StL.png";
		CloakSource[12]= "/Pictures/Hero/exchange/icon.png";
		
		StringToImage();
	}
	
	
	public void CloakKeyEvent(int key){
		super.CloakKeyEvent(key);
		if (key == KeyEvent.VK_Q && gp.board.p.life > 0){
			gp.board.p.mana += 100;
			gp.board.p.life -= 10;
		}
		if (key == KeyEvent.VK_W && gp.board.p.mana > 99){
			gp.board.p.mana -= 100;
			gp.board.p.life += 10;
		}
	}

}
