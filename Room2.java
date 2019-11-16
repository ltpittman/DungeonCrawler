class Room2{
	public String[][] room2;
	public int rows;
	public int columns;
	public Enemy enemy;
	Battles battle = new Battles();

	Room2(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		room2 = new String[rows][columns];
	}
	public void fillRoom2(Enemy enemy1, Enemy enemy2, Item item1, Item item2, Item item3, Item item4){
		String[][] room2 = 
		{
			{" #","#","#","#","#","#","#","#","#","#","#","#","#","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#","#","#","#","#","#","#","#","#","#","#","#","#","#","#\n"},
		};
		
		room2[item1.y][item1.x] = "$";
		room2[item2.y][item2.x] = "$";
		room2[item3.y][item3.x] = "$";
		room2[item4.y][item4.x] = "$";
		
		if (enemy1.enemyDead(enemy1) == false){
			room2[enemy1.y][enemy1.x] = "M";
		}
		if (enemy1.enemyDead(enemy1) == false){
			room2[enemy1.y][enemy1.x] = "M";
		}
	}
}
