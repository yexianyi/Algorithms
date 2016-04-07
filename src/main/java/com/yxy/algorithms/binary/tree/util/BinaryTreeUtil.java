package com.yxy.algorithms.binary.tree.util;

import com.yxy.algorithms.binary.tree.TreeNode;

public final class BinaryTreeUtil {
	
	/**
	 * Creates binary tree
	 * @param node list
	 */
	public static TreeNode create(Integer[] nodes){
		TreeNode[] nodeArray = new TreeNode[nodes.length] ;
		for(int i=0; i<nodes.length; i++){
			if(nodes[i]!=null){
				nodeArray[i] = new TreeNode(nodes[i].intValue()) ; 
			}
		}
		
		int slow = 0 ;
		int fast = 1 ;
		
		TreeNode root = nodeArray[slow] ;
		for(; fast<nodes.length; fast++){
			if(fast%2 != 0){	//left
				if(nodes[fast]!=null){
					root.left = nodeArray[fast] ; 
				}
			}else{	//right
				if(nodes[fast]!=null){
					root.right = nodeArray[fast] ;
				}
				while(nodes[++slow]==null) ;
				root = nodeArray[slow] ;
			}
		}
		
		return nodeArray[0] ;
	}
	
	
	/**
	 * Print binary tree
	 * @param root node
	 */
	public static void print(TreeNode root){
		
	}
	

	public static void main(String[] args) {
		Integer[] nodes = {0,1,2,3,4,null,null,5} ;
		TreeNode root = create(nodes) ;
		
		System.out.println(root);

	}

}
