import java.io.FileNotFoundException;
//Class for Item
import java.io.PrintWriter;
import java.util.Scanner;
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
	
	//Create the constructor for the items.
	public Item(ItemType type, String name, int weight, int value, int strength, int x, int y){
		this.type = type;
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.strength = strength;
		this.x = x;
		this.y = y;
	}	
	//Method to get the weight.
	int getWeight(){
		return this.weight;
	}
	//Method to get the value of the item.
	int getValue(){
		return this.value;
	}
	//Method to get the name of the item.
	String getName(){
		return this.name;
	}
	//Method to get the type of the item.
	ItemType getType(){
		return this.type;
	}
	//Method to get the strength of item.
	int getStrength(){
		return this.strength;
	}
	//Method to get the x-coordinate of the player.
	public int getItemX(){
		return this.x;
	}
	//Method to get the y-coordinate of the player.
	public int getItemY(){
		return this.y;
	}
	//Method to print out the statements with toString()
	public String toString(){
		return(this.name + ": " + this.weight + ", " + this.value + ", " + this.strength);
	}
	//To save the data into a file
	public void persist (PrintWriter pw){
		pw.println(type);
		pw.println(name);
		pw.println(weight);
		pw.println(value);
		pw.println(strength);
		pw.println(x);
		pw.println(y);
	}

	public void restore (String fileName){
		try{
			Scanner a = new Scanner(fileName);
			String t = a.nextLine();
			ItemType type = ItemType.valueOf(t);
			int weight = a.nextInt();
			int value = a.nextInt();
			int strength = a.nextInt();
			int x = a.nextInt();
			int y = a.nextInt();
			Item item = new Item (type, name, weight, value, strength, x, y);
		} catch (Exception e){
			System.out.println("Could not find file.");
		
		}}


}





































