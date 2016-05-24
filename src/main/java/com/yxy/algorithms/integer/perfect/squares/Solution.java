package com.yxy.algorithms.integer.perfect.squares;
/**
 * 279. Perfect Squares My Submissions QuestionEditorial Solution
	Total Accepted: 35296 Total Submissions: 107196 Difficulty: Medium
	Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	
	For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 * @author xianyiye
 * @date 05/24/2016
 * Copy from:
 * https://leetcode.com/discuss/62526/an-easy-understanding-dp-solution-in-java
 */
public class Solution {
	
	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
	    for(int i = 1; i <= n; ++i) {
	        int min = Integer.MAX_VALUE;
	        int j = 1;
	        while(i - j*j >= 0) {
	            min = Math.min(min, dp[i - j*j] + 1);
	            ++j;
	        }
	        dp[i] = min;
	    }       
	    return dp[n];
    }

	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}

}
