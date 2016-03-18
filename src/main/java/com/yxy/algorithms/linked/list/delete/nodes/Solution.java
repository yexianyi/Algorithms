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
package com.yxy.algorithms.linked.list.delete.nodes;

import com.yxy.algorithms.linked.list.ListNode;

/**
	* 03. Remove Linked List Elements My Submissions Question
	Total Accepted: 46403 Total Submissions: 170172 Difficulty: Easy
	Remove all elements from a linked list of integers that have value val.
	
	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author xianyiye
 * 2016/1/8
 */
public class Solution {
	
	public static ListNode removeElements(ListNode head, int val) {
		ListNode supperHead = new ListNode(Integer.MIN_VALUE) ;
		supperHead.next = head ;
        ListNode p1 = supperHead ;
        ListNode p2 = supperHead.next ;
		
        while(p2!=null){
        	if(p2.val == val){
        		while(p2!=null && p2.val==val){
        			p2 = p2.next ;
        		}
        		p1.next = p2 ;
        	}
        	
        	if(p2!=null){
        		p2 = p2.next ;
            	p1 = p1.next ;
        	}
        }
        
        
		return supperHead.next ;
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1) ;
		ListNode node2 = new ListNode(2) ;
		ListNode node3 = new ListNode(4) ;
		ListNode node4 = new ListNode(4) ;
		ListNode node5 = new ListNode(5) ;
		ListNode node6 = new ListNode(6) ;

		node1.next = node2 ;
		node2.next = node3 ;
		node3.next = node4 ;
		node4.next = node5 ;
		node5.next = node6 ;
		
		ListNode head = removeElements(node1,4) ;
		
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next ;
		}

	}

}
