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

public class Solution {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
       int[] sortedArray = new int[m+n] ;
       int p1 = 0 ;
       int p2 = 0 ;
       int i=0; 

       while(p1<m && p2<n){
    	   if(nums1[p1]<=nums2[p2]){
    		   sortedArray[i++] = nums1[p1++] ;
    	   }else{
    		   sortedArray[i++] = nums2[p2++] ;
    	   }
       }
       
       while(p1<m){
    	   sortedArray[i++] = nums1[p1++] ;
       }
       
       while(p2<n){
    	   sortedArray[i++] = nums2[p2++] ;
       }
       
       for(i=0 ; i<m+n; i++){
    	   nums1[i] = sortedArray[i] ;
       }
       
    }

	public static void main(String[] args) {
		int[] nums1 = {1,3,5,7,9,0,0,0,0,0,0,0,0} ;
		int[] nums2 = {2,3,4,6,8,10,12,14,16} ;
		merge(nums1, 5,nums2, 8) ;
		
		for(int num : nums1){
			System.out.print(num+" ") ;
		}
	}

}
