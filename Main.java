import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

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

		Scanner in = new Scanner(System.in);
		System.out.println("[Game Loading...]");

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
		world.fillWorld(player, item1, item2, item3, item4, enemy1, enemy2, enemy3);
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
					world.goUp(player);
					if (enemy1.enemyDead(enemy1) == false){
						world.moveMonster(enemy1);
					}
					if (enemy2.enemyDead(enemy2) == false){
						world.moveMonster(enemy2);
					}
					if (enemy3.enemyDead(enemy3) == false){
						world.moveMonster(enemy3);
					}
					world.fillWorld(player, item1, item2, item3, item4, enemy1, enemy2, enemy3);
					break;
				case'L':
					world.goDown(player);
					if (enemy1.enemyDead(enemy1) == false){
						world.moveMonster(enemy1);
					}
					if (enemy2.enemyDead(enemy2) == false){
						world.moveMonster(enemy2);
					}
					if (enemy3.enemyDead(enemy3) == false){
						world.moveMonster(enemy3);
					}
					world.fillWorld(player, item1, item2, item3, item4, enemy1, enemy2, enemy3);

					break;
				case'J':
					world.goLeft(player);
					if (enemy1.enemyDead(enemy1) == false){
						world.moveMonster(enemy1);
					}
					if (enemy2.enemyDead(enemy2) == false){
						world.moveMonster(enemy2);
					}
					if (enemy3.enemyDead(enemy3) == false){
						world.moveMonster(enemy3);
					}

					world.fillWorld(player, item1, item2, item3, item4, enemy1, enemy2, enemy3);
					break;
				case'K':
					world.goRight(player);
					if (enemy1.enemyDead(enemy1) == false){
						world.moveMonster(enemy1);
					}
					if (enemy2.enemyDead(enemy2) == false){
						world.moveMonster(enemy2);
					}
					if (enemy3.enemyDead(enemy3) == false){
						world.moveMonster(enemy3);
					}

					world.fillWorld(player, item1, item2, item3, item4, enemy1, enemy2, enemy3);
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





