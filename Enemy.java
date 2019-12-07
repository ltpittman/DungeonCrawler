/**
 * <tt>Enemy</tt> is a character in the game who's goal is to kill the players. They have a name, health
 * (out of 100), damage, and location. There are also many different types of monsters that have different 
 * stats. When a player and an enemy approach each other they fight. {@link Battles} 
 * @author Lauren Pittman, Tavion Britt, and Grace Long
 */

import java.util.Random;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class Enemy extends Character{
	//Instance variables.
	private int health;
	private String name;
	private MonsterType type;
	private int damage;
	private boolean isDead;
	public World world;
	public int x;
	public int y;
	public int roomNum;

	/**
	 * Constructs a new Enemy with stats from the paramaters. Contains a name, health, damage, x, y, type, isDead, and roomNum status.
	 * @param name the name of the Enemy
	 * @param health the health of the Enemy (out of 100)
	 * @param damage the damage of the Enemy {@link Battles} 
	 * @param x the x coordinate of the Enemy
	 * @param y the y coordinate of the Enemy
	 * @param type the type of monster the enemy is {@link MonsterType}
	 * @param isDead a boolean telling if the enemy is alive
	 * @param roomNum the room number that the enemy is assigned to
	 */
	//Enemy(MonsterType type, String name, int health, int damage, int X, int Y,){ 
	public Enemy(String name, int health, int damage, int x, int y, MonsterType type, boolean isDead, int roomNum){ 
		super(name, health);
		this.name = name;
		this.health = health;
		this.type = type;
		this.damage = damage;
		this.x = x;
		this.y = y;
		this.isDead = isDead;
		this.roomNum = roomNum;
	}

	/**
	 * Sets the room number that the enemy is in. 
	 * @param roomNum The room number that the enemy is in.
	 */
	public void setRoomNum(int roomNum){
		this.roomNum = roomNum;
	}

	/**
	 * Returns the room number that the enemy is in.
	 * @return The room number. 
	 */
	public int getRoomNum(){
		return this.roomNum;
	}

	/**
	 * Returns the enemy's symbol the is displayed on the board
	 * @return the symbol for the enemy
	 */
	public char getCharacterImage(){
		return 'M';
	}

	/**
	 * Returns the type of monster the Enemy is.
	 * @return type of monster
	 */
	MonsterType typeOfMonster(){
		return this.type;
	}

	/**
	 * Returns the strength of the Enemy.
	 * @return strenght out of 100
	 */
	int getDamage(){
		return this.damage;
	}

	/**
	 * Determines if the Enemy is dead or alive
	 * @return true if dead and false if alive
	 */
	boolean enemyDead(){
		if(health > 0){
			return false;
		}
		else{
			return true;
		}
	}		

	/**
	 * Determines if Enemy is dead or alive 
	 * @return true if enemy is dead and false if enemy is alive
	 */
	boolean getIsDead(){
		return this.isDead;
	}

	/**
	 * Sets if the Enemy is dead or alive
	 * @param isDead if true enemy is dead and if false enemy is alive
	 */
	public void setIsDead(boolean isDead){
		this.isDead = isDead;
	}

	/**
	 * Moves the Enemy around the board randomly. If the Enemy will run into a wall 
	 * when it moves it returns false, otherwise it returns true.
	 * @return if the enemy can move in the random directon
	 */
	public boolean move(){

		Random random = new Random();
		int mm = random.nextInt(4);

		if(mm == 0){
			//Have the monster go down.
			if(x + 1 == 11){
				return false;
			}
			else{
				x += 1;
				return true;
			}
		}
		else if(mm == 1){
			//Have the monster go up.
			if(x - 1 == 0){
				return false;
			}
			else{
				x -= 1;
				return true;
			}
		}
		else if(mm == 2){
			//Have the monster go left.
			if(y - 1 == 0){
				return false;
			}
			else{
				y -= 1;
				return true;
			}
		}
		else if(mm == 3){
			//Have the monster go right.
			if(y + 1 == 29){
				return false;
			}
			else{
				y += 1;
				return true;
			}
		}
		else{
			return false;
		}

	}

	/**
	 * Prints inforamtion about the Enemy.
	 * @return Enemy's name, health, and damage
	 */
	public String toString(){
		return("Enemy Name: " + this.name + "\nHealth: " + this.health + "/100" + "\nDamage: " + this.damage);
	}

	/**
	 * Saves the information about the Enemy to a text file.
	 * @param pw a print writer that will type the information into the file
	 */
	public void persist (PrintWriter pw){
		pw.println(name);
		pw.println(type);
		pw.println(x + " " + y);
		pw.println(health);
		pw.println(damage);
		pw.println(isDead);
		pw.println(roomNum);
		pw.println(".");
	}

	/**
	 * Restores the inforamtion about the Enemy from a text file.
	 * @param a scanner that will read the information in from a file
	 * @throws Exception if there is an error reading in the file.
	 */
	public void restore(Scanner a) throws Exception {
		try{
			this.name = a.nextLine();
			String t = a.nextLine();
			MonsterType type = MonsterType.valueOf(t);
			this.type = type;
			this.x = a.nextInt();
			this.y = a.nextInt();
			this.health = a.nextInt();
			this.damage = a.nextInt();
			this.isDead = a.nextBoolean();
			this.roomNum = a.nextInt();
			String noth = a.nextLine();
			noth = a.nextLine();
		}
		catch(Exception e){
			System.out.println("Could not read enemy portion of file.");
		}
	}	

	}

