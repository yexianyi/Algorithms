package com.yxy.algorithms.tree.level.order.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal
 * 
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by
 * level).
 * 
 * For example, given a 3-ary tree:
 * 
 * We should return its level order traversal:
 * 
 * [    [1], 
 *      [3,2,4], 
 *      [5,6] 
 * ]
 * 
 * 
 * Note:
 * 
 * The depth of the tree is at most 1000. The total number of nodes is at most 5000.
 * 
 * @author yexianyi
 * 2019/03/18
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

};

class Solution {

    public static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> all = new ArrayList<>();
        if (root == null) {
            return all;
        }

        queue.add(root);
        int count = 1;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int nextCount = 0;
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                list.add(node.val);

                if (node.children != null && node.children.size() > 0) {
                    nextCount += node.children.size();
                    queue.addAll(node.children);
                }
            }
            all.add(list);
            count = nextCount;
        }

        return all;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.children = Arrays.asList(node2, node3);
        node2.children = Arrays.asList(node4, node5, node6);
        node3.children = Arrays.asList(node7, node8);

        List<List<Integer>> all = levelOrder(node1);
        for (List<Integer> list : all) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
