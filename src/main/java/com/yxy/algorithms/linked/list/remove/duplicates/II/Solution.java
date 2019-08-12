package com.yxy.algorithms.linked.list.remove.duplicates.II;

import com.yxy.algorithms.linked.list.ListNode;
/**
 * 82. Remove Duplicates from Sorted List II
    Given a sorted linked list, delete all nodes that have duplicate numbers, 
    leaving only distinct numbers from the original list.
    
    Example 1:
    
    Input: 1->2->3->3->4->4->5
    Output: 1->2->5
    Example 2:
    
    Input: 1->1->1->2->3
    Output: 2->3
 * 
 * Copy from:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/354611/Java-Two-pointers-with-dummy-head-solution
 * 
 * @author yexianyi
 * 2019/08/12
 */
public class Solution {

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head ;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        // ListNode node1 = new ListNode(1) ;
        // ListNode node2 = new ListNode(1) ;
        // node1.next = node2 ;

        ListNode head = deleteDuplicates(node1);

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

}
