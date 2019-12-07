/**KeyGenerator creates a method that return a key. In order to put a key in a random place with little to no duplicates, there are a total of 10 keys being created. Each key below has the same name but differnt x and y coordinates. 
 * @author Lauren Pittman, Tavion Britt, Grace Long.
 */

import java.util.Random;

public class KeyGenerator{
	/**This method gets a random number and uses that number to get a key from a list. There are multiple keys in the array, however, each key has a differnt x and y coordinate so there will be less duplicates iwhen the game generates. 
	 * @return Returns the key located at the index of the random number.
	 */
	public static Item generateKey(){
		
		Random rng = new Random();
		//Will get a random number between 0 and 19.
		Item poss[] = new Item[10];

	 	//Item type, name, weight, value, strength, x, and y.	
		poss[0] = new Item(ItemType.Key,"Key", 0, 0, 0, 8, 8, 1);
		
		poss[1] = new Item(ItemType.Key,"Key", 0, 0, 0, 10, 25, 1);
		
		poss[2] = new Item(ItemType.Key,"Key", 0, 0, 0, 3, 5, 1);

		poss[3] = new Item(ItemType.Key,"Key", 0, 0, 0, 6, 20, 1);

		poss[4] = new Item(ItemType.Key,"Key", 0, 0, 0, 4, 9, 1);
		
		poss[5] = new Item(ItemType.Key,"Key", 0, 0, 0, 7, 12, 1);
		
		poss[6] = new Item(ItemType.Key,"Key", 0, 0, 0, 5, 26, 1);
		
		poss[7] = new Item(ItemType.Key,"Key", 0, 0, 0, 3, 21, 1);
		
		poss[8] = new Item(ItemType.Key,"Key", 0, 0, 0, 10, 13, 1);
		
		poss[9] = new Item(ItemType.Key,"Key", 0, 0, 0, 6, 3, 1);
		
		
		int x = rng.nextInt(10);
		//Returns a random item.
		return poss[x];

	}

}
