package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class ManavampStaff extends Weapon{
	
	//launches a magic missile which steals mana from the enemies.
	//The missile will travel a certain distance before returning to the player.

	public ManavampStaff(GamePanel gp) {
		super(gp);
		name = "Mana Vampire";
		description = "Casts a bat which steals mana from enemies and damages them.";
		manaCost = 100;
		reloadTime = 25;
		
		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/manavamp/1R.png";
		WeaponSource[1]= "/Pictures/Hero/manavamp/2R.png";
		WeaponSource[2]= "/Pictures/Hero/manavamp/3R.png";
		WeaponSource[3]= "/Pictures/Hero/manavamp/FR.png";
		WeaponSource[4]= "/Pictures/Hero/manavamp/ShR.png";
		WeaponSource[5]= "/Pictures/Hero/manavamp/StR.png";
		WeaponSource[6]= "/Pictures/Hero/manavamp/1L.png";
		WeaponSource[7]= "/Pictures/Hero/manavamp/2L.png";
		WeaponSource[8]= "/Pictures/Hero/manavamp/3L.png";
		WeaponSource[9]= "/Pictures/Hero/manavamp/FL.png";
		WeaponSource[10]= "/Pictures/Hero/manavamp/ShL.png";
		WeaponSource[11]= "/Pictures/Hero/manavamp/StL.png";
		WeaponSource[12]= "/Pictures/Hero/manavamp/icon.png";
		
		StringToImage();
	}
	
	public void fire(){

		new ManavampStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);

	}

}