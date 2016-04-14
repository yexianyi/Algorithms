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
 */

public class Solution {
	
	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE ;
		
		for(int i=0; i<nums.length; i++){
			int sum = 0 ;
			for(int j=i; j<nums.length; j++){
				sum += nums[j] ;
				if(sum>max){
					max = sum ;
				}
			}
		}
		
        return max ;
    }

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

	}

}
