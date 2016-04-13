package com.yxy.algorithms.bst.creation.convert.from.sorted.array;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;

/**
 * 108. Convert Sorted Array to Binary Search Tree My Submissions QuestionEditorial Solution
	Total Accepted: 73125 Total Submissions: 197287 Difficulty: Medium
	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author xianyiye
 * @date 04/13/2016
 */

public class Solution {

	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0){
			return null;
		}
		
		//init
		TreeNode[] nodes = new TreeNode[nums.length] ;
		for(int i=0; i<nums.length; i++){
			nodes[i] = new TreeNode(nums[i]) ;
		}
		
		TreeNode root = nodes[(nodes.length-1)/2] ;
		generateBST(nodes,0, nodes.length-1);
		
		return root ;
    }
	
	
	private static void generateBST(TreeNode[] nodes, int start, int end) {
		if(start>=end){
			return ;
		}
		
		int mid = (start+end)/2 ;
		int l_pos = (start+mid-1)/2 ;
		int r_pos = (mid+1+end)/2 ;
		
		TreeNode root = nodes[mid] ;
		if(mid>start){
			root.left = nodes[l_pos] ;
		}
		if(mid<=end){
			root.right = nodes[r_pos] ;
		}
		
		generateBST(nodes, start, mid-1) ;
		generateBST(nodes, mid+1, end) ;
		
	}


	public static void main(String[] args) {
		TreeNode root = sortedArrayToBST(new int[]{12,24,37,45,53,93,100,112}) ;
		BinaryTreeUtil.print(root) ;
		root = sortedArrayToBST(new int[]{1,3}) ;
		BinaryTreeUtil.print(root) ;
		root = sortedArrayToBST(new int[]{3,5,8}) ;
		BinaryTreeUtil.print(root) ;
	}

}
