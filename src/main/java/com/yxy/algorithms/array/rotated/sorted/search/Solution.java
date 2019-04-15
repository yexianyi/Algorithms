package com.yxy.algorithms.array.rotated.sorted.search;
/**
 * 33. Search in Rotated Sorted Array
 * 
 * Share Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 * 
 * @author yexianyi 
 */
public class Solution {

    // Time Limit Exceeded
    public static int search(int[] nums, int target) {

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                maxIdx = i;
                if (nums[minIdx] <= target && target <= nums[maxIdx]) {
                    return doSearch(nums, minIdx, maxIdx, target);

                } else {
                    minIdx = i + 1;
                }
            }
        }

        return doSearch(nums, minIdx, nums.length - 1, target);

    }

    private static int doSearch(int[] nums, int from, int to, int target) {
        while (from <= to) {
            int mid = (to + from) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 1 }, 1));
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
    }

}
