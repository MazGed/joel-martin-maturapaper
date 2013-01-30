package variousSprites;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;
import staticSprites.Block;



public class WeaponChanger extends Block{
	
	//A block which allows the player to change his carried weapons by jumping underneath it.
	// featured inside the holy sanctuary
	
	public int slot;
	public WeaponChanger(int x, int y, Board parent, int slot){
		super(x,y,parent);
		spriteString = "Block";
		this. slot = slot;

	}
	
	public void InitImage(){
		image[0] = GamePanel.carriedWeapons[slot].imageCollection[12];
	}

	public void Collision(String s1, Sprite s){
		super.Collision(s1, s);
		if (s1 == "Player" && s.y > y+height-1){
			
			parent.p.Jumpcounter = 0;
			GamePanel.wIndex[slot]++;
			if (GamePanel.wIndex[slot]<GamePanel.wInventory.size()){
				GamePanel.carriedWeapons[slot] = GamePanel.wInventory.get(GamePanel.wIndex[slot]);
			}else{
				GamePanel.wIndex[slot]=0;
				GamePanel.carriedWeapons[slot] = GamePanel.wInventory.get(GamePanel.wIndex[slot]);
			}
			if (GamePanel.wIndex[3] == slot){
				parent.p.w= GamePanel.carriedWeapons[slot];
			}
				
			
			image[0] = GamePanel.carriedWeapons[slot].imageCollection[12];
				
		}
		
	}
	
	
	

}
