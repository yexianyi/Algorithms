package com.yxy.algorithms.array.single.num;

import java.util.Arrays;

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
