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
 * @date 06/24/2016
 * Reference:
 * https://leetcode.com/discuss/10961/my-recursive-java-code-with-o-n-time-and-o-n-space
 */
public class Solution2 {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>() ;
		for(int i=0; i<inorder.length; i++){
			inMap.put(inorder[i], i) ;
		}
		
		
		return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap) ;
    }
	
	
	private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd, Map<Integer, Integer> inMap){
		
		if (pStart>pEnd || inStart>inEnd) {
			return null;
		}
		
		int rootVal = postorder[pEnd] ;
		int rootIdx = inMap.get(rootVal) ;
		TreeNode root = new TreeNode(rootVal) ;
		
//		LEFT:  is, rootIdx-1, postorder, ps, ps+rootIdx-is-1,
//		RIGHT: rootIdx+1, ie, postorder, ps+rootIdx-is, pe-1, 
//		The post order array will give you the root, the last one.
//		With the root, you can go to the in order array, notice the traverse sequence: left, root, right. Then we know the left child array size, right child array size.
//		With the size, we can then divide the post order array: left, right, root. Then, we have everything!
//		The beauty is the root, with the root, you are able to divide two arrays~
		
		//construct left branch
		root.left = build(inorder, inStart, rootIdx-1, postorder, pStart, pStart+rootIdx-1-inStart, inMap) ;
		//construct right branch
		root.right = build(inorder, rootIdx+1, inEnd,  postorder, pStart+rootIdx-inStart, pEnd-1, inMap) ;
		
		return root ;
	}

	public static void main(String[] args) {

		Solution2 s = new Solution2() ;
//		TreeNode root = s.buildTree(new int[]{7,4,2,8,5,9,1,3,6}, new int[]{7,4,8,9,5,2,6,3,1}) ;
		TreeNode root = s.buildTree(new int[]{1,2,3,4}, new int[]{4,3,2,1}) ;
		BinaryTreeUtil.print(root);
	}

}
