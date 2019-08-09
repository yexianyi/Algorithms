package com.yxy.algorithms.linked.list.rotate.list;

import com.yxy.algorithms.linked.list.ListNode;
/**
 * 61. Rotate List
    Given a linked list, rotate the list to the right by k places, where k is non-negative.
    
    Example 1:
    
    Input: 1->2->3->4->5->NULL, k = 2
    Output: 4->5->1->2->3->NULL
    Explanation:
    rotate 1 steps to the right: 5->1->2->3->4->NULL
    rotate 2 steps to the right: 4->5->1->2->3->NULL
    Example 2:
    
    Input: 0->1->2->NULL, k = 4
    Output: 2->0->1->NULL
    Explanation:
    rotate 1 steps to the right: 2->0->1->NULL
    rotate 2 steps to the right: 1->2->0->NULL
    rotate 3 steps to the right: 0->1->2->NULL
    rotate 4 steps to the right: 2->0->1->NULL
 * @author yexianyi
 * 2019/08/09
 * 
 */
public class Solution {

    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) {
            return head ;
        }
        
        ListNode p1 = head, p2 = head;

        while (--k > 0) {
            p2 = p2.next;
            if (p2 == null) {
                p2 = head;
            }
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode headCopy = head;
        head = p1;
        while (p1.next != null) {
            p1 = p1.next;
        }
        p1.next = headCopy;

        while (headCopy.next != head) {
            headCopy = headCopy.next;
        }
        headCopy.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode head = rotateRight(node1, 4);
        while (head != null) {
            System.out.print(head.val + " ->");
            head = head.next;
        }

    }

}
