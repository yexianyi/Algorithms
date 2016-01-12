package com.yxy.algorithms.binary.tree.path.travel;

import java.util.ArrayList;
import java.util.List;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 	257. Binary Tree Paths My Submissions Question
	Total Accepted: 29582 Total Submissions: 114391 Difficulty: Easy
	Given a binary tree, return all root-to-leaf paths.
	
	For example, given the following binary tree:
	
	   1
	 /   \
	2     3
	 \
	  5
	All root-to-leaf paths are:
	
	["1->2->5", "1->3"]
	
 * @author xianyiye
 * 2016/1/12
 */
public class Solution {
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> allPaths = new ArrayList<String>() ;
		travelTree(root, "", allPaths) ;
		
		return allPaths ;
    }
	
	private void travelTree(TreeNode root, String path, List<String> paths){
		if(root==null){
			return ;
		}
		
		if(root.left==null && root.right==null){
			path += root.val ;
			paths.add(path) ;
		}else{
			path += root.val + "->" ;
			travelTree(root.left, path, paths) ;
			travelTree(root.right, path, paths) ;
		}
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1) ;
		root.left = new TreeNode(2) ;
		root.right = new TreeNode(3) ;
		root.left.left = new TreeNode(4) ;
		root.left.right = new TreeNode(5) ;
		root.right.left = new TreeNode(6) ;
		root.right.right = new TreeNode(7) ;
		
		Solution solution = new Solution() ;
		for(String path : solution.binaryTreePaths(root)){
			System.out.println(path) ;
		}

	}

}
