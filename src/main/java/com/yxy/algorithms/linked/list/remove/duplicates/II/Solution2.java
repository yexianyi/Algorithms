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
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/356065/Short-recursion-Java-solution-beats-100
 * 
 * @author yexianyi
 * 2019/08/12
 */

public class Solution2 {
    
    
    /**
     *  case 1: cur node has same value as next's, then should return next.next
        case 2: next is a null, which means there are at least two duplicate nodes after cur node, e.g cur -> 1 -> 1
        so we just need to check if cur node is another duplicate node.
        case 3: no dupliate
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        // next means result so far
        ListNode next = deleteDuplicates(head.next);
        // case 1: 
        if(next != null && head.val == next.val) {
            return next.next;
        }
        // case 2: 
        if(head.val == head.next.val) 
            return next;
        // case 3:
        head.next = next;
        return head;
        
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1) ;
        ListNode node2 = new ListNode(2) ;
        ListNode node3 = new ListNode(3) ;
        ListNode node4 = new ListNode(3) ;
        ListNode node5 = new ListNode(4) ;
        ListNode node6 = new ListNode(4) ;
        ListNode node7 = new ListNode(5) ;
        
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4 ;
        node4.next = node5 ;
        node5.next = node6 ;
        node6.next = node7 ;
        
//        ListNode node1 = new ListNode(1) ;
//        ListNode node2 = new ListNode(1) ;
//        node1.next = node2 ;
        
        ListNode head = deleteDuplicates(node1) ;
        
        while(head!=null) {
            System.out.print(head.val + " -> ");
            head = head.next ;
        }
    }

}
