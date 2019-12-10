/**
 * Character represents an individual on the game board. Each Character object has a name, health, strength, image, and location.   
 * @author Lauren Pittman, Tavion Britt, Grace Long
 */

public abstract class Character{
	
	private String name;
	private int health;
	private int x;
	private int y;

	/**
	 * Constucts a new Character object with a name, health, and location.
	 * @param name The name of the character.
	 * @param health The health of the character (out of 100 pts).
	 */ 
	protected Character(String name, int health){
		this.name = name;
		this.health = health;
		this.x = x;
		this.y = y;
	}
	//If the character class shares any methods inside of the player or enemy class, then only the character class needs the methods.
	
	/**
	 * Returns the name of the Character
	 * @return Returns the name of a character.
	 */
	String getName(){
		return this.name;
	}

	/**
	 * Returns the health of the Character. 
	 * @return Returns the health of a character.
	 */
	int getHealth(){
		return this.health;
	}

	/**
	 * Sets the health of the Character. 
	 * @param num Setting the health to a specific number.
	 */
	public void setHealth(int num){
		this.health = num;
	}

	/**
	 * This Abstract method is used to get the character's image for the screen.
	 * @return Returns the char the symbol that represents the character on the board.
	 */ 
	abstract public char getCharacterImage();
	
	/**
	 * This Abtract method randomly moves the player, side character, and monsters.
	 * @return Returns a boolean.
	 */
	abstract public boolean move();
	
}

