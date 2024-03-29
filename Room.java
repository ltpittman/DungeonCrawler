import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Room represents part of the board that the player can move around. Each room is filled with a player, side character, nine items, and three enemies. The player is able to move around the room and interact with the other objects in the room. 
 * @author Lauren Pittman, Tavion Britt, and Grace Long
 */

public class Room{
	//Private instance variables.
	private char[][] grid;
	private Player player;
	private Inventory inventory;
	private Enemy enemy;
	private Battles battle = new Battles();
	private SideCharacter explorer;

	/**
	 * Constructs a new Room that is empty. The rooms are saved onto a file that is read.
	 * @param frame Takes in the file that will be used to upload a room. 
	 * @throws FileNotFoundException Throws exception if a file is not found for the room.
	 */
	public Room(String frame) throws FileNotFoundException {

		grid = new char[30][12];

		try{
			FileInputStream f = new FileInputStream(frame);
			Scanner in = new Scanner (f);

			for(int i = 0; i < 12; i++){
				String line = in.nextLine();
				for(int j = 0; j < 30; j++){
					grid[j][i] = line.charAt(j);
				}
			}
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File to upload the given room could not found.");
		}
	}

	/**
	 * Prints the room to the screen for the user to see. 
	 */
	public void printRoom(){
		for(int i = 0; i < 12; i ++){
			for(int j = 0; j < 30; j++){
				System.out.print(grid[j][i]);
			}
			System.out.println();
		}
	}

	/**
	 * Added objects to the room including a player, a side character, two keys, five random items, and three enemies. The characters in the room are able to move around the board and the other items are for the main player's benefit through out the game.
	 * @param player The main player that is controlled by the user.
	 * @param explorer A side character that helps the player pick up items.
	 * @param key1 A key to open the door to another room.
	 * @param key2 A key to otpen the door to another room.
	 * @param item1 A random item the player can pick up.
	 * @param item2 A random item the player can pick up.
	 * @param item3 A random item the player can pick up.
	 * @param item4 A randoom item the player can pick up.
	 * @param item5 A random item the player can pick up.
	 * @param enemy1 A random monster that the player must kill.
	 * @param enemy2 A random monster that the player must kill.
	 * @param enemy3 A random monster that the player must kill.
	 */
	public void fillRoom(Player player, SideCharacter explorer, Item key1, Item key2, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3){

		//Erase old player's location.
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 30; j++){
				if(grid[j][i] == '@'){
					grid[j][i] = '.';
				}
			}
		}
		//Erase old side character's location.
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 30; j++){
				if(grid[j][i] == '&'){
					grid[j][i] = '.';
				}
			}
		}
		//Erase old monster's locations.
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 30; j++){
				if(grid[j][i] == 'M'){
					grid[j][i] = '.';
				}
			}
		}

		//Erase the old key location.
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 30; j++){
				if(grid[j][i] == 'K'){
					grid[j][i] = '.';
				}
			}
		}


		//Items.
		if(player.inventory.inInventory(item1) == false){
			grid[item1.y][item1.x] = item1.getItemImage();
		}
		if(player.inventory.inInventory(item2) == false){
			grid[item2.y][item2.x] = item2.getItemImage();
		}
		if(player.inventory.inInventory(item3) == false){
			grid[item3.y][item3.x] = item3.getItemImage();
		}
		if(player.inventory.inInventory(item4) == false){
			grid[item4.y][item4.x] = item4.getItemImage();
		}
		if(player.inventory.inInventory(item5) == false){
			grid[item5.y][item5.x] = item5.getItemImage();
		}
		//Adding a key to the room.
		if(player.inventory.inInventory(key1) == false){
			grid[key1.y][key1.x] = key1.getItemImage();
		}
		if(player.inventory.inInventory(key2) == false){
			grid[key2.y][key2.x] = key2.getItemImage();
		}

		//Monsters.
		if(enemy1.getIsDead() == false){
			grid[enemy1.y][enemy1.x] = enemy1.getCharacterImage();
		}
		if(enemy2.getIsDead() == false){
			grid[enemy2.y][enemy2.x] = enemy2.getCharacterImage();
		}
		if(enemy3.getIsDead() == false){
			grid[enemy3.y][enemy3.x] = enemy3.getCharacterImage();
		}
		//Player.
		grid[player.y][player.x] = player.getCharacterImage();

		//Dungeon Explorer.
		grid[explorer.y][explorer.x] = explorer.getCharacterImage();

		//Here is where a player will be able to pick up items if they come across any.
		if(player.y == item1.y && player.x == item1.x && !player.inventory.items.contains(item1)){
			System.out.println("[Attention!] You just came across: " + item1.getName() + ".");
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(item1);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if(player.y == item2.y && player.x == item2.x && !player.inventory.items.contains(item2)){
			System.out.println("[Attention!] You just came across: " + item2.getName() + ".");
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(item2);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if(player.y == item3.y && player.x == item3.x && !player.inventory.items.contains(item3)){
			System.out.println("[Attention!] You just came across: " + item3.getName() + ".");
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(item3);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if(player.y == item4.y && player.x == item4.x && !player.inventory.items.contains(item4)){
			System.out.println("[Attention!] You just came across: " + item4.getName() + ".");
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(item4);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if(player.y == item5.y && player.x == item5.x && !player.inventory.items.contains(item5)){
			System.out.println("[Attention!] You just came across: " + item5.getName() + ".");
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(item5);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		//Here is where player will come across a key to enter a new room.
		if(player.y == key1.y && player.x == key1.x && !player.inventory.items.contains(key1)){
			System.out.println("[Attention!] You just came across a key.");
			System.out.print("Do you want to pick this key up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(key1);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if(player.y == key2.y && player.x == key2.x && !player.inventory.items.contains(key2)){
			System.out.println("[Attention!] You just came across a key.");
			System.out.print("Do you want to pick this key up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(key2);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}

		//Here is where the player and enemy will fight if they land on the same spot.
		if(player.y == enemy1.y && player.x == enemy1.x || player.y == enemy1.y&& player.x == enemy1.x){
			battle.attack(player,enemy1);
		}
		else if(player.y == enemy2.y && player.x == enemy2.x || player.y == enemy2.y && player.x == enemy2.x){
			battle.attack(player,enemy2);
		}
		else if(player.y == enemy3.y && player.x == enemy3.x || player.y == enemy3.y && player.x == enemy3.x){
			battle.attack(player,enemy3);
		}
	}
}
