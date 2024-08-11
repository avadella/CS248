package Projects.assignment6;
//Sorts Assignment: Create a program which uses five sorting algorithms and plots a graph
//Written by Anna Vadella and Noah Baker
import java.io.*;
import java.util.*;

class sortsAssignment
{
	public static void deepFunction (Integer [] list, Integer [] list2)
	{
		for(int i = 0; i< list.length; i++)
			{
				list[i] = list2[i];
				//System.out.print(list [i] + " ");
			}	
	} 
	
	public static void main (String [] args) 
	throws IOException
	{ 
		double startTime; 
		double endTime;
		double totalTime; 
		
		Scanner cin = new Scanner(System.in);
		System.out.print("Please enter the size of the list you want to sort: "); 
		int userSize = cin.nextInt();
		System.out.println(" ");
		
		Integer [] list = new Integer[userSize]; 
		for(int i = 0; i < list.length; i++)
			list[i] = (int)(100 * Math.random() + 1); 
		
		Integer [] deepCopy = new Integer[userSize];
		for(int i = 0; i < deepCopy.length; i++)
			deepCopy[i] = list[i];

		if(userSize <= 100)
		{
			System.out.println("Original unsorted list: ");
			for(int i = 0; i < list.length; i++)
				System.out.print(list[i] + " ");
				System.out.println(" ");
		} 
		
		System.out.println(" ");
		
		//Bubble Sort - Repeatedly swaps the adjacent elements if they are in the wrong order
		startTime = System.currentTimeMillis();
		Sorts.bubble(list);
		endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort: ");
		
		if(list.length <= 100)
		{
			for(int i = 0; i < list.length; i++)
				System.out.print(list[i] + " ");
			System.out.println(" ");
		} 
		
		totalTime = (endTime - startTime);
		System.out.println("Total time in millisecond: " + totalTime);
		deepFunction(list, deepCopy);
		System.out.println(" ");
		
		//Insertion Sort - Builds final sorted array one item at a time by comparisons
		startTime = System.currentTimeMillis();
		Sorts.insertion(list);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion Sort: ");
		
		if(list.length <= 100)
		{
			for(int i = 0; i < list.length; i++)
				System.out.print(list[i] + " ");
			System.out.println(" ");
		} 
		
		totalTime = (endTime - startTime);
		System.out.println("Total time in millisecond: " + totalTime);
		deepFunction(list, deepCopy);
		System.out.println(" ");
		
		//Selection Sort - Repeatedly selects the smallest (or largest) element from the unsorted portion, swaps it with first element	
			//of the unsorted part, process repeats for the remaining unsorted portions until the entire array is sorted
		startTime = System.currentTimeMillis();
		Sorts.selection(list);
		endTime = System.currentTimeMillis();
		
		System.out.println("Selection Sort: ");
		if(list.length <= 100)
		{
			for(int i = 0; i < list.length; i++)
				System.out.print(list[i] + " ");
			System.out.println(" ");
		} 
		
		totalTime = (endTime - startTime);
		System.out.println("Total time in millisecond: " + totalTime);
		deepFunction(list, deepCopy);
		System.out.println(" ");
		
		//Quick Sort - Divide and Conquer: picks a pivot element, partitions the array around the pivot by placing pivot in its correct position
		startTime = System.currentTimeMillis();
		Sorts.quick(list);
		endTime = System.currentTimeMillis();
		System.out.println("Quick Sort: ");
		
		if(list.length <= 100)
		{
			for(int i = 0; i < list.length; i++)
				System.out.print(list[i] + " ");
			System.out.println(" ");
		} 
		
		totalTime = (endTime - startTime);
		System.out.println("Total time in millisecond: " + totalTime);
		deepFunction(list, deepCopy);
		System.out.println(" ");
		
		//Shell Sort - Variation of Insertion Sort
		startTime = System.currentTimeMillis();
		Sorts.shell(list);
		endTime = System.currentTimeMillis();
		System.out.println("Shell Sort: ");
		
		if(list.length <= 100)
		{
			for(int i = 0; i < list.length; i++)
				System.out.print(list[i] + " ");
			System.out.println(" ");
		} 
		
		totalTime = (endTime - startTime);
		System.out.println("Total time in millisecond: " + totalTime);
		deepFunction(list, deepCopy);
		System.out.println(" ");
	} 
} 