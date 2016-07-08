/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.yxy.algorithms.bst.lca;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 
	235. Lowest Common Ancestor of a Binary Search Tree
	 My Submissions 
	Question 
	
	Total Accepted: 42582 Total Submissions: 112254 Difficulty: Easy 
	
	
	
	
	
	Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. 
	
	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).” 
	        _______6______
	       /              \
	    ___2__          ___8__
	   /      \        /      \
	   0      _4       7       9
	         /  \
	         3   5
	

 * @author Administrator
 * 2015/12/19
 */

public class Solution {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 int low = (p.val < q.val) ? p.val : q.val;
	        int high = (p.val < q.val) ? q.val : p.val;
	    
	        TreeNode current = root;
	        while(current.val < low || current.val > high) {
	            if(current.val < low) {
	                current = current.right;
	            }
	            if(current.val > high) {
	                current = current.left;
	            }
	        }
	    
	        return current;
		
	}
}
