package Projects.assignment1;
//Assignment #1: Guessing Game Program - program picks random number between 1 and 100 and asks user to guess value
import java.util.*; 

class GuessingGame
{	
	//Function which contains the "introduction" statements to explain the game to the user
	static void welcomeMessage()
	{
		System.out.println("***Welcome to the Guessing Game!***"); 
		System.out.println("I have a number between 1 and 100. Can you guess it?");
	} 

	public static void main(String [] args)
	{ 
		//Defines the variable that asks the user whether or not they want to keep playing
		char keepPlaying; 
	
		//Scanner is initalized here
		Scanner cin = new Scanner(System.in); 
		do { 
			//Calls the function to display the welcome message to the user
			welcomeMessage(); 
		
			//Defines + creates the random number variable
			int randomNum; 
			randomNum = (int)(1+100*Math.random());
			
			//Defines the variable used to hold the user's guess
			int guess; 
		
			//Conditional loop which determines whether or not the user's guess is correct
			do { 
			System.out.print("Enter your guess: "); 
			guess = cin.nextInt();
			if (guess == randomNum) 
				System.out.println("You win, good job! :) ");
			else if (guess < randomNum) 
				System.out.println("Too low!"); 
			else if (guess > randomNum)
				System.out.println("Too high!"); 
			} while (guess != randomNum); 
		
		//Asks the user whether or not they want to keep playing the game
		System.out.print("Would you like to continue playing? (Y or N): "); 
		keepPlaying = cin.next().charAt(0); 
		
		} while((keepPlaying == 'Y' || keepPlaying == 'y')); 

		//Creates the print statements which will be displayed if the user does not want to keep playing
		if(keepPlaying == 'N' || keepPlaying == 'n')
			System.out.println("Thanks for playing!"); 
		else 
			System.out.println("Invalid input, ending game."); 
	} 
} 