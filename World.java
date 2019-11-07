import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

class World{
	public String[][] world;
	public int rows;
	public int columns;
	public Enemy enemy;
	Battles battle = new Battles();

	//Method to create the room.
	World(){
		this.rows = 18;
		this.columns = 36;
		world = new String[rows][columns];
	}
	//Method to fill the world with the players, items, and enemies.
	public void fillWorld(Player player, Item item1, Item item2, Item item3, Item item4, Enemy enemy1, Enemy enemy2, Enemy enemy3){

		//Fill the 2D array.
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				if((i == 0) || (j == 0) || (i == rows - 1) || (j == columns - 1)){
					world[i][j] = "#";
				}
				else{
					world[i][j] = ".";
				}
			}
		}
		//Items.
		world[item1.y][item1.x] = "$";
		world[item2.y][item2.x] = "$";
		world[item3.y][item3.x] = "$";
		world[item4.y][item4.x] = "$";
		
		//Monsters.
		if (enemy1.enemyDead(enemy1) == false){
			world[enemy1.y][enemy1.x] = "M";
		}
		if (enemy2.enemyDead(enemy2) == false){
			world[enemy2.y][enemy2.x] = "M";
		}
		if (enemy3.enemyDead(enemy3) == false){
			world[enemy3.y][enemy3.x] = "M";
		}
		
		//Player.
		world[player.y][player.x] = "@";

		//Here is where the player will pick up a item they found.
		if (player.y == item1.y && player.x == item1.x && !player.inventory.items.contains(item1)){
			System.out.println("[Attention!] You just came across: " + item1.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			//If the user takes the item, delete the item from the map.
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item1);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if (player.y == item2.y && player.x == item2.x && !player.inventory.items.contains(item2)){
			System.out.println("[Attention!] You just came across: " + item2.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item2);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if (player.y == item3.y && player.x == item3.x && !player.inventory.items.contains(item3)){
			System.out.println("[Attention!] You just came across: " + item3.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item3);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		if (player.y == item4.y && player.x == item4.x && !player.inventory.items.contains(item4)){
			System.out.println("[Attention!] You just came across: " + item4.getName());
			System.out.print("Do you want to pick this item up and add it to your inventory? Y/N ");
			Scanner scan = new Scanner(System.in);
			String input = scan.next().toUpperCase();
			if (input.equals("Y")){
				player.inventory.addItem(item4);
			}
			else{
				System.out.println("You decided to not pick up the item and continue to explore the area...");
			}
		}
		//Here is where the player and enemy will fight if they land on the same area.
		if (player.y == enemy1.y && player.x == enemy1.x){
			System.out.println("[Attention!] You just came across a " + enemy1.getName() + ". Prepare to fight!");
			battle.attack(player, enemy1);
			enemy1.enemyDead(enemy1);
		}else if (player.y == enemy2.y && player.x == enemy2.x){
			System.out.println("[Attention!] You just came across a " + enemy2.getName() + ". Prepare to fight!");
			battle.attack(player, enemy2);
			enemy2.enemyDead(enemy2);
		}else if (player.y == enemy3.y && player.x == enemy3.x){
			System.out.println("[Attention!] You just came across a " + enemy3.getName() + ". Prepare to fight!");
			battle.attack(player, enemy3);
			enemy3.enemyDead(enemy3);
		}

}
//Method to print the world.
public void printWorld(){
	//Print the 2D array.
	for(int i = 0; i < rows; i++){
		for(int j = 0; j < columns; j++){
			System.out.print(world[i][j]);
		}
		System.out.println();
	}
}
//Method to have the player go up.
public boolean goUp(Player player){
	if((player.y - 1) == 0){
		System.out.println("[You can't go up in that direction.]");
		return false;
	}
	else{
		player.y -= 1;
		//player.y = player.y - 1;
		return true;
	}
}
//Method to have the player go down.
public boolean goDown(Player player){
	if((player.y + 1) == 17){
		System.out.println("[You can't go down in that direction.]");
		return false;
	}
	else{
		player.y += 1;
		//player.y = player.y - 1;
		return true;
	}
}
//Method to have the player go left.
public boolean goLeft(Player player){
	if((player.x - 1) == 0){
		System.out.println("[You can't go left in that direction.]");
		return false;
	}
	else{
		player.x -= 1;
		//player.x = player.x - 1;
		return true;
	}
}
//Method to have the player go right.
public boolean goRight(Player player){
	if((player.x + 1) == 35){
		System.out.println("[You can't go right in that direction.]");
		return false;
	}
	else{
		player.x += 1;
		return true;
	}
}
//Method for moving the monsters.
public boolean moveMonster(Enemy move){

	Random random = new Random();
	int mm = random.nextInt(4);

	//Going right.
	if(mm == 0){
		if(move.x + 1 == 35){
			return false;
		}
		else{
			move.x += 1;
			return true;
		}
	}
	//Going left.
	else if(mm == 1){
		if(move.x - 1 == 0){
			return false;
		}
		else{
			move.x -=1;
			return true;
		}
	}
	//Go up.
	else if(mm == 2){
		if(move.y - 1 == 0){
			return false;
		}
		else{
			move.y -= 1;
			return true;
		}
	}
	//Go down.
	else if(mm == 3){
		if(move.y + 1 == 17){
			return false;
		}
		else{
			move.y += 1;
			return true;
		}
	}
	else{
		return false;
	}
}
//Method to print the commands to the user.
void printCommands(){
	System.out.println("[How to Play]:\nPress 'H' to go up.\nPress 'L' to go down.\nPress 'J' to go left.\nPress 'K' to go right.\nPress 'I' to print your inventory.\nPress 'D' to drop an item from your inventory.\nPress 'W' to equip a weapon from your inventory.\nPress 'A' to equip armor from your inventory.\nPress 'P' to print the commands to read again.");
}
//Method to print the objective of the game.
void printObjective(){
	System.out.println("\n[Welcome to Dungeon Crawler!]...\n   The overall objective of the game is to fight all the monsters that you encounter and make it out of the dungeon alive. To begin, your health will start at 100/100. You will have two items in your inventory: a sword and a piece of armor. While out searching for monsters, you have the option to pick up random items, whether it is a piece of armor, a weapon, etc.\n    You may switch your weapon and armor for something different that you find anytime. When it comes to fighting the monsters, it's all about luck. If you win a battle against a monster, you will be able to continue exploring the area and fight any more monsters you come across. If you are able to kill all the monsters in the dungeon, then you have won the game! [Good luck!]"); 
}
}
