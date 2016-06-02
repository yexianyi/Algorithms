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
 * https://leetcode.com/discuss/36544/simple-ac-solution-in-java-in-o-n-with-explanation
 */
public class Solution2 {

	 public int rob(int[] nums) {
	        if (nums.length == 0) return 0;
	        if (nums.length == 1) return nums[0];
	        if (nums.length == 2) return Math.max(nums[0], nums[1]);
	        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
	        return Math.max(rob1(Arrays.copyOfRange(nums, 1, nums.length)), nums[0] + rob1(Arrays.copyOfRange(nums, 2, nums.length-1)));
	    }

	    public int rob1(int[] nums) {
	        int preno = 0;
	        int preyes = nums[0];
	        for (int i = 1; i < nums.length; i++)
	        {
	            int tmp = preyes;
	            preyes = preno + nums[i];
	            preno = Math.max(preno, tmp);
	        }
	        return Math.max(preyes, preno);
	    }

}
