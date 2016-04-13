package com.yxy.algorithms.bst.creation.convert.from.sorted.array;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree My Submissions QuestionEditorial Solution
	Total Accepted: 73125 Total Submissions: 197287 Difficulty: Medium
	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author xianyiye
 * @date 04/13/2016
 * Copy from: 
 * https://leetcode.com/discuss/73579/very-simple-java-solution
 */

public class Solution2 {

	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	private TreeNode helper(int[] nums, int l, int r) {
		if (l > r)
			return null;
		if (l == r)
			return new TreeNode(nums[l]);
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, l, mid - 1);
		root.right = helper(nums, mid + 1, r);
		return root;
	}

}
