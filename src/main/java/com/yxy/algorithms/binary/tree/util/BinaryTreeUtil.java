package com.yxy.algorithms.binary.tree.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.yxy.algorithms.binary.tree.TreeLinkNode;
import com.yxy.algorithms.binary.tree.TreeNode;

public final class BinaryTreeUtil {
	
	/**
	 * Creates binary tree
	 * @param node list
	 */
	public static <T> T create(Integer[] nodes, Class<T> theClass){
		//TreeNode[] nodeArray = new TreeNode[nodes.length] ;
		T[] nodeArray = (T[]) Array.newInstance(theClass, nodes.length) ;
		for(int i=0; i<nodes.length; i++){
			if(nodes[i]!=null){
				//nodeArray[i] = new TreeNode(nodes[i].intValue()) ; 
				try {
					nodeArray[i] = theClass.getDeclaredConstructor(Integer.TYPE).newInstance(nodes[i].intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		int slow = 0 ;
		int fast = 1 ;
		
		T root = nodeArray[slow] ;
		for(; fast<nodes.length; fast++){
			if(fast%2 != 0){	//left
				if(nodes[fast]!=null){
					//root.left = nodeArray[fast] ; 
					try {
						Field lField = root.getClass().getField("left");
						lField.set(root, nodeArray[fast]);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}else{	//right
				if(nodes[fast]!=null){
					//root.right = nodeArray[fast] ;
					try {
						Field rField = root.getClass().getField("right");
						rField.set(root, nodeArray[fast]);
					} catch (Exception e) {
						e.printStackTrace();
					}
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
	public static <T> void print(T rootNode){
		Stack<List<T>> stack = new Stack<List<T>>() ;
		List<T> list = new ArrayList<T>() ;
		list.add(rootNode) ;
		stack.push(list) ;
		
		while(!stack.isEmpty()){
			list = stack.pop() ;
			boolean hasNotNullNode = false ;
			for(T node : list){
				if(node!=null){
					hasNotNullNode = true ;
					break ;
				}
			}
			
			if(hasNotNullNode){
				List<T> newList = new ArrayList<T>() ;
				for(T node:list){
					if(node==null){
						System.out.print(" null");
					}else{
						try {
							Field vfield = node.getClass().getField("val");
							System.out.print(" "+vfield.getInt(node));
							
							Field lfield = node.getClass().getField("left");
							newList.add((T) lfield.get(node)) ;
							
							Field rfield = node.getClass().getField("right");
							newList.add((T) rfield.get(node)) ;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				stack.push(newList) ;
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		Integer[] nodes = {0,1,2,3,4,5,6} ;
		TreeNode root = create(nodes, TreeNode.class) ;
		print(root);
		
		TreeLinkNode root2 = create(nodes, TreeLinkNode.class) ;
		print(root2);

	}

}
