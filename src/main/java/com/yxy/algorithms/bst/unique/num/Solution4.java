package com.yxy.algorithms.bst.unique.num;

/**
 * 96. Unique Binary Search Trees My Submissions QuestionEditorial Solution
	Total Accepted: 79021 Total Submissions: 212627 Difficulty: Medium
	Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	
	For example,
	Given n = 3, there are a total of 5 unique BST's.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3

 * @author xianyiye
 * @Date 03/28/2016
 * Copied from:
 * https://leetcode.com/discuss/86650/fantastic-clean-java-dp-solution-with-detail-explaination
 */

public class Solution4 {
	
	//DP
	public static int numTrees(int n) {
		int [] dp = new int[n+1];
	    dp[0]= 1;
	    dp[1] = 1;
	    for(int level = 2; level <=n; level++)
	        for(int root = 1; root<=level; root++)
	            dp[level] += dp[level-root]*dp[root-1];
	    return dp[n];
    }
	

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
	}

}
