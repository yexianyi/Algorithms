package com.yxy.algorithms.max.product.word.lengths;

public class Solution {
	
	public static int maxProduct(String[] words) {
		int max = 0 ;
		for(int i=0; i<words.length; i++){
			for(int j=i+1; j<words.length; j++){
				if(!isShareCommLetters(words[i],words[j])){
					int temp = words[i].length() * words[j].length() ;
					if(temp>max){
						max = temp ;
					}
				}
			}
			
		}
        
		return max ;
    }
	
	private static boolean isShareCommLetters(String source, String target){
		int[] map = new int[26] ;
		for(int i=0; i<source.length(); i++){
			map[(source.charAt(i)-'a')]++ ;
		}
		
		for(int i=0; i<target.length(); i++){
			if(map[(target.charAt(i)-'a')]>0){
				return true ;
			}
		}
		
		return false ;
	}

	public static void main(String[] args) {
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"} ;
		System.out.println(maxProduct(words)) ;
		
		String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"} ;
		System.out.println(maxProduct(words2)) ;
		
		String[] words3 = {"a", "aa", "aaa", "aaaa"} ;
		System.out.println(maxProduct(words3)) ;
		
	}

}
