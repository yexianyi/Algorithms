package com.yxy.algorithms.binary.tree.same;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 	Same Tree My Submissions Question
	Total Accepted: 98481 Total Submissions: 233050 Difficulty: Easy
	Given two binary trees, write a function to check if they are equal or not.
	
	Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	
	Subscribe to see which companies asked this question
 * 
 * @author xianyiye
 *	2015/12/18
 */

public class Solution {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if((p==null ^ q==null) == true){
			return false ;
		}else if((p==null & q==null) == true){
		    return true ;
		}
		
		if(p.val == q.val){
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) ;
		}
		else{
			return false ;
		}
        
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
