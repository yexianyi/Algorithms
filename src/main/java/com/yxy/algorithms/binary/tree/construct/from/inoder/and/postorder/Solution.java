package com.yxy.algorithms.binary.tree.construct.from.inoder.and.postorder;

import java.util.HashMap;
import java.util.Map;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal My Submissions QuestionEditorial Solution
	Total Accepted: 58075 Total Submissions: 197222 Difficulty: Medium
	Given inorder and postorder traversal of a tree, construct the binary tree.
	
	Note:
	You may assume that duplicates do not exist in the tree.
	
 * @author xianyiye
 * @date 06/23/2016
 * 
 */
public class Solution {

	//timeout
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>() ;
		for(int i=0; i<inorder.length; i++){
			inMap.put(inorder[i], i) ;
		}
		
		Map<Integer, Integer> postMap = new HashMap<Integer, Integer>() ;
		for(int i=0; i<postorder.length; i++){
			postMap.put(postorder[i], i) ;
		}
		
		return build(inorder, 0, inorder.length-1, postorder, inMap, postMap) ;
    }
	
	
	private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, Map<Integer, Integer> inMap, Map<Integer, Integer> postMap){
		if(inStart>inEnd){
			return null ;
		}
		
		if(inStart==inEnd){
			return new TreeNode(inorder[inStart]) ;
		}
		
		int maxIdxInPost = Integer.MIN_VALUE ;
		for(int i=inStart; i<=inEnd; i++){
			if(postMap.get(inorder[i])>maxIdxInPost){
				maxIdxInPost = postMap.get(inorder[i]) ;
			}
		}
		
		int rootVal = postorder[maxIdxInPost] ;
		int rootIdx = inMap.get(rootVal) ;
		TreeNode root = new TreeNode(rootVal) ;
		
		//construct left branch
		root.left = build(inorder, inStart, rootIdx-1, postorder, inMap, postMap) ;
		
		//construct right branch
		root.right = build(inorder, rootIdx+1, inEnd, postorder, inMap, postMap) ;
		
		return root ;
	}

	public static void main(String[] args) {

		Solution s = new Solution() ;
//		TreeNode root = s.buildTree(new int[]{7,4,2,8,5,9,1,3,6}, new int[]{7,4,8,9,5,2,6,3,1}) ;
		TreeNode root = s.buildTree(new int[]{1,2,3,4}, new int[]{4,3,2,1}) ;
		BinaryTreeUtil.print(root);
	}

}
