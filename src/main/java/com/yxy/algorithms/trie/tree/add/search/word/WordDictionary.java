package com.yxy.algorithms.trie.tree.add.search.word;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Add and Search Word - Data structure design
Medium
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 * @author Ye Xianyi
 * 2020/07/01
 * 
 * Reference:
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/discuss/681589/Java-Solution-Using-Trie-and-DFS
 */
class WordDictionary {
    
    TrieNode root = new TrieNode('?', new HashMap<Character, TrieNode>(), false);

    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        if (root == null) {
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = cur.children.get(word.charAt(i));
            if (child == null) {
                TrieNode node = new TrieNode(word.charAt(i), new HashMap<Character, TrieNode>(), false);
                cur.children.put(word.charAt(i), node);
                cur = cur.children.get(word.charAt(i));
            } else {
                cur = child;
            }
        }
        
        cur.isWord = true ;
    }
    

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
     * letter.
     */
    public boolean search(String word) {
        return search(root, word, 0) ;
    }
    
    
    private boolean search(TrieNode node, String word, int pos) {
        if(pos == word.length()) {
            return node.isWord ;
        } 
        
        char target = word.charAt(pos) ;
        if(target == '.') {
            for(char ch : node.children.keySet()) {
                if(search(node.children.get(ch), word, pos + 1)) {
                    return true ;
                }
            }
            
            return false ;
        }
        
        TrieNode next = node.children.get(target) ;
        if(next == null) {
            return false ;
        } else {
            
            return search(next, word, pos+1) ;
        }
        
    }
    


    class TrieNode{
        Character ch ;
        Map<Character, TrieNode> children ;
        boolean isWord ;
        
        public TrieNode(Character ch, Map<Character, TrieNode> children, boolean isWord) {
            this.ch = ch ;
            this.children = children ;
            this.isWord = isWord ;
        }
    }
    

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
//        obj.addWord("bad");
//        obj.addWord("dad");
//        obj.addWord("mad");
//        System.out.println(obj.search("pad")) ; // false 
//        System.out.println(obj.search("bad"));// true
//        System.out.println(obj.search(".ad")) ;// true
//        System.out.println(obj.search("b..")) ;// true
//        System.out.println(obj.search("a")) ; // false 
        obj.addWord("a");
        System.out.println(obj.search("a.")) ; // false 
    }

}
