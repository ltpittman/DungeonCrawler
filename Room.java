/*This class reads in a file to create a room for the game. */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Room{
	//Instance variables.
	private char[][] grid;
	private Player player;
	private Enemy enemy;

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
		if (player.inventory.inInventory(item1) == false){
			grid[item1.y][item1.x] = '$';
		}
		if (player.inventory.inInventory(item2) == false){
			grid[item2.y][item2.x] = '$';
		}
		if (player.inventory.inInventory(item3) == false){
			grid[item3.y][item3.x] = '$';
		}
		if (player.inventory.inInventory(item4) == false){
			grid[item4.y][item4.x] = '$';
		}
		if (player.inventory.inInventory(item5) == false){
			grid[item5.y][item5.x] = '$';
		}

		//Monsters.
		if (enemy1.enemyDead() == false){
			grid[enemy1.y][enemy1.x] = 'M';
		}
		if (enemy2.enemyDead() == false){
			grid[enemy2.y][enemy2.x] = 'M';
		}
		if (enemy3.enemyDead() == false){
			grid[enemy3.y][enemy3.x] = 'M';
		}

		//Player.
		grid[player.y][player.x] = '@';

	}
}
