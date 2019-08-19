package com.yxy.algorithms.graph.deep.clone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. Clone Graph
    Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. 
    Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
    
    Example:
    Input:
    {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},
    {"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
    
    Explanation:
    Node 1's value is 1, and it has two neighbors: Node 2 and 4.
    Node 2's value is 2, and it has two neighbors: Node 1 and 3.
    Node 3's value is 3, and it has two neighbors: Node 2 and 4.
    Node 4's value is 4, and it has two neighbors: Node 1 and 3.
    
    Note:
    The number of nodes will be between 1 and 100.
    The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
    Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
    You must return the copy of the given node as a reference to the cloned graph.

 * @author yexianyi
 * 2019/08/19
 * 
 * Copy from:
 * https://leetcode.com/problems/clone-graph/discuss/360751/Java-Solution-beats-100-runtime-and-98-memory
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

public class Solution {

    public static Node cloneGraph(Node node) {
        Map<Node, Node> clones = new HashMap<>();
        cloneAllNodes(node, clones);
        return clones.get(node);
    }

    public static void cloneAllNodes(Node node, Map<Node, Node> clones) {
        if (clones.containsKey(node))
            return;
        
        Node clone = new Node(node.val, new ArrayList<>());
        clones.put(node, clone);
        for (Node neighbor : node.neighbors) {
            cloneAllNodes(neighbor, clones);
            Node clonedNeighbor = clones.get(neighbor);
            clone.neighbors.add(clonedNeighbor);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        Node clone = cloneGraph(node1);

        System.out.println(clone.val);

    }

}
