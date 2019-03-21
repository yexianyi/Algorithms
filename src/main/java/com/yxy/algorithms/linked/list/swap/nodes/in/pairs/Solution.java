package com.yxy.algorithms.linked.list.swap.nodes.in.pairs;

import com.yxy.algorithms.linked.list.ListNode;
import com.yxy.algorithms.linked.list.util.ListNodeUtil;

/**
 * 24. Swap Nodes in Pairs
    Given a linked list, swap every two adjacent nodes and return its head.
    
    You may not modify the values in the list's nodes, only nodes itself may be changed.
    
     
    
    Example:
    
    Given 1->2->3->4, you should return the list as 2->1->4->3.
 * @author yexianyi
 * 2019/03/21
 * 
 * Reference :
 * https://leetcode.com/problems/swap-nodes-in-pairs/discuss/257831/My-java-solution-using-recursion-easy-to-understand-for-all
 */
public class Solution {

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head ;
        }
        
        ListNode p1 = head ;
        ListNode p2 = head.next ;
        ListNode temp = p2.next ;
        
        p2.next = p1 ;
        p1.next = swapPairs(temp) ;
        
        return p2;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(new int[] {1,2,3,4,5,6}) ;
        ListNodeUtil.print(swapPairs(head));
    }

}
