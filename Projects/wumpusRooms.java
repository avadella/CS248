package Projects;
//wumpusRooms class
import java.util.*; 

//This class represents a single room in modeling the caves for the Wumpus program
public class wumpusRooms
{
	//Data members 
	int roomNumber; 
	int adjacent1;
	int adjacent2;
	int adjacent3;
	String roomDescription; 
	
	//Constructor
	public wumpusRooms(int r, int a1, int a2, int a3, String rd) 
	{ 
		roomNumber = r; 
		adjacent1 = a1; 
		adjacent2 = a2; 
		adjacent3 = a3; 
		roomDescription = rd; 
	} 
	
	//Constructor - Just do this in the main...
	public wumpusRooms (Scanner file)
	{ 
		 roomNumber = file.nextInt();
		 adjacent1 = file.nextInt(); 
		 adjacent2 = file.nextInt(); 
		 adjacent3 = file.nextInt(); 
		 roomDescription = file.nextLine();
		 roomDescription = file.nextLine(); 
	} 
	
	//Accessors
	//Returns the room number
	public int getRoomNumber() 
		{return roomNumber;}
	//Returns the first adjacent room
	public int getAdjacent1() 
		{return adjacent1;}
	//Returns the second adjacent room
	public int getAdjacent2() 
		{return adjacent2;}
	//Returns the third adjacent room
	public int getAdjacent3() 
		{return adjacent3;}
	//Returns the description of the room
	public String getRoomDescription() 
		{return roomDescription;}
} 
