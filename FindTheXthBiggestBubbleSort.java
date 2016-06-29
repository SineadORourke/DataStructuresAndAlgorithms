/*
Hackerrank Lab 5
Question: The goal is to read in a list of integers into an array, read in an integer x, and print out the xth biggest number.
For example, given the list 4,8,2,5, and 3, and x is 2, then you should output 5.
*/



import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        int len = myScanner.nextInt();			//take in array length
        int [] myArray = new int [len]			//create array
        for(int i=0; i<myArray.length; i++){	//loop through + fill with elements
            myArray[i]=myScanner.nextInt();
        }
        bubbleSort(myArray)						//call new method to sort array

        int x = myScanner.nextInt();			//take in final int
        int i = myArray.length					//find the length of the array
        System.out.print(myArray[i-x]);			//print the xth element in array
    }
    
    public static void bubbleSort(int [] myArray){			//bubble sort method
        for(int outer = myArray.length-1; outer>0; outer--){	//keep track of sorted
            for(int inner = 0; inner<outer; inner++){			//loop through + swaps
                if(myArray[inner]>myArray[inner+1]){
                    int temp = myArray[inner];
                    myArray[inner] = myArray[inner+1];
                    myArray[inner+1]= temp;
                }
            }
        }
    }
}
