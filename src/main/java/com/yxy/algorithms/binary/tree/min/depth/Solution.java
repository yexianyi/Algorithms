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
package com.yxy.algorithms.binary.tree.min.depth;

import com.yxy.algorithms.binary.tree.TreeNode;

public class Solution {
	private static int depth = -1 ;
	
	public static int minDepth(TreeNode root) {
		int leftDepth = 0 ;
    	int rightDepth = 0 ;
    	
    	if(root==null){
    		return 0 ;
    	}
    	
    	if(root.left!=null){
    		leftDepth = 1 + minDepth(root.left) ;
    	}
    	if(root.right!=null){
    		rightDepth = 1 + minDepth(root.right) ;
    	}
		
        if(root.left==null && root.right==null){
        	return 1 ;
        }
        
    	if(leftDepth==0){
    		return rightDepth ;
    	}else if(rightDepth==0){
    		return leftDepth ;
    			
    	}else if(leftDepth<=rightDepth){
    		return leftDepth ;
    	}else{
    		return rightDepth ;
    	}
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5) ;
		root.left = new TreeNode(4)  ;
		root.right = new TreeNode(8) ;
		root.left.left = new TreeNode(11) ;
		root.right.left = new TreeNode(13) ;
		root.right.right = new TreeNode(4) ;
//		root.left.left.left = new TreeNode(7) ;
//		root.left.left.right = new TreeNode(2) ;
		root.right.right.right = new TreeNode(1) ;
		
		System.out.println(minDepth(root));

	}

}
