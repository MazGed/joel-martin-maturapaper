package phaseThreeGames;

import staticSprites.Block;
import variousSprites.CloakChanger;
import variousSprites.StartPortal;
import variousSprites.Tag;
import variousSprites.WeaponChanger;


/*The Holy Sanctuary is the Board on which the player can choose his level.
 * 
 */

public class HolySanctuary extends Board{
	public HolySanctuary(GamePanel gp){
		super(gp); 
		p.life = GamePanel.carriedCloaks[GamePanel.cIndex[3]].maxLife;
		p.mana = GamePanel.carriedCloaks[GamePanel.cIndex[3]].maxMana;
		
		skin = new Skinset();
		BackSource = "/Pictures/darkwoodskinset/jungle.png";
		world =
				"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
			+	"@                                                                 @\n"
			+	"@                          i       j                              @\n"
			+	"@                        I             J                          @\n"
			+	"@                        ###############                          @\n"
			+	"@                                                                 @\n"
			+	"@                          g       h                              @\n"
			+	"@                        G             H                          @\n"
			+	"@                        ###############                          @\n"
			+	"@                                                                 @\n"
			+	"@                          e       f                              @\n"
			+	"@                        E             F                          @\n"
			+	"@                        ###############                          @\n"
			+	"@                                                                 @\n"
			+	"@                          c       d                              @\n"
			+	"@               y        C             D      x                   @\n"
			+	"@                        ###############                   @      @\n"
			+	"@              4 5 6                         1 2 3                @\n"
			+	"@                          a    !  b                ############  @\n"
			+	"@                        A             B                          @\n"
			+	"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n";
		
 
		
		InitSprites();
		
		}
	
	public void WorldToSprites(char item){
		super.WorldToSprites(item);
		
		if (item == 'A'){
			new StartPortal(worldX, worldY, this, 1, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'a'){
			new Tag(worldX, worldY, "Level 1: Tutorial", this);
			worldX += SPACE;
		}
		else if (item == 'B'){
			new StartPortal(worldX, worldY, this, 2, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'b'){
			new Tag(worldX, worldY, "Level 2: Unexpected visitors", this);
			worldX += SPACE;
		}
		else if (item == 'C'){
			new StartPortal(worldX, worldY, this, 3, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'c'){
			new Tag(worldX, worldY, "Level 3: Showtime", this);
			worldX += SPACE;
		}
		else if (item == 'D'){
			new StartPortal(worldX, worldY, this, 4, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'd'){
			new Tag(worldX, worldY, "Level 4: Iceberg journey", this);
			worldX += SPACE;
		}
		else if (item == 'E'){
			new StartPortal(worldX, worldY, this, 5, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'e'){
			new Tag(worldX, worldY, "Level 5: Slippery shoes", this);
			worldX += SPACE;
		}
		else if (item == 'F'){
			new StartPortal(worldX, worldY, this, 6, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'f'){
			new Tag(worldX, worldY, "Level 6: I scream for ice cream", this);
			worldX += SPACE;
		}
		else if (item == 'G'){
			new StartPortal(worldX, worldY, this, 7, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'g'){
			new Tag(worldX, worldY, "Level 7: Highway to hell", this);
			worldX += SPACE;
		}
		else if (item == 'H'){
			new StartPortal(worldX, worldY, this, 8, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'h'){
			new Tag(worldX, worldY, "Level 8: Ring of fire", this);
			worldX += SPACE;
		}
		else if (item == 'I'){
			new StartPortal(worldX, worldY, this, 9, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'i'){
			new Tag(worldX, worldY, "Level 9: Heart of the volcano", this);
			worldX += SPACE;
		}
		else if (item == 'J'){
			new StartPortal(worldX, worldY, this, 10, level1.Level1.class);
			worldX += SPACE;
		}
		if (item == 'j'){
			new Tag(worldX, worldY, "Level 10: Showdown with the Demonlord", this);
			worldX += SPACE;
		}
		
		else if (item == '1'){
			new WeaponChanger(worldX, worldY, this, 0);
			worldX += SPACE;
		}
		else if (item == '2'){
			new WeaponChanger(worldX, worldY, this, 1);
			worldX += SPACE;
		}
		else if (item == '3'){
			new WeaponChanger(worldX, worldY, this, 2);
			worldX += SPACE;
		}
		else if (item == '4'){
			new CloakChanger(worldX, worldY, this, 0);
			worldX += SPACE;
		}
		else if (item == '5'){
			new CloakChanger(worldX, worldY, this, 1);
			worldX += SPACE;
		}
		else if (item == '6'){
			new CloakChanger(worldX, worldY, this, 2);
			worldX += SPACE;
		}
		if (item == 'y'){
			new Tag(worldX, worldY, "Jump under these blocks to change your carried cloaks.", this);
			worldX += SPACE;
		}
		if (item == 'x'){
			new Tag(worldX, worldY, "Jump under these blocks to change your carried weapons.", this);
			worldX += SPACE;
		}
		
			
	}
	
	public void Init(){
		//Added this to holy Sanctuary so that player cannot die in it (e.g. by walking into mines).
		super.Init();
		if (p.life < p.maxLife){
			p.life = p.maxLife;
		}
		if (p.mana < p.maxMana){
			p.mana = p.maxMana;
		}
	}
}
