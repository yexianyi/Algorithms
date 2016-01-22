package com.yxy.algorithms.array.single.num.II;

/**
 * 	137. Single Number II My Submissions Question
	Total Accepted: 72923 Total Submissions: 199354 Difficulty: Medium
	Given an array of integers, every element appears three times except for one. Find that single one.
	
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author xianyiye
 * 2016/1/22
 */

public class Solution {

	public static int singleNumber(int[] nums) {
	    int[] digits = new int[32];
	    for(int i=0; i<nums.length; i++){
	        int mask = 1;
	        for(int j=31; j>=0; j--){
	            if((mask & nums[i])!=0)
	                digits[j] ++;
	            mask <<= 1;
	        }
	    }
	    int res = 0;
	    for(int i=0; i<32; i++){
	        if(digits[i]%3>0)
	            res += 1;
	        if(i==31)
	            continue;
	        res <<= 1;
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,1,2}));
		System.out.println(singleNumber(new int[]{1,3,4,1,3,4,5,5,1,3,4}));
		System.out.println(singleNumber(new int[]{1,1,1}));

	}

}
