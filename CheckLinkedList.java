/*
Hackerrank Sample 7
Question: Check the double-ended doubly-linked list to see if it is properly linked up.
*/

import java.util.*;
public class Solution{
	public static void main(String args[]) throws Exception{
		Scanner myscanner = new Scanner(System.in);
		int num = Integer.parseInt(myscanner.nextLine());
		Link[] array = new Link[num];
		for(int i=0; i<num; i++){
			array[i]=new Link(myscanner.nextLine());
		}
		while(myscanner.hasNext()){
			int select=myscanner.nextInt();
			int previous=myscanner.nextInt();
			int next=myscanner.nextInt();
			if(previous!=-1){
				array[select].previous=array[previous];
			}
			if(next!=-1){
				array[select].next=array[next];
			}
		}
		LinkedList mylist = new LinkedList();
		if(num>0){
			mylist.first=array[0];
			mylist.last=array[num-1];
		}
		System.out.println(check(mylist));
	}
	
	
	public static String check(LinkedList mylist){		//checking if the linked list is linked correctly
        if(mylist.isEmpty()){							//if the linked list is empty, return “empty”
            return "empty";
        }
        int forCount=0;									//initialize forward walk counter
        int backCount=0;								//initialize backwards walk counter
        Link forwards = mylist.first;					//new link “forwards” is set to the first link in our link list
        boolean flag = hasLoop(forwards);				//call method (to see if the link list loops)
        if(flag==true){									//if the link list loops, return “FALSE”
            return "FALSE";
        }else{						
            while(forwards.next!=null){					//otherwise, walk the list forwards
            forwards=forwards.next;
             forCount++;								//count how many links from start to end
            }
        
            Link backwards = mylist.last;				//new link set to the last link in our link list
            while(backwards.previous!=null){			//walk the list backwards
            backwards=backwards.previous;
            backCount++;								//count how many links from end to start
            }
			
  //if the “forwards” link (after the forwards walk) is the same as the last link in our list AND the “backwards” link (after the backwards walk) is the same as the first link in our list AND it took the same amount of steps forwards as it did backwards, return “TRUE”
            if(forwards==mylist.last && backwards==mylist.first &&forCount==backCount){
            return "TRUE";  
            } else{
                return "FALSE";							//otherwise, return “FALSE” because the list isn’t linked correctly
            }
        }
    }

    public static boolean hasLoop(Link first){  		//new method checking for loop in the linked list
        if(first==null){								//if the list if empty, return no loop
            return false;
        }
        Link slow, fast;								//two new links, both equal to the first link
        slow = fast = first;
        while(true){
            slow=slow.next;								//move on space forward
            if(fast.next!=null){
                fast=fast.next.next;					//move fast two steps forward
            }else{
                return false;
            }
            if(slow==null||fast==null){		
                return false;
            }
            if(slow==fast){								//if fast overtakes slow, then there is a loop
                return true;
            }
        }
    }
}


class Link{
	public String data;
	public Link next;
	public Link previous;
	
	public Link(String input){
		data=input;
		next=null;
		previous=null;
	}
}

class LinkedList{
	public Link first;
	public Link last;
	
	public LinkedList{
		first=null;
		last=null;
	}
	
	public boolean isEmpty(){
		return (first==null);
	}
	
	public void insertHead(Link insert){
		if(isEmpty()){
			first=insert;
			last=insert;
		}else{
			first.previous=insert;
			insert.next=first;
			first=insert;
		}
	}
}