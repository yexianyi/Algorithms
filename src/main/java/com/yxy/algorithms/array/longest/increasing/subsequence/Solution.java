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
 * @author xianyiye
 * @date 04/29/2016
 */
public class Solution {
	
	private int max = 0 ;
	
	//!timeout
	public int lengthOfLIS(int[] nums) {
        for(int i=0; i<nums.length; i++){
        	travel(0,nums, i, i) ;
        }
		return max ;
    }
	
	private void travel(int currSize, int[] nums, int target, int start) {
		if(start==nums.length){
			max = Math.max(max, currSize) ;
			return ;
		}
		
		for(int i=start; i<nums.length; i++){
			if(nums[i]>=nums[target]){
				currSize++ ;
				travel(currSize, nums, i, i+1) ;
				currSize-- ;
			}
		}
	}
	
	

	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,4}));
		System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

	}

}
