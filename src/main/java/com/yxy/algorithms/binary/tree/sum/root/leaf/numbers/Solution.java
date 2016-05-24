package com.yxy.algorithms.binary.tree.sum.root.leaf.numbers;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 129. Sum Root to Leaf Numbers My Submissions QuestionEditorial Solution
	Total Accepted: 77034 Total Submissions: 234214 Difficulty: Medium
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	
	An example is the root-to-leaf path 1->2->3 which represents the number 123.
	
	Find the total sum of all root-to-leaf numbers.
	
	For example,
	
	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.
	
	Return the sum = 12 + 13 = 25.

 * @author xianyiye
 * @date 05/24/2016
 */
public class Solution {
	
	public static int sumNumbers(TreeNode root) {
        if(root!=null){
        	return sumNumbers(root, 0) ;
        }
        return 0 ;
    }
	
	//Divide and Conquer
	private static int sumNumbers(TreeNode node, int sum){
		if(node.left==null && node.right==null){
			return sum*10+node.val ;
		}
		int left = 0 ;
		int right = 0;
		if(node.left!=null){
			left = sumNumbers(node.left, sum*10+node.val) ;
		}
		
		if(node.right!=null){
			right = sumNumbers(node.right, sum*10+node.val) ;
		}
		
		return left+right ;
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTreeUtil.create(new Integer[]{1,2,3,4,5,6,7}, TreeNode.class) ;
		System.out.println(sumNumbers(root));
	}

}
