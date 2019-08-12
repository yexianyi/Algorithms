package com.yxy.algorithms.binary.tree.validate.bst;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;

/**
 * 98. Validate Binary Search Tree
    Given a binary tree, determine if it is a valid binary search tree (BST).
    
    Assume a BST is defined as follows:
    
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
     
    
    Example 1:
    
        2
       / \
      1   3
    
    Input: [2,1,3]
    Output: true
    Example 2:
    
        5
       / \
      1   4
         / \
        3   6
    
    Input: [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.
 * @author yexianyi
 * 2019/08/12
 * 
 * Copy from:
 * https://leetcode.com/problems/validate-binary-search-tree/discuss/356166/Runtime-0ms-Java
 */
public class Solution {

    public static boolean isValidBST(TreeNode root) {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        if (node.val < min || node.val > max)
            return false;
        return (isValidBST(node.right, (long) node.val + 1, max) 
                && 
                isValidBST(node.left, min, (long) node.val - 1));

    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtil.create(new Integer[] { 2, 1, 3 }, TreeNode.class);
        BinaryTreeUtil.print(root);
        System.out.println(isValidBST(root));

        root = BinaryTreeUtil.create(new Integer[] { 5, 1, 4, null, null, 3, 6 }, TreeNode.class);
        BinaryTreeUtil.print(root);
        System.out.println(isValidBST(root));

    }

}
