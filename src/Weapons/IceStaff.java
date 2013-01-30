package Weapons;

import java.awt.Color;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class IceStaff extends Weapon{
	
	//Launches a single missile which freezes the hit enemy at impact.

	public IceStaff(GamePanel gp) {
		super(gp);
		manaCost = 30;
		reloadTime = 15;
		name = "Icy Marie";
		description = "Slows the enemy on impact and causes good damage.";
		
		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/ice/1R.png";
		WeaponSource[1]= "/Pictures/Hero/ice/2R.png";
		WeaponSource[2]= "/Pictures/Hero/ice/3R.png";
		WeaponSource[3]= "/Pictures/Hero/ice/FR.png";
		WeaponSource[4]= "/Pictures/Hero/ice/ShR.png";
		WeaponSource[5]= "/Pictures/Hero/ice/StR.png";
		WeaponSource[6]= "/Pictures/Hero/ice/1L.png";
		WeaponSource[7]= "/Pictures/Hero/ice/2L.png";
		WeaponSource[8]= "/Pictures/Hero/ice/3L.png";
		WeaponSource[9]= "/Pictures/Hero/ice/FL.png";
		WeaponSource[10]= "/Pictures/Hero/ice/ShL.png";
		WeaponSource[11]= "/Pictures/Hero/ice/StL.png";
		WeaponSource[12]= "/Pictures/Hero/ice/icon.png";
		
		StringToImage();
	}
	
	public void fire(){
		new IceStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);

	}

}