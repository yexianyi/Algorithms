package com.yxy.algorithms.binary.tree.path.sum.II;

import java.util.ArrayList;
import java.util.List;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 113. Path Sum II My Submissions QuestionEditorial Solution
	Total Accepted: 85733 Total Submissions: 296966 Difficulty: Medium
	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]

 * @author xianyiye
 * @date 06/29/2016
 */
public class Solution {

	//beats 38.48%
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		if(root!=null){
			findPath(root, 0, sum, new ArrayList<Integer>(), ret) ;
		}
		
		return ret ;
    }
	
	private static void findPath(TreeNode node, int currSum, int targetSum, List<Integer> list, List<List<Integer>> ret){
		if(node==null){
			return ;
		}
		
		list.add(node.val) ;
		currSum += node.val ;
		
		if(node.left==null && node.right==null && currSum==targetSum){
			ret.add(new ArrayList<Integer>(list)) ;
			list.remove(list.size()-1) ;
			return ;
		}
		
		findPath(node.left, currSum, targetSum, list, ret) ;
		findPath(node.right, currSum, targetSum, list, ret) ;
		
		list.remove(list.size()-1) ;
	}
	
	

	public static void main(String[] args) {
		TreeNode root = BinaryTreeUtil.create(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}, TreeNode.class) ;
//		TreeNode root = BinaryTreeUtil.create(new Integer[]{-2,null,-3}, TreeNode.class) ;
		List<List<Integer>> ret = pathSum(root, 22) ;
		for(List<Integer> list : ret){
			for(int num : list){
				System.out.print(num+" ") ;
			}
			System.out.println() ;
		}

	}

}
