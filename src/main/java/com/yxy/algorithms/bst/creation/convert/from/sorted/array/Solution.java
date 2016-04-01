package com.yxy.algorithms.bst.creation.convert.from.sorted.array;

import com.yxy.algorithms.binary.tree.TreeNode;

public class Solution {

		
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0){
			return null;
		}
		
		int rootIdx = nums.length/2 ;
		TreeNode root = new TreeNode(nums[rootIdx]) ;
		generateBST(nums, root, 0, nums.length-1) ;
		
		return root ;
    }
	
	
	
	private static void generateBST(int[] nums, TreeNode parent, int start, int end) {
		if(start==end){
			return ;
		}
		
		int parentIdx = (start+end)/2 ;
		int leftIdx = (start+parentIdx)/2 ;
		int rightIdx = (parentIdx+end)/2 ;
		
//		TreeNode pNode = new TreeNode(nums[parentIdx]) ;
		TreeNode lNode = new TreeNode(nums[leftIdx]) ;
		TreeNode rNode = new TreeNode(nums[rightIdx]) ;
		
		parent.left = lNode ;
		parent.right = rNode ;
		
		//generate left branch
		generateBST(nums, lNode, start, parentIdx-1) ;
		//generate right branch
		generateBST(nums, rNode, parentIdx+1, end) ;
		
	}





	private static void travelInOrder(TreeNode node){
		if(node==null){
			return ;
		}
		
		travelInOrder(node.left);
		System.out.print(node.val+" ");
		travelInOrder(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = sortedArrayToBST(new int[]{0,1,2,3,4,5}) ;
		travelInOrder(root) ;
//		
//		root = sortedArrayToBST(new int[]{0,1,2,3,4,5,6,7}) ;
//		travelInOrder(root) ;
		
//		TreeNode root = sortedArrayToBST(new int[]{0,1,2}) ;
//		travelInOrder(root) ;
	}

}
