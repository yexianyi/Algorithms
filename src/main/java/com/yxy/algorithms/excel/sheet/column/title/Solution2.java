package com.yxy.algorithms.excel.sheet.column.title;

public class Solution2 {
	
	public static String convertToTitle(int n) {
		String title = "" ;
		for(int i=0; i<n/26; i++){
			title += 'A' ;
		}
		
		title += (char) ('A'+ n%26 -1) ;
		
		return title;
        
    }

	public static void main(String[] args) {
		System.out.println(convertToTitle(26)) ;
		System.out.println(convertToTitle(27)) ;
		System.out.println(convertToTitle(28)) ;
	}

}
