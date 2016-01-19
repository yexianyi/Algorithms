package com.yxy.algorithms.linked.list.odd.even;

import com.yxy.algorithms.linked.list.ListNode;

/**
 * 
	328. Odd Even Linked List
	 My Submissions 
	Question 
	
	Total Accepted: 4059 Total Submissions: 10475 Difficulty: Easy 
	
	Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
	You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
	
	
	Example:
	 Given 1->2->3->4->5->NULL,
	 return 1->3->5->2->4->NULL. 
	
	Note:
	 The relative order inside both the even and odd groups should remain as it was in the input. 
	 The first node is considered odd, the second node even and so on ... 

 * @author xianyiye
 * 2016/1/19
 */

public class Solution {
	
	public static ListNode oddEvenList(ListNode head) {
		if(head==null){
			return head ;
		}
		
		ListNode p_odd = head ;
		ListNode p_even = p_odd.next ;
		ListNode evenNode = new ListNode(Integer.MAX_VALUE) ;
		evenNode.next = p_even ;
		
		while(p_even!=null){
			p_odd.next = p_even.next ;
			if(p_even.next!=null){
				p_odd = p_even.next ;
				p_even.next = p_odd.next ;
			}
			p_even = p_odd.next ;
		}
		
		p_odd.next = evenNode.next ;
		
        return head ;
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1) ;
		ListNode node2 = new ListNode(2) ;
		ListNode node3 = new ListNode(3) ;
		ListNode node4 = new ListNode(4) ;
		ListNode node5 = new ListNode(5) ;
		ListNode node6 = new ListNode(6) ;
		
		node1.next = node2 ;
		node2.next = node3 ;
		node3.next = node4 ;
		node4.next = node5 ;
//		node5.next = node6 ;
		
		ListNode head = oddEvenList(node1) ;
		while(head!=null){
			System.out.print(head.val+"->");
			head = head.next ;
		}
		
		
		

	}

}
