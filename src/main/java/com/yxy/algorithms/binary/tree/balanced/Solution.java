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
package com.yxy.algorithms.binary.tree.balanced;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 	110. Balanced Binary Tree My Submissions Question
	Total Accepted: 87485 Total Submissions: 266212 Difficulty: Easy
	Given a binary tree, determine if it is height-balanced.
	
	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author xianyiye
 * 2015/12/22
 */

public class Solution {
	
	public boolean isBalanced(TreeNode root) {
		
		if(root==null){
			return true ;
		}
		
		int depthLeft = getDepth(root.left) ;
		int depthRight = getDepth(root.right) ;
		
		int diff = depthLeft-depthRight ;
		if( diff>1 || diff<-1){
			return false ;
		}
		
		return isBalanced(root.left) && isBalanced(root.right) ;
		
	        
	}
	
	public int getDepth(TreeNode root) {
		if(root==null){
			return 0 ;
		}
		
		int depthLeft = 1 + getDepth(root.left) ;
		int depthRight = 1 + getDepth(root.right) ;
		
		return depthLeft >= depthRight ? depthLeft : depthRight ;
	}


}
