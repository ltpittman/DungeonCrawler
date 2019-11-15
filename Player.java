import java.util.Scanner;

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

	//Constructor
	public Player(String name, int health){
		super(name, health); 
		this.weaponStrength = weaponStrength;
		this.armorStrength = armorStrength;
		inventory = new Inventory(275);
		//Player starts in the middle.	
		this.x = 17;
		this.y = 8;
	}
	//Method to get the name of the player.
	String getName(){
		return name;
	}
	//Method to get the health of the player.
	int getHealth(){
		return health;
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
	//Method to get he strength of the weapon.
	int getWeaponStrength(){
		weaponStrength = equippedWeapon.getStrength();
		return weaponStrength;
	}
	public void getPlayerLocation(){
		System.out.println("Location: " + this.y + "," + this.x);
	}
	//Method to get the player's y coordinate
	int getPlayerY(){
		return y;
	}
	//Method to get the player's x coordinate
	int getPlayerX(){
		return x;
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
			if((y + 1) == 17){
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
			if((x + 1) == 35){
				System.out.println("[You can't go right in that direction.]");
				return false;
			}
			else{
				x += 1;
				return true;
			}
		}
		else{
			return false;
		}
	}
	//**********************************************************************
	//This method prints the player's name and health.
	void printInfo(){
		System.out.println("[Player Information] \nName: " + this.name + "\nHealth: " + this.health + "/100");
	}
	public String toString(){
		return("Player Name: " +  this.name + "\nHealth: " + this.health + "/100" + "\nStrength: " + this.weaponStrength);
	}
}
