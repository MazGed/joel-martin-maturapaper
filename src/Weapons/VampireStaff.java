package Weapons;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class VampireStaff extends Weapon{

	public VampireStaff(GamePanel gp) {
		super(gp);
		reloadTime = 7;
		manaCost = 10;
		//Launches a bat which steals life from the enemies.
		//The bat will travel a certain distance before returning to the player.
		name = "Dracula's Swag";
		description = "Casts a bat which causes lifesteal damage to enemies.";
		
		WeaponSource = new String[13];
		WeaponSource[0]= "/Pictures/Hero/vampire/1R.png";
		WeaponSource[1]= "/Pictures/Hero/vampire/2R.png";
		WeaponSource[2]= "/Pictures/Hero/vampire/3R.png";
		WeaponSource[3]= "/Pictures/Hero/vampire/FR.png";
		WeaponSource[4]= "/Pictures/Hero/vampire/ShR.png";
		WeaponSource[5]= "/Pictures/Hero/vampire/StR.png";
		WeaponSource[6]= "/Pictures/Hero/vampire/1L.png";
		WeaponSource[7]= "/Pictures/Hero/vampire/2L.png";
		WeaponSource[8]= "/Pictures/Hero/vampire/3L.png";
		WeaponSource[9]= "/Pictures/Hero/vampire/FL.png";
		WeaponSource[10]= "/Pictures/Hero/vampire/ShL.png";
		WeaponSource[11]= "/Pictures/Hero/vampire/StL.png";
		WeaponSource[12]= "/Pictures/Hero/vampire/icon.png";
		
		StringToImage();
	}
	
	public void fire(){
		new VampireStaffMissile(gp.board.p.x + gp.board.p.width/2, gp.board.p.y + gp.board.p.height/2, gp.board);
	}

}