/*This class reads in a file to create a room for the game. */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Room{
	//Instance variables.
	private char[][] grid;
	private Player player;
	private Inventory inventory;
	private Enemy enemy;
	private Item item1, item2, item3, item4, item5, item6, item7;
	private Battles battle = new Battles();

	//Constructor that takes in a file.
	public Room(String frame){

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

	//Method to print the room the player is in.
	public void printRoom(){
		for(int i = 0; i < 12; i ++){
			for(int j = 0; j < 30; j++){
				System.out.print(grid[j][i]);
			}
			System.out.println();
		}
	}
	public void fillRoom(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Enemy enemy1, Enemy enemy2, Enemy enemy3){
		
		//Erase old players location.
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 30; j++){
				if(grid[j][i] == '@'){
					grid[j][i] = '.';
				}
			}
		}

		//Erase old monsters locations.
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 30; j++){
				if(grid[j][i] == 'M'){
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
		if(player.inventory.inInventory(item6) == false){
			grid[item6.y][item6.x] = item6.getItemImage();
		}
		if(player.inventory.inInventory(item7) == false){
			grid[item7.y][item7.x] = item7.getItemImage();
		}

		//Monsters.
		if(enemy1.getIsDead() == false){
			grid[enemy1.getY()][enemy1.getX()] = enemy1.getCharacterImage();
		}
		if(enemy2.getIsDead() == false){
			grid[enemy2.getY()][enemy2.getX()] = enemy2.getCharacterImage();
		}
		if(enemy3.getIsDead() == false){
			grid[enemy3.getY()][enemy3.getX()] = enemy3.getCharacterImage();
		}
	
		//Player.
		grid[player.y][player.x] = player.getCharacterImage();

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
		if(player.y == item6.y && player.x == item6.x && !player.inventory.items.contains(item6)){
			System.out.println("[Attention!] You just came across: " + item6.getName() + ".");
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(item6);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if(player.y == item7.y && player.x == item7.x && !player.inventory.items.contains(item7)){
			System.out.println("[Attention!] You just came across: " + item7.getName() + ".");
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner in = new Scanner(System.in);
			String input = in.next().toUpperCase();
			if(input.equals("Y")){
				player.inventory.addItem(item7);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}

		//Here is where the player and enemy will fight if they land on the same spot.
		if(player.y == enemy1.y && player.x == enemy1.x){
			System.out.println("[Attention!] You just came across a " + enemy1.getName() + ". Prepare to fight!");
			battle.attack(player,enemy1);
		}
		else if(player.y == enemy2.y && player.x == enemy2.x){
			System.out.println("[Attention!] You just came across a " + enemy2.getName() + ". Prepare to fight!");
			battle.attack(player,enemy2);
		}
		else if(player.y == enemy3.y && player.x == enemy3.x){
			System.out.println("[Attention!] You just came across a " + enemy3.getName() + ". Prepare to fight!");
			battle.attack(player,enemy3);
		}

	}

}
