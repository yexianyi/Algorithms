package com.yxy.algorithms.binary.tree.invert;

/**
 * 
	Invert Binary Tree
	 My Submissions 
	Question 
	
	Total Accepted: 56032 Total Submissions: 132877 Difficulty: Easy 
	
	
	
	
	Invert a binary tree. 
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	to      4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1

 * @author Administrator
 * 2015/12/18
 */

public class Solution {
	
	public TreeNode invertTree(TreeNode root) {
		if(root==null){
			return root ;
		}

		invertTree(root.left) ;
		invertTree(root.right) ;
		
		TreeNode temp = root.left ;
		root.left = root.right ;
		root.right = temp ;
		
		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
