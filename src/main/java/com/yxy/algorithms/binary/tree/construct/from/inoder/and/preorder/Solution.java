package com.yxy.algorithms.binary.tree.construct.from.inoder.and.preorder;

import java.util.HashMap;
import java.util.Map;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal My Submissions QuestionEditorial Solution
	Total Accepted: 67426 Total Submissions: 230786 Difficulty: Medium
	Given preorder and inorder traversal of a tree, construct the binary tree.
	
	Note:
	You may assume that duplicates do not exist in the tree.
 * @author xianyiye
 * @date 06/29/2016
 * 
 * Reference:
 * https://leetcode.com/discuss/12179/my-accepted-java-solution
 * https://leetcode.com/discuss/29229/concise-java-recursive-solution
 */
public class Solution {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>() ;
		for(int i=0; i<inorder.length; i++){
			inMap.put(inorder[i], i) ;
		}
		
		
		return build(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, inMap) ;
    }
	
	/**
	 * The Root of the tree is the first element in Preorder Array.
		Find the position of the Root in Inorder Array.
		Elements to the left of Root element in Inorder Array are the left subtree.
		Elements to the right of Root element in Inorder Array are the right subtree.
		Call recursively buildTree on the subarray composed by the elements in the left subtree. Attach returned left subtree root as left child of Root node.
		Call recursively buildTree on the subarray composed by the elements in the right subtree. Attach returned right subtree root as right child of Root node.
		return Root.
	 */
	private TreeNode build(int[] inorder, int inStart, int inEnd, int[] pretorder, int pStart, int pEnd, Map<Integer, Integer> inMap){
		if (pStart>pEnd || inStart>inEnd) {
			return null;
		}
		
		int rootVal = pretorder[pStart] ;
		int rootIdx = inMap.get(rootVal) ;
		TreeNode root = new TreeNode(rootVal) ;
		
		//construct left branch
		root.left = build(inorder, inStart, rootIdx-1, pretorder, pStart+1, pStart+rootIdx-inStart, inMap) ;
		//construct right branch
		root.right = build(inorder, rootIdx+1, inEnd,  pretorder, pStart+rootIdx-inStart+1, pEnd, inMap) ;
				
		
		return root ;
	}
	
	

	public static void main(String[] args) {
		Solution s = new Solution() ;
		TreeNode root = s.buildTree(new int[]{1,2,4,7,8,5,9,3,6}, new int[]{7,4,8,2,5,9,1,3,6}) ;
//		TreeNode root = s.buildTree(new int[]{1,2,3,4}, new int[]{4,3,2,1}) ;
		BinaryTreeUtil.print(root);
	}

}
