import java.util.Random;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;


class Enemy extends Characters{
	//Instance variables.
	private int health;
	private String name;
	private MonsterType type;
	private int damage;
	public int x;
	public int y;
	private boolean isDead;
	public World world;

	//Constructor for the enemy.
	//Enemy(MonsterType type, String name, int health, int damage, int X, int Y){ 
	public Enemy(String name, int health, int damage, int x, int y, MonsterType type){//, boolean isDead){ 
		super(name, health);//,health);
		//this.health = health;
		this.type = type;
		this.damage = damage;
		this.x = x;
		this.y = y;
		//this.isDead = isDead;
	}
//	public String characterImage(){
//		return "M";
//	}
	//Get the type of the monster.
	MonsterType typeOfMonster(){
		return this.type;
	}
	//Get the strength of the monster.
	int getDamage(){
		return this.damage;
	}
	/*
	//to determine if the enemy is dead
	boolean getIsDead(){
		return this.isDead;
	}
	//to set the is dead
	public void boolean setIsDead(boolean isDead){
		this.isDead = isDead;
	}
	*/
	//Adding the movement method for the Enemy class.
	public boolean move(){

		Random random = new Random();
		int mm = random.nextInt(4);

		if(mm == 0){
			if(x + 1 == 22){
				return false;
			}
			else{
				x += 1;
				return true;
			}
		}
		else if(mm == 1){
			if(x - 1 == 0){
				return false;
			}
			else{
				x -= 1;
				return true;
			}
		}
		else if(mm == 2){
			if(y - 1 == 0){
				return false;
			}
			else{
				y -= 1;
				return true;
			}
		}
		else if(mm == 3){
			if(y + 1 == 18){
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
	//After enemy is dead remove from board
	public boolean enemyDead(Enemy enemy){
		int healthEnemy = enemy.getHealth();
		if (healthEnemy <= 0){
			y= 1;
			x = 1;
			return true;
		} 
		else{
			return false;
		}
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

	public void restore (String fileName) {
		try{
		Scanner a = new Scanner(new FileReader(fileName));
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
		catch(FileNotFoundException e){
			System.out.println("Could not find anything.");
		}
	}	

	}

