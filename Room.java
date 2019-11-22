/*This class reads in a file to create a room for the game. */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Room{
	char[][] grid;
	String[][]world;
	//Constructor that takes in a file.
	Room(String frame){
		
		grid = new char[30][12];

		try{
			FileInputStream f = new FileInputStream(frame);
			Scanner in = new Scanner (f);
			
			for(int i = 0; i < 12; i++){
				String line = in.nextLine();
				System.out.print("\n");
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
<<<<<<< HEAD
	//Method to print a room.
	public void printRoom(){
		for(int i = 0; i < 12; i ++){
			for(int j = 0; j < 30; j++){
				System.out.println(grid[j][i]);
			}//If the room prints backwards, then change the i and j variables above?
		}
	}
	//To print the room in the world class, do room1.printRoom()?
	
=======
	public void fillWorld(Player player, Item item1, Item item2, Item item3, Item item4, Item item5, Enemy enemy1, Enemy enemy2, Enemy enemy3){
		//Items
		if (player.inventory.inInventory(item1) == false){
			world[item1.y][item1.x] = "$";
		}
		if (player.inventory.inInventory(item2) == false){
			world[item2.y][item2.x] = "$";
		}
		if (player.inventory.inInventory(item3) == false){
			world[item3.y][item3.x] = "$";
		}
		if (player.inventory.inInventory(item4) == false){
			world[item4.y][item4.x] = "$";
		}
		if (player.inventory.inInventory(item5) == false){
			world[item5.y][item5.x] = "$";
		}
		
		//Monsters
		if (enemy1.enemyDead() == false){
			world[enemy1.y][enemy1.x] = "M";
		}
		if (enemy2.enemyDead() == false){
			world[enemy2.y][enemy2.x] = "M";
		}
		if (enemy3.enemyDead() == false){
			world[enemy3.y][enemy3.x] = "M";
		}

	}
>>>>>>> c2a085a97a226bc2bfb228dae5b3eedfa46f1915
}
