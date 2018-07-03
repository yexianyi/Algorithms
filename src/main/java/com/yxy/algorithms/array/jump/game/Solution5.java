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
 * @date 07/02/2018
 * 
 * Reference:
 * https://blog.csdn.net/revivedsun/article/details/52951765
 */
public class Solution5 {
	
	 public static boolean canJump(int[] nums) {
	        int lastPos = nums.length - 1;
	        for (int i = nums.length - 1; i >= 0; i--) {
	            if (i + nums[i] >= lastPos) {
	                lastPos = i;
	            }
	        }
	        return lastPos == 0;
	    }



	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
		System.out.println(canJump(new int[]{3,2,1,0,4}));
	}

}
