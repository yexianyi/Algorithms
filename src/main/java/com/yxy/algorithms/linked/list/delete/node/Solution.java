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
package com.yxy.algorithms.linked.list.delete.node;

import com.yxy.algorithms.linked.list.ListNode;

/**
 * 
 *  Delete Node in a Linked List My Submissions Question
	Total Accepted: 49241 Total Submissions: 112120 Difficulty: Easy
	Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	
	Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.


 * @author xianyiye
 * 2015/12/18
 */

public class Solution {

	public void deleteNode(ListNode node) {
		node.val = node.next.val ;
		node.next = node.next.next ;
		node.next = null ;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
