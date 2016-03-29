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
 */

public class Solution2 {
	
	public static int numTrees(int n) {
		int res = 0;
        // Base case
        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
        	//h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0) (n>=2)
            res += numTrees(i) * numTrees(n - i - 1);
        }
        return res;
    }
	

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
	}

}
