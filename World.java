import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class World{
	public Enemy enemy;
	public Player player;
	Inventory inventory;
	public Room1 room1;
	public Room2 room2;
	public Room3 room3;
	public int currentRoom;
	Battles battle = new Battles();
	//store the rooms into variables

	World(){
		room1 = new Room1();
		room2 = new Room2();
		room3 = new Room3();

	}
	//Method to fill the world with the players, items, and enemies.
	public void fillWorld(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3, int room){	
		
		//Set the mainRoom to null.
		//Rooms mainRoom = null;
		//If room is equal to one, then make the mainRoom equal to room1.
		if(room == 1){
		//	mainRoom = room1;
			currentRoom = 1;
		}
		else if(room == 2){
			//mainRoom = room2;
			currentRoom = 2;
		}
		else if(room == 3){
			//mainRoom = room3;
			currentRoom = 3;
		}
		
		//Items.
		if (player.inventory.inInventory(item1) == false){
			world[item1.y][item1.x] = "$";
		}
		if (player.inventory.inInventory(item2) == false){
			world[item2.y][item2.x] = "$";
		}
		if (player.inventory.inInventory(item3) == false){
			world[item3.y][item3.x] = "$";
		}
		if (player.inventory.inInventory(item4) == false){
			world[item4.y][item4.x] = "$";
		}
		if (player.inventory.inInventory(item5) == false){
			world[item5.y][item5.x] = "$";
		}
		//Monsters.
		if (enemy1.enemyDead(enemy1) == false){
			mainRoom.getRoom()[enemy1.y][enemy1.x] = "M";
		}
		if (enemy2.enemyDead(enemy2) == false){
			mainRoom.getRoom()[enemy2.y][enemy2.x] = "M";
		}
		if (enemy3.enemyDead(enemy3) == false){
			mainRoom.getRoom()[enemy3.y][enemy3.x] = "M";
		}

		//Player.
		mainRoom.getRoom()[player.y][player.x] = "@";

		//Here is where the player will pick up a item they found.
		if (player.y == item1.y && player.x == item1.x && !player.inventory.items.contains(item1)){
			System.out.println("[Attention!] You just came across: " + item1.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			//If the user takes the item, delete the item from the map.
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item1);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if (player.y == item2.y && player.x == item2.x && !player.inventory.items.contains(item2)){
			System.out.println("[Attention!] You just came across: " + item2.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item2);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if (player.y == item3.y && player.x == item3.x && !player.inventory.items.contains(item3)){
			System.out.println("[Attention!] You just came across: " + item3.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item3);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if (player.y == item4.y && player.x == item4.x && !player.inventory.items.contains(item4)){
			System.out.println("[Attention!] You just came across: " + item4.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item4);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if (player.y == item5.y && player.x == item5.x && !player.inventory.items.contains(item5)){
			System.out.println("[Attention!] You just came across: " + item5.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item5);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}

		//Here is where the player and enemy will fight if they land on the same area.
		if (player.y == enemy1.y && player.x == enemy1.x){
			System.out.println("[Attention!] You just came across a " + enemy1.getName() + ". Prepare to fight!");
			battle.attack(player, enemy1);
			enemy1.enemyDead(enemy1);
		}
		else if (player.y == enemy2.y && player.x == enemy2.x){
			System.out.println("[Attention!] You just came across a " + enemy2.getName() + ". Prepare to fight!");
			battle.attack(player, enemy2);
			enemy2.enemyDead(enemy2);
		}
		else if (player.y == enemy3.y && player.x == enemy3.x){
			System.out.println("[Attention!] You just came across a " + enemy3.getName() + ". Prepare to fight!");
			battle.attack(player, enemy3);
			enemy3.enemyDead(enemy3);
		}

		//If the player finds the room on the top, then ask if they want to go to that room.
		if(player.x == 6 && player.y == 1){
			System.out.print("\nYou just encountered a mysterious entrance! However, it is blocked by rocks...\nDo you want to try and enter the dark room? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				System.out.println("You push the heavy rocks to the side and fit through...");
				//room1.printRoom1();//player);//, enemy1, item1, item2, item3);
			}
			else{
				System.out.println("You decide to stay in the main room and continue to explore...");
			}
		}

		//If the player finds the door on the right side of the room, ask if they want to go to that room.
		if(player.x == 22 && player.y == 13){
			System.out.print("\nYou just encountered a mysterious entrance! However, it is blocked by rocks...\nDo you want to try and enter the dark room? Y/N "); // [Type 'E' to enter...] ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				System.out.println("You push the heavy rocks to the side and fit through...");
				//room2.printRoom2();//player, item1, item2);
			}
		}
	}
/*	
	public void printWorld(){
		//Print the first world if the current world if equal to 1.
		if(currentRoom == 1){
			for(int i = 0; i < room1; i++){
				for(int j = 0; j < room1.length; j++){
					System.out.println(room1[i][j] + " ");
				}
			}
			System.out.println();
		}
		//Print the second world if the current world is equal to 2.
		else if (currentRoom == 2){
			for(int i = 0; i < room2; i++){
				for(int j = 0; j < room2.length; j++){
					System.out.println(room2[i][j] + " ");
				}
			}
			System.out.println();
		}
		//Print the third world if the current world is equal to 3.
		else if(currentRoom == 3){
			for(int i = 0; i < room; i++){
				for(int j = 0; i < room[i].length; j++){
					System.out.println(room[i][j] + " ");
					}
				}
			System.out.println();
		}
	}
	*/
	//Method to print the commands to the user.
	void printCommands(){
		System.out.println("[How to Play]:\nPress 'H' to go up.\nPress 'L' to go down.\nPress 'J' to go left.\nPress 'K' to go right.\nPress 'I' to print your inventory.\nPress 'D' to drop an item from your inventory.\nPress 'W' to equip a weapon from your inventory.\nPress 'A' to equip armor from your inventory.\nPress 'P' to print the commands to read again.");
	}
	//Method to print the objective of the game.
	void printObjective(){
		System.out.println("\n[Welcome to Dungeon Crawler!]...\n   The overall objective of the game is to fight all the monsters that you encounter and make it out of the dungeon alive. To begin, your health will start at 100/100 pts. You will have two items in your inventory: a sword and a piece of armor. While out searching for monsters, you have the option to pick up random items, whether it is a piece of armor, a weapon, etc.\n    You may switch your weapon and armor for something different that you find anytime. When it comes to fighting the monsters, it's all about luck. If you win a battle against a monster, you will be able to continue exploring the area and fight any more monsters you come across. If you are able to kill all the monsters in the dungeon, then you have won the game! [Good luck!]"); 
	}
	}
