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
 * Copy from:
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class Solution3 {

	public int findKthLargest(int[] nums, int k) {
	    if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
	    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}    

	public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
	    if (start > end) return Integer.MAX_VALUE;

	    int pivot = nums[end];// Take A[end] as the pivot, 
	    int left = start;
	    for (int i = start; i < end; i++) {
	        if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
	            swap(nums, left++, i);          
	    }
	    swap(nums, left, end);// Finally, swap A[end] with A[left]

	    if (left == k)// Found kth smallest number
	        return nums[left];
	    else if (left < k)// Check right part
	        return findKthLargest(nums, left + 1, end, k);
	    else // Check left part
	        return findKthLargest(nums, start, left - 1, k);
	} 

	void swap(int[] A, int i, int j) {
	    int tmp = A[i];
	    A[i] = A[j];
	    A[j] = tmp;             
	}

	public static void main(String[] args) {
		System.out.println(new Solution3().findKthLargest(new int[]{2,1},1));

	}
}
