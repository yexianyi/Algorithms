package com.yxy.algorithms.array.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all
 * unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Ye, Xianyi 
 * 2020/09/23
 * 
 */
public class Solution3 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) { // assume 1st num is one of result
            if(i == 0 || ( i>0 && nums[i] != nums[i-1])) {
                int left = i+1;
                int right = nums.length - 1;
                int target = 0 - nums[i] ;
                
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++ ;
                        right-- ;
                    }
                }
                
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(threeSum(new int[] { 3, 0, -2, -1, 1, 2 }));
        System.out.println(threeSum(new int[] { -2, 0, 0, 2, 2 }));
    }

}
