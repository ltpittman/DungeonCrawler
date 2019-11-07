class Enemy{
	//Instance variables.
	public World world;
	private MonsterType type;
	private String name;
	private int health;
	private int damage;
	public int x;
	public int y;

	//Constructor for the enemy.
	//Enemy(MonsterType type, String name, int health, int damage, int X, int Y){ 
	public Enemy(MonsterType type, String name, int health, int damage, int x, int y){ 
		this.type = type;
		this.name = name;
		this.health = health;
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

