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
 *  Copy from:
 *  https://leetcode.com/problems/reorder-list/discuss/451646/100-both
 */
public class Solution3 {

	public static void reorderList(ListNode head) {
		if(head==null)
            return;
		
        // Find the middle node
        ListNode run = head;
        ListNode walker = head;
        while(run!=null && run.next!=null){
            run = run.next.next;
            walker = walker.next;
        }
        //Break original list into 2 linkedist
        ListNode reverse = walker.next;
        walker.next=null;
        
        // Reverse the second linkedList
        ListNode l1 = head;
        ListNode prev = null;
        while(reverse!=null){
            ListNode temp = reverse;
            reverse = reverse.next;
            temp.next = prev;
            prev = temp;
        }
        ListNode l2 = prev;
        head = l1;
        //Merge 2 linkedList
        while(l2!=null){
            ListNode tmpl1 = l1;
            ListNode templ2 = l2;
            l1= l1.next;
            l2 = l2.next;
            tmpl1.next = templ2;
            templ2.next=l1;
        }
		
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
