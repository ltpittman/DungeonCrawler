/**This class is used to set up the foundation of a item object. It creates a Item with a name, weight, value, strength, and x/ y coordinates. If creating a a object, this class will be needed or it will not work.
 * @author Lauren Pittman, Tavion Britt, Grace Long.
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileReader;

class Item{
	//Create the instance variables.
	private ItemType type;
	private String name;
	private int weight;
	private int value;
	private int strength;
	public int x;
	public int y;
	
	/** This is the constructor for the item objects. The Item takes in the type, name, weight, value, strength, x, y coordinates when creating a object.
	 * @param type Type includes either a weapon, armor, health potion, or other. 
	 * @param name The name of the object.
	 * @param weight The weight of the object.
	 * @param value The value of the object.
	 * @param strength The strength of the object.
	 * @param x The x coordinate of the object (where it will be placed on the map).
	 * @param y The y coordinate of the object (where it will be placed on the map).
	 */
	public Item(ItemType type, String name, int weight, int value, int strength, int x, int y){
		this.type = type;
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.strength = strength;
		this.x = x;
		this.y = y;
	}	
	/**This method is used to get the weight of the item.
	 * @return Returns this.weight of the item.
	 */
	int getWeight(){
		return this.weight;
	}
	/**This method is used to get the value of the item.
	 * @return Returns this.value of the item.
	 */
	int getValue(){
		return this.value;
	}
	/**This method is used to get the name of the item.
	 * @return Returns this.name of the item.
	 */
	String getName(){
		return this.name;
	}
	/**This method is used to get the type of the item.
	 * @return Returns this.type of the item type (Weapon, Armor, Health Potion, Other).
	 */
	ItemType getType(){
		return this.type;
	}
	/**This method is used to get the strength of item.
	 * @return Returns this.strength of the item.
	 */
	int getStrength(){
		return this.strength;
	}
	/**This method is used to get the x-coordinate of the item.
	 * @return Returns the x-coordinate of the item.
	 */
	public int getItemX(){
		return this.x;
	}
	/**This method is used to get the x-coordinate of the item.
	 * @return Returns the y-coordinate of the item.
	 */
	public int getItemY(){
		return this.y;
	}
	/**This method is return to get the item's image.
	 *@return Returns the item's char image.
	 */
	public char getItemImage(){
		if(type == ItemType.HealthPotion){
			return 'H';
		}
		else if(type == ItemType.Key){
			return 'K';
		}
		else{
		
			return '$';
		}
	}
	/** This method is used to print out the statements with toString().
	 * @return Returns the toString statement.
	 */
	public String toString(){
		return(this.name + ": " + this.weight + ", " + this.value + ", " + this.strength);
	}
	/**This method is used to save the data into a file.
	 */
	public void persist (PrintWriter pw){
		pw.println(type);
		pw.println(name);
		pw.println(weight);
		pw.println(value);
		pw.println(strength);
		pw.println(x);
		pw.println(y);
		pw.println(".");
	}
	/**This method is used to restore the data to the game.
	 */
	public void restore (Scanner a){
		try{
			String noth = a.nextLine();
			String t = a.nextLine();
			ItemType type = ItemType.valueOf(t);
			this.type = type;
			this.name = a.nextLine();
			this.weight = a.nextInt();
			this.value = a.nextInt();
			this.strength = a.nextInt();
			this.x = a.nextInt();
			this.y = a.nextInt();
		} 
		catch (Exception e){
			System.out.println("Could not read item portion of file");
		} 
		
	}


}





































