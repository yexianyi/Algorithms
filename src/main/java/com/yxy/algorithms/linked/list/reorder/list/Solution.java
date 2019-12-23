package com.yxy.algorithms.linked.list.reorder.list;

import com.yxy.algorithms.linked.list.ListNode;
import com.yxy.algorithms.linked.list.util.ListNodeUtil;

/**
 * 143. Reorder List
	Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	
	You may not modify the values in the list's nodes, only nodes itself may be changed.
	
	Example 1:
	
	Given 1->2->3->4, reorder it to 1->4->2->3.
	Example 2:
	
	Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * @author Ye Xianyi
 * 2019/12/23
 */
public class Solution {

	public static void reorderList(ListNode head) {
		ListNode p1 = head ;
		ListNode p2 = p1 ;
		int len = 0;
		
		while(p1 != null) {
			len ++ ;
			p1 = p1.next ;
		}
		
		p1 = head ;
		int step = len - 1 ;
		while(step >= 2) {
			for(int i=0; i<step; i++) { // move i steps to get n-i node 
				p2 = p2.next ;
			}
			p2.next = p1.next ;
			p1.next = p2 ;
			p1 = p2.next ;
			p2 = p1 ;
			step = step - 2 ;
		}
		
		if(step==0) {
			p1.next = null ;
		} else if(step == 1) {
			p1.next.next = null ;
		}
		
	}

	public static void main(String[] args) {
//		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4,5,6,7,8}) ;
		ListNode head = ListNodeUtil.create(new int[]{1}) ;
//		ListNode head = ListNodeUtil.create(new int[]{1,2}) ;
//		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4}) ;
//		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4,5}) ;
//		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4,5,6,7,8,9}) ;
		reorderList(head) ;
		ListNodeUtil.print(head);
		
	}

}
