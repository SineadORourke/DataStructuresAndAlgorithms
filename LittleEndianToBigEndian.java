/*
Hackerrank Lab 11.2
Question: The goal is to convert a 32-bit integer from Little Endian (Java, iPhone, Xbox) to Big Endian (Intel, TCP, IPv6)
encoding. This is a very common task in software engineering. In Little Endian encoding the first byte contains the most significant
bits, and bytes 2, 3, and 4 decrease in significance. In Big Endiann encoding the first byte contains the least significant bits, and bytes
2, 3 and 4 increase in significance. Thus, to move from Little Endian to Big Endian the byte shuffling is as follows:
Byte 1 -> Byte 4
Byte 2 -> Byte 3
Byte 3 -> Byte 2
Byte 4 -> Byte 1

Take in an integer encoded in Little Endian and shuffle its bytes using bit manipulation operators to put it into Big Endian
*/

import java.util.*;
public class Solution {
	public static void main(String args[] ) throws Exception {
		Scanner myScanner = new Scanner(System.in);
		int num = myScanner.nextInt();
    
		int byte1 = num<<24;
		int byte2 = ((num>>8)<<24)>>>8;
		int byte3 = ((num>>16)<<24)>>>16;
		int byte4 = num>>>24;
		System.out.println(byte1|byte2|byte3|byte4);
	}
}