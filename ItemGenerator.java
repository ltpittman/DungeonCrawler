import java.util.Random;
public class ItemGenerator{
	//Method gets a random number and uses that number to get an item from a list.
	public static Item generate(){
		
		Random rng = new Random();
		//Will get a random number between 0 and 19.
		Item poss[] = new Item[20];

	 	//Item type, Item name, weight, value, strength, x(12), and y(30).	
		poss[0] = new Item(ItemType.Other, "Vase", 5, 4, 0, 2, 11);
		
		poss[1] = new Item(ItemType.Other, "Silver Cup", 2, 7, 0, 10, 17);
		
		poss[2] = new Item(ItemType.Other, "Broom", 8, 15, 0, 3, 4);	
		
		poss[3] = new Item(ItemType.Other, "Book", 4, 46, 0, 6, 8);	
		
		poss[4] = new Item(ItemType.Other, "Broken Sword", 9, 87, 0, 6, 28);	
		
		//poss[0] = new Item(ItemType.HealthPotion, "Health Potion", 5, 25, 100, 1, 9);
		


		poss[5] = new Item(ItemType.Armor, "Hunting Armor", 26, 146, 12, 5, 13);
		
		poss[6] = new Item(ItemType.Armor, "Iron Armor", 29, 298, 14, 10, 7);
		
		poss[7] = new Item(ItemType.Armor, "Steel Armor", 35, 456, 16, 6, 14);
		
		poss[8] = new Item(ItemType.Armor, "Ebony Armor", 47, 768, 18, 9, 20);	
		
		poss[9] = new Item(ItemType.Armor, "Orcish Armor", 52, 486, 20, 3, 14);



		poss[10] = new Item(ItemType.Weapon,"Iron Sword", 17, 112, 15, 3, 2);
		
		poss[11] = new Item(ItemType.Weapon,"Steel Sword", 24, 120, 20, 5, 19);

		poss[12] = new Item(ItemType.Weapon, "Steel Dagger", 21, 178, 18, 7, 2);
		
		poss[13] = new Item(ItemType.Weapon,"Ebony Sword", 32, 520, 22, 4, 1);
		
		poss[14] = new Item(ItemType.Weapon,"Ebony Dagger", 28, 345, 20, 3, 9);
		
		poss[15] = new Item(ItemType.Weapon,"Orcish Sword", 30, 336, 25, 6, 5);
		
		poss[16] = new Item(ItemType.Weapon, "Orcish Dagger", 26, 290, 23, 7, 28);  
		
		poss[17] = new Item(ItemType.Weapon,"Wooden Staff", 19, 160, 17, 10, 16);
		
		poss[18] = new Item(ItemType.Weapon,"Iron Staff", 25, 297, 18, 8, 27);
		
		poss[19] = new Item(ItemType.Weapon,"Steel Staff", 32, 323, 19, 2, 17);
		

		int x = rng.nextInt(20);
		//Returns a random item.
		return poss[x];

	}

}
