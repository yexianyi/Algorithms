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
package com.yxy.algorithms.binary.tree.invert;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 
	Invert Binary Tree
	 My Submissions 
	Question 
	
	Total Accepted: 56032 Total Submissions: 132877 Difficulty: Easy 
	
	
	
	
	Invert a binary tree. 
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	to      4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1

 * @author Administrator
 * 2015/12/18
 */

public class Solution {
	
	public TreeNode invertTree(TreeNode root) {
		if(root==null){
			return root ;
		}

		invertTree(root.left) ;
		invertTree(root.right) ;
		
		TreeNode temp = root.left ;
		root.left = root.right ;
		root.right = temp ;
		
		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
