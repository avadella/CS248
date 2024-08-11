package Projects.assignment7;
//Camp Posanivee Assignment: Program that will use a binary search tree to keep track of campers enrolled in a summer camp
//Written by Anna Vadella and Noah Baker
import java.io.*;
import java.util.*;

class campPosanivee
{
	public static void printMenu()
	{
		System.out.println("H - Help: print a list of commands");
		System.out.println("E - Enroll a new camper (insert)");
		System.out.println("W - withdraw a camper");
		System.out.println("D - Display the age and diet of a camper");
		System.out.println("A - Print the average age of the campers");
		System.out.println("L - List all campers names in alphabetical order");
		System.out.println("V - Print the number of vegan campers");
		System.out.println("P - List all campers names in preorder");
		System.out.println("Q - Quit");
	}

	public static void main (String [] args)
	throws IOException
	{
		BST T = new BST();
		int count = 0; 
		
		System.out.println("Welcome to Camp Posanivee!");

		//Open camp.txt file
		Scanner file = new Scanner(new FileReader("camp.txt"));

		do{
				char menuOption = file.next().charAt(0);
				System.out.print("Command: " + menuOption);
				System.out.println();
				if(menuOption == 'H' || menuOption == 'h')
				{
					printMenu();
				}
				else if(menuOption == 'E' || menuOption == 'e') 
				{
					camper c = new camper(file); 
					T.insert(c);
					count++; 
					System.out.println(c); 
					System.out.println("New camper added."); 
					System.out.println(); 
				}
				else if(menuOption == 'W' || menuOption == 'w')
				{
					String name = file.next(); 
					System.out.println(name);
					T.delete(new camper(name, 0, ' '));
					System.out.println("Camper withdrawn.");
					System.out.println();
				}
				else if(menuOption == 'D' || menuOption == 'd')
				{ 
					String name = file.next();
					System.out.println(name);
					camper print = (camper)T.lookup(new camper(name, 0, ' '));
					if(print != null)
					{
						System.out.println("   Name: " + print.getName());
						System.out.println("   Age: " + print.getAge());
						System.out.println("   Diet: " + print.getDiet());
					}
					else
						System.out.println("Camper not found.");
					System.out.println(); 
				}
				else if(menuOption == 'A' || menuOption == 'a')
				{
					double averageAge = 0;
					double countCamper = 0; 
					T.reset(BST.PRE); 
					if(T.size() <= 0)
						System.out.println("There are no campers.");
					else 
					{
						while(T.hasNext())
						{
							countCamper++; 
							camper hold = (camper)T.getNext(); 
							averageAge = hold.getAge() + averageAge; 
						} 
						System.out.println("Average age: " + averageAge/countCamper);
					} 
					System.out.println();
				}
				else if(menuOption == 'L' || menuOption == 'l')
				{
					System.out.println("Alphabetical List of Campers:");
					T.reset(BST.IN); 
					while(T.hasNext())
					{
						camper hold = (camper)T.getNext(); 
						System.out.println("  " + hold.getName());
					} 
					System.out.println();
				}
				else if(menuOption == 'V' || menuOption == 'v')
				{
					int countVegan = 0;
					T.reset(BST.IN);
					while(T.hasNext())
					{
						camper hold = (camper)T.getNext(); 
						if(hold.getDiet() == 'V' || hold.getDiet() == 'v')
							countVegan++; 
					} 
					System.out.println("Number of vegan campers: " + countVegan);
					System.out.println();
				}
				else if(menuOption == 'P' || menuOption == 'p')
				{
					System.out.println("Preorder Traversal:");
					T.reset(BST.PRE);
					while(T.hasNext())
					{
						camper hold = (camper)T.getNext();
						System.out.println("   " + hold.getName()); 
					}
					System.out.println();
				}
				else if(menuOption == 'Q' || menuOption == 'q')
					System.out.println("End of program.");

				file.nextLine();
		} while(file.hasNext());

		System.out.println("Bring plenty of calomine!");
	}
}