package com.yxy.algorithms.binary.tree.house.robber.III;

import java.util.ArrayList;
import java.util.List;

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
 */

public class Solution {
	private int max = 0 ;
	
	/**
	 * This implementation is invalid!
	 * @param root
	 * @return
	 */
	public int rob(TreeNode root) {
		List<Integer> weights = new ArrayList<Integer>() ;
		if(root!=null){
			calLevelWeights(root, weights, 0) ;
			for(int i=0; i<weights.size(); i++){
				calMaxSum(weights, i, 0) ;
			}
			
		}
		
		return max ;
    }


	private void calLevelWeights(TreeNode node, List<Integer> weights, int kthLayer) {
		if(node==null){
			return ;
		}
		
		if(weights.size()<kthLayer+1){
			weights.add(0);
		}
		weights.set(kthLayer,weights.get(kthLayer)+node.val) ;
		
		calLevelWeights(node.left, weights, kthLayer+1) ;
		calLevelWeights(node.right, weights, kthLayer+1) ;
		
	}
	
	private void calMaxSum(List<Integer> weights, int currIndex, int sum) {
		if(currIndex<weights.size()){
			sum += weights.get(currIndex) ;
			if(sum>max){
				max = sum ;
			}
			for(int i=currIndex+2; i<weights.size(); i++){
				calMaxSum(weights, i, sum) ;
			}
		}
		
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
		
		System.out.println(new Solution().rob(root));

	}

}
