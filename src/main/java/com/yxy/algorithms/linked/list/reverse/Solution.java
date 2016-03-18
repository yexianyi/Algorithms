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
package com.yxy.algorithms.linked.list.reverse;

import com.yxy.algorithms.linked.list.ListNode;

/**
 * 	206. Reverse Linked List My Submissions Question
	Total Accepted: 67569 Total Submissions: 185167 Difficulty: Easy
	Reverse a singly linked list.
	
	click to show more hints.
	
	Hint:
	A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @author xianyiye
 * 2015/12/21
 */

public class Solution {

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// initialization
		ListNode previousNode = null;
		ListNode nextNode = null;

		while (head != null) {
			// save the next node
			nextNode = head.next;
			// update the value of "next"
			head.next = previousNode;
			// shift the pointers
			previousNode = head;
			head = nextNode;
		}
		return previousNode;

	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;

		ListNode head = n1;
		head = reverseList(n1);

		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

}
