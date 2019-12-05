/**
 * A <tt>Item</tt> is a object on the board that helps the player in some way. The <tt>Item</tt> has a name, 
 * weight, value, strength, and x/ y coordinates. When moving around the board the player is able to pick 
 * up the item and add it their inventory to use. {@link Inventory} {@link World}
 * @author Lauren Pittman, Tavion Britt, Grace Long
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
	public int roomNum;
	
	/** 
	 * Constructs an <tt>Item</tt> with a type, name, weight, value, strength, x, y coordinates that are taken 
	 * in as parameters
	 * @param type either a weapon, armor, health potion, or other. 
	 * @param name name of the object.
	 * @param weight weight of the object. used in calculating the max weight of the inventory
	 * @param value value of the object.
	 * @param strength strength of the object. used in a battle against an enemy
	 * @param x x coordinate of the object (where it will be placed on the map).
	 * @param y y coordinate of the object (where it will be placed on the map).
	 */
	public Item(ItemType type, String name, int weight, int value, int strength, int x, int y, int roomNum){
		this.type = type;
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.strength = strength;
		this.x = x;
		this.y = y;
		this.roomNum = roomNum;
	}
	
	/**Sets the room number that the item is in.
	 * @return The room number.
	 */
	public void setRoomNum(int roomNum){
		this.roomNum = roomNum;
	}

	/**Returns the room number that the enemy is in.
	 * @return The room number.
	 */
	public int getRoomNum(){
		return this.roomNum;
	}

	/**
	 * Returns the weight of the <tt>Item</tt>. Used when calculating the max weight of the Inventory {@link Inventory}
	 * @return weight of the item 
	 */
	int getWeight(){
		return this.weight;
	}

	/**
	 * Returns the value of the <tt>Item</tt>.
	 * @return value of the item.
	 */
	int getValue(){
		return this.value;
	}

	/**
	 * Returns the name of the <tt>Item</tt>.
	 * @return name of the item.
	 */
	String getName(){
		return this.name;
	}

	/**
	 * Returns the type of the <tt>Item</tt>. There are four types of items: Weapon, Armor, 
	 * Health Potion, and Other
	 * @return type of the item (weapon, armor, health potion, or other)
	 */
	ItemType getType(){
		return this.type;
	}

	/**
	 * Returns the strength of <tt>Item</tt>. This is used in a battle when a player is attacking an enemy and 
	 * using its equipped weapon or armor. {@link Battles}
	 * @return strength of the item.
	 */
	int getStrength(){
		return this.strength;
	}

	/**
	 * Returns the x-coordinate of the <tt>Item</tt>.
	 * @return x-coordinate of the item.
	 */
	public int getItemX(){
		return this.x;
	}

	/**
	 * Returns the y-coordinate of the <tt>Item</tt>.
	 * @return y-coordinate of the item.
	 */
	public int getItemY(){
		return this.y;
	}

	/**
	 * Returns the symbol to represent the <tt>Item</tt> on the board
	 * @return item's char image.
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

	/** 
	 * Return the infomation about the <tt>Item</tt>
	 * @return itmes name, wright, value, and strength
	 */
	public String toString(){
		return(this.name + ": " + this.weight + ", " + this.value + ", " + this.strength);
	}

	/**
	 * Saves the information about the <tt>Item</tt> in a file
	 * @param pw printwriter that will type the informatin into a file
	 */
	public void persist (PrintWriter pw){
		pw.println(type);
		pw.println(name);
		pw.println(weight);
		pw.println(value);
		pw.println(strength);
		pw.println(x);
		pw.println(y);
		pw.println(roomNum);
		pw.println(".");
	}

	/**
	 * Restores the information in a file that is saved from a previous game.
	 * @param a scanner that will read the information from a file
	 */
	public void restore (Scanner a){
		try{
			String t = a.nextLine();
			ItemType type = ItemType.valueOf(t);
			this.type = type;
			this.name = a.nextLine();
			this.weight = a.nextInt();
			this.value = a.nextInt();
			this.strength = a.nextInt();
			this.x = a.nextInt();
			this.y = a.nextInt();
			this.roomNum = a.nextInt(); //added this
			String noth = a.nextLine();
		} 
		catch (Exception e){
			System.out.println("Could not read item portion of file");
		} 
		
	}


}

