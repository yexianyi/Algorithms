package com.yxy.algorithms.lca.binary.tree;

/**
 * 
	235. Lowest Common Ancestor of a Binary Search Tree
	 My Submissions 
	Question 
	
	Total Accepted: 42582 Total Submissions: 112254 Difficulty: Easy 
	
	
	
	
	
	Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. 
	
	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).” 
	        _______6______
	       /              \
	    ___2__          ___8__
	   /      \        /      \
	   0      _4       7       9
	         /  \
	         3   5
	

 * @author Administrator
 * 2015/12/19
 */

public class Solution {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 int low = (p.val < q.val) ? p.val : q.val;
	        int high = (p.val < q.val) ? q.val : p.val;
	    
	        TreeNode current = root;
	        while(current.val < low || current.val > high) {
	            if(current.val < low) {
	                current = current.right;
	            }
	            if(current.val > high) {
	                current = current.left;
	            }
	        }
	    
	        return current;
		
	}
}
