package com.yxy.algorithms.array.four.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
    Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
    
    Note:
    
    The solution set must not contain duplicate quadruplets.
    
    Example:
    
    Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
    
    A solution set is:
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]
 * 
 * @author yexianyi
 * 2019/03/21
 *
 * Copy from:
 * https://leetcode.com/problems/4sum/discuss/255760/Java-32ms-solution
 */
public class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int f = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int s = nums[j];
                int sum1 = f + s;
                
                int k1 = j + 1, k2 = nums.length - 1;
                while (k1 < k2) {
                    int total = sum1 + nums[k1] + nums[k2];

                    if (total == target) {
                        res.add(Arrays.asList(f, s, nums[k1], nums[k2]));
                        
                        // skip duplicates of third and fourth nums
                        while (k1 + 1 < k2 && nums[k1] == nums[k1 + 1]) k1++;
                        while (k2 - 1 > k1 && nums[k2] == nums[k2 - 1]) k2--;
                        
                        k1++;  k2--;
                    } else if (total > target) {
                        k2--;
                    } else k1++;
                }
                // skip duplicates of second num
                while (j + 1 < nums.length && s == nums[j + 1]) j++;
            }
            // skip duplicates of first num
            while (i + 1 < nums.length && f == nums[i + 1]) i++;
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
