package Projects.assignment5;
//Party class
import java.util.*; 

//This class represents a single party in the La Food program
public class Party 
{
	//Data members 
	public int timeofArrival;
	public static int timeofSeat;
	public int partyNum; 
	public String tableName; 
	public char input;
	
	//Constructor
	public Party (int toa, int tos, int n, String tn, char i)
	{
		timeofArrival = toa; 
		timeofSeat = tos; 
		partyNum = n; 
		tableName = tn; 
		input = i;
	} 
	
	//Constuctor 
	public Party (Scanner file)
	{
		timeofArrival = file.nextInt();
		partyNum = file.nextInt();
		tableName = file.nextLine(); 
	} 
	
	public String toString()
	{
		return "  Party" + tableName + " of " + partyNum + " people. (time = " + timeofArrival + ")";
	} 
	
	//Accessor
	//Returns the arrival time (in minutes past opening time)
	public int getTimeofArrival()
	{
		return timeofArrival; 
	} 
	public static int getTimeofSeat(Scanner in)
	{
		timeofSeat = in.nextInt(); 
		return timeofSeat; 
	} 
	//Returns the number of people in the party
	public int getPartyNum()
	{
		return partyNum; 
	} 
	//Returns the name to call when the table is ready
	public String getTableName()
	{
		return tableName; 
	} 
} 