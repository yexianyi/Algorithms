package com.yxy.algorithms.palindrome.number;

/**
 * 	9. Palindrome Number My Submissions Question
	Total Accepted: 97471 Total Submissions: 323285 Difficulty: Easy
	Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author xianyiye
 * 2015/12/30
 */

public class Solution {
	
	public boolean isPalindrome(int x) {
		int sum = 0,target = x;
        while (x > 0) {
            int temp = x % 10;
            x /= 10;
            sum = sum * 10 + temp;
        }
        return sum == target;
	        
	}


}
