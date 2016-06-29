/*
Hackerrank Lab 11
Question: Find the largest integer that can be created from a pair of integers and the following bit manipulation operators: <<, >>, and |.
Once the | operator is applied, the two inputs are consumed and cannot be referred to again. So you can shift the two original integers as much as you want, then apply the | operator to yield a result.
*/

import java.util.*;
public class Solution {
public static void main(String args[] ) throws Exception {
    Scanner myScanner = new Scanner(System.in);
    int num1 = myScanner.nextInt();             //take in the two inputs
    int num2 = myScanner.nextInt();
    int record = Integer.MIN_VALUE;             //make one variable set to the lowest possible num
    for(int i=0; i<=32; i++){                  	//nested loop to check all possibilities for a higher number
        for(int j=0; j<=32; j++){
            if(((num1<<i)|(num2<<j))>record){
                record=((num1<<i)|(num2<<j));	//update record if bigger one found
            }
            if(((num1>>i)|(num2<<j))>record){
                record =((num1>>i)|(num2<<j));
            }
            if(((num1<<i)|(num2>>j))>record){
                record =((num1<<i)|(num2<<j));
            }
            if(((num1>>i)|(num2>>j))>record){
                record = ((num1>>i)|(num2<<j));
            }
        }
    }
    System.out.println(record);                		 //print out the highest number found
}
}
