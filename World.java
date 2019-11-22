/*This class displays the world, along with the three rooms. In the fillWorld method, the player will be able to move between rooms, fight monsters, and pick up random items.*/

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.PrintWriter;

class World{
	private Enemy enemy;
	private Player player;
	private Inventory inventory;

	private ArrayList<Room> rooms = new ArrayList<Room>(); 
	private Room room1;
	private Room room2;
	private Room room3;
	private int currentRoom;
	
	private Battles battle = new Battles();
	
	//Constructor for the world.
	World(){
		this.room1 = new Room("Room1.txt");
		this.room2 = new Room("Room2.txt");
		this.room3 = new Room("Room3.txt");
		//Add the rooms to the arrayList.
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		//Set the currentRoom to 0 (this will help get the room with the index).
		this.currentRoom = 0;
	}
	//Method to fill the world with the players, items, and enemies.
	public void fillWorld(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3){ 	

		Room currentRoom = room1;
		
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
		}
		else if (player.y == enemy2.y && player.x == enemy2.x){
			System.out.println("[Attention!] You just came across a " + enemy2.getName() + ". Prepare to fight!");
			battle.attack(player, enemy2);
		}
		else if (player.y == enemy3.y && player.x == enemy3.x){
			System.out.println("[Attention!] You just came across a " + enemy3.getName() + ". Prepare to fight!");
			battle.attack(player, enemy3);
		}

		//If the player finds the room on the top, then ask if they want to go to that room.
		if(player.x == 6 && player.y == 1){
			System.out.print("\nYou just encountered a mysterious entrance! However, it is blocked by rocks...\nDo you want to try and enter the dark room? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				System.out.println("You push the heavy rocks to the side and fit through...");
			}
			else{
				System.out.println("You decide to stay in the main room and continue to explore...");
			}
		}

		//If the player finds the door on the right side of the room, ask if they want to go to that room.
		if(player.x == 22 && player.y == 13){
			System.out.print("\nYou just encountered a mysterious entrance! However, it is blocked by rocks...\nDo you want to try and enter the dark room? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				System.out.println("You push the heavy rocks to the side and fit through...");
			}
		}


	}
	//This method prints the current room that the player is in.
	public void printCurrentRoom(){
		rooms.get(currentRoom).printRoom();


	}
	public void persist (PrintWriter pw){
		pw.println(currentRoom);
	}
	public void restore(String fileName){
		try{
			Scanner a = new Scanner(fileName);
			this.currentRoom = currentRoom;
		} 
		catch(Exception e){
			System.out.println("No file found.");
		}
	}
}
