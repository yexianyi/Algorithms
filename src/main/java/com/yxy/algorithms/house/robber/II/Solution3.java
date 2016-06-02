package com.yxy.algorithms.house.robber.II;

import java.util.Arrays;
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
 * https://leetcode.com/discuss/57601/good-performance-dp-solution-using-java
 */
public class Solution3 {

	 public int rob(int[] nums) {
		 if (nums.length == 0)
	            return 0;
	        if (nums.length < 2)
	            return nums[0];

	        int[] startFromFirstHouse = new int[nums.length + 1];
	        int[] startFromSecondHouse = new int[nums.length + 1];

	        startFromFirstHouse[0]  = 0;
	        startFromFirstHouse[1]  = nums[0];
	        startFromSecondHouse[0] = 0;
	        startFromSecondHouse[1] = 0;

	        for (int i = 2; i <= nums.length; i++) {
	            startFromFirstHouse[i] = Math.max(startFromFirstHouse[i - 1], startFromFirstHouse[i - 2] + nums[i-1]);
	            startFromSecondHouse[i] = Math.max(startFromSecondHouse[i - 1], startFromSecondHouse[i - 2] + nums[i-1]);
	        }

	        return Math.max(startFromFirstHouse[nums.length - 1], startFromSecondHouse[nums.length]);
	  }

}
