/**
 *A Player is a type of character that the user creates to go around the game. The player has a name, health, equipped weapon (with a corresponding strenght), equipped armor (with a corresponding strength) and an inventroy. The player is moved around the board through the control of the user. It can pick items up, add the items to the player's inventory, and equip the items to use in a battle. When the player comes across an enemy the player can choose to fight it.
 * @author Lauren Pittman, Tavion Britt, and Grace Long
 */
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Player extends Character{
	//Private instance variables.
	private String name;
	private int health;
	private int weaponStrength;
	private int armorStrength;
	Item equippedWeapon;
	Item equippedArmor;
	public Inventory inventory;
	public int x;
	public int y;

	/**
	 * Constructs a new Player with a name, health, Inventory, and equipped weapon and armor. Each  new player starts with their location in the center of the board
	 *  @param name The name of the Player.
	 * @param health The health of the Player.
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
	 * This method sets the health of the Player.
	 * @param num The health of the player.
	 */
	public void setHealth(int num){
		this.health = num;
	}

	/**
	 * This method restores the health to 100 when the Player drinks a health potion.
	 */
	public void restoreHealth(){
		this.health = 100;
	}

	/**
	 * This method returns the player's image to the screen.
	 * @return Returns the symbol of the player ('@').
	 */
	public char getCharacterImage(){
		return '@';
	}

	/**This method returns the player's x-coordinate.
	 * @return Returns the x-coordinate of the player.
	 */
	public int getPlayerX(){
		return this.x;
	}
	
	/**This method returns the player's x-coordinate.
	 * @return Returns the y-coordinate of the player.
	 */
	public int getPlayerY(){
		return this.y;
	}

	/**
	 * This method returns the item that the Player currently has equipped.
	 * @return Returns the armor that is equipped by the player.
	 */
	public Item getEquippedArmor(){
		return inventory.getEquippedArmor();
	}

	/**
	 * This method returns the item that the Player currently has equipped.
	 * @return Returns the weapon that is equipped by the player.
	 */
	public Item getEquippedWeapon(){
		return inventory.getEquippedWeapon();
	}

	/**
	 * This method returns the strength of the armor that is worn by the player.
	 * @return Returns the strength of the armor that is worn by the player.
	 */
	int getArmorStrength(){
		armorStrength = equippedArmor.getStrength();
		return armorStrength;
	}

	/**
	 * This method returns the strength of the weapon that is worn by the player.
	 * @return Returns the strength of the weapon that is worn by the player.
	 */
	int getWeaponStrength(){
		weaponStrength = equippedWeapon.getStrength();
		return weaponStrength;
	}

	/**
	 * This method checks to see if the Player can move up. If the Player can move up, then they can go up one space on the board. The Player would not be able to move if there was a wall in the way.
	 * @return Returns true if the player can move, else false if the player cannot move.
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
	 * This method checks to see if the Player can move down. If the Player can move down, then they can go down one space on the board. The Player would not be able to move if there was a wall in the way.
	 * @return Returns true if the player can move, else false if the player cannot move.
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
	 * This method checks to see if the Player can move left. If the Player can move left, then they can go left one space on the board. The Player would not be able to move if there was a wall in the way.
	 * @return Returns true if the player can move, else false if the player cannot move.
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
	 * This method checks to see if the Player can move right. If the Player can move right, then they can go right one space  on the board. The Player would not be able to move if there was a wall in the way.
	 * @return Returns true if the player can move, else false if the player cannot move.
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
	 * This method moves the player in a random direction. The player can move left,right,up, or down.
	 * @return Returns true if the player can move in the random direction, false if it cannot.
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
	 * This method prints the player's name and health.
	 */
	void printInfo(){
		System.out.println("[Player Information] \nName: " + this.name + "\nHealth: " + this.health + "/100");
	}

	/**This method returns the location of the player to the screen.
	 */
	public void getLocation(){
		System.out.println("Location: " + this.x + "," + this.y);
	}

	/**
	 * This method prints the player's name, health, and strength of the weapon the Player is using. 
	 * @return Returns the player's name, health, and strength.
	 */
	public String toString(){
		return("Player Name: " +  this.name + "\nHealth: " + this.health + "/100" + "\nStrength: " + this.weaponStrength);
	}

	/**
	 * The method prints the information about the Player into a text file to save the game.
	 * @param pw PrintWriter pw types the information into the file.
	 */ 
	 public void persist(PrintWriter pw){
		String file = "Saved";
	        pw.println(file);	
		pw.println(name);
		pw.println(x + " " + y);
		pw.println(health);
		pw.println(inventory.equippedWeapon.getStrength());
		pw.println(inventory.equippedArmor.getStrength());
	}

	/**
	 * This method restores the information from a text file. This information is saved from a previous game and  allows the user to continue the game.
	 * @param a Scanner a reads the file.
	 */
	public void restore (Scanner a){
		try{
			this.name = a.nextLine();
			this.x = a.nextInt();
			this.y = a.nextInt();
			this.health = a.nextInt();
			this.weaponStrength = a.nextInt();
			this.armorStrength = a.nextInt();
		}

		catch(Exception e){
			System.out.println("No file could be found for the player portion.");
		}
	}
}


