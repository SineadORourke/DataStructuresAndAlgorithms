/*
Hackerrank Lab 10.2
Question: The goal is to sort a long list of words by special order. The special order is as follows; All words are sorted by length, starting
with the shortest words, and ending with the longest words. For words that have the same length, these should be sorted alphabetically.
*/

import java.util.*;
public class Solution{
    public static String[] myarray;                         //Declare 2 arrays as class variables
    public static String[] workSpace;

    public static void main(String[] args){
        Scanner myscanner = new Scanner(System.in);
        int num = Integer.parseInt(myscanner.nextLine());   //take in the array length
  
        myarray = new String[num];                         	//initialize both arrays
        workSpace = new String[num];
        for(int i=0;i<num;i++){                            	//populate first array with inputs
            myarray[i]=myscanner.nextLine();
        }
      
        mergeSort(0, myarray.length-1);                     //call the mergesort method on first array
        for(int i=0;i<num;i++){                             //print out the now sorted array
            System.out.println(myarray[i]);
        }
    }
    
    public static void mergeSort(int left, int right){     	//mergeSort method
        int mid = (left + right) /2;                       	//get the midpoint
        if(left==right) return;	                            //base case
        mergeSort(left, mid);                               //recursion (with first half)    
        mergeSort(mid+1, right);                        	//recursion (with second half)
        for(int i=left; i<=right; i++){                     //copy the firstarray into the second array
            workSpace[i]=myarray[i]; 
        }
        int num1=left;                                      //start point of first half
        int num2=mid+1;                                     //start point of second half
        for(int curr=left; curr<=right; curr++){            //merge workspace
            if(num1>mid){			               			//copies all remnants in
				myarray[curr]=workSpace[num2++]; 
            }else if(num2>right){		               		//copies all remnants in
                myarray[curr] = workSpace[num1++]; 
            }else if(check(workSpace[num1], workSpace[num2])){  //check order with special method	   
                myarray[curr]=workSpace[num1++];	           //merge
            }else{
                myarray[curr]=workSpace[num2++];	           //merge
            }
        }
    }
	
    public static boolean check(String one, String two){    //special check method takes in two words
        if(one.length()<two.length()){                     	//if one is shorter than two, return true
            return true;
        }else if(one.length()>two.length()){               	//if two is shorter than one, return false
            return false;
        }else{                                             	//if both words have the same length
            if(one.compareTo(two)<0){                      	//if one is alphabetically smaller, return true
                return true;
            }else{                                         	//otherwise return false
                return false;
            }
        }
    }
}
