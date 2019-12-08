/**
 * Inventory is all the items the player is currently holding. The player starts out with one iron dagger, one leather armor, and a health potion when they start the game. Here the player will be able to add a item to their inventory, drop a item, print their inventory, get their total weight and other stats, equip a weapon or armor, and drink a health potion.
 * @author Lauren Pittman, Tavion Britt, Grace Long
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;

public class Inventory{
	//All instance variables will be private!
	public ArrayList<Item> items;
	private int maxWeight;
	private int health;
	private int strength;
	Item equippedWeapon;
	Item equippedArmor;
	Player player;
	Item item;

	/**Constructs a new Inventory with a iron daggeer, leather armor, and a health potion.
	 * @param maxWeight the total weight that the player can carry in their inventory
	 */
	Inventory(int maxWeight){

		this.maxWeight = maxWeight;
		items = new ArrayList<Item>();

		//The two items that the player will have in their inventory when the game starts.
		Item ironDagger = new Item(ItemType.Weapon, "Iron Dagger", 12, 28, 16, 0, 0, 1);
		items.add(ironDagger);

		Item leatherArmor = new Item(ItemType.Armor, "Leather Armor", 14, 120, 18, 0, 0, 1);
		items.add(leatherArmor);

		Item healthPotion = new Item(ItemType.HealthPotion, "Health Potion", 2, 25, 100, 0, 0, 1);
		items.add(healthPotion);

		//Default armor and weapon.
		equippedWeapon = ironDagger;
		equippedArmor = leatherArmor;
	}

	/**
	 * Returns the max weight of the player.
	 * @return maxWeight
	 */
	int getMaxWeight(){
		return this.maxWeight;
	}

	/**
	 * Prints the total weight/max weight, equipped armor name, and the equipped weapon name.
	 */
	void printInventoryStats(){
		System.out.println("Total Weight: " + getTotalWeight() + "/" + maxWeight + "\nEquipped Armor: " + equippedArmor.getName() + " "  + equippedArmor.getStrength() + "\nEquipped Weapon: " + equippedWeapon.getName() + " " + equippedWeapon.getStrength() + "\nPress 'P' to print the commands again.");
	}

	/**
	 * Determines if an item is in the Inventory. If it is then the item will not be displayed
	 * on the board
	 * @param item checks this particular item in the inventory.
	 * @return returns true if the item is located in the inventory, or false if it is not.
	 */
	public boolean inInventory(Item item){
		if (items.contains(item)){
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds item to the Inventory after checking if the player can carry it.
	 * @param item This particular item is checked for its weight first then added to 
	 * the inventory if it weighs less than the inventory max weight.
	 * @return Returns true if the item is already in the player's inventory, else false 
	 * and adds the item to the player's inventory.
	 */
	public boolean addItem(Item item){
		//Get weight of item you want to add.
		int weightOfNewItem = item.getWeight();
		//Add the new item's weight and the max weight together.
		int itemWeight_and_maxWeight = weightOfNewItem + this.getTotalWeight();
		//If the weight added together is less than the maxWeight, then add it to your inventory. 
		if(itemWeight_and_maxWeight <= maxWeight){
			if(items.contains(item)){
				System.out.println("[Attention!] Already in inventory");
				return true;
			}
			else{
				items.add(item);
				System.out.println("[Inventory Updated] " + item.getName() + " was added to your inventory.");
				return false;
			}
		}
		//Else, if the weight goes over max limit, then don't add the item and tell the user the item cannot be added.
		else{
			System.out.println("[Attention!] Item exeeds weight limit. Item was not added.");
			return false;
		}
	}

	/**
	 * Returns the total weight of the Inventory
	 * @return current weight that the player is carrying.
	 */
	int getTotalWeight(){
		int currentWeight = 0;
		for(int i = 0; i < items.size(); i++){
			currentWeight += items.get(i).getWeight();
		}
		return currentWeight;
	}

	/**
	 * Prints a list of all their items in the Inventory
	 */
	void print(){
		if(items.size() == 0){
			System.out.println("You have no items in your inventory.");
		}

		else{
			int count = 0;
			System.out.println("[Player Inventory]");
			System.out.println("Item Weight Value Strength");
			for(int i = 0; i < items.size(); i++){
				count++;
				System.out.println(count + ". " + items.get(i));
			}
			System.out.println();
		}
	}

	/**
	 * Drops a item from the player's Inventory.
	 * @param player that corresponds to the inventory {@link Player}
	 */
	void drop(Player player){
		//If the user's inventory is empty, then print that they have no items in their inventory.
		if(items.size() == 0){
			System.out.println("You have no items to drop as your inventory is empty.");
		}
		//If the user has items in their inventory, ask them to pick out which item they want to drop.
		else{
			int count = 0;
			System.out.println("[Player Inventory]");
			System.out.println("Item Weight Value Strength");
			//This for-loop prints out the items in a numbered list.
			for(int i = 0; i < items.size(); i++){
				count++;
				System.out.println(count + ". " + items.get(i));
			}
			//Option to cancel.
			count++;
			//Update the count then print out a line that says "#. Cancel."
			System.out.println(count + ". Cancel");

			//Asking the user what they want to drop from their inventory.
			System.out.print("\nWhat item do you want to drop from your inventory?\nAnswer: ");
			Scanner in = new Scanner(System.in);
			//Store the user's answer into this variable.
			int userInput = in.nextInt();
			//While the user's input is not equal to count(or the last number/option), then either break or remove the item from the arrayList.
			while(userInput != count){
				if(userInput == count){
					break;
				}
				//If the user's input is not a valid number, then ask them to enter in a number again.
				else if(userInput > count || userInput < 1){
					System.out.print("Please enter a valid number.\n[Answer] ");
					userInput = in.nextInt();
					continue;
				}
				else{
					//Remove the item by the user's input(userInput - 1, since userInput will be different than the index of the ArrayList).
					Item dropItem = items.get(userInput - 1);
					//Getting the equipped items of the player.
					Item equipItemA = player.getEquippedArmor();
					Item equipItemB = player.getEquippedWeapon();
					//If the player is equipping a item they want to drop, then tell them they have to equip something else first.
					if (dropItem == equipItemA || dropItem == equipItemB){
						System.out.println("[Attention!] You cannot drop an item that you have equipped! You must be able to defend yourself...\nIf you do not have another item to equip, look for items around the area.");
					}	
					else {
						items.remove(userInput - 1);
					}
					break;
				}
			}

		}
	}

	/**
	 * Equips weapon from the Inventory for the player to use in a battle. A player will look at the 
	 * strength of the weapons to decide which is suitable for battle.
	 */
	void equipWeapon(){
		//Create a new arrayList to hold the items that are classified as weapons.
		ArrayList<Item> weapons = new ArrayList<Item>();

		int count = 0;
		//This for-loop reads over the items in the inventory and stores the weapons into the weapons arrayList.
		//Then the items that are classified as weapons is printed to the user. The user will then pick a weapon to equip.
		System.out.println("[Player Inventory]");
		System.out.println("Item Weight Value Strength");
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getType() == ItemType.Weapon){
				count++;
				//Add to the arrayList.
				weapons.add(items.get(i));
				System.out.println(count + ". " + items.get(i));
			}
		}
		//Option to cancel.
		count++;
		//Update the count then print out a line that says "#. Cancel."
		System.out.println(count + ". Cancel");

		Scanner in = new Scanner(System.in);
		//Asking the user what weapon they want to equip.
		System.out.print("\nWhich weapon do you want to equip? \n[Answer] ");

		//Store the user's answer into this variable.
		int userInput = in.nextInt();
		//While the user's input is not equal to count(or the last number/option), then either break or store the user's answer in the equippedWeapon isntance variable.
		while(userInput != count){
			if(userInput == count){
				break;
			}
			//If the user's input is not a valid number, then ask them to enter in a number again.
			else if(userInput > count || userInput < 1){
				System.out.print("Please enter a valid number.\n[Answer] ");
				userInput = in.nextInt();	
				continue;
			}
			else{
				//Index is offset by one with the count in the for-loop, hence the (userInput -1). 
				//By doing the -1, you take off the last(empty) space in the arrayList so you can't access it.
				equippedWeapon = weapons.get(userInput - 1);
				System.out.println("[You are currently equipping]: " + equippedWeapon.getName() + "\n");
				break;
			}
		}
	}
	/**
	 * Equips an armor from the Inventory for the player to use in an attack. A player will
	 * look at the strength of the armor to determine which is suitable. 
	 */
	void equipArmor(){
		//Create a new arrayList to hold the items that are classified as armor.
		ArrayList<Item> armor = new ArrayList<Item>();

		int count = 0;
		//This for-loop reads over the items in the inventory and stores the armors into the armor arrayList.
		//Then the items that are classifed as armor is printed to the user. The user will then pick one armor to wear.
		System.out.println("[Player Inventory]");
		System.out.println("Item Weight Value Strength");
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getType() == ItemType.Armor){
				count++;
				//Add to the arrayList.
				armor.add(items.get(i));
				System.out.println(count + ". " + items.get(i));
			}
		}
		//Option to cancel.
		count++;
		//Update the count then print out a line that says "#. Cancel."
		System.out.println(count + ". Cancel");

		Scanner in = new Scanner(System.in);
		//Asking the user what peice of armor they want to wear.
		System.out.print("\nWhich piece of armor do you want to wear? \n[Answer] ");

		//Store the user's answer into this variable.
		int userInput = in.nextInt();

		//While the user's input is not equal to count(or the last number/option), then either break or store the user's answer in the equippedArmor isntance variable.
		while(userInput != count){
			if(userInput == count){
				break;
			}
			//If the user's input is not a valid number, then ask them to enter in a number again.
			else if(userInput > count || userInput < 1){
				System.out.print("Please enter a valid number.\n[Answer] ");
				userInput = in.nextInt();
				continue;
			}
			else{
				//Index is offset by one with the count in the for-loop, hence the (userInput -1). 
				//By doing the -1, you take off the last(empty) space in the arrayList so you can't access it.
				equippedArmor = armor.get(userInput - 1);
				System.out.println("[You are currently wearing]: " + equippedArmor.getName() + "\n");
				break;
			}
		}
	}

	/**
	 * Drinks the health potion in the player's Inventory. The health potion give the player more
	 * strength to fight the enemies on the board. 
	 */
	void drinkHealthPotion(){

		int count = 0;
		System.out.println("[Player Inventory]");
		System.out.println("Name Weight Value Strength");
		for(int i = 0; i < items.size(); i++){
			count++;
			System.out.println(count + ". " + items.get(i));
		}
		count++;
		System.out.println(count + ". Cancel\n");

		System.out.print("Which health potion do you want to drink?\n[Answer] ");
		Scanner in = new Scanner(System.in);
		int userInput = in.nextInt();

		while(userInput != count){
			if(userInput == count){
				break;
			}
			else if(userInput > count || userInput < 1){
				System.out.println("Please enter a valid number.\n[Answer] ");
				userInput = in.nextInt();
				continue;
			}
			else{
				items.remove(userInput - 1);
				System.out.println("[Health Restored] You drink the health potion and restore your health...");
				break;
			}
		}
	}

	/**
	 * Returns the current equipped armor of the player.
	 * @return the armor the player has on
	 */
	Item getEquippedArmor(){
		return this.equippedArmor;
	}

	/** 
	 * Returns the current equipped weapon of the player.
	 * @return the weapon the player is holding
	 */
	Item getEquippedWeapon(){
		return this.equippedWeapon;
	}

	/**
	 * Saves the informaiton from the Inventory into a file to save the game.
	 * @param pw  print writer that will type the information into the file 
	 */
	//Method to save the game into a file.
	public void persist(PrintWriter pw){
		pw.println(equippedWeapon.getType());
		pw.println(equippedWeapon.getName());
		pw.println(equippedWeapon.getWeight());
		pw.println(equippedWeapon.getValue());
		pw.println(equippedWeapon.getStrength());
		pw.println(equippedWeapon.getItemX());
		pw.println(equippedWeapon.getItemY());
		pw.println(equippedWeapon.getRoomNum());

		pw.println(equippedArmor.getType());
		pw.println(equippedArmor.getName());
		pw.println(equippedArmor.getWeight());
		pw.println(equippedArmor.getValue());
		pw.println(equippedArmor.getStrength());
		pw.println(equippedArmor.getItemX());
		pw.println(equippedArmor.getItemY());
		pw.println(equippedArmor.getRoomNum());
				
		pw.println("Inventory");
		for(Item i : items){
			i.persist(pw);
		}
		pw.println("-");
		pw.println("nothing");


	}

	/**
	 * Restores information from a file to create a new Inventory that consists of items saved
	 *  from a previous game
	 * @param a scanner that will read the information from a file
	 */
	public void restore (Scanner a){
		try{
			String typeItem = a.nextLine();
			ItemType type = ItemType.valueOf(typeItem);
			String name = a.nextLine();
			int weight = a.nextInt();
			int value = a.nextInt();
			int stren = a.nextInt();
			int x = a.nextInt();
			int y = a.nextInt();
			int roomNum = a.nextInt();
			String blank = a.nextLine();
			Item w = new Item (type, name, weight, value, stren, x, y, roomNum);
			this.equippedWeapon = w;

			String typeItemB = a.nextLine();
			ItemType typeB = ItemType.valueOf(typeItemB);
			String nameB = a.nextLine();
			int weightB = a.nextInt();
			int valueB = a.nextInt();
			int strenB = a.nextInt();
			int xB = a.nextInt();
			int yB = a.nextInt();
			int roomNumB = a.nextInt();
			blank = a.nextLine();
			Item r = new Item (typeB, nameB, weightB, valueB, strenB, xB, yB, roomNumB);
			this.equippedArmor = r;
			
			
			this.items.clear();
			String noth = a.nextLine();
			String t = a.nextLine();
			ItemType typeC = ItemType.valueOf(t);
			String nameC = a.nextLine();
			int weightC = a.nextInt();
			int valueC = a.nextInt();
			int strengthC = a.nextInt();
			int xC = a.nextInt();
			int yC = a.nextInt();
			int roomNumC = a.nextInt(); //added this
			Item item = new Item (typeC, nameC, weightC, valueC, strengthC, xC, yC, roomNumC); //added the end "roomNum"
			this.items.add(item); 
			noth = a.nextLine();
			noth = a.nextLine();
			while(a.hasNext()){
				t = a.nextLine();
				if(!t.equals("-")){
					type = ItemType.valueOf(t);
					name = a.nextLine();
					weight = a.nextInt();
					value = a.nextInt();
					strength = a.nextInt();
					x = a.nextInt();
					y = a.nextInt();
					roomNum = a.nextInt(); // added this
					noth = a.nextLine();
					noth = a.nextLine();
					Item item1 = new Item (type, name, weight, value, strength, x, y, roomNum); //added the end "roomNum"
					this.items.add(item1);
				} 
				else if(t.equals("-")){
					noth = a.nextLine();
					break;
				}
			}
		} catch (Exception e){
			System.out.println("Could not read inventory portion of file.");
		}
	}

}

