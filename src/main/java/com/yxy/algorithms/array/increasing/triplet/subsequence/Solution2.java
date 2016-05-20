package com.yxy.algorithms.array.increasing.triplet.subsequence;
/**
 * 334. Increasing Triplet Subsequence My Submissions QuestionEditorial Solution
	Total Accepted: 13747 Total Submissions: 40966 Difficulty: Medium
	Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
	
	Formally the function should:
	Return true if there exists i, j, k 
	such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
	Your algorithm should run in O(n) time complexity and O(1) space complexity.
	
	Examples:
	Given [1, 2, 3, 4, 5],
	return true.
	
	Given [5, 4, 3, 2, 1],
	return false.
 * @author xianyiye
 * @date 05/20/2016
 * Copy from:
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class Solution2 {

	public static boolean increasingTriplet(int[] nums) {
		// start with two largest values, as soon as we find a number bigger
		// than both, while both have been updated, return true.
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} // update small if n is smaller than both
			else if (n <= big) {
				big = n;
			} // update big only if greater than small but smaller than big
			else
				return true; // return if you find a number bigger than both
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
		// System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
		// System.out.println(increasingTriplet(new int[]{5,1,5,5,2,5,4}));
		System.out.println(increasingTriplet(new int[] { 0, 4, 2, 1, 0, -1, -3 }));
	}

}
