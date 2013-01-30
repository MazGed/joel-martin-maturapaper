package phaseThreeGames;

import java.awt.Image;

import javax.swing.ImageIcon;



//The skinset class contains 16 images for blocks and 4 images for platforms
//It is contained in the block and makes it possible to change a boards atmosphere completely.

public class Skinset {
	public Image[] PlatformSkin = new Image[4];
	public Image[] BlockSkin = new Image[16];
	public String[] PlatformSource = new String[4];
	public String[] BlockSource = new String[16];
	String folder = "DarkWoodSkinset";
	
	
	public Skinset(){
		
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
	
	public void defineImg(){
		//generates the right paths for the skinset images.
		PlatformSource[0]= "/Pictures/"+folder+"/11.png";
		PlatformSource[1]= "/Pictures/"+folder+"/00.png";
		PlatformSource[3]= "/Pictures/"+folder+"/01.png";
		PlatformSource[2]= "/Pictures/"+folder+"/10.png";
		BlockSource[0]= "/Pictures/"+folder+"/0000.png";
		BlockSource[1]= "/Pictures/"+folder+"/0001.png";
		BlockSource[2]= "/Pictures/"+folder+"/1000.png";
		BlockSource[3]= "/Pictures/"+folder+"/0100.png";
		BlockSource[4]= "/Pictures/"+folder+"/0010.png";
		BlockSource[5]= "/Pictures/"+folder+"/1001.png";
		BlockSource[6]= "/Pictures/"+folder+"/1100.png";
		BlockSource[7]= "/Pictures/"+folder+"/0110.png";
		BlockSource[8]= "/Pictures/"+folder+"/0011.png";
		BlockSource[9]= "/Pictures/"+folder+"/1011.png";
		BlockSource[10]= "/Pictures/"+folder+"/1110.png";
		BlockSource[11]= "/Pictures/"+folder+"/0111.png";
		BlockSource[12]= "/Pictures/"+folder+"/1101.png";
		BlockSource[13]= "/Pictures/"+folder+"/1111.png";
		BlockSource[14]= "/Pictures/"+folder+"/1010.png";
		BlockSource[15]= "/Pictures/"+folder+"/0101.png";

	}
}

