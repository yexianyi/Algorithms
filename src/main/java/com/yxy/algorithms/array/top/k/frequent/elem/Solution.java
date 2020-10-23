package com.yxy.algorithms.array.top.k.frequent.elem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 347. Top K Frequent Elements
    Medium
    Given a non-empty array of integers, return the k most frequent elements.
    
    Example 1:
    
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    Example 2:
    
    Input: nums = [1], k = 1
    Output: [1]
    Note:
    
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
    You can return the answer in any order.

 * @author Ye Xianyi
 * @date 2020/10/14
 * 
 * Reference:
 * https://leetcode.com/problems/top-k-frequent-elements/solution/
 */
public class Solution {

    public static int[] topKFrequent(int[] nums, int k) {
        // O(1) 
        if (k == nums.length) {
            return nums;
        }
        
        Map<Integer, Integer> frequency = new HashMap<>() ;
        
        // O(N)
        for(int num : nums) {
            frequency.putIfAbsent(num, 0) ;
            frequency.put(num, frequency.get(num) + 1) ;
        }
        
        Queue<Integer> heap = new PriorityQueue<>((n1 , n2) -> frequency.get(n1) - frequency.get(n2)) ;
        // O(N) in average, O(klogk) in worst
        frequency.keySet().forEach(num -> {
            heap.add(num) ;
            if(heap.size() > k) {
                heap.poll() ;
            }
        });
        
        int[] ans = new int[k] ;
        // O(klogk)
        for(int i=0; i<k; i++) {
            ans[i] = heap.poll() ;
        }
        
        return ans ;
    }

    public static void main(String[] args) {
        
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1) ;
        heap.add(1);
        heap.add(3);
        heap.add(2);
        heap.add(4);
        
        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

    }

}
