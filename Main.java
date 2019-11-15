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

		//Here is where we will upload the saved game if the user say yes.
		//####################################################
		//System.out.print("\nLoad Game...? Y/N");
		//String loadGameAnswer = in.next().toUpperCase();
		//if(loadGameAnswer.equals('Y'){
		//	System.out.println("What is the name of the file you want to load? ");
		//	String answer = in.next();
		//	System.out.println("[Loading saved game...]");



		System.out.print("[Username] What is your username? ");
		String userName = in.next();

		player = new Player(userName, health);

		World world = new World();

		//Print the objective of the game.
		world.printObjective();			
		//*****************************************************************************************

		//Print the commands.
		System.out.println("------------------------------------------------");
		world.printCommands();
		System.out.println("------------------------------------------------");

		//Put the player, items, and monster in the world, then print the world to the screen.
		world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
		world.printWorld();

		char input;

		do{
			System.out.println("------------------------------------------------");
			player.printInfo();
			player.getPlayerLocation();
			player.inventory.printOtherStats();
			System.out.print("[Answer] ");
			input = in.next().toUpperCase().charAt(0);
			System.out.println("------------------------------------------------");

			switch(input){
				case'H':
					player.move();
					//world.move(player); //goUp(player);
					if (enemy1.enemyDead(enemy1) == false){
						enemy1.move(); //world.move(enemy1);
					}
					if (enemy2.enemyDead(enemy2) == false){
						enemy1.move(); //world.move(enemy1);
					}
					if (enemy3.enemyDead(enemy3) == false){
						enemy1.move(); //world.move(enemy1);
					}
					world.fillWorld(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
					break;
				case'L':
					player.move();
					if (enemy1.enemyDead(enemy1) == false){
						enemy1.move(); //world.move(enemy1);
					}
					if (enemy2.enemyDead(enemy2) == false){
						enemy1.move(); //world.move(enemy1);
					}
					if (enemy3.enemyDead(enemy3) == false){
						enemy1.move(); //world.move(enemy1);
					}
					world.fillWorld(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);

					break;
				case'J':
					player.move();
					if (enemy1.enemyDead(enemy1) == false){
						enemy1.move(); //world.move(enemy1);
					}
					if (enemy2.enemyDead(enemy2) == false){
						enemy1.move(); //world.move(enemy1);
					}
					if (enemy3.enemyDead(enemy3) == false){
						enemy1.move(); //world.move(enemy1);
					}

					world.fillWorld(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
					break;
				case'K':
					player.move();
					if (enemy1.enemyDead(enemy1) == false){
						enemy1.move(); //world.move(enemy1);
					}
					if (enemy2.enemyDead(enemy2) == false){
						enemy1.move(); //world.move(enemy1);
					}
					if (enemy3.enemyDead(enemy3) == false){
						enemy1.move(); //world.move(enemy1);
					}

					world.fillWorld(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
					break;
				case'P':
					world.printCommands();
					break;
				case'I':
					player.inventory.print();
					break;
				case'D':
					player.inventory.drop(player);
					break;
				case'W':
					player.inventory.equipWeapon();
					break;
				case'A':
					player.inventory.equipArmor();
					break;
				case'N':
					break;
				case'Q':
					System.exit(1);
					break;
			}
			world.printWorld();
		}
		while(input != 'Q');
	}
}





