package com.yxy.algorithms.binary.tree.traversal.level.order.zigzag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 103. Binary Tree Zigzag Level Order Traversal My Submissions QuestionEditorial Solution
	Total Accepted: 64210 Total Submissions: 218864 Difficulty: Medium
	Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
	
	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
	
 * @author xianyiye
 * @date 06/27/2016
 * 
 */
public class Solution {
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
		if(root!=null) {
			queue.add(root) ;
		}
		
		boolean fromRight = true ;
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		Stack<TreeNode> tempNodes = new Stack<TreeNode>() ;
		
		while(!queue.isEmpty()){
			while(!queue.isEmpty()){
				tempNodes.push(queue.poll()) ;
			}
			
			List<Integer> list = new ArrayList<Integer>() ;
			for(TreeNode node : tempNodes){
				list.add(node.val) ;
			}
			if(list.size()>0){
				ret.add(list) ;
			}
			
			while(!tempNodes.isEmpty()){
				TreeNode node = tempNodes.pop() ;
				if(fromRight){
					if(node.right!=null)
						queue.offer(node.right);
					if(node.left!=null)
						queue.offer(node.left);
				}else{
					if(node.left!=null)
						queue.offer(node.left);
					if(node.right!=null)
						queue.offer(node.right);
				}
			}
			
			fromRight = !fromRight ;
		}
		
		
		return ret ;
    }


	public static void main(String[] args) {
		TreeNode root = BinaryTreeUtil.create(new Integer[]{1,2,3,4,5,null,6,7,null,8,9}, TreeNode.class) ;
		BinaryTreeUtil.print(root);
		List<List<Integer>> ret = zigzagLevelOrder(root) ;
		
		for(List<Integer> list : ret){
			for(Integer num : list){
				System.out.print(num+" ");
			}
			System.out.println() ;
		}
		
	}

}
