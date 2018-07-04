package com.yxy.algorithms.binary.tree.max.distance;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;

/**
 * 543. Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.

	Example:
	Given a binary tree 
	          1
	         / \
	        2   3
	       / \     
	      4   5    
	Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
	
	Note: The length of path between two nodes is represented by the number of edges between them.
	
 * @author Ye Xianyi
 *
 */

public class Solution {
	
	static int Maxdis = 0;  
	
	
	public static void getMaxDistance(TreeNode root) {
		int ldis=0,rdis=0;
		if(root==null)
			return ;
		
		if(root.left!=null){
			ldis=getMaxDepth(root.left);
		}
		
		if(root.right!=null){
			rdis=getMaxDepth(root.right);
		}

		if((ldis+rdis)>Maxdis)
			Maxdis=ldis+rdis;

		getMaxDistance(root.left);
		getMaxDistance(root.right);

	}
	
	
	static int getMaxDepth(TreeNode node)  
	{  
	    int depth=0;  
	    if(node!=null)  
	    {  
	        int l=getMaxDepth(node.left);  
	        int r=getMaxDepth(node.right);  
	        depth=(l>r)?l:r;  
	        depth++;  
	    }  
	    return depth;  
	} 

	

	public static void main(String[] args) {
		Integer[] nodes = {1,2,3,4,5,6,7,8} ;
		TreeNode root = BinaryTreeUtil.create(nodes, TreeNode.class) ;
		getMaxDistance(root) ;
		System.out.println(Maxdis) ;
	}

}
