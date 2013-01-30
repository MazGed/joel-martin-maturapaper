package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class MineStaff extends Weapon{

	public MineStaff(GamePanel gp) {
		
		//launches a mine which will explode if the hero or an enemy touches it.
		//causes area damage to enemies and the player.
		super(gp);
		name = "MineFieldCreator 5000";
		description = "Creates a mine which causes big area damage and friendly fire.";
		
		manaCost = 75;
		reloadTime = 50;

		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/mine/1R.png";
		WeaponSource[1]= "/Pictures/Hero/mine/2R.png";
		WeaponSource[2]= "/Pictures/Hero/mine/3R.png";
		WeaponSource[3]= "/Pictures/Hero/mine/FR.png";
		WeaponSource[4]= "/Pictures/Hero/mine/ShR.png";
		WeaponSource[5]= "/Pictures/Hero/mine/StR.png";
		WeaponSource[6]= "/Pictures/Hero/mine/1L.png";
		WeaponSource[7]= "/Pictures/Hero/mine/2L.png";
		WeaponSource[8]= "/Pictures/Hero/mine/3L.png";
		WeaponSource[9]= "/Pictures/Hero/mine/FL.png";
		WeaponSource[10]= "/Pictures/Hero/mine/ShL.png";
		WeaponSource[11]= "/Pictures/Hero/mine/StL.png";
		WeaponSource[12]= "/Pictures/Hero/mine/icon.png";
		
		StringToImage();
	}
	
	public void fire(){
			
			new MineStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);

	}

}