package com.yxy.algorithms.bst.kth.smallest.elem;

/**
 * 230. Kth Smallest Element in a BST My Submissions QuestionEditorial Solution
	Total Accepted: 41706 Total Submissions: 112507 Difficulty: Medium
	Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
	
	Note: 
	You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	
	Follow up:
	What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
	
	Hint:
	
	Try to utilize the property of a BST.
	What if you could modify the BST node's structure?
	The optimal runtime complexity is O(height of BST).
	
 * @author Xianyi Ye
 * @Date 03/30/2016
 */

import com.yxy.algorithms.binary.tree.TreeNode;

public class Solution {
	
	private int count = 0;
	private int result = -1;

	public int kthSmallest(TreeNode root, int k) {

		if (count<k && root.left != null) {
			kthSmallest(root.left, k);
		}
			//System.out.print(root.val+",");  
	    if(++count==k){
	    	result = root.val ;
	    }
			
		if (count<k && root.right != null) {	
			kthSmallest(root.right, k);
		}

		return result;
    }

	public static void main(String[] args) {
		//2,3,4,5,6,7,9
		TreeNode root = new TreeNode(4) ;
		root.left = new TreeNode(3) ;
		root.right = new TreeNode(7) ;
		root.left.left = new TreeNode(2) ;
		root.right.left = new TreeNode(5) ;
		root.right.right = new TreeNode(9) ;
		root.right.left.right = new TreeNode(6) ;
		
		System.out.println(new Solution().kthSmallest(root,1)) ;

	}

}
