package com.yxy.algorithms.linked.list.insertion.sort;

import com.yxy.algorithms.linked.list.ListNode;
import com.yxy.algorithms.linked.list.util.ListNodeUtil;
/**
 * 147. Insertion Sort List My Submissions QuestionEditorial Solution
	Total Accepted: 73092 Total Submissions: 245260 Difficulty: Medium

 * @author xianyiye
 * @date 6/13/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/92229/7ms-java-solution-with-explanation
 */
public class Solution3 {
	
	//9 ms
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
	    {
	        return head;
	    }

	    ListNode sortedHead = head, sortedTail = head;
	    head = head.next;
	    sortedHead.next = null;

	    while (head != null)
	    {
	        ListNode temp = head;
	        head = head.next;
	        temp.next = null;

	        // new val is less than the head, just insert in the front
	        if (temp.val <= sortedHead.val)
	        {
	            temp.next = sortedHead;
	            sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
	            sortedHead = temp;
	        }
	        // new val is greater than the tail, just insert at the back
	        else if (temp.val >= sortedTail.val)
	        {
	            sortedTail.next = temp;
	            sortedTail = sortedTail.next;
	        }
	        // new val is somewhere in the middle, we will have to find its proper
	        // location.
	        else
	        {
	            ListNode current = sortedHead;
	            while (current.next != null && current.next.val < temp.val)
	            {
	                current = current.next;
	            }

	            temp.next = current.next;
	            current.next = temp;
	        }
	    }

	    return sortedHead;
    }

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.create(new int[]{1,4,3,2,5,2}) ;
		head = insertionSortList(head) ;
		
		while(head!=null){
			System.out.print(head.val+" ") ;
			head = head.next ;
		}

	}

}
