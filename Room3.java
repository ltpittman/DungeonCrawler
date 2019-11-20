import java.io.FileInputStream;
import java.util.Arrays;

class Room3{
	//Instance variables.
 	public String[][] room;
	public int rows;
	public int columns;

	//The constructor.
	//The parameters will come from the World class constructor. AKA the rooms and their length and width.
	//While the rows and colums are instance variable above. Set the instance variables to the constructor parameters.
	public Room1("Room3.txt"){
		
		this.rows = rows;
		this.columns = columns;
		room = new room[rows][columns];


		FileInputStream room3 = new FileInputStream("Room3.txt");
		Scanner fin = new Scanner(room3);
		
		for(int i = 0, i < rows; i++){
			String l = room3.nextLine();
			for(int j = j room3.length(); j++){
				room[i][j] = room3.charAt(j);
			}
		}


		//Setting the room array to hold the rows and columns.
	//	room = new String[rows][columns];
		
	}
