package com.yxy.algorithms.linked.list.insertion.sort;

import com.yxy.algorithms.linked.list.ListNode;
import com.yxy.algorithms.linked.list.util.ListNodeUtil;
/**
 * 147. Insertion Sort List My Submissions QuestionEditorial Solution
	Total Accepted: 73092 Total Submissions: 245260 Difficulty: Medium

 * @author xianyiye
 * @date 6/13/2016
 * 
 */
public class Solution {
	
	//54 ms
	public static ListNode insertionSortList(ListNode head) {
		ListNode superHead = new ListNode(Integer.MIN_VALUE) ;
		
		while(head!=null){
			ListNode p = superHead ;
			while(p.next!=null && head.val>=p.next.val){
				p = p.next ;
			}
			
			if(p.next==null){
				p.next = new ListNode(head.val) ;
			}else{
				ListNode cloneNext = new ListNode(p.next.val) ;
				cloneNext.next = p.next.next ;
				
				ListNode cloneHead = new ListNode(head.val) ;
				cloneHead.next = cloneNext ;
				
				p.next = cloneHead ;
			}
			
			head = head.next ;
		}
		
		return superHead.next ;
    }

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.create(new int[]{1,4,3,2,7,5,8}) ;
		head = insertionSortList(head) ;
		
		while(head!=null){
			System.out.print(head.val+" ") ;
			head = head.next ;
		}

	}

}
