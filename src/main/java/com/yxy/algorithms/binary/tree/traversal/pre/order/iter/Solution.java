package com.yxy.algorithms.binary.tree.traversal.pre.order.iter;

/**
 * 144. Binary Tree Preorder Traversal My Submissions Question
	Total Accepted: 114083 Total Submissions: 289445 Difficulty: Medium
	Given a binary tree, return the preorder traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,2,3].
	
	Note: Recursive solution is trivial, could you do it iteratively?
 * @author Xianyi Ye
 * @Date 3/26/2016
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.yxy.algorithms.binary.tree.TreeNode;

public class Solution {
	
 public static List<Integer> preorderTraversal(TreeNode root) {
	 List<Integer> list = new ArrayList<Integer>() ;
	 Stack<TreeNode> stack = new Stack<TreeNode>() ;
	 if(root!=null){
		 stack.push(root) ;
	 }
	 
	 while(!stack.isEmpty()){
		 TreeNode node = stack.pop() ;
		 list.add(node.val) ;
		 
		 if(node.right!=null){
			 stack.push(node.right) ;
		 }

		 if(node.left!=null){
			 stack.push(node.left) ;
		 }
		 
	 }
	 
	return list;
        
    }

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1) ;
		node1.left = new TreeNode(2)  ;
		node1.right = new TreeNode(3) ;
		node1.left.left = new TreeNode(4) ;
		node1.left.right = new TreeNode(5) ;
		node1.right.left = new TreeNode(6) ;
		node1.right.right = new TreeNode(7) ;
		node1.left.left.left = new TreeNode(8) ;
		node1.left.left.right = new TreeNode(9) ;
		
		//124895367
		List<Integer> list = preorderTraversal(node1) ;
		for(Integer num : list){
			System.out.print(num+" ");
		}

	}

}
