import java.util.Scanner;
import java.io.PrintWriter;

class Player extends Characters{
	//Private instance variables.
	private String name;
	private int health;
	private int weaponStrength;
	private int armorStrength;
	private Item equippedWeapon;
	private Item equippedArmor;
	public int x;
	public int y;
	Inventory inventory;
	Player player;
	World world;

	//Constructor
	public Player(String name, int health){
		//super(name);//, health);
		super(name, health); 
		//this.name = name;
		//this.health = health;
		this.weaponStrength = weaponStrength;
		this.armorStrength = armorStrength;
		inventory = new Inventory(275);
		//Player starts in the middle.	
		this.x = 12;
		this.y = 9;
	}
	//Method to get the name of the player.
//	String getName(){
//		return name;//or return name;
//	}
	//Method to get the health of the player.
//	int getHealth(){
//		return this.health;// or return health;
//	}
	//Method to get the equipped armor.
	Item getEquippedArmor(){
		return inventory.getEquippedArmor();
	}
	//Method to get the equipped weapon.
	Item getEquippedWeapon(){
		return inventory.getEquippedWeapon();
	}
	//Method to the the strength of the armor.
	int getArmorStrength(){
		armorStrength = equippedArmor.getStrength();
		return armorStrength;
	}
	//Method to get the strength of the weapon.
	int getWeaponStrength(){
		weaponStrength = equippedWeapon.getStrength();
		return weaponStrength;
	}
	//Method to print the player's location to the user. Will be displayed in the player's information.
	public void getLocation(){
		System.out.println("Location: " + this.y + "," + this.x);
	}
	//Adding the movement method from the world class. This is share the same name in the Enemy class.
	public boolean move(){
		Scanner in = new Scanner(System.in);
		String input = in.next().toUpperCase();
		//Have the player go up.
		if(input.equals("H")){
			if((y - 1) == 0){
				System.out.println("[You can't go up in that direction.]");
				return false;
			}
			else{
				y -= 1;
				return true;
			}
		}
		//Have the player go down.
		else if(input.equals("L")){
			if((y + 1) == 19){
				System.out.println("[You can go left in that direction.]");
				return false;
			}
			else{
				y += 1;
				return true;
			}
		}
		//Have the player go left.
		else if(input.equals("J")){
			if((x - 1) == 0){
				System.out.println("[You can't go left in that direction.]");
				return false;
			}
			else{
				x -= 1;
				return true;
			}
		}
		//Have the player go right.
		else if(input.equals("K")){
			if((x + 1) == 23){
				System.out.println("[You can't go right in that direction.]");
				return false;
			}
			else{
				x += 1;
				return true;
			}
		}/*
		//Print the game commands back to the player.
		else if(input.equals("P")){
			world.printCommands();
		}
		//Have the player drop a item from their inventory.
		else if(input.equals("D")){
			inventory.drop(player);
		}
		//Print the player's inventory to the user.
		else if(input.equals("I")){
			inventory.print();
		}
		//Have the player equip a weapon.
		else if(input.equals("W")){
			inventory.equipWeapon();
		}
		//Have the player equip a piece of armor.
		else if(input.equals("A")){
			inventory.equipArmor();
		}
		//If the player puts "Q," then quit the game.
		else if(input.equals("Q")){
			System.exit(1);
			return false;
		}
		//Else return false on any other command.
		else{
			return false;
		}*/
		return false;
	}
	//This method prints the player's name and health.
	void printInfo(){
		System.out.println("[Player Information] \nName: " + this.name + "\nHealth: " + this.health + "/100");
	}
	public String toString(){
		return("Player Name: " +  this.name + "\nHealth: " + this.health + "/100" + "\nStrength: " + this.weaponStrength);
	}
	//Method for saving the data for the character
	public void persist(PrintWriter pw){
		pw.println(name);
		pw.println(x + " " + y);
		pw.println(health);
		pw.println(weaponStrength);
		pw.println(armorStrength);
		pw.println(equippedWeapon);
		pw.println(equippedArmor);
	}
}
