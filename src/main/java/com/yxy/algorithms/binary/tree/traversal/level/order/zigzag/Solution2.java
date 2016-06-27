package com.yxy.algorithms.binary.tree.traversal.level.order.zigzag;

import java.util.ArrayList;
import java.util.List;

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
public class Solution2 {
	
	//beats 95%
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		travel(root, 0, ret) ;
		
		return ret ;
    }

	private static void travel(TreeNode node, int level, List<List<Integer>> ret){
		if(node==null){
			return ;
		}
		List<Integer> list = null ;
		if(ret.size()<=level){
			list = new ArrayList<Integer>() ; //ArrayList has greater performance than LinkedList
			ret.add(list) ;
		}else{
			list = ret.get(level) ;
		}
		
		if(level%2==0){ //left -> right
			list.add(node.val) ;
		}else{
			list.add(0, node.val) ;
		}
		
		travel(node.left, level+1, ret) ;
		travel(node.right, level+1, ret) ;
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
