package com.yxy.algorithms.array.sorted.search.insert.pos;

import java.util.Random;

/**
 * 35. Search Insert Position My Submissions QuestionEditorial Solution Total
 * Accepted: 99738 Total Submissions: 268948 Difficulty: Medium Given a sorted
 * array and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * 
 * @author Xianyi Ye
 * @Date 03/28/2016
 */
public class Solution3 {

	public static int searchInsert(int[] nums, int target) {
		int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) l = mid + 1;
            if (nums[mid] > target) r = mid - 1;
        }

        return l;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3 }, 2)); // 1
		System.out.println(searchInsert(new int[] { 1, 3 }, 0)); // 0
		System.out.println(searchInsert(new int[] { 3, 5, 7, 9, 10 }, 8)); // 3
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5)); // 2
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2)); // 1
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7)); // 4
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0)); // 0
	}

}
