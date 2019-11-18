import java.util.Random;
public class ItemGenerator{
	//Method gets a random number and uses that number to get an item from a list.
	public static Item generate(){
		
		Random rng = new Random();
		//Will get a random number between 0 and 19.
		Item poss[] = new Item[20];

	 	//Item type, Item name, weight, value, strength, x , and y.	
		poss[0] = new Item(ItemType.Other, "Vase", 5, 4, 0, 1, 9);
		
		poss[1] = new Item(ItemType.Other, "Broom", 3, 4, 0, 3, 5);
		
		poss[2] = new Item(ItemType.Other, "Book", 2, 7, 0, 8, 3);
		
		poss[3] = new Item(ItemType.Other, "Silver Cup", 2, 7, 0, 7, 10);


		
		poss[4] = new Item(ItemType.HealthPotion, "Health Potion", 2, 25, 100, 10, 4);	
		


		poss[5] = new Item(ItemType.Armor, "Hunting Armor", 26, 146, 12, 5, 6);
		
		poss[6] = new Item(ItemType.Armor, "Iron Armor", 29, 298, 14, 11, 7);
		
		poss[7] = new Item(ItemType.Armor, "Steel Armor", 35, 456, 16, 6, 4);
		
		poss[8] = new Item(ItemType.Armor, "Ebony Armor", 47, 768, 18, 10, 10);	
		
		poss[9] = new Item(ItemType.Armor, "Orcish Armor", 52, 486, 20, 2, 11);



		poss[10] = new Item(ItemType.Weapon,"Iron Sword", 17, 112, 15, 10, 2);
		
		poss[11] = new Item(ItemType.Weapon,"Steel Sword", 24, 120, 20, 11, 9);

		poss[12] = new Item(ItemType.Weapon, "Steel Dagger", 21, 178, 18, 10, 2);
		
		poss[13] = new Item(ItemType.Weapon,"Ebony Sword", 32, 520, 22, 4, 1);
		
		poss[14] = new Item(ItemType.Weapon,"Ebony Dagger", 28, 345, 20, 3, 9);
		
		poss[15] = new Item(ItemType.Weapon,"Orcish Sword", 30, 336, 25, 11, 11);
		
		poss[16] = new Item(ItemType.Weapon, "Orcish Dagger", 26, 290, 23, 6, 8);  
		
		poss[17] = new Item(ItemType.Weapon,"Wooden Staff", 19, 160, 17, 3, 6);
		
		poss[18] = new Item(ItemType.Weapon,"Iron Staff", 25, 297, 18, 8, 7);
		
		poss[19] = new Item(ItemType.Weapon,"Steel Staff", 32, 323, 19, 11, 8);
		

		int x = rng.nextInt(20);
		//Returns a random item.
		return poss[x];

	}

}
