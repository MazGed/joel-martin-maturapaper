package Cloaks;

import java.awt.event.KeyEvent;

import Weapons.ExplosionDebris;

import phaseThreeGames.GamePanel;

public class MagmaCloak extends Cloak{
	public int counter;
	public MagmaCloak(GamePanel gp){
		//Allows the player to cast a wave of dangerous debris by clicking space
		super(gp);
		
		maxLife = 75;
		maxMana = 1250;
		name = "Iruption Cloak";
		description = "Click Space to cast a devastating wave of magma.";
		CloakSource = new String[13];
		CloakSource[0]= "/Pictures/Hero/magma/1R.png";
		CloakSource[1]= "/Pictures/Hero/magma/2R.png";
		CloakSource[2]= "/Pictures/Hero/magma/3R.png";
		CloakSource[3]= "/Pictures/Hero/magma/FR.png";
		CloakSource[4]= "/Pictures/Hero/magma/ShR.png";
		CloakSource[5]= "/Pictures/Hero/magma/StR.png";
		CloakSource[6]= "/Pictures/Hero/magma/1L.png";
		CloakSource[7]= "/Pictures/Hero/magma/2L.png";
		CloakSource[8]= "/Pictures/Hero/magma/3L.png";
		CloakSource[9]= "/Pictures/Hero/magma/FL.png";
		CloakSource[10]= "/Pictures/Hero/magma/ShL.png";
		CloakSource[11]= "/Pictures/Hero/magma/StL.png";
		CloakSource[12]= "/Pictures/Hero/magma/icon.png";
		
		StringToImage();
	}
	
	public void InitCloak(){
		super.InitCloak();
		
		gp.board.p.armor = 3;
		
		
		
	}
	
	public void CloakKeyEvent(int key){
		super.CloakKeyEvent(key);
		if (key == KeyEvent.VK_SPACE&& gp.board.p.mana > 50){
			for (int i = 0; i<150 ; i++){
				new MagmaDebris(gp.board.p.x+gp.board.p.width/2, gp.board.p.y+gp.board.p.height/2, gp.board);
				
			}
			gp.board.p.mana -= 100;
		}
		
	}

}
