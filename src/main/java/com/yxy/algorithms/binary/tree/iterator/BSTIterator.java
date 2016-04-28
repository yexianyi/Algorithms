package com.yxy.algorithms.binary.tree.iterator;

import java.util.Stack;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 173. Binary Search Tree Iterator   My Submissions QuestionEditorial Solution
	Total Accepted: 47116 Total Submissions: 136405 Difficulty: Medium
	Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
	
	Calling next() will return the next smallest number in the BST.
	
	Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Reference:
 * https://leetcode.com/discuss/20101/ideal-solution-using-stack-java
 */

public class BSTIterator {
	
	private Stack<TreeNode> stack  = new Stack<TreeNode>() ;

    public BSTIterator(TreeNode root) {
        while(root!=null){
        	stack.push(root) ;
        	root = root.left ;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() ;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop() ;
        if(node.right != null){
        	TreeNode curr = node.right ;
        	while(curr!=null){
        		stack.push(curr) ;
        		curr = curr.left ;
        	}
        }
        
        return node.val ;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */