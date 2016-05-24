package com.yxy.algorithms.array.sorted.remove.duplicates.II;
/**
 * 
	80. Remove Duplicates from Sorted Array II
	    My Submissions 
	Question Editorial Solution  
	
	Total Accepted: 75517 Total Submissions: 229577 Difficulty: Medium 
	
	Follow up for "Remove Duplicates":
	 What if duplicates are allowed at most twice?
	
	For example,
	 Given sorted array nums = [1,1,1,2,2,3], 
	
	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length. 


 * @author xianyiye
 * @date 05/23/2016
 * Reference from:
 * https://leetcode.com/discuss/102160/java-solution-1-ms
 */
public class Solution2 {
	
	public static int removeDuplicates(int[] nums) {
		if(nums.length<3){
			return nums.length ;
		}
		
		int p1 = 1 ; 
		
		for(int p2 = p1+1; p2<nums.length; p2++){
			if(nums[p2]==nums[p1-1]){
				continue ;
			}else{
				nums[++p1] = nums[p2] ;
			}
		}
		
		return p1+1 ;
    }

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,2,2,3,3,3} ;
//		int[] nums = {1,1,1} ;
		int ret = removeDuplicates(nums) ;
		System.out.println(ret) ;
		for(int num : nums){
			System.out.print(num+" ") ;
		}
	}

}
