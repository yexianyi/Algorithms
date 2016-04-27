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
 * Reference:
 * https://leetcode.com/discuss/85963/extentions-more-clear-explanation-than-previous-posts
 */

public class Solution2 {
	
	//1-pass
	public static void sortColors(int[] nums) {
		int p0 = 0 ; //the latest pointer marks [n]==0 ;
		int p1 = 0; //the latest pointer marks [n]==1 ;
		int p2 = nums.length-1 ; //the latest pointer marks [n]==2 ;

		while(p1<=p2){
			if(nums[p1]==0){
				//swap [p1] and [p0]
				int temp = nums[p1] ;
				nums[p1] = nums[p0] ;
				nums[p0] = temp ;
				p0++ ;
				p1++ ;
			}else if(nums[p1]==2){
				//swap [p1] and [p2]
				int temp = nums[p1] ;
				nums[p1] = nums[p2] ;
				nums[p2] = temp ;
				p2-- ;
			}else{
				p1++ ;
			}
			
		}
	}

	public static void main(String[] args) {
		int[] nums = {0,2,1} ;
		sortColors(nums) ;
		
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
		}
		
//		int[] nums = {1,2} ;
//		nums[0] = nums[0] ^ nums[1] ;
//		nums[1] = nums[1] ^ nums[0] ;
//		nums[0] = nums[0] ^ nums[1] ;
//		
//		System.out.print(nums[0]+" "+nums[1]);
		
	}

}
