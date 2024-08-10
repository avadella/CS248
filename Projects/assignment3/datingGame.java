package Projects.assignment3;
//Assignment #3: The Dating Game Program
import java.io.*; 

public class datingGame
{
	public static void main(String [] args) 
	throws IOException
	{ 
		dateInterface d = new myDate(); 
		//Sets the date to Sunday, January 27th, 2019
		d.set(1,27,2019,0); 
		
		while(d.getYear() < 3000) 
		{
			d.tomorrow(); 
			//Uncomment out the next line to help with debugging
			//System.out.println(d); 
		} 
		
		//At this point d represents January 1, 3000
		System.out.println(d); 
	} 
} 