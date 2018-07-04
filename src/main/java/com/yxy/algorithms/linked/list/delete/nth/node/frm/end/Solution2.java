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
package com.yxy.algorithms.linked.list.delete.nth.node.frm.end;

import com.yxy.algorithms.linked.list.ListNode;

/**
 * 	19. Remove Nth Node From End of List My Submissions Question
	Total Accepted: 87788 Total Submissions: 311992 Difficulty: Easy
	Given a linked list, remove the nth node from the end of list and return its head.
	
	For example,
	
	   Given linked list: 1->2->3->4->5, and n = 2.
	
	   After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
 * @author xianyiye
 * 2016/1/6
 */

public class Solution2 {
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode supperHead = new ListNode(-1);
	    supperHead.next = head;
	    ListNode p1 = supperHead;
	    ListNode p2 = supperHead;
	    while (p1.next!=null){
	        p1=p1.next;
	        if (n--<=0)p2=p2.next;
	    }
	    if (p2.next!=null) p2.next=p2.next.next;
	    return supperHead.next;
	}
	
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1) ;
		ListNode node2 = new ListNode(2) ;
		ListNode node3 = new ListNode(3) ;
		ListNode node4 = new ListNode(4) ;
		ListNode node5 = new ListNode(5) ;
//		
		node1.next = node2 ;
//		node2.next = node3 ;
//		node3.next = node4 ;
//		node4.next = node5 ;
		
		ListNode head = removeNthFromEnd(node1,1) ;
		
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next ;
		}
		
		
	}

}
