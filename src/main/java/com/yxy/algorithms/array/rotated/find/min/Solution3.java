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
 * Copy from:
 * https://leetcode.com/discuss/45611/7-line-o-logn-solution
 * 
 * Reference:
 * https://leetcode.com/discuss/81444/9-line-java-code-beats-95-14%25-run-times
 */
public class Solution3 {
	
	/**
	 * if the array is indeed rotated by some pivot, there are only 2 possibilities

		a[mid] > a[left] && a[mid] > a[right], meaning we are on the bigger part, the smaller part is on our right, so go right
		a[mid] < a[left] && a[mid] < a[right], meaning we are on the smaller part, to find the smallest element, go left
		if the array is not rotated (actually one rotating cycle completed), we just need to go left, in this case a[mid] < a[right] always holds.

	 	the cases above, we conclude that

		if a[mid] > a[right], go right; if a[mid] < a[right], go left.
	 * @param nums
	 * @return
	 */
	
	//O(logN)
	public static int findMin(int[] nums) {
	    int left = 0, right = nums.length - 1, mid = 0;
	    while(left < right){
	        mid = (left + right) >> 1;
	        if(nums[mid] > nums[right]) left = mid + 1;
	        else right = mid;
	    }
	    return nums[right];
	}

	public static void main(String[] args) {
		System.out.println(findMin(new int[]{1}));
		System.out.println(findMin(new int[]{1,2}));
		System.out.println(findMin(new int[]{3,1,2}));
		System.out.println(findMin(new int[]{1,2,3,4,5,6,7,0}));
		System.out.println(findMin(new int[]{4,5,6,7,0,1,2,3}));
	}

}
