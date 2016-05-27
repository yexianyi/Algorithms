package com.yxy.algorithms.linked.list.detect.cycle.II;

import com.yxy.algorithms.linked.list.ListNode;
/**
 * 142. Linked List Cycle II My Submissions QuestionEditorial Solution
	Total Accepted: 76275 Total Submissions: 243246 Difficulty: Medium
	Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	
	Note: Do not modify the linked list.
	
	Follow up:
	Can you solve it without using extra space?
 * @author xianyiye
 * @date 05/26/2016
 * 
 * Reference:
 * https://leetcode.com/discuss/65724/concise-java-solution-based-on-slow-fast-pointers
 */
public class Solution {
	public static ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null)
            return null;
		
        ListNode p1 = head ;
        ListNode p2 = head ;
        
        
        while(p2!=null && p2.next!=null){
    		p1 = p1.next ;
    		p2 = p2.next.next ;
    		
    		if(p1==p2){
    			p1 = head ;
            	while(p1!=p2){ //To use this solution, the start position of the fast pointer MUST start from HEAD node.
            		p1 = p1.next ;
            		p2 = p2.next ;
            	}
            	
            	return p1 ;
    		}
        }
        
		return null ;
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
		node5.next = node3 ;
		
		System.out.println(detectCycle(node1).val) ;
		
	}

}
