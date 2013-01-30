package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class PurpleStaff extends Weapon{

	public PurpleStaff(GamePanel gp) {
		super(gp);
		//Casts a wave of missile which will slow down the enemies at impact.
		
		manaCost = 50;
		reloadTime = 20;
		
		name = "Ancestor's Poison";
		description = "Casts a wave of poisoning missiles.";

		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/PStaff/PS1R.png";
		WeaponSource[1]= "/Pictures/Hero/PStaff/PS2R.png";
		WeaponSource[2]= "/Pictures/Hero/PStaff/PS3R.png";
		WeaponSource[3]= "/Pictures/Hero/PStaff/PSFR.png";
		WeaponSource[4]= "/Pictures/Hero/PStaff/PSShR.png";
		WeaponSource[5]= "/Pictures/Hero/PStaff/PSStR.png";
		WeaponSource[6]= "/Pictures/Hero/PStaff/PS1L.png";
		WeaponSource[7]= "/Pictures/Hero/PStaff/PS2L.png";
		WeaponSource[8]= "/Pictures/Hero/PStaff/PS3L.png";
		WeaponSource[9]= "/Pictures/Hero/PStaff/PSFL.png";
		WeaponSource[10]= "/Pictures/Hero/PStaff/PSShL.png";
		WeaponSource[11]= "/Pictures/Hero/PStaff/PSStL.png";
		WeaponSource[12]= "/Pictures/Hero/PStaff/PSIcon.png";
		
		StringToImage();
	}
	
	public void fire(){
		for (int i = 0; i < 10; i++){
			new PurpleStaffMissile(gp.board.p.x + gp.board.p.width/2+i*5, gp.board.p.y + gp.board.p.height/2-i*5, gp.board);
				
		}
			
	}

}
