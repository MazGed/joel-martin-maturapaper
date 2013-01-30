package phaseThreeGames;


/*The camera class is basically the top left corner of the players screen. In the draw function of the board the cameras x coordinate is subtracted from every Sprites x coordinate
 * and the cameras y coordinate is subtracted from every Sprites y coordinate so that the right sprites are drawn into the players screen.
 */
public class Camera {
	public int x, y;// the x and y coordinate of the camera
	public Board parent;
	public Camera (Board parent){
		this.parent = parent;
		
	}
	
	public void move(){
	/*The vertical movement of the camera is very easy: the cameras x coordinate is always equal the players x-coordinate minus 500
	 *The horizontal movement is a bit more complicated: There are two vertical lines on the screen, if the player crosses the lower line, which is at y = 400, 
	 *the cameras y coordinate will change so that the player is no longer underneath this line. if the player crosses the upper line, which is at y = 300, 
	 *the cameras x coordinate will change so that the player is no longer above this line.
	 */

		if (parent.p.y>350+y){ 
			y += parent.p.y - (350 + y);
			if (y>parent.h-690){
				y = parent.h-690;
			}
		}
		
		if (parent.p.y<250+y){
			y -= (250+y) - parent.p.y;
			if (y<0){
				y = 0;
			}
		}
		
		x = parent.p.x - 500;
		if (x<0){
			x = 0;
		}
		
		if (x>parent.w-995){
			x=parent.w-995;
		}
		
	
		
	}

}
