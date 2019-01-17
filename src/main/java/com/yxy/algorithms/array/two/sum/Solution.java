package com.yxy.algorithms.array.two.sum;

import java.util.Arrays;

/**
 * 1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


 * @author yexianyi
 * 2019/01/17
 */
public class Solution {
    
    //Runtime: 6 ms, faster than 98.95% of Java online submissions for Two Sum.
    public static int[] twoSum(int[] nums, int target) {
        int[] copy = Arrays.copyOfRange(nums, 0, nums.length) ;
        Arrays.sort(nums);
        
        int left = 0 ;
        int right = nums.length - 1 ;
        
        while(left < right) {
            int sum = nums[left] + nums[right] ;
            if(sum < target) {
                left++ ;
            } else if(sum > target) {
                right -- ;
            } else {
                break ;
            }
        }
        
        int l = -1,r = -1 ;
        for(int i=0; i<copy.length; i++) {
            if(copy[i] == nums[left] && l == -1) {
                l = i ;
            } else if(copy[i] == nums[right]) {
                r = i ;
            }
            
        }
        
        return new int[] {l, r}  ;
    }

    public static void main(String[] args) {
//        int[] result = twoSum(new int[] {2, 7, 11, 15}, 9) ;
//        System.out.println(result[0] + "," + result[1]);
//        
//        result = twoSum(new int[] {3, 2, 4}, 6) ;
//        System.out.println(result[0] + "," + result[1]);
        
        int[] result = twoSum(new int[] {3, 3}, 6) ;
        System.out.println(result[0] + "," + result[1]);
    }

}
