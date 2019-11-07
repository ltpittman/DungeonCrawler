//Class for Item
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
	//boolean stillOnMap(){
	//	if(){
	//		return true;
	//	}
	//	else{
	//		return false;
	//	}
	//}
	//Method to print out the statements with toString()
	public String toString(){
		return(this.name + ": " + this.weight + ", " + this.value + ", " + this.strength);
	}
}





































