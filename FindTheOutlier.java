/*Hackerrank - Lab 2
Ques: The goal is to read in 3 numbers and output the one which is most different from the other two (i.e. the one
with the greatest difference from the nearest number to it). If there is no single outlier then output "NA"
*/



import java.util.*;
public class CS210Lab2Outlier
{
	public static void main (String []args)
	{
		Scanner myScanner = new Scanner(System.in);			//Scanner
		int num1 = myScanner.nextInt();						//Take in 3 inputs
		int num2 = myScanner.nextInt();
		int num3 = myScanner.nextInt();
		
		int avg = (num1+num2+num3)/3;						//Find average
		
		int num1Diff = Math.abs(num1-avg);					//Find difference between value
		int num2Diff = Math.abs(num2-avg);					//^^ and avg for each input
		int num3Diff = Math.abs(num3-avg);
		
		if(num1Diff>num2Diff && num1Diff>num3Diff)			//If the first value has the biggest difference
		{
			System.out.println(num1);						//Print it out - it is the outlier
		}
		else if(num2Diff>num1Diff && num2Diff>num3Diff)
		{
			System.out.println(num2);
		}
		else if(num3Diff>num1Diff && num3Diff>num2Diff)
		{
			System.out.println(num3);
		}
		else												//If they are all equidistant from the avg
		{
			System.out.println("NA");						//Print "NA"
		}
	}
}