package com.yxy.algorithms.classic.array.quick.select;

import java.util.Random;

/**
 * find Kth Largest Element in an Array
 * 
 * @author Xianyi Ye
 *
 */
public class Solution {

    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        return quickSelect(left, right, k, nums);
    }

    private static int quickSelect(int start, int end, int k, int[] nums) {
        if (start == end) // If the list contains only one element,
            return nums[start]; // return that element

        int pivot = start; // default pivot
        // int pivot = start + new Random().nextInt(end - start); // optimizer to choose pivot
        pivot = partition(start, end, pivot, nums);
        if (pivot == nums.length - k) {
            return nums[pivot];
        } else if (pivot < nums.length - k) {
            return quickSelect(pivot + 1, end, k, nums);
        } else {
            return quickSelect(start, pivot - 1, k, nums);
        }

    }

    private static int partition(int start, int end, int pivot, int[] nums) {
        pivot = end;
        int i = start;
        int j = start;

        while (j < end) {
            if (nums[j] > nums[pivot]) {
                j++;
            } else {
                swap(i, j, nums);
                i++;
                j++;
            }
        }

        swap(i, pivot, nums); // finally swap the last num with nums[i]

        return i;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        System.out.println(findKthLargest(nums, 2));
    }

}
