package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class GrenadeStaff extends Weapon{
	
	//This staff launches a grenade which explodes and releases ExplosionDebris which
	//make Area damage to enemies and the player


	public GrenadeStaff(GamePanel gp) {
		super(gp);
		manaCost = 50;
		reloadTime = 25;
		name = "GRENADINATOR 780";
		description = "BOOM BOOM BABY! But don't get yourself blasted away.";

		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/grenade/1R.png";
		WeaponSource[1]= "/Pictures/Hero/grenade/2R.png";
		WeaponSource[2]= "/Pictures/Hero/grenade/3R.png";
		WeaponSource[3]= "/Pictures/Hero/grenade/FR.png";
		WeaponSource[4]= "/Pictures/Hero/grenade/ShR.png";
		WeaponSource[5]= "/Pictures/Hero/grenade/StR.png";
		WeaponSource[6]= "/Pictures/Hero/grenade/1L.png";
		WeaponSource[7]= "/Pictures/Hero/grenade/2L.png";
		WeaponSource[8]= "/Pictures/Hero/grenade/3L.png";
		WeaponSource[9]= "/Pictures/Hero/grenade/FL.png";
		WeaponSource[10]= "/Pictures/Hero/grenade/ShL.png";
		WeaponSource[11]= "/Pictures/Hero/grenade/StL.png";
		WeaponSource[12]= "/Pictures/Hero/grenade/icon.png";
		
		StringToImage();
	}
	
	public void fire(){

			
		new GrenadeStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);

	}

}
