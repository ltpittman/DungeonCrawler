import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * World represents the entire domain that the characters can move around in. Each world has three rooms, the first room the player starts in and the  next two rooms require a key to enter. {@link Room} The player can find the keys on the board as items. The player can move around the board as they please and fight any monsters, pick up any items, and converse with their side character.
 * @author Lauren Pittman, Tavion Britt, and Grace Long
 */

public class World{
	private Enemy enemy;
	private Player player;
	public int x,y;
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
	 * Constructs a new World that contains three rooms. World contains a arraylist called Rooms that hold the three different rooms.
	 * @throws FileNotFoundException Throws exception if file is not found.
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
	 * @param explorer A side character that helps the player out by giving them items.
	 * @param key1 A key that allows the player to enter a new specific room.
	 * @param key2 A key that allows the player to enter a new specific room.
	 * @param item1 A random item that the player can pick up and use.
	 * @param item2 A random item that the player can pick up and use.
	 * @param item3 A random item that the player can pick up and use.
	 * @param item4 A random item that the player can pick up and use.
	 * @param item5 A random item that the player can pick up and use.
	 * @param item6 A random item that the player can pick up and use.
	 * @param item7 A random item that the player can pick up and use.
	 * @param item8 A random item that the player can pick up and use.
	 * @param item9 A random item that the player can pick up and use.
	 * @param item10 A random item that the player can pick up and use.
	 * @param item11 A random item that the player can pick up and use.
	 * @param item12 A random item that the player can pick up and use.
	 * @param item13 A random item that the player can pick up and use.
	 * @param item14 A random item that the player can pick up and use.
	 * @param item15 A random item that the player can pick up and use.
	 * @param enemy1 A enemy that the player can battle against.
	 * @param enemy2 A enemy that the player can battle against.
	 * @param enemy3 A enemy that the player can battle against.
	 * @param enemy4 A enemy that the player can battle against.
	 * @param enemy5 A enemy that the player can battle against.
	 * @param enemy6 A enemy that the player can battle against.
	 * @param enemy7 A enemy that the player can battle against.
	 * @param enemy8 A enemy that the player can battle against.
	 * @param enemy9 A enemy that the player can battle against.
	 * @return Reurns the current room number of the player.
	 */
	public int fillWorld(Player player, SideCharacter explorer, Item key1, Item key2, Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8, Item item9, Item item10, Item item11, Item item12, Item item13, Item item14, Item item15, Enemy enemy1, Enemy enemy2, Enemy enemy3, Enemy enemy4, Enemy enemy5, Enemy enemy6, Enemy enemy7, Enemy enemy8, Enemy enemy9){ 	

		Scanner in = new Scanner(System.in);
		
		//Set the main room as room1.
		room1.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);

		//If the player is in the first room, then print Room1.
		if(currentRoom == 0){
			room1.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
			//Here is where the player will enter the second room located on the top.
			if(player.getPlayerX() == 1 && player.getPlayerY() == 6 && currentRoom == 0 && player.inventory.items.contains(key1)){
				System.out.println("[Attention!] The door appears locked.\n You notice that one of the keys you found looks like it can unlock the door. Do you want to try and enter the room? Y/N");
				System.out.print("[Answer] ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 1; //Room2
					player.x = 10;
					player.y = 6;
					System.out.println("You put the key into the lock and slowly turn it. You hear a click as the old, worn down door unlocks.\nYou carefully open the door and enter into the dark room before you...");
					room2.fillRoom(player, explorer, key1, key2, item6, item7, item8, item9, item10, enemy4, enemy5, enemy6);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
			//If the player does not have a key to open the door, the refuse entry.
			if(player.getPlayerX() == 1 && player.getPlayerY() == 6 && currentRoom == 0 && !player.inventory.items.contains(key1)){
				if(player.inventory.items.contains(key2)){
					System.out.println("It seems you have the wrong key. Go back to the area and look around for the other key to enter.");
				}
				else{
					System.out.println("[Attention!] The door appears locked. It seems that you need a key to open it.\nGo look around the area and try to find a key! Be careful of all the monsters!");
				}
			}
			//Here is where the player will enter the third room (located on the right).
			if(player.getPlayerX() == 9 && player.getPlayerY() == 28 && currentRoom == 0 && player.inventory.items.contains(key2)){
				System.out.println("[Attention!] The door appears locked.\n You notice that one of the keys you found looks like it can unlock the door. Do you want to try and enter the room? Y/N");
				System.out.print("[Answer] ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 2; //Room3
					player.x = 9;
					player.y = 1;
					System.out.println("You put the key into the lock and slowly turn it. You hear a click as the old, worn down door unlocks.\nYou carefully open the door and enter into the dark room before you...");
					room3.fillRoom(player, explorer, key1, key2, item11, item12, item13, item14, item15, enemy7, enemy8, enemy9);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
			//If the player does not have a key to open the door, the refuse entry.
			if(player.getPlayerX() == 9 && player.getPlayerY() == 28 && currentRoom == 0 && !player.inventory.items.contains(key2)){
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
			room2.fillRoom(player, explorer, key1, key2, item6, item7, item8, item9, item10, enemy4, enemy5, enemy6);
			//Here is where the player will enter the first room if they want to leave this room.
			if(player.getPlayerX() == 10 && player.getPlayerY() == 6 && currentRoom == 1){
				System.out.print("\n[Attention!] You came across the door you entered in from earlier...\nDo you want to leave this room and head back to the first one? Y/N ");
				System.out.print("\n[Answer] ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 0; //Room1
					player.x = 1;
					player.y = 6;
					System.out.println("You manage to push aside the heavy rocks and push your body through the entrance...");
					room1.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
				}
				else{
					System.out.println("You decide to keep exploring the room you are currently in...");
				}
			}
		}







		//If the player is in the third room, then print Room3.
		else if(currentRoom == 2){
			room3.fillRoom(player, explorer, key1, key2, item11, item12, item13, item14, item15, enemy7, enemy8, enemy9);
			if(player.getPlayerX() == 9 && player.getPlayerY() == 1 && currentRoom == 2){
				System.out.print("\n[Attention!] You came across the door you entered in from earlier...\nDo you want to leave this room and head back to the first one? Y/N ");
				System.out.print("\n[Answer] ");
				String input = in.next().toUpperCase();
				if(input.equals("Y")){
					currentRoom = 0; //Room1
					player.x = 9;
					player.y = 28;
					System.out.println("You manage to push aside the heavy rocks and push your body through the entrance...");
					room1.fillRoom(player, explorer, key1, key2, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
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
	 * This method gets the current room number that the player is in.
	 * @return Returns the current room numbe the player is in.
	 */ 
	public int getCurrentRoom(){
		return currentRoom;
	}


	/**
	 *  This method prints the current room the main player is in to the screen.
	 */
	public void printCurrentRoom(){
		//We are calling the arraylist Rooms to GET the index of the current room the player is in to print it to the screen.
		rooms.get(currentRoom).printRoom();
	}

	/**
	 * This method saves the information about the current room the player is in to a file.
	 * @param pw Print writer will type the information into a file.
	 */
	public void persist(PrintWriter pw){
		pw.println(currentRoom);
		pw.println(".");
	}

	/**
	 * This methodReads the information about the current room from a file. This they allows the user to continue with a previously saved game. 
	 * @param a Scanner a that reads the text in from a file.
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
