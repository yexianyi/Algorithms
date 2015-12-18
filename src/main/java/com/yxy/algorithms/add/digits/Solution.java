package com.yxy.algorithms.add.digits;

/**
 * Add Digits My Submissions Question
	Total Accepted: 51639 Total Submissions: 108431 Difficulty: Easy
	Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	
	For example:
	
	Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	
	Follow up:
	Could you do it without any loop/recursion in O(1) runtime?
 * @author Xianyi Ye
 * 2015/12/18
 *
 */

public class Solution {
	
	public int addDigits(int num) {
		
		return num>0 && num%9 == 0 ? 9 : num%9;
        
    }

	public static void main(String[] args) {

	}

}
