package Enemies;

import java.awt.Image;

import javax.swing.ImageIcon;

import phaseThreeGames.Board;


public class MutantBanana extends Enemy{
	//Behaves exactly like a mignon but has a counter which causes his death after a certain time.
	//Fun fact: Bananas were the enemies of the phaseTwoGame.

	private int dcounter = 100;

	public MutantBanana(int x, int y, Board parent, int direction) {
		super(x, y, parent);
		maxSpeed = 2;
		maxLife = 20;
		life = maxLife;
		damage = 20;
		width = 30;
		height = 60;
		this.direction = direction;
		
		source.add("/Pictures/bml1.png");
		source.add("/Pictures/bjl.png");
		source.add("/Pictures/bmr1.png");
		source.add("/Pictures/bjr.png");
		source.add("/Pictures/bml2.png");
		source.add("/Pictures/bmr2.png");
		StringToImage();
		
		
	}
	
	public void Init(){
		dcounter --;
		if (dcounter == 0){
			life = 0;
		}
	}
	
	
	


}
