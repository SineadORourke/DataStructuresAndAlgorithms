/*Hackerrank Lab 7.2
Question: Manipulate a queue according to the given insert and remove commands and then
output the string that is in the middle of the queue. If there is an even number of strings
in the queue, thus two middle strings, output the one which is nearest the front. If a remove
command is issued for an empty queue then nothing should happen*/

import java.util.*;
public class Solution {
	public static void main(String args[] ) throws Exception {
		Scanner myScanner = new Scanner(System.in);
        Q myQ = new Q(20);                          //Create new instance of Q
        while(myScanner.hasNextLine()){             //Loop until no more commands
            String command = myScanner.nextLine();  //take in the command
            if(command.equals("REMOVE")){           //if command is REMOVE, remove from Q
                String removed = myQ.remove();
            }else{                                 	//otherwise INSERT command
                myQ.insert(command.substring(7, command.length()));
            }
        }
        int numElems = myQ.getSize();               	//get the num of elements in queue
        if(numElems==0){                            	//if it is empty, print empty
            System.out.println("empty");
        }else{                                    		//otherwise copy the queue into new array
            String []myArray = new String[numElems];
            int counter=0;
            while(!myQ.isEmpty()){
                myArray[counter]=myQ.remove();
                counter++;
            }
            if(numElems%2==0){                     		 //if there are two midpoints print the first one
                System.out.println(myArray[(numElems/2)-1]);
            }else{                                  	//otherwise, just print the single midpoint
                System.out.println(myArray[numElems/2]);
            }
        }
    }
}

class Q{                                     //Q class
   private int maxSize;
    private String[] queArray;
    private int front;
    private int  rear;
    private int nItems;
    
    public Q(int size){						//constructor
        maxSize=size;
        queArray = new String[maxSize];
        front=0;
        rear=-1;
        nItems=0;
    }
    
    public boolean insert(String item){		//insert at the rear
        if(isFull()){
            return false;
        }else{
            if(rear==maxSize-1){
                rear=-1;
            }
            rear++;
            queArray[rear]=item;
            nItems++;
            return true;
        }
    }
    
    public String remove(){			//remove from the front
        if(isEmpty()){
            return null;
        }else{
            String temp=queArray[front];
            front++;
            if(front==maxSize){
                front=0;
            }
            nItems--;
            return temp;
        }
    }
    
    public boolean isEmpty(){			//returns true if empty
        return(nItems==0);
    }
    
    public boolean isFull(){			//return true if full
        return(nItems==maxSize);
    }
    
    public String peek(){				//shows the front element
        return queArray[front];
    }
    
    public int getSize(){				//returns the queue size
        return nItems;
    }
}
