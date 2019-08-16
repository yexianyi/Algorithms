package com.yxy.algorithms.tree.populating.next.right.pointers.II;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 117. Populating Next Right Pointers in Each Node II
    Given a binary tree
    
    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.
    
    Example:
    Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
    Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
    Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
    
    Note:
    
    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * @author yexianyi
 * 2019/08/16
 */
public class Solution {
    
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    
    public static Node connect(Node root) {
        if(root == null) {
            return root ;
        }
        
        
        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root) ;
        Node preLevelTailNode = root ; // record the last node in previous level
        Node currLevelTailNode = root ; // record the last node in curr level
        
        List<Node> levelRepo = new LinkedList<>() ; // store nodes of each level
        List<List<Node>> repo = new LinkedList<>() ; // store each level of nodes 
        
        while(!queue.isEmpty()) {
            Node currNode = queue.poll() ;
            levelRepo.add(currNode) ;
           
            if(currNode.left != null) {
                queue.offer(currNode.left) ;
                currLevelTailNode = currNode.left ;
            }
            
            if(currNode.right != null) {
                queue.offer(currNode.right) ;
                currLevelTailNode = currNode.right ;
            }
            
            if(currNode == preLevelTailNode) {
                preLevelTailNode = currLevelTailNode ;
                repo.add(levelRepo) ;
                levelRepo = new LinkedList<>() ;
                System.out.print(currNode.val + "\n") ;
            } else {
                System.out.print(currNode.val) ;
            }
        }
        
        
        connect(repo) ;
        
        return root ;
    }



    private static void connect(List<List<Node>> repo) {
        repo.forEach(list -> {
            for(int i=0; i<list.size()-1 ; i++) {
                list.get(i).next = list.get(i+1) ;
            }
            
        });
    }



    public static void main(String[] args) {
        
        Node node7 = new Node(7, null, null, null) ;
        Node node8 = new Node(8, null, null, null) ;
        
        Node node4 = new Node(4, null, null, null) ;
        Node node5 = new Node(5, node7, node8, null) ;
        Node node6 = new Node(6, null, null, null) ;
        
        Node node2 = new Node(2, node4, null, null) ;
        Node node3 = new Node(3, node5, node6, null) ;
        
        Node node1 = new Node(1, node2, node3, null) ;
        
        connect(node1) ;

    }

}
