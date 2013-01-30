package level1;

import Cloaks.TinyCloak;
import Enemies.EdgeWalkerMignon;
import Enemies.FireDog;
import Enemies.Mignon;
import Enemies.ShamanMignon;
import phaseThreeGames.Board;
import phaseThreeGames.GamePanel;
import phaseThreeGames.Skinset;
import staticSprites.ElasticBlock;
import variousSprites.CloakSpawner;
import variousSprites.Flag;
import variousSprites.LifeBall;
import variousSprites.LifeWell;
import variousSprites.ManaWell;
import variousSprites.Spike;
import variousSprites.Tag;

public class Board4 extends Board{
	
	public Board4(GamePanel gp){
		super(gp);
		skin = new Skinset();
		BackSource = "/Pictures/darkwoodskinset/jungle.png";
		Gravity[1]=1;
		world =


						    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
						  + "@                              @                                          @        2222222222222222222222   @     @         @\n"
						  + "@                              @                                          @                                 @     @         @\n"
						  + "@                              @              @@@@@@                      @                                 @     @         @\n"
						  + "@                            4 @              @                           @                                1@     @         @\n"
						  + "@                          ##@ @            4 @                           @                     ####       @@     @      @  @\n"
						  + "@                            @ @           @@@@                           @                  4             @      @ #####@  @\n"
						  + "@                            @ @           @                   @@@@       @                  #             @      @      @  @\n"
						  + "@                          ##@ @           @                              @                                @      @      @  @\n"
						  + "@                            @ @    3 3    @                              @              ##              @ @      @##    @  @\n"
						  + "@!                           @ @ ##########@           4                @@@                             @@ @      @      @  @\n"
						  + "@@@@             @@@@        @ @           @       @@@@@@@                                              @  @      @      @  @\n"
						  + "@                           @@ @           @                           5           3 3 3                @  @@@@@@@@      @  @\n"
						  + "@                          @@@ @  3 3 3   @@                        @@@@@@@       ##########           1@              ##@  @\n"
						  + "@                    @@@@@@@@@ @######### @       #                 @     @                            @@                @  @\n"
						  + "@            @       @       @ @          @                         @     @666666666                   @      3 3        @  @\n"
						  + "@               @    @       @ @          @                         @7    @@@@@@@@@@                   @@@@@@@@@@@@@@@@@@@  @\n"
						  + "@                    @       @ @          @ #####                   @@@@           @                   @                    @\n"
						  + "@                  @ @@@@@@@@@ @ ########@@                         @              @                   @                    @\n"
						  + "@                    @         @         @                          @              @                   @ @     4   @        @\n"
						  + "@               @    @         @         @                          @              @1111111111111111   @ @     @   @     @  @\n"
						  + "@                    @ @@@@@@@@@         @                          @  @@@         @@@@@@@@@@@@@@@@@@@@@ @  @  @   @     @  @\n"
						  + "@                    @             @@    @@@@@                      @              222222222222222222222 @  @  @   @  @  @  @\n"
						  + "@   3 3 3 3          @             @@    @11111111111111111111111111@       3 3 @                        @  @  @ 3 @  @  @  @\n"
						  + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n";
		
 
		
		InitSprites();
		
		}
	
	public void WorldToSprites(char item){
		super.WorldToSprites(item);
		
		if (item == '1'){
			new Spike(worldX, worldY, this, 0);
			worldX += SPACE;
		}
		if (item == '2'){
			new Spike(worldX, worldY, this, 1);
			worldX += SPACE;
		}
		if (item == '3'){
			new EdgeWalkerMignon(worldX, worldY ,this, -1);
			worldX += SPACE;
		}
		if (item == '4'){
			new LifeBall(worldX, worldY ,this);
			worldX += SPACE;
		}
		if (item == '5'){
			new ManaWell(worldX, worldY ,this);
			worldX += SPACE;
		}
		
		if (item == '6'){
			new ElasticBlock(worldX, worldY ,this);
			worldX += SPACE;
		}
		if (item == '7'){
			new Flag(worldX, worldY ,this);
			worldX += SPACE;
		}
		
		
		
		
		
			
	}

}
