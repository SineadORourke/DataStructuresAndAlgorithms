/*
Hackerrank Lab 8
Question: A loop in a linked list occurs when following the linked list chain brings you back where you started. 
For example, link 1 points to link 2 which points to link3 which points to link 1, which points to link 2, to link3, to lonk 1 ... and you go round
in an infinite loop. Each test case here involves a single-ended singly-linked list with a potential loop. Output the data of the link whose pointer
has caused the linked list to loop back to a previous point. In the above example, it would be whatever data is stored in link 3.
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
	
	
	public static String findloop(LinkedList mulist){
		if(mylist.isEmpty()){					//if the list is empty, return empty
            return("empty");
        }

        Link[] myArray = new Link[100];			//new link
        Link fwd = mylist.first;				//reference to first link
        
        int i=0;
        while(fwd.next!=null){					//move forward while there is a link
            myArray[i]=fwd;						//populate new Link with old Link
            Link current =fwd;		
            fwd=fwd.next;						//moving up the link
            for(int j=0;j<i;j++){
                if(fwd==myArray[j]){
                    return(current.data);		//return the link that loops
                }
            } 
            i++; 
        }
        return("OK");							//otherwise, return OK if it doesn’t loop
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


























	
	