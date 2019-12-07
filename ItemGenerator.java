/**
 * A <tt>ItemGenerator</tt> is a generator that produced a random time from an array of items. These items are
 * placed on the board for the player to add to their inventory and use. Since it is a random generator, 
 * there can be multiple items of the same type in the game.
 * @author Lauren Pittman, Tavion Britt, Grace Long
 */

import java.util.Random;

public class ItemGenerator{

	/**
	 * Produce a random number that is used to pick a item from the array. This item will then me added to 
	 * the game board.
	 * @return random item
	 */
	public static Item generate(){
		
		Random rng = new Random();
		//Will get a random number between 0 and 26.
		Item poss[] = new Item[29];

	 	//Item type, Item name, weight, value, strength, x and y, and roomNumber.	
		poss[0] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 5, 23, 1);
		
		poss[1] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 10, 5, 1);
		
		poss[2] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 9, 6, 1);	
		
		poss[3] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 4, 19, 1);	
		
		poss[4] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 6, 28, 1);	
		


		poss[5] = new Item(ItemType.Armor,"Hunting Armor", 29, 146, 15, 5, 13, 1);
		
		poss[6] = new Item(ItemType.Armor,"Iron Armor", 38, 298, 16, 10, 7, 1);

		poss[7] = new Item(ItemType.Armor,"Branded Iron Armor", 42, 388, 17, 6, 5, 1);
		
		poss[8] = new Item(ItemType.Armor,"Steel Armor", 47, 456, 18, 6, 4, 1);

		poss[9] = new Item(ItemType.Armor,"Branded Steel Armor", 47, 424, 19, 6, 4, 1);
	
		poss[10] = new Item(ItemType.Armor,"Ebony Armor", 59, 768, 20, 9, 20, 1);	
		
		poss[11] = new Item(ItemType.Armor,"Orcish Armor", 68, 486, 18, 3, 14, 1);

		poss[12] = new Item(ItemType.Armor,"Black Mage Robes", 20, 129, 16, 9, 9, 1);

		poss[13] = new Item(ItemType.Armor,"Blue Mage Robes", 20, 145, 17, 6, 24, 1);


		poss[14] = new Item(ItemType.Weapon,"Iron Sword", 24, 112, 15, 3, 2, 1);

		poss[15] = new Item(ItemType.Weapon,"Iron Dagger", 17, 146, 13, 6, 16, 1);
		
		poss[16] = new Item(ItemType.Weapon,"Steel Sword", 29, 120, 20, 5, 19, 1);

		poss[17] = new Item(ItemType.Weapon,"Steel Dagger", 21, 178, 18, 7, 2, 1);
		
		poss[18] = new Item(ItemType.Weapon,"Ebony Sword", 32, 520, 22, 4, 1, 1);
		
		poss[19] = new Item(ItemType.Weapon,"Ebony Dagger", 28, 345, 20, 3, 9, 1);
		
		poss[20] = new Item(ItemType.Weapon,"Orcish Sword", 39, 336, 25, 6, 5, 1);
		
		poss[21] = new Item(ItemType.Weapon,"Orcish Dagger", 30, 290, 23, 7, 20, 1);  
		
		poss[22] = new Item(ItemType.Weapon,"Wooden Staff", 54, 160, 17, 10, 16, 1);
		
		poss[23] = new Item(ItemType.Weapon,"Iron Staff", 67, 297, 18, 8, 25, 1);
		
		poss[24] = new Item(ItemType.Weapon,"Steel Staff", 83, 323, 19, 2, 17, 1);
		

		poss[25] = new Item(ItemType.Other,"Steel Cup", 4, 16, 0, 3, 13, 1);
		
		poss[26] = new Item(ItemType.Other,"Ruined Book", 2, 4, 0, 8, 3, 1);
		
		poss[27] = new Item(ItemType.Other,"Dried Moss", 1, 14, 0, 5, 11, 1);
		
		poss[28] = new Item(ItemType.Other,"Broken Sword", 25, 14, 0, 4, 7, 1);
		
		
		int x = rng.nextInt(29);
		//Returns a random item.
		return poss[x];

	}

}
