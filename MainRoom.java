import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

class MainRoom{
	public String[][] mainRoom;
	public int rows;
	public int columns;
	public Enemy enemy;
	public Player player;
	public Rooms room1;
	public Rooms room2;
	Inventory inventory;

	Battles battle = new Battles();

	//Method to create the room.
	MainRoom(){
		this.rows = rows;
		this.columns = columns;
		mainRoom = new String[rows][columns];
	}
	//Method to fill the world with the players, items, and enemies.
	public void fillMainRoom(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3){

		String[][] mainRoom = 
		{
			{" #","#","#","#","#","#","D","#","#","#","#","#","#","#","#","#","#","#","#","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","D\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#",}
		};

		//Items.
		mainRoom[item1.y][item1.x] = "$";
		mainRoom[item2.y][item2.x] = "$";
		mainRoom[item3.y][item3.x] = "$";
		mainRoom[item4.y][item4.x] = "$";
		mainRoom[item5.y][item5.x] = "$";
		//Monsters.
		if (enemy1.enemyDead(enemy1) == false){
			mainRoom[enemy1.y][enemy1.x] = "M";
		}
		if (enemy2.enemyDead(enemy2) == false){
			mainRoom[enemy2.y][enemy2.x] = "M";
		}
		if (enemy3.enemyDead(enemy3) == false){
			mainRoom[enemy3.y][enemy3.x] = "M";
		}

		//Player.
		mainRoom[player.y][player.x] = "@";

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
			System.out.print("\nYou just encountered a mysterious entrance! However, it is blocked by rocks...\nDo you want to try and enter the dark room? Y/N "); // [Type 'E' to enter...] ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				System.out.println("You push the heavy rocks to the side and fit through...");
				room1.fillRoom1(player);//player);//, enemy1, item1, item2, item3);
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
				room2.fillRoom2();//player, item1, item2);
			}
		}


		for(int i = 0; i < mainRoom.length; i++){
			for (int j = 0; j < mainRoom[i].length; j++){
				System.out.print(mainRoom[i][j] + " ");
			}
		}
		System.out.println();
	}
/*
	public void printWorld(){
		for(int i = 0; i < world.length; i++){
			for (int j = 0; j < world[i].length; j++){
				System.out.print(world[i][j]);
			}
			}
		System.out.println();
	}*/
	//Method to print the commands to the user.
	void printCommands(){
		System.out.println("[How to Play]:\nPress 'H' to go up.\nPress 'L' to go down.\nPress 'J' to go left.\nPress 'K' to go right.\nPress 'I' to print your inventory.\nPress 'D' to drop an item from your inventory.\nPress 'W' to equip a weapon from your inventory.\nPress 'A' to equip armor from your inventory.\nPress 'P' to print the commands to read again.");
	}
	//Method to print the objective of the game.
	void printObjective(){
		System.out.println("\n[Welcome to Dungeon Crawler!]...\n   The overall objective of the game is to fight all the monsters that you encounter and make it out of the dungeon alive. To begin, your health will start at 100/100 pts. You will have two items in your inventory: a sword and a piece of armor. While out searching for monsters, you have the option to pick up random items, whether it is a piece of armor, a weapon, etc.\n    You may switch your weapon and armor for something different that you find anytime. When it comes to fighting the monsters, it's all about luck. If you win a battle against a monster, you will be able to continue exploring the area and fight any more monsters you come across. If you are able to kill all the monsters in the dungeon, then you have won the game! [Good luck!]"); 
	}
	}
