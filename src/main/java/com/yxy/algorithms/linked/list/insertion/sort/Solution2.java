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
 * https://leetcode.com/discuss/24663/an-easy-and-clear-way-to-sort-o-1-space
 */
public class Solution2 {
	
	//42 ms
	public static ListNode insertionSortList(ListNode head) {
		if( head == null ){
            return head;
        }

        ListNode superHead = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = superHead; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = superHead;
            cur = next;
        }

        return superHead.next;
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
