package staticSprites;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;

public class IcyBlock extends Block{
	//Exactly like a normal block except for the lower gripp --> slippy block.
	
	public IcyBlock(int x, int y, Board parent){
		super(x,y,parent);
		friction = 4;
	}
	
	public void InitImage(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/etc/blocks/iceblock.png"));
		image[0]=ii.getImage();
	}

}
