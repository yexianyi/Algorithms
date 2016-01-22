package com.yxy.algorithms.array.single.num.I;

/**
 * 	136. Single Number My Submissions Question
	Total Accepted: 109612 Total Submissions: 227843 Difficulty: Medium
	Given an array of integers, every element appears twice except for one. Find that single one.
	
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author xianyiye
 * 2016/1/22
 */

public class Solution4 {
	
	public static int singleNumber(int[] nums) {
		int result = 0;
	    for(int i : nums) {
	        result ^= i;
	    }
	    return result;
    }

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,2}));
		System.out.println(singleNumber(new int[]{1,3,4,5,3,5,1}));
		System.out.println(singleNumber(new int[]{1,3,4,5,3,5,1,4}));

	}

}
