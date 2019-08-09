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
 * Reference:
 * https://www.cnblogs.com/271934Liao/p/8256891.html
 */
public class Solution2 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        int len = 1;

        // get the size of linkedlist and make p points to the last node
        while (p.next != null) {
            p = p.next;
            len++;
        }

        k = k % len;
        if (k == 0)
            return head;
        ListNode newHead = null;
        ListNode preRotatedNode = head;
        // get the preRotatedNode whose next node will start to be rotated
        // i = len - k - 1
        int i = 0;
        while (i < len - k - 1) {
            preRotatedNode = preRotatedNode.next;
            i++;
        }
        // newHead = node[i].next
        newHead = preRotatedNode.next;
        // node[i] is the last node of the linkedlist after rotated
        preRotatedNode.next = null;
        
        // Since p is the last node of the original linkedlist,
        // make p.next point to the orignal head node 
        p.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = rotateRight(node1, 4);
        while (head != null) {
            System.out.print(head.val + " ->");
            head = head.next;
        }

    }

}
