package com.yxy.algorithms.binary.tree.lca;

import java.util.ArrayList;
import java.util.List;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 236. Lowest Common Ancestor of a Binary Tree  QuestionEditorial Solution  My Submissions
	Total Accepted: 48657
	Total Submissions: 168941
	Difficulty: Medium
	Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
	
	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
	
	        _______3______
	       /              \
	    ___5__          ___1__
	   /      \        /      \
	   6      _2       0       8
	         /  \
	         7   4
	For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

 * @author xianyiye
 * @date 07/08/2016
 */
public class Solution2 {
	
	//Not finished yet!
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
		List<List<TreeNode>> ret1 = new ArrayList<List<TreeNode>>() ;
		findPath(root, p, new ArrayList<TreeNode>(), ret1) ;
		
		List<List<TreeNode>> ret2 = new ArrayList<List<TreeNode>>() ;
		findPath(root, q, new ArrayList<TreeNode>(), ret2) ;
		
		if(!ret1.isEmpty() && !ret2.isEmpty()){
			List<TreeNode> maxPath1 = null ; ;
			int maxLen1 = 0 ;
			for(List<TreeNode> list : ret1){
				if(list.size()>maxLen1){
					maxLen1 = list.size() ;
					maxPath1 = list ;
				}
			}
			
			List<TreeNode> maxPath2 = null ; ;
			int maxLen2 = 0 ;
			for(List<TreeNode> list : ret2){
				if(list.size()>maxLen2){
					maxLen2 = list.size() ;
					maxPath2 = list ;
				}
			}
			
			TreeNode ans = null ;
			for(int i=0; i<maxPath1.size() && i<maxPath2.size(); i++){
				if(maxPath1.get(i).val==maxPath2.get(i).val){
					ans = maxPath1.get(i) ;
				}else{
					break ;
				}
			}
			
			return ans ;
		}
		
		
		return null ; 
    }
	

	private static void findPath(TreeNode node, TreeNode target, List<TreeNode> path, List<List<TreeNode>> ret){
		if(node==null){
			return ;
		}
		
		path.add(node) ;
		if(node.val==target.val){
			ret.add(new ArrayList<TreeNode>(path)) ;
			path.remove(path.size()-1) ;
			return ;
		}
		
		findPath(node.left, target, path, ret) ;
		findPath(node.right, target, path, ret) ;
		path.remove(path.size()-1) ;
	}

	public static void main(String[] args) {
//		TreeNode root = BinaryTreeUtil.create(new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, TreeNode.class) ;
		TreeNode root = BinaryTreeUtil.create(new Integer[]{37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8}, TreeNode.class) ;
		BinaryTreeUtil.print(root);
		System.out.println(lowestCommonAncestor(root, new TreeNode(-100), new TreeNode(-71)).val);
	}

}
