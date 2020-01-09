package com.yxy.algorithms.lru;

import java.util.LinkedHashMap;

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

public class Solution {
	
	class LRUCache {
	    int capacity;
	    LinkedHashMap<Integer, Integer> map;
	    
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.map = new LinkedHashMap<>();
	    }
	    
	    /**
	     *  get function:
				if key not in map, return -1
				if key in map, remove key and add key, return value
	     */
	    public int get(int key) {
	        if (!map.containsKey(key)) {
	            return -1;
	        }
	        
	        int value = map.remove(key);
	        map.put(key, value);
	        return value;
	    }
	    
	    
	    /**
			put function:
			if key in map, remove key and add (key, value)
			if key not in map && map.size == capacity, remove first key and add (key, value)
		 */
	    public void put(int key, int value) {
	        if (map.containsKey(key)) {
	            map.remove(key);
	        } else if (map.size() == capacity) {
	            map.remove(map.entrySet().iterator().next().getKey());
	        }
	        map.put(key, value);
	    }  
	}


}
