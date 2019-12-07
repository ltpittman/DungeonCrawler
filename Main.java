/**
 * Main class for the game. It creates a player, side character, items, monsters, and world. This class 
 * is needed to play the game. Here the player is able to tell the program to move up, down, left, or right, 
 * print their inventory, add or drop items, fight monsters, restore their health with a health potion, and 
 * load/save a game. The items and monsters  created in this class are randomly generated. 
 * @throws InputMismatchException Throws this exception when the user enters the wrong input.
 * @throws FileNotFoundException Throws this exception when a file cannot be found to upload.
 * @author Lauren Pittman, Tavion Britt, Grace Long.
 */

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileInputStream;

public class Main{

	public static void main(String args[]) throws InputMismatchException, FileNotFoundException{

		Objective command = new Objective();
		Interaction interaction = new Interaction();	

		World world = new World();

		SideCharacter explorer = new SideCharacter("Bolgraf", 100);

		Inventory inventory;
		Player player;
		//Setting the player's health.
		int health = 100;

		Battles battle = new Battles();
		Interaction interact = new Interaction();
		//Creating the monsters.
		Enemy enemy1 = MonsterGenerator.generateMonster();
		enemy1.setRoomNum(1);
		Enemy enemy2 = MonsterGenerator.generateMonster();
		enemy2.setRoomNum(1);
		Enemy enemy3 = MonsterGenerator.generateMonster();
		enemy3.setRoomNum(1);
		Enemy enemy4 = MonsterGenerator.generateMonster();
		enemy4.setRoomNum(2);
		Enemy enemy5 = MonsterGenerator.generateMonster();
		enemy5.setRoomNum(2);
		Enemy enemy6 = MonsterGenerator.generateMonster();
		enemy6.setRoomNum(2);
		Enemy enemy7 = MonsterGenerator.generateMonster();
		enemy7.setRoomNum(3);
		Enemy enemy8 = MonsterGenerator.generateMonster();
		enemy8.setRoomNum(3);
		Enemy enemy9 = MonsterGenerator.generateMonster();
		enemy9.setRoomNum(3);

		//Creating the items.
		Item item1 = ItemGenerator.generate();   
		item1.setRoomNum(1);
		Item item2 = ItemGenerator.generate();
		item2.setRoomNum(1);
		Item item3 = ItemGenerator.generate();   
		item3.setRoomNum(1);
		Item item4 = ItemGenerator.generate();
		item4.setRoomNum(1);
		Item item5 = ItemGenerator.generate();
		item5.setRoomNum(1);
		
		Item item6 = ItemGenerator.generate();
		item6.setRoomNum(2);
		Item item7 = ItemGenerator.generate();   
		item7.setRoomNum(2);
		Item item8 = ItemGenerator.generate();   
		item8.setRoomNum(2);
		Item item9 = ItemGenerator.generate();   
		item9.setRoomNum(2);
		Item item10 = ItemGenerator.generate();   
		item10.setRoomNum(2);

		Item item11 = ItemGenerator.generate();   
		item11.setRoomNum(3);
		Item item12 = ItemGenerator.generate();   
		item12.setRoomNum(3);
		Item item13 = ItemGenerator.generate();   
		item13.setRoomNum(3);
		Item item14 = ItemGenerator.generate();   
		item14.setRoomNum(3);
		Item item15 = ItemGenerator.generate();   
		item15.setRoomNum(3);
		
		Item key1 = KeyGenerator.generateKey();
		Item key2 = KeyGenerator.generateKey();

		Scanner in = new Scanner(System.in);
		System.out.println("[Game Loading...]");
		System.out.print("[Name] What is your name? ");
		String userName = in.nextLine();

		player = new Player(userName, health);
		File f;

		//Ask player if they would like to continue with saved game. If no game is saved print no game is saved and continue
		System.out.print("[Option] Would you like to continue with a saved game, " + userName + "? Y/N ");

		String inputAnswer = in.next().toUpperCase();
		if(inputAnswer.equals("Y")){
			try {
				f = new File("info.txt");
				Scanner a = new Scanner (f);
				String open = a.nextLine();
				if (!open.equals("Saved")){
					System.out.println("There is no game saved. A new game will start shortly.");
				} else {
					player.restore(a);
					explorer.restore(a);
					enemy1.restore(a);
					enemy2.restore(a);
					enemy3.restore(a);
					enemy4.restore(a);
					enemy5.restore(a);
					enemy6.restore(a);
					enemy7.restore(a);
					enemy8.restore(a);
					enemy9.restore(a);
					item1.restore(a);
					String noth = a.nextLine();
					item2.restore(a);
					noth = a.nextLine();
					item3.restore(a);
					noth = a.nextLine();
					item4.restore(a);
					noth = a.nextLine();
					item5.restore(a);
					noth = a.nextLine();
					item6.restore(a);
					noth = a.nextLine();
					item7.restore(a);
					noth = a.nextLine();
					item8.restore(a);
					noth = a.nextLine();
					item9.restore(a);
					noth = a.nextLine();
					item10.restore(a);
					noth = a.nextLine();
					item11.restore(a);
					noth = a.nextLine();
					item12.restore(a);
					noth = a.nextLine();
					item13.restore(a);
					noth = a.nextLine();
					item14.restore(a);
					noth = a.nextLine();
					item15.restore(a);
					noth = a.nextLine();
					key1.restore(a);
					noth = a.nextLine();
					key2.restore(a);
					noth = a.nextLine();
					player.inventory.restore(a);
					world.restore(a);
					a.close();
				}
			}
			catch (Exception e){
				System.out.println("There is no game saved. A new game will start shortly.");
			}
		}

		System.out.println("------------------------------------------------");

		//Print the objective of the game.
		command.printObjective();			

		//Print the commands.
		System.out.println("------------------------------------------------");
		command.printCommands();
		System.out.println("------------------------------------------------");



		//Put the player, items, and monster in the world, then print the world to the screen.
		world.fillWorld(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8, enemy9);

		char input;

		do{
			System.out.println("------------------------------------------------");
			world.printCurrentRoom();
			player.printInfo();
			player.getLocation();
			player.inventory.printInventoryStats();
			System.out.print("[Answer] ");
			input = in.next().toUpperCase().charAt(0); 
			System.out.println("------------------------------------------------");

			switch(input){
				case'H':
					player.goUp();
					if(player.y == enemy1.y && player.x == enemy1.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy2.y && player.x == enemy2.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy3.y && player.x == enemy3.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy4.y && player.x == enemy4.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy5.y && player.x == enemy5.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy6.y && player.x == enemy6.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy7.y && player.x == enemy7.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy8.y && player.x == enemy8.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy9.y && player.x == enemy9.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == explorer.y && player.x == explorer.x){
						interact.interactCharacters(player,explorer);
					}

					explorer.move();
					if (enemy1.getIsDead() == false){
						enemy1.move();
					}
					if (enemy2.getIsDead() == false){
						enemy2.move();
					}
					if (enemy3.getIsDead() == false){
						enemy3.move();
					}
					if (enemy4.getIsDead() == false){
						enemy4.move();
					}
					if (enemy4.getIsDead() == false){
						enemy5.move();
					}
					if (enemy5.getIsDead() == false){
						enemy6.move();
					}
					if (enemy6.getIsDead() == false){
						enemy7.move();
					}
					if (enemy8.getIsDead() == false){
						enemy8.move();
					}
					if (enemy9.getIsDead() == false){
						enemy9.move();
					}
					world.fillWorld(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8, enemy9);
					break;
				case'L':
					player.goDown();
					if(player.y == enemy1.y && player.x == enemy1.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy2.y && player.x == enemy2.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy3.y && player.x == enemy3.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy4.y && player.x == enemy4.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy5.y && player.x == enemy5.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy6.y && player.x == enemy6.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy7.y && player.x == enemy7.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy8.y && player.x == enemy8.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy9.y && player.x == enemy9.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == explorer.y && player.x == explorer.x){
						interact.interactCharacters(player,explorer);
					}
					explorer.move();
					if (enemy1.getIsDead() == false){
						enemy1.move();
					}
					if (enemy2.getIsDead() == false){
						enemy2.move();
					}
					if (enemy3.getIsDead() == false){
						enemy3.move();
					}
					if (enemy4.getIsDead() == false){
						enemy4.move();
					}
					if (enemy5.getIsDead() == false){
						enemy5.move();
					}
					if (enemy6.getIsDead() == false){
						enemy6.move();
					}
					if (enemy7.getIsDead() == false){
						enemy7.move();
					}
					if (enemy8.getIsDead() == false){
						enemy8.move();
					}
					if (enemy9.getIsDead() == false){
						enemy9.move();
					}
					world.fillWorld(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8, enemy9);
					break;
				case'J':
					player.goLeft();
					if(player.y == enemy1.y && player.x == enemy1.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy2.y && player.x == enemy2.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy3.y && player.x == enemy3.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy4.y && player.x == enemy4.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy5.y && player.x == enemy5.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy6.y && player.x == enemy6.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy7.y && player.x == enemy7.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy8.y && player.x == enemy8.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy9.y && player.x == enemy9.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == explorer.y && player.x == explorer.x){
						interact.interactCharacters(player,explorer);
					}
					explorer.move();
					if (enemy1.getIsDead() == false){
						enemy1.move();
					}
					if (enemy2.getIsDead() == false){
						enemy2.move();
					}
					if (enemy3.getIsDead() == false){
						enemy3.move();
					}
					if (enemy4.getIsDead() == false){
						enemy4.move();
					}
					if (enemy5.getIsDead() == false){
						enemy5.move();
					}
					if (enemy6.getIsDead() == false){
						enemy6.move();
					}
					if (enemy7.getIsDead() == false){
						enemy7.move();
					}
					if (enemy8.getIsDead() == false){
						enemy8.move();
					}
					if (enemy9.getIsDead() == false){
						enemy9.move();
					}
					world.fillWorld(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8, enemy9);
					break;
				case'K':
					player.goRight();
					if(player.y == enemy1.y && player.x == enemy1.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy2.y && player.x == enemy2.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy3.y && player.x == enemy3.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy4.y && player.x == enemy4.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy5.y && player.x == enemy5.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy6.y && player.x == enemy6.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy7.y && player.x == enemy7.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy8.y && player.x == enemy8.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == enemy9.y && player.x == enemy9.x){
						battle.attack(player,enemy1);
					}
					else if(player.y == explorer.y && player.x == explorer.x){
						interact.interactCharacters(player,explorer);
					}
					explorer.move();
					if (enemy1.getIsDead() == false){
						enemy1.move();
					}
					if (enemy2.getIsDead() == false){
						enemy2.move();
					}
					if (enemy3.getIsDead() == false){
						enemy3.move();
					}
					if (enemy4.getIsDead() == false){
						enemy4.move();
					}
					if (enemy5.getIsDead() == false){
						enemy5.move();
					}
					if (enemy6.getIsDead() == false){
						enemy6.move();
					}
					if (enemy7.getIsDead() == false){
						enemy7.move();
					}
					if (enemy8.getIsDead() == false){
						enemy8.move();
					}
					if (enemy9.getIsDead() == false){
						enemy9.move();
					}
					world.fillWorld(player, explorer, key1, key2, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, enemy8, enemy9);
					break;
				case'P':
					command.printCommands();
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
				case'R':
					player.inventory.drinkHealthPotion();
					player.restoreHealth();
					break;
				case'Q':
					System.out.print("Would you like to save the game? Y/N ");
					String ans = in.next().toUpperCase();
					if (ans.equals("Y")) {
						try{
							PrintWriter pw = new PrintWriter ("info.txt");
							player.persist(pw);
							explorer.persist(pw);
							enemy1.persist(pw);
							enemy2.persist(pw);
							enemy3.persist(pw);
							enemy4.persist(pw);
							enemy5.persist(pw);
							enemy6.persist(pw);
							enemy7.persist(pw);
							enemy8.persist(pw);
							enemy9.persist(pw);
							item1.persist(pw);
							item2.persist(pw);
							item3.persist(pw);
							item4.persist(pw);
							item5.persist(pw);
							item6.persist(pw);
							item7.persist(pw);
							item8.persist(pw);
							item9.persist(pw);
							item10.persist(pw);
							item11.persist(pw);
							item12.persist(pw);
							item13.persist(pw);
							item14.persist(pw);
							item15.persist(pw);
							key1.persist(pw);
							key2.persist(pw);
							player.inventory.persist(pw);
							world.persist(pw);
							pw.close();
						}
						catch(FileNotFoundException e){
							System.out.println("Could not find anything.");
						}		
					}
					else if (ans.equals("N")){
						break;
					}
					System.exit(1);
					break;
			}
		}
		while(input != 'Q');
	}
}




