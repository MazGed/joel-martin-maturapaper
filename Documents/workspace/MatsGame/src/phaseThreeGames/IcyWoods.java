package phaseThreeGames;

import javax.swing.ImageIcon;

public class IcyWoods extends Skinset{
	//Ice-landscape skinset
	
	public IcyWoods(){
		folder = "snowforest";
		defineImg();
		try{
			for (int i = 0; i < PlatformSource.length; i++){
				ImageIcon ii = new ImageIcon(this.getClass().getResource(PlatformSource[i]));
				PlatformSkin[i]=ii.getImage();}
			
			for (int i = 0; i < BlockSource.length; i++){
				ImageIcon ii = new ImageIcon(this.getClass().getResource(BlockSource[i]));
				BlockSkin[i]=ii.getImage();}
		}catch (NullPointerException e){
			
		}
	}

}
