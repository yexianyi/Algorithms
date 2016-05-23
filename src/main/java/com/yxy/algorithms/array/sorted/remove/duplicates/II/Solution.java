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
 * Copy from:
 * https://leetcode.com/discuss/42348/3-6-easy-lines-c-java-python-ruby
 */
public class Solution {
	
	public static int removeDuplicates(int[] nums) {
		 int i = 0;
		    for (int n : nums)
		        if (i < 2 || n > nums[i-2])
		            nums[i++] = n;
		    return i;
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
