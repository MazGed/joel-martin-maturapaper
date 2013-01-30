package phaseThreeGames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import Cloaks.Cloak;
import Cloaks.GreenCloak;
import Weapons.Weapon;
import Weapons.WoodenStaff;

public class SaverLoader {
	/*The SaverLoader is the class dedicated to saving and loading. Essentially it saves and loads the player's progress
	 *and his weapons and cloaks.
	 * 
	 */
	public String s;//The name of the .ser-data on which the SaverLoader saves.
	public GamePanel gp;
	public boolean newGame;
	
	public SaverLoader(String s, GamePanel gp){
		this.s = s;
		this.gp = gp;
		GamePanel.wInventory.clear();
 		GamePanel.cInventory.clear();
 		newGame= gp.sp.newGame;

		
	}
	
	public void save(){
		//saves the player's progress and inventory inside a given .ser-data.
		
		
		
		ArrayList<Class> wInventory = new ArrayList<Class>();
		Class carriedWeapons[] = new Class[3];
		ArrayList<Class> cInventory = new ArrayList<Class>();
		Class carriedCloaks[] = new Class[3];
		
		/*Takes the players inventory items and carried items classes and puts them into ArrayLists and Arrays
		 *This is necessary to be able to save weapons and cloaks. If one would just try to save existing 
		 *Weapon object there would be an IOexception.
		 * 
		 */
		for (int i = 0; i < GamePanel.wInventory.size(); i++){
			wInventory.add(GamePanel.wInventory.get(i).getClass());
		}
		for (int i = 0; i < GamePanel.cInventory.size(); i++){
			cInventory.add(GamePanel.cInventory.get(i).getClass());
		}
		for (int i = 0; i < GamePanel.carriedWeapons.length; i++){
			carriedWeapons[i] = GamePanel.carriedWeapons[i].getClass();
		}
		for (int i = 0; i < GamePanel.carriedCloaks.length; i++){
			carriedCloaks[i] = GamePanel.carriedCloaks[i].getClass();
		}
		
		wInventory.clear();
		wInventory.add(Weapons.GrenadeStaff.class);
		wInventory.add(Weapons.WoodenStaff.class);
		wInventory.add(Weapons.IceStaff.class);
		wInventory.add(Weapons.PurpleStaff.class);
		wInventory.add(Weapons.ManavampStaff.class);
		wInventory.add(Weapons.VampireStaff.class);
		wInventory.add(Weapons.HookStaff.class);
		wInventory.add(Weapons.PushStaff.class);
		wInventory.add(Weapons.ScatterStaff.class);
		wInventory.add(Weapons.MineStaff.class);
		
		cInventory.clear();
		cInventory.add(Cloaks.GreenCloak.class);
		cInventory.add(Cloaks.DarkCloak.class);
		cInventory.add(Cloaks.ElasticCloak.class);
		cInventory.add(Cloaks.ExchangeCloak.class);
		cInventory.add(Cloaks.GravityCloak.class);
		cInventory.add(Cloaks.IceCloak.class);
		cInventory.add(Cloaks.IronCloak.class);
		cInventory.add(Cloaks.MagmaCloak.class);
		cInventory.add(Cloaks.ManaCloak.class);
		cInventory.add(Cloaks.ParachuteCloak.class);
		cInventory.add(Cloaks.TinyCloak.class);
		
		
		//Saves the progress, the cloaks and the weapons inside a .ser-data.
		try{

            FileOutputStream fs = new FileOutputStream(s);

            ObjectOutputStream os = new ObjectOutputStream(fs);
            
            os.writeInt(GamePanel.progress);
            os.writeObject(GamePanel.wIndex);
            os.writeObject(GamePanel.cIndex);
            os.writeObject(wInventory);
            os.writeObject(cInventory);
            os.writeObject(carriedWeapons);
            os.writeObject(carriedCloaks);
            
            
            
            
            os.flush();
            os.close();

     }catch(IOException e){

            System.err.println(e.toString());

     }
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void load(){
		//loads the player's progress and inventory from a given .ser-data.
		//If there isn't an appropriate .ser-data around this method starts a new game
		
		ArrayList<Class> wInventory = new ArrayList<Class>();
		Class carriedWeapons[] = new Class[3];
		ArrayList<Class> cInventory = new ArrayList<Class>();
		Class carriedCloaks[] = new Class[3];
		
		if (newGame){
			
			GamePanel.progress = 0;
			GamePanel.wInventory.add(new WoodenStaff(gp));
			GamePanel.cInventory.add(new GreenCloak(gp));
			GamePanel.carriedWeapons[0]= GamePanel.wInventory.get(0);
			GamePanel.wIndex[0] = 0;
			GamePanel.carriedWeapons[1]= GamePanel.wInventory.get(0);
			GamePanel.wIndex[1] = 0;
			GamePanel.carriedWeapons[2]= GamePanel.wInventory.get(0);
			GamePanel.wIndex[2] = 0;
			GamePanel.wIndex[3] = 0;
			GamePanel.carriedCloaks[0]= GamePanel.cInventory.get(0);
			GamePanel.cIndex[0] = 0;
			GamePanel.carriedCloaks[1]= GamePanel.cInventory.get(0);
			GamePanel.cIndex[1] = 0;
			GamePanel.carriedCloaks[2]= GamePanel.cInventory.get(0);
			GamePanel.cIndex[2] = 0;
			GamePanel.cIndex[3] = 0;
			
			gp.level = 1;
			
		}else{
			//extracts the player's progress and the classes of his weapons and cloaks.
			try{

	            FileInputStream fs = new FileInputStream(s);

	            ObjectInputStream is = new ObjectInputStream(fs);

	            GamePanel.progress = is.readInt();
	            GamePanel.wIndex = (int[]) is.readObject();
	            GamePanel.cIndex = (int[]) is.readObject();
	            wInventory = (ArrayList<Class>) is.readObject();
	            cInventory = (ArrayList<Class>) is.readObject();
	    		carriedWeapons = (Class[]) is.readObject();
	    		carriedCloaks = (Class[]) is.readObject();

	            is.close();
	            
	            
	        //creates a new instance of the saved weapons and cloaks. The player won't notice any difference between
	        //the different instances of the classes.
	    		for (int i = 0; i < wInventory.size(); i++){
	    			Constructor<Weapon>[] c1 = (Constructor<Weapon>[]) wInventory.get(i).getConstructors();
	    			try {
	    				Weapon w = (Weapon)c1[0].newInstance(gp);
	    				GamePanel.wInventory.add(w);
	    			} catch (InstantiationException e) {
	    				e.printStackTrace();
	    			} catch (IllegalAccessException e) {
	    				e.printStackTrace();
	    			} catch (IllegalArgumentException e) {
	    				e.printStackTrace();
	    			} catch (InvocationTargetException e) {
	    				e.printStackTrace();
	    			}
	    			
	    		}
	    		
	    		for (int i = 0; i < cInventory.size(); i++){
	    			Constructor<Cloak>[] c2 = (Constructor<Cloak>[]) cInventory.get(i).getConstructors();
	    			Cloak c;
	    			try {
	    				c = (Cloak)c2[0].newInstance(gp);
	    				GamePanel.cInventory.add(c);
	    			} catch (InstantiationException e) {
	    				e.printStackTrace();
	    			} catch (IllegalAccessException e) {
	    				e.printStackTrace();
	    			} catch (IllegalArgumentException e) {
	    				e.printStackTrace();
	    			} catch (InvocationTargetException e) {
	    				e.printStackTrace();
	    			}
	    			
	    		}
	    		
	    		for (int i = 0; i < carriedWeapons.length; i++){
	    			Constructor<Weapon>[] c3 = (Constructor<Weapon>[]) carriedWeapons[i].getConstructors();
	    			Weapon w;
	    			try {
	    				w = (Weapon)c3[0].newInstance(gp);
	    				GamePanel.carriedWeapons[i] = w;
	    			} catch (InstantiationException e) {
	    				e.printStackTrace();
	    			} catch (IllegalAccessException e) {
	    				e.printStackTrace();
	    			} catch (IllegalArgumentException e) {
	    				e.printStackTrace();
	    			} catch (InvocationTargetException e) {
	    				e.printStackTrace();
	    			}
	    			
	    		}
	    		
	    		for (int i = 0; i < carriedCloaks.length; i++){
	    			Constructor<Cloak>[] c4 = (Constructor<Cloak>[]) carriedCloaks[i].getConstructors();
	    			Cloak c;
	    			try {
	    				c = (Cloak)c4[0].newInstance(gp);
	    				GamePanel.carriedCloaks[i] = c;
	    			} catch (InstantiationException e) {
	    				e.printStackTrace();
	    			} catch (IllegalAccessException e) {
	    				e.printStackTrace();
	    			} catch (IllegalArgumentException e) {
	    				e.printStackTrace();
	    			} catch (InvocationTargetException e) {
	    				e.printStackTrace();
	    			}
	    			
	    		}

			 }catch(IOException e){
				System.err.println(e.toString()); 
				// If there isn't an appropriate .ser-data the game will set the players progress to zero
				// and give him a starting cloak and a starting weapon.
					GamePanel.progress = 0;
					GamePanel.wInventory.add(new WoodenStaff(gp));
					GamePanel.cInventory.add(new GreenCloak(gp));
					GamePanel.carriedWeapons[0]= GamePanel.wInventory.get(0);
					GamePanel.wIndex[0] = 0;
					GamePanel.carriedWeapons[1]= GamePanel.wInventory.get(0);
					GamePanel.wIndex[1] = 0;
					GamePanel.carriedWeapons[2]= GamePanel.wInventory.get(0);
					GamePanel.wIndex[2] = 0;
					GamePanel.wIndex[3] = 0;
					GamePanel.carriedCloaks[0]= GamePanel.cInventory.get(0);
					GamePanel.cIndex[0] = 0;
					GamePanel.carriedCloaks[1]= GamePanel.cInventory.get(0);
					GamePanel.cIndex[1] = 0;
					GamePanel.carriedCloaks[2]= GamePanel.cInventory.get(0);
					GamePanel.cIndex[2] = 0;
					GamePanel.cIndex[3] = 0;
					
					gp.level = 1;
					
					newGame = true;


        

			 }catch (ClassNotFoundException e) {
			 		e.printStackTrace();
			 }
		}


	}
	



}
