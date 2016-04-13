package com.yxy.algorithms.binary.tree.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		Stack<List<TreeNode>> stack = new Stack<List<TreeNode>>() ;
		List<TreeNode> list = new ArrayList<TreeNode>() ;
		list.add(root) ;
		stack.push(list) ;
		
		while(!stack.isEmpty()){
			list = stack.pop() ;
			boolean hasNotNullNode = false ;
			for(TreeNode node : list){
				if(node!=null){
					hasNotNullNode = true ;
					break ;
				}
			}
			
			if(hasNotNullNode){
				List<TreeNode> newList = new ArrayList<TreeNode>() ;
				for(TreeNode node:list){
					if(node==null){
						System.out.print(" null");
					}else{
						System.out.print(" "+node.val);
						newList.add(node.left) ;
						newList.add(node.right) ;
					}
				}
				stack.push(newList) ;
			}
			System.out.println();
		}
	}
	

//	public static void main(String[] args) {
//		Integer[] nodes = {0} ;
//		TreeNode root = create(nodes) ;
//		
//		print(root);
//
//	}

}
