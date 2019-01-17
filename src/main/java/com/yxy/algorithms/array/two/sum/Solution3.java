package com.yxy.algorithms.array.two.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * 
 * @author yexianyi 2019/01/17
 */
public class Solution3 {

    /**
     * Approach 2: Two-pass Hash Table To improve our run time complexity, we need a more efficient way to check if the
     * complement exists in the array. If the complement exists, we need to look up its index. What is the best way to
     * maintain a mapping of each element in the array to its index? A hash table.
     * 
     * We reduce the look up time from O(n)O(n) to O(1)O(1) by trading space for speed. A hash table is built exactly
     * for this purpose, it supports fast look up in near constant time. I say "near" because if a collision occurred, a
     * look up could degenerate to O(n)O(n) time. But look up in hash table should be amortized O(1)O(1) time as long as
     * the hash function was chosen carefully.
     * 
     * A simple implementation uses two iterations. In the first iteration, we add each element's value and its index to
     * the table. Then, in the second iteration we check if each element's complement (target - nums[i]target−nums[i])
     * exists in the table. Beware that the complement must not be nums[i]nums[i] itself!
     * 
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
