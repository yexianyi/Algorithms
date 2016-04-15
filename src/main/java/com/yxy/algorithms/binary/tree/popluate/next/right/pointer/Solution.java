package com.yxy.algorithms.binary.tree.popluate.next.right.pointer;

import com.yxy.algorithms.binary.tree.TreeLinkNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 116. Populating Next Right Pointers in Each Node My Submissions QuestionEditorial Solution
	Total Accepted: 85031 Total Submissions: 233129 Difficulty: Medium
	Given a binary tree
	
	    struct TreeLinkNode {
	      TreeLinkNode *left;
	      TreeLinkNode *right;
	      TreeLinkNode *next;
	    }
	Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	
	Initially, all next pointers are set to NULL.
	
	Note:
	
	You may only use constant extra space.
	You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
	For example,
	Given the following perfect binary tree,
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \  / \
	    4->5->6->7 -> NULL
 * @author xianyiye
 * @date 04/14/2016
 */
public class Solution {

	public static void connect(TreeLinkNode root) {
		
		if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null){
            root.right.next = root.next==null ? null : root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
    }
	
	public static void main(String[] args) {
		TreeLinkNode root = BinaryTreeUtil.create(new Integer[]{1,2,3,4,5,6,7}, TreeLinkNode.class) ;
		connect(root) ;
		BinaryTreeUtil.print(root);

	}

}
