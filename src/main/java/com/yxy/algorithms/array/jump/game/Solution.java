package com.yxy.algorithms.array.jump.game;

/**
 * 55. Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	Example 1:
	
	Input: [2,3,1,1,4]
	Output: true
	Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
	Example 2:
	
	Input: [3,2,1,0,4]
	Output: false
	Explanation: You will always arrive at index 3 no matter what. Its maximum
	             jump length is 0, which makes it impossible to reach the last index.
	             
 * @author Ye Xianyi
 */

public class Solution {
	
	//timeout
	public static boolean canJump(int[] nums) {
       return jump(nums, 0) ;
		
    }

	private static boolean jump(int[] nums, int start) {
		if(start>=nums.length-1){
			return true ;
		}
		
		for(int i=1; i<=nums[start]; i++){
			if(jump(nums, start+i)){
				return true ;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
		System.out.println(canJump(new int[]{3,2,1,0,4}));
	}

}
