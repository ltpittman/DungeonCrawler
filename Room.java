/*This class reads in a file to create a room for the game. */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Room{
	char[][] grid;

	//Constructor that takes in a file.
	Room(String frame){
		
		grid = new char[30][12];

		try{
			FileInputStream f = new FileInputStream(frame);
			Scanner in = new Scanner (f);
			
			for(int i = 0; i < 12; i++){
				String line = in.nextLine();
				System.out.print("\n");
				for(int j = 0; j < 30; j++){
					grid[j][i] = line.charAt(j);
				}
			}
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
	}
	//Method to print a room.
	public void printRoom(){
		for(int i = 0; i < 12; i ++){
			for(int j = 0; j < 30; j++){
				System.out.println(grid[j][i]);
			}//If the room prints backwards, then change the i and j variables above?
		}
	}
	//To print the room in the world class, do room1.printRoom()?
	
}
