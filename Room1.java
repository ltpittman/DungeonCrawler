import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Arrays;

class Room1{
	//Instance variables.
 	public String[][] room1;
	public int rows;
	public int columns;

	//The constructor.
	public Room1(String filename){
		
		this.rows = rows;
		this.columns = columns;
		room1 = new String[rows][columns];

		FileInputStream room1 = new FileInputStream("Room1.txt");
		Scanner in = new Scanner(room1);
		
		for(int i = 0; i < rows; i++){
			String l = room1.nextLine();
			for(int j = 0; i < room1.length(); j++){
				room[i][j] = room1.charAt(j);
			}
		}

	room1.close();
	}

}
