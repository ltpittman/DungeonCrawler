import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Main{

	public static void main(String args[]) throws InputMismatchException{
		//Inventory playerInventory;
		Player player;
		//Setting the player's health.
		int health = 100;
		File file = new File("info.txt");

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

		//Ask player if they would like to continue with saved game. If no game is saved print no game is saved and continue
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Would you like to continue with a saved game?(Y/N)");
		String inputAns = in.next().toUpperCase();
		if (inputAns.equals("Y")){
			if (file.length() == 0){
				System.out.println("There is no game saved. A new game will start shortly.");
			} else {
				player.restore("info.txt");
				enemy1.restore("info.txt");
				enemy2.restore("info.txt");
				enemy3.restore("info.txt");
				item1.restore("info.txt");
				item2.restore("info.txt");
				item3.restore("info.txt");
				item4.restore("info.txt");
				item5.restore("info.txt");
				player.inventory.restore("info.txt");
			}
		}



		System.out.print("[Name] What is your name? ");
		String userName = in.next();

		player = new Player(userName, health);

		//The player starts out with one health potion. 	
		//Item healthPotion = new Item(ItemType.HealthPotion, "Health Potion", 2, 25, 100, 4, 5);
		//player.inventory.addItem(healthPotion);

		World world = new World();	
		//World room1 = new World();
		//Rooms room2 = new Rooms();
		//Rooms room3 = new Rooms(); 

		//Print the objective of the game.
		world.printObjective();			

		//Print the commands.
		System.out.println("------------------------------------------------");
		world.printCommands();
		System.out.println("------------------------------------------------");
		//Put the player, items, and monster in the world, then print the world to the screen.
		world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3, 1);
		world.printWorld();
		//room1.printRoom();

		char input;

		do{
			System.out.println("------------------------------------------------");
			player.printInfo();
			player.getLocation();
			player.inventory.printOtherStats();
			System.out.print("[Answer] ");
			input = in.next().toUpperCase().charAt(0); 
			System.out.println("------------------------------------------------");

			switch(input){
				case'H':
					player.goUp();
					if (enemy1.enemyDead(enemy1) == false){
						enemy1.move();
					}
					if (enemy2.enemyDead(enemy2) == false){
						enemy2.move();
					}
					if (enemy3.enemyDead(enemy3) == false){
						enemy3.move();
					}
					//	world.fillWorld(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3, 1);
					break;
				case'L':
					player.goDown();
					if (enemy1.enemyDead(enemy1) == false){
						enemy1.move();
					}
					if (enemy2.enemyDead(enemy2) == false){
						enemy2.move();
					}
					if (enemy3.enemyDead(enemy3) == false){
						enemy3.move();
					}
					//	world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3, 1);
					break;
				case'J':
					player.goLeft();
					if (enemy1.enemyDead(enemy1) == false){
						enemy1.move();
					}
					if (enemy2.enemyDead(enemy2) == false){
						enemy2.move();
					}
					if (enemy3.enemyDead(enemy3) == false){
						enemy3.move();
					}
					//	world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3, 1);
					break;
				case'K':
					player.goRight();
					if (enemy1.enemyDead(enemy1) == false){
						enemy1.move();
					}
					if (enemy2.enemyDead(enemy2) == false){
						enemy2.move();
					}
					if (enemy3.enemyDead(enemy3) == false){
						enemy3.move();
					}
					//	world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3, 1);
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
					//	case'R':
					//		player.inventory.drinkHealthPotion(healthPotion);
					//		break;
					//case'E':
					//		System.out.println("You move aside the heavy rocks to create an opening...");
					//		System.out.println("You manage to fit your body through the rocks and enter the room...");
					//		room1.fillRoom1();
					//	break;
					//	case'R':
					//		System.out.println("You move aside the heavy rocks to create an opening...");
					//		System.out.println("You manage to fit your body through the rocks and enter the room...");
					//		room2.fillRoom2(player,item1, item2);
					//		
				case'Q':
					try{
						PrintWriter pw = new PrintWriter (file);
						System.out.print("Would you like to save the game? Y/N ");
						String ans = in.next().toUpperCase();
						if (ans.equals("Y")) {
							player.persist(pw);
							enemy1.persist(pw);
							enemy2.persist(pw);
							enemy3.persist(pw);
							item1.persist(pw);
							item2.persist(pw);
							item3.persist(pw);
							item4.persist(pw);
							item5.persist(pw);
							player.inventory.persist(pw);
						}
						else if (ans.equals("N")){
							break;
						}}
					catch(FileNotFoundException e){
						System.out.println("Could not find anything.");
					}
					System.exit(1);
					break;
			}
		}
		while(input != 'Q');
	}

}





