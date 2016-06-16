/*Hackerrank Sample 9
Question: The goal is to sort a long list of words by special order, namely usual [a-z]
alphabetical order, but considering the words in an inverted fashion. The last letter in the word
 has the significance,t he second last letter has the second greatest significance, the third last letter
 has the third greatest significance and so forth...
 */
 
import java.io.*;
import java.util.*;
public class Solution {
public static void main(String args[] ) throws Exception {		//main method
    Scanner myScanner = new Scanner(System.in);
    int num = myScanner.nextInt();
    String blank = myScanner.nextLine();
    String [] myArray = new String [num];
    for(int i=0; i<num; i++){				//populate array with the input
        myArray[i]=myScanner.nextLine();
    }
    mergeSort(myArray, 0, num-1);			//call the merge method
    for(int i=0; i<num; i++){				//print out newly sorted method
        System.out.println(myArray[i]);
    }
}

public static boolean check(String one, String two){    	//check method (special order)
    String reverse1 = "";									//temp variables
    String reverse2 = "";
    for(int i=0; i<one.length(); i++){						//reverse first input
        reverse1= one.charAt(i)+reverse1;
    }
    for(int i=0; i<two.length(); i++){						//reverse second input
        reverse2 = two.charAt(i)+reverse2;
    }
    if(reverse1.compareTo(reverse2)<0){						//check if the reverse of the words is alphabetical
        return true;
    }else{
        return false;
    }
}
public static void mergeSort(String[] myArray, int left, int right){		//merge method
    int mid = (left+right)/2;								//find midpoint
    if(left==right){										//base case
        return;
    }
    mergeSort(myArray, left, mid);							//recursion to half the array
    mergeSort(myArray, mid+1, right);
    String [] workspace = new String[myArray.length];
    for(int i=left; i<=right; i++){
        workspace[i]=myArray[i];							//copy array to workspace
    }
    int num1 = left;
    int num2 = mid+1;
    for(int curr=left; curr<=right; curr++){				//merge workspace
        if(num1>mid){
            myArray[curr]=workspace[num2++];				//copy elements back to array
        }else if(num2>right){
            myArray[curr]=workspace[num1++];				//copy elements back to array
        }else if(check(workspace[num1], workspace[num2])){	//call special check method
            myArray[curr]=workspace[num1++];				//merge
        }else{
            myArray[curr]=workspace[num2++];				//merge
        }
    }
}
}
