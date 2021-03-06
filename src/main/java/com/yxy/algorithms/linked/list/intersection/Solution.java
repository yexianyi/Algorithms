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
package com.yxy.algorithms.linked.list.intersection;

import com.yxy.algorithms.linked.list.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.

	
	For example, the following two linked lists:
	
	A:          a1 → a2
	                   	↘
	                     c1 → c2 → c3
	                   	↗            
	B:     b1 → b2 → b3
	begin to intersect at node c1.
	
	
	Notes:
	
	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.
 * @author Ye Xianyi
 *
 */

public class Solution {
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null){
			return null ;
		}
		ListNode head = headB ;
		
		while(headA!=null){
			headB = head ;
			while(headB!=null){
				if(headA.val==headB.val){
					return headA ;
				}
				headB = headB.next ;
			}
			
			headA = headA.next ;
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
		
		ListNode node11 = new ListNode(6) ;
		ListNode node12 = new ListNode(1) ;
		ListNode node13 = new ListNode(7) ;
//		ListNode node14 = new ListNode(14) ;
		
		node11.next = node12 ;
		node12.next = node13 ;
//		node13.next = node14 ;
		
		
		System.out.println(getIntersectionNode(node1,node11));

	}

}
