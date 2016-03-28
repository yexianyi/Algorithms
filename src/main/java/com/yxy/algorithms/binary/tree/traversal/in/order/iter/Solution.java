package com.yxy.algorithms.binary.tree.traversal.in.order.iter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 94. Binary Tree Inorder Traversal My Submissions QuestionEditorial Solution
Total Accepted: 117123 Total Submissions: 298402 Difficulty: Medium
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
* @author xianyiye
* @Date 03/28/2016
*/

public class Solution {
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>() ;
        if(root==null){
        	return list ;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>() ;
        TreeNode node = root ;
        while(node!=null || !stack.isEmpty()){
        	while(node!=null){
        		stack.push(node) ;
        		node = node.left ;
        	}
        	
        	node = stack.pop();
        	list.add(node.val) ; //because node.left == null ;
        	node = node.right ; //travel node.right ;
        }
		
		return list ;
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
		
		//849251637
		List<Integer> list = inorderTraversal(node1) ;
		for(Integer num : list){
			System.out.print(num+" ");
		}

	}

}
