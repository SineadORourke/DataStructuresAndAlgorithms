/*Hackerrank Lab 4.2
Question: The goal is to read in a number N and output the Nth prime number.
For example, if N is 3, then output 5, because 5 is the thrid prime number.
*/

import java.util.*;
public class Solution {
public static void main(String args[] ) throws Exception {
    Scanner myScanner = new Scanner(System.in);
    int num = myScanner.nextInt();                     	 //Take in input
    boolean []myArray = new boolean [10000];     		//Make a REALLY big boolean array to find up to 1000 prime numbers
    for(int i=0; i<myArray.length; i++){                //Fill each slot with true
        myArray[i]=true;
    }
    int [] myPrimeArray = new int [10000];              //Make new REALLY big boolean array to hold the prime numbers
    int counter=0;
    for(int i=2; i<myArray.length; i++){                //Checks if a number is true
        if(myArray[i]==true){               
            myPrimeArray[counter]=i;                    //If true, add the slot number to primeArray
            counter++;
            for(int j=i; j<myArray.length; j++){        //Remove any numbers from the array that are divisible by this prime number
                if(j%i==0){
                    myArray[j]=false;
                }
            }
        }
    }
    System.out.println(myPrimeArray[num-1]);            //Print out the answer 
}
}
