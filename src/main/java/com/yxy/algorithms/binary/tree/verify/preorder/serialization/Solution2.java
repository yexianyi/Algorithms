package com.yxy.algorithms.binary.tree.verify.preorder.serialization;

/**
 *  331. Verify Preorder Serialization of a Binary Tree My Submissions QuestionEditorial Solution
	Total Accepted: 12594 Total Submissions: 39624 Difficulty: Medium
	One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
	
	     _9_
	    /   \
	   3     2
	  / \   / \
	 4   1  #  6
	/ \ / \   / \
	# # # #   # #
	For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
	
	Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
	
	Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
	
	You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
	
	Example 1:
	"9,3,4,#,#,1,#,#,2,#,6,#,#"
	Return true
	
	Example 2:
	"1,#"
	Return false
	
	Example 3:
	"9,#,#,1"
	Return false

 * @author xianyiye
 * @date 05/24/2016
 * Copy from:
 * https://leetcode.com/discuss/92919/java-counting-indegree-and-outdegree-simple-%26-clear
 */
public class Solution2 {
	public static boolean isValidSerialization(String preorder) {
		int degree = -1 ; // Root node does not have In Degree
		String[] seq = preorder.split(",") ;
		for(int i=0; i<seq.length ;i++){
			degree++ ; // all nodes have 1 indegree 
			if(degree>0){ // total degree should never exceeds 0
				return false ;
			}
			if(!seq[i].equals("#")){ 
				degree -=2 ;// only non-leaf node has 2 outdegree
			}
		}
		
		return degree == 0 ;
    }
	

	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")) ;
		System.out.println(isValidSerialization("1,#")) ;
		System.out.println(isValidSerialization("9,#,#,1")) ;
	}

}
