package com.yxy.algorithms.array.sort.color;
/**
 * 75. Sort Colors   My Submissions QuestionEditorial Solution
	Total Accepted: 96628 Total Submissions: 278578 Difficulty: Medium
	Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
	
	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	
	Note:
	You are not suppose to use the library's sort function for this problem.
	
	click to show follow up.
	
	Follow up:
	A rather straight forward solution is a two-pass algorithm using counting sort.
	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
	
	Could you come up with an one-pass algorithm using only constant space?
 * @author xianyiye
 * @date 04/27/2016
 */
public class Solution {
	
	//2-pass
	public static void sortColors(int[] nums) {
		int red = 0 ;
		int white = 0 ;
		int blue = 0 ;
		
		for(int num : nums){
			switch(num){
				case 0 : ++red; break ;
				case 1 : ++white; break ;
				case 2 : ++blue; break ;
			}
		}
		
		int i = 0;
		for(int j=0; j<red; j++,i++){
			nums[i] = 0 ;
		}
		
		for(int j=0; j<white; j++,i++){
			nums[i] = 1 ;
		}
		
		for(int j=0; j<blue; j++,i++){
			nums[i] = 2 ;
		}
        
    }

	public static void main(String[] args) {
		int[] nums = {0,1,2,0,1,2} ;
		sortColors(nums) ;
		
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
		}
		
	}

}
