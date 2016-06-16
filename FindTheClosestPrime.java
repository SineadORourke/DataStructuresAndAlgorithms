/**Hackerrank - Lab 4
Question: The goal is to read in a number and to output the nearest prime. 
If two primes are equidistant then output the lower one.

*/
import java.util.*;
public class CS210Lab4ClosestPrime
{
	public static void main (String []args)
	{
		Scanner myScanner = new Scanner(System.in);			//Scanner
		int val = myScanner.nextInt();						//Take in user input
		boolean []primeArray = new boolean [val*2];			//Make array with siza of input x2
															//^^incase the closest prime is larger
		for(int i=0; i<primeArray.length; i++)				//Sieve
		{ 
			primeArray[i]=true;
		}
		
		for(int i=2; i<primeArray.length; i++)
		{
			if(primeArray[i]==true)
			{
				for(int j=i+1; j<primeArray.length; j++)
				{
					if(j%i==0)
					{
						primeArray[j]=false;
					}
					
				}
			}
		}
		
		
		int [] primeNums = new int[val*2];					//New array to hold prime numbers
		int j=0;
		for(int i=2; i<primeArray.length; i++)
		{
			if(primeArray[i]==true)
			{
				primeNums[j]=i;
				j++;
			}
			
		}
		
		int minDiff=Math.abs(primeNums[0]-val);				//find closest number to val from the new array
		int minNum=primeNums[0];
		for(int i=0; i<primeNums.length; i++)
		{
			int Diff=Math.abs(primeNums[i]-val);
			if(Diff<minDiff)
			{
				minDiff=Diff;
				minNum=primeNums[i];
			}
		}
		System.out.println(minNum);	
		
		
	}
}