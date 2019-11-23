import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

class Player extends Character{// throws FileNotFoundException{
	//Private instance variables.
	private String name;
	private int health;
	private int weaponStrength;
	private int armorStrength;
	private Item equippedWeapon;
	private Item equippedArmor;
	Inventory inventory;
	public World world;
	public int x;
	public int y;

	//Constructor
	public Player(String name, int health){
		super(name, health); 
		this.name = name;
		this.health = health;
		this.weaponStrength = weaponStrength;
		this.armorStrength = armorStrength;
		inventory = new Inventory(275);
		//Player starts in the middle.	
		this.x = 9;
		this.y = 9;
	}
	//Method to get the name of the player.
	String getName(){
		return this.name;
	}
	//Method to get the health of the player.
	int getHealth(){
		return this.health;
	}
	//Method to set the health of the player.
	public void setHealth(int num){
		this.health = num;
	}
	public char getCharacterImage(){
		return '@';
	}
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
	//Method to get the x-coordinate.
	public int getPositionX(){
		return this.x;
	}
	//Method to get the y-coordinate.
	public int getPositionY(){
		return this.y;
	}
	//Method to move the player up.
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
	//Method to move the player down.
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
	//Method to move the player left.
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
	//Method to move the player right.
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
		pw.println(x + "," + y);
		pw.println(health);
		pw.println(weaponStrength);
		pw.println(armorStrength);
		pw.println(equippedWeapon.getName());
		pw.println(equippedWeapon.getWeight());
		pw.println(equippedWeapon.getValue());
		pw.println(equippedWeapon.getStrength());
		pw.println(equippedWeapon.getItemX());
		pw.println(equippedWeapon.getItemY());
		pw.println(equippedArmor.getName());
		pw.println(equippedArmor.getWeight());
		pw.println(equippedArmor.getValue());
		pw.println(equippedArmor.getStrength());
		pw.println(equippedArmor.getItemX());
		pw.println(equippedArmor.getItemY());
		pw.println(".");
	}

	public void restore (String fileName){
		try{
			Scanner a = new Scanner(fileName);
			this.name = a.nextLine();
			this.x = a.nextInt();
			this.y = a.nextInt();
			this.health = a.nextInt();
			this.weaponStrength = a.nextInt();
			this.armorStrength = a.nextInt();
			String typeItem = a.nextLine();
			ItemType type = ItemType.valueOf(typeItem);
			String name = a.nextLine();
			int weight = a.nextInt();
			int value = a.nextInt();
			int stren = a.nextInt();
			int x = a.nextInt();
			int y = a.nextInt();
			this.equippedWeapon = new Item(type, name, weight, value, stren, x, y);
			String typeitemB = a.nextLine();
			ItemType typeB = ItemType.valueOf(typeitemB);
			String nameB = a.nextLine();
			int weightB = a.nextInt();
			int valueB = a.nextInt();
			int strenB = a.nextInt();
			int xB = a.nextInt();
			int yB = a.nextInt();
			this.equippedArmor = new Item(typeB, nameB, weightB, valueB, strenB, xB, yB);
		}
		catch(Exception e){
			System.out.println("Could not find file.");
		}
	}
}

