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

public class Solution {
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.next==null){
			return null ;
		}
		
		ListNode node1 = head ;
		ListNode node2 = head ;
		
		int count = 0 ;
		while(node2!=null && count<n+1){
			count++ ;
			node2 = node2.next ;
		}
		
		if(node2==null){
			if(count==n){
				return node1.next ;
			}
		}
		
		while(node2!=null){
			node1 = node1.next ;
			node2 = node2.next ;
		}
		
		node1.next = node1.next.next ;
		
		return head ;
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
