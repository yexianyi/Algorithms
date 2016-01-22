package com.yxy.algorithms.array.single.num;

/**
 * 	136. Single Number My Submissions Question
	Total Accepted: 109612 Total Submissions: 227843 Difficulty: Medium
	Given an array of integers, every element appears twice except for one. Find that single one.
	
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author xianyiye
 * 2016/1/22
 */

public class Solution3 {
	
	public static int singleNumber(int[] nums) {
		int sum = 0;
		for(int i=0 ; i<nums.length; i++){
			if(((i+1)&1)==1) {//odd
				sum = sum + nums[i] ;
			}else{
				sum = sum - nums[i] ;
			}
		}
        
		return sum ;
    }

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,2}));
		System.out.println(singleNumber(new int[]{1,3,4,5,3,5,1}));
		System.out.println(singleNumber(new int[]{1,3,4,5,3,5,1,4}));

	}

}
