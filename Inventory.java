import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

class Inventory{
	//All instance variables will be private!
	public ArrayList<Item> items;
	private int maxWeight;
	private int health;
	private int strength;
	private Item equippedWeapon;
	private Item equippedArmor;
	Player player;
	Item item;

	//Method for the maxWeight/inventory.
	Inventory(int maxWeight){

		this.maxWeight = maxWeight;
		items = new ArrayList<Item>();

		//The two items that the player will have in their inventory when the game starts.
		Item ironDagger = new Item(ItemType.Weapon, "Iron Dagger", 12, 28, 16, 0, 0);
		items.add(ironDagger);

		Item leatherArmor = new Item(ItemType.Armor, "Leather Armor", 14, 120, 18, 0, 0);
		items.add(leatherArmor);

		//Default armor and weapon.
		equippedArmor = leatherArmor;
		equippedWeapon = ironDagger;
	}

	//This method prints the total weight/max weight, equipped armor name, and the equipped weapon name.
	void printOtherStats(){
		System.out.println("Total Weight: " + totalWeight() + "/" + maxWeight + "\nEquipped Armor: " + equippedArmor.getName() + " "  + equippedArmor.getStrength() + "\nEquipped Weapon: " + equippedWeapon.getName() + " " + equippedWeapon.getStrength() + "\nPress 'P' to print the commands again.");
	}

	//Method to add a item.
	public boolean addItem(Item item){
		//Get weight of item you want to add.
		int weightOfNewItem = item.getWeight();
		//Add the new item's weight and the max weight together.
		int itemWeight_and_maxWeight = weightOfNewItem + this.totalWeight();
		//If the weight added together is less than the maxWeight, then add it to your inventory. 
		if(itemWeight_and_maxWeight <= maxWeight){
			if(items.contains(item)){
				System.out.println("[Attention!] Already in inventory");
				return true;
			}
			else{
				items.add(item);
				System.out.println(item.getName() + " was added to your inventory.");
				return false;
			}
		}
		//Else, if the weight goes over max limit, then don't add the item and tell the user the item cannot be added.
		else{
			System.out.println("[Attention!] Item exeeds weight limit. Item was not added.");
			return false;
		}
	}


	//Method to get the total weight of the player.
	int totalWeight(){
		int currentWeight = 0;
		for(int i = 0; i < items.size(); i++){
			currentWeight += items.get(i).getWeight();
		}
		return currentWeight;
	}
	//Method to present the player a list of all their items in inventory.
	void print(){
		if(items.size() == 0){
			System.out.println("You have no items in your inventory.");
		}

		else{
			int count = 0;
			System.out.println("\nInventory:");
			System.out.println("Item Weight Value Strength");
			for(int i = 0; i < items.size(); i++){
				count++;
				System.out.println(count + ". " + items.get(i));
			}
			System.out.println();
		}
	}	
	//Method to drop a item.
	void drop(Player player){
		//If the user's inventory is empty, then print that they have no items in their inventory.
		if(items.size() == 0){
			System.out.println("You have no items to drop as your inventory is empty.");
		}
		//If the user has items in their inventory, ask them to pick out which item they want to drop.
		else{
			int count = 0;
			System.out.println("\nInventory:");
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
			System.out.print("[Attention!] If you drop a item from your inventory, it will be destroyed. Continue with option? Y/N ");

			Scanner in = new Scanner(System.in);

			String answer = in.next().toUpperCase();

			if(answer.equals("Y")){
				System.out.print("\nWhat item do you want to drop from your inventory?\nAnswer: ");
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
						} else {
							items.remove(userInput - 1);
						}
						break;
					}
				}
			}
			//Else if userInput is equal to "N," then cancel the action.
			else{
				System.out.println("Action cancelled.");
			}
		}
	}
	//Method to equip weapon.
	void equipWeapon(){
		//Create a new arrayList to hold the items that are classified as weapons.
		ArrayList<Item> weapons = new ArrayList<Item>();

		int count = 0;
		//This for-loop reads over the items in the inventory and stores the weapons into the weapons arrayList.
		//Then the items that are classified as weapons is printed to the user. The user will then pick a weapon to equip.
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
	//Method to equip armor.
	void equipArmor(){
		//Create a new arrayList to hold the items that are classified as armor.
		ArrayList<Item> armor = new ArrayList<Item>();

		int count = 0;
		//This for-loop reads over the items in the inventory and stores the armors into the armor arrayList.
		//Then the items that are classifed as armor is printed to the user. The user will then pick one armor to wear.
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
	//Method to drink a health potion.
	void drinkHealthPotion(Item healthPotion){
		ArrayList<Item> healthPotions = new ArrayList<Item>();
		int count = 0;

		System.out.println("Name Weight Value Strength");
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getType() == ItemType.HealthPotion){
				count++;
				healthPotions.add(items.get(i));
				System.out.println(count + ". " + items.get(i));
			}
		}
		count++;
		System.out.println(count + ".Cancel\n");

		System.out.print("Which health potion do you want to drink?\n[Answer] ");
		
		Scanner in = new Scanner(System.in);
		int userInput = in.nextInt();
		
		while(userInput != count){
			if(userInput == count){
				System.out.println("You decided to keep your health potion for later...");
				break;
			}
			else if(userInput > count || userInput < 1){
				System.out.println("Please enter a valid number.\n[Answer] ");
				userInput = in.nextInt();
				continue;
			}
			else{
				this.health = 100;
				items.remove(healthPotion);//healthPotion);
				System.out.println("You drink the health potion and restore your health...");
				break;
			}
		}
	}

	//To get the equipped Armor.
	Item getEquippedArmor(){
		return this.equippedArmor;
	}
	//To get the equipped Weapon.
	Item getEquippedWeapon(){
		return this.equippedWeapon;
	}
	

	public void persist(PrintWriter pw){
		pw.println("Inventory");
		for(Item items : items){
			pw.println(items.getName());
			pw.println(items.getType());
			pw.println(items.getStrength());
			pw.println(items.getWeight());
			pw.println(items.getItemX());
			pw.println(items.getItemY());
			pw.println("-");
		}
		pw.println(".");
	}
}

