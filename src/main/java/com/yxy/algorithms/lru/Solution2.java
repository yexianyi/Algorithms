package com.yxy.algorithms.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * Medium

 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * The cache is initialized with a positive capacity.

 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * 
 * @author Ye Xianyi
 * 2020/01/09
 * 
 * Copy from:
 * https://www.jianshu.com/p/ba3969f143b8
 */
public class Solution2 {
	
	// Double Linked List Node
	class ListNode {
	    int key;
	    int value;
	    ListNode prev;
	    ListNode next;
	    
	    public ListNode(int key, int value) {
	        this.key = key;
	        this.value = value;
	    }
	}

	class LRUCache {
	    int capacity;
	    Map<Integer, ListNode> map;
	    ListNode head = new ListNode(0, 0);
	    ListNode tail = new ListNode(0, 0);
	    
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        map = new HashMap<>();
	        head.next = tail;
	        tail.prev = head;
	    }
	    
	    public int get(int key) {
	        if (!map.containsKey(key)) {
	            return -1;
	        } 

	        ListNode node = map.get(key);
	        moveToTail(node);

	        return node.value;
	    }
	    
	    public void put(int key, int value) {
	        if (map.containsKey(key)) {
	            ListNode node = map.get(key);
	            node.value = value;
	            moveToTail(node);
	        } else {
	            if (map.size() == capacity) {
	                ListNode first = head.next;
	                head.next = first.next;
	                first.next.prev = head;
	                map.remove(first.key);
	            }
	            
	            ListNode newNode = new ListNode(key, value);
	            newNode.prev = tail.prev;
	            tail.prev.next = newNode;
	            newNode.next = tail;
	            tail.prev = newNode;
	            
	            map.put(key, newNode);
	        }
	    }
	    
	    private void moveToTail(ListNode node) {
	        node.prev.next = node.next;
	        node.next.prev = node.prev;

	        // move node to tail of list
	        node.prev = tail.prev;
	        tail.prev.next = node;
	        node.next = tail;
	        tail.prev = node;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
