package com.yxy.algorithms.tree.implement.trie;

/**
 * 208. Implement Trie (Prefix Tree)

	Share
	Implement a trie with insert, search, and startsWith methods.
	
	Example:
	
	Trie trie = new Trie();
	
	trie.insert("apple");
	trie.search("apple");   // returns true
	trie.search("app");     // returns false
	trie.startsWith("app"); // returns true
	trie.insert("app");   
	trie.search("app");     // returns true
	Note:
	
	You may assume that all inputs are consist of lowercase letters a-z.
	All inputs are guaranteed to be non-empty strings.
 * @author Ye Xianyi
 * 2020/01/22
 * 
 * Copy from:
 * https://leetcode.com/problems/implement-trie-prefix-tree/discuss/485723/java-solution
 */
public class Trie {

	Node root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node p = root;
		for (Character c : word.toCharArray()) {
			int u = c - 'a';
			if (p.son[u] == null)
				p.son[u] = new Node();
			p = p.son[u];
		}
		p.is_end = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node p = root;
		for (Character c : word.toCharArray()) {
			int u = c - 'a';
			if (p.son[u] == null)
				return false;
			p = p.son[u];
		}
		return p.is_end;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Node p = root;
		for (Character c : prefix.toCharArray()) {
			int u = c - 'a';
			if (p.son[u] == null)
				return false;
			p = p.son[u];
		}
		return true;
	}

	class Node {
		boolean is_end;
		Node[] son = new Node[26];

		Node() {
			is_end = false;
			for (int i = 0; i < 26; i++)
				son[i] = null;
		}
	}

	public static void main(String[] args) {

	}

}
