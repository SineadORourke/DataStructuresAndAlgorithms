/*
Hackerrank - Lab 3
Question: The goal is to read in a list of integers into an array and output the one
which occurs most frequently. If there are two or more values that occur most frequently
then choose the one which was earliest in the list
*/

import java.util.*;
public class CS210Lab3Mode{
	public static void main (String[]args){
		Scanner myScanner = new Scanner(System.in); 
		int T = myScanner.nextInt();			//Take in size of array
		int [] myArray = new int [T];			//create array
		for(int i=0; i<myArray.length; i++){		//fill array with inputs
			int num = myScanner.nextInt();
			myArray[i]=num;
		}
		
		int record=0;	//variable to hold the amount of times a number comes up
		int recordNumber=0;			//variable to hold the mode
		
		for(int i=0; i<myArray.length; i++){	//loop through elements
			int count=0;					
			for(int j=0; j<myArray.length; j++){}//loop through elements
				if(myArray[i]==myArray[j]){
					count++;	//count how many times a number appears
				}
			}
			
			if(count>record){				
				record=count;		//record if the top number of repeats
				recordNumber=myArray[i]; //recordNumber is the number repeated
			}
		}
		System.out.println(recordNumber);	//Print answer
	}
}
