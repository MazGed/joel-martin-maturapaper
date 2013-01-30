package level1;

import Enemies.BouncingNut;
import Enemies.MutantPlant;
import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.IcyWoods;
import phaseThreeGames.Skinset;
import phaseThreeGames.Volcano;
import staticSprites.ElasticBlock;
import staticSprites.IcyBlock;
import variousSprites.CloakChanger;
import variousSprites.Flag;
import variousSprites.LifeBall;
import variousSprites.ManaBall;
import variousSprites.ManaWell;
import variousSprites.Portal;
import variousSprites.SpawnPortal;
import variousSprites.Spike;
import variousSprites.StartPortal;
import variousSprites.Tag;
import variousSprites.WeaponChanger;

public class Board1 extends Board{
	public Board1(GamePanel gp){
		super(gp);
		skin = new Skinset();
		BackSource = "/Pictures/darkwoodskinset/jungle.png";
		Gravity[1]=1;
		world =

							"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                             4               5                         @@             @\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                                                                       @@             @\n"
						  + "@                                   @@                        ###@@@@@@@##@@@@@@@@@@@@       @@@@@@@  @@@@@@@@@             @\n"
						  + "@                                   @@                           @                            @@@@@@  @@@@@@@@@             @\n"
						  + "@                                   @@                           @                            @@@@@@         @@             @\n"
						  + "@                                   @@                  #####    @                            @@@@@@         @@             @\n"
						  + "@                                   @@                           @      ##                    @@@@@@@@@@@@@  @@             @\n"
						  + "@                                   @@                           @                            @@@@@@@@@@@@@  @@             @\n"
						  + "@ 1                                 @@           ####            @                            @@@@@@         @@             @\n"
						  + "@                   2               @@                           @                            @@@@@@         @@             @\n"
						  + "@                               3   @@                           @      ##                    @@@@@@  @@@@@@@@@         6   @\n"
						  + "@ !                      @@@@@@            ####                  @                            @@@@@@  @@@@@@@@@       @     @\n"
						  + "@                        @@@@@@                                  @                            @@@@@@  @@@@@@@@@     @ @     @\n"
						  + "@@@@@                    @@@@@@     @@   #                       @                            @@@@@@              @ @ @     @\n"
						  + "@@@@@@@@@                @@@@@@     @@                           @      @@                    @@@@@@            @ @ @ @  p  @\n"
						  + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n";
		
 
		
		InitSprites();
		
		}
	
	public void WorldToSprites(char item){
		super.WorldToSprites(item);
		
		if (item == '1'){
			new Tag(worldX, worldY, "Use the left and right arrow keys to walk." ,this);
			worldX += SPACE;
		}
		if (item == '2'){
			new Tag(worldX, worldY, "Press the upper arrow key firmly to jump." ,this);
			worldX += SPACE;
		}
		if (item == '3'){
			new Tag(worldX, worldY, "By just clicking on the upper arrow key you can make a small jump." ,this);
			worldX += SPACE;
		}
		if (item == '4'){
			new Tag(worldX, worldY, "While walking press control to start running." ,this);
			worldX += SPACE;
		}
		if (item == '5'){
			new Tag(worldX, worldY, "When you run the range of your jump will be extended." ,this);
			worldX += SPACE;
		}
		if (item == '6'){
			new Tag(worldX, worldY, "Enter the portal by clicking the under arrow key." ,this);
			worldX += SPACE;
		}
		
		
		
			
	}
	
	
	
	
		
	}
	
