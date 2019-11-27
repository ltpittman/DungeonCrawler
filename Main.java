import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileInputStream;

class Main{

	public static void main(String args[]) throws InputMismatchException, FileNotFoundException{

		Objective command = new Objective();

		World world = new World();	

		Inventory inventory;
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

					//FileInputStream f = new FileInputStream("info.txt");
					Scanner a = new Scanner (f);
					String open = a.nextLine();
					if (!open.equals("Saved")){
						System.out.println("There is no game saved. A new game will start shortly.");
					} else {
						player.restore(a);
						enemy1.restore(a);
						enemy2.restore(a);
						enemy3.restore(a);
						String noth = a.nextLine();
						item1.restore(a);
						noth = a.nextLine();
						item2.restore(a);
						noth = a.nextLine();
						item3.restore(a);
						noth = a.nextLine();
						item4.restore(a);
						noth = a.nextLine();
						item5.restore(a);
						player.inventory.restore(a);
						world.restore(a);
						a.close();
					}
			}catch (Exception e){
						System.out.println("File Not Found.");
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
			world.fillWorld(player, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3);

			char input;

			do{
				System.out.println("------------------------------------------------");
				player.printInfo();
				player.getLocation();
				player.inventory.printInventoryStats();
				world.printCurrentRoom();
				System.out.print("[Answer] ");
				input = in.next().toUpperCase().charAt(0); 
				System.out.println("------------------------------------------------");

				switch(input){
					case'H':
						player.goUp();
						if (enemy1.getIsDead() == false){
							enemy1.move();
						}
						if (enemy2.getIsDead() == false){
							enemy2.move();
						}
						if (enemy3.getIsDead() == false){
							enemy3.move();
						}
						world.fillWorld(player, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3);
						break;
					case'L':
						player.goDown();
						if (enemy1.getIsDead() == false){
							enemy1.move();
						}
						if (enemy2.getIsDead() == false){
							enemy2.move();
						}
						if (enemy3.getIsDead() == false){
							enemy3.move();
						}
						world.fillWorld(player, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3);
						break;
					case'J':
						player.goLeft();
						if (enemy1.getIsDead() == false){
							enemy1.move();
						}
						if (enemy2.getIsDead() == false){
							enemy2.move();
						}
						if (enemy3.getIsDead() == false){
							enemy3.move();
						}
						world.fillWorld(player, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, enemy1, enemy2, enemy3);
						break;
					case'K':
						player.goRight();
						if (enemy1.getIsDead() == false){
							enemy1.move();
						}
						if (enemy2.getIsDead() == false){
							enemy2.move();
						}
						if (enemy3.getIsDead() == false){
							enemy3.move();
						}
						world.fillWorld(player, item1, item2, item3, item4, item5,  enemy1, enemy2, enemy3);
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
					case'Q':
						System.out.print("Would you like to save the game? Y/N ");
						String ans = in.next().toUpperCase();
						if (ans.equals("Y")) {
							try{
								PrintWriter pw = new PrintWriter ("info.txt");
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




