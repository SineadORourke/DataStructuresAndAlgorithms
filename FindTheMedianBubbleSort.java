/*Hackerrank Lab 5.2
Question: The goal is to read in a list of integers into an array and output the one
which is the median, that is, the one which if you put them all in order would be in the middle.
If there are two in the middle then take the average of those two. For example, the median of 4, 8, 2, 3 and 5
is 4. The median of 2, 7, 4 and 9 is 5.5 because 5.5 is the average of 4 and 7.
*/

import java.util.*;
public class Solution {
public static void main(String args[] ) throws Exception {
    Scanner myScanner = new Scanner(System.in);
    int num = myScanner.nextInt();                     			//Take in size of array
    
    int [] myArray = new int [num];                     		//Fill array with the inputs
    for(int i=0; i<num; i++){
        myArray[i]=myScanner.nextInt();
    }
    
    bubbleSort(myArray);                               			//Call the bubble sort method
    
    if(num%2==0){                                      			//if there is no single midpoint
        double num1 = (double)myArray[num/2];      				//get the two middle slots (convert to double)
        double num2 = (double)myArray[(num/2)-1];
        
        double average =(num1+num2)/2;                  		//get the average of the two middles
        System.out.println(average);                   	 		//print out the average
    }else{                                              		//otherwise, there is a midpoint
        double num3 = (double)myArray[num/2];    				//get the middle slot (convert to double)
        System.out.println(num3);                      	 		//print out the middle element
    }
}
    

public static void bubbleSort(int[]myArray){                 	//takes in an array to be sorted
    int outer, inner;
    for(outer=myArray.length-1; outer>0; outer--){      		//outer keeps track of the bubbled elements
        for(inner=0; inner<outer; inner++){            	      	//inner keeps track of the unsorted elements
            if(myArray[inner]>myArray[inner+1]){            	//if the current element is bigger than the next 
                int temp=myArray[inner];               	    	//swap them
                myArray[inner]=myArray[inner+1];
                myArray[inner+1]=temp;
            }
        }
    }
}
}
