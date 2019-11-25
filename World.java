/*This class displays the world, along with the three rooms. In the fillWorld method, the player will be able to move between rooms, fight monsters, and pick up random items.*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.PrintWriter;

class World{
	private Enemy enemy;
	private Player player;
	private int x,y;
	private Inventory inventory;
	//Store all three rooms in a arraylist.
	private ArrayList<Room> rooms = new ArrayList<Room>(); 
	//CurrentRoom will be used to get a room through the index of the arraylist.
	private int currentRoom; 
	private Room room1; //Index[0]
	private Room room2; //Index[1]
	private Room room3; //Index[2]

	private Battles battle = new Battles();

	//Constructor for the world.
	World(){
		this.room1 = new Room("Room1.txt");
		this.room2 = new Room("Room2.txt");
		this.room3 = new Room("Room3.txt");
		//Add the rooms to the arrayList.
		this.currentRoom = currentRoom;
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
	}
	//Method to fill the world with the players, items, and enemies.
	public int fillWorld(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3){ 	

		Scanner in = new Scanner(System.in);
		
		//Set the main room as room1.
		room1.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);

		//If the player is in the first room, then print Room1.
		if(currentRoom == 0){
			room1.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
			//Here is where the player will enter the second room located on the top.
			if(player.getPositionX() == 1 && player.getPositionY() == 6 && currentRoom == 0){
				System.out.print("\n[Attention!] You just encountered a mysterious entrance!\nHowever, it is blocked by rocks... Do you want to try and enter the dark room? Y/N ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 1; //Room2
					player.x = 10;
					player.y = 6;
					System.out.println("You manage to push aside the heavy rocks and push your body through the entrance...");
					room2.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
			//Here is where the player will enter the third room (located on the right).
			if(player.getPositionX() == 9 && player.getPositionY() == 28 && currentRoom == 0){
				System.out.print("\n[Attention!] You just encountered a mysterious entrance!\nHowever, it is blocked by rocks... Do you want to try and enter the dark room? Y/N ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 2; //Room3
					player.x = 9;
					player.y = 1;
					System.out.println("You manage to push aside the heavy rocks and push your body through the entrance...");
					room3.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
		}
		//If the player is in the second room, then print Room2.
		else if(currentRoom == 1){
			room2.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
			//Here is where the player will enter the first room if they want to leave this room.
			if(player.getPositionX() == 10 && player.getPositionY() == 6 && currentRoom == 1){
				System.out.print("\n[Attention!] You came across the door you entered in from earlier... Do you want to leave this room and head back to the first one? Y/N ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 0; //Room1
					player.x = 1;
					player.y = 6;
					System.out.println("You manage to push aside the heavy rocks and push your body through the entrance...");
					room1.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
		}
		//If the player is in the third room, then print Room3.
		else if(currentRoom == 2){
			room3.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
			if(player.getPositionX() == 9 && player.getPositionY() == 1 && currentRoom == 2){
				System.out.print("\n[Attention!] You came across the door you entered in from earlier... Do you want to leave this room and head back to the first one? Y/N ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 0; //Room1
					player.x = 9;
					player.y = 28;
					System.out.println("You manage to push aside the heavy rocks and push your body through the entrance...");
					room1.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
		}
		//Return the current room that the player is in to print it to the screen.
		return currentRoom;
	}
	void printCommands(){
		System.out.println("[How to Play]:\nPress 'H' to go up.\nPress 'L' to go down.\nPress 'J' to go left.\nPress 'K' to go right.\nPress 'I' to print your inventory.\nPress 'D' to drop an item from your inventory.\nPress 'W' to equip a weapon from your inventory.\nPress 'A' to equip armor from your inventory.\nPress 'P' to print the commands to read again.");
	}
	//Method to print the objective of the game.
	void printObjective(){
		System.out.println("\n[Welcome to Dungeon Crawler!]...\n   The overall objective of the game is to fight all the monsters that you encounter and make it out of the dungeon alive. To begin, your health will start at 100/100 pts. You will have two items in your inventory: a sword and a piece of armor. While out searching for monsters, you have the option to pick up random items, whether it is a piece of armor, a weapon, etc.\n    You may switch your weapon and armor for something different that you find anytime. When it comes to fighting the monsters, it's all about luck. If you win a battle against a monster, you will be able to continue exploring the area and fight any more monsters you come across. If you are able to kill all the monsters in the dungeon, then you have won the game! [Good luck!]"); 


	}

	//This method prints the current room that the player is in.
	public void printCurrentRoom(){
		//We are calling the arraylist Rooms to GET the index of the current room the player is in to print it to the screen.
		rooms.get(currentRoom).printRoom();
	}
	//***** This one may need to be changed since the currentRoom is a int.
	public void persist(PrintWriter pw){
		pw.println(currentRoom);
		pw.println(".");
	}
	public void restore(Scanner a){
		try{
			this.currentRoom = a.nextInt();
		} 
		catch(Exception e){
			System.out.println("Could not read world portion of the file");
		}
	}
}
