package com.yxy.algorithms.linked.list.sort;

import com.yxy.algorithms.linked.list.ListNode;
import com.yxy.algorithms.linked.list.util.ListNodeUtil;

/**
 * 148. Sort List
	Medium
	
	2025
	
	101
	
	Add to List
	
	Share
	Sort a linked list in O(n log n) time using constant space complexity.
	
	Example 1:
	
	Input: 4->2->1->3
	Output: 1->2->3->4
	Example 2:
	
	Input: -1->5->3->4->0
	Output: -1->0->3->4->5
	
 * @author Ye Xianyi
 * 2020/01/10
 */
public class Solution2 {

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
            return head;
        }
		
		ListNode p = head ;
		while(p.next != null) {
			p = p.next ;
		}
		
		ListNode mid = getMiddleNode(head) ;
		ListNode leftHead = head ;
		ListNode rightHead = mid.next ;
		mid.next = null ;
		
		ListNode left = sortList(leftHead) ;
		ListNode right = sortList(rightHead) ;
		return merge(left, right) ;
		
	}
	
	
	private static ListNode merge(ListNode left, ListNode right) {
		ListNode head = null ;
		ListNode root = null ;
		while(left != null && right != null) {
			if(left.val < right.val) {
				if(head == null) {
					head = left ;
					root = left ;
				} else {
					head.next = left ;
					head = head.next ;
				}
				left = left.next ;
				head.next = null ;
			} else {
				if(head == null) {
					head = right ;
					root = right ;
				} else {
					head.next = right ;
					head = head.next ;
				}
				right = right.next ;
				head.next = null ;
			}
			
		}
		
		if(left != null) {
			head.next = left ;
		}
		
		if(right != null) {
			head.next = right ;
		}
		
		return root ;
		
	}
	
	
	private static ListNode getMiddleNode(ListNode head) {
		ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
		
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.create(new int[]{4,7,2,3,1,5,8}) ;
		head = sortList(head) ;
		ListNodeUtil.print(head);
	}

}
