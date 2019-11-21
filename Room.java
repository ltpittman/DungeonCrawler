import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Room{
	char[][] grid;

	//Constructor that takes in a file.
	Room(String frame){
		
		grid = new char[36][14];

		try{
			FileInputStream f = new FileInputStream(frame);
			Scanner in = new Scanner (f);
			
			for(int i = 0; i < 14; i++){
				String line = in.nextLine();
				System.out.print("\n");
				for(int j = 0; j < 36; j++){
					grid[j][i] = line.charAt(j);
					System.out.print(grid[j][i]);
				}
			}
			System.out.println();
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
	}
}
