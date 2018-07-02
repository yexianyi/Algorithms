package com.yxy.algorithms.array.longest.increasing.subsequence;

/**
 * 300. Longest Increasing Subsequence   My Submissions QuestionEditorial Solution
	Total Accepted: 26531 Total Submissions: 77383 Difficulty: Medium
	Given an unsorted array of integers, find the length of longest increasing subsequence.
	
	For example,
	Given [10, 9, 2, 5, 3, 7, 101, 18],
	The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
	
	Your algorithm should run in O(n2) complexity.
	
	Follow up: Could you improve it to O(n log n) time complexity?
	
 * @update 07/01/2018
 */
public class Solution {
	
	public int lengthOfLIS(int[] nums) {
        return travel(nums, Integer.MIN_VALUE, 0);
    }

    public int travel(int[] nums, int prev, int curr) {
        if (curr == nums.length) {
            return 0;
        }
        
        int taken = 0;
        if (nums[curr] > prev) {
            taken = 1 + travel(nums, nums[curr], curr + 1);
        }
        
        int nottaken = travel(nums, prev, curr + 1);
        
        return Math.max(taken, nottaken);
    }
	
	

	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,4}));
		System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));

	}

}
