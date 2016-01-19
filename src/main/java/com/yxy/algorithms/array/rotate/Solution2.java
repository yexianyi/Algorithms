package com.yxy.algorithms.array.rotate;

/**
 * 	189. Rotate Array My Submissions Question
	Total Accepted: 57478 Total Submissions: 286689 Difficulty: Easy
	Rotate an array of n elements to the right by k steps.
	
	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	
	Note:
	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
	
	[show hint]
	
	Hint:
	Could you do it in-place with O(1) extra space?
	Related problem: Reverse Words in a String II


 * @author xianyiye
 * 2016/1/19
 */

public class Solution2 {

	public static void rotate(int[] nums, int k) {
		if (nums.length <= 1) {
			return;
		}
		k = k % nums.length;
		int mid = nums.length - k;
		reverse(nums, mid, nums.length - 1);
		reverse(nums, 0, mid - 1);
		reverse(nums, 0, nums.length - 1);
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			nums[start] = nums[start] ^ nums[end];
			nums[end] = nums[start] ^ nums[end];
			nums[start] = nums[start] ^ nums[end];
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);

		for (int num : nums) {
			System.out.print(num + " ");
		}

	}

}
