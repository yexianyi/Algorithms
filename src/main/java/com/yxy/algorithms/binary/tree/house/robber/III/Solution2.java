package com.yxy.algorithms.binary.tree.house.robber.III;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 	337. House Robber III My Submissions QuestionEditorial Solution
	Total Accepted: 5506 Total Submissions: 14911 Difficulty: Medium
	The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
	
	Determine the maximum amount of money the thief can rob tonight without alerting the police.
	
	Example 1:
	     3
	    / \
	   2   3
	    \   \ 
	     3   1
	Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
	Example 2:
	     3
	    / \
	   4   5
	  / \   \ 
	 1   3   1
	Maximum amount of money the thief can rob = 4 + 5 = 9.
 * @author xianyiye
 * @Date 03/31/2016
 * Runtime：892ms
 */

public class Solution2 {
	
	public static int rob(TreeNode root) {
		if(root==null){
			return 0 ;
		}else if(root.left==null && root.right==null){
			return root.val ;
		}else if(root.left==null){
			return Math.max(root.val+rob(root.right.left)+rob(root.right.right), rob(root.right)) ;
		}else if(root.right==null){
			return Math.max(root.val+rob(root.left.left)+rob(root.left.right), rob(root.left)) ;
		}else{
			return Math.max(root.val+rob(root.left.left)+rob(root.left.right)+rob(root.right.left)+rob(root.right.right), rob(root.left)+rob(root.right)) ;
		}
		
    }




	public static void main(String[] args) {
		//
//		TreeNode root = new TreeNode(3) ;
//		root.left = new TreeNode(2)  ;
//		root.right = new TreeNode(3) ;
//		root.left.right = new TreeNode(3) ;
//		root.right.right = new TreeNode(1) ;
		
		//[4,1,null,2,null,3]
//		TreeNode root = new TreeNode(4) ;
//		root.left = new TreeNode(1)  ;
//		root.left.left = new TreeNode(2) ;
//		root.left.left.left = new TreeNode(3) ;
		
		//[4,1,null,2,null,3]
		TreeNode root = new TreeNode(3) ;
		root.left = new TreeNode(4)  ;
		root.right = new TreeNode(5) ;
		root.left.left = new TreeNode(1) ;
		root.left.right = new TreeNode(3) ;
		root.right.right = new TreeNode(1) ;
		
		System.out.println(rob(root));

	}

}
