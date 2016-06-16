/*Hackerrank Sample 3
Question: The goal is to check if a number is prime or not. If it is a prime number
output TRUE, otherwise FALSE
*/

import java.util.*;

public class CS210Sample3Prime {
    public static void main(String args[] ) throws Exception {
       Scanner myScanner = new Scanner(System.in);
       int num = myScanner.nextInt();
       boolean flag = checkPrime(num);
       if(flag==false)
           {
                System.out.println("FALSE");
           }
        else
           {
                System.out.println("TRUE");
           }
    }

    public static boolean checkPrime(int p)
        {
            if(p%2==0)
                {
                    return false;
                }

            for(int i=3; i*i<=p; i++)
                {
                    if(p%i==0)
                        {
                            return false;
                        }
                }

            return true;
       }
}