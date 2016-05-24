package com.yxy.algorithms.integer.perfect.squares;
/**
 * 279. Perfect Squares My Submissions QuestionEditorial Solution
	Total Accepted: 35296 Total Submissions: 107196 Difficulty: Medium
	Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	
	For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 * @author xianyiye
 * @date 05/24/2016
 * Copy from:
 * https://leetcode.com/discuss/57185/o-sqrt-n-about-0-034-ms-and-0-018-ms
 */
public class Solution2 {
	/**
	 * In mathematics, Legendre's three-square theorem states that a natural number can be represented as the sum of three squares of integers
		n = x^2 + y^2 + z^2
		if and only if n is not of the form n = 4^a(8b + 7) for integers a and b.
		
		The first numbers that cannot be expressed as the sum of three squares (i.e. numbers that can be expressed as n = 4^a(8b + 7)) are 7, 15, 23, 28, 31, 39, 47, 55, 60, 63, 71 ...
	 * @param n
	 * @return
	 */
	public static int numSquares(int n) {
		  while (n % 4 == 0)
		        n /= 4;
		    if (n % 8 == 7)
		        return 4;
		    int a = -1, b = (int) Math.sqrt(n);
		    n -= b * b;
		    b += b + 1;
		    while (a <= b) {
		        if (n < 0)
		            n += b -= 2;
		        else if (n > 0)
		            n -= a += 2;
		        else
		            return a < 0 ? 1 : 2;
		    }
		    return 3;
    }

	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}

}
