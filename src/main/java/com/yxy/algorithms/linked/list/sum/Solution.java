package com.yxy.algorithms.linked.list.sum;

import com.yxy.algorithms.linked.list.ListNode;
import com.yxy.algorithms.linked.list.util.ListNodeUtil;

public class Solution {

	public static ListNode reverserList(ListNode head) {
		if(head==null || head.next==null) {
			return head ;
		}
		
		ListNode preNode = null ;
		ListNode currNode = head ;
		ListNode nextNode = null ;
		
		while(currNode!=null) {
			nextNode = currNode.next ;
			currNode.next = preNode ;
			preNode = currNode ;
			currNode = nextNode ;
		}
		
		return preNode ;
	}
	
	
	public static ListNode sum(ListNode head1, ListNode head2) {
		ListNode p = new ListNode(0) ;
		ListNode head = p ;
		int sum = 0;
		
		while(head1!=null || head1!=null || sum>0) {
			if(head1!=null) {
				sum += head1.val ;
				head1 = head1.next ;
			}
			
			if(head2!=null) {
				sum += head2.val ;
				head2 = head2.next ;
			}
			
			p.next = new ListNode(sum%10) ;
			sum = sum/10 ;
			p = p.next ;
			
		}
		
		return head.next ;
	}


	public static void main(String[] args) {
		ListNode head1 = ListNodeUtil.create(new int[]{5,6,7}) ;
		ListNode head2 = ListNodeUtil.create(new int[]{7,8,9}) ;
		
		head1 = reverserList(head1) ;
		head2 = reverserList(head2) ;
		
		ListNode node = sum(head1, head2) ;
		node = reverserList(node) ;
		
		ListNodeUtil.print(node);
		
		
		
		
		
		
	}

}
