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
 * https://leetcode.com/discuss/88064/97%25-2ms-java-quick-select-solution
 */
public class Solution4 {

	 public int findKthLargest(int[] nums, int k) {

	        return select(nums, k-1);
	    }

	    // Quick select
	    private int select(int[] nums, int k) {
	        int left = 0, right = nums.length-1;
	        while(true) {
	            if(left == right)
	                return nums[left];
	            int pivotIndex = medianOf3(nums, left, right);
	            pivotIndex = partition(nums, left, right, pivotIndex);
	            if(pivotIndex == k)
	                return nums[k];
	            else if(pivotIndex > k)
	                right = pivotIndex-1;
	            else
	                left = pivotIndex+1;
	        }
	    }

	    //Use median-of-three strategy to choose pivot
	    private int medianOf3(int[] nums, int left, int right) {
	        int mid = left + (right - left) / 2;
	        if(nums[right] > nums[left])
	            swap(nums, left, right);
	        if(nums[right] > nums[mid])
	            swap(nums, right, mid);
	        if(nums[mid] > nums[left])
	            swap(nums,left, mid);
	        return mid;
	    }

	    private int partition(int[] nums, int left, int right, int pivotIndex) {
	        int pivotValue = nums[pivotIndex];
	        swap(nums, pivotIndex, right);
	        int index = left;
	        for(int i = left; i < right; ++i) {
	            if(nums[i] > pivotValue) {
	                swap(nums, index, i);
	                ++index;
	            }
	        }
	        swap(nums, right, index);
	        return index;
	    }

	    private void swap(int[] nums, int a, int b) {
	        int temp = nums[a];
	        nums[a] = nums[b];
	        nums[b] = temp;
	    }

	public static void main(String[] args) {
		System.out.println(new Solution4().findKthLargest(new int[]{2,1},1));

	}
}
