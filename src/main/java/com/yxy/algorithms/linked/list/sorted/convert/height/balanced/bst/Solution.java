package com.yxy.algorithms.linked.list.sorted.convert.height.balanced.bst;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
import com.yxy.algorithms.linked.list.ListNode;
import com.yxy.algorithms.linked.list.util.ListNodeUtil;
/**
 * 109. Convert Sorted List to Binary Search Tree My Submissions QuestionEditorial Solution
	Total Accepted: 71716 Total Submissions: 233228 Difficulty: Medium
	Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author xianyiye
 * @date 06/04/2016
 * 
 * Reference:
 * https://leetcode.com/discuss/23676/share-my-o-1-space-and-o-n-time-java-code
 */
public class Solution {

	private ListNode temp ;
	
	public TreeNode sortedListToBST(ListNode head) {
		int len = 0;
		ListNode node = head ;
		temp = head ;
		while(node!=null){
			node = node.next ;
			len++ ;
		}
		
		return constructBST(0, len-1) ;
		
    }
	
	private TreeNode constructBST(int start, int end) {
		if(start > end){
	        return null;
	    }

		int mid = start+(end-start)/2 ;
		
		TreeNode left = constructBST(start, mid-1) ;
		
		TreeNode root = new TreeNode(temp.val) ;
		root.left = left ;
		temp = temp.next ;
		
		TreeNode right = constructBST(mid+1, end) ;
		root.right = right ;
		
		return root ;
	}

	public static void main(String[] args) {
		ListNode head = ListNodeUtil.create(new int[]{1,2,3,4,5}) ;
		Solution s = new Solution() ;
		TreeNode root = s.sortedListToBST(head) ;
		
		BinaryTreeUtil.print(root);
		
	}

}
