package com.yxy.algorithms.linked.list.detect.cycle;

import com.yxy.algorithms.linked.list.ListNode;
/**
 * 141. Linked List Cycle My Submissions QuestionEditorial Solution
	Total Accepted: 100013 Total Submissions: 270778 Difficulty: Medium
	Given a linked list, determine if it has a cycle in it.
	
	Follow up:
	Can you solve it without using extra space?
 * @author xianyiye
 * @date 04/13/2016
 */

public class Solution {
	
	public static boolean hasCycle(ListNode head) {
		if(head==null || head.next==null) 
			return false;

		ListNode slow = head ;
		ListNode fast = head ;
		
		while(fast != null && fast.next != null){
			slow = slow.next ;
			fast = fast.next.next ;
			
			if(slow==fast){
				return true ;
			}
		}
		
		return false;
        
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1) ;
		ListNode node2 = new ListNode(1) ;
//		ListNode node3 = new ListNode(1) ;
//		ListNode node4 = new ListNode(1) ;
		
		node1.next = node2 ;
		node2.next = node1 ;
//		node2.next = node3 ;
//		node3.next = node4 ;
//		node4.next = node2 ;
		
		System.out.println(hasCycle(node1));
		
	}

}
