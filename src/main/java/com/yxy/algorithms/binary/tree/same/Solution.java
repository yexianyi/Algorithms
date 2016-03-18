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
package com.yxy.algorithms.binary.tree.same;

import com.yxy.algorithms.binary.tree.TreeNode;

/**
 * 	Same Tree My Submissions Question
	Total Accepted: 98481 Total Submissions: 233050 Difficulty: Easy
	Given two binary trees, write a function to check if they are equal or not.
	
	Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	
	Subscribe to see which companies asked this question
 * 
 * @author xianyiye
 *	2015/12/18
 */

public class Solution {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if((p==null ^ q==null) == true){
			return false ;
		}else if((p==null & q==null) == true){
		    return true ;
		}
		
		if(p.val == q.val){
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) ;
		}
		else{
			return false ;
		}
        
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
