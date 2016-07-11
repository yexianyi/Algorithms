package com.yxy.algorithms.array.jump.game;
/**
 * 55. Jump Game  QuestionEditorial Solution  My Submissions
	Total Accepted: 83980
	Total Submissions: 293310
	Difficulty: Medium
	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	A = [2,3,1,1,4], return true.
	A = [3,2,1,0,4], return false.

 * @author xianyiye
 * @date 07/11/2016
 * 
 * Reference:
 * http://www.cnblogs.com/yuzhangcmu/p/4039840.html
 * https://discuss.leetcode.com/topic/19931/6-line-java-solution-in-o-n
 */
public class Solution4 {
	
	//DP2, timeout
	public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxReachable = 0;
        
        for(int i=0; i<nums.length; i++){
        	if (i > maxReachable) {
        		return false;
        	}
        	maxReachable = Math.max(maxReachable, i+nums[i]) ;
        	
        	if(maxReachable>=nums.length-1){
        		return true ;
        	}
        }
        
		return true;

    }


	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
		System.out.println(canJump(new int[]{3,2,1,0,4}));
	}

}
