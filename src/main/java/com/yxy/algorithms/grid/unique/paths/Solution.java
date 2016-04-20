package com.yxy.algorithms.grid.unique.paths;
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
 */
public class Solution {
	
	private int count = 0 ;
	
	public int uniquePaths(int m, int n) {
		findPaths(m-1,n-1) ;
		
        return count ;
    }
	
	
	private void findPaths(int m, int n){
		if(m==0 && n==0){
			count++ ;
			return ;
		}
		
		if(m>0){
			findPaths(m-1,n) ;
		}
		
		if(n>0){
			findPaths(m, n-1) ;
		}
		
	}

	public static void main(String[] args) {
		System.out.println(new Solution().uniquePaths(1,1)) ;
		System.out.println(new Solution().uniquePaths(2,3)) ;
		System.out.println(new Solution().uniquePaths(3,3)) ;
		System.out.println(new Solution().uniquePaths(4,4)) ;
		System.out.println(new Solution().uniquePaths(3,7)) ;

	}

}
