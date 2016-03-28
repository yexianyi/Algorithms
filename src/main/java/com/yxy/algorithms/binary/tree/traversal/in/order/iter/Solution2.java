package com.yxy.algorithms.binary.tree.traversal.in.order.iter;


import java.util.ArrayList;
import java.util.List;
import com.yxy.algorithms.binary.tree.TreeNode;
/**
	 * 94. Binary Tree Inorder Traversal My Submissions QuestionEditorial Solution
	Total Accepted: 117123 Total Submissions: 298402 Difficulty: Medium
	Given a binary tree, return the inorder traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 * @author xianyiye
 * @Date 03/28/2016
 * 
 * Reference:
 * https://leetcode.com/discuss/58964/o-n-solution-with-o-1-space-using-morris-traversal
 */

public class Solution2 {
	
	/**
	 * First read this article and look at the code. http://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion

		The ideas is as follows: There are 3 important points in the program:
		
		1. For any Node if the left subtree is absent, this goes to if loop and adds the value to the result and move pointer to right node.
		
		2. If you look closer at 2 and 3, they are similar. This is where the magic takes place. 
		A link is established to the right most child back to the root node. 
		This is removed at this point and moves to the right node of the root.
		
		3. This is responsible for creating a right pointer for the right most child and moves the pointer to the left of child.
	 * @param root
	 * @return
	 */
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		 TreeNode node = root;
	       List<Integer> list = new ArrayList<Integer>();
	       while (node != null) {
	           // POINT 1
	           if (node.left == null) {
	               list.add(node.val);
	               node = node.right;
	           } else {
	               TreeNode temp = node.left;
	               while (temp.right != null && temp.right != node) temp = temp.right;
	               // POINT 2
	               if (temp.right == node) {
	                   temp.right = null;
	                   list.add(node.val);
	                   node = node.right;
	               // POINT 3
	               } else {
	                   temp.right = node;
	                   node = node.left;
	               }

	           }
	       }
	       return list;
    }
	
	public static List<Integer> inorderTraversal2(TreeNode node) {
		List<Integer> list = new ArrayList();

	    while(node != null) {
	        if(node.left == null) {
	            list.add(node.val);
	            node = node.right;
	        }
	        else {
	            TreeNode nextNode = node.left;
	            TreeNode p = nextNode;

	            while(p.right != null) p = p.right;
	            p.right = node;
	            node.left = null;
	            node = nextNode;
	        }
	    }
	    return list;
   }

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1) ;
		node1.left = new TreeNode(2)  ;
		node1.right = new TreeNode(3) ;
		node1.left.left = new TreeNode(4) ;
		node1.left.right = new TreeNode(5) ;
		node1.right.left = new TreeNode(6) ;
		node1.right.right = new TreeNode(7) ;
		node1.left.left.left = new TreeNode(8) ;
		node1.left.left.right = new TreeNode(9) ;
		
		//849251637
		List<Integer> list = inorderTraversal(node1) ;
		for(Integer num : list){
			System.out.print(num+" ");
		}

	}

}
