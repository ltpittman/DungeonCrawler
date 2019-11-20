import java.io.FileInputStream;
import java.util.Arrays;

class Room2{
	//Instance variables.
 	public String[][] room;
	public int rows;
	public int columns;

	//The constructor.
	//The parameters will come from the World class constructor. AKA the rooms and their length and width.
	//While the rows and colums are instance variable above. Set the instance variables to the constructor parameters.
	public Room1("Room2.txt"){
		FileInputStream room2 = new FileInputStream("Room2.txt");
		Scanner fin = new Scanner(f);
		
		for(int i = 0, i < rows; i++){
			String l = room2.nextLine();
			for(int j = j room1.length(); j++){
				room[i][j] = room2.charAt(j);
			}
		}


		//this.rows = roomLength;
		//this.columns = roomWidth;
		//Setting the room array to hold the rows and columns.
	//	room = new String[rows][columns];
		
		//For loop to create the rooms.
	//	for(int i = roomLength; i < rows; i++){
	//		for(int j = roomWidth; i < columns; j++){
	//			if((i == 0) || (j == 0) || (i == rows - 1) || (j == columns - 1)){
	///				room[i][j] = "#";			}
	//			else{
	//				room[i][j] = ".";
	//			}
	//		}
	//	}
	}
