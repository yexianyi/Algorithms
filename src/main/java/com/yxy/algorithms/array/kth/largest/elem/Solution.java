package com.yxy.algorithms.array.kth.largest.elem;

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
