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

public class Solution {
	
	public static int numTrees(int n) {
		if(n==0){
			return 0 ;
		} else if(n==1){
			return 1 ;
		}
		
		//Catalan num : h(n)=h(n-1)*(4*n-2)/(n+1);
		return numTrees(n-1)*(4*n-2)/(n+1);
    }
	

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
	}

}
