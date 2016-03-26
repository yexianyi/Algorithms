package com.yxy.algorithms.array.missing.num;

/**
 * 268. Missing Number My Submissions Question
Total Accepted: 44505 Total Submissions: 112158 Difficulty: Medium
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * 
 * @author xianyiye
 * @Date 3/26/2016
 */

public class Solution2 {
	
	public static int missingNumber(int[] nums) {
		
		int n = nums.length ;
		int sn = (0+n)*(n+1)/2 ;
		
		for(int i=0; i<nums.length ; i++){
			sn -= nums[i] ;
		}
		
		return sn;
	        
	}

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{0,1,3}));
	}

}
