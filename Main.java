import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Main{


	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;

	public static void main(String args[]) throws InputMismatchException{
		Inventory playerInventory;
		Player player;
		//Setting the player's health.
		int health = 100;

		//Creating the monsters.
		enemy1 = MonsterGenerator.generateMonster();
		enemy2 = MonsterGenerator.generateMonster();
		enemy3 = MonsterGenerator.generateMonster();

		//Creating the items.
		item1 = ItemGenerator.generate();
		item2 = ItemGenerator.generate();
		item3 = ItemGenerator.generate();
		item4 = ItemGenerator.generate();
		item5 = ItemGenerator.generate();

		Scanner in = new Scanner(System.in);
		System.out.println("[Game Loading...]");

		System.out.print("[Username] What is your username? ");
		String userName = in.next();

		player = new Player(userName, health);
	
		//The player starts out with one health potion. 	
	//	Item healthPotion = new Item(ItemType.HealthPotion, "Health Potion", 2, 25, 100, 4, 5);
	//	player.inventory.addItem(healthPotion);

		World world = new World();
		//Rooms room1 = new Rooms();
		//Rooms room2 = new Rooms();
		
		//Print the objective of the game.
		world.printObjective();			

		//Print the commands.
		System.out.println("------------------------------------------------");
		world.printCommands();
		System.out.println("------------------------------------------------");

		//Put the player, items, and monster in the world, then print the world to the screen.
		world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);

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
					world.fillWorld(player, item1, item2, item3, item4, item5, enemy1, enemy2, enemy3);
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
					world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
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
					world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
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
					world.fillWorld(player, item1, item2, item3, item4,item5, enemy1, enemy2, enemy3);
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
					File file = new File("info.txt");
					PrintWriter pw = new PrintWriter (file);
					System.out.println("Would you like to save the game?(yes/no)");
					String ans = in.next();
					if (ans.equals("yes")) {
						Player.persist(pw);
						Enemy.persist(pw);
						Battles.persist(pw);
					}else if (ans.equals("no")){
						break;
					}
					System.exit(1);
					break;
	}
}
while(input != 'Q');
}
	public void persist (PrintWriter pw) {
		pw.println(enemy1.getName());
		pw.println(enemy1.typeOfMonster());
		pw.println(enemy1.getPositionX());
		pw.println(enemy1.getPositionY());
		pw.println(enemy1.getHealth());
		pw.println(enemy1.getDamage());

		pw.println(enemy2.getName());
                pw.println(enemy2.typeOfMonster());
                pw.println(enemy2.getPositionX());
                pw.println(enemy2.getPositionY());
                pw.println(enemy2.getHealth());
                pw.println(enemy2.getDamage());

		pw.println(enemy3.getName());
                pw.println(enemy3.typeOfMonster());
                pw.println(enemy3.getPositionX());
                pw.println(enemy3.getPositionY());
                pw.println(enemy3.getHealth());
                pw.println(enemy3.getDamage());

		pw.println(item1.getType());
		pw.println(item1.getName());
		pw.println(item1.getWeight());
		pw.println(item1.getValue());
		pw.println(item1.getStrength());
		pw.println(item1.getItemX());
		pw.println(item1.getItemY());

	       	pw.println(item2.getType());
                pw.println(item2.getName());
                pw.println(item2.getWeight());
                pw.println(item2.getValue());
                pw.println(item2.getStrength());
                pw.println(item2.getItemX());
                pw.println(item2.getItemY());

		pw.println(item3.getType());
                pw.println(item3.getName());
                pw.println(item3.getWeight());
                pw.println(item3.getValue());
                pw.println(item3.getStrength());
                pw.println(item3.getItemX());
                pw.println(item3.getItemY());

		pw.println(item4.getType());
                pw.println(item4.getName());
                pw.println(item4.getWeight());
                pw.println(item4.getValue());
                pw.println(item4.getStrength());
                pw.println(item4.getItemX());
                pw.println(item4.getItemY());

		pw.println(item5.getType());
                pw.println(item5.getName());
                pw.println(item5.getWeight());
                pw.println(item5.getValue());
                pw.println(item5.getStrength());
                pw.println(item5.getItemX());
                pw.println(item5.getItemY());
	}



}





