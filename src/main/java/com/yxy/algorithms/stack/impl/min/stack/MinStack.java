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

public class MinStack {
	
	private List<Integer> list = new ArrayList<Integer>() ;
	private List<Integer> minElems = new ArrayList<Integer>() ;
	
	public void push(int x) {
		list.add(x) ;
		int i=0;
		for(; i<minElems.size(); i++){
			if(x<minElems.get(i)){
				minElems.add(i, x);
			}
		}
		
		if(i==minElems.size()){
			minElems.add(x) ;
		}
    }

    public void pop() {
    	if(!list.isEmpty()){
    		int idx = minElems.indexOf(list.size()-1) ;
    		minElems.remove(idx) ;
    		list.remove(list.size()-1) ;
    	}
    }

    public int top() {
    	return list.get(list.size()-1);
        
    }

    public int getMin() {
		return minElems.get(0) ;
        
    }

	public static void main(String[] args) {
		MinStack stack = new MinStack() ;
		stack.push(-3);
		System.out.println(stack.getMin());

	}

}
