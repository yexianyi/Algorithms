package com.yxy.algorithms.linked.list.reorder.list;

import java.util.HashMap;
import java.util.Map;

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
public class Solution2 {

	public static void reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return ;
		}
		ListNode p1 = head ;
		ListNode p2 = p1 ;
		int len = 0;
		Map<Integer, ListNode> map = new HashMap<>() ;
		
		while(p1 != null) {
			len ++ ;
			map.put(len, p1) ;
			p1 = p1.next ;
		}
		
		int move = len ;
		p1 = head ;
		while(move >= len/2 + 1) {
			p2 = map.get(move) ;
			p2.next = p1.next ;
			p1.next = p2;
			p1 = p2.next ;
			move -- ;
		}
		
		p1.next = null ;
		
		
	}

	public static void main(String[] args) {
//		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4,5,6,7,8}) ; //1->8->2->7->3->6->4->5->
//		ListNode head = ListNodeUtil.create(new int[]{1}) ; // 1
//		ListNode head = ListNodeUtil.create(new int[]{1,2}) ; // 1->2
//		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4}) ; // 1->4->2->3->
//		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4,5}) ; //1->5->2->4->3->
		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4,5,6,7,8,9}) ; // 1->9->2->8->3->7->4->6->5->
		reorderList(head) ;
		ListNodeUtil.print(head);
		
	}

}
