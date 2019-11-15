/*This class is used to load and save a game.*/

import java.io.PrintWriter;
import java.util.ArrayList;

class SaveGame{
	Player player;
	Enemy enemy;
	Inventory inventory;
	
	//variables for player and inventory
	private Item equippedArmor, equippedWeapon;
	private int playerHealth, armorStrength, weaponStrength, playerX, playerY;
	private String playerName;
	ArrayList<Item> items;
	
	//Method to get information about player.
	public void player(Player player, Inventory inventory){
	
	this.player = player;
	this.inventory = inventory;
	playerName = player.getName();
	playerHealth = player.getHealth();
	equippedArmor = player.getEquippedArmor();
	equippedWeapon = player.getEquippedWeapon();
	armorStrength = player.getArmorStrength();
	weaponStrength = player.getWeaponStrength();
	playerY = player.getPlayerY();
	playerX = player.getPlayerX();
	
	//	
	}
	/*
		, playerName, playerHealth;
	Inventory inventory;

	Item items; //Or Item item1, Item item 2, etc.
	Item getEquippedArmor, getEquippedWeapon;
	
	Enemy enemy, enemyName, enemyHealth;

	World playerPosition, enemyPosition;

	World world;
	Rooms rooms;
*/
	//Method to save the game.
	void persist(PrintWriter pw){
		pw.println(playerName);
		pw.println(playerX + " " + playerY);
		pw.println(playerHealth);
		pw.println(equippedArmor);
		pw.println(equippedWeapon);
		pw.println(armorStrength);
		pw.println(weaponStrength);
		

	}

		



}
