package Projects.assignment5;
public interface Container
{ 
	public void makeEmpty();
	//Erases all data
	public int size(); 
	//Returns the number of items
	public boolean isEmpty();
	//Returns true if there are no items
	public boolean isFull();
	//Returns true if there is no room
} 