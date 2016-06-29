/*
Hackerrank Lab 7
Question: Manipulate a queue according to the given insert and remove commands and then output the string
that is at the front of the queue. If a remove command is issued  for a en empty  queue then nothing should happen
*/

import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
		Scanner myScanner = new Scanner(System.in);
        Queue myQueue = new Queue(20);				//create new Queue 
        while(myScanner.hasNext())					//loop while there is input
            {
                String input = myScanner.nextLine();			//take in command
                String [] myArray = input.split(" ");			//split words in line into array
                String result ="";
            
                String array = (myArray[0].toString()).toUpperCase();	//make sure all uppercase
                if(array.compareTo("REMOVE")==0){						//if command is Remove
                    if(myQueue.isEmpty()){								//check if empty
                        int k=0;										//do nothing
                    }
                    else{												//otherwise remove from queue
                        myQueue.remove();
                    }
                }
                else {													//otherwise command is Insert
                   for(int i=1; i<myArray.length; i++){					//loop incase input is 2 words
                       result = result + myArray[i] + " ";				//get input part of Insert command
                       }
                   myQueue.insert(result);								//Insert the input String
                } 
                
            }

		//display output
        if(myQueue.isEmpty())								//if queue is empty print “empty”
            {
                String emptyQ = "empty";
                System.out.print(emptyQ);
            }
        else{												//otherwise
                String front = myQueue.remove();			//remove the front of the Queue
                System.out.print(front);					//print out front of queue
        }  
	}
}


class Queue{
	private int maxSize;
	private String[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s){
		maxSize = s;
		queArray = new String[maxSize];
		front=0;
		rear=-1;
		nItems=0;
	}
	
	public boolean insert(String item){
		if(!isFull()){
			rear++;
			queArray[rear]=item;
			nItems++;
			return true;
		}else{
			return false;
		}
	}
	
	public String remove(){
		String temp = queArray[front];
		front++;
		if(front==maxSize)
			front=0;
		nItems--;
		return temp;
	}
	
	public boolean isEmpty(){
		return (nItems==maxSize);
	}
	
	public boolean isFull(){
		return (nItems==maxSize);
	}
	
	public int size(){
		return nItems;
	}
}
