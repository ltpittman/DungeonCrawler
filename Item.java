/**
 * A Item is a object on the board that helps the player in some way. The Item has a name, weight, value, strength, and x/ y coordinates. When moving around the board the player is able to pick up the item and add it their inventory to use. {@link Inventory} {@link World}
 * @author Lauren Pittman, Tavion Britt, Grace Long
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileReader;

public class Item{
	//Instance variables.
	private ItemType type;
	private String name;
	private int weight;
	private int value;
	private int strength;
	public int x;
	public int y;
	public int roomNum;
	
	/** 
	 * Constructs an Item with a type, name, weight, value, strength, x, y coordinates that are taken 
	 * in as parameters
	 * @param type Either a weapon, armor, health potion, or other. 
	 * @param name The name of the object.
	 * @param weight The weight of the object. used in calculating the max weight of the inventory
	 * @param value The value of the object.
	 * @param strength The strength of the object. used in a battle against an enemy
	 * @param x The x coordinate of the object (where it will be placed on the map).
	 * @param y The y coordinate of the object (where it will be placed on the map).
	 * @param roomNum The room number that the item is assigned to
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
	
	/**This method sets the room number that the item is in. The item will be in either room 1,2 or 3.
	 * @param roomNum Sets the room number as either 1, 2, or 3.
	 */
	public void setRoomNum(int roomNum){
		this.roomNum = roomNum;
	}

	/**This method returns the room number that the item is in.
	 * @return Returns the room number.
	 */
	public int getRoomNum(){
		return this.roomNum;
	}

	/**
	 * This method returns the weight of the Item. Used when calculating the max weight of the Inventory {@link Inventory}
	 * @return Returns the weight of the item .
	 */
	int getWeight(){
		return this.weight;
	}

	/**
	 * This method returns the value of the Item.
	 * @return Returns the value of the item.
	 */
	int getValue(){
		return this.value;
	}

	/**
	 * This method returns the name of the Item.
	 * @return Returns the name of the item.
	 */
	String getName(){
		return this.name;
	}

	/**
	 * This method returns the type of the Item. There are four types of items: Weapon, Armor,  Health Potion, and Other.
	 * @return Returns type of the item (weapon, armor, health potion, or other).
	 */
	ItemType getType(){
		return this.type;
	}

	/**
	 * This method returns the strength of Item. This is used in a battle when a player is attacking an enemy and  using its equipped weapon or armor. {@link Battles}
	 * @return Returns the strength of the item.
	 */
	int getStrength(){
		return this.strength;
	}

	/**
	 * This method returns the x-coordinate of the Item.
	 * @return Returns the x-coordinate of the item.
	 */
	public int getItemX(){
		return this.x;
	}

	/**
	 * This method returns the y-coordinate of the Item.
	 * @return Returns the y-coordinate of the item.
	 */
	public int getItemY(){
		return this.y;
	}

	/**
	 * This method returns the symbol to represent the Item on the board.
	 * @return Returns item's char image.
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
	 * This method returns the infomation about the Item.
	 * @return Returns the item's name, wright, value, and strength.
	 */
	public String toString(){
		return(this.name + ": " + this.weight + ", " + this.value + ", " + this.strength);
	}

	/**
	 * This method saves the information about the Item in a file.
	 * @param pw Printwriter pw will type the informatin into a file.
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
	 * This method restores the information in a file that is saved from a previous game.
	 * @param a Scanner a will read the information from a file.
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
			this.roomNum = a.nextInt();
			String noth = a.nextLine();
		} 
		catch (Exception e){
			System.out.println("Could not read item portion of file");
		} 
		
	}


}

