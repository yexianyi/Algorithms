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
package com.yxy.algorithms.symmetric.tree;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 	101. Symmetric Tree My Submissions Question
	Total Accepted: 85608 Total Submissions: 262025 Difficulty: Easy
	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	
	For example, this binary tree is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.


 * @author xianyiye
 * 2015/12/24
 */

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if(root==null || (root.left==null && root.right==null)){
			return true ;
		}
		
		return isSymmetric(root.left, root.right) ;
    }
	
	public boolean isSymmetric(TreeNode p1, TreeNode p2) {
		if(p1 == null && p2 == null){
			return true ;
		}
		
		if(p1 == null || p2 == null){
			return false ;
		}
		
		if(p1.val == p2.val){
			return isSymmetric(p1.left, p2.right) && isSymmetric(p1.right, p2.left) ;
		}

		return false ;
	}
	
	
}
