package com.yxy.algorithms.array.shortest.unsorted.continuous.subarray;
/**
 * 
581. Shortest Unsorted Continuous Subarray

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too. 

You need to find the shortest such subarray and output its length.

Example 1:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.



Note:

1.Then length of the input array is in range [1, 10,000].
2.The input array may contain duplicates, so ascending order here means <=. 

 * @author Ye Xianyi
 * 2019/03/03
 * 
 * Copy from:
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/
 * 
 * Reference:
 * https://blog.csdn.net/qq_36214481/article/details/85244953
 *
 */
public class Solution {

	public static int findUnsortedSubarray(int[] nums) {
		// find min and max value in unsorted array,
		// moreover, the boundary of the unsorted array must include the 1st descending
		// order index and the last descending order index
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1])
				flag = true;
			if (flag)
				min = Math.min(min, nums[i]);
		}
		flag = false;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > nums[i + 1])
				flag = true;
			if (flag)
				max = Math.max(max, nums[i]);
		}
		int l, r;
		// scan left to right, find the 1st index which result in nums[index] > min
		for (l = 0; l < nums.length; l++) {
			if (min < nums[l])
				break;
		}

		// scan right to left, find the 1st index which result in nums[index] < max
		for (r = nums.length - 1; r >= 0; r--) {
			if (max > nums[r])
				break;
		}
		return r - l < 0 ? 0 : r - l + 1;
	}

	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 })); // 5
		System.out.println(findUnsortedSubarray(new int[] { 2, 3, 3, 2, 4 })); // 3
		System.out.println(findUnsortedSubarray(new int[] { 1, 3, 2, 3, 3 })); // 2
		System.out.println(findUnsortedSubarray(new int[] { 1, 3, 2, 4, 5 })); // 2
		System.out.println(findUnsortedSubarray(new int[] { 1, 3, 2, 2, 2 })); // 4
		System.out.println(findUnsortedSubarray(new int[] { 1, 2, 3, 3, 3, 3, 3 })); // 0
		System.out.println(findUnsortedSubarray(new int[] { 1, 2, 3, 4 })); // 0

	}

}
