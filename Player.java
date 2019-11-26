import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Player extends Character{// throws FileNotFoundException{
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

	//Constructor
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
		String file = "Saved";
	        pw.println(file);	
		pw.println(name);
		pw.println(x + " " + y);
		pw.println(health);
		//pw.println(weaponStrength);
		//pw.println(armorStrength);
		pw.println(inventory.equippedWeapon.getStrength());
		pw.println(inventory.equippedArmor.getStrength());

		pw.println(inventory.equippedWeapon.getType());
		pw.println(inventory.equippedWeapon.getName());
		pw.println(inventory.equippedWeapon.getWeight());
		pw.println(inventory.equippedWeapon.getValue());
		pw.println(inventory.equippedWeapon.getStrength());
		pw.println(inventory.equippedWeapon.getItemX());
		pw.println(inventory.equippedWeapon.getItemY());

		pw.println(inventory.equippedArmor.getType());
		pw.println(inventory.equippedArmor.getName());
		pw.println(inventory.equippedArmor.getWeight());
		pw.println(inventory.equippedArmor.getValue());
		pw.println(inventory.equippedArmor.getStrength());
		pw.println(inventory.equippedArmor.getItemX());
		pw.println(inventory.equippedArmor.getItemY());
		pw.println(".");
	}

	public void restore (Scanner a){
		try{
			//FileInputStream f = new FileInputStream(fileName);
			//Scanner a = new Scanner(f);
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
			blank = a.nextLine();
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
			System.out.println("No file could be found for the player portion.");
		}
	}
}

