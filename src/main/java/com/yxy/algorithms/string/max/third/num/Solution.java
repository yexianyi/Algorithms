package com.yxy.algorithms.string.max.third.num;

/**
 * 414. Third Maximum Number
 * 
 * Share Given a non-empty array of integers, return the third maximum number in this array. If it does not exist,
 * return the maximum number. The time complexity must be in O(n).
 * 
 * Example 1: Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1. Example 2: Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead. Example 3: Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum distinct number. Both numbers with value 2 are
 * both considered as second maximum.
 * 
 * @author yexianyi 2019/02/28
 *
 */
public class Solution {

    public static int thirdMax(int[] nums) {
        Integer[] array = new Integer[3];

        for (int i = 0; i < nums.length; i++) {
            if ((array[0] != null && nums[i] == array[0]) 
                    || (array[1] != null && nums[i] == array[1])
                    || (array[2] != null && nums[i] == array[2])) {
                continue;
            }

            if (array[2] == null || nums[i] > array[2]) {
                array[0] = array[1];
                array[1] = array[2];
                array[2] = nums[i];
            } else if (array[1] == null || nums[i] > array[1]) {
                array[0] = array[1];
                array[1] = nums[i];
            } else if (array[0] == null || nums[i] > array[0]) {
                array[0] = nums[i];
            }

        }

        return array[0] == null ? array[2] : array[0];
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[] { 5, 2, 4, 1, 3, 6, 0 })); // 4
        System.out.println(thirdMax(new int[] { 1, 2, 2, 5, 3, 5 })); // 2
        System.out.println(thirdMax(new int[] { 1, 1, 2 })); // 2
        System.out.println(thirdMax(new int[] { 3, 2, 1 })); // 1
        System.out.println(thirdMax(new int[] { 1, 2 })); // 2
        System.out.println(thirdMax(new int[] { 2, 2, 3, 1 })); // 1
    }

}
