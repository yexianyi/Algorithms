package com.yxy.algorithms.array.single.num;

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
