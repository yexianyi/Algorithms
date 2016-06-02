package com.yxy.algorithms.bits.bitwise.and.numbers.range;

/**
 * 201. Bitwise AND of Numbers Range
    My Submissions 
	Question Editorial Solution  
	
	Total Accepted: 35229 Total Submissions: 114440 Difficulty: Medium 
	
	Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
	
	For example, given the range [5, 7], you should return 4. 

 * @author xianyiye
 * @date 06/02/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/49088/2-line-solution-with-detailed-explanation
 */
public class Solution2 {
	
	public static int rangeBitwiseAnd(int m, int n) {
		while(m<n) n = n & (n-1);
        return n;

    }
	
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5,7)) ;

	}

}
