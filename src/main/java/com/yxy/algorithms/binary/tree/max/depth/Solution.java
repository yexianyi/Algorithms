package com.yxy.algorithms.binary.tree.max.depth;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 
 * 	Maximum Depth of Binary Tree My Submissions Question
	Total Accepted: 107630 Total Submissions: 231653 Difficulty: Easy
	Given a binary tree, find its maximum depth.
	
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	
	Subscribe to see which companies asked this question
 * 
 * 
 * @author xianyiye
 * 2015/12/18
 */
public class Solution {
	

	public int maxDepth(TreeNode root) {
		int l_depth = 0 ;
		int r_depth = 0 ;
		
		if(root==null){
			return 0 ;
		}
		
		if(root.left!=null){
			l_depth += 1 + maxDepth(root.left) ; 
		}
		
		if(root.right!=null){
			r_depth += 1 + maxDepth(root.right) ; 
		}

		if(root.left==null && root.right==null){
			return 1 ;
		}
		
		if(l_depth > r_depth){
			return l_depth ;
		}else{
			return r_depth ;
		}
        
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1) ;
		root.left = null ;
		root.right = new TreeNode(2) ;
		root.right.left = new TreeNode(3) ;
		root.right.right = null ;
		
		Solution solution = new Solution() ;
		System.out.println(solution.maxDepth(root)) ;

	}

}
