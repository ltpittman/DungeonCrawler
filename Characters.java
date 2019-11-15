abstract class Characters{
	
	private String name;
	private int health;
	public int x;
	public int y;
//	Inventory inventory;
//	private int weaponStrength;
//	private int armorStrength;
//	private Item equippedWeapon;
//	private Item equippedArmor;

	//constuctor with basic character qualities
	protected Characters(String name, int health){
		this.name = name;
		this.health = health;
	}
	//If the character class shares any methods inside of the player or enemy class,
	//then only the character class needs the methods.
	String getName(){
		return this.name;
	}
	int getHealth(){
		return this.health;
	}
	public void setHealth(int num){
		this.health = num;
	}
	//Abstract method to move both the player and the enemy.
	abstract public boolean move();
	
	//Method to get the position of the characters.
	public int getPostionX(){
		return this.x;
	}
	//Method to get the position of the characters.
	public int getPositionY(){
		return this.y;
	}
	public void getLocation(){
		System.out.println("Location: " + getPostionX() + "," + getPositionY());
	}
}

