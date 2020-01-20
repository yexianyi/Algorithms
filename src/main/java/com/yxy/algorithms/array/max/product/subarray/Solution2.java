package com.yxy.algorithms.array.max.product.subarray;

/**
 * 152. Maximum Product Subarray
	Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
	
	Example 1:
	
	Input: [2,3,-2,4]
	Output: 6
	Explanation: [2,3] has the largest product 6.
	Example 2:
	
	Input: [-2,0,-1]
	Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * @author Ye Xianyi
 * 2020/01/20
 * Copy from:
 * https://leetcode.com/problems/maximum-product-subarray/discuss/484927/My-java-O(n)-solution.
 */
public class Solution2 {

	public static int maxProduct(int[] nums) {
		if (nums.length < 1)
			return 0;
		int res = nums[0];
		int max = res, min = res;
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
			min = Math.min(temp * nums[i], Math.min(min * nums[i], nums[i]));
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 0, 1, -2 })); // 1
		System.out.println(maxProduct(new int[] { -2, 3, -4 })); // 24
		System.out.println(maxProduct(new int[] { 0, 2 })); // 2
		System.out.println(maxProduct(new int[] { 2 })); // 2
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 })); // 6
		System.out.println(maxProduct(new int[] { -2, 0, -1 })); // 0
		System.out.println(maxProduct(new int[] { 1, 2, 4, -1, 3, 2 })); // 8
	}

}
