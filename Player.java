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
		super(name, health); //this.name = name;
	//	this.health = health;
		this.weaponStrength = weaponStrength;
		this.armorStrength = armorStrength;
		inventory = new Inventory(275);
		//Player starts in the middle.	
		this.x = 17;
		this.y = 8;
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
	//Get the position from the X-axis for the player. *getter method*
	public int getPlayerX(){
		return this.x;
	}
	//Get the position from the Y-axis for the player. *getter method*
	public int getPlayerY(){
		return this.y;
	}
	public void getPlayerLocation(){
		System.out.println("Location: " + getPlayerY() + "," + getPlayerX());
	}
	//Adding the movment method from the world class. This is share the same name in the Enemy class.
	public boolean move(Player player){
		//Have the player go up.
		if((player.y - 1) == 0){
			System.out.println("[You can't go up in that direction.]");
			return false;
		}
		else{
			player.y -= 1;
		}
		//Have the player go down.
		if((player.y + 1) == 17){
			System.out.println("[You can go left in that direction.]");
			return false;
		}
		else{
			player.y += 1;
			return true;
		}
		//Have the player go left.
		if((player.x - 1) == 0){
			System.out.println("[You can't go left in that direction.]");
			return false;
		}
		else{
			player.x -= 1;
			return true;
		}
		//Have the player go right.
		if((player.x + 1) == 35){
			System.out.println("[You can't go right in that direction.]");
			return false;
		}
		else{
			player.x += 1;
			return true;
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
