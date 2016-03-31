package com.yxy.algorithms.binary.tree.house.robber.III;

import java.util.HashMap;
import java.util.Map;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 	337. House Robber III My Submissions QuestionEditorial Solution
	Total Accepted: 5506 Total Submissions: 14911 Difficulty: Medium
	The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
	
	Determine the maximum amount of money the thief can rob tonight without alerting the police.
	
	Example 1:
	     3
	    / \
	   2   3
	    \   \ 
	     3   1
	Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
	Example 2:
	     3
	    / \
	   4   5
	  / \   \ 
	 1   3   1
	Maximum amount of money the thief can rob = 4 + 5 = 9.
 * @author xianyiye
 * @Date 03/31/2016
 * Runtime：7ms
 * Copied from:
 * https://leetcode.com/discuss/93873/java-concise-memoization-dp-solution-7ms
 */

public class Solution3 {
	
	 private Map<TreeNode, Integer> memo = new HashMap<>();

	    public int rob(TreeNode root) {
	        if(root==null) return 0;
	        if(root.left==null && root.right==null) return root.val;
	        if(memo.containsKey(root)) {
	        	return memo.get(root);
	        }

	        //case 1
	        int sum1 = root.val;
	        if(root.left!=null){
	            sum1 += rob(root.left.left) + rob(root.left.right);
	        }
	        if(root.right!=null){
	            sum1 += rob(root.right.left) + rob(root.right.right);
	        }

	        //case 2
	        int sum2 = rob(root.left) + rob(root.right);

	        int sum = Math.max(sum1, sum2);
	        memo.put(root, sum);
	        return sum;
	    }


	public static void main(String[] args) {
		//
//		TreeNode root = new TreeNode(3) ;
//		root.left = new TreeNode(2)  ;
//		root.right = new TreeNode(3) ;
//		root.left.right = new TreeNode(3) ;
//		root.right.right = new TreeNode(1) ;
		
		//[4,1,null,2,null,3]
//		TreeNode root = new TreeNode(4) ;
//		root.left = new TreeNode(1)  ;
//		root.left.left = new TreeNode(2) ;
//		root.left.left.left = new TreeNode(3) ;
		
		//[4,1,null,2,null,3]
		TreeNode root = new TreeNode(3) ;
		root.left = new TreeNode(4)  ;
		root.right = new TreeNode(5) ;
		root.left.left = new TreeNode(1) ;
		root.left.right = new TreeNode(3) ;
		root.right.right = new TreeNode(1) ;
		
		System.out.println(new Solution3().rob(root));

	}

}
