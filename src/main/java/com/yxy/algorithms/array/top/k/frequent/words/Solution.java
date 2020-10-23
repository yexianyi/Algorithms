package com.yxy.algorithms.array.top.k.frequent.words;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 692. Top K Frequent Words
    Medium
    
    Given a non-empty list of words, return the k most frequent elements.
    
    Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
    
    Example 1:
    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    Output: ["i", "love"]
    Explanation: "i" and "love" are the two most frequent words.
        Note that "i" comes before "love" due to a lower alphabetical order.
    Example 2:
    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    Output: ["the", "is", "sunny", "day"]
    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
        with the number of occurrence being 4, 3, 2 and 1 respectively.
    Note:
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Input words contain only lowercase letters.
    Follow up:
    Try to solve it in O(n log k) time and O(n) extra space.
    
 *  @author Ye Xianyi
 *  2020/10/23
 */
public class Solution {
    
    // Time Complexity: O(N \log{N})O(NlogN), where NN is the length of words
    // Space Complexity: O(N)O(N), the space used to store our candidates.
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counter = new HashMap<>() ;
        for(String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1) ;
        }
        
        List<String> sorted = new ArrayList<>(counter.keySet());
        Collections.sort(sorted,
                (word1, word2) -> counter.get(word1).equals(counter.get(word2)) ? word1.compareTo(word2)
                        : counter.get(word2) - counter.get(word1));

        return sorted.subList(0, k);
    }


    public static void main(String[] args) {

    }

}
