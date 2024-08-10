package Projects.assignment3;
//Asignment #3: The Dating Game
//Dating Game Class 

public class myDate implements dateInterface
//will have all of the functions listed within the DateInterface interface
{ 
	//Defines variables
	static int day; 
	static int month; 
	static int dayOf; 
	static int year; 

	//Acessor (getter) for day
	public int getDay() 
	{ 
		return day; 
	} 
	
	//Acessor (getter) for day of the week
	public int getDow() 
	{ 
		return dayOf; 
	} 
	
	//Acessor (getter) for month
	public int getMonth()
	{ 
		return month; 
	} 
	
	//Acessor (getter) for year
	public int getYear()
	{ 
		return year; 
	} 

	public void set(int m, int d, int y, int dow)
	{ 
		day = d; 
		dayOf = dow; 
		month = m; 
		year = y; 
	}
	
	public static boolean leap = false; 
	
	//Establishes whether or not a leap year exists
	public static void leapYear() 
	{ 
		if (year%4 == 0)
			if (year%100 != 0) 
				leap = true; 
		else if (year%100 == 0 && year%400 == 0)
				leap = true;
		else 
			leap = false; 
	}
	
	//Determines what year it is 
	public static int theYear()
	{ 
		year++; 
		return year; 
	} 
	
	//Defines the variable used for the length of the month
	public static int lengthOfMonth; 
	
	//Determines how many days are in each month
	public static int monthSequence()
	{ 
		if (month >= 1 && month <= 12)
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) 
				lengthOfMonth = 31; 
			else if (month == 4 || month == 6 || month == 9 || month == 11) 
				lengthOfMonth = 30; 
			else 
			{ 
				leapYear();
				if (leap == true) 
					lengthOfMonth = 29; 
				else if (leap == false)
					lengthOfMonth = 28;
			}
		return lengthOfMonth; 
	} 
	
	public static String wordMonth; 
	
	//Changes the month number (1-12) and converts it to its english equivalent
	public static String numberToMonth()
	{
		if (month == 1)
			wordMonth = "January"; 
		else if (month == 2)
			wordMonth = "February"; 
		else if (month == 3)
			wordMonth = "March"; 
		else if (month == 4)
			wordMonth = "April"; 
		else if (month == 5)
			wordMonth = "May"; 
		else if (month == 6)
			wordMonth = "June"; 
		else if (month == 7)
			wordMonth = "July"; 
		else if (month == 8)
			wordMonth = "August"; 
		else if (month == 9)
			wordMonth = "September"; 
		else if (month == 10)
			wordMonth = "October"; 
		else if (month == 11)
			wordMonth = "November"; 
		else if (month == 12)
			wordMonth = "December"; 
		
		return wordMonth; 
	} 
	
	//Determines what day of the week it is, using a 0-6 loop
	public static int dayOfWeek()
	{ 
		if (dayOf == 0)
			dayOf++; 
		else if (dayOf == 1)
			dayOf++; 
		else if (dayOf == 2)
			dayOf++; 
		else if (dayOf == 3)
			dayOf++; 
		else if (dayOf == 4)
			dayOf++; 
		else if (dayOf == 5)
			dayOf++; 
		else if (dayOf == 6)
			dayOf = 0; 
		
		return dayOf; 
	} 
	
	public static String wordDay; 
	
	//Changes the week number (0-6) and converts it to its english equivalent
	public static String numberToWeek()
	{ 
		if (dayOf == 0)
			wordDay = "Sunday"; 
		else if (dayOf == 1)
			wordDay = "Monday"; 
		else if (dayOf == 2)
			wordDay = "Tuesday"; 
		else if (dayOf == 3)
			wordDay = "Wednesday"; 
		else if (dayOf == 4)
			wordDay = "Thursday"; 
		else if (dayOf == 5)
			wordDay = "Friday"; 
		else if (dayOf == 6)
			wordDay = "Saturday";
		
		return wordDay; 
	} 
	
	//Moves the day forward by exactly one day
	public void tomorrow()
	{
		monthSequence(); 
		dayOfWeek(); 
		
		if (day < lengthOfMonth)
			day++; 

		else if(day>=lengthOfMonth)
		{
			day = 1;
			month++; 
			if (month > 12)
			{
			month = 1; 
			year = theYear(); 
			} 
		}	
		numberToMonth(); 
		numberToWeek(); 
	} 
	
	//Accessor
	public String toString()
	{
		return wordDay + " " + wordMonth + " " + day + ", " + year; 
	} 
	
	//Extra Credit
	public void today()
	{ 
		
	}
	
	//Extra Credit
	public void yesterday()
	{
		
	} 
} 