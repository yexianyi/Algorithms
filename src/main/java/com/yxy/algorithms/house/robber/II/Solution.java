package com.yxy.algorithms.house.robber.II;

public class Solution {

	public int rob(int[] nums) {
		if (nums.length == 1){
			return nums[0];
		}
		
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] num, int lo, int hi) {
		int include = 0, exclude = 0;
		for (int j = lo; j <= hi; j++) {
			int i = include, e = exclude;
			include = e + num[j];
			exclude = Math.max(e, i);
		}
		return Math.max(include, exclude);
	}

	public static void main(String[] args) {
		// System.out.println(new Solution().rob(new int[]{1,1,1}));
//		System.out.println(new Solution().rob(new int[] { 0, 1, 2, 3, 4, 5, 6 }));
		 System.out.println(new Solution().rob(new int[] { 1, 2, 3, 4, 5, 1,
		 2, 3, 4, 5 }));
	}

}
