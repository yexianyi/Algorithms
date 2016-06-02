package com.yxy.algorithms.bits.bitwise.and.numbers.range;

/**
 * 
201. Bitwise AND of Numbers Range
    My Submissions 
	Question Editorial Solution  
	
	Total Accepted: 35229 Total Submissions: 114440 Difficulty: Medium 
	
	Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
	
	For example, given the range [5, 7], you should return 4. 

 * @author xianyiye
 * @date 06/02/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/53646/simple-and-easy-to-understand-java-solution
 * http://www.07net01.com/2015/07/873374.html
 */
public class Solution3 {
	
	/**
	 * Basic idea:
	 * This algorithm is based on 2 regular patterns.
	 * 1. As long as there are different numbers in the same position for two numbers, then this position must by ZERO in the final result.
	 * 2. If the number of higher position is ZERO, then every position lower than it in the final result must be ZERO too. (THIS IS VERY IMPORTANT!!)
	 * 3. Based on #1 and #2, this question has became looking for common prefix in M and N.
	 * @param m
	 * @param n
	 * @return
	 */
	public static int rangeBitwiseAnd(int m, int n) {
		 int diffBits = 0;
	        while (m != n) {
	            m >>= 1;
	            n >>= 1;
	            diffBits++;
	        }
	        return n<<diffBits;

    }
	
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(4,7)) ;

	}

}
