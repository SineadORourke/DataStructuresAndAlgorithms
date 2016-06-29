/*
Hackerrank Lab 6
Question: Manipulate a stack according to the given push and pop commands and then output the number
that is at the top of the stack. If a pop commans is issued for an empty stack then nothing  should happen.
*/

import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
		Scanner myScanner = new Scanner(System.in);
        int T = myScanner.nextInt();
        String blank = myScanner.nextLine();

        Stack myStack = new Stack(T);
        for(int i=1; i<=T; i++)				//loop for amount of command cases
            {
                String myString = myScanner.nextLine();	//take in command
                String wordString ="";
                String numString ="";
                int num =0;
            
                for(int j=0; j<myString.length(); j++)		//loop through chars of command
                    {
                        if(Character.isLetter(myString.charAt(j)))		//put letters in one string
                            {
                                wordString = wordString + myString.charAt(j);
                            }
                
                        else if(Character.isDigit(myString.charAt(j)))	//put numbers in another string
                            {
                                numString = numString + myString.charAt(j);
                                num = Integer.parseInt(numString);
                            }
                        else{						//irrelevant
                                int k=0;
                            }
                    }
                String push = "PUSH";
                String pop = "POP";
                if(wordString.compareTo(push)==0)	//do push command if string is PUSH
                    {
                        myStack.push(num);			//push the number string
                    }
                else if(wordString.compareTo(pop)==0)	//do pop command if string is POP
                    {
                        if(!myStack.isEmpty())			//if stack is empty, do nothing
                        {
                            int popBack =myStack.pop();
                        }   
                    }
                else
                    {
                      int peek = myStack.peek(); 
                    }
            }
       if(myStack.isEmpty())						//at end, if stack is empty, print empty
           {
            System.out.print("empty");
           }
        else{
            int topStack = myStack.peek();			//or, print out the top of the stack
            System.out.print(topStack);
        }
	}
}


//Add Stack Class