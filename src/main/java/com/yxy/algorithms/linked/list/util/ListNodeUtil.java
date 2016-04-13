package com.yxy.algorithms.linked.list.util;

import com.yxy.algorithms.linked.list.ListNode;

public abstract class ListNodeUtil {

	public static ListNode create(int[] nums){
		ListNode[] nodeArray = new ListNode[nums.length] ;
		
		for(int i=0; i<nums.length; i++){
			nodeArray[i] = new ListNode(nums[i]) ;
			if(i>0){
				nodeArray[i-1].next = nodeArray[i] ;
			}
		}
		
		return nodeArray[0] ;
	}
	
	
	public static void print(ListNode head){
		while(head!=null){
			System.out.print(head.val+"->");
			head = head.next ;
		}
	}
	
	public static void main(String args[]){
		ListNode head = create(new int[]{1,2,3,4,5,6,7}) ;
		print(head) ;
	}
	
}
