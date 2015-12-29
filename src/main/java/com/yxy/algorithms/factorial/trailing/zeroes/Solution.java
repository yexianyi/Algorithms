package com.yxy.algorithms.factorial.trailing.zeroes;

/**
 * 	172. Factorial Trailing Zeroes My Submissions Question
	Total Accepted: 45545 Total Submissions: 147064 Difficulty: Easy
	Given an integer n, return the number of trailing zeroes in n!.
	
	Note: Your solution should be in logarithmic time complexity.
 * @author xianyiye
 * 2015/12/29
 */

public class Solution {
	
	public static int trailingZeroes(int n) {
		int count = 0;
		while(n>0){
			count += n/=5 ;
		}
		
		return count;
        
    }

	public static void main(String[] args) {
		System.out.println(trailingZeroes(0));
		System.out.println(trailingZeroes(1));
		System.out.println(trailingZeroes(2));
		System.out.println(trailingZeroes(3));
		System.out.println(trailingZeroes(14));
		System.out.println(trailingZeroes(24));

	}

}
