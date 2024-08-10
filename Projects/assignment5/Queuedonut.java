package Projects.assignment5;

public class Queuedonut implements Queue
{ 
	int front, back, count; 
	Object [] donut; 
	
	public Queuedonut(int maxsize)
	{
		donut = new Object[maxsize];
		count = 0; 
		back = 0; 
		front = 0; 
	} 
	
	public Queuedonut()
	{
		this(100); 
	} 
	
	public void enqueue(Object x)
	{
		if (isFull())
			return;
		count++; 
		back++;
		if (back >= donut.length)
			back = 0; 
		donut[back] = x; 
		if (count == 1)
		//This is the only item
			front = back; 
	} 
	public Object dequeue()
	{ 
		if (isEmpty())
			return null; 
		int oldFront = front; 
		front++; 
		if (front >= donut.length)
			front = 0; 
			//Wraparound
		count--; 
		return donut[oldFront]; 
	} 
	public Object getFront()
	{ 
		if (isEmpty())
			return null; 
		return donut[front]; 
	} 
	
	public void makeEmpty()
	{ 
		count = 0; 
		front = 0; 
		back = 0; 
	} 
	public int size()
	{ 
		return count;
	} 
	public boolean isEmpty()
	{ 
		return count <= 0; 
	} 
	public boolean isFull()
	{ 
		return count >= donut.length; 
	} 
} 