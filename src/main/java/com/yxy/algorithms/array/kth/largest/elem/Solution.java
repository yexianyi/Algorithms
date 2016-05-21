package com.yxy.algorithms.array.kth.largest.elem;
/**
 * 
	215. Kth Largest Element in an Array
	    My Submissions 
	Question Editorial Solution  
	
	Total Accepted: 56474 Total Submissions: 168404 Difficulty: Medium 
	
	
	
	
	Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element. 
	
	For example,
	 Given [3,2,1,5,6,4] and k = 2, return 5. 
	
	Note: 
	 You may assume k is always valid, 1 ≤ k ≤ array's length.

 * @author Xianyi Ye
 * @date 05/21/2016
 */
public class Solution {

	public static int findKthLargest(int[] nums, int k) {
		quicksort(nums,0,nums.length-1) ;
		
		return nums[k-1] ;
    }
	
	private static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }
 
	private static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] <= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] >= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{2,1},1));

	}
}
