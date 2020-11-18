package com.yxy.algorithms.array.subarray.sum.equals.k;

import java.util.HashMap;

/**
 * 560. Subarray Sum Equals K
    Medium
    
    Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
    
    Example 1:
    
    Input: nums = [1,1,1], k = 2
    Output: 2
    Example 2:
    
    Input: nums = [1,2,3], k = 3
    Output: 2
    
    Constraints:
    
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
 * @author Ye Xianyi
 * 2020/11/18
 */
public class Solution {

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[] {1, -1, 0, 1}, 0)) ;
        System.out.println(subarraySum(new int[] {3,4,7,2,-3,1,4,3}, 7)) ;
    }

}
