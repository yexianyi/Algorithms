package com.yxy.algorithms.house.robber;

/**
 * 	198. House Robber My Submissions Question
	Total Accepted: 46542 Total Submissions: 144410 Difficulty: Easy
	You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
	
	Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * @author xianyiye
 * 2015/12/25
 * Reference:
 * http://www.programcreek.com/2014/03/leetcode-house-robber-java/
 */

public class Solution {

	public static int rob(int[] nums) {
		if(nums==null || nums.length==0){
			return 0 ;
		}
		
	    int n = nums.length;
	 
	    int[] dp = new int[n+1];
	    dp[0]=0;
	    dp[1]=nums[0];
	 
	    for (int i=2; i<n+1; i++){
	       dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
	    }
	 
	    return dp[n];
	}

	public static void main(String[] args) {
//		System.out.println(rob(new int[]{1,2,5,4,5}));
		System.out.println(rob(new int[]{1,2}));
		System.out.println(rob(new int[]{2}));
//		System.out.println(rob(new int[]{2,1,1,2}));
		System.out.println(rob(new int[]{4,1,2,7,5,3,1,0,0}));

	}

}
