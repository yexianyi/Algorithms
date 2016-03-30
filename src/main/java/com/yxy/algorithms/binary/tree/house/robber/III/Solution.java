package com.yxy.algorithms.binary.tree.house.robber.III;

import java.util.ArrayList;
import java.util.List;

import com.yxy.algorithms.binary.tree.TreeNode;

public class Solution {
	
	
	public static int rob(TreeNode root) {
		List<Integer> weights = new ArrayList<Integer>() ;
		if(root!=null){
			weights.add(root.val) ;
			calLevelWeights(root, weights) ;
			
			for(int weight : weights){
				System.out.println(weight);
			}
		}
		
		return 0 ;
    }

	
	
	private static void calLevelWeights(TreeNode node, List<Integer> weights) {
		if(node==null){
			return ;
		}
		
		int total = 0  ;
		if(node.left!=null){
			total += node.left.val ;
		}
		
		if(node.right!=null){
			total += node.right.val ;
		}
		
		weights.add(total) ;
		
		calLevelWeights(node.left, weights) ;
		calLevelWeights(node.right, weights) ;
		
	}



	public static void main(String[] args) {
		TreeNode root = new TreeNode(3) ;
		root.left = new TreeNode(2)  ;
		root.right = new TreeNode(3) ;
		root.left.left = new TreeNode(3) ;
		root.right.right = new TreeNode(1) ;
		
		System.out.println(rob(root));

	}

}
