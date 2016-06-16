/*
Hackerrank Lab 9.2ii
Question: Euclid's algroithm is the oldest algorithm ever written down. It is named after
the ancient Greek mathematician Euclid, who first described it in his Elements around 300BC.
It involves a recursive algorithm for deriving the Greatest Common Divisor (GCD) of a pair of
numbers. Let the first number be x and the second number be y. If either x or y is a zero, 
then the GCD is the other number. Otherwise the GCD of (x, y) is equal to that of (y, x modulo y)
*/

import java.util.Scanner;
public class Solution{
	public static void main(String args[]){
		Scanner myscanner = new Scanner(System.in);
		long x = myscanner.nextLong();
		long y = myscanner.nextLong();
		System.out.println(GCD(x,y));
	}
	
	public static long GCD(long x, long y){
		long one;
        long two;
        if(x==0){           //base case 1
            return y;
        }else if(y==0){     //base case 2
            return x;
        }else{              //instructions given in question
            one = y;
            two = x%y;
		}
		return(GCD(one, two));
	}
}