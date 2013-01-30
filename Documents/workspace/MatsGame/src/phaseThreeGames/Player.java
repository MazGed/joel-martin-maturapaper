package phaseThreeGames;

import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;

import variousSprites.DeathSprite;

import Cloaks.*;
import Weapons.*;

public class Player extends Sprite{
	/*This is the class for the main character, the sprite the player controls.
	 *There's an instance of this class on every board, but there's isn't any 
	 *noticeable difference between two different instances.
	 */
	public boolean up, left, right,down, lookingLeft, firstCircle=true;
	//up, left, right and down are boolean tracking whether an arrow key is pressed.
	public int JumpImp, SpeedLimit, maxMana, mana, manaRegen, shooting, Jumpcounter, reloading; 
	public static double lPercentage=1;
	public static double mPercentage=1;
	public Weapon w = GamePanel.carriedWeapons[GamePanel.wIndex[3]];
	public Cloak c= GamePanel.carriedCloaks[GamePanel.cIndex[3]];
	public Cloak previousCloak = c;
	
	public Player(int x, int y, Board parent){
		super(x,y,parent, true);
		spriteString = "Player";
		width = 40; height = 61;
		xPcorrect = 45; xNcorrect = 19;
		ycorrect = 15;
		acc=1;
		maxMana = c.maxMana;
		mana = maxMana;
		maxLife = c.maxLife;
		life = maxLife;
		manaRegen = 5;
		SpeedLimit= 6;
		maxSpeed = SpeedLimit;
		JumpImp = 25;
		lookingLeft = false;
		image = new Image[2];
		deathAnim= true;
		
		
		
		

	}
	
	public void Init(){
		//Changes the cloak and the weapon the player is wearing if wIndex[3] or cIndex[3] got changed.
		w = GamePanel.carriedWeapons[GamePanel.wIndex[3]];
		c = GamePanel.carriedCloaks[GamePanel.cIndex[3]];
		
		
		if(firstCircle){
			c.InitCloak();
			firstCircle =false;
		}
		
		
		if (previousCloak.getClass()==Cloaks.TinyCloak.class && previousCloak.getClass() != c.getClass()){
			
			
			
			boolean underBlock=false;
			for (int i = 0; i < parent.staticSprites.size(); i++){
				Sprite s = parent.staticSprites.get(i);
				if (s.x < x + width && s.x > x - s.width){
					if (s.y < y - s.height && s.y > y +height - 2*s.height -1 && s.spriteString == "Block"){
						c = previousCloak;
						underBlock = true;
					}
				}
				
			}
				
			if (!underBlock){
				y -= 30;
			}
			
		}
		
		
		
		//Regenerates mana
		if (mana<maxMana && counter == 60){
			mana+=manaRegen;
		}
		if (maxMana < mana){
			mana = maxMana;
		}
		mPercentage = (double)mana/(double)maxMana ;
		
		
		
		
		lPercentage = (double)life/(double)maxLife ;
		
		
		//This function changes some of the hero attributes depending on which cloak he carries.
		c.InitCloak();
		previousCloak = c;
		
		
		
		//accelerates to the left if left arrow is pressed and to the right if right arrow is pressed
		if (left){
			xImp(-acc, -maxSpeed, friction);
		}
		if (right){
			xImp(acc, maxSpeed, friction);
		}
		
		//If reloading or Jumpcounter aren't = 0 they are diminished by 1
		if (Jumpcounter>0)
			Jumpcounter--;
		
		if (reloading>0)
			reloading--;
		
		/*If the hero has its feet on the ground and the up arrow is pressed he will get a big impulse and jump 
		 *if he holds up he will get a small impulse every cycle ---> ability to fine tune a jump.
		 */
		if (up){
			if (FeetsOnTheGround){
				Jumpcounter = 10;
				yImp(-JumpImp+10, -30, 1);
				FeetsOnTheGround = false;
			}
			if (Jumpcounter>0){
				yImp(-1, -30, 1);
			}
		}
		
		super.Init();
		
		//checks whether the hero's feet are on the ground.
		FeetsOnTheGround = onGround();
		
		
	}
	
	
	public void keyPressed(KeyEvent e){
		//The keys the player can press
		int key = e.getKeyCode();	
		if (key == KeyEvent.VK_LEFT){//Hero walks to the left
			left=true;
			lookingLeft = true;
			
		}
		if (key == KeyEvent.VK_RIGHT){//Hero walks to the right
			lookingLeft = false;
			right=true;
		}
		if (key == KeyEvent.VK_UP){//Hero jumps
			up = true;
		}
		if (key == KeyEvent.VK_DOWN){//no function
			down = true;
		}
		if (key == KeyEvent.VK_CONTROL){//Hero Runs
			maxSpeed = SpeedLimit*2;
		}
		if (key == KeyEvent.VK_A && reloading == 0){//Hero shoots
			w.shoot();
			shooting = 10;
		}
		if (key == KeyEvent.VK_4){//Hero changes weapon to weapon 1
			GamePanel.wIndex[3]=0;
		}
		if (key == KeyEvent.VK_5){//Hero changes weapon to weapon 2
			GamePanel.wIndex[3]=1;
		}
		if (key == KeyEvent.VK_6){//Hero changes weapon to weapon 3
			GamePanel.wIndex[3]=2;

		}
		if (key == KeyEvent.VK_1){//Hero changes cloak to cloak 1
			GamePanel.cIndex[3]=0;
		}
		if (key == KeyEvent.VK_2){//Hero changes cloak to cloak 1
			GamePanel.cIndex[3]=1;
		}
		if (key == KeyEvent.VK_3){//Hero changes cloak to cloak 1
			GamePanel.cIndex[3]=2;

		}
		c.CloakKeyEvent(key);//KeyEvents defined by the worn cloak

		
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();	
		if (key == KeyEvent.VK_LEFT){//Hero stops walking left
			left=false;
		}
		if (key == KeyEvent.VK_RIGHT){//Hero stops walking right
			
			right=false;
		}
		if (key == KeyEvent.VK_UP){
			up = false;
		}
		if (key == KeyEvent.VK_DOWN){
			down = false;
		}
		if (key == KeyEvent.VK_CONTROL){//Hero stops running
			maxSpeed = SpeedLimit;
		}

	}
	

	public void Collision(String s1, Sprite s){
		c.CloakCollision(s1, s);
		

		
	}
	

	public void CloackSourceToImage(){
		//Transforms the cloaks image-sources into images
		imageCollection = new Image[c.CloakSource.length];
		for (int i = 0; i < c.CloakSource.length; i++){
			ImageIcon ii = new ImageIcon(this.getClass().getResource(c.CloakSource[i]));
			imageCollection[i]=ii.getImage();}
	}
	
	public boolean onGround(){
		
		//Checks whether the player touches he the ground with his feet 
		boolean onGround = false;
		boolean block = false;
		Sprite s;
		for (int i = 0; i < parent.staticSprites.size(); i++){
			s = parent.staticSprites.get(i);
			if (s.y == y+height && s.x > x-s.width && s.x <x+width){
				onGround = true;
				if (s.spriteString == "tag"){
					onGround = false;
				}
				if (yImp == -1){
					block = true;
				}
				
				
				
			}
			
			
			
			if (s.y  == y+height+1 && s.x > x-s.width && s.x <x+width){
				onGround = true;
				block = true;
				
			}
			
			
			
		}
		
		if (yImp != 0 && elasticity == 0 && !block){
			onGround = false;
			
			
		}
		
			
		return onGround;
	}
	
	public void findImage(){
		//searches the right images for the right moment
		if (lookingLeft){
			if (xImp != 0 && left) {
				if (counter <15 ){
					image[0] = c.imageCollection[6];
					image[1] = w.imageCollection[6];
				}
				if (counter> 15 && counter < 30 || counter > 45){
					image[0] = c.imageCollection[7];
					image[1] = w.imageCollection[7];
				}		
				if (counter > 30 && counter <45){
					image[0] = c.imageCollection[8];
					image[1] = w.imageCollection[8];
				}
				
					
			}else{
				image[0] = c.imageCollection[11];
				image[1] = w.imageCollection[11];
			}
			if (FeetsOnTheGround == false ){
				image[0] = c.imageCollection[9];
				image[1] = w.imageCollection[9];
			}
			if (shooting > 0){
				image[0] = c.imageCollection[10];
				image[1] = w.imageCollection[10];
				shooting -= 1;
			}
		}
		
		else{
			if (xImp != 0 && right){
				if (counter <15 ){
					image[0] = c.imageCollection[0];
					image[1] = w.imageCollection[0];
				}
				if (counter> 15 && counter < 30 || counter > 45){
					image[0] = c.imageCollection[1];
					image[1] = w.imageCollection[1];
				}		
				if (counter > 30 && counter <45){
					image[0] = c.imageCollection[2];
					image[1] = w.imageCollection[2];
				}
				
					
			}else{
				image[0] = c.imageCollection[5];
				image[1] = w.imageCollection[5];
			}
			if (FeetsOnTheGround == false){
				image[0] = c.imageCollection[3];
				image[1] = w.imageCollection[3];
			}
			if (shooting > 0){
				image[0] = c.imageCollection[4];
				image[1] = w.imageCollection[4];
				shooting -= 1;
			}
		}
		
		if (invincible > 0 && counter/4%2 == 0){
			image[0] = null;
			image[1] = null;
		}

		
	}
	
public void death(){
	//When the player dies there's 6 times more blood explosion!!!
		
		super.death();
		super.death();
		super.death();
		super.death();
		super.death();
		super.death();
		
		if (parent.getClass() == phaseThreeGames.HolySanctuary.class){
			parent.p = new Player(x,y,parent);
		}
		
		
	}
	


}
