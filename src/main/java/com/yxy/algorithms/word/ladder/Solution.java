package com.yxy.algorithms.word.ladder;

import java.util.ArrayList;
import java.util.List;

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
public class Solution {

    // Timeout
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord) == -1) {
            return 0 ;
        }
        
        if(wordList.get(0) != beginWord) {
            wordList.add(0, beginWord) ;
        }
        
        int[][] matrix = new int[wordList.size()][wordList.size()] ;
        
        for(int i=0; i<wordList.size(); i++) {
            for(int j=0; j<wordList.size(); j++) {
                matrix[i][j] = diff(wordList.get(i), wordList.get(j)) ;
//                System.out.print(matrix[i][j] + " ");
            }
            
//            System.out.println() ;
        }
        
        int start = wordList.indexOf(endWord) ;
        int min = Integer.MAX_VALUE ;
        int count = 0 ;
        boolean matched = false ;
        for(int i = start; i > 0; i--) {
           for(int j=0; j<matrix.length; j++) {
               if(matrix[i][j] == 1) {
                   matched = true ;
                   System.out.print(wordList.get(j) + "->") ;
                   i = j+1 ;
                   count ++ ;
                   break ;
               }
           }
        }
        
        
        return matched ? count + 1 : 0;
    }

    private static int diff(String word1, String word2) {
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();

        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dog");
//        list.add("dog");
//        list.add("lot");
//        list.add("log");
//        list.add("cog");
        System.out.println(ladderLength("hot", "dog", list));
    }

}
