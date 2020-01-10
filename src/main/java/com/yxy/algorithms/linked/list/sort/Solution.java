package com.yxy.algorithms.linked.list.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
public class Solution {

	// Memory Limit Exceeded
	public static ListNode sortList(ListNode head) {
		Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode node1, ListNode node2) {
				if(node1.val > node2.val) {
					return 1 ;
				} else if (node1.val == node2.val) {
					return 0 ;
				} else {
					return -1 ;
				}
			}
			
		}) ;
		
		while(head != null) {
			heap.offer(head) ;
			head = head.next ;
		}
		
		ListNode p = heap.poll() ;
		head = p ;
		while(!heap.isEmpty()) {
			p.next = heap.poll() ;
			p = p.next ;
		}
		
		return head ;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.create(new int[]{4,7,2,3,1,5,8}) ;
		head = sortList(head) ;
		ListNodeUtil.print(head);
	}

}
