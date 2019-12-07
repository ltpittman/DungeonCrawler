/**
 * <tt>Character</tt> represents an individual on the game board. Each Character object  * has a name, health, strength, and location.   
 * @author Lauren Pittman, Tavion Britt, Grace Long
 */

public abstract class Character{
	
	private String name;
	private int health;
	public int x;
	public int y;

	/**
	 * Constucts a new Character object with a name, health, and location
	 * @param name the name of the character
	 * @param health the health of the character (out of 100 pts)
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
	 * Returns the name of the Character
	 * @return String the name of the character
	 */
	String getName(){
		return this.name;
	}

	/**
	 * Returns the health of the Character. 
	 * @return int the health of the character
	 */
	int getHealth(){
		return this.health;
	}

	/**
	 * Sets the health of the Character. 
	 * @param num the health
	 */
	public void setHealth(int num){
		this.health = num;
	}

	/**
	 * Abstract method to get the character's image for the screen.
	 * @return char the symbol that represents the character on the board
	 */ 
	abstract public char getCharacterImage();
	
	/**
	 * Abtract method to randomly move the player and monster.
	 * @return boolean 
	 */
	abstract public boolean move();
	
	/**
	 * Returns the position(x coordinate) of the Character on the board
	 * @return int the x coordinate of the character
	 */
	public int getPositionX(){
		return this.x;
	}

	/**
	 * Returns the position(y coordinate) of the Character on the board
	 * @return int the y coordinate of the character
	 */ 
	public int getPositionY(){
		return this.y;
	}
}

