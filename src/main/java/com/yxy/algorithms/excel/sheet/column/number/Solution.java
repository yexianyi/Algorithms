package com.yxy.algorithms.excel.sheet.column.number;

public class Solution {

	public int titleToNumber(String s) {
		if(s==null || s.length()==0){
			return 0 ;
		}
		
		char[] chars = s.toCharArray() ;
		
		int colNum = 0 ;
		for(int i=0; i<chars.length; i++){
			colNum = colNum*26 + (chars[i]-'A'+1) ;
		}
		
		return colNum ;

	}


}
