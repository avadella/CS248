package Projects.assignment7;

import java.util.*;

public class camper implements Comparable
{
	//Data members
	String name;
	int age;
	char diet; 
	
	//Constructor
	public camper(String n, int a, char d)
	{
		name = n; 
		age = a;
		diet = d; 
	} 
	
	//Constructor
	public camper(Scanner file)
	{
		if(file.hasNext())
		{
			name = file.next(); 
			if(file.hasNextInt())
			{
			age = file.nextInt(); 
				if(file.hasNext())
					diet = file.next().charAt(0); 
			}
		}
	} 
	
	public String toString()
	{
		return name + " " + age + " " + diet + " "; 
	} 
	
	//Accessors
	public String getName()
	{
		return name; 
	} 
	public int getAge()
	{
		return age; 
	} 
	public char getDiet()
	{
		return diet; 
	} 
	
//To be used with BST class
	public int compareTo(Object x)
	{
		if(x instanceof camper) 
		{ 
			camper c = (camper)x; 
			if(name.compareTo(c.name) < 0) return -1; 
			if(name.compareTo(c.name) > 0) return +1; 
			return 0;
		} 
		else 
		{ 
			System.out.println("Error: x is not a camper in compareTo()"); 
			System.exit(1);
			return 0; 
		}
	}
} 