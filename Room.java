import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Room{
	int rows;
//	int columns;
	char[][] grid;

	//Constructor that takes in a file.
	Room(String frame){
		
	//	this.rows = rows;
	//	this.columns = columns;
		grid = new char[15][36];

		try{
			FileInputStream f = new FileInputStream(frame);
			Scanner in = new Scanner (f);
			
			//rows = in.nextInt();

			for(int i = 0; i < rows; i++){
				String line = in.nextLine();
				for(int j = 0; j < line.length(); j++){
					grid[i][j] = line.charAt(j);
				}
			}
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
	}
}
