package Weapons;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;

public class Weapon implements Serializable{
	
	/*Abstract class for the weapons. Note that a weapon isn't contained by a board but by a GamePanel.
	 *The Weapon class basically only gives the hero the needed Image and allows him to use its 
	 *shoot() method.
	 * 
	 */
	
	public GamePanel gp;
	public int manaCost = 20, reloadTime = 15;
	public String[] WeaponSource;
	public Image[] imageCollection;
	//The String which are displayed whenever the player hovers over the weapons icon in the ui.
	public String name = "any Weapon";
	public String description = "really any weapon that hasn't been described by the lazy programmers";
	public Weapon(GamePanel gp){
		this.gp = gp;
		
		
	}
	
	public void fire(){
		//In the subclasses the missiles are created in this method
		
	}
	
	public void shoot(){
		//This methods triggers fire() and decreases the player's mana in function the weapons mana cost
		//It also activates the reload time
		if(gp.board.p.mana >=manaCost){
			fire();
			gp.board.p.mana -=manaCost;
			gp.board.p.reloading = reloadTime;
		}
	}
	
	public void StringToImage(){
		//same as in the Sprite class
		imageCollection = new Image[WeaponSource.length];
		for (int i = 0; i < WeaponSource.length; i++){
			ImageIcon ii = new ImageIcon(this.getClass().getResource(WeaponSource[i]));
			imageCollection[i]=ii.getImage();}
	}
	
	

}
