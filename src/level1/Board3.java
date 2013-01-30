package level1;

import Cloaks.TinyCloak;
import Enemies.EdgeWalkerMignon;
import Enemies.Mignon;
import Enemies.ShamanMignon;
import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Skinset;
import staticSprites.ElasticBlock;
import variousSprites.CloakSpawner;
import variousSprites.LifeWell;
import variousSprites.ManaWell;
import variousSprites.Spike;
import variousSprites.Tag;

public class Board3 extends Board{
	
	public Board3(GamePanel gp){
		super(gp);
		skin = new Skinset();
		BackSource = "/Pictures/darkwoodskinset/jungle.png";
		Gravity[1]=1;
		world =

							"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
						  + "@                              @@@@@@@@@@@@@@@@@@@@@@         @    @                                                        @\n"
						  + "@                              @@@@@@@@@@@@@@@@@@@@@@         @   @@                                                        @\n"
						  + "@                              @@@@@@@@@@@@@@@@@@@@@@         @@@@@@                                                        @\n"
						  + "@                              @@@@@@@@@@@@@@@@@@@@@@         @ @@ @                                                        @\n"
						  + "@                              @@@@@@@@@@@@@@@@@@@@@@         @    @                                                        @\n"
						  + "@                              @@                 33@         @@@  @                                                        @\n"
						  + "@                              @@                   @         @ @  @                                                        @\n"
						  + "@                              @@  @@@@@@@@@@@@@@@  @         @ @  @                                                        @\n"
						  + "@                              @@  @@@@@@@@@@@@@@@# @         @ @@@@                                                        @\n"
						  + "@                              @@               @@  @         @    @                                                        @\n"
						  + "@                              @@     4 4 5     @@ #@         @@@  @                                                        @\n"
						  + "@                              @@@@@@@@@@@@@@@  @@  @         @ @@@@                                                        @\n"
						  + "@                              @@@@@@@@@@@@@@@  @@# @         @    @                                                        @\n"
						  + "@                              @@               @@  @         @    @                                                        @\n"
						  + "@   !                          @@     4 4 5     @@ #@         @@@  @                                 2                      @\n"
						  + "@                              @@  @@@@@@@@@@@@@@@  @         @  @@@         ####@               @##########@               @\n"
						  + "@                              @@  @@@@@@@@@@@@@@@# @         @    @             @               @   @ @ @  @  44           @\n"
						  + "@@                             @@               @@  @         @    @ 4 4 5       @      A        @   @ @ @  @######@        @\n"
						  + "@                   B          @@     4 4 5     @@ #@         @  @@@@@@@@@@@     @               @   @ @ @  @  @@  @  444   @\n"
						  + "@@@ @                          @@@@@@@@@@@@@@@  @@  @ 6   7   @@@@ @       @     @   4       4   @   @ @ @  @  @@  @####### @\n"
						  + "@  @ @ @                       @@@@@@@@@@@@@@@  @@# @         @    @ @@@@@ @     @               @   @ @ @  @  @@  @  @@@ @ @\n"
						  + "@ @  @@ @                                       @@            @@@@@@ @   @ @@@@  @               @   @@@@@  @  @@  @  @@@ @ @\n"
						  + "@@ @ @@@ @        1    2                        @@      8            @   @       @999999999999999@p                         @\n"
						  + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n";
		
 
		
		InitSprites();
		
		}
	
	public void WorldToSprites(char item){
		super.WorldToSprites(item);
		
		if (item == '1'){
			new LifeWell(worldX, worldY ,this);
			worldX += SPACE;
		}
		if (item == '2'){
			new ManaWell(worldX, worldY ,this);
			worldX += SPACE;
		}
		if (item == '3'){
			new Spike(worldX, worldY, this, 1);
			worldX += SPACE;
		}
		if (item == '4'){
			new EdgeWalkerMignon(worldX, worldY ,this, -1);
			worldX += SPACE;
		}
		if (item == '5'){
			new ShamanMignon(worldX, worldY ,this, -1);
			worldX += SPACE;
		}
		
		if (item == '6'){
			new Tag(worldX, worldY, "Walk over an Item to pick it up. This is a tiny cloak." ,this);
			worldX += SPACE;
		}
		if (item == '7'){
			new Tag(worldX, worldY, "Put on the tiny cloak by clicking on it. Use it to go into tight holes." ,this);
			worldX += SPACE;
		}
		if (item == '8'){
			new CloakSpawner(worldX, worldY ,this, new TinyCloak(gp), 100);
			worldX += SPACE;
		}
		if (item == '9'){
			new ElasticBlock(worldX, worldY ,this);
			worldX += SPACE;
		}
		if (item == 'A'){
			new Tag(worldX, worldY, "Jump jump jump!!!" ,this);
			worldX += SPACE;
		}
		if (item == 'B'){
			new Tag(worldX, worldY, "Restore you're life and mana at the Wells." ,this);
			worldX += SPACE;
		}
		
		
		
		
			
	}

}
