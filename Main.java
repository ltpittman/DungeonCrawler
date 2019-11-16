import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Main{
	public static void main(String args[]) throws InputMismatchException{
		Inventory playerInventory;
		Player player;
		//Setting the player's health.
		int health = 100;

		//Creating the monsters.
		Enemy enemy1 = MonsterGenerator.generateMonster();
		Enemy enemy2 = MonsterGenerator.generateMonster();
		Enemy enemy3 = MonsterGenerator.generateMonster();

		//Creating the items.
		Item item1 = ItemGenerator.generate();
		Item item2 = ItemGenerator.generate();
		Item item3 = ItemGenerator.generate();
		Item item4 = ItemGenerator.generate();
		Item item5 = ItemGenerator.generate();

		Scanner in = new Scanner(System.in);
		System.out.println("[Game Loading...]");

		System.out.print("[Username] What is your username? ");
		String userName = in.next();

		player = new Player(userName, health);

		World world = new World();

		//Print the objective of the game.
		world.printObjective();			

		//Print the commands.
		System.out.println("------------------------------------------------");
		world.printCommands();
		System.out.println("------------------------------------------------");

		//Put the player, items, and monster in the world, then print the world to the screen.
		world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);

		String input;

		System.out.println("------------------------------------------------");
		player.printInfo();
		player.getLocation();
		player.inventory.printOtherStats();
		System.out.print("[Answer] ");
		input = in.next().toUpperCase(); 
		System.out.println("------------------------------------------------");

		if(input.equals("Q")){
			System.exit(1);
		}

		world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
		
		while(input != "Q"){
			System.out.println("------------------------------------------------");
			player.printInfo();
			player.getLocation();
			player.inventory.printOtherStats();
			System.out.println("------------------------------------------------");
			System.out.print("[Answer] ");

			player.move();
			world.fillWorld(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);

			if(input.equals("H")){
				if (enemy1.enemyDead(enemy1) == false){
					enemy1.move();
				}
				if (enemy2.enemyDead(enemy2) == false){
					enemy2.move();
				}
				if (enemy3.enemyDead(enemy3) == false){
					enemy3.move();
				}
				continue;
			}
			if(input.equals("L")){
				if (enemy1.enemyDead(enemy1) == false){
					enemy1.move();
				}
				if (enemy2.enemyDead(enemy2) == false){
					enemy2.move();
				}
				if (enemy3.enemyDead(enemy3) == false){
					enemy3.move();
				}
				continue;
			}
			if(input.equals("J")){
				if (enemy1.enemyDead(enemy1) == false){
					enemy1.move();
				}
				if (enemy2.enemyDead(enemy2) == false){
					enemy2.move();
				}
				if (enemy3.enemyDead(enemy3) == false){
					enemy3.move();
				}
				continue;
			}
			if(input.equals("K")){
				if (enemy1.enemyDead(enemy1) == false){
					enemy1.move();
				}
				if (enemy2.enemyDead(enemy2) == false){
					enemy2.move();
				}
				if (enemy3.enemyDead(enemy3) == false){
					enemy3.move();
				}
				continue;
			}
			if(input.equals("P")){
				world.printCommands();
			}
			if(input.equals("I")){
				player.inventory.print();
			}
			if(input.equals("D")){
				player.inventory.drop(player);
			}
			if(input.equals("W")){
				player.inventory.equipWeapon();
			}
			if(input.equals("A")){
				player.inventory.equipArmor();
			}
			//else{
			//	break;
			//}

		}
		}

}





