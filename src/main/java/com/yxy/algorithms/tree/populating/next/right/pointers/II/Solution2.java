package com.yxy.algorithms.tree.populating.next.right.pointers.II;

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
 * 
 * Copy from:
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/359074/simple-solution-with-a-dummy-node-beat-100
 */

public class Solution2 {
    
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
        Node cur = root;
        // this check is for the level head
        while (cur != null) {
            // connect the next level using a dummy
            Node sen = new Node();
            Node p = sen;
            // this check is for cur.next
            while (cur != null) {
                if (cur.left != null) {
                    p.next = cur.left;
                    p = p.next;
                }
                if (cur.right != null) {
                    p.next = cur.right;
                    p = p.next;
                }
                cur = cur.next;
            }
            cur = sen.next;
        }
        return root;
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
