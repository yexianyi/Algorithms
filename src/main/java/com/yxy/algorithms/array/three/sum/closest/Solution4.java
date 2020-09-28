package com.yxy.algorithms.array.three.sum.closest;

import java.util.Arrays;
/**
 * 16. 3Sum Closest My Submissions QuestionEditorial Solution
	Total Accepted: 81876 Total Submissions: 277713 Difficulty: Medium
	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	
	    For example, given array S = {-1 2 1 -4}, and target = 1.
	
	    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author xianyiye
 * @date 09/24/2020
 * 
 */
public class Solution4 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums) ;
        int diff = Integer.MAX_VALUE ;
        for(int i=0; i<nums.length && diff !=0 ; i++){
            int left = i+1 ;
            int right = nums.length - 1 ; 
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right] ;
                int curr_abs_diff = Math.abs(target - sum) ;
                if(curr_abs_diff < Math.abs(diff)){
                    diff = target - sum ;
                }
                
                if(sum < target){
                    left ++ ;
                } else {
                    right -- ;
                }
            }
     
        }
       
        return target - diff ;
    }

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		System.out.println(s.threeSumClosest(new int[] { 0, 1, 2 }, 3));
	}

}
