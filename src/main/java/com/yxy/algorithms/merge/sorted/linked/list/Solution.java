package com.yxy.algorithms.merge.sorted.linked.list;

/**
 *  Merge Two Sorted Lists My Submissions Question
	Total Accepted: 96922 Total Submissions: 286444 Difficulty: Easy
	Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * @author xianyiye
 * 2015/12/22
 */

public class Solution {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2 ;
		}
		
		if(l2==null){
			return l1 ;
		}
		
		if(l1.val > l2.val){
			return mergeTwoLists(l2, l1) ;
		}
		
		ListNode head = l1 ;
		ListNode p = l1 ;
		ListNode p1 = l1 ;
		ListNode p2 = l2 ;
		p1 = p1.next ;
		while(p1!=null && p2!=null){
			while(p1!=null && p2!=null && p1.val<=p2.val){
				ListNode temp = p1.next;
				p.next = p1 ;
				p1 = temp ;
				p = p.next ;
			}
			
			while(p1!=null && p2!=null && p1.val>p2.val){
				ListNode temp = p2.next;
				p.next = p2 ;
				p2 = temp ;
				p = p.next ;
			}
		}
		
		if(p1==null && p2!=null){
			p.next = p2 ;
		}
		
		if(p1!=null && p2==null){
			p.next = p1 ;
		}
		
		return head;
        
    }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		
		ListNode m1 = new ListNode(2);
		ListNode m2 = new ListNode(3);
		ListNode m3 = new ListNode(4);
		m1.next = m2;
		m2.next = m3;

		ListNode head = n1;
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		
		System.out.println() ;
		
		head = m1;
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		
		System.out.println() ;
		
		head = mergeTwoLists(n1, m1) ;
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}

	}

}
