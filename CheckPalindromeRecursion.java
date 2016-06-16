/*Hackerrank Lab 9.2i
Question: Write a recursive method that takes in a String and outputs "TRUE" if it
is a palindrome and "FALSE" if it is not.
*/

import java.util.Scanner;
public class Solution{
	public static void main(String args[]){
		Scanner myscanner = new Scanner(System.in);
		String mystring = myscanner.nextLine();
		System.out.println(check(mystring));
		
		public static String check(String mystring){
			String substring="";        
			if(mystring.length()<=1){           //base case
				return "TRUE";
			}else{
				if(mystring.charAt(0)==mystring.charAt(mystring.length()-1)){   //if the start + end chars are the same
					substring = mystring.substring(1, mystring.length()-1);     //remove them
				}else{                                                          //otherwise, it is not a palindrome
					return "FALSE";
				}
			}
			return (check(substring));
		}
	}
}