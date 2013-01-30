package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class HookStaff extends Weapon{
	
	//This staff launches a single projectile which pulls the hit enemy towards the hero at impact

	public HookStaff(GamePanel gp) {
		super(gp);
		name = "Shoot'n'Hook";
		description = "Haha, you're not getting away.";
		manaCost = 15;
		reloadTime = 10;
		
		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/hook/1R.png";
		WeaponSource[1]= "/Pictures/Hero/hook/2R.png";
		WeaponSource[2]= "/Pictures/Hero/hook/3R.png";
		WeaponSource[3]= "/Pictures/Hero/hook/FR.png";
		WeaponSource[4]= "/Pictures/Hero/hook/ShR.png";
		WeaponSource[5]= "/Pictures/Hero/hook/StR.png";
		WeaponSource[6]= "/Pictures/Hero/hook/1L.png";
		WeaponSource[7]= "/Pictures/Hero/hook/2L.png";
		WeaponSource[8]= "/Pictures/Hero/hook/3L.png";
		WeaponSource[9]= "/Pictures/Hero/hook/FL.png";
		WeaponSource[10]= "/Pictures/Hero/hook/ShL.png";
		WeaponSource[11]= "/Pictures/Hero/hook/StL.png";
		WeaponSource[12]= "/Pictures/Hero/hook/icon.png";
		
		StringToImage();
	}
	
	public void fire(){

		new HookStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);

	}

}