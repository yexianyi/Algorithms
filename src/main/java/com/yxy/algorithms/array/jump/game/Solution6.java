package com.yxy.algorithms.array.jump.game;

/**
 * 55. Jump Game QuestionEditorial Solution My Submissions Total Accepted: 83980
 * Total Submissions: 293310 Difficulty: Medium Given an array of non-negative
 * integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
 * 
 * @author xianyiye
 * @date 01/23/2025
 * 
 *       Copy from:
 *       https://leetcode.com/problems/jump-game/solutions/3758301/java-easy-solution-with-explanation
 */
public class Solution6 {

	public static boolean canJump(int[] nums) {
		int reachable = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > reachable)
				return false;
			reachable = Math.max(reachable, i + nums[i]);
			if (reachable >= nums.length - 1) {
				return true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

}
