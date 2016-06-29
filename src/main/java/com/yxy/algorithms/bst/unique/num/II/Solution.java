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
 * https://leetcode.com/discuss/10254/a-simple-recursive-solution
 * https://leetcode.com/discuss/24305/divide-and-conquer-f-i-g-i-1-g-n-i
 */
public class Solution {
	
	public static List<TreeNode> generateTrees(int n) {
		if(n>0){
			return genTrees(1,n);
		}
		
		return new ArrayList<TreeNode>() ;
    }

    private static List<TreeNode> genTrees (int start, int end){
        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }
    
    
	public static void main(String[] args) {
		new Solution().generateTrees(3) ;
	}

}
