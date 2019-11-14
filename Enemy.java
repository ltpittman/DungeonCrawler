import java.util.Random;

class Enemy extends Characters{
	//Instance variables.
	private int health;
	private String name;
	private MonsterType type;
	private int damage;
	public int x;
	public int y;
	public World world;

	//Constructor for the enemy.
	//Enemy(MonsterType type, String name, int health, int damage, int X, int Y){ 
	public Enemy(String name, int health){ 
		super(name,health);
		//this.name = name;
		//this.health = health;	
		this.type = type;
		this.damage = damage;
		this.x = x; //8
		this.y = y; //15
	}
	//Get the type of the monster.
	MonsterType typeOfMonster(){
		return this.type;
	}
	//Get the name of the monster.
	String getName(){
		return this.name;
	}
	//Get the health of the monster.
	int getHealth(){
		return this.health;
	}
	//Set the health of the monster.
	public void setHealth(int num){
		this.health = num;
	}
	//Get the strength of the monster.
	int getDamage(){
		return this.damage;
	}
	//Get the x-coordinate of the monster.
	int getEnemyX(){
		return this.x;
	}
	//Get the y-coordinate of the monster.
	int getEnemyY(){
		return this.y;
	}
	//Adding the movement method for the Enemy class.
	//Have the monster go right.
	public boolean goRight(Enemy move){
		Random random = new Random();
		int mm = random.nextInt(4);
		if(mm == 0){
			if(move.x + 1 == 35){
				return false;
			}
			else{
				move.x += 1;
				return true;
			}
		}
		return false;
	}
	//#####
	public boolean move(Enemy move){
		Random random = new Random();
		int mm = random.nextInt(4);
	
		if(mm == 1){
			if(move.x - 1 == 0){
				return false;
			}
			else{
				move.x -= 1;
				return true;
			}
		}
		else if(mm == 2){
			if(move.y - 1 == 0){
				return false;
			}
			else{
				move.y -= 1;
				return true;
			}
		}
		else if(mm == 3){
			if(move.y + 1 == 17){
				return false;
			}
			else{
				move.y += 1;
				return true;
			}
		}
		else{
			return false;
		}
		
	}
	//*******************************************************************************

	boolean monsterIsAlive(){
		if(health > 0){
			return true;
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
	}

