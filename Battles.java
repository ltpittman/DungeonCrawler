import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.InputMismatchException;

/**
 *Battles represents when the enemy and player attack each other. After the attack the player's health and the number of monsters left on the board is checked to see if the player won or lost the game.
 * @author Lauren Pittman, Tavion Britt, Grace Long
 */

public class Battles{
	World world;
	Player player;
	Enemy enemy;	
	Inventory inventory;
	Item equippedArmor;
	Item equippedWeapon;

	private int numberOfMonsters = 9;
	private static int healthEnemy;
	private int difference;

	/**
	 * In this method we compare the health and the strength of the enemy  and the player. Based on the strength of each we name a winner of the fight and modify the Health of both. If a monster is killed the number of monsters on the board is decreased.
	 * @param player The player that is fighting the enemy.
	 * @param enemy The enemy that is being attacked.
	 *
	 */
	public void attack(Player player, Enemy enemy) throws InputMismatchException {
		//Get the equipped armor of the player.
		equippedArmor = player.getEquippedArmor();
		//Get the equipped weapon of the player.
		equippedWeapon = player.getEquippedWeapon();

		int healthPlayer = player.getHealth();
		//The player damage is the strength of their weapon.
		int strengthPlayer = equippedWeapon.getStrength();
		//The player's strength for their armor.	
		int strengthArmor = equippedArmor.getStrength();

		String enemyName = enemy.getName();
		healthEnemy = enemy.getHealth();
		int strengthEnemy = enemy.getDamage();

		System.out.println("[Attention!] You just came cross a " + enemy.getName() + ". Prepare to fight!");
		
		while(healthEnemy > 0){
			//System.out.println("[Attention!] You just came cross a " + enemy.getName() + ". Prepare to fight!");
			if(healthPlayer > 0){
				System.out.println("What would you like to do?");
				System.out.println("1. Attack the monster!");
				System.out.println("2. Run away!");
				System.out.print("[Answer] ");
				
				Scanner in = new Scanner(System.in);
				int answer = in.nextInt();

				if(answer == 1){
					difference = strengthArmor - strengthEnemy;
					if (difference < 0){
						healthPlayer = healthPlayer + difference;
					} 
					else{
						healthPlayer = healthPlayer;
					}

					healthEnemy = healthEnemy - strengthPlayer;

					player.setHealth(healthPlayer);
					enemy.setHealth(healthEnemy);

					if(healthPlayer <= 0){
						playerLoses();
					}
					System.out.println("\nThe " + enemyName + " attacked you with a damage of " + strengthEnemy + "...");
					try{
						Thread.sleep(1000);
					} 
					catch(InterruptedException e){
						System.out.println(e);
					}

					System.out.println("Your health is now " + healthPlayer + "/100.\n");

					try{
						Thread.sleep(1000);
					} 
					catch(InterruptedException e){
						System.out.println(e);
					}

					System.out.println("You attack the " + enemyName + " with a damage of " + strengthPlayer + "!");

					//If the enemy's health is less than 1, then the player defeated the monster.
					if(healthEnemy < 1){
						System.out.println("The enemy's health has reached 0/100.");
						System.out.println("You have defeated the monster!");
						player.move();
						//Subtract one from the numberMonster variable. 
						numberOfMonsters = numberOfMonsters - 1;
						if(numberOfMonsters == 0){
							playerWins();
						}
						boolean dead = true;
						enemy.setIsDead(dead);
					}
					else{
						System.out.println("The enemy's health is now " + healthEnemy + "/100.\n");
						try{
							Thread.sleep(1000);
						}
						catch(InterruptedException e){
							System.out.println(e);
						}

					}

					//If the player's health is less than 1, the player loses and the game exits.
					if(healthPlayer < 1){
						System.out.println("You have been defeated... Restart the game to play again!");
						playerLoses();
					}
				}
				else if(answer == 2){
					player.move();
					System.out.println("You dodge the monster's last attack and try to get away...");
					break;

				}
				else if(answer != 1 || answer != 2){
					System.out.println("\nInvalid answer. Please enter in a valid number.");
				}
			}
		}
	}
	/**
	 *In this method the health is updated for the enemy. 
	 * @return Returns the updated health of the enemy.
	 */
	public static int getNewHealth(){
		return healthEnemy;
	}

	/**
	 *In this methd we determine if the player has lost the game. This is concluded by looking at the player's health. If the player's health is less than zero, then the player loses the game.
	 */
	public void playerLoses(){

		System.out.println("The monsters have defeated you... you lost :(");
		System.exit(1);
	}

	/**
	 * In this method we determine if the player won the game. A player wins the game if there are no more monsters left on the board.
	 */	
	public void playerWins(){
			System.out.println("Woohoo! You were able to kill all monsters and won the game!!");
			System.exit(1);
			return;
	}


}

