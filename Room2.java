import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Room2{
	//Instance variables.
	public char[][] room;
	public int rows;
	public int columns;

	//The constructor.
	public Room2(String filename){

		this.rows = rows;
		this.columns = columns;
		room = new char[rows][columns];

		try{		
			FileInputStream room2 = new FileInputStream("Room2.txt");
			Scanner in = new Scanner(room2);

			for(int i = 0; i < rows; i++){
				String l = in.nextLine();
				for(int j = 0; j < l.length(); j++){
					room[i][j] = l.charAt(j);
				}
			}
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
	}
}
