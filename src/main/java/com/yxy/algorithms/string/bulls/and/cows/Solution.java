package com.yxy.algorithms.string.bulls.and.cows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	public static String getHint(String secret, String guess) {
        Set<Character> set = new HashSet<Character>() ;
        Set<Character> recycleBin = new HashSet<Character>() ;
        int bull = 0 ;
        int cows = 0 ;
        
        for(int i=0; i<secret.length(); i++){
        	set.add(secret.charAt(i)) ;
        }
        
        for(int i=0; i<guess.length(); i++){
        	char gChar = guess.charAt(i) ;
        	char sChar = secret.charAt(i) ;
        	if(gChar==sChar){
        		bull++ ;
        		recycleBin.add(gChar) ;
        	}else{
        		if(set.contains(gChar) && !recycleBin.contains(gChar)){
            		cows++ ;
            	}
        	}
        }
        
		return bull+"A"+cows+"B";
        
    }
	
	public static String getHint2(String secret, String guess) {
		
        Map<Character, Set<Integer>> map = new HashMap<Character, Set<Integer>>() ;
        int bull = 0 ;
        int cows = 0 ;
        
        for(int i=0; i<secret.length(); i++){
        	char sChar = secret.charAt(i) ;
        	
        	if(map.containsKey(sChar)){
        		Set<Integer> set = map.get(sChar) ;
        		set.add(i) ;
        	}else{
        		Set<Integer> set = new HashSet<Integer>() ;
        		set.add(i) ;
        		map.put(secret.charAt(i), set) ;
        	}
        }
        
        for(int i=0; i<guess.length(); i++){
        	char gChar = guess.charAt(i) ;
        	char sChar = secret.charAt(i) ;
        	if(gChar==sChar){
        		bull++ ;
        	}
        	
        	if(map.containsKey(gChar)){
        		if(map.get(gChar).contains(i)){
        			bull++ ;
        		}else{
        			cows++ ;
        		}
        	}
        	
        }
        
		return bull+"A"+cows+"B";
        
    }

	public static void main(String[] args) {
		System.out.println(getHint("1807","7810")) ;
		System.out.println(getHint("1123","0111")) ;
		System.out.println(getHint("1122","2211")) ;
		System.out.println(getHint("1234","0111")) ;
	}

}
