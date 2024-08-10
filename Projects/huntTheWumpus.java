package Projects;
//Assignment #4: Hunt The Wumpus!
//Written by Anna Vadella and Noah Baker
import java.io.*;
import java.util.*; 

public class huntTheWumpus
{ 
	public static int adjacent1;
	public static int adjacent2;
	public static int adjacent3;
	public static String roomDescription; 
	public static int playerRoom = 1;
	public static int roomAmount;  
	public static int roomNumber = playerRoom;  

	public static void layout(wumpusRooms [] caveLayout, int roomAmount)
	{
		roomNumber = caveLayout[roomNumber].getRoomNumber();  
		adjacent1 = caveLayout[roomNumber].getAdjacent1(); 
		adjacent2 = caveLayout[roomNumber].getAdjacent2(); 
		adjacent3 = caveLayout[roomNumber].getAdjacent3();
		roomDescription = caveLayout[roomNumber].getRoomDescription(); 
	} 
	
	public static boolean gameFinish;
	public static int foundWumpus;
	public static int bottomlessPit; 
	public static int bottomlessPit2; 
	public static int spider;
	public static int spider2;	 
	
	public static void foundWumpus()
	{
		int max = roomAmount;
		int min = 2;
		foundWumpus = (int)Math.floor(Math.random()*(max-min+1)+min);
	}

	public static void bottomlessPit()
	{
		do
		{
			int max = roomAmount;
			int min = 2;
			bottomlessPit = (int)(Math.floor(Math.random()*(max-min+1)+min));
			bottomlessPit2 = (int)(Math.floor(Math.random()*(max-min+1)+min));
			if (bottomlessPit == bottomlessPit)
			{
				bottomlessPit2 = (int)(Math.floor(Math.random()*(max-min+1)+min));
			}
		} while (bottomlessPit == bottomlessPit2);
	}

	public static void spiderRoom()
	{
		do 
		{
			int max = roomAmount;
			int min = 2;
			spider = (int)(Math.floor(Math.random()*(max-min+1)+min));
			spider2 =( int)(Math.floor(Math.random()*(max-min+1)+min));
			if (spider == spider2)
			{
				spider2 = (int)(Math.floor(Math.random()*(max-min+1)+min));
			}
		} while (spider == spider2);
	}

	public static void randomize()
	{
		do
		{
			bottomlessPit();
			spiderRoom();
			foundWumpus();
		} while (foundWumpus == bottomlessPit || foundWumpus == bottomlessPit2 || foundWumpus == spider || foundWumpus == spider2 || bottomlessPit == spider|| bottomlessPit == spider2 || bottomlessPit2 == spider || bottomlessPit2 == spider2);
	} 
	
	public static char userInput; 
	public static int roomInput; 
	public static int arrowAmount = 3;
	public static int holdCurrent = roomNumber; 
	
	public static void arrowLost()
	{
		if (arrowAmount == 0)
		{ 
			System.out.println("You ran out of arrows. Game over!"); 
			gameFinish = true; 
		} 
	} 
	
	public static int userInput()
	{
		Scanner cin = new Scanner(System.in); 
		
		System.out.print("(M)ove or (S)hoot? "); 
		userInput = cin.next().charAt(0);
		
		if (userInput == 'M')
		{
			System.out.println("Which room? ");
			roomInput = cin.nextInt(); 
				do { 
				if (roomInput == adjacent1) 
				{ 
					roomNumber = adjacent1;
					if (roomNumber == spider || roomNumber == spider2)
					{ 
						System.out.println("I hope you're not afraid of spiders, cause omg there are a lot of them, and they look hungry..."); 
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					else if (roomNumber == bottomlessPit || roomNumber == bottomlessPit2)
					{ 
						System.out.println("You fall into a bottomless pit, and hey, spoiler alert, you're gonna be falling for a while."); 
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					else if (roomNumber == foundWumpus)
					{ 
						System.out.println("You stumbled upon the Wumpus' lair. You've been Wumped to death. :("); 
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					break; 
				} 
				else if (roomInput == adjacent2)
				{ 
					roomNumber = adjacent2;
					if (roomNumber == spider || roomNumber == spider2)
					{ 
						System.out.println("I hope you're not afraid of spiders, cause omg there are a lot of them, and they look hungry..."); 
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					else if (roomNumber == bottomlessPit || roomNumber == bottomlessPit2)
					{ 
						System.out.println("You fall into a bottomless pit, and hey, spoiler alert, you're gonna be falling for a while."); 
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					else if (roomNumber == foundWumpus)
					{ 
						System.out.println("You stumbled upon the Wumpus' lair. You've been Wumped to death. :("); 
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					break; 
				} 
				else if (roomInput == adjacent3) 
				{ 
					roomNumber = adjacent3; 
					if (roomNumber == spider || roomNumber == spider2)
					{ 
						System.out.println("I hope you're not afraid of spiders, cause omg there are a lot of them, and they look hungry..."); 
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					else if (roomNumber == bottomlessPit || roomNumber == bottomlessPit2)
					{ 
						System.out.println("You fall into a bottomless pit, and hey, spoiler alert, you're gonna be falling for a while.");
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					else if (roomNumber == foundWumpus)
					{ 
						System.out.println("You stumbled upon the Wumpus' lair. You've been Wumped to death. :("); 
						System.out.println("Game over!"); 
						gameFinish = true; 
					} 
					break;
				} 
				else 
				{ 
					System.out.println("Dimwit! You can't get to there from here.");
					userInput(); 
				} 
			} while (roomNumber != adjacent1 || roomNumber != adjacent2 || roomNumber != adjacent3);	
		} 
		
		else if (userInput == 'S')
		{
			System.out.println("Which room? ");
			roomInput = cin.nextInt(); 
			roomNumber = holdCurrent; 
			do { 
				if (roomInput == adjacent1) 
				{ 
					roomNumber = adjacent1; 
					if (roomNumber == foundWumpus)
					{
						System.out.println("Your arrow goes down the tunnel and finds its mark!"); 
						System.out.println("You shot the Wumpus!"); 
						System.out.println("**You Win!**"); 
						System.out.println(" ");
						System.out.println("Enjoy your fame!");
						arrowAmount--; 
						gameFinish = true; 
						break; 
					} 
					else
						roomNumber = holdCurrent; 
						System.out.println(" "); 
						System.out.println("Your arrow goes down the tunnel and is lost. You missed."); 
						System.out.println(" "); 
						arrowAmount--; 
						arrowLost(); 
						break; 
				} 
				else if (roomInput == adjacent2)
				{ 
					roomNumber = adjacent2; 
					if (roomNumber == foundWumpus)
					{
						System.out.println("Your arrow goes down the tunnel and finds its mark!"); 
						System.out.println("You shot the Wumpus!"); 
						System.out.println("**You Win!**"); 
						System.out.println(" ");
						System.out.println("Enjoy your fame!");
						arrowAmount--; 
						gameFinish = true; 
						break;
					}
					else 
						roomNumber = holdCurrent; 
						System.out.println(" "); 
						System.out.println("Your arrow goes down the tunnel and is lost. You missed."); 
						System.out.println(" "); 
						arrowAmount--; 
						arrowLost(); 
						break; 
				} 
				else if (roomInput == adjacent3) 
				{ 
					roomNumber = adjacent3;
					if (roomNumber == foundWumpus)
					{
						System.out.println("Your arrow goes down the tunnel and finds its mark!"); 
						System.out.println("You shot the Wumpus!"); 
						System.out.println("**You Win!**"); 
						System.out.println(" ");
						System.out.println("Enjoy your fame!");
						arrowAmount--; 
						gameFinish = true; 
						break; 
					} 
					else 
						roomNumber = holdCurrent; 
						System.out.println(" "); 
						System.out.println("Your arrow goes down the tunnel and is lost. You missed."); 
						System.out.println(" "); 
						arrowAmount--; 
						arrowLost(); 
						break; 
				} 
				else 
				{
					System.out.println("Dimwit! You can't get to there from here.");
					userInput(); 
				} 
			} while (roomNumber != adjacent1 || roomNumber != adjacent2 || roomNumber != adjacent3);	
		} 
		return roomNumber;
	} 
		
	public static void main(String [] args) 
	throws IOException
	{ 
		//Open wumpus.txt file
		Scanner file = new Scanner(new FileReader("wumpus.txt")); 
		
		//Define amount of rooms 
		roomAmount = file.nextInt();
		wumpusRooms [] caveLayout; 
		caveLayout = new wumpusRooms[roomAmount]; 
		caveLayout[0] = null; 
		
		//Read wumpus.txt file
		for (int i = 1; i < caveLayout.length; i++)
		{
			caveLayout[i] = new wumpusRooms(file);
		}
		
		System.out.println("Welcome to **Hunt The Wumpus!**"); 
		System.out.println(" "); 
		
		spiderRoom();
		bottomlessPit();
		foundWumpus();
		randomize();
		
		do
		{ 
			layout(caveLayout, roomAmount); 
			System.out.println("You are in room " + roomNumber + "."); 
			System.out.println("You have " + arrowAmount + " arrow(s) left."); 
			System.out.println(roomDescription); 
			System.out.println("There are tunnels to rooms " + adjacent1 + ", " + adjacent2 + ", and " + adjacent3 + "."); 
			if (adjacent1 == foundWumpus)
			{ 
				System.out.println("You smell some nasty Wumpus!"); 
			} 
			else if (adjacent2 == foundWumpus)
			{
				System.out.println("You smell some nasty Wumpus!"); 
			} 
			else if (adjacent3 == foundWumpus)
			{
				System.out.println("You smell some nasty Wumpus!"); 
			} 
			if (adjacent1 == bottomlessPit || adjacent1 == bottomlessPit2)
			{ 
				System.out.println("You smell a dank odor."); 
			} 
			else if (adjacent2 == bottomlessPit || adjacent2 == bottomlessPit2)
			{
				System.out.println("You smell a dank odor."); 
			} 
			else if (adjacent3 == bottomlessPit || adjacent3 == bottomlessPit2)
			{
				System.out.println("You smell a dank odor."); 
			} 
			if (adjacent1 == spider || adjacent1 == spider2)
			{ 
				System.out.println("You hear a faint clicking noise. "); 
			} 
			else if (adjacent2 == spider || adjacent2 == spider2)
			{
				System.out.println("You hear a faint clicking noise. "); 
			} 
			else if (adjacent3 == spider || adjacent3 == spider2)
			{
				System.out.println("You hear a faint clicking noise. "); 
			} 
			System.out.println(" "); 
			userInput(); 
		} while (gameFinish != true); 
	} 
}	