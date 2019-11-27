abstract class Character{
	
	private String name;
	private int health;
	public int x;
	public int y;

	//constuctor with basic character qualities
	protected Character(String name, int health){//, int health){
		this.name = name;
		this.health = health;
		this.x = x;
		this.y = y;
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

	//Abstract method to get the character's image for the screen.
	abstract public char getCharacterImage();
	
	//Abtract method to randomly move the player and monster.
	abstract public boolean move();
	
	//Method to get the position of the characters.
	public int getPositionX(){
		return this.x;
	}
	//Method to get the position of the characters.
	public int getPositionY(){
		return this.y;
	}
	public void getLocation(){
		System.out.println("Location: " + getPositionX() + "," + getPositionY());
	}
}

