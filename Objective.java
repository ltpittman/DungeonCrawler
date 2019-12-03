/* This class prints the objective of the game to the user along with the commands.*/
class Objective{
	Player player;
	Inventory inventory;
	
	//Method to print the commands to the user.
	void printCommands(){
		System.out.println("[How to Play]:\nPress 'H' to go up.\nPress 'L' to go down.\nPress 'J' to go left.\nPress 'K' to go right.\nPress 'I' to print your inventory.\nPress 'D' to drop an item from your inventory.\nPress 'W' to equip a weapon from your inventory.\nPress 'A' to equip armor from your inventory.\nPress 'R' to drink a health potion.\nPress 'P' to print the commands to read again.");
	}

	//Method to print the objective of the game.
	void printObjective(){
		System.out.println("[Welcome to Dungeon Crawler!]...\n   The overall objective of the game is to fight all the monsters that you encounter and make it out of the dungeon alive. To begin, your health will start at 100/100 pts. You will have two items in your inventory: a sword and a piece of armor. While out searching for monsters, you have the option to pick up random items, whether it is a piece of armor, a weapon, etc.\n    You may switch your weapon and armor for something different that you find anytime. [Note] the better weapon or armor you wear, the better chance you have of winning! When it comes to fighting the monsters, it's all about luck. If you win a battle against a monster, you will be able to continue exploring the area and fight any more monsters you come across. If you are able to kill four monsters in the dungeon, then you have won the game! [Good luck!]"); 
	}
}
