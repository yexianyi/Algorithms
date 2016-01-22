package com.yxy.algorithms.array.single.num;

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
