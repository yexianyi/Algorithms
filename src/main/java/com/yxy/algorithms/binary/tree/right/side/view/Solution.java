package com.yxy.algorithms.binary.tree.right.side.view;

import java.util.ArrayList;
import java.util.List;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 199. Binary Tree Right Side View   My Submissions QuestionEditorial Solution
	Total Accepted: 40831 Total Submissions: 118551 Difficulty: Medium
	Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
	
	For example:
	Given the following binary tree,
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
	You should return [1, 3, 4].


 * @author xianyiye
 * @date 04/29/2016
 */
public class Solution {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>() ; //Using ArrayList will be more efficient.
        travel(list, root, 0) ;
		
		return list ;
    }
	
	private void travel(List<Integer> list, TreeNode node, int currHeight){
		if(node==null){
			return ;
		}
		
		if(list.size() == currHeight){
			list.add(node.val) ;
		}
		
		travel(list, node.right, currHeight+1) ;
		travel(list, node.left, currHeight+1) ;
	}
	

	public static void main(String[] args) {
		TreeNode root = BinaryTreeUtil.create(new Integer[]{1,2,3,4}, TreeNode.class) ;
		List<Integer> list = new Solution().rightSideView(root) ;
		for(int item : list){
			System.out.print(item+" ");
		}
	}

}
