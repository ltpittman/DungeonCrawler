/**This class is where the player and a side character will have a conversation with each other. Here the player will be able to ask the side characrer who they are, why they are down in the dungeon, and if they could have any health potions or a item (such as a weapon or piece of armor). 
 * @author Lauren Pittman, Tavion Britt, Grace Long
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Interaction{
	World world;
	Player player;
	Inventory inventory;
	SideCharacter character;

	/**In this method, we have a conversation between the player and a side character. The player will be able to ask the side character who they are, why they are down in the dungeon, and if they could have any health potions or a item (such as a weapon or piece of armor). This will happen through a while loop that will only break when the player inputs the number to cancel. The amount of health potions that the player can receive is unlimited.
	 * @param player
	 * @param character
	 */
	public void interactCharacters(Player player, SideCharacter character){

		String characterName = character.getName();

		System.out.println();

		boolean running = false;

		while(true){

			System.out.println("1. Who are you..? ");
			System.out.println("2. What are you doing down here? ");
			System.out.println("3. Do you have any extra health potions that I can have? ");
			System.out.println("4. Do you have any items I can borrow? ");
			System.out.println("5. Cancel ");
			System.out.print("[Answer] ");

			Scanner in = new Scanner(System.in);
			int input = in.nextInt();

			if(input == 1){
				
				System.out.println();
				System.out.println("[" + characterName + "] Hello, my fellow adventurer!\nMy name is " + characterName + "! It's funny running into another explorer down here. What can I do for you? ");
				System.out.println();
				running = true;
				try{
					Thread.sleep(2000);
				}
				catch(InterruptedException e){
					System.out.println(e);
				}
			}
			else if(input == 2){
				
				System.out.println();
				System.out.println("[" + characterName + "] What am I doing down here? I could say the same thing about you!\nJust like yourself I love to explore and fight monsters. I have been doing this since I was a young kid with my father. In fact, I love to see new explorers like yourself taking on such strong monsters! If you happen to need anything, just let me know and I may have what you need!");
				System.out.println();
				running = true;
				try{
					Thread.sleep(3000);
				}
				catch(InterruptedException e){
					System.out.println(e);
				}
			}
			else if(input == 3){
				
				System.out.println();
				System.out.println("[" + characterName + "] I have a few health potions to spare. Here you can have one!");
				Item healthPotion = new Item(ItemType.HealthPotion, "Health Potion", 2, 25, 100, 0, 0, 1);
				player.inventory.addItem(healthPotion);
				System.out.println();
				running = true;
				try{
					Thread.sleep(2000);
				}
				catch(InterruptedException e){
					System.out.println(e);
				}

			}
			else if(input == 4){

				Item item = SideCharacterItemGenerator.generate();
				System.out.println();
				System.out.println("[" + characterName + "] I may have something that can be useful... Hope this can help!");
				player.inventory.addItem(item);
				System.out.println();
				System.out.println();
				running = true;
				try{
					Thread.sleep(2000);
				}
				catch(InterruptedException e){
					System.out.println(e);
				}
			}
			else if(input == 5){
				running = false;
				break;
			}
		}
	}
}





