package com.yxy.algorithms.power.of.two;

/**
 * 	Power of Two My Submissions Question
	Total Accepted: 44342 Total Submissions: 132535 Difficulty: Easy
	Given an integer, write a function to determine if it is a power of two.


 * @author xianyiye
 * 2015/12/23
 */

public class Solution {
	
	public boolean isPowerOfTwo(int n) {
		if(n<=0){
            return false ;
        }
        return (n&(n-1)) == 0 ;
    }


}
