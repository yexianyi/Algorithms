package com.yxy.algorithms.binary.tree.count.complete.tree.nodes;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;

/**
 * 222. Count Complete Tree Nodes
    Medium
    
    Given a complete binary tree, count the number of nodes.
    
    Note:
    
    Definition of a complete binary tree from Wikipedia:
    In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
    
    Example:
    
    Input: 
        1
       / \
      2   3
     / \  /
    4  5 6
    
    Output: 6

 * @author Ye Xianyi
 * 2020/07/08
 *
 * Reference:
 * https://www.cnblogs.com/grandyang/p/4567827.html
 */
public class Solution2 {

    // acceptable: beats 15.98%
    public static int countNodes(TreeNode root) {
        int leftHeight = 0 ;
        int rightHeight = 0 ;
        
        // calculate the height of left sub-tree 
        TreeNode rootCopy = root ; 
        while(rootCopy != null) {
            rootCopy = rootCopy.left ;
            leftHeight++ ;
        }
        
        // calculate the height of right sub-tree 
        TreeNode rootCopy2 = root ; 
        while(rootCopy2 != null) {
            rootCopy2 = rootCopy2.right ;
            rightHeight++ ;
        }
        
        // current tree is a full binary tree
        if(leftHeight == rightHeight) {
            return (1 << leftHeight) - 1 ;
        } 
        
        // current tree is a complete binary tree,
        // so, the total nodes should be the number of left tree + right tree.
        // However, we can do this process by repeat above step.
        return countNodes(root.left) + countNodes(root.right) + 1 ;
    }
    
    

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtil.create(new Integer[] { 1,2,3,4,5,6 }, TreeNode.class);
        System.out.println(countNodes(root)) ;
    }

}
