/*This class displays the world, along with the three rooms. In the fillWorld method, the player will be able to move between rooms, fight monsters, and pick up random items.*/

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
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		this.currentRoom = currentRoom;
	}
	//Method to fill the world with the players, items, and enemies.
	public void fillWorld(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3){ 	
				Scanner in = new Scanner(System.in);
				String input;
		//public void switchRooms(int currentRoom){
		//Set the currentRoom's index to 0 to print the first room when the game starts.
		currentRoom = 0;
		boolean room = false;
		room1.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);

		//Right now the room is being printed becuase of the currentRoom = 0 in the constructor.
		if(currentRoom == 0){ //Room1 has the index of 0.
			room1.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
			if(player.getPositionX() == 1 && player.getPositionY() == 6 && currentRoom == 0){
				System.out.print("\n[Attention!] You just encountered a mysterious entrance!\nHowever, it is blocked by rocks... Do you want to try and enter the dark room? Y/N ");
				input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 1;
					room2.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
					while(room == true){
						room2.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
						printCurrentRoom();
						//Have the player be in the position of(10,6)
						if(player.getPositionX() == 10 && player.getPositionX() == 6 && currentRoom == 1){//Fix coordinates
							System.out.print("\nYou come cross the door that you entered. Do you want to leave this room? Y/N ");
							input = in.next().toUpperCase();
							if(input.equals("Y")){
								currentRoom = 0;
								room = false;
							}
							else{
								System.out.println("You decide to continue exploring this room...");
								currentRoom = 1;
								room = true;
							}
						}
					}
				}
			}
			if(player.getPositionX() == 9 && player.getPositionY() == 28 && currentRoom == 0){
				System.out.print("\n[Attention!] You just encountered a mysterious entrance!\nHowever, it is blocked by rocks... Do you want to try and enter the dark room? Y/N ");
			
				input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 2;
					room3.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
					while(room == true){
						room3.fillRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
						printCurrentRoom();
						if(player.getPositionX() == 1 && player.getPositionX() == 28 && currentRoom == 2){
							System.out.print("\nYou come cross the door that you entered. Do you want to leave this room? Y/N ");
							input = in.next().toUpperCase();
							if(input.equals("Y")){
								currentRoom = 0;
								room = false;
							}
							else{
								System.out.println("You decide to continue exploring this room...");
								currentRoom = 2;
								room = true;
							}
						}
					}
				}
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
