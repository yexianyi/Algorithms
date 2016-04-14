package com.yxy.algorithms.array.max.subarray;

/**
 * 53. Maximum Subarray My Submissions QuestionEditorial Solution
	Total Accepted: 107254 Total Submissions: 293959 Difficulty: Medium
	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	
	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
	
	click to show more practice.
	
	More practice:
	If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * @author xianyiye
 * @date 04/14/2016
 * Copy from:
 * http://blog.csdn.net/linhuanmars/article/details/21314059
 */

public class Solution2 {
	
	//DP
	public static int maxSubArray(int[] nums) {
		int local = nums[0] ;
		int global = nums[0] ;
		
		for(int i=1; i<nums.length; i++){
			//local[i+1] = Max(nums[i+1], local[i]+nums[i+1])
			local = Math.max(nums[i], local+nums[i]) ;
			//global[i+1] = Max(local[i], local[i+1])
			global = Math.max(global, local) ;
			
		}
		
        return global ;
    }
	

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

	}

}
