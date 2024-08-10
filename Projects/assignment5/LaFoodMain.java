package Projects.assignment5;
//Assignment #5: La Food 
//Written by Anna Vadella and Noah Baker
import Projects.assignment5.Queue;
import java.io.*;
import java.util.*;

class LaFoodMain
{
  public static char input;
  public static int timeofArrival;
  public static int timeofSeat;
  public static double totmins = 0;
  public static int partyNum;
  public static String tableName;
  public static double average; 
  public static int count; 

  public static void main(String[] args)
  throws IOException
  {
    Queue Q = new Queuedonut();

    System.out.println("*** Welcome to the La Food Restaurant Simulator ***");
    System.out.println();
	
	//Opens user's desired text file
    Scanner cin = new Scanner(System.in);
    String filename;
    System.out.print("please enter a file name: ");
    filename = cin.next();
    System.out.println();

    Scanner file = new Scanner(new FileReader(filename));
    do
    {
      input=file.next().charAt(0);
      if(input== 'A')
      {
		    System.out.println("Please wait at the bar, ");
		    Party p = new Party(file);
        Q.enqueue(p);
        System.out.println(p);
      }
      else if(input== 'T')
      {
        Party prty = (Party) Q.dequeue();
        timeofSeat = Party.getTimeofSeat(file);
        System.out.println("Table for" + prty.getTableName() + "! (time = " + timeofSeat + ")");
		    partyNum = prty.getPartyNum();
        timeofArrival = prty.getTimeofArrival();
		    count = count + prty.getPartyNum();
        totmins = totmins + partyNum * (timeofSeat - timeofArrival);
		    average = totmins/count; 
      }
      else if(input == 'Q')
      {
        System.out.println("** Simulation Terminated **");
      }
	  else
      {
        //empty
      }
    } while (file.hasNext());
    System.out.println();

    System.out.println("The average waiting time was: " + average);
    System.out.println("The following parties were never seated: ");
	
    if(Q.getFront() == null)
    {
      System.out.println("None! You did great today.");
    }
    else
    {
		do
		{
			Party p = (Party) Q.dequeue();
			System.out.println("  Party" + p.getTableName() + " of " + p.getPartyNum() + " people");
		} while (!Q.isEmpty());
    }
	
    System.out.println();
    System.out.println("Have a nice meal!");
	System.out.println();
  }
} 