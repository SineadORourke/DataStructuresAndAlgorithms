/*
Hackerrank Sample 10
Question: The goal is to change a given number from one base to another. The first line of input contains an integer which is the base that the number
N is represented in. The second line contains an integer which is the base that the number N should be transformed into. The third line contains an integer
which represents N.
*/

import java.util.*;
public class Solution{
	public static void main(String []args){
		Scanner myScanner = new Scanner(System.in);	//take in inputs
   		int base1 = myScanner.nextInt();
    	int base2 = myScanner.nextInt();
   		int num = myScanner.nextInt();
		
    		//changing into Base 10
    		int value =0;
    		int power =0;
    		while(num>0){     			//positional number system (base1 input)
        		value+=(num%10)*Math.pow(base1, power);	
        		power++;
        		num=(num-(num%10))/10;
    		}
			
    		//change into second base (second input)	
    		String total ="";
    		String totString="";
    		while(value>0){					//Euclidean division (base2 input)
        		total=""+(value%base2);
        		totString= total + totString;			
        		value = value/base2;
   		 }
    		System.out.println(totString);			//print out answer
	}
}
