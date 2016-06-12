package com.yxy.algorithms.linked.list.partition;

import com.yxy.algorithms.linked.list.ListNode;
import com.yxy.algorithms.linked.list.util.ListNodeUtil;
/**
 * 86. Partition List My Submissions QuestionEditorial Solution
	Total Accepted: 68257 Total Submissions: 228584 Difficulty: Medium
	Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	
	You should preserve the original relative order of the nodes in each of the two partitions.
	
	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
	
 * @author xianyiye
 * @date 06/12/2016
 * Copy from:
 * https://leetcode.com/discuss/100459/java-concise-solution
 */
public class Solution {

	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode head1, p1 = new ListNode(0), head2, p2 = new ListNode(0);
		head1 = p1;
		head2 = p2;
		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				p1 = p1.next;
			} else {
				p2.next = head;
				p2 = p2.next;
			}
			head = head.next;
		}
		p2.next = null;
		p1.next = head2.next;
		return head1.next;
    }
	
	public static void main(String[] args) {
//		ListNode head = ListNodeUtil.create(new int[]{1,4,3,2,5,2}) ;
		ListNode head = ListNodeUtil.create(new int[]{2,1}) ;
		head = partition(head,2) ;
		
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next ;
		}
	}

}
