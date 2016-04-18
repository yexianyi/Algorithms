package com.yxy.algorithms.unique.paths;
/**
 * 	62. Unique Paths   My Submissions QuestionEditorial Solution
	Total Accepted: 85178 Total Submissions: 235795 Difficulty: Medium
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	
	How many possible unique paths are there?
	
	
	Above is a 3 x 7 grid. How many possible unique paths are there?
	
	Note: m and n will be at most 100.
 * @author xianyiye
 * @date 04/18/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/89774/0ms-java-10-line-code
 * http://blog.csdn.net/linhuanmars/article/details/22126357
 */
public class Solution3 {
	
	//Basically it is math: select m (or n) from [(m-1)+(n-1)]
	public int uniquePaths(int m, int n) {
	    int smaller = m>n ? n-1 : m-1;
	    int totalsteps = m+n-2;
	    long result = 1;
	    for (int counter = 1; counter<=smaller; counter++){
	        result *= totalsteps--;
	        result /= counter;
	    }
	    return (int)result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution3().uniquePaths(1,1)) ;
		System.out.println(new Solution3().uniquePaths(2,3)) ;
		System.out.println(new Solution3().uniquePaths(3,3)) ;
		System.out.println(new Solution3().uniquePaths(4,4)) ;
		System.out.println(new Solution3().uniquePaths(3,7)) ;

	}

}
