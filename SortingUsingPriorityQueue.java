/*Hackerrank Sample 6
Question: Use a priority queue to sort a list of numbers. Insert all the numbers into the
prioirty queue and then remove them all. Smaller numbers should have highest priority so they come
out first. You need to write the priority queue class yourself.
*/

import java.util.Scanner;
public class Solution{
	public static void main (String []args) throws Exceptions{
		Scanner myScanner = new Scanner(System.in);	
      	Queue myQueue = new Queue(100);	
        while(myScanner.hasNextInt()){			//loop while there is still an int in input
            myQueue.insert(myScanner.nextInt());		//insert input in the priority queue
       	}
        while(!myQueue.isEmpty()){			//loop while the queue is not empty
            System.out.println(myQueue.remove());	//remove the elements from queue + print
        }
    }
}

	
class Queue{				//Queue class
    private int maxSize;
    private int[] queArray;
    private int front;
    private int nItems;
    
    public Queue(int i){			//Constructor
        maxSize = i;
        queArray = new int[maxSize];
        nItems=0;
        front = 0;
    }
    
   public void insert(int item){	//Insert method (inserts elements in order of priority aka smallest first)
        if(nItems==0){			//if the queue is empty
            queArray[0] = item;		//just start at the first place
        }else{
            int j = nItems;
            while (j>0 && queArray[j-1]>item){	//loop to find its spot
                queArray[j] = queArray[j-1];		//copy the elements to the right
                j--;
            }
            queArray[j] = item;		//place new element into its place
        }
        nItems++;
        }
    
    public int remove(){	//Remove method, takes element from the front of the queue
        if(nItems==0){			//if there are no element, return zero
            return 0;
        }
        else{
            int temp = queArray[front];
            front++;
            if(front==maxSize){
               front =0; 
                }
            nItems--;
            return temp;
        }
    }
    
    public boolean isEmpty(){		//isEmpty method checks if there are items in the queue
        return(nItems==0);
    }
 }
