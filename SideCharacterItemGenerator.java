/**
 * SideCharacterItemGenerator is used to generate a random item for the player. These items are only given by the side character in the game. The Iteraction class uses this class.
 * @author Lauren Pittman, Tavion Britt, Grace Long.
*/

import java.util.Random;

public class SideCharacterItemGenerator{
	/**This method creates 19 items and stores them into a array. A random index will be seleected to pick a item to give to the player when the player asks the side character for a item. Since the number is random, any item can be picked whether it is a weapon or piece of armor. Additionally, items can be given more than one.
	 * @return poss[x] This returns one random item from the array. 
	 */
	public static Item generate(){

		Random rng = new Random();
		//Will get a random number between 0 and 19.
		Item poss[] = new Item[20];

		//Item type, Item name, weight, value, strength, x, and y.	
		poss[0] = new Item(ItemType.Armor,"Hide Armor", 29, 146, 15, 5, 13, 1);

		poss[1] = new Item(ItemType.Armor,"Iron Chain Armor", 38, 298, 16, 10, 7, 1);

		poss[2] = new Item(ItemType.Armor,"Branded Iron Armor", 42, 388, 17, 6, 5, 1);

		poss[3] = new Item(ItemType.Armor,"Steel Chain Armor", 47, 456, 18, 6, 4, 1);

		poss[4] = new Item(ItemType.Armor,"Branded Steel Armor", 47, 424, 19, 6, 4, 1);

		poss[5] = new Item(ItemType.Armor,"Ebony Chain Armor", 59, 768, 20, 9, 20, 1);	

		poss[6] = new Item(ItemType.Armor,"Orcish Chain Armor", 68, 486, 18, 3, 14, 1);

		poss[7] = new Item(ItemType.Armor,"Studded Armor", 20, 129, 16, 9, 9, 1);

		poss[8] = new Item(ItemType.Armor,"Hooded Mage Robes", 20, 145, 17, 6, 24, 1);


		poss[9] = new Item(ItemType.Weapon,"Iron War Axe", 24, 112, 15, 3, 2, 1);

		poss[10] = new Item(ItemType.Weapon,"Iron Great Sword", 17, 146, 13, 6, 16, 1);

		poss[11] = new Item(ItemType.Weapon,"Steel War Axe", 29, 120, 20, 5, 19, 1);

		poss[12] = new Item(ItemType.Weapon,"Steel Great Sword", 21, 178, 18, 7, 2, 1);

		poss[13] = new Item(ItemType.Weapon,"Ebony War Axe", 32, 520, 22, 4, 1, 1);

		poss[14] = new Item(ItemType.Weapon,"Ebony Great Sword", 28, 345, 20, 3, 9, 1);

		poss[15] = new Item(ItemType.Weapon,"Orcish War Axe", 39, 336, 25, 6, 5, 1);

		poss[16] = new Item(ItemType.Weapon,"Orcish Great Sword", 30, 290, 23, 7, 20, 1);  

		poss[17] = new Item(ItemType.Weapon,"Wooden Staff", 54, 160, 17, 10, 16, 1);

		poss[18] = new Item(ItemType.Weapon,"Iron Staff", 67, 297, 18, 8, 25, 1);

		poss[19] = new Item(ItemType.Weapon,"Steel Staff", 83, 323, 19, 2, 17, 1);


		int x = rng.nextInt(20);
		//Returns a random item.
		return poss[x];

	}

}
