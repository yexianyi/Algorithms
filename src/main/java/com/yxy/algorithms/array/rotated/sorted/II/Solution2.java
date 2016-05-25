package com.yxy.algorithms.array.rotated.sorted.II;

/**
 * 81. Search in Rotated Sorted Array II My Submissions QuestionEditorial Solution
	Total Accepted: 63429 Total Submissions: 198067 Difficulty: Medium
	Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?
	
	Would this affect the run-time complexity? How and why?
	
	Write a function to determine if a given target is in the array.

 * @author xianyiye
 * @date 05/24/2016
 * Copy from:
 * https://leetcode.com/discuss/60618/neat-java-solution-using-binary-search
 * https://leetcode.com/discuss/23559/c-concise-log-n-solution
 */

public class Solution2 {

	public static boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }

        return false;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 1 }, 0));

	}

}
