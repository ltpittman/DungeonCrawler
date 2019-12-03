/**
 *This is an abstract class of all the characters in the game. 
 * @author Lauren Pittman, Tavion Britt, Grace Long
 */

abstract class Character{
	
	private String name;
	private int health;
	public int x;
	public int y;

	/**
	 * This is a constuctor with basic character qualities
	 * @param name The name of the character
	 * @param health The health of the character
	 */ 
	protected Character(String name, int health){
		this.name = name;
		this.health = health;
		this.x = x;
		this.y = y;
	}
	//If the character class shares any methods inside of the player or enemy class,
	//then only the character class needs the methods.
	
	/**
	 * This method gets the Name of the character
	 * @return String The name of the character
	 */
	String getName(){
		return this.name;
	}

	/**
	 * This method gets the Health of the character
	 * @return int The health of the character
	 */
	int getHealth(){
		return this.health;
	}

	/**
	 * This method sets the health of the character
	 * @param num the health
	 */
	public void setHealth(int num){
		this.health = num;
	}

	/**
	 * Abstract method to get the character's image for the screen.
	 * @return char The image that represents the character on the board
	 */ 
	abstract public char getCharacterImage();
	
	/**
	 * Abtract method to randomly move the player and monster.
	 * @return boolean 
	 */
	abstract public boolean move();
	
	/**Method to get the position of the characters.
	 * @return int the x coordinate of the character
	 */
	public int getPositionX(){
		return this.x;
	}

	/**
	 * Method to get the position of the characters.
	 * @return int the y coordinate of the character
	 */ 
	public int getPositionY(){
		return this.y;
	}

	/**
	 * Method to print the information about the location of the character
	 */
	public void getLocation(){
		System.out.println("Location: " + getPositionX() + "," + getPositionY());
	}
}

