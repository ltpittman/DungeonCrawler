/**
 * A <tt>Player</tt> is a type of character that the user creates to go around the game. The player has a 
 * name, health, equipped weapon (with a corresponding strenght), equipped armor (with a corresponding strength)
 * and an inventroy. The player is moved around the board through the control of the user. It can pick items up,
 * add the items to the player's inventory, and equip the items to use in a battle. When the player comes across
 * an enemy the player can choose to fight it.
 * @author Lauren Pittman, Tavion Britt, and Grace Long
 */
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Player extends Character{
	//Private instance variables.
	private String name;
	private int health;
	private int weaponStrength;
	private int armorStrength;
	private Item equippedWeapon;
	private Item equippedArmor;
	public Inventory inventory;
	public World world;
	public int x;
	public int y;

	/**
	 * Constructs a new <tt>Player</tt> with a name, health, Inventory, and equipped weapon and armor. Each
	 * new player starts with their location in the center of the board
	 * @param name the name of the <tt>Player</tt>
	 * @param health the health of the <tt>Player</tt>
	 * @return the new <tt>Player</tt>
	 */
	public Player(String name, int health){
		super(name, health); 
		this.name = name;
		this.health = health;
		this.weaponStrength = weaponStrength;
		this.armorStrength = armorStrength;
		inventory = new Inventory(275);
		//Player starts in the middle.	
		this.x = 6;
		this.y = 14;
	}

	/**
	 * Restores the health to 100 when the <tt>Player</tt> drinks a health potion.
	 */
	public void restoreHealth(){
		this.health = 100;
	}

	/**
	 * Returns the player's image to the screen.
	 * @return the symbol of the player
	 */
	public char getCharacterImage(){
		return '@';
	}

	/**
	 * Returns the item that the <tt>Player</tt> currently has equipped
	 * @return armor that is equipped
	 */
	Item getEquippedArmor(){
		return inventory.getEquippedArmor();
	}

	/**
	 * Return the item that the <tt>Player</tt> currently has equipped
	 * @return weapon that is equipped
	 */
	Item getEquippedWeapon(){
		return inventory.getEquippedWeapon();
	}

	/**
	 * Returns the strength of the armor.
	 * @return the strength of the armor
	 */
	int getArmorStrength(){
		armorStrength = equippedArmor.getStrength();
		return armorStrength;
	}

	/**
	 * Returns the strength of the weapon.
	 * @return the strength of the weapon
	 */
	int getWeaponStrength(){
		weaponStrength = equippedWeapon.getStrength();
		return weaponStrength;
	}

	/**
	 * Checks to see if the <tt>Player</tt> can move up, if it can the <tt>Player</tt> moves up one 
	 * space on the board. The <tt>Player</tt> would not be able to move if there was a wall in the way.
	 * @return true if the player can move, false if the player cannot move
	 */
	public boolean goUp(){
		if((x - 1) == 0){
			System.out.println("[You can't go up in that direction anymore.]");
			return false;
		}
		else{
			x -= 1;
			return true;
		}
	}

	/**
	 * Checks to see if the <tt>Player</tt> can move down, it it can the <tt>Player</tt> moves down one
	 * space on the board. The <tt>Player</tt> would not be able to move if there was a wall in the way.
	 * @return true if the player can move, false if the player cannot move
	 */
	public boolean goDown(){
		if((x + 1) == 11){
			System.out.println("[You can't go down in that direction anymore.]");
			return false;
		}
		else{
			x += 1;
			return true;
		}	
	}

	/**
	 * Checks to see if the <tt>Player</tt> can move left, if it can the <tt>Player</tt> moves left one
	 * space on the board. The <tt>Player</tt> would not be able to move if there was a wall in the way.
	 * @return true if the player can move, false if the player cannot move
	 */
	public boolean goLeft(){
		if((y - 1) == 0){
			System.out.println("[You can't go left in that direction anymore.]");
			return false;
		}
		else{
			y -= 1;
			return true;
		}
	}

	/**
	 * Checks to see if the <tt>Player</tt> can move right, if it can <tt>Player</tt> moves right one
	 * space on the board. The <tt>Player</tt> would not be able to move if there was a wall in the way.
	 * @return true if the player can move, false if the player cannot move
	 */
	 public boolean goRight(){
		if((y + 1) == 29){
			System.out.println("[You can't go right in that direction anymore.]");
			return false;
		}
		else{
			y += 1;
			return true;
		}
	}

	/**
	 * Moves the player in a random direction. 
	 * @return true if the player can move in the random direction, false if it cannot
	 */
	public boolean move(){

		Random random = new Random();
		int pp = random.nextInt(4);

		if(pp == 0){
			//Have the player go down.
			if(x + 1 == 11){
				return false;
			}
			else{
				x += 1;
				return true;
			}
		}
		else if(pp == 1){
			//Have the player go up.
			if(x - 1 == 0){
				return false;
			}
			else{
				x -= 1;
				return true;
			}
		}
		else if(pp == 2){
			//Have the player go left.
			if(y - 1 == 0){
				return false;
			}
			else{
				y -= 1;
				return true;
			}
		}
		else if(pp == 3){
			//Have the player go right.
			if(y + 1 == 29){
				return false;
			}
			else{
				y += 1;
				return true;
			}
		}
		else{
			return false;
		}
	}

	/**
	 * Prints the player's name and health (out of 100)
	 */
	void printInfo(){
		System.out.println("[Player Information] \nName: " + this.name + "\nHealth: " + this.health + "/100");
	}

	/**Returns the location of the player to the screen.
	 */
	public void getLocation(){
		System.out.println("Location: " + this.x + "," + this.y);
	}

	/**
	 * Prints the player's name, health(out of 100) and strength of the weapon the <tt>Player</tt> is using. 
	 * @return player's name, health, and strength
	 */
	public String toString(){
		return("Player Name: " +  this.name + "\nHealth: " + this.health + "/100" + "\nStrength: " + this.weaponStrength);
	}

	/**
	 * Prints the information about the <tt>Player</tt> into a text file to save the game.
	 * @param pw the print writer that types the information into the file
	 */ 
	 public void persist(PrintWriter pw){
		String file = "Saved";
	        pw.println(file);	
		pw.println(name);
		pw.println(x + " " + y);
		pw.println(health);
		pw.println(inventory.equippedWeapon.getStrength());
		pw.println(inventory.equippedArmor.getStrength());

		pw.println(inventory.equippedWeapon.getType());
		pw.println(inventory.equippedWeapon.getName());
		pw.println(inventory.equippedWeapon.getWeight());
		pw.println(inventory.equippedWeapon.getValue());
		pw.println(inventory.equippedWeapon.getStrength());
		pw.println(inventory.equippedWeapon.getItemX());
		pw.println(inventory.equippedWeapon.getItemY());
		pw.println(inventory.equippedWeapon.getRoomNum());

		pw.println(inventory.equippedArmor.getType());
		pw.println(inventory.equippedArmor.getName());
		pw.println(inventory.equippedArmor.getWeight());
		pw.println(inventory.equippedArmor.getValue());
		pw.println(inventory.equippedArmor.getStrength());
		pw.println(inventory.equippedArmor.getItemX());
		pw.println(inventory.equippedArmor.getItemY());
		pw.println(inventory.equippedArmor.getRoomNum());
		pw.println(".");
	}

	/**
	 * Restores the information from a text file. This information is saved from a previous game and 
	 * allows the user to continue the game.
	 * @param a scanner that reads the file
	 */
	public void restore (Scanner a){
		try{
			this.name = a.nextLine();
			this.x = a.nextInt();
			this.y = a.nextInt();
			this.health = a.nextInt();
			this.weaponStrength = a.nextInt();
			this.armorStrength = a.nextInt();
			String blank = a.nextLine();
			String typeItem = a.nextLine();

			ItemType type = ItemType.valueOf(typeItem);
			String name = a.nextLine();
			int weight = a.nextInt();
			int value = a.nextInt();
			int stren = a.nextInt();
			int x = a.nextInt();
			int y = a.nextInt();
			int roomNum = a.nextInt(); //added this
			blank = a.nextLine();
			this.equippedWeapon = new Item(type, name, weight, value, stren, x, y, roomNum);
			String typeitemB = a.nextLine();
			ItemType typeB = ItemType.valueOf(typeitemB);
			String nameB = a.nextLine();
			int weightB = a.nextInt();
			int valueB = a.nextInt();
			int strenB = a.nextInt();
			int xB = a.nextInt();
			int yB = a.nextInt();
			int rN = a.nextInt();
			this.equippedArmor = new Item(typeB, nameB, weightB, valueB, strenB, xB, yB, rN);
		}

		catch(Exception e){
			System.out.println("No file could be found for the player portion.");
		}
	}
}


