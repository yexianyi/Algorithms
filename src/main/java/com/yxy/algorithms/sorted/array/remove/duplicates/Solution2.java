package com.yxy.algorithms.sorted.array.remove.duplicates;

/**
 *  Remove Duplicates from Sorted Array My Submissions Question
	Total Accepted: 101087 Total Submissions: 314416 Difficulty: Easy
	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	
	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	For example,
	Given input array nums = [1,1,2],
	
	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * @author xianyiye
 * 2015/12/28
 */

public class Solution2 {
	
	public static int removeDuplicates(int[] nums) {
        if(nums==null || nums.length<=1){
        	return nums.length ;
        }
        
        int i = 1; //iterator thru array
        int j = 0; //current index
        for (; i<nums.length; i++) { 
            if (nums[i] != nums[j]) { //new number
                j++; //move current index
                nums[j] = nums[i]; //fill current index with new number
            } 
        }
        return j+1;
    }

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,2,2,3,4,4}));
		System.out.println(removeDuplicates(new int[]{1,1,1,1}));
		System.out.println(removeDuplicates(new int[]{1,2}));
		System.out.println(removeDuplicates(new int[]{1,1,2,2,2,3}));
		System.out.println(removeDuplicates(new int[]{1,2,3}));
		System.out.println(removeDuplicates(new int[]{1,1,2}));
		System.out.println(removeDuplicates(new int[]{1,2,2}));
		System.out.println(removeDuplicates(new int[]{2,2,2}));

	}

}
