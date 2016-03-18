/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
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

public class Solution2 {
	
    public static boolean isPalindrome(ListNode head) {
    	 if(head == null) return true;
         int len = 0;
         ListNode fake = head;
         while(fake != null) {
             fake = fake.next;
             len++;
         }

         boolean even = len%2 == 0;
         len = len/2 - 1;
         ListNode p1 = head;
         ListNode p2 = head.next;
         while(len != 0 && p2 != null) {
             ListNode temp = p2.next;
             p2.next = p1;
             p1 = p2;
             p2 = temp;
             len--;
         }

         if(!even && p2 != null) p2 = p2.next;

         while(p1 != null && p2 != null) {
             if(p1.val != p2.val) return false;
             p1 = p1.next;
             p2 = p2.next;
         }

         return true;
    }
	
    
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
