package Projects.assignment3;
//Interface for Date objects to be used by the Year3000 driver program

public interface dateInterface
{ 
	//Returns the day of the month (1-31) 
	public int getDay(); 
	//Returns the day of the week (0-6)
	public int getDow(); 
	//Returns the month of the year (1-12)
	public int getMonth(); 
	//Returns the year (four digits)
	public int getYear();
	//Sets the date 
	
	//@param m the month of the year (1-12)
	//@param d the day of the month (1-31)
	//@param y the year (four digits)
	//@param dow the day of the week (0-6)
	public void set(int m, int d, int y, int dow);
	
	//Moves the date forard by exactly one day
	public void tomorrow(); 
	
	//Returns the date as a String in the format "Monday March 18, 2002" 
	public String toString(); 
	
	//Sets the date to today 
	public void today(); 
	//Make this empty {} unless you do the extra credit
	
	//Moves the date backwards by exactly one day
	public void yesterday(); 
	//Make this empty {} unless you do the extra credit 
} 