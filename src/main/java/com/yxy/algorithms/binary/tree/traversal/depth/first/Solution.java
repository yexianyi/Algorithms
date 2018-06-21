package com.yxy.algorithms.binary.tree.traversal.depth.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;

public class Solution {
	
	public static List<Integer> depthFirstTravel(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>() ;
		Stack<TreeNode> stack = new Stack<TreeNode>() ;
		stack.push(root) ;
		TreeNode node = null ;
		while(stack.size()!=0) {
			node = stack.pop() ;
			list.add(node.val);
			if(node.right!=null) {
				stack.push(node.right) ;
			}
			
			if(node.left!=null) {
				stack.push(node.left) ;
			}
		}
		
		
		return list;
		
	}
	
	

	public static void main(String[] args) {
		Integer[] nodes = {1,2,3,4,5,6,7,8} ;
		TreeNode root = BinaryTreeUtil.create(nodes, TreeNode.class) ;
		List<Integer> list = depthFirstTravel(root) ;
		for(Integer val : list) {
			System.out.print(val+" ");
		}
	}

}
