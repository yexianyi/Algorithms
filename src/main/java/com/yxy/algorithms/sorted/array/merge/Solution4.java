package com.yxy.algorithms.sorted.array.merge;

/**
 * 	88. Merge Sorted Array My Submissions Question
	Total Accepted: 81040 Total Submissions: 274699 Difficulty: Easy
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	
	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * @author xianyiye
 * 2015/12/31
 */

public class Solution4 {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1, j = n-1, k = m+n-1;
	    while (i>=0 && j>=0) {
	         nums1[k--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
	    }
	    while (i==-1 && j>=0) 
	        nums1[j] = nums2[j--];

    }

	public static void main(String[] args) {
		int[] nums1 = {1,3,5,7,9,0,0,0,0,0,0,0,0,0} ;
		int[] nums2 = {2,3,4,6,8,10,12,14,16} ;
		merge(nums1, 5,nums2, 9) ;
		
		for(int num : nums1){
			System.out.print(num+" ") ;
		}
	}

}
