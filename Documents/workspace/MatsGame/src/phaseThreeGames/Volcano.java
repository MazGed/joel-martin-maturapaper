package phaseThreeGames;

import javax.swing.ImageIcon;

public class Volcano extends Skinset{

	//Skinset for a burned landscape.
	
	public Volcano(){
		folder = "volcano";
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
