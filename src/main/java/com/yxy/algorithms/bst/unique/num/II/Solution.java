package com.yxy.algorithms.bst.unique.num.II;

import java.util.ArrayList;
import java.util.List;

import com.yxy.algorithms.binary.tree.TreeNode;

public class Solution {
	
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ret = new ArrayList<TreeNode>() ;
		TreeNode init = new TreeNode(1) ;
//		ret.add(init) ;
//		
//		for(int i=0, num=2; i<ret.size() && num<=n; i++){
//			TreeNode root = ret.get(i) ;
//			
//			
//		}
		
		build(init, init, 2, n, ret) ;
		
		return ret ;
    }

	private void build(TreeNode root, TreeNode currNode, int newVal, int n, List<TreeNode> ret) {
		if(newVal>n){
			ret.add(root) ;
			return ;
		}
		
		
	}

	public static void main(String[] args) {

	}

}
