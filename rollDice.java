package assignment2;

import java.util.Random;


public class rollDice {
static int count;
static int total;
static long seed = (new java.util.Date()).getTime();
static java.util.Random rnd = new java.util.Random(seed);

static boolean exit = true;
	public static void main(String[] args) {
		
	while(exit) {
		int die1 = rnd.nextInt(6)+1;
		int die2 = rnd.nextInt(6)+1;
		int roll = die1 + die2;
		if( roll != 7){
			count++;
			total = total + roll;
		System.out.println("This is roll number " + count);
		System.out.printf(" die1 = "+ die1);
		System.out.println(" die2 = "+ die2);
		System.out.println("You rolled a " + roll);
		System.out.println("Your total is " + total );
		
		} 
		
		else {System.out.println("Game Over!");
		exit = false;
		 
			
		
		}
		
		
	}

	}

}
