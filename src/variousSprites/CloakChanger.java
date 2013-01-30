package variousSprites;

import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Sprite;
import staticSprites.Block;

public class CloakChanger extends Block{
	
	//A block which allows the player to change his carried cloaks by jumping underneath it.
	// featured inside the holy sanctuary
	
	public int slot;
	public CloakChanger(int x, int y, Board parent, int slot){
		super(x,y,parent);
		spriteString = "Block";
		this. slot = slot;

	}
	
	public void InitImage(){
		image[0] = GamePanel.carriedCloaks[slot].imageCollection[12];
	}

	public void Collision(String s1, Sprite s){
		super.Collision(s1, s);
		if (s1 == "Player" && s.y > y+height-1){
			
			parent.p.Jumpcounter = 0;
			GamePanel.cIndex[slot]++;
			if (GamePanel.cIndex[slot]<GamePanel.cInventory.size()){
				GamePanel.carriedCloaks[slot] = GamePanel.cInventory.get(GamePanel.cIndex[slot]);
			}else{
				GamePanel.cIndex[slot]=0;
				GamePanel.carriedCloaks[slot] = GamePanel.cInventory.get(GamePanel.cIndex[slot]);
			}
			if (GamePanel.cIndex[3] == slot){
				parent.p.c= GamePanel.carriedCloaks[slot];
			}
				
			
			image[0] = GamePanel.carriedCloaks[slot].imageCollection[12];
				
		}
		
	}
	
	
	

}
