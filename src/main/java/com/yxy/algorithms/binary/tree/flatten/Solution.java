package com.yxy.algorithms.binary.tree.flatten;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 114. Flatten Binary Tree to Linked List My Submissions QuestionEditorial Solution
	Total Accepted: 83420 Total Submissions: 266906 Difficulty: Medium
	Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
	click to show hints.
	
	Hints:
	If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 * @author xianyiye
 * @date 05/27/2016
 */
public class Solution {
	
	//timeout
	public static void flatten(TreeNode root) {
		preOrder(root, null) ;
    }
	
	private static TreeNode preOrder(TreeNode node, TreeNode parent){
		if(node==null){
			return parent;
		}
		
//		System.out.println(node.val);
		
		if(parent!=null){
			parent.right = node ;
		}
		
		TreeNode copy = node.right ;
		parent = preOrder(node.left, node) ;
		return preOrder(copy, parent) ;
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTreeUtil.create(new Integer[]{1,2,5,3,4,null,6}, TreeNode.class) ;
		flatten(root) ;
		
		while(root!=null){
			System.out.print(root.val+" ") ;
			root = root.right ;
		}
	}

}
