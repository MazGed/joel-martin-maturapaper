package phaseThreeGames;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import level1.Level1;
import menu.SuperPanel;

import Cloaks.Cloak;
import Goals.Goal;
import Weapons.Weapon;

/*While the board coordinates all the Sprites and that way is responsible for gravity, collision tests etc, the GamePanel coordinates the Boards and other objects like Goals,
 *which are crucial for the big picture, which means the GamePanel knows which Level the player is playing right now and keeps track of the players progress.
 *The GamePanel has a total of five methods which allow him to change between boards and to pause the game.
 */
public class GamePanel extends JPanel{

	public Board board;//The board that is actually shown
	public PausePanel pp;//The Menu that pops up when the game is paused
	public Goal g;// The Goal that the player has to reach
	public Level lvl;// The level that the player is playing (levels are basically only board arrays through which the GamePanel can switch + they contain the mission goal)
	public int level;// The number of the Level the player is playing (used to keep track of the progress)
	private CardLayout cards;
	private int boardIndex;//keeps track of which board in the Levels Board Array is shown at the moment
	public SaverLoader sl;// The object responsible for saving and loading
	
	public static int progress;// The players progress, if the player has completed all levels up to level 3, progress is = 3 (is saved and loaded)
	
	public static ArrayList<Weapon> wInventory = new ArrayList<Weapon>();// The List with all weapons yet collected(is saved and loaded)
	public static int[] wIndex = new int[4]; 
	/* The slots 1 to 3 describe which weapon in the inventory is in which slot,
	while the fourth one describes which of the carried weapons the character wears.(is saved and loaded)*/
	public static Weapon[] carriedWeapons = new Weapon[3];// The 3 weapons which the player carries (are saved and loaded)
	
	public static ArrayList<Cloak> cInventory= new ArrayList<Cloak>();// The List with all cloaks yet collected(is saved and loaded)
	public static int[] cIndex = new int[4]; 
	/* The slots 1 to 3 describe which cloak in the inventory is in which slot,
	while the fourth one describes which of the carried cloaks the character wears.(is saved and loaded)*/
	public static Cloak[] carriedCloaks = new Cloak[3];// The 3 claoks which the player carries (are saved and loaded)
	public SuperPanel sp;
	public Class source;
	public LoadingPanel lp;
	
	
	
	public GamePanel(String source, SuperPanel sp){
		
		this.sp = sp;
		sl = new SaverLoader(source, this);
		
		sl.load();
		
		cards = new CardLayout();
		setLayout(cards);
		
		pp = new PausePanel(this);
		add(pp, "Pause");
		
		lp = new LoadingPanel(this);
		add(lp, "Load");
		
		if (sl.newGame){//If the players starts a new game he starts at the first level.
			startLevel(new Level1(this));
		}else{//If he has already played he will start at the base, where he will be able to pick a level.
			backToBase();
		}
		
		
		
	}
	
	public void startLevel(Level lvl){
		/*Starts a level, which means:
		 *Sets the goal to the levels goal
		 *Sets the board to the first board in the choosen Levels Board Array
		 *Shows the PausePanel so that the player can read the mission goal and the lore
		 */
		this.lvl = lvl;
		g = lvl.goal;
		try{
			board.timer.stop();}
		catch(NullPointerException e){}
		board = lvl.board[0];
		boardIndex = 0;
		board.timer.stop();
		add(board, "Board");
		cards.show(this,"Pause");
		pp.requestFocus();
		
		board.p.life = GamePanel.carriedCloaks[GamePanel.cIndex[3]].maxLife;
		board.p.mana = GamePanel.carriedCloaks[GamePanel.cIndex[3]].maxMana;
	}
	
	public void changeBoard(int change){
		/*Switches to the next board in the played Levels Board Array
		 *If it was the last Board backToBase() is triggered
		 */
		board.timer.stop();
		boardIndex += change;
		try{
		board = lvl.board[boardIndex];}
		catch(ArrayIndexOutOfBoundsException e){
			backToBase();}
		add(board, "Board");
		cards.show(this,"Board");
		board.timer.start();
		board.requestFocus();
	}
	
	public void backToBase(){
		/*The Player goes back to base, where he can choose a level, which means:
		 *Goal is set to null
		 *The Level is set to null
		 *Board is set to a new HolySanctuary (which is the base)
		 */
		g = null;
		lvl = null;
		try{
			board.timer.stop();}
		catch(NullPointerException e){}
		board = new HolySanctuary(this);
		board.timer.start();
		add(board, "Board");
		cards.show(this,"Board");
		board.requestFocus();

	}
	
	public void load(){
		//shows the loading screen and loads the level
		cards.show(this, "Load");
		lp.initLoading();
	}
	
	public void pause(int state){
		//Pauses the game and shows the PauseMenu
		board.timer.stop();
		pp.state = state;
		cards.show(this,"Pause");
		pp.requestFocus();
	}
	
	public void board(){
		//restarts the game
		board.timer.start();
		cards.show(this,"Board");
		board.requestFocus();
	}

}
