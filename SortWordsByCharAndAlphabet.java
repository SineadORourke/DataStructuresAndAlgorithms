/*
Hackerrank Lab 10
Question: The goal is to sort a long list of words by special order. The special order is as follows; All the words are sorted by the 
'greatest' character in that word. What this means is that all words whose greatest character us a 'a' (i.e. that feature only a's) should
come first, followed by all words whose greatest character is a 'b' (e.g. 'baa'), followed by all those words whose greatest character is a 'c' ...
For words that have the same greatest character (e.g. 'salt' and 'table', which both feature 't' as their greatest character), should be sorted alphabetically
(i.e. 'salt' would come first). 

*/


import java.util.*;

public class Solution{
    
    public static String [] myArray;
    public static String [] workspace;
    
    public static void main(String []args){
        Scanner myScanner = new Scanner(System.in);	//Take in the inputs
        int num = myScanner.nextInt();
        String blank = myScanner.nextLine();
        
        myArray = new String[num];
        for(int i=0; i<num; i++){
            myArray[i] = myScanner.nextLine();
        }
        
        mergeSort(0, myArray.length-1);				//call the merge method
        for(int i=0; i<num; i++){
            System.out.println(myArray[i]);
        }
    }
    
    
    public static void mergeSort(int left, int right){		//merge method
        int mid = (left+right)/2;
        if(left==right){
            return;
        }
        
        mergeSort(left, mid);
        mergeSort(mid+1, right);
        
        workspace = new String[myArray.length];
        for(int i=0; i<workspace.length; i++){
            workspace[i] = myArray[i];
        }
        
        int num1 = left;
        int num2 = mid+1;
        for(int j=left; j<=right; j++){
            if(num1>mid){
                myArray[j]=workspace[num2];
                num2++;
            }else if(num2>right){
                myArray[j]=workspace[num1];
                num1++;
            }else if(check(workspace[num1], workspace[num2])){
                myArray[j]=workspace[num1];
                num1++;
            }else{
                myArray[j]=workspace[num2];
                num2++;
            }
        }
    }
  
    public static boolean check(String one, String two){		//special sort method
        int great1 = (int)one.charAt(0);						//get biggest char in each input
        int great2 = (int)two.charAt(0);
        for(int i=1; i<one.length(); i++){
            if((int)one.charAt(i)>great1){
                great1= (int)one.charAt(i);
            }
        }
        
        for(int i=1; i<two.length(); i++){				
            if((int)two.charAt(i)>great2){
                great2= (int)two.charAt(i);
            }
        }
        
        if(great1<great2){										//compare the two chars
            return true;
        }else if(great1==great2){
            if(one.compareTo(two)<0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
