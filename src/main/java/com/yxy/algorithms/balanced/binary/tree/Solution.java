package com.yxy.algorithms.balanced.binary.tree;

/**
 * 	110. Balanced Binary Tree My Submissions Question
	Total Accepted: 87485 Total Submissions: 266212 Difficulty: Easy
	Given a binary tree, determine if it is height-balanced.
	
	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author xianyiye
 * 2015/12/22
 */

public class Solution {
	
	public boolean isBalanced(TreeNode root) {
		
		if(root==null){
			return true ;
		}
		
		int depthLeft = getDepth(root.left) ;
		int depthRight = getDepth(root.right) ;
		
		int diff = depthLeft-depthRight ;
		if( diff>1 || diff<-1){
			return false ;
		}
		
		return isBalanced(root.left) && isBalanced(root.right) ;
		
	        
	}
	
	public int getDepth(TreeNode root) {
		if(root==null){
			return 0 ;
		}
		
		int depthLeft = 1 + getDepth(root.left) ;
		int depthRight = 1 + getDepth(root.right) ;
		
		return depthLeft >= depthRight ? depthLeft : depthRight ;
	}


}
