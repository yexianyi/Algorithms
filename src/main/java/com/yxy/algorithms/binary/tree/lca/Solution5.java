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
public class Solution5 {
	// beats 6.52%
	// iteratively 
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		parent.put(root, null);
		queue.add(root);
		while (!parent.containsKey(p) || !parent.containsKey(q)) {
			TreeNode node = queue.poll();
			if (node != null) {
				parent.put(node.left, node);
				parent.put(node.right, node);
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		Set<TreeNode> set = new HashSet<>();
		while (p != null) {
			set.add(p);
			p = parent.get(p);
		}
		while (!set.contains(q)) {
			q = parent.get(q);
		}
		return q;
	}

	public static void main(String[] args) {

	}

}
