import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**A SideCharacter is a type of character that moves around the board randomly. When the player encounters this character, they are able to get health potions, weapons, and armor from them. The side character has a name and health status. The side character is able to mvoe around the board freely.
 * @author Lauren Pittman, Tavion Britt, Grace Long.
 */

class SideCharacter extends Character{
	//Private instance variables.
	private String name;
	private int health;
	public int x;
	public int y;
	
	/**Constructs a new SideCharacter with a name and health. When the game starts, the side character is placed on a x-coordinate of 3 and a y-coordinate of 23. This will be palced in the upper right corner of the room. 
	 * @param name The name of the SideCharacter.
	 * @param health The health of the SideCharacter.
	 */
	public SideCharacter(String name, int health){
		super(name,health);
		this.name = name;
		this.health = health;
		this.x = 3;
		this.y = 23;

	}

	/**This method returns the char image of the SideCharater.
	 * @return Returns the char image of the side character.
	 */
	public char getCharacterImage(){
		return '&';
	}
	
	/**This method moves the SideCharacter in a random direction.
	 * @return Returns true if the player can move, else returns false if the player comes across a wall or goes out of bounds.
	 */
	public boolean move(){

		Random random = new Random();
		int cc = random.nextInt(4);

		if(cc == 0){
			if(x + 1 == 11){
				return false;
			}
			else{
				x += 1;
				return true;
			}
		}
		else if(cc == 2){
			if(y - 1 == 0){
				return false;
			}
			else{
				y -= 1;
				return true;
			}
		}
		else if(cc == 3){
			if(y + 1 == 29){
				return false;
			}
			else{
				y += 1;
				return true;
			}
		}
		else{
			return false;
		}
	}
	/**This method prints the SideCharacter name.
	 * @return Returns the side character's name.
	 */
	public String toString(){
		return this.name;
	}
	/**This method prints the information about the SideCharacter into a text file to save the game.
	 * @param pw The print writer that types the inforamtion into the file.
	 */
	public void persist(PrintWriter pw){
		pw.println(name);
		pw.println(x + " " + y);
		pw.println(health);
		pw.println(".");
	}
	/**This method restores the information from the text file. This information is saved from a previous game and allows the user to continue the game.
	 * @param a Scanner that reads from the file.
	 */
	public void restore (Scanner a){
		try{
			String noth = a.nextLine();
			this.name = a.nextLine();
			this.x = a.nextInt();
			this.y = a.nextInt();
			this.health = a.nextInt();
			noth = a.nextLine();
			noth = a.nextLine();
		}
		catch(Exception e){
			System.out.println("No file could be found for the side character portion.");
		}
	}
}





