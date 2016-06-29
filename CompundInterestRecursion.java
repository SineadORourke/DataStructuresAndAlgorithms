/*
Hackerrank Lab 9ii
Question: Wrie a recursive method that takes in a bank account balance x, an interest rate i and a number of years y,
and outputs how much the bank account will be worth after y years. For example, if you invest  €100 at 2% annual interest,
then after year 1 you have €102.00, after year 2 you have €104.04, after year 3 you have €106.12 and so forth.
*/


import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner myScanner = new Scanner(System.in);
		int y = myScanner.nextInt();
		double i = myScanner.nextDouble();
		double x = myScanner.nextDouble();
		System.out.println(String.format("%.2f", compound(y, i, x)));
	}
	
	public static double compound(int y, double i, double x){
		if (y<=0){          //base case
			return x;
		}
    
		int one = y--;		//decrease year
		double two = i;
		double three = x;
		double factor = 1.0*(two/100);
		return (factor*compound(one, two, three));
	}
}