package com.yxy.algorithms.array.word.ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127. Word Ladder
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
    
    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
    Note:
    
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.
    Example 1:
    
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]
    
    Output: 5
    
    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.
    Example 2:
    
    Input:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]
    
    Output: 0
    
    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * @author yexianyi
 * 2019/08/16
 */
import javafx.util.Pair;

class Solution2 {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		// Since all words are of same length.
		int L = beginWord.length();

		// Dictionary to hold combination of words that can be formed,
		// from any given word. By changing one letter at a time.
		HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

		wordList.forEach(word -> {
			for (int i = 0; i < L; i++) {
				// Key is the generic word
				// Value is a list of words which have the same intermediate generic word.
				String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
				ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
				transformations.add(word);
				allComboDict.put(newWord, transformations);
			}
		});

		// Queue for BFS
		Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
		Q.add(new Pair(beginWord, 1));

		// Visited to make sure we don't repeat processing same word.
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		visited.put(beginWord, true);

		while (!Q.isEmpty()) {
			Pair<String, Integer> node = Q.remove();
			String word = node.getKey();
			int level = node.getValue();
			for (int i = 0; i < L; i++) {

				// Intermediate words for current word
				String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

				// Next states are all the words which share the same intermediate state.
				for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
					// If at any point if we find what we are looking for
					// i.e. the end word - we can return with the answer.
					if (adjacentWord.equals(endWord)) {
						return level + 1;
					}
					// Otherwise, add it to the BFS Queue. Also mark it visited
					if (!visited.containsKey(adjacentWord)) {
						visited.put(adjacentWord, true);
						Q.add(new Pair(adjacentWord, level + 1));
					}
				}
			}
		}

		return 0;
	}
	
	 public static void main(String[] args) {
	        List<String> list = new ArrayList<>();
	        list.add("hot");
	        list.add("dog");
	        list.add("dog");
	        list.add("lot");
	        list.add("log");
	        list.add("cog");
	        System.out.println(ladderLength("hot", "dog", list));
	    }
}