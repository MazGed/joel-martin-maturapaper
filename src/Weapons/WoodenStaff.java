package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class WoodenStaff extends Weapon{

	public WoodenStaff(GamePanel gp) {
		//The basic staff. Shoots a single missile which causes damage at impact.
		super(gp);
		name = "Apprentice Staff";
		description = "Click A to shoot a nice little ball of energy.";
		
		reloadTime = 5;
		manaCost = 15;
		
		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/WoodenStaff/WS1R.png";
		WeaponSource[1]= "/Pictures/Hero/WoodenStaff/WS2R.png";
		WeaponSource[2]= "/Pictures/Hero/WoodenStaff/WS3R.png";
		WeaponSource[3]= "/Pictures/Hero/WoodenStaff/WSFR.png";
		WeaponSource[4]= "/Pictures/Hero/WoodenStaff/WSShR.png";
		WeaponSource[5]= "/Pictures/Hero/WoodenStaff/WSStR.png";
		WeaponSource[6]= "/Pictures/Hero/WoodenStaff/WS1L.png";
		WeaponSource[7]= "/Pictures/Hero/WoodenStaff/WS2L.png";
		WeaponSource[8]= "/Pictures/Hero/WoodenStaff/WS3L.png";
		WeaponSource[9]= "/Pictures/Hero/WoodenStaff/WSFL.png";
		WeaponSource[10]= "/Pictures/Hero/WoodenStaff/WSShL.png";
		WeaponSource[11]= "/Pictures/Hero/WoodenStaff/WSStL.png";
		WeaponSource[12]= "/Pictures/Hero/WoodenStaff/WSIcon.png";
		
		StringToImage();
	}
	
	public void fire(){

		new WoodenStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);

	}

}