package ssa;

import java.util.Scanner;
// main class declaration
public class RPNCalculator {
	

	public static void main(String[] args) {
		int solution = 0;
		Scanner z = new Scanner(System.in);
//prompts for user to enter parameters for equation
		System.out.println("Enter a number:");
		int x = z.nextInt();
		
		System.out.println("Enter another number:");
		int y = z.nextInt();
		
		System.out.println("Enter the operation you would like to perform:");
		String operand = z.next();
		
		System.out.println("You would like to solve:");
		
		System.out.print(x); System.out.print(y); System.out.println(operand);
//switch statement to handle the operand as a string		
		switch(operand){
		
			case "+": solution = x + y;
			break;
		
			case "-": solution = x - y;
			break;
			
			case "/": solution = x / y;
			break;
			
			case "*": solution = x * y;
			break;
		}
		System.out.println("Your solution is " + solution);
	}

}
