package com.yxy.algorithms.binary.tree.traversal.breadth.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;

public class Solution {
	
	public static List<Integer> breadthFirstTravel(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>() ;
		Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
		queue.offer(root) ;
		TreeNode node = null ;
		
		while(queue.size()>0) {
			node = queue.poll() ;
			list.add(node.val) ;
			
			if(node.left!=null) {
				queue.offer(node.left) ;
			}
			
			if(node.right!=null) {
				queue.offer(node.right) ;
			}
		}
		
		return list ;
	}
	

	public static void main(String[] args) {
		Integer[] nodes = {1,2,3,4,5,6,7,8} ;
		TreeNode root = BinaryTreeUtil.create(nodes, TreeNode.class) ;
		List<Integer> list = breadthFirstTravel(root) ;
		for(Integer val : list) {
			System.out.print(val+" ");
		}

	}

}
