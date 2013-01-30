package menu;

import java.awt.CardLayout;

import javax.swing.JPanel;

import phaseThreeGames.GamePanel;
import phaseThreeGames.PausePanel;

public class SuperPanel extends JPanel{
	
	/*The highest placed JPanel in the whole hierarchy.
	 *It is the Panel which is put inside the window.
	 *It contains and coordinates the startPanel, a LoadingPanel, the MenuPanel
	 *and most importantly the GamePanels.
	 */
	
	public String source;
	public boolean newGame=false;
	
	public CardLayout cards;
	public StartPanel sp;
	public MenuPanel mp;
	public GamePanel gp;
	public LoadingPanel lp;
	public ConfirmationPanel cp;
	
	public SuperPanel(){
		
		
		cards = new CardLayout();
		setLayout(cards);
		
		sp = new StartPanel(this);
		add(sp, "Start");
		
		mp = new MenuPanel(this);
		add(mp, "Menu");
		
		lp = new LoadingPanel(this);
		add(lp, "Load");
		
		cp = new ConfirmationPanel(this);
		add(cp, "Confirm");
		
		start();
	}
	
	public void start(){
		//shows the starting screen
		cards.show(this, "Start");
		sp.requestFocus();
	}
	
	
	public void menu(){
		//shows the menu screen
		cards.show(this, "Menu");
		gp = null;
	}
	
	public void load(String source, boolean newGame){
		//loads a new GamePanel. The SaverLoader of that gp will be able to load from the given source
		//shows the loading Panel
		this.newGame = newGame;
		this.source = source;
		cards.show(this, "Load");
		lp.initLoading();
		
	}
	
	public void confirm(String source){
		//shows the Are-you-sure-you-want-to-create-a-new-game panel
		this.source = source;
		cards.show(this, "Confirm");
	}

}
