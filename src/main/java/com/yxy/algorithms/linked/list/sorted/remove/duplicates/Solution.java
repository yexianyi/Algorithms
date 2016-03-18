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
package com.yxy.algorithms.linked.list.sorted.remove.duplicates;

import com.yxy.algorithms.linked.list.ListNode;

/**
 * 	83. Remove Duplicates from Sorted List My Submissions Question
	Total Accepted: 91554 Total Submissions: 257573 Difficulty: Easy
	Given a sorted linked list, delete all duplicates such that each element appear only once.
	
	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
 * @author xianyiye
 * 2015/12/22
 */

public class Solution {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null){
			return head ;
		}
		
		ListNode p = head ;
		while(p.next!=null){
			ListNode pNext = p.next ;
			if(p.val == pNext.val){
				p.next = pNext.next ;
			}else{
				p = p.next ;
			}
		}

		return head ;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4 ;

		ListNode head = n1;
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		
		System.out.println() ;
		
		head = n1;
		head = deleteDuplicates(head) ;
		
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}

	}

}
