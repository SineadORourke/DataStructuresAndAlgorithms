/*
Hackerrank Sample 5
Question: Use a stack to check if a sentence is a palindrome or not. A palindromic sentence is one that
reads the same forwards as backwards when you ignore all the spaces. Only lower case letters and spaces 
will be used. If the sentence is palindromic, output TRUE, otherwise output FALSE.
*/


import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        					//get rid of spaces from the input and store in a new String
        String myString = "";
        for(int i=0; i<input.length(); i++){
            if(Character.isLetter(input.charAt(i))){
                myString = myString+(input.charAt(i));
            }
        }
       				 //create Stack and push all the characters from the spaceless String
        Stack myStack = new Stack(myString.length());
        for(int i=0; i<myString.length(); i++){
                myStack.push(myString.charAt(i));
            }
       					 //pop all the Stack elements into another new String
        String newString = "";
        for(int i=0; i<myString.length(); i++){
                newString = newString+(myStack.pop());
            }
       				//Compare the two [spaceless] Strings to see if they are palindromes
        if(myString.compareTo(newString)==0){
            System.out.print("TRUE");
            }
        else{
            System.out.print("FALSE");
        }
	}
}

			
class Stack{                                       	 //Stack class
    private int maxSize;
    private char [] stackArray;
    private int top;
    
    public Stack(int s){
        maxSize=s;
        stackArray = new char [maxSize];
        top = -1;
    }
    
    public void push(char item){
        top++;
        stackArray[top]=item;
    }
    
    public char pop(){
        return stackArray[top--];
    }
    
    public char peek(){
        return stackArray[top];
    }
    
    public boolean isEmpty(){
        return (top == -1);
    }
    
    public boolean isFull(){
        return (top==maxSize-1);
    }
	
	public void makeEmpty(){
		top=-1;
	}
}
