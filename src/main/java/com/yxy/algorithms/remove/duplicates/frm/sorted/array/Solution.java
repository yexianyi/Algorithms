package com.yxy.algorithms.remove.duplicates.frm.sorted.array;

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

public class Solution {
	
	public static int removeDuplicates(int[] nums) {
        if(nums==null || nums.length<=1){
        	return nums.length ;
        }
		
        int p1 = 0 ;
        int p2 = nums.length-1 ;
        int curr = 1 ;
        
        while(p1!=p2){
        	if(nums[p1]==nums[curr]){
        		for(int i=curr ; i<p2; i++){
        			nums[i] = nums[i+1] ;
        		}
        		nums[p2] = -1 ;
        		if(p1+1==nums.length){
        			break ;
        		}
        		p2-- ;
        	}else{
        		p1++ ;
        		curr++ ;
        	}
        	
        }
        
        
		return p2+1 ;
    }

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,2,2,3,4,4}));
		System.out.println(removeDuplicates(new int[]{1,1}));
		System.out.println(removeDuplicates(new int[]{2,2,2}));

	}

}
