/**
 * A <tt>World</tt> represents the entire domain that the characters can move around in. Each world has three rooms, the first room the player starts in and the
 * next two rooms require a key to enter. {@link Room} The player can find the keys on the board as items. The player can move around the board as they
 * please and fight any monsters, pick up any items, and converse with their side character
 * @author Lauren Pittman, Tavion Britt, and Grace Long
 */
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
	private SideCharacter explorer;
	//Store all three rooms in a arraylist.
	private ArrayList<Room> rooms = new ArrayList<Room>(); 
	//CurrentRoom will be used to get a room through the index of the arraylist.
	private int currentRoom; 
	private Room room1; //Index[0]
	private Room room2; //Index[1]
	private Room room3; //Index[2]

	/**
	 * Constructs a new <tt>World</tt> that contains three rooms.
	 * @throws FileNotFoundException
	 */
	World() throws FileNotFoundException{
		try{
			this.room1 = new Room("Room1.txt");
			this.room2 = new Room("Room2.txt");
			this.room3 = new Room("Room3.txt");
		} catch(FileNotFoundException e){
			System.out.println("The room files were not found.");
		}
		//Add the rooms to the arrayList.
		this.currentRoom = currentRoom;
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
	}

	/**
	 * Adds objects to the world including: a player, a side character, two keys, seven items, and three enemies. The character move around the board and the items are  on the board for the benefit of the player.
	 * @param player the main character of the game that is controlled by the user.
	 * @param explorer a side character that helps the player out by giving them items.
	 * @param key1 a key that allows the player to enter a new specific room.
	 * @param key2 a key that allows the player to enter a new specific room.
	 * @param item1 a random item that the player can pick up and use.
	 * @param item2 a random item that the player can pick up and use.
	 * @param item3 a random item that the player can pick up and use.
	 * @param item4 a random item that the player can pick up and use.
	 * @param item5 a random item that the player can pick up and use.
	 * @param item6 a random item that the player can pick up and use.
	 * @param item7 a random item that the player can pick up and use.
	 * @param enemy1 a enemy that the player can battle against.
	 * @param enemy2 a enemy that the player can battle against.
	 * @param enemy3 a enemy that the player can battle against.
	 * @param enemy4 a enemy that the player can battle against.
	 * @param enemy5 a enemy that the player can battle against.
	 * @param enemy6 a enemy that the player can battle against.
	 * @param enemy7 a enemy that the player can battle against.
	 * @param enemy8 a enemy that the player can battle against.
	 * @param enemy9 a enemy that the player can battle against.
	 * @return the current room number of the player.
	 */
	public int fillWorld(Player player, SideCharacter explorer, Item key1, Item key2, Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Enemy enemy1, Enemy enemy2, Enemy enemy3, Enemy enemy4, Enemy enemy5, Enemy enemy6, Enemy enemy7, Enemy enemy8, Enemy enemy9){ 	

		Scanner in = new Scanner(System.in);
		
		//Set the main room as room1.
		room1.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, enemy1, enemy2, enemy3);

		//If the player is in the first room, then print Room1.
		if(currentRoom == 0){
			room1.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, enemy1, enemy2, enemy3);
			//Here is where the player will enter the second room located on the top.
			if(player.getPositionX() == 1 && player.getPositionY() == 6 && currentRoom == 0 && player.inventory.items.contains(key1)){
				System.out.println("[Attention!] The door appears locked.\n You notice that one of the keys you found looks like it can unlock the door. Do you want to try and enter the room?");
				System.out.print("[Answer] ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 1; //Room2
					player.x = 10;
					player.y = 6;
					System.out.println("You put the key into the lock and slowly turn it. You hear a click as the old, worn down door unlocks.\nYou carefully open the door and enter into the dark room before you...");
					room2.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, enemy4, enemy5, enemy6);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
			//If the player does not have a key to open the door, the refuse entry.
			if(player.getPositionX() == 1 && player.getPositionY() == 6 && currentRoom == 0 && !player.inventory.items.contains(key1)){
				if(player.inventory.items.contains(key2)){
					System.out.println("It seems you have the wrong key. Go back to the area and look around for the other key to enter.");
				}
				else{
					System.out.println("[Attention!] The door appears locked. It seems that you need a key to open it.\nGo look around the area and try to find a key! Be careful of all the monsters!");
				}
			}
			//Here is where the player will enter the third room (located on the right).
			if(player.getPositionX() == 9 && player.getPositionY() == 28 && currentRoom == 0 && player.inventory.items.contains(key2)){
				System.out.println("[Attention!] The door appears locked.\n You notice that one of the keys you found looks like it can unlock the door. Do you want to try and enter the room?");
				System.out.print("[Answer] ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 2; //Room3
					player.x = 9;
					player.y = 1;
					System.out.println("You put the key into the lock and slowly turn it. You hear a click as the old, worn down door unlocks.\nYou carefully open the door and enter into the dark room before you...");
					room3.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, enemy7, enemy8, enemy9);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
			//If the player does not have a key to open the door, the refuse entry.
			if(player.getPositionX() == 9 && player.getPositionY() == 28 && currentRoom == 0 && !player.inventory.items.contains(key2)){
				if(player.inventory.items.contains(key1)){
					System.out.println("It seems you have the wrong key. Go back to the area and look around for the other key to enter.");
				}
				else{
					System.out.println("[Attention!] The door appears locked. It seems that you need a key to open it.\nGo look around the area and try to find a key! Be careful of all the monsters!");
				}
			}
		}






		//If the player is in the second room, then print Room2.
		else if(currentRoom == 1){
			room2.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, enemy4, enemy5, enemy6);
			//Here is where the player will enter the first room if they want to leave this room.
			if(player.getPositionX() == 10 && player.getPositionY() == 6 && currentRoom == 1){
				System.out.print("\n[Attention!] You came across the door you entered in from earlier...\nDo you want to leave this room and head back to the first one? Y/N ");
				System.out.print("[Answer] ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 0; //Room1
					player.x = 1;
					player.y = 6;
					System.out.println("You manage to push aside the heavy rocks and push your body through the entrance...");
					room1.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, enemy1, enemy2, enemy3);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
		}







		//If the player is in the third room, then print Room3.
		else if(currentRoom == 2){
			room3.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, enemy7, enemy8, enemy9);
			if(player.getPositionX() == 9 && player.getPositionY() == 1 && currentRoom == 2){
				System.out.print("\n[Attention!] You came across the door you entered in from earlier...\nDo you want to leave this room and head back to the first one? Y/N ");
				System.out.print("[Answer] ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 0; //Room1
					player.x = 9;
					player.y = 28;
					System.out.println("You manage to push aside the heavy rocks and push your body through the entrance...");
					room1.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, enemy1, enemy2, enemy3);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
		}
		//Return the current room that the player is in to print it to the screen.
		return currentRoom;
	}





	/**
	 * Prints the current room the main player is in to the screen.
	 */
	public void printCurrentRoom(){
		//We are calling the arraylist Rooms to GET the index of the current room the player is in to print it to the screen.
		rooms.get(currentRoom).printRoom();
	}

	/**
	 * Saves the information about the current room the player is in to a file.
	 * @param pw Print writer that types the information into a file.
	 */
	public void persist(PrintWriter pw){
		pw.println(currentRoom);
		pw.println(".");
	}

	/**
	 * Reads the information about the current room from a file. This they allows the user to continue with a previously saved game. 
	 * @param a A scanner that reads the text in from a file.
	 */
	public void restore(Scanner a){
		try{
			this.currentRoom = a.nextInt();
		} 
		catch(Exception e){
			System.out.println("Could not read world portion of the file");
		}
	}
}
