package com.yxy.algorithms.binary.tree.lca;

import com.yxy.algorithms.binary.tree.TreeNode;
/**
 * 236. Lowest Common Ancestor of a Binary Tree  QuestionEditorial Solution  My Submissions
	Total Accepted: 48657
	Total Submissions: 168941
	Difficulty: Medium
	Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
	
	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
	
	        _______3______
	       /              \
	    ___5__          ___1__
	   /      \        /      \
	   6      _2       0       8
	         /  \
	         7   4
	For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

 * @author xianyiye
 * @date 07/08/2016
 */
public class Solution {
	
	//timeout
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
		if(findNode(root.left, p) && findNode(root.left, q)){
			return lowestCommonAncestor(root.left, p, q) ; //p and q both in LEFT tree
		}
		
		if(findNode(root.right, p) && findNode(root.right, q)){
			return lowestCommonAncestor(root.right, p, q) ;  //p and q both in RIGHT tree
		}
		
		return root ;  //p and q in LEFT and RIGHT respectively.
    }
	
	private static boolean findNode(TreeNode root, TreeNode node){
		if(root==null){
			return false ;
		}
		
		if(root==node){
			return true ;
		}
		
		return findNode(root.left, node) || findNode(root.right, node) ;
		
	}

	public static void main(String[] args) {
		
	}

}
