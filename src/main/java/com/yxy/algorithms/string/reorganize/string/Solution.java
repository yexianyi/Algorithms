package com.yxy.algorithms.string.reorganize.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767. Reorganize String
    Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
    
    If possible, output any possible result.  If not possible, return the empty string.
    
    Example 1:
    
    Input: S = "aab"
    Output: "aba"
    Example 2:
    
    Input: S = "aaab"
    Output: ""
    Note:
    
    S will consist of lowercase letters and have length in range [1, 500].
 * 
 * @author Ye Xianyi
 * 2020/12/11
 *
 * Copy from:
 * https://leetcode.com/problems/reorganize-string/discuss/943268/java-heap-with-very-detail-explainations
 */
public class Solution {

    public static String reorganizeString(String S) {
        // step 1:
        // build a hashmap to store characters and its frequencies:
        Map<Character, Integer> freq_map = new HashMap<>();
        for (char c : S.toCharArray()) {
            freq_map.put(c, freq_map.getOrDefault(c, 0) + 1);
        }
        // step 2:
        // put the char of freq_map into the maxheap with sorting the frequencies by large->small
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a, b) -> freq_map.get(b) - freq_map.get(a));
        // addAll() is adding more then one element to heap
        maxheap.addAll(freq_map.keySet());

        // now maxheap has the most frequent character on the top

        // step 3:
        // obtain the character 2 by 2 from the maxheap to put in the result sb
        // until there is only one element(character) left in the maxheap
        // create a stringbuilder to build the result result
        StringBuilder sb = new StringBuilder();
        while (maxheap.size() > 1) {
            char first = maxheap.poll();
            char second = maxheap.poll();
            sb.append(first);
            sb.append(second);
            freq_map.put(first, freq_map.get(first) - 1);
            freq_map.put(second, freq_map.get(second) - 1);
            // insert the character back to the freq_map if the count in
            // hashmap of these two character are still > 0
            // then the heap will heapify itself..
            // add() comes from Collection.
            // offer() comes from Queue.
            // For a capacity-constrained queue, the difference is that add() always returns true and throws an
            // exception if it can't add the element, whereas offer() is allowed to return false if it can't add the
            // element.
            if (freq_map.get(first) > 0) {
                maxheap.offer(first);
            }
            if (freq_map.get(second) > 0) {
                maxheap.offer(second);
            }
        }

        if (!maxheap.isEmpty()) {
            // when there is only 1 element left in the maxheap
            // check the count, it should not be greater than 1
            // otherwise it would be impossible and should return ""
            if (freq_map.get(maxheap.peek()) > 1) {
                return "";
            } else {
                sb.append(maxheap.poll());
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {

    }

}
