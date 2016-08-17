package assignment2;

public class craps {
	
	static long seed = (new java.util.Date()).getTime();
	static java.util.Random rnd = new java.util.Random(seed);

	   public static void main(String[] args) {
			
		    int point;
			int wins = 0;
			int losses = 0;	
			
				
		for(int totalGames = 0; totalGames <= 199; totalGames= wins + losses) {
			int die1 = rnd.nextInt(6)+1;
			int die2 = rnd.nextInt(6)+1;
			int roll = die1 + die2;
		
		if(roll == 2 || roll == 3 || roll == 12){
			System.out.println("You rolled a " + roll + " and your game is over.");
			losses++;
			}
		     
		else if(roll == 7){
			System.out.println("You rolled a 7, WINNER!");
			wins++;
		}
		
		else {
			point = roll;
			System.out.println("Point number is " + point);
			while (true) {
				die1 = rnd.nextInt(6)+1;
				die2 = rnd.nextInt(6)+1;
				roll = die1 + die2;
				
				System.out.println("New roll is "+ roll);
						
			if(roll == point){
				System.out.println("Your roll was on point, Winner!");
				wins++;
				break;
			}
			if(roll == 7){
				System.out.println("You rolled a 7, Lost");
				losses++;
				break;
			}
			}
		}
		System.out.println("Wins = " + wins);
		System.out.println("Losses = " + losses);
		}
		}
}