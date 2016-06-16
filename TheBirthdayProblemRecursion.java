/*
Hackerrank Sample 8
Question: Write a recursive method that finds the probability that in a class of n people,
some pair of them will have the same birthday.
*/

import java.util.Scanner;

public class Solution{
	public static void main(String args[]){
		Scanner myscanner = new Scanner(System.in);
		int n = myscanner.nextInt();
		System.out.println(String.format("%.3f", (1-birthday(n))));
	}
	
	public static double birthday(int n){
		double input = (double)n;		//cast the input to a double (input is no. of people)
		double value = 0;				//declare variables 
		int x = 0;

		if (input<=1){					//If no. of people is 1 or less
			return 1;					//base case, return just 1
		}else{							//otherwise, use recursive method
			value = ((366-input)/365);	//366 – no. of people / days in a year
			x = (int)input - 1;			//cast x into an int (recursive part)
		}

		return (value*birthday(x));
	}
}