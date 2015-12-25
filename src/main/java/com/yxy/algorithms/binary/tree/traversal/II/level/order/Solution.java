package com.yxy.algorithms.binary.tree.traversal.II.level.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) { 
		if(root==null){  
            return new ArrayList<List<Integer>>();  
        }  
		
		Stack<List<TreeNode>> stack = new Stack<List<TreeNode>>() ;
        List<TreeNode> subList = new ArrayList<TreeNode>() ;
        subList.add(root) ;// root
        stack.push(subList) ;
        
        while(true){
        	List<TreeNode> peekNodes = stack.peek() ; 
        	if(peekNodes!=null && peekNodes.size()>0){
        		subList = new ArrayList<TreeNode>() ;
        		for(TreeNode node : peekNodes){
        			if(node.left!=null){
                		subList.add(node.left) ;
                	}
                	
                	if(node.right!=null){
                		subList.add(node.right) ;
                	}
        		}
        		if(subList.size()>0){
        			stack.push(subList) ;
        		}else{
        			break ;
        		}
        	}
        	
        }//end while
        
        List<List<Integer>> list = new ArrayList<List<Integer>>() ;
    	while(!stack.isEmpty()){
    		List<TreeNode> nodes = stack.pop() ;
    		List<Integer> nums = new ArrayList<Integer>() ;
    		for(TreeNode node : nodes){
    			nums.add(node.val) ;
    		}
    		list.add(nums) ;
    	}
        
        
        return list ;
    }

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1) ;
		node1.left = new TreeNode(2)  ;
		node1.right = new TreeNode(3) ;
		node1.left.left = new TreeNode(4) ;
		node1.left.right = new TreeNode(5) ;
		node1.right.left = new TreeNode(6) ;
		node1.right.right = new TreeNode(7) ;
		node1.left.left.left = new TreeNode(8) ;
		node1.left.left.right = new TreeNode(9) ;
		
		List<List<Integer>> list = levelOrderBottom(node1) ;
		for(List<Integer> nums : list){
			for(Integer num : nums){
				System.out.print(num + " ");
			}
			System.out.println();
		}
				

	}

}
