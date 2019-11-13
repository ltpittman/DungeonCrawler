class Player extends Character{
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
		super(name);
		super(health);
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
	//This method prints the player's name and health.
	void printInfo(){
		System.out.println("[Player Information] \nName: " + this.name + "\nHealth: " + this.health + "/100");
	}
	public String toString(){
		return("Player Name: " +  this.name + "\nHealth: " + this.health + "/100" + "\nStrength: " + this.weaponStrength);
	}
}
