package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class ScatterStaff extends Weapon{

	public ScatterStaff(GamePanel gp) {
		//My favorite ShotGun. Causes area damage in front of the player.
		super(gp);
		name = "Astral Dragon";
		description = "Casts a purifying wave of fire.";
		manaCost = 100;
		reloadTime = 75;

		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/scatter/1R.png";
		WeaponSource[1]= "/Pictures/Hero/scatter/2R.png";
		WeaponSource[2]= "/Pictures/Hero/scatter/3R.png";
		WeaponSource[3]= "/Pictures/Hero/scatter/FR.png";
		WeaponSource[4]= "/Pictures/Hero/scatter/ShR.png";
		WeaponSource[5]= "/Pictures/Hero/scatter/StR.png";
		WeaponSource[6]= "/Pictures/Hero/scatter/1L.png";
		WeaponSource[7]= "/Pictures/Hero/scatter/2L.png";
		WeaponSource[8]= "/Pictures/Hero/scatter/3L.png";
		WeaponSource[9]= "/Pictures/Hero/scatter/FL.png";
		WeaponSource[10]= "/Pictures/Hero/scatter/ShL.png";
		WeaponSource[11]= "/Pictures/Hero/scatter/StL.png";
		WeaponSource[12]= "/Pictures/Hero/scatter/icon.png";
		
		StringToImage();
	}
	
	public void fire(){
		for (int i = 0; i < 50; i++){
			new ScatterStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);
				
		}
	}

}