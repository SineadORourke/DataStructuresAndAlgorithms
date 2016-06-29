/*
Hackerrank Lab 8.2
Question: A loop in a linked list occurs when following the linked list chain brings you back where you started.
Output the size of the loop, or 0 if there is no loop. 
*/

import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
		Scanner myscanner = new Scanner(System.in);
		int num = Integer.parseInt(myscanner.nextLine());
		Link [] array = new Link[num];
		for(int i=0; i<num; i++){
			array[i]=new Link(myscanner.nextLine());
		}
		while(myscanner.hasNext()){
			int select=myscanner.nextInt();
			int next=myscanner.nextint();
			if(next!=-1){
				array[select].next = array[next];
			}
		}
		LinkedList mylist = new LinkedList();
		if(num>0){
			mylist.first=array[0];
		}
		System.out.println(findloop(mylist));
	}
	
	
	public static int findLoopLength(LinkedList mylist){
        if(mylist.isEmpty()){                   //return 0 if the Linked list is empty
            return 0;
        }
        
        Link[] myArray = new Link[100];         //create a seperate Link array
        int counter=0;                         	//create counter to keep track of Link array
        Link forward = mylist.first;            //create reference to the first Link
        
        while(forward.next!=null){              //loop until forward reaches the end
            myArray[counter]=forward;           //copy the element into the Link array
            
            for(int i=0; i<counter; i++){       //loop (from the start of the array)
                if(forward==myArray[i]){        //to see if this current element has already occurred
         return(counter-i);            	  		//if so, return the total num of elements-the start elements that arent in the loop
                }
            }
            forward=forward.next;              	//if no loop is found yet, move forward in the Linked list
            counter++;                         	//update the counter
        }
        return 0;                              	//if no loop found at all, return 0
    }

}


class Link{
	public String data;
	public Link next;
	
	public Link(String input){
		data=input;
		next-null;
	}
}

class LinkedList{
	public Link first;
	
	public LinkedList(){
		first=null;
	}
	
	public boolean isEmpty(){
		returnn(first==null);
	}
	
	public void insertHead(Link insert){
		if(isEmpty()){
			first=insert;
		}else{
			insert.next=first;
			first=insert;
		}
	}
}
