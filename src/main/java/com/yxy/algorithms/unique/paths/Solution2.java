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
 * Copy from:
 * https://leetcode.com/discuss/94614/sharing-my-0ms-java-solution-with-detailed-exploration
 */

public class Solution2 {
	
	/**
	 * 	First, image you have a m*n matrix, and you start from the left-top corner, to the right-bottom corner. 
	 * 	And at the beginning, the matrix[0][0] would be 1, means you only have one way to reach the position where you are. 
	 * 	And then if you want to move to the end of the first row, which is matrix[0][n-1], you only have one way to be there, too. 
	 * 	you just need to move along the first row, to the rightmost position. Thus, you may set all values in the first row to 1.

		And then you move down, if you want to reach the bottom of the leftmost column. Similarly, you only have one way to be there, too.
		thus you can also set all values in the leftmost column to be 1.
		
		Let's go further, if you want to reach the right end of second row, how many different paths you can choose? 
		Let's say, if you want to get matrix[1][1], you can either move right firstly, then move down, or you can move down firstly, 
		then move right. So you will have two paths to reach the position(1,1), then matrix[1][1] will equal 2. 
		So how can we get this number in general?
		
		Obviously, we could know matrix[i][j] = matrix[i-1][j] + matrix[i][j-1], because if we can get the position (i-1,j) or (i, j-1), 
		then we only have one way to reach the destination -- move down or move right -- thus we use this formula 
		matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] to fill up all of the values in the matrix.
		
		Further more, do we really need o(m*n) space to help us finishing this task? 
		Not really, through filling the matrix, we may see the filling task could be fulfilled layer by layer. 
		Another saying, we could use only 1-dimension array to present each row of the matrix. 
		And we fill the array again and again till n times (0,1,2...n-1). And finally we will get the result we want.
	 * @param m
	 * @param n
	 * @return
	 */
	
	public int uniquePaths(int m, int n) {
	    int[] dp = new int[n];
	    dp[0] = 1;
	    for (int i = 0; i < m; i++)
	        for (int j = 1; j < n; j++)
	            dp[j] = dp[j - 1] + dp[j]; //dp[j] = dp[row-1][col]; dp[j-1] = dp[row][col-1] ;
	    return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(new Solution2().uniquePaths(1,1)) ;
		System.out.println(new Solution2().uniquePaths(2,3)) ;
		System.out.println(new Solution2().uniquePaths(3,3)) ;
		System.out.println(new Solution2().uniquePaths(4,4)) ;
		System.out.println(new Solution2().uniquePaths(3,7)) ;

	}

}
