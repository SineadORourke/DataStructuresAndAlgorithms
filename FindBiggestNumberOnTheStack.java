/*Hackerrank Lab 6.2
Question: Manipulate a stack according to the given push and pop commands and then
output the biggest number that is left on the stack. If a pop command is issued for 
an empty stack then nothing should happen
*/

import java.util.*;
public class Solution {
public static void main(String args[] ) throws Exception {
    Scanner myScanner = new Scanner(System.in);
    int num = myScanner.nextInt();                  		//take in number of commands
    String blank = myScanner.nextLine();           		 	//take care of blank space
    
    Stack myStack = new Stack(num);                 		//create new stack object
    
    for(int i=0; i<num; i++){                      			//loop as many times as there is commands
        String command = myScanner.nextLine();     	 		//take in command
        
        if(command.equals("POP")){             				//if the command equals POP, then pop item off stack if it is not empty
            if(!myStack.isEmpty()){
                int popped = myStack.pop();
            }
        }else{                                    			//otherwise the command is PUSH
			int item = Integer.parseInt(command.substring(5, command.length()));
															//remove the PUSH part of the command and convert to int
            myStack.push(item);                    			//push the item on to the stack
        }
    }
    
    if(myStack.isEmpty()){                         			//if the stack is empty, just print empty
        System.out.println("empty");
    }else{                                          		//otherwise
        int max = myStack.pop();                    		//assume that the next popped element is the biggest
        while(!myStack.isEmpty()){                 			//pop elements off until the stack is empty
            int pop = myStack.pop();
            
            if(pop>max){                           	 		//if an element is bigger than the biggest, update max
                max=pop;
            }
        }
        System.out.println(max);                    		//print out max
    }
}
}



class Stack{                                       	 //Stack class
    private int maxSize;
    private int [] myArray;
    private int top;
    private int nItems;
    
    public Stack(int size){
        maxSize=size;
        myArray = new int [maxSize];
        top = -1;
        nItems=0;
    }
    
    public void push(int item){
        top++;
        myArray[top]=item;
        nItems++;
    }
    
    public int pop(){
        nItems--;
        return myArray[top--];
    }
    
    public int peek(){
        return myArray[top];
    }
    
    public boolean isEmpty(){
        return (nItems==0);
    }
    
    public boolean isFull(){
        return (nItems==maxSize);
    }
}
