package com.yxy.algorithms.binary.tree.construct.from.inoder.and.postorder;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
 * Copy from:
 * https://leetcode.com/discuss/15115/my-comprehension-of-o-n-solution-from-%40hongzhi
 */
public class Solution3 {

	//To be understood
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		   if (inorder == null || inorder.length < 1) return null;
	        int i = inorder.length - 1;
	        int p = i;
	        TreeNode node;
	        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        p--;

	        while (true) {
	            if (inorder[i] == stack.peek().val) { // inorder[i] is on top of stack, pop stack to get its parent to get to left side
	                if (--i < 0) break;
	                node = stack.pop();
	                if (!stack.isEmpty() && inorder[i] == stack.peek().val) {// continue pop stack to get to left side
	                    continue;
	                }
	                node.left = new TreeNode(postorder[p]);
	                stack.push(node.left);
	            } else { // inorder[i] is not on top of stack, postorder[p] must be right child
	                node = new TreeNode(postorder[p]);
	                stack.peek().right = node;
	                stack.push(node);
	            }
	            p--;
	        }

	        return root;
    }
	
	
	public static void main(String[] args) {

		Solution3 s = new Solution3() ;
//		TreeNode root = s.buildTree(new int[]{7,4,2,8,5,9,1,3,6}, new int[]{7,4,8,9,5,2,6,3,1}) ;
		TreeNode root = s.buildTree(new int[]{1,2,3,4}, new int[]{4,3,2,1}) ;
		BinaryTreeUtil.print(root);
	}

}
