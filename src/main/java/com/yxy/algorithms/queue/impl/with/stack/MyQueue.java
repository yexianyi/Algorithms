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
package com.yxy.algorithms.queue.impl.with.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 	Implement Queue using Stacks My Submissions Question
	Total Accepted: 27360 Total Submissions: 80836 Difficulty: Easy
	Implement the following operations of a queue using stacks.
	
	push(x) -- Push element x to the back of queue.
	pop() -- Removes the element from in front of queue.
	peek() -- Get the front element.
	empty() -- Return whether the queue is empty.
	Notes:
	You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
	Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
	You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 * @author xianyiye
 * 2015/12/23
 */

public class MyQueue {
	
	private List<Integer> stack = new ArrayList<Integer>();
	
	// Push element x to the back of queue.
    public void push(int x) {
    	stack.add(x) ;
    }

    // Removes the element from in front of queue.
    public void pop() {
    	stack.remove(0) ;
    }

    // Get the front element.
    public int peek() {
    	return stack.get(0) ;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        
    	return stack.isEmpty() ;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
