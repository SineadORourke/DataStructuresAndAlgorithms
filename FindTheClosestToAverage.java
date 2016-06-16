/*Hackerrank - Sample 2
Question: The goal is to read in a list of integers into an array and output which is closest 
to the average. For example, the average of 4,8,2,3 and 5 is 4.25, and 4 is the closest to this. 
If there are two values equally close then choose the once which was earliest in the list.
*/

import java.util.*;

public class CS210Sample2ClosestNum
{
	public static void main (String[]args)
	{
		Scanner scn = new Scanner(System.in);		//Scanner
		int T = scn.nextInt();						//Take in array length
		int[]myArray = new int[T];					//create array
		int total =0;								//variable to hold sum of all values
		for(int i=0; i<myArray.length; i++)			//fill array with inputs
		{
			int num = scn.nextInt();
			myArray[i]=num;
			total=total+num;						//update total each time
		}

		int av = total/T;							//find average

		int minDiff=Math.abs(myArray[0]-av);		//assume the first diff is the mindiff
		int minNum=myArray[0];						//assume first element is the closest
		for (int i=0; i<myArray.length; i++)		//loop through array
		{
			int Diff=Math.abs(myArray[i]-av);		//calculate diff of each element

			if(Diff<minDiff || Diff==minDiff)		//replace the mindiff with diff if it is smaller
			{
				minDiff=Diff;
				minNum=myArray[i];					//newest closest number
			}
		}
		System.out.println(minNum);					//Print answer




	}
}