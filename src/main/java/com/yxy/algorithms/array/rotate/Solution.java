package com.yxy.algorithms.array.rotate;

/**
 * 	189. Rotate Array My Submissions Question
	Total Accepted: 57478 Total Submissions: 286689 Difficulty: Easy
	Rotate an array of n elements to the right by k steps.
	
	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	
	Note:
	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
	
	[show hint]
	
	Hint:
	Could you do it in-place with O(1) extra space?
	Related problem: Reverse Words in a String II


 * @author xianyiye
 * 2016/1/19
 */

public class Solution {
	
	public static void rotate(int[] nums, int k) {
        for(int i=k; i>=0; i--){
        	for(int j=0; j<nums.length-k-1; j++){
        		nums[i+j] = nums[i+j] ^ nums[i+j+1] ;
        		nums[i+j+1] = nums[i+j+1] ^ nums[i+j] ;
        		nums[i+j] = nums[i+j] ^ nums[i+j+1] ;
        	}
        }
    }

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7} ;
		rotate(nums, 3) ;
		
		for(int num : nums){
			System.out.print(num+" ");
		}
		
	}

}
