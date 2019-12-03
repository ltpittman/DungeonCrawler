import java.util.Random;

public class ItemGenerator{
	//Method gets a random number and uses that number to get an item from a list.
	public static Item generate(){
		
		Random rng = new Random();
		//Will get a random number between 0 and 19.
		Item poss[] = new Item[25];

	 	//Item type, Item name, weight, value, strength, x(12), and y(30) and roomNumber.	
		poss[0] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 5, 23);//Other,"Vase", 8, 4, 0, 2, 11);
		
		poss[1] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 10, 5);//Other,"Silver Cup", 2, 7, 0, 9, 17);
		
		poss[2] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 9, 6);// Other,"Broom", 12, 15, 0, 3, 4);	
		
		poss[3] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 4, 19);//Other,"Book", 4, 46, 0, 6, 8);	
		
		poss[4] = new Item(ItemType.HealthPotion,"Health Potion", 2, 25, 100, 6, 28);//Other,"Broken Sword", 14, 87, 0, 6, 28);	
		


		poss[5] = new Item(ItemType.Armor,"Hunting Armor", 29, 146, 15, 5, 13);
		
		poss[6] = new Item(ItemType.Armor,"Iron Armor", 38, 298, 16, 10, 7);

		poss[7] = new Item(ItemType.Armor,"Branded Iron Armor", 42, 388, 17, 6, 5);
		
		poss[8] = new Item(ItemType.Armor,"Steel Armor", 47, 456, 18, 6, 4);

		poss[9] = new Item(ItemType.Armor,"Branded Steel Armor", 47, 424, 19, 6, 4);
	
		poss[10] = new Item(ItemType.Armor,"Ebony Armor", 59, 768, 20, 9, 20);	
		
		poss[11] = new Item(ItemType.Armor,"Orcish Armor", 68, 486, 18, 3, 14);

		poss[12] = new Item(ItemType.Armor,"Black Mage Robes", 20, 129, 16, 9, 9);

		poss[13] = new Item(ItemType.Armor,"Blue Mage Robes", 20, 145, 17, 6, 24);


		poss[14] = new Item(ItemType.Weapon,"Iron Sword", 24, 112, 15, 3, 2);

		poss[15] = new Item(ItemType.Weapon,"Iron Dagger", 17, 146, 13, 6, 16);
		
		poss[16] = new Item(ItemType.Weapon,"Steel Sword", 29, 120, 20, 5, 19);

		poss[17] = new Item(ItemType.Weapon,"Steel Dagger", 21, 178, 18, 7, 2);
		
		poss[18] = new Item(ItemType.Weapon,"Ebony Sword", 32, 520, 22, 4, 1);
		
		poss[19] = new Item(ItemType.Weapon,"Ebony Dagger", 28, 345, 20, 3, 9);
		
		poss[20] = new Item(ItemType.Weapon,"Orcish Sword", 39, 336, 25, 6, 5);
		
		poss[21] = new Item(ItemType.Weapon,"Orcish Dagger", 30, 290, 23, 7, 20);  
		
		poss[22] = new Item(ItemType.Weapon,"Wooden Staff", 54, 160, 17, 10, 16);
		
		poss[23] = new Item(ItemType.Weapon,"Iron Staff", 67, 297, 18, 8, 25);
		
		poss[24] = new Item(ItemType.Weapon,"Steel Staff", 83, 323, 19, 2, 17);
		

		int x = rng.nextInt(25);
		//Returns a random item.
		return poss[x];

	}

}
