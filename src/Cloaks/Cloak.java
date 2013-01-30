package Cloaks;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Player;
import phaseThreeGames.Sprite;

public class Cloak implements Serializable{
	
	/*The abstract class for all the cloaks
	 * 
	 */
	
	public GamePanel gp;
	public int maxLife = 100;
	public int maxMana = 1000;
	//The two strings that show up when the player hovers the mouse over them in the GUI
	public String name = "any Cloak";
	public String description = "really any cloak that hasn't been described by the lazy programmers";
	//The cloak's image-sources
	public String[] CloakSource;
	public Image[] imageCollection;
	public Cloak(GamePanel gp){
		this.gp = gp;
		
		
		
		
	}
	
	
	
	public void InitCloak(){
		/*Init cloak is needed in the subclasses to change attributes of the hero.
		*In the InitCloak()-method of the superclass these attributes are set back to their normal value
		*so that the attributes are at standard value if the player changes its cloak
		*/
		
		
		
		gp.board.p.featherLight = false;
		gp.board.p.maxLife = maxLife;
		gp.board.p.maxMana = maxMana;
		gp.board.p.elasticity = 0;
		gp.board.p.armor = 0;
		gp.board.p.width = 40;
		gp.board.p.height = 61;
		gp.board.p.ycorrect = 19;
		if (gp.board.p.lookingLeft){
			gp.board.p.xNcorrect = 45;
			gp.board.p.xPcorrect = 15;
		}
		else{
			gp.board.p.xNcorrect = 15;
			gp.board.p.xPcorrect = 45;
		}
		
		gp.board.p.life = (int) (Player.lPercentage*maxLife);
		gp.board.p.mana = (int) (Player.mPercentage*maxMana);
		
		
		
	}
		
	public void CloakCollision(String s1, Sprite s){
		//Allows to add new collision events depending on the worn cloak
		
	}
	
	public void CloakKeyEvent(int key){
		//Allows to add new key events depending on the worn Cloak
		//xNcorrect and xPcorrect are changed in the CloakKeyEvent()-method because
		//the tiny cloak has smaller xNcorrect and xPcorrect
		if (key == KeyEvent.VK_RIGHT){
			gp.board.p.xNcorrect = 15;
			gp.board.p.xPcorrect = 45;
		}
		if (key == KeyEvent.VK_LEFT){
			gp.board.p.xNcorrect = 45;
			gp.board.p.xPcorrect = 15;
		}
	}
	
	public void StringToImage(){
		//same as Sprite
		imageCollection = new Image[CloakSource.length];
		for (int i = 0; i < CloakSource.length; i++){
			ImageIcon ii = new ImageIcon(this.getClass().getResource(CloakSource[i]));
			imageCollection[i]=ii.getImage();}
	}
	

	


}
