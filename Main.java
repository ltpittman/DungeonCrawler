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
	
		//The player starts out with one health potion. 	
	//	Item healthPotion = new Item(ItemType.HealthPotion, "Health Potion", 2, 25, 100, 4, 5);
	//	player.inventory.addItem(healthPotion);

		MainRoom mainRoom = new MainRoom();
		Rooms room1 = new Rooms();
		Rooms room2 = new Rooms();
		
		//Print the objective of the game.
		mainRoom.printObjective();			

		//Print the commands.
		System.out.println("------------------------------------------------");
		mainRoom.printCommands();
		System.out.println("------------------------------------------------");

		//Put the player, items, and monster in the world, then print the world to the screen.
		mainRoom.fillMainRoom(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);

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
					mainRoom.fillMainRoom(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
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
					mainRoom.fillMainRoom(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
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
					mainRoom.fillMainRoom(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
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
					mainRoom.fillMainRoom(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
					break;
				case'P':
					mainRoom.printCommands();
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
				case'X':
					room1.fillRoom1(player);
					continue;
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
			/*		switch(input){
						case'H':
							player.move();
							room2.fillRoom2(player,item1,item2);
							break;
						case'L':
							player.move();
							room2.fillRoom2(player,item1,item2);
							break;
						case'J':
							player.move();
							room2.fillRoom2(player,item1,item2);
							break;
						case'K':
							player.move();
							room2.fillRoom2(player,item1,item2);
							break;
					}
					break;
				case'X':
					world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
					break;*/
				case'Q':
					System.exit(1);
					break;
	}
}
while(input != 'Q');
}
	//public void persist


}





