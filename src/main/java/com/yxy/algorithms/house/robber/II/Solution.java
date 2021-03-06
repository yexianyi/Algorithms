package com.yxy.algorithms.house.robber.II;
/**
 * 213. House Robber II My Submissions QuestionEditorial Solution
	Total Accepted: 29759 Total Submissions: 95933 Difficulty: Medium
	Note: This is an extension of House Robber.
	
	After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
	
	Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 * @author xianyiye
 * @date 06/02/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/36544/simple-ac-solution-in-java-in-o-n-with-explanation
 */
public class Solution {

	public int rob(int[] nums) {
		if (nums.length == 1){
			return nums[0];
		}
		
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] num, int lo, int hi) {
		int include = 0, exclude = 0;
		for (int j = lo; j <= hi; j++) {
			int i = include, e = exclude;
			include = e + num[j];
			exclude = Math.max(e, i);
		}
		return Math.max(include, exclude);
	}

	public static void main(String[] args) {
		// System.out.println(new Solution().rob(new int[]{1,1,1}));
//		System.out.println(new Solution().rob(new int[] { 0, 1, 2, 3, 4, 5, 6 }));
		 System.out.println(new Solution().rob(new int[] { 1, 2, 3, 4, 5, 1,
		 2, 3, 4, 5 }));
	}

}
