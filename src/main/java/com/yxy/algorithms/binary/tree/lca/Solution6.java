package com.yxy.algorithms.binary.tree.lca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
 * 
 * Copy from:
 * https://discuss.leetcode.com/topic/44601/java-iterative-and-recursive-solutions
 */
public class Solution6 {
	// beats 3.57%
	// recursively
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null || root == p || root == q) {
	        return root;
	    }
	    TreeNode l = lowestCommonAncestor(root.left, p, q);
	    TreeNode r = lowestCommonAncestor(root.right, p, q);
	    return l != null && r != null?root : l == null?r: l;
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == p || root == q) {
	        return root;
	    }
	    int count = leftCount(root.left, p, q);
	    if (count == 0) {
	        return lowestCommonAncestor(root.right, p, q);
	    } else if (count == 2) {
	        return lowestCommonAncestor(root.left, p, q);
	    } else {
	        return root;
	    }
	}

	private int leftCount(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null) {
	        return 0;
	    }
	    if (root == p && root == q) {
	        return 2;
	    }
	    if (root == p || root == q) {
	        return 1 + leftCount(root.left, p, q) + leftCount(root.right, p, q);
	    }
	    return leftCount(root.left, p, q) + leftCount(root.right, p, q);
	}

}
