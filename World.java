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
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		//Set the currentRoom to 0(this will help get the room's index in the arraylist).
		this.currentRoom = 0;
	}
	//Method to fill the world with the players, items, and enemies.
	public void fillWorld(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3){ 	
		currentRoom = 0;

		//Right now the room is being printed becuase of the currentRoom = 0 in the constructo
		if(currentRoom == 0){
			room1.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
			//room1.printRoom();
		}
		if(currentRoom == 1){
			room2.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
			//room2.printRoom();
		}
		if(currentRoom == 2){
			room3.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
			//room3.printRoom();
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
		//We are calling the arraylist Rooms to GET the index of the current room the player is in to print it to the screen.
		rooms.get(currentRoom).printRoom();
	}



	//***** This one may need to be changed since the currentRoom is a int.
	public void persist(PrintWriter pw){
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
