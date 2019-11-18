import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;

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
	//public String characterImage(){
	//	return "@";
	//}
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
	public int getPositionX(){
		return this.x;
	}
	public int getPositionY(){
		return this.y;
	}
	//Method to move the player up. Make this into only one method?
	public boolean goUp(){
		if((y - 1) == 0){
			System.out.println("[You can't go up in that direction anymore.]");
			return false;
		}
		else{
			y -= 1;
			return true;
		}
	}
	public boolean goDown(){
		if((y + 1) == 17){
			System.out.println("[You can't go down in that direction anymore.]");
			return false;
		}
		else{
			y += 1;
			return true;
		}	
	}
	public boolean goLeft(){
		if((x - 1) == 0){
			System.out.println("[You can't go left in that direction anymore.]");
			return false;
		}
		else{
			x -= 1;
			return true;
		}
	}
	public boolean goRight(){
		if((x + 1) == 19){
			System.out.println("[You can't go right in that direction anymore.]");
			return false;
		}
		else{
			x += 1;
			return true;
		}
	}
	//Take out?
	public boolean move(){
		return false;
	}
	/*
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
if(input.equals("L")){
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
if(input.equals("J")){
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
if(input.equals("K")){
if((x + 1) == 19){
System.out.println("[You can't go right in that direction.]");
return false;
}
else{
x += 1;
return true;
}
}
return false;
}*/
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
	pw.println(".");
}
/*
   public void restore (String fileName){
   Scanner a = new Scanner(new FileReader(fileName)){
   this.name = a.nextLine();
   this.x = a.nextInt();
   this.y = a.nextInt();
   this.health = a.nextInt();
   this.weaponStrength = a.nextInt();
   this.armorStrength = a.nextInt();
//this.equippedWeapon = a.next();
//this.equippedArmor = a.next();
   }
   }*/
}
