import java.util.Scanner;
/*In this class we have the methods for when a character and an enemy attack
 * each other. There are four methods, attack, playerWins, playerLoses, and
 * playerDeath.
 */
class Battles{
	Player player;
	Enemy enemy;	
	Inventory inventory;
	Item equippedArmor;
	Item equippedWeapon;

	private int numberMonster = 3;
	private static int healthEnemy;
	private int difference;

	//In this method we compare the health and the strength of the enemy and the player. Based on the strength of each we name a winner of the fight and modify the Health of both. If the player wins then we modify the number of monsters left in the game.
	public void attack(Player player, Enemy enemy){

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

		System.out.println();
		System.out.println("[Player Health] " + healthPlayer + " pts.");
		System.out.println("[Player Strength] " + strengthArmor + " pts.");
		System.out.println("[Enemy Health] " + strengthEnemy + " pts.");
		System.out.println();

		while(healthEnemy > 0){

			if(healthPlayer > 0){
				System.out.println("What would you like to do?");
				System.out.println("1. Attack the monster!");
				System.out.println("2. Run away!");
				System.out.print("[Answer}");

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
					System.out.println("Your health is now " + healthPlayer + "/100.\n");
					System.out.println("You attack the " + enemyName + " with a damage of " + strengthPlayer + "!");


					//If the enemy's health is less than 1, then the player defeated the monster.
					if(healthEnemy < 1){
						System.out.println("The enemy's health has reached 0/100.");
						System.out.println("You have defeated the monster!");
						//Subtract one from the numberMonster variable. 
						numberMonster = numberMonster - 1;
					}
					else{
						System.out.println("The enemy's health is now " + healthEnemy + "/100.\n");
					}

					//If the player's health is less than 1, the player loses and the game exits.
					if(healthPlayer < 1){
						System.out.println("You have been defeated... Restart the game to play again!");
						playerLoses();
					}
					//If there are no monsters left, then the player wins.
					if(numberMonster == 0){
						playerWins();
					}
				}
				else{
					break;
				}
			}
		}
	}
	//In this method we determine if the player has lost the game. We do this by looking at the player's health.
	public void playerLoses(){

		System.out.println("The monsters have defeated you... you lost :(");
		System.exit(1);
	}
	public static int getNewHealth(){
		return healthEnemy;
	}	
	//In this method we determin if the player won after the battle. We do this by seeing how many monsters are left. Once all the monsters have been killed the player wins.
	public void playerWins(){
		if(numberMonster < 1){
			System.out.println("Woohoo! You have defeated all the monsters and won the game!!");
			System.exit(1);
		}
		else{
			return;
		}
	}
}

