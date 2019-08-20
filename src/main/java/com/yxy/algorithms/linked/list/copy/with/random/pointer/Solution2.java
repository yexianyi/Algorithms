package com.yxy.algorithms.linked.list.copy.with.random.pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 138. Copy List with Random Pointer A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * Example 1:
 * 
 * Input: {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * Explanation: Node 1's value is 1, both of its next and random pointer points to Node 2. Node 2's value is 2, its next
 * pointer points to null and its random pointer points to itself.
 * 
 * Note:
 * 
 * You must return the copy of the given head as a reference to the cloned list.
 * 
 * @author yexianyi 
 * 2019/08/20
 * 
 * Copy from:
 * https://leetcode.com/problems/copy-list-with-random-pointer/discuss/360795/Short-and-simple-java-solution-using-recursion-and-a-hash-table
 */
public class Solution2 {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    static HashMap<Node, Node> map = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (map.get(head) != null) {
            return map.get(head);
        } else {
            Node newHead = new Node(head.val, null, null);
            map.put(head, newHead);

            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
            return newHead;
        }
    }

    public static void main(String[] args) {
        Node node4 = new Node(4, null, null);
        Node node3 = new Node(3, node4, null);
        Node node2 = new Node(2, node3, null);
        Node node1 = new Node(1, node2, null);

        node1.random = node3;
        node2.random = node2;
        node3.random = null;
        node4.random = node2;

        Node head = copyRandomList(node1);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

    }

}
