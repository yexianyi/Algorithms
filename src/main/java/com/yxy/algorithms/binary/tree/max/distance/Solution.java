package com.yxy.algorithms.binary.tree.max.distance;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;

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
