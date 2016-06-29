/*
Hackerrank Lab 9i
Question: Write a recursive method that takes in an integer n and outputs !n (a double).
*/

import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		System.out.println(factorial(n));
	}
	
	public static double factorial(int n){
		if(n<=1){				//base case
			return 1;
		}
		int x = n-1;			//reduce for recursion (smaller problem)
		double value = 1.0/n;	//making it a double
		return (factorial(x)/value);
	}
}