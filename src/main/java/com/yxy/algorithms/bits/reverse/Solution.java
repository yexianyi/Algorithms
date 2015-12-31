package com.yxy.algorithms.bits.reverse;

/**
 * 	190. Reverse Bits My Submissions Question
	Total Accepted: 47525 Total Submissions: 162790 Difficulty: Easy
	Reverse bits of a given 32 bits unsigned integer.
	
	For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
	
	Follow up:
	If this function is called many times, how would you optimize it?
	
	Related problem: Reverse Integer
 * @author xianyiye
 * 2015/12/31
 */

public class Solution {
	
	long[] bitMap = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 
					8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 
					2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728,
					268435456, 536870912, 1073741824, 2147483648l} ;
	
	// you need treat n as an unsigned value
	 public static int reverseBits(int n) {
		 int reverseVal = 0, x = Integer.MIN_VALUE;
	        while (x != 0)
	        {
	            reverseVal = (reverseVal<<1)  + (n & 1);
	            n >>>= 1;
	            x >>>= 1;
	        }

	        return reverseVal;
	}
	

	public static void main(String[] args) {
//		System.out.println(reverseBits(Long.valueOf(2863311530l).intValue())) ;
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE)) ;
	}

}
