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
public class Solution4 {

	//beats 32.74%
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//base case
        if (root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTreeUtil.create(new Integer[]{3,5,1,6,2,0,8,null, null, 7, 4, null, null, null, null}, TreeNode.class) ;
		BinaryTreeUtil.print(root);
		System.out.println(lowestCommonAncestor(root, root.left.right.left, root.left.right.right).val);
	}

}
