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
 * Copy from:
 *         https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/275487/Java-Short-Solution-!!!
 */
public class Solution2 {

    public static int search(int[] a, int t) {
        if (a.length == 0)
            return -1;
        int l = 0, h = a.length - 1;

        // looking for pivot
        while (l < h) {
            int m = l + (h - l) / 2;
            if (a[m] > a[h])
                l = m + 1;
            else if (a[m] < a[h])
                h = m;
        }

        if (t <= a[a.length - 1])
            h = a.length - 1;
        else {
            h = l - 1;
            l = 0;
        }

        while (l < h) {
            int m = l + (h - l) / 2;
            if (a[m] >= t)
                h = m;
            else
                l = m + 1;
        }

        return a[l] == t ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(search(new int[] { 1 }, 1));
    }

}
