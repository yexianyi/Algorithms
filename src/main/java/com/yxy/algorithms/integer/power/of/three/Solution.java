package com.yxy.algorithms.integer.power.of.three;
/**
 * 326. Power of Three My Submissions Question
	Total Accepted: 9973 Total Submissions: 28215 Difficulty: Easy
	Given an integer, write a function to determine if it is a power of three.
	
	Follow up:
	Could you do it without using any loop / recursion?
 * @author xianyiye
 * 2016/1/19
 */

public class Solution {

	public static boolean isPowerOfThree(int n) {
		if (n > 0) {
			int max = (int) Math.pow(3, 19);
			if (max % n == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(15));
	}

}
