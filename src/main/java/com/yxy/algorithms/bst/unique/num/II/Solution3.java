package com.yxy.algorithms.bst.unique.num.II;

import java.util.ArrayList;
import java.util.List;

import com.yxy.algorithms.binary.tree.TreeNode;
/**
 * 95. Unique Binary Search Trees II My Submissions QuestionEditorial Solution
	Total Accepted: 58248 Total Submissions: 199177 Difficulty: Medium
	Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
	
	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 * @author xianyiye
 * @date 06/29/2016
 * 
 * Copy from:
 * https://leetcode.com/submissions/detail/65646942/
 */
public class Solution3 {
	
	 public List<TreeNode> generateTrees(int n) {
	        if(n==0) return new ArrayList<TreeNode>();
	        return generateTress(1, n);
	    }

	    private List<TreeNode> generateTress(int start, int end){
	        if(start>end) {
	            List<TreeNode> list = new ArrayList<TreeNode>();
	            list.add(null);
	            return list;
	        }
	        if(start==end) {
	            List<TreeNode> list = new ArrayList<TreeNode>();
	            list.add(new TreeNode(start)); return list;
	        }
	        List<TreeNode> roots = new ArrayList<TreeNode>();
	        for(int i=start;i<=end;i++){
	            List<TreeNode> leftTrees = generateTress(start, i-1);
	            List<TreeNode> rightTrees = generateTress(i+1, end);
	            for(int j=0;j<leftTrees.size();j++){
	                for(int k=0;k<rightTrees.size();k++){
	                    TreeNode root = new TreeNode(i);
	                    root.left = leftTrees.get(j);
	                    root.right = rightTrees.get(k);
	                    roots.add(root);
	                }
	            }

	        }
	        return roots;
	    }
    
	public static void main(String[] args) {
		new Solution3().generateTrees(3) ;
	}

}
