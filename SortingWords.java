/*Hackerrank Sample 4
Question: The goal is to sort a list of words by alphabetical order
*/


import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        int N = myScanner.nextInt();				//Take in num of words
        String blank = myScanner.nextLine();		//get rid of white space after int
        
        String []myArray = new String[N];			//make string array with length N
        for(int i=0; i<N; i++)						//make all the elements of array equal the words
            {
               myArray[i]=myScanner.nextLine();
            }
        bubbleSort(myArray);						//call the new method (below)
        
        for(int i=0; i<myArray.length; i++)
            {
                System.out.print(myArray[i]+" ");
            }
        
    }
    public static void bubbleSort(String [] myArray){	    //new method takes in a string array
        for(int outer=myArray.length-1; outer>0; outer--)	//Nested loop (outer starts at end of array)
            {
                for(int inner=0; inner<outer; inner++)		//inner loop starts at beginning and goes to the new outer each time
                    {
                            if(myArray[inner].compareTo(myArray[inner+1])>0) 	//if word1 > word 2
                            {
                                String temp = myArray[inner];					//swap positions
                                myArray[inner]=myArray[inner+1];
                                myArray[inner+1]=temp;
                            }
                    }
            }
    }
}
