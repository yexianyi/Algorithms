package com.yxy.algorithms.linked.list.reverse.II;

import com.yxy.algorithms.linked.list.ListNode;
/**
 * 92. Reverse Linked List II  QuestionEditorial Solution  My Submissions
	Total Accepted: 76987
	Total Submissions: 269714
	Difficulty: Medium
	Reverse a linked list from position m to n. Do it in-place and in one-pass.
	
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	
	return 1->4->3->2->5->NULL.
	
	Note:
	Given m, n satisfy the following condition:
	1 ≤ m ≤ n ≤ length of list.
 * @author xianyiye
 * @date 07/13/2016
 * 
 * Copy from:
 * https://discuss.leetcode.com/topic/8976/simple-java-solution-with-clear-explanation
 */
public class Solution {

	public ListNode reverseBetween(ListNode head, int m, int n) {
	    if(head == null) return null;
	    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
	    dummy.next = head;
	    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
	    for(int i = 0; i<m-1; i++) pre = pre.next;
	    
	    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
	    ListNode then = start.next; // a pointer to a node that will be reversed
	    
	    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
	    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
	    
	    for(int i=0; i<n-m; i++)
	    {
	        start.next = then.next;
	        then.next = pre.next;
	        pre.next = then;
	        then = start.next;
	    }
	    
	    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
	    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
	    
	    return dummy.next;
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
