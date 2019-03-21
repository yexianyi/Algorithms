package com.yxy.algorithms.array.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
 */
public class Solution {

    // Time Limit Exceeded
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>() ;
        List<Integer> temp = new ArrayList<>() ;
        Arrays.sort(nums);
        calculateCombination(0, nums, temp, res) ;
        
        return new ArrayList<>(res) ;
    }

    private static void calculateCombination(int start, int[] nums, List<Integer> temp, Set<List<Integer>> res) {
        if(temp.size()>3 || start==nums.length) {
            return ;
        }
        
        for(int i=start; i<nums.length; i++) {
            temp.add(nums[i]) ;
            if(temp.size()==3) {
                int sum = temp.stream().mapToInt(n -> n).sum() ;
                if(sum == 0) {
                    Collections.sort(temp) ;
                    res.add(new ArrayList<>(temp)) ;
                } else {
                    calculateCombination(i+1, nums, temp, res) ;
                }
            } else {
                calculateCombination(i+1, nums, temp, res) ;
            }
            temp.remove(temp.size()-1);
        }
        
       
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {3,0,-2,-1,1,2}));
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

}
