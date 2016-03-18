/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.yxy.algorithms.stack.impl.with.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 	225. Implement Stack using Queues My Submissions Question
	Total Accepted: 26496 Total Submissions: 87445 Difficulty: Easy
	Implement the following operations of a stack using queues.
	
	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	empty() -- Return whether the stack is empty.
	Notes:
	You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
	Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
	You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

 * @author xianyiye
 * 2015/12/30
 */

public class MyStack {
	
	private List<Integer> queue = new LinkedList<Integer>() ;
	Integer top = null ;
	
	// Push element x onto stack.
    public void push(int x) {
    	top = x ;
    	queue.add(x) ;
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i=1; i<=queue.size()-1; i++){
        	top = queue.get(0) ;
        	queue.add(queue.get(0)) ;
        	queue.remove(0) ;
        }
        queue.remove(0) ;
        
    }

    // Get the top element.
    public int top() {
        return top.intValue() ;
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return queue.isEmpty() ;
    }
    
    public static void main(String[] args){
    	MyStack stack = new MyStack() ;
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.pop();
    }
}
