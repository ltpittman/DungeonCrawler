import java.util.Arrays;

class Room1{
	public String[][] room1;
	public int rows;
	public int columns;
	public Enemy enemy;
	Battles battle = new Battles();

	Room1(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		room1 = new String[rows][columns];
	}
	public void fillRoom1(){//Enemy enemy1, Item item1, Item item2, Item item3){
		String[][] room1 = 
		{
			{" #","#","#","#","#","#","#","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".","#\n"},
			{"#","#","#","#","#","#","#","#","#"}
		};
		//room1[item1.y][item1.x] = "$";
		//room1[item2.y][item2.x] = "$";
		//room1[item3.y][item3.x] = "$";

	//	if (enemy1.enemyDead(enemy1) == false){
	//		room1[enemy1.y][enemy1.x] = "M";
	//	}
		System.out.println(Arrays.deepToString(room1).replace(",","").replace("[[","").replace("]]","").replace("[","").replace("]",""));
	}
}
