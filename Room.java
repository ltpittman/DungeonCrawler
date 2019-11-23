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
	Item item1, item2, item3, item4, item5;

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
			System.out.println("File not found.");
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

	//We should probably change this to fillRoom so we dont get confused later.
	public void fillRoom(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3){
		//Items.
		if(player.inventory.inInventory(item1) == false){
			grid[item1.y][item1.x] = '$';
		}
		if(player.inventory.inInventory(item2) == false){
			grid[item2.y][item2.x] = '$';
		}
		if(player.inventory.inInventory(item3) == false){
			grid[item3.y][item3.x] = '$';
		}
		if(player.inventory.inInventory(item4) == false){
			grid[item4.y][item4.x] = '$';
		}
		if(player.inventory.inInventory(item5) == false){
			grid[item5.y][item5.x] = '$';
		}
		//Monsters.
		if(enemy1.enemyDead() == false){
			grid[enemy1.getY()][enemy1.getX()] = enemy.getCharacterImage();
		}
		if(enemy2.enemyDead() == false){
			grid[enemy2.getY()][enemy2.getX()] = enemy.getCharacterImage();
		}
		if(enemy3.enemyDead() == false){
			grid[enemy3.getY()][enemy3.getX()] = enemy.getCharacterImage();
		}

		//Player.

		grid[player.y][player.x] = player.getCharacterImage();

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
	
	}
}
