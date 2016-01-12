package com.yxy.algorithms.linked.list.palindrome;

import com.yxy.algorithms.linked.list.ListNode;

/**
 * 	234. Palindrome Linked List My Submissions Question
	Total Accepted: 33213 Total Submissions: 127818 Difficulty: Easy
	Given a singly linked list, determine if it is a palindrome.
	
	Follow up:
	Could you do it in O(n) time and O(1) space?
 * @author xianyiye
 * 2016/1/12
 */

public class Solution {
	
    public static boolean isPalindrome(ListNode head) {
    	if(head==null || head.next==null){
    		return true ;
    	}
    	
    	if(head.next.next==null){
    		return head.val==head.next.val ;
    	}
    	
        //locate the center point of linked list
    	ListNode temp = new ListNode(Integer.MIN_VALUE) ;
    	temp.next = head ;
    	ListNode p1 = head ;
        ListNode p2 = head ;
        
        while(p2!=null && p2.next!=null){
        	p1 = p1.next ;
    		p2 = p2.next.next ;
    		temp = temp.next ;
        }
        
        temp.next = null ;
        
        //reverse remaining 1/2 linked list
        ListNode preNode = p1 ;
        ListNode curNode = p1.next ;
        ListNode nextNode = null ;
        while(curNode!=null){
        	nextNode = curNode.next ;
        	
        	curNode.next = preNode ;
        	preNode = curNode ;
        	curNode = nextNode ;
        }
        
        p1.next = null ;
        p1 = preNode ;
        
        //compare each of items between 2 sub-linked list
        while(head!=null){
        	if(head.val!=p1.val){
        		return false ;
        	}
        	head = head.next ;
        	p1 = p1.next ;
        }
    	
    	
    	return true ;
    }
	
    
//    public static ListNode reverse(ListNode p1){
//    	ListNode preNode = p1 ;
//        ListNode curNode = p1.next ;
//        ListNode nextNode = null ;
//        while(curNode!=null){
//        	nextNode = curNode.next ;
//        	
//        	curNode.next = preNode ;
//        	preNode = curNode ;
//        	curNode = nextNode ;
//        }
//        
//        p1.next = null ;
//        p1 = preNode ;
//        
//        return p1 ;
//    }
    
    public static void main(String[] args) {
    	ListNode node1 = new ListNode(1) ;
		ListNode node2 = new ListNode(2) ;
		ListNode node3 = new ListNode(2) ;
		ListNode node4 = new ListNode(1) ;
		ListNode node5 = new ListNode(3) ;
		ListNode node6 = new ListNode(2) ;
		ListNode node7 = new ListNode(1) ;
		
		node1.next = node2 ;
		node2.next = node3 ;
		node3.next = node4 ;
//		node4.next = node5 ;
//		node5.next = node6 ;
//		node6.next = node7 ;
		
		System.out.println(isPalindrome(node1));
		
//		ListNode head = reverse(node1);
//		while (head != null) {
//			System.out.print(head.val + "->");
//			head = head.next;
//		}

	}

}
