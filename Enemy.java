import java.util.Random;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

class Enemy extends Character{
	//Instance variables.
	private int health;
	private String name;
	private MonsterType type;
	private int damage;
	private boolean isDead;
	public World world;
	public int x;
	public int y;

	//Constructor for the enemy.
	//Enemy(MonsterType type, String name, int health, int damage, int X, int Y){ 
	public Enemy(String name, int health, int damage, int x, int y, MonsterType type, boolean isDead){ 
		super(name, health);
		this.name = name;
		this.health = health;
		this.type = type;
		this.damage = damage;
		this.x = x;
		this.y = y;
		this.isDead = isDead;
	}
	public char getCharacterImage(){
		return 'M';
	}
	//Get the type of the monster.
	MonsterType typeOfMonster(){
		return this.type;
	}
	//Get the strength of the monster.
	int getDamage(){
		return this.damage;
	}

	//to see if the monster is alive
	boolean enemyDead(){
		if(health > 0){
			return false;
		}
		else{
			return true;
		}
	}		

	//to determine if the enemy is dead
	boolean getIsDead(){
		return this.isDead;
	}

	//to set the is dead
	public void setIsDead(boolean isDead){
		this.isDead = isDead;
	}

	//to get x and y
	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	//Adding the movement method for the Enemy class.
	public boolean moveRandomly(){

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

	//Print out format. 
	public String toString(){
		return("Enemy Name: " + this.name + "\nHealth: " + this.health + "/100" + "\nDamage: " + this.damage);
	}
	//Method to save the information about the enemy
	public void persist (PrintWriter pw){
		pw.println(name);
		pw.println(type);
		pw.println(x + " " + y);
		pw.println(health);
		pw.println(damage);
		pw.println(isDead);
		pw.println(".");
	}

	public void restore(Scanner a) {
		try{
			String noth = a.nextLine();
			noth = a.nextLine();
			this.name = a.nextLine();
			String t = a.nextLine();
			MonsterType type = MonsterType.valueOf(t);
			this.type = type;
			this.x = a.nextInt();
			this.y = a.nextInt();
			this.health = a.nextInt();
			this.damage = a.nextInt();
			this.isDead = a.nextBoolean();
		}
		catch(Exception e){
			System.out.println("Could not read enemy portion of file.");
		}
	}	

	}

