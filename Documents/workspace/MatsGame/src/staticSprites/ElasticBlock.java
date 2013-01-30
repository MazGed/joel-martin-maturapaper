package staticSprites;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;

public class ElasticBlock extends Block{
	/*Exactly like a normal block exept for the x- and yBehaviour
	 *It multiplies the impulse of the colliding sprite by -1
	 *and this way acts as a trampoline
	 */
	public ElasticBlock(int x, int y, Board parent){
		super(x,y,parent);
		spriteString = "Block";
		
		
	}
	
	public void InitImage(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/Pictures/etc/blocks/elastic.png"));
		image[0]=ii.getImage();
	}
	
	
	public void yBlockBehaviour(){
		
		
		
		
		s.yImp(s.yImp*2*(-1), 1);
		if (s.x <= x-s.height){
			s.FeetsOnTheGround = true;
		}
		
		
		
		
	}
	
	public void xBlockBehaviour(){
		s.xImp(s.xImp*2*(-1),1);
	}
	
	
	
	

}
