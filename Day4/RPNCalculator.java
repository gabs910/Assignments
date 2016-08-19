package ssa;

import java.util.Scanner;
import java.util.Stack;

//class declaration
public class RPNCalculator {

	private static Scanner z;

	public static void main(String[] args) {
		z = new Scanner(System.in);
		Stack<Integer> stk = new Stack<Integer>();
		boolean quit = false;
		boolean firstTime = true;

		while (!quit) {
//get first number from user and push to the stack			
			System.out.println("Enter a number:");
			int x = z.nextInt();
			stk.push(x);
//if loop checks to see if this is the first time the while loop runs through.
			if (firstTime) {
				firstTime = false;
//get another number from the user				
				System.out.println("Enter another number:");
				int y = z.nextInt();
				stk.push(y);
			}
//get operator for equation from user			
			System.out.println("Enter the operation you would like to perform:");
			String operand = z.next();
//pop off of the stack into the variables
			int pop1 = stk.pop();
			int pop2 = stk.pop();
//switch checks to see which operator was chosen in order to run the correct equation
			switch (operand) {

			case "+":
				stk.push(pop2 + pop1);
				break;

			case "-":
				stk.push(pop2 - pop1);
				break;

			case "/":
				stk.push(pop2 / pop1);
				break;

			case "*":
				stk.push(pop2 * pop1);
				break;
			}
			System.out.print(pop2); System.out.print(pop1); System.out.println(operand);
			System.out.println("Do you want to continue with more operations? Y or N: ");
			String stop = z.next();
			if (stop.equalsIgnoreCase("N")) {
				quit = true;
			}

		}
		System.out.println("Your solution is " + stk.pop());
	}
}
