package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class PushStaff extends Weapon{

	public PushStaff(GamePanel gp) {
		
		//launches a single missile which will push enemies back.
		super(gp);
		name = "Fisty Fist";
		description = "Pushes the dirty demons out of sight.";
		reloadTime = 8;
		manaCost = 40;
		
		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/push/1R.png";
		WeaponSource[1]= "/Pictures/Hero/push/2R.png";
		WeaponSource[2]= "/Pictures/Hero/push/3R.png";
		WeaponSource[3]= "/Pictures/Hero/push/FR.png";
		WeaponSource[4]= "/Pictures/Hero/push/ShR.png";
		WeaponSource[5]= "/Pictures/Hero/push/StR.png";
		WeaponSource[6]= "/Pictures/Hero/push/1L.png";
		WeaponSource[7]= "/Pictures/Hero/push/2L.png";
		WeaponSource[8]= "/Pictures/Hero/push/3L.png";
		WeaponSource[9]= "/Pictures/Hero/push/FL.png";
		WeaponSource[10]= "/Pictures/Hero/push/ShL.png";
		WeaponSource[11]= "/Pictures/Hero/push/StL.png";
		WeaponSource[12]= "/Pictures/Hero/push/icon.png";
		
		StringToImage();
	}
	
	public void fire(){
		new PushStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);

	}

}