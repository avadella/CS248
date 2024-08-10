package Projects;
//Assignment #2: Exam Statistics Program (ESP) - program will compute statistics from a list of exam scores
import java.io.*; 
import java.util.*; 

class examStatistics 
{ 
	static int[] loadArray() 
	throws IOException
	{ 
		int buildArray[];
		try (//Opens the user's desired text file
		Scanner cin = new Scanner(System.in)) {
			System.out.print("Please enter a file name: "); 
			String filename = cin.next(); 
			
			try (Scanner file = new Scanner(new FileReader(filename))) {
				//Takes the first value of the text value and puts it into the length variable
				int length; 
				length = file.nextInt(); 
				buildArray = new int[length]; 
				
				//Builds the array, called buildArray, which stores the info from the text file
				for (int i = 0; i < length; i++)
					buildArray[i] = file.nextInt();
			}
		} 
		return buildArray;
	}

	//Minimum score
	static int minScore(int minimum[]) 
	{ 
		int lowestScore = minimum[0]; 
		for (int i = 1; i < minimum.length; i++) { 
			if(minimum[i] < lowestScore) { 
				lowestScore = minimum[i]; 
		} 
	} 
	return lowestScore; 
	} 
	
	//Maximum score
	static int maxScore(int maximum[]) 
	{ 
		int highestScore = maximum[0]; 
		for (int i = 1; i < maximum.length; i++) { 
			if(maximum[i] > highestScore) { 
				highestScore = maximum[i]; 
			} 
		} 
		return highestScore; 
	} 
	
	//Defines variable to be used in average score for loop
	static double averageScore; 

	//Average score
	static double avgScore(int average[]) 
	{ 
		for (int i = 0; i < average.length; i++) { 
			averageScore += average[i]; 
		} 	
		averageScore = averageScore/average.length; 
		return averageScore; 
	} 
	
	//Defines letter grades as variables
	static int letterA; 
	static int letterB; 
	static int letterC; 
	static int letterD; 
	static int letterF; 
	
	//Establishes the number of A's, B's, C's, D's, and F's using a 90-80-70-60 grading scale 
	static void gradingScale(int letterGrade[]) { 
	for (int i = 0; i < letterGrade.length; i++) { 
		if (letterGrade[i] >= 90) { 
			letterA++; 
		} else if (letterGrade[i] >= 80) { 
			letterB++; 
		} else if (letterGrade[i] >= 70) { 
			letterC++; 
		} else if (letterGrade[i] >= 60) { 
			letterD++; 
		} else { 
			letterF++; 
		} 
	} 
}
	public static void main(String [] args) 
	throws IOException
	{ 
		System.out.println("***Welcome to the Exam Statistics Program!***");
		
		int examArray[]; 
		examArray = loadArray(); 
		
		System.out.println("Minimum Score: " + minScore(examArray)); 
		System.out.println("Maximum Score: " + maxScore(examArray)); 
		System.out.println("Average Score: " + avgScore(examArray)); 
		
		System.out.println("Number of scores by letter grade:");
		gradingScale(examArray); 
		System.out.println("A: " + letterA); 
		System.out.println("B: " + letterB); 
		System.out.println("C: " + letterC); 
		System.out.println("D: " + letterD); 
		System.out.println("F: " + letterF); 
		int scores = letterA + letterB + letterC + letterD + letterF; 
		System.out.println("There are " + scores + " scores."); 
	} 
} 