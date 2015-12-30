package com.yxy.algorithms.linked.list.intersection;

import com.yxy.algorithms.linked.list.ListNode;

public class Solution2 {
	
	public static ListNode  getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = length(headA);
        int lB = length(headB);
        int lmin = Math.min(lA, lB);
        ListNode hA = headA;
        ListNode hB = headB;

        while(lA-- > lmin) hA = hA.next;
        while(lB-- > lmin) hB = hB.next;
        while(hA != null) {
            if(hA == hB) return hA;
            hA = hA.next;
            hB = hB.next;
        }

        return null;
    }

    public static int length(ListNode head) {
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }

        return len;
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1) ;
		ListNode node2 = new ListNode(2) ;
		ListNode node3 = new ListNode(3) ;
		ListNode node4 = new ListNode(4) ;
		ListNode node5 = new ListNode(5) ;
		
		node1.next = node2 ;
		node2.next = node3 ;
		node3.next = node4 ;
		node4.next = node5 ;
		
		ListNode node11 = new ListNode(6) ;
		ListNode node12 = new ListNode(1) ;
		ListNode node13 = new ListNode(7) ;
//		ListNode node14 = new ListNode(14) ;
		
		node11.next = node12 ;
		node12.next = node13 ;
//		node13.next = node14 ;
		
		
		System.out.println(getIntersectionNode(node1,node11));

	}

}
