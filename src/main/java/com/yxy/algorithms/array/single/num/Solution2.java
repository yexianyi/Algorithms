package com.yxy.algorithms.array.single.num;

import java.util.Arrays;

/**
 * 	136. Single Number My Submissions Question
	Total Accepted: 109612 Total Submissions: 227843 Difficulty: Medium
	Given an array of integers, every element appears twice except for one. Find that single one.
	
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author xianyiye
 * 2016/1/22
 */

public class Solution2 {
	
	public static int singleNumber(int[] nums) {
		Arrays.sort(nums) ;
		int i=0 ;
		for(; i<nums.length; i+=2){
			if(i==nums.length-1){
				return nums[i] ;
			}
			else if(nums[i]!=nums[i+1]){
				return nums[i] ;
			}
		}
        
		return -1 ;
    }

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,2}));
		System.out.println(singleNumber(new int[]{1,3,4,5,3,5,1}));
		System.out.println(singleNumber(new int[]{1,3,4,5,3,5,1,4}));

	}

}
