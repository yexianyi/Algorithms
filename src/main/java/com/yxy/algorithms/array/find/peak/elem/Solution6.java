package com.yxy.algorithms.array.find.peak.elem;

/**
 * 162. Find Peak Element My Submissions QuestionEditorial Solution Total
 * Accepted: 66136 Total Submissions: 200452 Difficulty: Medium A peak element
 * is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * click to show spoilers.
 * 
 * Note: Your solution should be in logarithmic complexity.
 * 
 * 
 * @author xianyiye
 * @date 05/23/2016 
 * Copy from:
 * https://leetcode.com/problems/find-peak-element/
 */
public class Solution6 {
	public int findPeakElement(int[] nums) {
		int N = nums.length;
		if (N == 1) {
			return 0;
		}

		int left = 0, right = N - 1;
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
	}

}