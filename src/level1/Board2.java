package level1;

import Enemies.Mignon;
import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Skinset;
import variousSprites.LifeBall;
import variousSprites.ManaBall;
import variousSprites.Spike;
import variousSprites.Tag;

public class Board2 extends Board{
	
	public Board2(GamePanel gp){
		super(gp);
		skin = new Skinset();
		BackSource = "/Pictures/darkwoodskinset/jungle.png";
		Gravity[1]=1;
		world =

				  			"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
						  + "@                                                                                @@   @@                                    @\n"
						  + "@                                                                                @@ @@ @                                    @\n"
						  + "@ !                                                                              @@@2 1@                                    @\n"
						  + "@                                                                                @@   @@                                    @\n"
						  + "@                                                                                @@ @ @@                                    @\n"
						  + "@                                                                                @@@2@2@                                    @\n"
						  + "@        4                                                                       @@@   @3  3  3  3  3  @ #   #   #  # #  #  @\n"
						  + "@                                                                                @@ @@ @###############@ 1 1  1    1 1 1 1  @\n"
						  + "@                        5                                                       @@1   @               @1@ @1 @ 1 1@1@ @1@  @\n"
						  + "@       @                                                                        @@@ @1@               @@212@121@1@2@212@2  @\n"
						  + "@########                                                                        @@  @@@333         333@2 @ 2@ @2@2 2 @ 2   @\n"
						  + "@          @                          @ 3 3@                 Z                   @@@ @2@###############@  2  2 2 2    2     @\n"
						  + "@          @@      @######            ######                                     @@1 @ @               @                    @\n"
						  + "@1111111111@@@     @              @                          Y X                 @@@ @ @               @ p                  @\n"
						  + "@##############@   @      @ 3 @             ####           @@@@@@@@  @@  @@  @@  @@@@ 1@     33333     @####################@\n"
						  + "@              @   @      #####                           @@@@@@@@@11@@11@@11@@  @@ @@@@###############@                    @\n"
						  + "@              @111@                                     @ @@      ##  ##  ##    @@@@@@@               @                    @\n"
						  + "@              @####                             @      @  @@                    @@@@@@@               @                    @\n"
						  + "@                                                ########  @@ @    3  3  3  3    @@@@@@@  3 3 3  3 3 3 @                    @\n"
						  + "@                                                          @@ @@@@@@@@@@@@@@@@@@@@@@@@@@###############@                    @\n"
						  + "@                                                          @@                    2222222               @                    @\n"
						  + "@                                                      ####@@                                          @                    @\n"
						  + "@1111111111111111111111111111111111111111111111111111111111@@  @ 3  @  3 @  3  @                       @                    @\n"
						  + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n";
		
 
		
		InitSprites();
		
		}
	
	public void WorldToSprites(char item){
		super.WorldToSprites(item);
		
		if (item == '1'){
			new Spike(worldX, worldY ,this,0);
			worldX += SPACE;
		}
		if (item == '2'){
			new Spike(worldX, worldY ,this,1);
			worldX += SPACE;
		}
		if (item == '3'){
			new Mignon(worldX, worldY, this, 1);
			worldX += SPACE;
		}
		if (item == '4'){
			new Tag(worldX, worldY, "These spiky roots can cause heavy damage to the Guardian." ,this);
			worldX += SPACE;
		}
		if (item == '5'){
			new Tag(worldX, worldY, "Use the \"a\"-button to shoot the demonic creatures." ,this);
			worldX += SPACE;
		}
		if (item == 'X'){
			new LifeBall(worldX, worldY, this);
			worldX += SPACE;
		}
		if (item == 'Y'){
			new ManaBall(worldX, worldY, this);
			worldX += SPACE;
		}
		
		if (item == 'Z'){
			new Tag(worldX, worldY, "Pick up life-and manaballs to restore your life and mana." ,this);
			worldX += SPACE;
		}
		
		
		
		
			
	}

}
