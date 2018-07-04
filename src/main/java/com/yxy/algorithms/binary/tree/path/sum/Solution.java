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
package com.yxy.algorithms.binary.tree.path.sum;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 	112. Path Sum My Submissions Question
	Total Accepted: 83283 Total Submissions: 273686 Difficulty: Easy
	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along 
	the path equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author xianyiye
 * 2015/12/30
 */

public class Solution {
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null){
			return false ;
		}
		
		if(root.left==null && root.right==null){
			if(sum-root.val==0){
				return true ;
			}else{
				return false ;
			}
		}
		
		sum = sum - root.val ;
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5) ;
		root.left = new TreeNode(4)  ;
		root.right = new TreeNode(8) ;
		root.left.left = new TreeNode(11) ;
		root.right.left = new TreeNode(13) ;
		root.right.right = new TreeNode(4) ;
		root.left.left.left = new TreeNode(7) ;
		root.left.left.right = new TreeNode(2) ;
		root.right.right.right = new TreeNode(1) ;
		
		System.out.println(hasPathSum(root,22));

	}

}
