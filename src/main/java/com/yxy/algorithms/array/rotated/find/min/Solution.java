package com.yxy.algorithms.array.rotated.find.min;
/**
 * 153. Find Minimum in Rotated Sorted Array   My Submissions QuestionEditorial Solution
	Total Accepted: 88402 Total Submissions: 244822 Difficulty: Medium
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	Find the minimum element.
	
	You may assume no duplicate exists in the array.


 * @author xianyiye
 * @Date 04/18/2016
 * 
 */
public class Solution {
	
	//O(n)
	public static int findMin(int[] nums) {
        int i=0;
        int j = nums.length-1 ;
        
        while(i+1<nums.length && j-1>=0){
        	if(nums[i]<nums[i+1]){
        		i++ ;
        	}else{
        		return nums[i+1] ;
        	}
        	
        	if(nums[j]>nums[j-1]){
        		j-- ;
        	}else{
        		return nums[j] ;
        	}
        }
		
		return nums[0] ;
    }

	public static void main(String[] args) {
		System.out.println(findMin(new int[]{1}));
		System.out.println(findMin(new int[]{1,2,3,4,5,6,7,0}));
		System.out.println(findMin(new int[]{4,5,6,7,0,1,2,3}));
	}

}
