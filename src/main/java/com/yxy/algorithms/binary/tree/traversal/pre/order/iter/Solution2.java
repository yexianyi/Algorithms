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
 * @Date 3/28/2016
 */

import java.util.ArrayList;
import java.util.List;

import com.yxy.algorithms.binary.tree.TreeNode;

public class Solution2 {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>() ;
		if(root==null){
			return list ;
		}
		List<TreeNode> arrayList = new ArrayList<TreeNode>() ;
		arrayList.add(root) ;
 		
		for(int i=0; i<arrayList.size(); i++){
			TreeNode node = arrayList.get(i) ;
			if(node.right!=null){
				arrayList.add(i+1, node.right);
			}

			if(node.left!=null){
				arrayList.add(i+1, node.left);
			}
			
		}
		
		for(TreeNode node : arrayList){
			list.add(node.val) ;
		}
	 
		return list;
        
    }

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(3);
		node1.left.left = new TreeNode(4);
		node1.left.right = new TreeNode(5);
		node1.right.left = new TreeNode(6);
		node1.right.right = new TreeNode(7);
		node1.left.left.left = new TreeNode(8);
		node1.left.left.right = new TreeNode(9);

		// 124895367
		List<Integer> list = preorderTraversal(node1);
		for (Integer num : list) {
			System.out.print(num + " ");
		}

	}

}
