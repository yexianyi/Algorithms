package com.yxy.algorithms.array.min.size.subarray.sum;

/**
 * 209. Minimum Size Subarray Sum
Medium
	Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	
	Example: 
	
	Input: s = 7, nums = [2,3,1,2,4,3]
	Output: 2
	Explanation: the subarray [4,3] has the minimal length under the problem constraint.
	Follow up:
	If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 * @author Ye Xianyi
 * 2020/01/22
 * 
 * Reference:
 * https://leetcode.com/problems/minimum-size-subarray-sum/solution/
 */
public class Solution2 {
	
	// O(n)
	public static int minSubArrayLen(int s, int[] nums) {
		int minLen = Integer.MAX_VALUE ;
		int left = 0 ;
		int sum = 0;
		for(int i=0; i < nums.length ; i++) {
			sum += nums[i] ;
			while(sum >= s) {
				minLen = Math.min(minLen, i - left + 1) ;
				sum -= nums[left++] ;
			}
		}
		
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(11, new int[] {1,2,3,4,5})); // 3
		System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3})); // 2
	}

}
