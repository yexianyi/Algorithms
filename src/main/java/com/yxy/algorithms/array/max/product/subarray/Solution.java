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
 *
 */
public class Solution {

	public static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE ;
		for(int low=0; low<nums.length; low++) {
			int temp = 1 ;
			for(int fast=low; fast<nums.length; fast++) {
				temp = temp * nums[fast] ;
				max = Integer.max(max, temp) ;
			}
			
		}
		return max ;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{0,1,-2})) ; // 1
		System.out.println(maxProduct(new int[]{-2,3,-4})) ; // 24
		System.out.println(maxProduct(new int[]{0, 2})) ; // 2
		System.out.println(maxProduct(new int[]{2})) ; // 2
		System.out.println(maxProduct(new int[]{2,3,-2,4})) ; // 6
		System.out.println(maxProduct(new int[]{-2,0,-1})) ; // 0
		System.out.println(maxProduct(new int[]{1,2,4,-1,3,2})) ; // 8
	}

}
