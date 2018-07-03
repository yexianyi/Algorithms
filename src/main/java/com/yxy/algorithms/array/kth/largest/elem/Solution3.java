package com.yxy.algorithms.array.kth.largest.elem;

/**
 * 
		215. Kth Largest Element in an Array
	    My Submissions 
	Question Editorial Solution  
	
	Total Accepted: 56474 Total Submissions: 168404 Difficulty: Medium 
	
	Find the kth largest element in an unsorted array. 
	Note that it is the kth largest element in the sorted order, not the kth distinct element. 
	
	For example,
	 Given [3,2,1,5,6,4] and k = 2, return 5. 
	
	Note: 
	 You may assume k is always valid, 1 ≤ k ≤ array's length.

 * @author Xianyi Ye
 * @date 05/21/2016
 * Copy from:
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * https://www.cnblogs.com/grandyang/p/4539757.html
 */
public class Solution3 {

	public int findKthLargest(int[] nums, int k) {
		int left = 0, right = nums.length-1;
		while (true) {
			int pos = partition(nums, left, right);
			if (pos == k-1)
				return nums[pos];
			else if (pos > k-1)
				right = pos-1;
			else
				left = pos+1;
		}

	}    

	public int partition(int[] nums, int left, int right) {
	    int pivot = nums[left], l = left+1, r =right;
	    
	    while (l<=r) {
	        if (nums[l]<pivot && nums[r]>pivot) {
	            swap(nums, l++, r--);
	        }
	        if (nums[l]>=pivot) ++l;
	        if (nums[r]<=pivot) --r;
	    }
	    swap(nums, left, r);
	    return r;
	}

	void swap(int[] A, int i, int j) {
	    int tmp = A[i];
	    A[i] = A[j];
	    A[j] = tmp;             
	}

	public static void main(String[] args) {
		System.out.println(new Solution3().findKthLargest(new int[]{3,2,1,5,6,4},2));
		System.out.println(new Solution3().findKthLargest(new int[]{2,1},1));

	}
}
