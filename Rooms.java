import java.util.Arrays;

class Rooms{
	public String[][] room1;
	public String[][] room2;
	public int rows;
	public int columns;
	public Player player;
	public Enemy enemy;
	Battles battle = new Battles();

	Rooms(){
		this.rows = rows;
		this.columns = columns;
		room1 = new String[rows][columns];
	}
	public void fillRoom1(Player player){//Player player){//, Enemy enemy1, Item item1, Item item2, Item item3){
		String[][] room1 = 
		{
			{" #","#","#","#","#","#","#","#","#\n"},
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
			{"#","#","#","#","D","#","#","#","#"}
		};
		
		room1[player.y][player.x] = "@";

	/*	room1[item1.y][item1.x] = "$";
		room1[item2.y][item2.x] = "$";
		room1[item3.y][item3.x] = "$";

		if (enemy1.enemyDead(enemy1) == false){
			room1[enemy1.y][enemy1.x] = "M";
		}*/

		//Printing out room1 to the screen.
		System.out.println(Arrays.deepToString(room1).replace(",","").replace("[[","").replace("]]","").replace("[","").replace("]",""));
	}


	//Fill room 2 for the player.
	public void fillRoom2(){//Player player,Item item1,Item item2){
		String[][] room2 =
		{
			{" #","#","#","#","#","#","#","#","#","#","#","#","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"D",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#",".",".",".",".",".",".",".",".",".",".",".","#\n"},
			{"#","#","#","#","#","#","#","#","#","#","#","#","#",}
		};

		//room2[player.y][player.x] = "@";

		//room2[item1.y][item1.x] = "$";
		//room2[item2.y][item2.x] = "$";

		//Printing out room2 to the screen.
		System.out.println(Arrays.deepToString(room2).replace(",","").replace("[[","").replace("]]","").replace("[","").replace("]",""));
	}
}
