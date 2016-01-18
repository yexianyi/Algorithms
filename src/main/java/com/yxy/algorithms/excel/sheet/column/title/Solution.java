package com.yxy.algorithms.excel.sheet.column.title;

public class Solution {
	
	public static String convertToTitle(int n) {
		String title = "" ;
		while(n>26){
			title += 'A' ;
			n -= 26 ;
		}
		
		title += (char) ('A'+ n -1) ;
		
		return title;
        
    }

	public static void main(String[] args) {
		System.out.println(convertToTitle(26)) ;
		System.out.println(convertToTitle(27)) ;
		System.out.println(convertToTitle(28)) ;
	}

}
