package com.yxy.algorithms.array.three.sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 3Sum
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    
    Note:
    
    The solution set must not contain duplicate triplets.
    
    Example:
    
    Given array nums = [-1, 0, 1, 2, -1, -4],
    
    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
 * 
 * @author yexianyi
 * 2019/03/21
 * 
 * Copy from:
 * https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
 */
public class Solution2 {

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {3,0,-2,-1,1,2}));
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

}
