package phaseThreeGames;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import variousSprites.DeathSprite;

/*Sprite is the abstract class for all actors in the game. It extends the player, blocks, enemies and just anything that interacts with something else.
 *Sprites depend on the board which basically regulates their methods. Depending on whether the boolean moveable is set to true or false in the constructor
 *the sprite will be put in a different Sprite ArrayList in the board. These ArrayList are called staticSprites and movingSprites and are regulated
 *quite differently which leads the Sprite inside one of these Lists to behave quite differently from Sprites in the other List.
 * 
 */


public abstract class Sprite {
	
	public int x, y; // x and y coordinate of the Sprite
	public int dx, dy; //(used for movingSprites only)Delta x and y. Gets added to the x and y coordinate every cycle
	public int xImp, yImp; // (used for movingSprites only) the kinetic Energy of the Sprite. Directly influences Delta y and x
	public int acc, maxSpeed; // not directly used in the sprite class. used in sub classes to regulate acceleration and maximum Speed.
	public int friction = 3; /*(for movingSprites) A high friction means that the sprite cannot accelerate quickly
	 						   (for staticSprites) A high friction means that movingSprites standing on the Sprite cannot accelerate quickly*/
	public boolean moveable;// The boolean which determines in which ArrayList of the board a Sprite is going to be put.
	
	public int height = 60; // Height of the Sprites collision Rectangle
	public int width = 60;	// Width of the Sprites collision Rectangle
	
	public int maxLife=1, life = 1; // (for movingSprites only) used in Subclasses to determine how much damage a Sprite can take.
	public int damage; // used in Subclasses to determine how much the Sprite damages a movingSprite with which it collides.
	
	public boolean FeetsOnTheGround; // (for movingSprites only) true if the Sprite stands on a block or platform of any sort.
	public boolean OnTheWall, OnTheCeiling; // (for movingSprites only) true if the Sprite touches a wall or a ceiling.
	public boolean xCollided, yCollided;// (for movingSprites only) true if the sprite collided with a block vertically or horizontally during this cycle.
	
	public boolean featherLight;
	public boolean AirAffected =true; // if true the Sprite will be slowed down every cycle
	public boolean GravityAffected=true; // if true the Sprite will be accelerated downwards every cycle
	public int elasticity = 0; /* if = 0, no elasticity at all
	 							  if = 1, complete elasticity (the Sprite doesn't slow down when it bounces)
	 							  if = 2, elastic (but the Sprite slows down when it bounces)*/
	
	public int invincible =0; // if invincible isnt't = 0 the Sprite doesn't take damage;
	public int Slowed = 0, Freezed = 0; /* if Freezed isn't = 0 the sprite can't move
	 									   if Slowed isn't = 0 the Sprite is slowed to half of its speed*/
	public boolean Unstoppable;// if Unstoppable is true a Sprite cannot be slowed or freezed
	public int armor;// reduces damage taken.
	
	
	public String spriteString; // The Sprites "name". Used by other Sprite to react appropriately when they collide with it.
	public int xpoints[] = {x,		x,			x+width,	x+width};
	public int ypoints[] = {y,		y+height,	y+height,	y};//(for movingSprites only)  Array for the x and y coordinates of the collision polygons points
	public Polygon collisionp= new Polygon(xpoints,ypoints,4);//(for movingSprites only) The collision polygon
	/*The collision polygons points are basically the corners of the Sprites bounds and the future corners of the Sprites bounds (after dx and dy have been added to the x and y coordinate)
	 *That way the collision polygon basically stands for the path the Sprite will move this cycle. This is handy to correct the Sprites dx and dy before the it actually moves.
	 */
	public Rectangle bounds;//The collision rectangle (his size is defined by width and height)
	
	public Board parent;//The Board which coordinates the Sprite and on which the Sprite is drawn 
	public int counter = 0;/* The counter is increased by one every cycle and is set back to zero when it hits 60. Used when a process doesnt have
							  to be performed every cycle. (Example: if counter mod 2 = 0 -> regenerate 1 life)*/
	
	public Image[] image; //the images that will be drawn
	public int xPcorrect=0, xNcorrect=0, ycorrect=0; /* Defines how much the image will be drawn outside the bounds
	 													xPcorrect is how much more on the right
	 													xNcorrect is how much more on the left
	 													ycorrect is how much higher*/
	public Image[] imageCollection;//(for movingSprites only)all the different images from which the Sprite can choose (Example: if xImp > 0 -> image[0] = imageCollection[7])
	public ArrayList<String> source;// the data names for the imageCollection
	public boolean deathAnim = false;
	
	
	public Sprite(int x, int y, Board parent, boolean moveable){
		this.x = x;
		this.y = y;
		this.parent = parent;
		bounds = new Rectangle(x,y,width,height);
		this.moveable = moveable;
		source = new ArrayList<String>();
		//If moveable is set to true in the constructor the sprite will be added to the parents movingSprites ArrayList
		if (moveable){
			parent.movingSprites.add(this);
		//If moveable is set to false in the constructor the sprite will be added to the parents staticSprites ArrayList
		}else{
			parent.staticSprites.add(this);
		}
		
	}
	
	public void InitImage(){
		//(for static sprites only) Initiates the image of the Sprite
		// see the block class for a good example of InitImage()
	}
	
	public void xImp(int x, int b){
		//increases/decreases the Sprites xImp by x, up to a maximum of 60/ down to a minimum of -60, if counter mod b = 0;
		if (counter%b == 0){
			xImp += x;
			if(xImp>60)
				xImp=60;
			if(xImp<-60)
				xImp=-60;
		}
		
	}
	
	public void xImp(int x, int a, int b){
		//increases/decreases the Sprites xImp by x, up to a maximum of a/ down to a minimum of -a, if counter mod b = 0;
		if (counter%b == 0){
			if (a>0){
				if (xImp<a){
					xImp += x;
					if (xImp>a){
						xImp=a;
					}
				}
				if (a<xImp){
					xBrake(1,1);
				}
			}
			
			if (a<0){
				if (xImp>a){
					xImp += x;
					if (xImp<a){
						xImp=a;
					}
				}
				if (a>xImp){
					xBrake(1,1);
				}
			}
		}
		

	
	}
	
	public void yImp(int x, int b){
		//increases/decreases the Sprites yImp by x, up to a maximum of 60/ down to a minimum of -60, if counter mod b = 0;
		if (counter%b == 0){
			yImp += x;
			if(yImp>60)
				yImp=60;
			if(yImp<-60)
				yImp=-60;
		}
		
	}
	
	public void yImp(int x, int a, int b){
		//increases/decreases the Sprites yImp by x, up to a maximum of a/ down to a minimum of -a, if counter mod b = 0;
		if (counter%b == 0){
			if (a>0){
				if (yImp<a){
					yImp += x;
					if (yImp>a){
						yImp=a;
					}
				}
			}
			
			if (a<0){
				if (yImp>a){
					yImp += x;
					if (yImp<a){
						yImp=a;
					}
				}
			}
		}
		

	
	}
	
	public void xNullify(){
		//if elasticity is = 0, xImp is reduced to zero
		//if elasticity is bigger than 0, xImp is set to -xImp
		//if elasticity is bigger than 1, xImp is set to -xImp and reduced by 2
		if (elasticity > 0){
			xImp = -xImp;
			if (elasticity > 1){
				xBrake(2,1);
			}
		}else{
			xImp = 0;
		}
		
		
	}
	
	public void yNullify(){
		//if elasticity is = 0, yImp is reduced to zero
		//if elasticity is bigger than 0, xImp is set to -yImp
		//if elasticity is bigger than 1, xImp is set to -yImp and reduced by 2
		if (elasticity > 0){
			yImp = -yImp;
			if (elasticity > 1){
				yBrake(2,1);
			}
		}else{
			yImp = 0;
		}
		
	}
	
	public void xBrake(int x, int b){
		// if xImp is bigger than zero, its reduced by x, down to a minimum of zero, if counter mod b = 0
		// if xImp is smaller than zero, its increased by x, up to a maximum of zero, if counter mod b = 0
		if (counter%b == 0){
			if (xImp > 0){
				xImp -= x;
				if (xImp < 0){
					xImp = 0;
				}
			}
			if (xImp < 0){
				xImp += x;
				if (xImp > 0){
					xImp = 0;
				}
			}
		}
		
	}
	
	public void yBrake(int x,int b){
		// if yImp is bigger than zero, its reduced by x, down to a minimum of zero, if counter mod b = 0
		// if yImp is smaller than zero, its increased by x, up to a maximum of zero, if counter mod b = 0
		if (counter%b == 0){
			if (yImp > 0){
				yImp -= x;
				if (yImp < 0){
					yImp = 0;
				}
			}
			if (yImp < 0){
				yImp += x;
				if (yImp > 0){
					yImp = 0;
				}
			}
		}
		
	}
	
	public void Init(){
		//(for movingSprites only) Init() are the basic operations which are fulfilled every cycle
		//The programmer can add things to init so that a sprite can shoot missile or whatever
		
		//counter ticks up and is set down to zero if it hits 60;
		counter +=1;
		if (counter>60)
			counter = 1;
		
		if (life > maxLife){
			life = maxLife;
		}
		
		//if the Sprite is GravityAffected it's accelerated downwards
		if (GravityAffected){
			yImp(parent.Gravity[0],parent.Gravity[1]);
			
		}
		
		//if the Sprite is AirAffected it's braked vertically
		if (AirAffected){
			xBrake(1,friction*2);
			
		}
		
		
		//friction, FeetsOnTheGround, OnTheWall, OnTheCeiling, xCollided and yCollided are set to their standard value. They will eventually be changed if the Sprite collides with a block.
		friction = 2;
		FeetsOnTheGround = OnTheWall = OnTheCeiling = false;
		xCollided = yCollided = false;
		
		// If invincible is bigger than zero, its reduced by one. That way when you set invincible = 100 the sprite will be invincible for 100 cycles.
		if (invincible!=0){
			invincible --;
		}
		
		//dx is set to xImp and dy to yImp
		dx = xImp;
		dy = yImp;
		
		//If Untsoppable is false, Freezed Sprites are immobilized and Slowed Sprites are well... slowed. 
		if (Unstoppable == false){
			if (Slowed > 0){
				dx = dx/2;
				if (dy < 0){
					dy = dy/2;
				}
				// If Slowed is bigger than zero, its reduced by one.
				Slowed -=1;
			}
			
			if (Freezed > 0){
				dx = 0;
				if (dy < 0){
					dy = 0;
				}
				// If Freezed is bigger than zero, its reduced by one.
				Freezed -=1;
			}
		}
		
		
		
		//creates the collision Polygon when...
		if (dx==0 && dy==0){//... the sprite doesn't move
			int xpoints[] = {x,		x,			x+width,	x+width};
			int ypoints[] = {y,		y+height,	y+height,	y};
			collisionp= new Polygon(xpoints,ypoints,4);
		}
		
		if (dx==0 && dy>0){//... the sprite moves down
			int xpoints[] = {x,		x,				x+width,		x+width};
			int ypoints[] = {y,		y+height+dy,	y+height+dy,	y};
			collisionp= new Polygon(xpoints,ypoints,4);
		}
		
		if (dx==0 && dy<0){//... the sprite moves up
			int xpoints[] = {x,		x,			x+width,	x+width};
			int ypoints[] = {y+dy,	y+height,	y+height,	y+dy};
			collisionp= new Polygon(xpoints,ypoints,4);
		}
		if (dx>0 && dy==0){//... the sprite moves to the right
			int xpoints[] = {x,		x,			x+width+dx,	x+width+dx};
			int ypoints[] = {y,		y+height,	y+height,	y};
			collisionp= new Polygon(xpoints,ypoints,4);
		}
		if (dx<0 && dy==0){//... the sprite moves to the left
			int xpoints[] = {x+width,	x+dx,		x+dx,		x+width};
			int ypoints[] = {y,			y,	y+height,	y+height};
			collisionp= new Polygon(xpoints,ypoints,4);
		}
		if (dx>0 && dy>0){//... the sprite moves down and to the right
			int xpoints[] = {x,		x,			x+dx,			x+width+dx,		x+width+dx,		x+width};
			int ypoints[] = {y,		y+height,	y+height+dy,	y+height+dy,	y+dy,			y};
			collisionp= new Polygon(xpoints,ypoints,6);
		}
		if (dx>0 && dy<0){//... the sprite moves up and to the right
			int xpoints[] = {x,		x,			x+width,			x+width+dx,			x+width+dx,		x+dx,};
			int ypoints[] = {y,		y+height,	y+height,			y+dy+height,		y+dy,			y+dy};
			collisionp= new Polygon(xpoints,ypoints,6);
		}
		if (dx<0 && dy>0){//... the sprite moves down and to the left
			int xpoints[] = {x,		x+dx,			x+dx,			x+width+dx,		x+width,	x+width};
			int ypoints[] = {y,		y+dy,			y+height+dy,	y+height+dy,	y+height,	y};
			collisionp= new Polygon(xpoints,ypoints,6);
		}
		if (dx<0 && dy<0){//... the sprite moves up and to the left
			int xpoints[] = {x+width,		x+width,		x+width+dx,		x+dx,		x+dx,			x};
			int ypoints[] = {y+height,		y,				y+dy,			y+dy,		y+height+dy,	y+height};
			collisionp= new Polygon(xpoints,ypoints,6);
		}
	}
	
	public void move(){
		//(for movingSprites only)dx is added to the x-coordinate and dy is added to the y-coordinate
		x += dx;
		y += dy;
		//bounds are adapted to the new position
		bounds = new Rectangle(x,y,width,height);
	}
	
	public void heal(int x){
		//(for movingSprites only) life is increased by x, up to a maximum of maxLife
		life += x;
		if (life > maxLife){
			life = maxLife;
		}
	}
	
	public void damage(int x, boolean ignoreArmor){
		//(for movingSprites only)life is reduced by x-armor if ignoreArmor is false or by x if ignore armor is true.
		if (invincible == 0){
			if (ignoreArmor){
				life -= x;
			}else{
				if (x>armor){
					life -= x-armor;
				}else{
					life -=1;
				}
			}
			if (life<0){
				life = 0;
			}
		}
		
	}
	
	
	public void Collision(String s1, Sprite s){
		//The method that is launched when the Sprite collides with another one. String s1 is the SpriteString of the colliding Sprite
		//Example: if s1 = "enemy" --> 15 damage
	}
	
	public void death(){
		//Creates an explosion of pixel, gore and blood when a Sprite with deathAnim = true dies.
		
		int a = 20;
		if (deathAnim){
			for (int i = 0; i*a<height ; i++){
				int posy= y+i*a;
				for (int j = 0; j*a<width; j++){
					int posx = x+j*a;
					new DeathSprite(posx, posy, parent);
				}
			}
		}
		
	}
	
	public void findImage(){
		
		//the method that is launched before the Sprite gets painted. It allows the sprite to pick the right picture out of its imageCollection.
		
		
	}
	
	public void StringToImage(){
		
		//Takes the source Array and creates the imageCollection from the data names in source.

		try{
			imageCollection = new Image[source.size()];
			for (int i = 0; i < source.size(); i++){
				ImageIcon ii = new ImageIcon(this.getClass().getResource(source.get(i)));
				imageCollection[i]=ii.getImage();}
			image[0] = imageCollection[0];
		}catch(NullPointerException e){
			
		}
		
	}

}
