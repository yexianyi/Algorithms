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

public class Solution3 {
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;

	    ListNode a = headA;
	    ListNode b = headB;

	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	        //for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }

	    return a;
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
