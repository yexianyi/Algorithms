package com.yxy.algorithms.stack.impl.min.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 	155. Min Stack My Submissions Question
	Total Accepted: 57848 Total Submissions: 272319 Difficulty: Easy
	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	
	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
 * @author xianyiye
 * 2016/1/18
 */

public class MinStack2 {
	
	private List<Node> list = new ArrayList<Node>() ;
	
	public void push(int x) {
		
		Node node = new Node(x) ;
		if(!list.isEmpty()){
			int preMinVal = list.get(list.size()-1).minVal ;
			if(x<=preMinVal){
				node.minVal = x ;
			}else{
				node.minVal = preMinVal ;
			}
		}else{
			node.minVal = x ;
		}
		
		list.add(node) ;
    }

    public void pop() {
    	if(!list.isEmpty()){
    		list.remove(list.size()-1) ;
    	}
    }

    public int top() {
    	return list.get(list.size()-1).val;
        
    }

    public int getMin() {
		return list.get(list.size()-1).minVal ;
        
    }
    
    private class Node{
    	public int val ;
    	public int minVal ;
    	
    	public Node(int val){
    		this.val = val ;
    	}
    }

	public static void main(String[] args) {
		MinStack2 stack = new MinStack2() ;
		stack.push(-3);
		System.out.println(stack.getMin());

	}

}
