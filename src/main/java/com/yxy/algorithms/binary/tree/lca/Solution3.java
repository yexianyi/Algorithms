package com.yxy.algorithms.binary.tree.lca;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
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
 * 
 * Copy from:
 * https://discuss.leetcode.com/topic/18561/4-lines-c-java-python-ruby
 */
public class Solution3 {

	//beats 76.12%
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		return left != null && right != null ? root : left == null ? right : left;
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTreeUtil.create(new Integer[]{37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8}, TreeNode.class) ;
		BinaryTreeUtil.print(root);
		System.out.println(lowestCommonAncestor(root, root.right.left, root.right.right.left.left).val);
	}

}
