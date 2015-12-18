package com.yxy.algorithms.delete.linkedlist.node;

/**
 * 
 *  Delete Node in a Linked List My Submissions Question
	Total Accepted: 49241 Total Submissions: 112120 Difficulty: Easy
	Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	
	Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.


 * @author xianyiye
 * 2015/12/18
 */

public class Solution {

	public void deleteNode(ListNode node) {
		node.val = node.next.val ;
		node.next = node.next.next ;
		node.next = null ;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
